import dhbw.mosbach.ServiceCenter;
import dhbw.mosbach.cryptography.HashConfig;
import dhbw.mosbach.cryptography.aes.AES;
import dhbw.mosbach.cryptography.aes.Configuration;
import dhbw.mosbach.cryptography.sha.SHA;
import dhbw.mosbach.decorator.LogStringDecorator;
import dhbw.mosbach.decorator.Recorder;
import dhbw.mosbach.decorator.StringDecorator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestDecorator {


    String s;
    StringDecorator decorator;

    public TestDecorator() {
        decorator = new LogStringDecorator(new TestUtils().getServiceCenter());
        s = "test";
    }

    @Test
    public void testHash() {
        assertEquals(s + " | " + new SHA().hash(s, HashConfig.INSTANCE.getKey()), decorator.hash(s));
    }

    @Test
    public void testRecord() {
        decorator.record(s);
        assertEquals(s, Recorder.INSTANCE.getStack().peek());
    }

    @Test
    public void testEncrypt() {
        assertEquals(new AES(Configuration.INSTANCE.salt).encrypt(s, Configuration.INSTANCE.secretKey), decorator.encrypt(s));
    }

    @Test
    public void testSend() {
        ServiceCenter sMock = mock(ServiceCenter.class);
        StringDecorator mockedDecorator = new LogStringDecorator(sMock);
        mockedDecorator.send(s);
        verify(sMock).receive(s);
    }


}
