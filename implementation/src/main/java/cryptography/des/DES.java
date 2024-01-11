package cryptography.des;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class DES implements IAlgorithm {
    private final KeySchedule keySchedule = new KeySchedule();
    private final InitialPermutation initialPermutation = new InitialPermutation();
    private final FeistelNetwork feistelNetwork = new FeistelNetwork();
    private final IPInverse ipInverse = new IPInverse();

    public String decrypt(String cipher, String secretKey) {
        StringBuilder stringBuilder = new StringBuilder();
        int maximum = cipher.length() % 64 > 0 ? (cipher.length() / 64) + 1 : cipher.length() / 64;

        for (int i = 0; i < maximum; i++) {
            int index = i * 64;
            String toProcess = cipher.substring(index, index + (Math.min(cipher.length() - index, 64)));
            stringBuilder.append(bitToString(ipInverse.permute(feistelNetwork.iterate(initialPermutation.permute(pushTo64Bit(toProcess)),
                    keySchedule.schedule(pushTo64Bit(stringToBit(secretKey)), false)))));
        }

        return stringBuilder.toString();
    }

    public String encrypt(String plainMessage, String secretKey) {
        StringBuilder stringBuilder = new StringBuilder();
        int maximum = plainMessage.length() % 8 > 0 ? (plainMessage.length() / 8) + 1 : plainMessage.length() / 8;

        for (int i = 0; i < maximum; i++) {
            int index = i * 8;
            String temp = plainMessage.substring(index, index + (Math.min(plainMessage.length() - index, 8)));
            stringBuilder.append(ipInverse.permute(feistelNetwork.iterate(initialPermutation.permute(pushTo64Bit(stringToBit(temp))),
                    keySchedule.schedule(pushTo64Bit(stringToBit(secretKey)), true))));
        }

        return stringBuilder.toString();
    }

    private String pushToNextByte(String input) {
        int nextByte = (int) (Math.pow(2, (int) (Math.log(input.length()) / Math.log(2)) + 1));
        StringBuilder stringBuilder = new StringBuilder(input);

        while (stringBuilder.length() < nextByte) {
            stringBuilder.insert(0, "0");
        }

        input = stringBuilder.toString();
        return input;
    }

    private String pushTo64Bit(String input) {
        StringBuilder stringBuilder = new StringBuilder(input);

        while (stringBuilder.length() < 64) {
            stringBuilder.insert(0, "0");
        }

        input = stringBuilder.toString();
        return input;
    }

    private String stringToBit(String input) {
        return pushToNextByte(new BigInteger(input.getBytes(StandardCharsets.UTF_8)).toString(2));
    }

    private String bitToString(String input) {
        return new String(new BigInteger(input, 2).toByteArray());
    }
}