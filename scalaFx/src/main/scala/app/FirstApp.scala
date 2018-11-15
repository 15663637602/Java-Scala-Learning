package app

import scalafx.application
import scalafx.application.JFXApp
import scalafx.event.ActionEvent
import scalafx.scene.Scene
import scalafx.scene.control.{Button, ComboBox, ListView, SelectionMode}
import scalafx.Includes._

/**
  * define TODO
  *
  * @author yuqili
  *         Date 12/11/18  11:05
  * @version 1.0
  **/
object FirstApp {

  val app: JFXApp = new JFXApp {
    stage = new application.JFXApp.PrimaryStage {
      title = "First GUI"
      scene = new Scene(400, 300) {
        val button = new Button("Click Me!")
        // the location of button
        button.layoutX = 100
        button.layoutY = 20

        val comboBox = new ComboBox(List("Scala", "Java", "C++", "Haskell"))
        comboBox.layoutX = 200
        comboBox.layoutY = 50

        val listView = new ListView(List("AWT", "Swing", "JavaFx", "ScalaFx"))
        listView.layoutX = 100
        listView.layoutY = 100
        listView.prefHeight = 150
        listView.getSelectionModel.setSelectionMode(SelectionMode.Multiple)

        content = List(button, comboBox, listView)

        // requires importing scalafx.Includes._
        button.onAction = handle { // simple handler
          println("clicked2")
        }
        button.onAction = (e: ActionEvent) => {
          val allSelectedInList = listView.selectionModel.apply.getSelectedItems
          listView.items = listView.items.apply.diff(allSelectedInList) // remove allSelectedInList in the listView
          println("clicked")
        }

        comboBox.onAction = (e: ActionEvent) => {
          listView.items.apply += comboBox.selectionModel.apply.getSelectedItem
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    app.main(args)
  }
}
