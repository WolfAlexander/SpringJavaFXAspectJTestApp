package controller;

import configuration.ViewConfig;
import model.TestClickModel;
import org.springframework.beans.factory.annotation.Autowired;
import view.ViewLoader;

public class TestStageController implements CustomController {
    @Autowired
    private TestClickModel model;
    private ViewLoader viewLoader;
    private ViewConfig viewConfig;

    @Override
    public void setViewLoader(ViewLoader viewLoader) {
        this.viewLoader = viewLoader;
    }

    @Override
    public void showView() {
        viewLoader.showView(ViewLoader.Views.TEST, this);
    }

    @Override
    public void setViewConfig(ViewConfig viewConfig) {
        this.viewConfig = viewConfig;
    }

    public void switchToHomeView(){
        viewConfig.homeStageController().showView();
    }
}
