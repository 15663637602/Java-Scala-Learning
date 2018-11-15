package layout

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.layout.{AnchorPane, StackPane, TilePane}

/**
  * define TODO
  *
  * @author yuqili
  *         Date 15/11/18  16:39
  * @version 1.0
  **/
object _05AnchorPane extends App{
  new JFXApp {
    stage = new JFXApp.PrimaryStage {
      title = "Tile Pane"
      scene = new Scene(600, 300) {
        val tilePane = new TilePane
        for(i <- 1 to 10) {
          val thing = new Button("Button " + i)
          thing.minWidth = 200
          tilePane.children += thing
        }
        tilePane.children += new TextField

        val label = new Label("On stack")
        val slider = new Slider(0, 10, 0)

        val anchorPane = new AnchorPane
        anchorPane.children = List(label, slider)
        AnchorPane.setBottomAnchor(label, 0) // 把label放在距离底部0 pixel的位置
        AnchorPane.setBottomAnchor(slider, 0) // 把slider放在距离底部0 pixel的位置
        AnchorPane.setLeftAnchor(label, 0) // 把label放在距离左侧0 pixel的位置
        AnchorPane.setRightAnchor(slider, 0) // 把slider放在距离右侧0 pixel的位置

        // 一层覆盖一层, Label is going across the top of tilePane, and the slider is going across the top of the Label
        val stackPane = new StackPane
        stackPane.children = List(tilePane, anchorPane)

        root = stackPane

      }
    }
  }.main(args)
}
