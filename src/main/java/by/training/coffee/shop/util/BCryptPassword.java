package by.training.coffee.shop.util;

public class BCryptPassword {

    private static final int WORKLOAD = 12;

    public static String hashPassword(String initialPassword) {
        String salt = BCrypt.gensalt(WORKLOAD);

        return BCrypt.hashpw(initialPassword, salt);
    }
}
