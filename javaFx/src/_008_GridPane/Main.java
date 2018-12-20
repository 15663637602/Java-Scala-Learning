package _008_GridPane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("the new boston");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10)); //paddings
        grid.setVgap(8); //vertical spacing
        grid.setHgap(10); // horizontal spacing

        Label nameLabel = new Label("Username: ");
        GridPane.setConstraints(nameLabel, 0, 0); //first col first row

        TextField nameInput = new TextField("Default");
        GridPane.setConstraints(nameInput, 1, 0);

        Label passLabel = new Label("Password: ");
        GridPane.setConstraints(passLabel, 0, 1); //first col 2nd row

        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 1);

        Button loginButton = new Button("log in");
        GridPane.setConstraints(loginButton, 1, 2);

        grid.getChildren().addAll(loginButton, nameLabel, nameInput, passLabel, passInput);

        Scene scene = new Scene(grid, 300, 250);
        window.setScene(scene);
        window.show();
    }
}
