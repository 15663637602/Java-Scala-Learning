package _007_EmbeddingLayouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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

        HBox topMenu = new HBox();
        Button buttonFile = new Button("File");
        Button buttonEdit= new Button("Edit");
        Button buttonView = new Button("View");
        topMenu.getChildren().addAll(buttonFile, buttonEdit, buttonView);

        VBox leftMenu = new VBox();
        Button buttonA = new Button("A");
        Button buttonB= new Button("B");
        Button buttonC = new Button("C");
        leftMenu.getChildren().addAll(buttonA, buttonB, buttonC);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setLeft(leftMenu);

        Scene scene = new Scene(borderPane, 300, 250);
        window.setScene(scene);
        window.show();
    }
}
