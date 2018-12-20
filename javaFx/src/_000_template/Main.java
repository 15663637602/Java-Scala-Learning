package _000_template;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * The entire window is called stage
 * The content inside the window is the scene
 * Put buttons widgets on scene
 *
 * @author yuqili
 * Date 20/12/18  14:54
 * @version 1.0
 **/

public class Main extends Application {

    private Button button;

    public static void main(String[] args) {
        // launch will call Application, after all things fed up, it's going to call start method
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Title of the window");

        button = new Button();
        button.setText("Click Me");

        // A simple layout
        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        // Create a scene
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();// display it to the users
    }
}
