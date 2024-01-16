package dhbw.mosbach.cryptography;

public interface IAlgorithm {
    String encrypt(String plainMessage, String secretKey);

    String decrypt(String cipher, String secretKey);
}