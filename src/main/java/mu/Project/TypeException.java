package mu.Project;

import com.sun.jdi.InvalidTypeException;

public class TypeException extends InvalidTypeException {

    public TypeException() {
        super();
    }

    public TypeException(String message) {
        super(message);
    }
}
