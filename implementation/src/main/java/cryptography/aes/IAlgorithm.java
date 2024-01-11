package cryptography.aes;

public interface IAlgorithm {
    String encrypt(String plainMessage, String secretKey);

    String decrypt(String cipher, String secretKey);
}