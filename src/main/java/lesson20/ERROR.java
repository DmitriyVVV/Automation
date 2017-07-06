package lesson20;

/**
 * Created by Dmitriy on 05.07.2017.
 */
public enum ERROR {

    LOGIN_ERROR("LOGIN_ERROR", 2), INVALID_EMAIL_ERROR("INVALID_EMAIL_ERROR", 1), SEND_MESSAGE_ERROR("SEND_MESSAGE_ERROR", 4), MISSING_LINK("MISSING_LINK", 3);

    private String message;
    private int errorId;

    ERROR(String message, int errorId){
        this.message = message;
        this.errorId = errorId;
    }

    public String getMessage(){
        return message;
    }

    public int getErrorId(){
        return errorId;
    }

}
