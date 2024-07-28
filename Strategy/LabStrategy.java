package Strategy;
import java.util.Scanner;

// Define the AuthenticationStrategy interface
interface AuthenticationStrategy {
    void authenticate();
}

// Implement UsernamePasswordAuth strategy
class UsernamePasswordAuth implements AuthenticationStrategy {
    @Override
    public void authenticate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        // Your authentication logic here
        System.out.println("Authenticated using Username/Password");
    }
}

// Implement OAuthAuth strategy
class OAuthAuth implements AuthenticationStrategy {
    @Override
    public void authenticate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter OAuth token: ");
        String token = scanner.nextLine();
        // Your authentication logic here
        System.out.println("Authenticated using OAuth");
    }
}

// Context class for authentication
class GitHubSimulator {
    private AuthenticationStrategy authStrategy;

    public void setAuthStrategy(AuthenticationStrategy authStrategy) {
        this.authStrategy = authStrategy;
    }

    public void login() {
        if (authStrategy != null) {
            authStrategy.authenticate();
        } else {
            System.out.println("Please set authentication strategy first.");
        }
    }
}

// Example usage
public class LabStrategy {
    public static void main(String[] args) {
        GitHubSimulator gitHubSimulator = new GitHubSimulator();

        // Login with Username/Password
        gitHubSimulator.setAuthStrategy(new UsernamePasswordAuth());
        gitHubSimulator.login();

        // Login with OAuth
        gitHubSimulator.setAuthStrategy(new OAuthAuth());
        gitHubSimulator.login();
    }
}

