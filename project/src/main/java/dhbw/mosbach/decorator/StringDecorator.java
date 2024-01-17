package dhbw.mosbach.decorator;

public abstract class StringDecorator {

    public abstract String log(String message);
    public abstract String hash(String message);
    public abstract String record(String message);
    public abstract String encrypt(String message);
    public abstract String send(String message);

}
