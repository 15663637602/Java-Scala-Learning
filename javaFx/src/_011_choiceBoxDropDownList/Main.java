package _011_choiceBoxDropDownList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
    Scene scene;
    Button button;
    ColorPicker colorPicker;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("meat subs");

        button = new Button("Click Me");

        ChoiceBox<String> choiceBox = new ChoiceBox<>();

        //getItems returns the ObservableList object which you can add items to
        choiceBox.getItems().add("Apples");
        choiceBox.getItems().add("Banana");
        choiceBox.getItems().addAll("Bacon", "Ham", "Meatballs");
        // Set a default value, the value needs to be equal to an exist value.
        choiceBox.setValue("Apples");

        // Listen for selection changes
        choiceBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> System.out.println(newValue));

        button.setOnAction(e -> getChoice(choiceBox));

        colorPicker = new ColorPicker(Color.WHITE);
        Circle circle = new Circle(50);
        circle.setFill(colorPicker.getValue());


        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll( choiceBox, button, colorPicker, circle);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        colorPicker.setOnAction(e -> circle.setFill(colorPicker.getValue()));
        window.show();
    }

    private void getChoice(ChoiceBox<String> choiceBox) {
        String food = choiceBox.getValue();
        System.out.println(food);
    }

}
