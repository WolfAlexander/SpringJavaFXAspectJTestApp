package controller;

import configuration.ViewConfig;
import model.TestClickModel;
import org.springframework.beans.factory.annotation.Autowired;
import view.View;

public class TestStageController implements CustomController {
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
        view.setTitle("Not Home Stage");
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

    public void goHome(){
        viewConfig.homeView().getController().showView();
        closeView();
    }
}
