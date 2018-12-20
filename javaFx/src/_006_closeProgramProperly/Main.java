package _006_closeProgramProperly;

import _005_confirmBox.ConfirmBox;
import javafx.application.Application;
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
public class Main extends Application {

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("the new boston");

        button = new Button("Close Program");
        button.setOnAction(e -> closeProgram());

//        window.setOnCloseRequest(e -> closeProgram()); //Works for Exit button from the menu bar.

        window.setOnCloseRequest(e -> {
            e.consume(); // stops its further propagation.
            closeProgram();
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram() {
        boolean answer = ConfirmBox.display("A Tile", "Sure you want to exit");
        if (answer) {
           window.close();
        }
    }
}
