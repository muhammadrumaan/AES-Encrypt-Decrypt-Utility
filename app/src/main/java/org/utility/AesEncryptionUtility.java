package org.utility;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AesEncryptionUtility {
    private static final String ALGORITHM = "AES/ECB/PKCS5Padding";
    private static final String SECRET_KEY = "uC01Y8YxFjxLnbkWj3PpkQ==";

    public static String encrypt(String plainText) {
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException |
                 BadPaddingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String decrypt(String encryptedText) {
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
            return new String(decryptedBytes);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException |
                 BadPaddingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Usage: java -jar aes-encryption.jar <encrypt/decrypt> <text>");
            System.exit(1);
        }

        String action = args[0];
        String inputText = args[1];

        if (action.equals("encrypt")) {
            String encryptedText = AesEncryptionUtility.encrypt(inputText);
            System.out.println("Encrypted Text: " + encryptedText);
        } else if (action.equals("decrypt")) {
            String decryptedText = AesEncryptionUtility.decrypt(inputText);
            System.out.println("Decrypted Text: " + decryptedText);
        } else {
            System.out.println("Invalid action: " + action);
            System.exit(1);
        }
    }
}
