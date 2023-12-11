package sg.darren.ms.credentials.manager.exception;

import lombok.NoArgsConstructor;

import java.io.Serial;

@NoArgsConstructor
public class UnauthorizedException extends RuntimeException {
	
	@Serial
    private static final long serialVersionUID = -1445366231864801032L;

	public UnauthorizedException(String message) {
        super(message);
    }
}