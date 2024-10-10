package task3;
public class UserValidator {

    // Method to validate the username and password
    public boolean validateUser(String username, String password) {
        // Check if username is at least 5 characters long
        if (username.length() < 5) {
            System.out.println("Error: Username must be at least 5 characters long.");
            return false;
        }

        // Check if password contains at least one special character
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            System.out.println("Error: Password must contain at least one special character.");
            return false;
        }

        // Add further validation logic as needed

        // If both validations pass
        System.out.println("User validation successful.");
        return true;
    }

    public static void main(String[] args) {
        UserValidator validator = new UserValidator();
        // Test validation
        String testUsername = "user123";
        String testPassword = "pass@word1";
        
        boolean result = validator.validateUser(testUsername, testPassword);
        System.out.println("Validation result: " + result);
    }
}
