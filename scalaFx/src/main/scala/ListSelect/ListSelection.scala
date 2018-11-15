package ListSelect
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control.{ComboBox, Label, ListView, SelectionMode}
/**
  * define TODO
  *
  * @author yuqili
  *         Date 12/11/18  15:02
  * @version 1.0
  **/
object ListSelection {

  val app: JFXApp = new JFXApp {
    stage = new JFXApp.PrimaryStage {
      title = "Selection Controls"

      // 可以放在这里
      val label = new Label("Feedback")
      label.layoutX = 20
      label.layoutY = 20

      scene = new Scene(600, 300){
        val comboBox = new ComboBox(List("Com 1", "Com 2", "Com 3"))
        comboBox.layoutX = 20
        comboBox.layoutY = 50

        val listView = new ListView(List.tabulate(20)(i => "Opt " + (i + 1)))
        listView.layoutX = 300
        listView.layoutY = 20
        listView.prefHeight = 260
        listView.getSelectionModel.setSelectionMode(SelectionMode.Multiple)

        content = List(label, comboBox, listView)

        comboBox.onAction = handle {
          label.text = "Combo Selection = " + comboBox.value.apply
        }

        listView.selectionModel.apply.selectedItems.onChange{
          label.text = "List View = " + listView.selectionModel.apply.getSelectedItems
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    app.main(args)
  }

}
