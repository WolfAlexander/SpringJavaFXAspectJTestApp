package view;

import controller.CustomController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;

/**
 * This class loads FXML view, sets controller and sets scene
 */
public class View extends Stage {
    private final int WIDTH = 400;
    private final int HEIGHT = 250;
    private CustomController controller;

    public View(final CustomController controller, URL fxml, Window stageOwner){
        super(StageStyle.DECORATED);
        initModality(Modality.WINDOW_MODAL);
        initOwner(stageOwner);

        try {
            FXMLLoader loader = new FXMLLoader(fxml);
            setController(loader, controller);
            controller.setView(this);
            setScene(new Scene((Parent) loader.load(), WIDTH ,HEIGHT));
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }

    private void setController(FXMLLoader loader, final CustomController controller){
        this.controller = controller;
        loader.setControllerFactory(new Callback<Class<?>, Object>() {
            @Override
            public Object call(Class<?> param) {
                return controller;
            }
        });
    }

    public CustomController getController(){
        return controller;
    }
}
