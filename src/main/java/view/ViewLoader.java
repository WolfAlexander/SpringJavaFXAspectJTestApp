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
import java.util.HashMap;
import java.util.Map;

/**
 * This class loads FXML view, sets controller and sets scene
 */
public class ViewLoader {
    private HashMap<Views, URL> viewToFXML = new HashMap<>();
    private Stage primaryStage;
    private final int WIDTH = 400;
    private final int HEIGHT = 250;

    public enum Views{
        HOME, TEST, POST_MESSAGE
    }

    public ViewLoader(Stage stage){
        this.primaryStage = stage;

        viewToFXML.put(Views.HOME, getClass().getResource("../home.fxml"));
        viewToFXML.put(Views.TEST, getClass().getResource("../nothome.fxml"));
        viewToFXML.put(Views.POST_MESSAGE, getClass().getResource("../postMessage.fxml"));
    }

    public void showView(Views view, CustomController controller){
        showScene(getScene(view, controller));
    }

    private Scene getScene(Views view, CustomController controller){
        try {
            FXMLLoader loader = new FXMLLoader(viewToFXML.get(view));
            setController(loader, controller);
            Scene scene = new Scene((Parent) loader.load(), WIDTH, HEIGHT);
            scene.getStylesheets().add(getClass().getResource("../stylesheet.css").toString());
            return scene;
        }catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void showScene(Scene scene){
        primaryStage.setScene(scene);

        if(!primaryStage.isShowing())
            primaryStage.show();
    }

    private void setController(FXMLLoader loader, final CustomController controller){
        loader.setControllerFactory(new Callback<Class<?>, Object>() {
            @Override
            public Object call(Class<?> param) {
                return controller;
            }
        });
    }
}