import configuration.AppConfig;
import configuration.AspectConfig;
import configuration.ViewConfig;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Startup extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, ViewConfig.class, AspectConfig.class);
        ViewConfig viewConfig = context.getBean(ViewConfig.class);
        viewConfig.setPrimaryStage(primaryStage);
        viewConfig.homeView().getController().showView();
    }
}
