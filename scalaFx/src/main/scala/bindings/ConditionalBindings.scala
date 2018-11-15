package bindings

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.paint.Color

/**
  * define TODO
  *
  * @author yuqili
  *         Date 15/11/18  11:15
  * @version 1.0
  **/
object ConditionalBindings extends App{
  new JFXApp {
    stage = new JFXApp.PrimaryStage {
      title = "Conditional Bindings"
      scene = new Scene(600, 300) {
        val label = new Label("Hover to change background") // 悬停

        val slider = new Slider(0, 10, 0)

        content = List(label, slider)


        // Put label at the vertical center
        label.layoutY <== (scene.height - label.height) / 2 // 可以写成公式的好处是 可以和基本上任何东西动态绑定. 这里就算是label的长度变化了也没事

        label.layoutX <== when (slider.value < 5) choose 0 otherwise scene.width - label.width // 这里的条件表达式起到了 if else的效果
        fill <== when (label.hover) choose Color.Green otherwise Color.White
      }
    }
  }.main(args)

}
