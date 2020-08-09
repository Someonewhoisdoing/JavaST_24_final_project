package by.training.coffee.shop.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDataValidator {
    private static final String LOGIN_PATTERN = "([a-zA-Z0-9_]+){4,10}";
    private static final String NAME_PATTERN = "[A-Za-zА-Яа-я]+";
    private static final String PHONE_PATTERN = "([\\+0-9]){13}";

    public static boolean checkData(String login, String name, String surname, String phone) {
        if (isRegexMatches(login, LOGIN_PATTERN)) {
            return true;
        }
        if (isRegexMatches(name, NAME_PATTERN)) {
            return true;
        }
        if (isRegexMatches(surname, NAME_PATTERN)) {
            return true;
        }
        return isRegexMatches(phone, PHONE_PATTERN);
    }

    private static boolean isRegexMatches(String data, String regex) {
        if (data == null) {
            return false;
        }
        return isPatternMatches(data, regex);
    }

    private static boolean isPatternMatches(String data, String currentPattern) {
        Pattern pattern = Pattern.compile(currentPattern);
        Matcher matcher = pattern.matcher(data);

        return matcher.matches();
    }
}