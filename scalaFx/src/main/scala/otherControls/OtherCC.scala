package otherControls
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.geometry.Orientation
import scalafx.scene.Scene
import scalafx.scene.control._
/**
  * define TODO
  *
  * @author yuqili
  *         Date 14/11/18  17:53
  * @version 1.0
  **/
object OtherCC extends App{
  new JFXApp {
    stage = new JFXApp.PrimaryStage {
      title = "tree view"
      scene = new Scene(600, 600) {
       val toolBar = new ToolBar
        toolBar.prefWidth = 600
        val advButton = new Button("Advance")
        val decButton = new Button("Decrement")
        toolBar.items = List(advButton, decButton, new Separator, new Button("Tool 1"), new Button("Tool 2"))

        val progress = new ProgressBar
        progress.layoutX = 20
        progress.layoutY = 70
        progress.prefWidth = 260

        val scrollBar = new ScrollBar
        scrollBar.layoutX = 20
        scrollBar.layoutY = 130
        scrollBar.prefWidth = 260
        scrollBar.min = 0
        scrollBar.max = 100

        val scrollLabel = new Label("")
        scrollLabel.layoutX = 20
        scrollLabel.layoutY = 180

        val separator = new Separator
        separator.layoutX = 300
        separator.layoutY = 70
        separator.orientation = Orientation.Vertical
        separator.prefHeight = 230

        val slider = new Slider(0, 10, 0)
        slider.layoutX = 320
        slider.layoutY = 70
        slider.prefWidth = 260

        val sliderLabel = new Label("")
        sliderLabel.layoutX = 320
        sliderLabel.layoutY = 120

        content = List(toolBar, progress, scrollBar, separator, slider, scrollLabel, sliderLabel)

        advButton.onAction = handle {
          progress.progress = progress.progress.apply + 0.05 min 1.0 max 0.0 // progress 的值要比1小比0大
        }

        decButton.onAction = handle {
          progress.progress = progress.progress.apply - 0.05 min 1.0 max 0.0
        }

        scrollBar.value.onChange {
          scrollLabel.text = "ScrollBar: " + scrollBar.value.apply
        }

        slider.value.onChange {
          sliderLabel.text = "Slider: " + slider.value.apply
        }
      }
    }
  }.main(Array())
}
