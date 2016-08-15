package controller;

import configuration.ViewConfig;
import view.ViewLoader;

public interface CustomController {
    void setViewLoader(ViewLoader viewLoader);

    /**
     * This method will be called to show view
     */
    void showView();

    /**
     * ViewConfig will be needed to get controllers to other views
     * @param viewConfig of type configuration.ViewConfig
     */
    void setViewConfig(ViewConfig viewConfig);
}
