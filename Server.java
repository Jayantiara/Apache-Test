package com.mycompany.securegroupchat;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Server {
    private static final int PORT = 12345;
    private static final String LOG = "chat.log";
    private static final String LOG_ENC = "chat.log.enc";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);
        List<Socket> clients = new ArrayList<>();
        System.out.println("Server listening on port " + PORT);

        if (Files.exists(Paths.get(LOG_ENC))) {
            CryptoUtil.decryptFile(LOG_ENC, LOG);
        }

        while (true) {
            Socket client = server.accept();
            clients.add(client);
            new Thread(() -> handleClient(client, clients)).start();
        }
    }

    private static void handleClient(Socket client, List<Socket> clients) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
            String msg;
            while ((msg = in.readLine()) != null) {
                String full = "Client[" + client.getPort() + "]: " + msg;
                Files.write(Paths.get(LOG), (full + "\n").getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                for (Socket s : clients) {
                    if (s != client) {
                        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                        out.println(full);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            clients.remove(client);
            try { client.close(); } catch (IOException ignored) {}
            try {
                CryptoUtil.encryptFile(LOG, LOG_ENC);
                Files.deleteIfExists(Paths.get(LOG));
            } catch (Exception e) { e.printStackTrace(); }
        }
    }
}