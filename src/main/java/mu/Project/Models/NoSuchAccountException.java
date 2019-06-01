package mu.Project.Models;

public class NoSuchAccountException extends Exception {

    public NoSuchAccountException(String email) {
        super(email);
    }
}
