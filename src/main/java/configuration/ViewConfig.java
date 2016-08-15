package configuration;

import controller.HomeController;
import controller.TestStageController;
import controller.PostMessageController;
import javafx.stage.Stage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import view.ViewLoader;

@Lazy
@Configuration
public class ViewConfig {
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Bean
    @Scope("singleton")
    public ViewLoader viewLoader(){
        return new ViewLoader(primaryStage);
    }

    @Bean
    @Scope("singleton")
    public HomeController homeStageController(){
        HomeController controller = new HomeController();
        controller.setViewConfig(this);
        controller.setViewLoader(viewLoader());
        return controller;
    }

    @Bean
    @Scope("singleton")
    public TestStageController notHomeStageController(){
        TestStageController controller = new TestStageController();
        controller.setViewConfig(this);
        controller.setViewLoader(viewLoader());
        return controller;
    }

    @Bean
    @Scope("singleton")
    public PostMessageController postMessageController(){
        PostMessageController controller = new PostMessageController();
        controller.setViewConfig(this);
        controller.setViewLoader(viewLoader());
        return controller;
    }
}