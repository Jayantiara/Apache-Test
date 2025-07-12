package com.mycompany.securegroupchat;

import java.util.Scanner;

public class SecureGroupChat {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("=== Secure Group Chat ===");
        System.out.println("1. Jalankan Server");
        System.out.println("2. Jalankan Client");
        System.out.print("Pilihan: ");
        int pilihan = input.nextInt();

        if (pilihan == 1) {
            Server.main(null);
        } else if (pilihan == 2) {
            Client.main(null);
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }
}