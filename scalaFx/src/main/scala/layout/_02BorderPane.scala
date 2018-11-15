package layout

import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.layout.{BorderPane, FlowPane, HBox, VBox}

/**
  * define TODO
  *
  * @author yuqili
  *         Date 15/11/18  16:39
  * @version 1.0
  **/
object _02BorderPane extends App{
  new JFXApp {
    stage = new JFXApp.PrimaryStage {
      title = "Border Pane"
      scene = new Scene(600, 300) {
        val border = new BorderPane

        val hbox = new HBox(10, new Label("On top"), new Button("On top"), new TextField) // hbox lays things horizontally

        val vbox = new VBox(10, new Label("On Right"), new Button("On Right"), new TextField) // hbox lays things horizontally

        // the difference between hvbox and flowpane is flowpane is more flexible that if there is no room for display all things in one line, it will lay things into two lines
        val flow = new FlowPane(10, 10)
        flow.children = List(new Label("On Bottom"), new Button("On Bottom"), new TextField)

        border.top = hbox
        border.bottom = new Button("Bottom Button")
        border.left = new ListView(List(1,2,3))
        border.right = vbox
        border.center = flow

        root = border

      }
    }
  }.main(args)
}
