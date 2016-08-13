package exception;

public class MessageArgumentException extends IllegalArgumentException {
    private String logMsg;

    /**
     * Constructor
     * @param userMsg - user-friendly message that may be shown to the user
     * @param logMsg - message that will be logged
     */
    public MessageArgumentException(String userMsg, String logMsg){
        super(userMsg);
        this.logMsg = logMsg;
    }

    public String getLogMsg(){
        return logMsg;
    }
}
