package pickerControl
import java.time.LocalDate

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.paint.Color
/**
  * define TODO
  *
  * @author yuqili
  *         Date 12/11/18  15:16
  * @version 1.0
  **/
object PickerControls extends App {
  new JFXApp {
    stage = new JFXApp.PrimaryStage {
      title = "Picker Controls"
      scene = new Scene(390, 300) {
        val label = new Label("Shows date")
        label.layoutX = 20
        label.layoutY = 20

        val date = new DatePicker(LocalDate.now)
        date.layoutX = 20
        date.layoutY = 50

        val color = new ColorPicker(Color.White)
        color.layoutX = 20
        color.layoutY = 80

        content = List(label, date, color)

        date.onAction = handle {
          label.text = "Date: " + date.value.apply
        }

        // Defines the background fill of this Scene.
        color.onAction = handle {
          fill = color.value.apply
        }
      }
    }
  }.main(args)
}
