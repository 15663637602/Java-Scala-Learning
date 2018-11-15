package layout

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.layout.TilePane

/**
  * define TODO
  *
  * @author yuqili
  *         Date 15/11/18  16:39
  * @version 1.0
  **/
object _03TilePane extends App{
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

        root = tilePane

      }
    }
  }.main(args)
}
