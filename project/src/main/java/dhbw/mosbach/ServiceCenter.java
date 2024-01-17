package dhbw.mosbach;

import dhbw.mosbach.builder.JetEngine;
import dhbw.mosbach.cryptography.Context;
import dhbw.mosbach.cryptography.aes.AES;
import dhbw.mosbach.cryptography.aes.Configuration;
import dhbw.mosbach.serviceteam.STTrent1000;
import dhbw.mosbach.serviceteam.STTrent900;
import dhbw.mosbach.serviceteam.STTrentXWB;
import dhbw.mosbach.serviceteam.ServiceTeam;

public class ServiceCenter {
    private ServiceTeam serviceTeam;

    private JetEngine jetEngine;

    private Context context;
    public ServiceCenter(JetEngine jetEngine) {

        context = new Context(new AES(Configuration.INSTANCE.salt));
        this.jetEngine = jetEngine;

        ServiceTeam s900 = new STTrent900();

        ServiceTeam sXWB = new STTrentXWB();

        serviceTeam = new STTrent1000();
        sXWB.setSuccessor(s900);
        serviceTeam.setSuccessor(sXWB);


    }

    public void receive(String s){
        System.out.println("Recieved String:");
        System.out.println(s);
        System.out.println();
        System.out.println(context.decrypt(s, Configuration.INSTANCE.secretKey));
        this.serviceTeam.doService(context.decrypt(s, Configuration.INSTANCE.secretKey), jetEngine);
    }
}
