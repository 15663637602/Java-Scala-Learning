package tableView
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.beans.property.{ObjectProperty, StringProperty}
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import scalafx.scene.control._
/**
  * define TODO
  *
  * @author yuqili
  *         Date 12/11/18  15:28
  * @version 1.0
  **/

case class Student(name: String, test1: Int, test2: Int)

object TableView {
  val app: JFXApp = new JFXApp {
    stage = new JFXApp.PrimaryStage {
      title = "Table View"
      scene = new Scene(600, 300){
        val data = ObservableBuffer(
          Student("Li", 90, 92),
          Student("Yu", 28, 89),
          Student("oi", 86, 67)
        )

        val table = new TableView(data)
        val col1 = new TableColumn[Student, String]("Name")
        // 用cdf.value 你可以得到Student对象
        col1.cellValueFactory = cdf => StringProperty(cdf.value.name)
        val col2 = new TableColumn[Student, Int]("Test 1")
        col2.cellValueFactory = cdf => ObjectProperty(cdf.value.test1)
        val col3 = new TableColumn[Student, Int]("Test 2")
        col3.cellValueFactory = cdf => ObjectProperty(cdf.value.test2)

        val col4 = new TableColumn[Student, Double]("Average")
        col4.cellValueFactory = cdf => ObjectProperty((cdf.value.test2 + cdf.value.test1) / 2.0)

        table.columns ++= List(col1, col2, col3, col4)


        root = table // in order to let table to be auto-adjusted, use it as root
        table.selectionModel.apply.selectedItem.onChange{
          println("Selected " + table.selectionModel.apply.getSelectedItems)
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    app.main(args)
  }
}
