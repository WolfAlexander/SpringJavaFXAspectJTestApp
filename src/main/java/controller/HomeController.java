package controller;

import configuration.ViewConfig;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.TestClickModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import view.View;

public class HomeController implements CustomController {
    @Autowired
    private TestClickModel model;
    private View view;
    private ViewConfig viewConfig;

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void showView() {
        view.setTitle("Home Stage");
        view.show();
    }

    @Override
    public void closeView() {
        view.close();
    }

    @Override
    public void setViewConfig(ViewConfig viewConfig) {
        this.viewConfig = viewConfig;
    }

    @FXML
    Label answerField;

    public void doesItWork(){
        String reply = model.clickedToConfirm();
        answerField.setText(reply);
    }

    public void showTestStage(){
        viewConfig.notHomeView().getController().showView();
        closeView();

    }

    public void showPostMessageView(){
        viewConfig.postMessageView().getController().showView();
        closeView();
    }
}
