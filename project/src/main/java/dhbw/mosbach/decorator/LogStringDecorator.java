package dhbw.mosbach.decorator;

import dhbw.mosbach.ServiceCenter;
import dhbw.mosbach.cryptography.HashConfig;
import dhbw.mosbach.cryptography.IAlgorithm;
import dhbw.mosbach.cryptography.IHash;
import dhbw.mosbach.cryptography.aes.AES;
import dhbw.mosbach.cryptography.aes.Configuration;
import dhbw.mosbach.cryptography.sha.SHA;

public class LogStringDecorator extends StringDecorator {
    private IHash hashing;

    private IAlgorithm crypt;

    private ServiceCenter serviceCenter;

    public LogStringDecorator(ServiceCenter serviceCenter) {
        this.hashing = new SHA();
        this.crypt = new AES(Configuration.INSTANCE.salt);
        this.serviceCenter = serviceCenter;
    }

    @Override
    public String log(String message) {
        return System.currentTimeMillis() + " | " + message;
    }

    @Override
    public String hash(String message) {
        return message + " | " + hashing.hash(message, HashConfig.INSTANCE.getKey());
    }

    @Override
    public String record(String message) {

        Recorder.INSTANCE.store(message);

        return message;
    }

    @Override
    public String encrypt(String message) {
        return crypt.encrypt(message, Configuration.INSTANCE.secretKey);
    }

    @Override
    public String send(String message) {
        serviceCenter.receive(message);
        return message;
    }
}
