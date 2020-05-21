package by.training.coffee.shop.util;

public class BCryptPassword {
    /*
    A workload of 12 is a very reasonable safe default as of 2013.
    *This automatically handles secure 128-bit salt generation and storage within the hash.
     */
    private static final int WORKLOAD = 12;

    public static String hashPassword(String initialPassword) {
        String salt = BCrypt.gensalt(WORKLOAD);

        return BCrypt.hashpw(initialPassword, salt);
    }

    public static boolean checkPassword(String initialPassword, String storedHash) {
        if (storedHash == null || !storedHash.startsWith("$2a")) {
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
        }

        return BCrypt.checkpw(initialPassword, storedHash);
    }
}
