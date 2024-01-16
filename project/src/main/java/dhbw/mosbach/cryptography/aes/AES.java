package dhbw.mosbach.cryptography.aes;


import dhbw.mosbach.cryptography.IAlgorithm;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AES implements IAlgorithm {
    private final String salt;
    private final byte[] iv = {0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1};

    public AES(String salt) {
        this.salt = salt;
    }

    public String encrypt(String plainMessage, String secretKey) {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            SecretKeySpec secretKeySpecification = new SecretKeySpec(factory.generateSecret(new PBEKeySpec(secretKey.toCharArray(),
                    salt.getBytes(), 65536, 256)).getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpecification, new IvParameterSpec(this.iv));

            return Base64.getEncoder().encodeToString(cipher.doFinal(plainMessage.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public String decrypt(String cipher, String secretKey) {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            SecretKeySpec secretKeySpecification = new SecretKeySpec(factory.generateSecret(new PBEKeySpec(secretKey.toCharArray(),
                    salt.getBytes(), 65536, 256)).getEncoded(), "AES");

            Cipher cipherInstance = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipherInstance.init(Cipher.DECRYPT_MODE, secretKeySpecification, new IvParameterSpec(iv));

            return new String(cipherInstance.doFinal(Base64.getDecoder().decode(cipher)));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}