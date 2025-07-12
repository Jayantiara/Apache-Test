package com.mycompany.securegroupchat;

import java.io.*;
import java.net.*;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(HOST, PORT);
        new Thread(() -> listenServer(socket)).start();

        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            String line;
            while ((line = console.readLine()) != null) {
                out.println(line);
            }
        }
    }

    private static void listenServer(Socket socket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String msg;
            while ((msg = in.readLine()) != null) {
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}