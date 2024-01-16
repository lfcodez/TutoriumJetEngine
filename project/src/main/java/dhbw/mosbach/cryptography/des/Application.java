package dhbw.mosbach.cryptography.des;


public class Application {
    public static void main(String... args) {
        String plainMessage = "this is a secret message";
        String cipher;
        String decryptedMessage;

        DES des = new DES();
        cipher = des.encrypt(plainMessage, Configuration.INSTANCE.secretKey);
        decryptedMessage = des.decrypt(cipher, Configuration.INSTANCE.secretKey);
        System.out.println("DES : " + cipher + " : " + decryptedMessage);
    }
}