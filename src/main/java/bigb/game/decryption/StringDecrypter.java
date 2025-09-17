package bigb.game.decryption;

import org.apache.commons.codec.binary.Base64;

public class StringDecrypter {

    public static String decryptString(String encodedString) {
        return new String(Base64.decodeBase64(encodedString.getBytes()));
    }
}
