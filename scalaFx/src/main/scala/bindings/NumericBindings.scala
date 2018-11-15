package bindings

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control._

/**
  * define TODO
  *
  * @author yuqili
  *         Date 15/11/18  11:15
  * @version 1.0
  **/
object NumericBindings extends App{
  new JFXApp {
    stage = new JFXApp.PrimaryStage {
      title = "Numeric Bindings"
      scene = new Scene(600, 300) {
        val label = new Label("Centered")
        label.layoutY = 50
        val button = new Button("Click Me")
        button.layoutY = 100
        val slider = new Slider(0, 500, 0)
        val scrollBar = new ScrollBar
        scrollBar.min = 0
        scrollBar.max = 500
        scrollBar.layoutY = 270
        val textField = new TextField
        textField.text = label.text.value
        textField.layoutX = 500

        content = List(label, button, slider, scrollBar, textField)

        button.layoutX <== slider.value
        scrollBar.value <==> slider.value // bing bi-directional

        // Put label at the center
        label.layoutX <== (scene.width - label.width) / 2 // 可以写成公式的好处是 可以和基本上任何东西动态绑定. 这里就算是label的长度变化了也没事
        label.text <== textField.text

        textField.layoutX <== scene.width - textField.width
      }
    }
  }.main(args)

}
