package exception;

public class UsernameArgumentException extends IllegalArgumentException {
    private String logMsg;

    /**
     * Constructor
     * @param userMsg - user-friendly message that may be shown to the user
     * @param logMsg - message that will be logged
     */
    public UsernameArgumentException(String userMsg, String logMsg){
        super(userMsg);
        this.logMsg = logMsg;
    }

    public String getLogMsg(){
        return logMsg;
    }
}
