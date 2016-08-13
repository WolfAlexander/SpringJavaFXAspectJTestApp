package controller;

import configuration.ViewConfig;
import view.View;

public interface CustomController {
    void setView(View view);
    void setViewConfig(ViewConfig viewConfig);
    void showView();
    void closeView();
}
