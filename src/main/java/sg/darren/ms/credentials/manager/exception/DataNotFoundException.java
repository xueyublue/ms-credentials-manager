package sg.darren.ms.credentials.manager.exception;

import lombok.NoArgsConstructor;

import java.io.Serial;

@NoArgsConstructor
public class DataNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -6796055067130923090L;

    public DataNotFoundException(String message) {
        super(message);
    }

    public static DataNotFoundException credentialsNotFound(Integer id) {
        return new DataNotFoundException(String.format("Credentials ID %s not found!", id));
    }

}
