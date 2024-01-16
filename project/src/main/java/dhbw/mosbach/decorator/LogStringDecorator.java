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
    public String log(String s) {
        return System.currentTimeMillis() + " | " + s;
    }

    @Override
    public String hash(String s) {
        return s + " | " + hashing.hash(s, HashConfig.INSTANCE.getKey());
    }

    @Override
    public String record(String s) {

        Recorder.INSTANCE.store(s);

        return s;
    }

    @Override
    public String encrypt(String s) {
        return crypt.encrypt(s, Configuration.INSTANCE.secretKey);
    }

    @Override
    public String send(String s) {
        serviceCenter.receive(s);
        return s;
    }
}
