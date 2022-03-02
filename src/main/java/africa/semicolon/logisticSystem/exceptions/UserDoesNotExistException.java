package africa.semicolon.logisticSystem.exceptions;

public class UserDoesNotExistException extends Throwable{
    public UserDoesNotExistException(String message){
        super(message);
    }
}
