package task3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UserValidator {
    
    private List<String> existingUsernames = new ArrayList<>();

    public UserValidator() {
        existingUsernames.add("user123");
        existingUsernames.add("admin");
    }

    public boolean validateUser(String username, String password, String email) {
        if (username.length() < 5) {
            System.out.println("Error: Username must be at least 5 characters long.");
            return false;
        }

        if (existingUsernames.contains(username)) {
            System.out.println("Error: Username is already taken.");
            return false;
        }

        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            System.out.println("Error: Password must contain at least one special character.");
            return false;
        }

        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (!pattern.matcher(email).matches()) {
            System.out.println("Error: Invalid email format.");
            return false;
        }

        System.out.println("User validation successful.");
        return true;
    }

    public static void main(String[] args) {
        UserValidator validator = new UserValidator();
        
        String testUsername = "user123";
        String testPassword = "pass@word1";
        String testEmail = "user@example.com";

        boolean result = validator.validateUser(testUsername, testPassword, testEmail);
        System.out.println("Validation result: " + result);

        testUsername = "newuser";
        result = validator.validateUser(testUsername, testPassword, testEmail);
        System.out.println("Validation result: " + result);

        testEmail = "invalid-email";
        result = validator.validateUser(testUsername, testPassword, testEmail);
        System.out.println("Validation result: " + result);
    }
}
