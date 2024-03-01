package cl.bci.javatest.util;

public class RegExUtil {
    private static final RegExUtil instance = new RegExUtil();

    private static final String EMAIL_REGEX = "^[-A-Za-z0-9!#$%&'*+/=?^_`{|}~]+(?:\\.[-A-Za-z0-9!#$%&'*+/=?^_`{|}~]+)*@(?:[A-Za-z0-9](?:[-A-Za-z0-9]*[A-Za-z0-9])?\\.)+[A-Za-z0-9](?:[-A-Za-z0-9]*[A-Za-z0-9])?$";

    //Minimum eight characters, at least one letter, one number and one special character:
    // ^                 -> start-of-string
    // (?=.*[0-9])       -> a digit must occur at least once
    // (?=.*[a-z])       -> a lower case letter must occur at least once
    // (?=.*[A-Z])       -> an upper case letter must occur at least once
    // (?=.*[@#$%^&+=])  -> a special character must occur at least once
    // (?=\S+$)          -> no whitespace allowed in the entire string
    // .{8,}             -> anything, at least eight places though
    // $                 -> end-of-string
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    private RegExUtil() {
    }

    public static RegExUtil getInstance() {
        return instance;
    }

    public boolean isValidEmail(String email) {
        return email != null && email.matches(EMAIL_REGEX);
    }

    public boolean isValidPassword(String password) {
        return password != null && password.matches(PASSWORD_REGEX);
    }
}
