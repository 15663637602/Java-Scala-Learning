package layout
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.layout.BorderPane
/**
  * define TODO
  *
  * @author yuqili
  *         Date 15/11/18  16:39
  * @version 1.0
  **/
object _01BorderPane extends App{
  new JFXApp {
    stage = new JFXApp.PrimaryStage {
      title = "Border Pane"
      scene = new Scene(600, 300) {
        val border = new BorderPane
        border.top = new Label("On top")
        border.bottom = new Button("Bottom Button")
        border.left = new ListView(List(1,2,3))
        border.right = new Button("Right")
        border.center = new TextArea

        root = border

      }
    }
  }.main(args)
}
