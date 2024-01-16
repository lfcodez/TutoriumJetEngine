package dhbw.mosbach.cryptography;

public class Context {
    private final IAlgorithm strategy;

    public Context(IAlgorithm strategy) {
        this.strategy = strategy;
    }

    public String encrypt(String s, String key) {
        return strategy.encrypt(s, key);
    }
    public String decrypt(String s, String key) {
        return strategy.decrypt(s, key);
    }
}