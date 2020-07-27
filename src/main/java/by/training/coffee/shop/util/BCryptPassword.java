package by.training.coffee.shop.util;

import org.bouncycastle.util.encoders.Hex;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BCryptPassword {

    private static final int WORKLOAD = 12;

    public static String hashPassword(String initialPassword) {
//        String salt = BCrypt.gensalt(WORKLOAD);
//
//        return BCrypt.hashpw(initialPassword, salt);
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(initialPassword.getBytes(StandardCharsets.UTF_8));
            return new String(Hex.encode(hash));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
