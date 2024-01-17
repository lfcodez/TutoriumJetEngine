import dhbw.mosbach.cryptography.Context;
import dhbw.mosbach.cryptography.IAlgorithm;
import dhbw.mosbach.cryptography.aes.AES;
import dhbw.mosbach.cryptography.des.DES;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStrategy {

    private String key = "asdf";
    private String salt = "asdf";
    private String s = "test";
    IAlgorithm algorithm;



    @Test
    public void testStrategyAes(){
        Context c = new Context(new AES(salt));
        algorithm = new AES(salt);
        assertEquals(algorithm.encrypt(s, key), c.encrypt(s, key));
        assertEquals(algorithm.decrypt(algorithm.encrypt(s, key),key), c.decrypt(c.encrypt(s,key),key));

    }
    @Test
    public void testStrategyDes(){
        Context c = new Context(new DES());
        algorithm = new DES();
        assertEquals(algorithm.encrypt(s, key), c.encrypt(s, key));
        assertEquals(algorithm.decrypt(algorithm.encrypt(s, key),key), c.decrypt(c.encrypt(s,key),key));

    }


}
