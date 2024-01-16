package dhbw.mosbach.cryptography.sha;


import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class Application {
    public static void main(String... args) {
        String plainMessage = System.nanoTime() + " : engine | started";

        String sha256Hex = Hashing.sha256()
                .hashString(plainMessage, StandardCharsets.UTF_8)
                .toString();

        String sha384Hex = Hashing.sha384()
                .hashString(plainMessage, StandardCharsets.UTF_8)
                .toString();

        System.out.println("sha256Hex : " + sha256Hex);
        System.out.println("sha384Hex : " + sha384Hex);
    }
}