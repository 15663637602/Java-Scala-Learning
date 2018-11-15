package bindings

import java.time.LocalDate

import scalafx.application.JFXApp
import scalafx.beans.property.StringProperty
import scalafx.scene.Scene
import scalafx.scene.control.{ColorPicker, DatePicker, Label}
import scalafx.scene.paint.Color

/**
  * define TODO
  *
  * @author yuqili
  *         Date 12/11/18  15:16
  * @version 1.0
  **/
object PickerBindings extends App {
  new JFXApp {
    stage = new JFXApp.PrimaryStage {
      title = "Picker Bindings"
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

        label.text <== StringProperty("Date: ") + date.value.asString

        // Use Bindings, every time the right side changes, it updates the property that on the left
        fill <== color.value
      }
    }
  }.main(args)
}
