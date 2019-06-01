package mu.Project.Models;

public class InvalidEmailAddressException extends Exception {

    public InvalidEmailAddressException(String email) {
        super(email);
    }
}
