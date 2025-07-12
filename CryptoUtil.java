package com.mycompany.securegroupchat;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.nio.file.*;
import java.security.*;

public class CryptoUtil {
    private static final String ALGO = "AES";
    private static final byte[] keyValue = "1234567812345678".getBytes();

    public static void encryptFile(String inPath, String outPath) throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGO);
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] data = Files.readAllBytes(Paths.get(inPath));
        byte[] enc = c.doFinal(data);
        Files.write(Paths.get(outPath), enc);
    }

    public static void decryptFile(String inPath, String outPath) throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGO);
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] data = Files.readAllBytes(Paths.get(inPath));
        byte[] dec = c.doFinal(data);
        Files.write(Paths.get(outPath), dec);
    }
}