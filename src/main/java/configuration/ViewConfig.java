package configuration;

import controller.HomeController;
import controller.TestStageController;
import controller.PostMessageController;
import javafx.stage.Stage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import view.View;

@Configuration
public class ViewConfig {
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Bean
    public View homeView(){
        return new View(homeStageController(), getClass().getResource("../home.fxml"), primaryStage);
    }

    @Bean
    @Scope("singleton")
    public HomeController homeStageController(){
        HomeController controller = new HomeController();
        controller.setViewConfig(this);
        return controller;
    }

    @Bean
    public View notHomeView(){
        return new View(notHomeStageController(), getClass().getResource("../nothome.fxml"), primaryStage);
    }

    @Bean
    @Scope("singleton")
    public TestStageController notHomeStageController(){
        TestStageController controller = new TestStageController();
        controller.setViewConfig(this);
        return controller;
    }

    @Bean
    public View postMessageView(){
        return new View(postMessageController(), getClass().getResource("../postMessage.fxml"), primaryStage);
    }

    @Bean
    @Scope("singleton")
    public PostMessageController postMessageController(){
        PostMessageController controller = new PostMessageController();
        controller.setViewConfig(this);
        return controller;
    }
}
