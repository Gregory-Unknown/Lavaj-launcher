package esobchak.school21;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class MD5Encryption {

    public static boolean checkEncrypt(String text, String hash) throws NoSuchAlgorithmException {
        String md5 = encryptToMD5(text);
        return md5.equals(hash);
    }

    private static String encryptToMD5(String text) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(text.getBytes());
        byte[] digest = md5.digest();
        BigInteger bigInteger = new BigInteger(1, digest);
        StringBuilder builder = new StringBuilder(bigInteger.toString(16));
        while (builder.length() < 32) {
            builder.insert(0, "0");
        }
        return builder.toString();
    }
}
