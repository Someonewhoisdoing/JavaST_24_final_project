package by.training.coffee.shop.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidator {
    private static final String LOGIN_PATTERN = "([a-zA-Z0-9_]+){4,10}";
    // private static final String PASSWORD_PATTERN = "([a-zA-Z0-9_]+){3,30}";

//    public boolean checkData(String login, String password) {
//        if (isRegexMatches(login, LOGIN_PATTERN)) {
//            return true;
//        }
//        return isRegexMatches(password, PASSWORD_PATTERN);
//    }

    public boolean checkData(String login) {
        return isRegexMatches(login, LOGIN_PATTERN);
    }

    private boolean isRegexMatches(String data, String regex) {
        if (data == null) {
            return false;
        }
        return isPatternMatches(data, regex);
    }

    private boolean isPatternMatches(String data, String currentPattern) {
        Pattern pattern = Pattern.compile(currentPattern);
        Matcher matcher = pattern.matcher(data);

        return matcher.matches();
    }
}
