package controller;

import configuration.ViewConfig;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.TestClickModel;
import org.springframework.beans.factory.annotation.Autowired;
import view.ViewLoader;

public class HomeController implements CustomController {
    @Autowired
    private TestClickModel model;
    private ViewLoader viewLoader;
    private ViewConfig viewConfig;

    @Override
    public void setViewLoader(ViewLoader viewLoader) {
        this.viewLoader = viewLoader;
    }

    @Override
    public void setViewConfig(ViewConfig viewConfig) {
        this.viewConfig = viewConfig;
    }

    @Override
    public void showView() {
        viewLoader.showView(ViewLoader.Views.HOME, this);
    }

    @FXML
    Label answerField;

    public void doesItWork(){
        String reply = model.clickedToConfirm();
        answerField.setText(reply);
    }

    public void switchToTestView(){
        viewConfig.notHomeStageController().showView();
    }

    public void switchToPostMessageView() {
        viewConfig.postMessageController().showView();
    }
}