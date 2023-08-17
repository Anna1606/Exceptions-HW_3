/**
 * Ошибки при создании пользователя
 */
public class ExceptionsUserCreate extends RuntimeException {
    public ExceptionsUserCreate(String message) {
        super(message);
    }
}
