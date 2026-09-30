package utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptAndDecrypt {

    private static final String SECRET_KEY = "1234567890123456";

    public static String encrypt(String text) throws Exception {
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(text.getBytes());
        String encryptedData = new String(Base64.getEncoder().encode(encrypted));
        System.out.println(encryptedData);
        return encryptedData;
    }

    public static String decrypt(String encryptedText) throws Exception {
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        String decryptedData = new String(decrypted);
        System.out.println(decryptedData);
        return decryptedData;
    }

    public static void main(String[] args) throws Exception {
        encrypt("");
    }
}
