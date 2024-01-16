package dhbw.mosbach.cryptography.aes;

public class Application {
    public static void main(String... args) {
        String plainMessage = "this is a secret message";
        String cipher;
        String decryptedMessage;

        AES aes = new AES(Configuration.INSTANCE.salt);
        cipher = aes.encrypt(plainMessage, Configuration.INSTANCE.secretKey);
        decryptedMessage = aes.decrypt(cipher, Configuration.INSTANCE.secretKey);
        System.out.println("AES : " + cipher + " : " + decryptedMessage);
    }
}