package model;

import exception.MessageArgumentException;
import exception.UsernameArgumentException;

/**
 * This object encapsulates username and message entered by user in PostMessage stage
 * Also provides both username and message validation
 */
public class Message {
    private String username;
    private String message;

    public Message(String username, String message) {
        this.username = username;
        this.message = message;
    }

    /**
     * Call this to validate fields in this objects
     * @throws IllegalArgumentException if any of fields are invalid
     */
    public void validateMessageInput() throws IllegalArgumentException{
        validateName();
        validateMessage();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "username='" + username + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    private void validateName() throws IllegalArgumentException{
        if(username.length() < 5)
            throw new UsernameArgumentException("Username cannot be shorted than 5 characters!", "Username is too short! Username '" + username + "' has " + username.length() + " characters");
        else if(username.length() > 20)
            throw new UsernameArgumentException("Username cannot be longer than 20 characters!", "Username is too long! Username '" + username + "' has " + username.length() + " characters");
    }

    private void validateMessage() throws UsernameArgumentException {
        if(message.length() <= 0)
            throw new MessageArgumentException("Message cannot be empty!", "Message is to short! Message '" + message + "' has length " + message.length() + " characters");
        else if(message.length() > 400)
            throw new MessageArgumentException("Message cannot be longer that 400 characters!", "Message is to long! Message length is " + message.length());
    }
}
