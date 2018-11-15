package controls

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control._

/**
  * define TODO
  *
  * @author yuqili
  *         Date 12/11/18  12:10
  * @version 1.0
  **/
class TextControl {
  val tcApp: JFXApp = new JFXApp {
    stage = new JFXApp.PrimaryStage {
      title = "Text Controls"
      scene = new Scene(400, 400) {
        val label = new Label("This is a label")
        label.layoutX = 20
        label.layoutY = 20

        val textField = new TextField
        textField.layoutX = 20
        textField.layoutY = 50
        textField.promptText = "A Field"

        val textArea = new TextArea

        textArea.layoutX = 20
        textArea.layoutY = 80
        textArea.prefWidth = 360
        textArea.prefHeight = 200
        textArea.promptText = "Area"

        val passwordField = new PasswordField
        passwordField.layoutX = 20
        passwordField.layoutY = 280
        passwordField.promptText = "Password"

        content = List(label, textField, textArea, passwordField)

        // Hit the enter will call the action on text
        textField.onAction = handle {
          label.text = "Field Action: " + textField.text.apply
        }

        textArea.text.onChange{
          label.text = "Area change: " + textArea.text.apply
        }

        passwordField.focused.onChange{
          label.text = "Password changed " + passwordField.focused.apply
        }
      }
    }
  }
}

object TextControl {
  def main(args: Array[String]): Unit = {
    new TextControl().tcApp.main(args)
  }
}
