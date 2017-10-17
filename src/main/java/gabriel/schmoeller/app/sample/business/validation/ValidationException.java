package gabriel.schmoeller.app.sample.business.validation;

import java.util.List;

public class ValidationException extends RuntimeException {

    private final List<String> violationMessages;

    public ValidationException(String message, List<String> violationMessages) {
        super(message);
        this.violationMessages = violationMessages;
    }

    public List<String> getViolationMessages() {
        return violationMessages;
    }
}
