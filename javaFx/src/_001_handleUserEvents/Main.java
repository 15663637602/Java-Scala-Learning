package _001_handleUserEvents;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * define TODO
 *
 * @author yuqili
 * Date 20/12/18  15:10
 * @version 1.0
 **/
public class Main extends Application implements EventHandler<ActionEvent> {

    private Button button;

    public static void main(String[] args) {
        // launch will call Application, after all things fed up, it's going to call start method
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        // Identify which source called this event
        if (event.getSource() == button) {
            System.out.println("button touched");
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Title of the window");

        button = new Button();
        button.setText("Click Me");

        // Means whenever the button is clicked, this class will be the class to handle it.
        // Will try to find the handle method in this class, u can also create a new handler class.
        button.setOnAction(this);

        // A simple layout
        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        // Create a scene
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();// display it to the users
    }
}
