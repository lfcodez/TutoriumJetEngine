package dhbw.mosbach.cryptography.sha;

import com.google.common.hash.Hashing;
import dhbw.mosbach.cryptography.IAlgorithm;
import dhbw.mosbach.cryptography.IHash;

import java.nio.charset.StandardCharsets;

public class SHA implements IHash {


    @Override
    public String hash(String plainMessage, String secretKey) {
        return Hashing.sha256()
                .hashString(plainMessage, StandardCharsets.UTF_8)
                .toString();
    }
}
