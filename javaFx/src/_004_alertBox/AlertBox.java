package _004_alertBox;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * define TODO
 *
 * @author yuqili
 * Date 20/12/18  15:33
 * @version 1.0
 **/
public class AlertBox {
    public static void display(String title, String message) {
        Stage window = new Stage(); // A blank stage

        // Block input event or user interactions with other windows until this one is taken care of.
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Close the window");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait(); // Display this window and block others until it is closed.
    }
}
