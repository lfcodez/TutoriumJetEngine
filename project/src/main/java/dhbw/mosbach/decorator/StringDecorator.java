package dhbw.mosbach.decorator;

public abstract class StringDecorator {

    public abstract String log(String s);
    public abstract String hash(String s);
    public abstract String record(String s);
    public abstract String encrypt(String s);
    public abstract String send(String s);

}
