package controller;

import configuration.ViewConfig;
import exception.MessageArgumentException;
import exception.UsernameArgumentException;
import integration.MessageJDBCTemplate;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import view.View;

public class PostMessageController implements CustomController{
    @Autowired
    private MessageJDBCTemplate messageDB;
    private View view;
    private ViewConfig viewConfig;
    @FXML private Label postResult;
    @FXML private TextField usernameInput;
    @FXML private TextField messageInput;

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void setViewConfig(ViewConfig viewConfig) {
        this.viewConfig = viewConfig;
    }

    @Override
    public void showView() {
        view.show();
    }

    @Override
    public void closeView() {
        view.close();
    }

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
