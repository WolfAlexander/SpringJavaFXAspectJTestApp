package controller;

import configuration.ViewConfig;
import integration.MessageJDBCTemplate;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import view.ViewLoader;

public class PostMessageController implements CustomController{
    @Autowired
    private MessageJDBCTemplate messageDB;
    private ViewLoader viewLoader;
    private ViewConfig viewConfig;

    @FXML private Label postResult;
    @FXML private TextField usernameInput;
    @FXML private TextField messageInput;

    @Override
    public void setViewLoader(ViewLoader viewLoader) {
        this.viewLoader = viewLoader;
    }

    @Override
    public void showView() {
        viewLoader.showView(ViewLoader.Views.POST_MESSAGE, this);
    }

    @Override
    public void setViewConfig(ViewConfig viewConfig) {
        this.viewConfig = viewConfig;
    }

    /**
     * Method that calls model to post message and prints status returned from model to users
     */
    public void postMessage(){
        try {
            messageDB.addMessage(new Message(usernameInput.getText(), messageInput.getText()));
            postResult.setText("Message Successful Posted!");
        }catch (IllegalArgumentException illArgEx) {
            postResult.setText(illArgEx.getMessage());
        }catch (CannotGetJdbcConnectionException jdbcEx){
            postResult.setText("Could not post the message due to unavailable server - try again later.");
        }catch (Exception ex){
            postResult.setText("Could not post the message!");
        }
    }
}
