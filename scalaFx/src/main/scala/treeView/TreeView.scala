package treeView
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control._
/**
  * define TODO
  *
  * @author yuqili
  *         Date 14/11/18  16:21
  * @version 1.0
  **/
object TreeView extends App{
  new JFXApp {
    stage = new JFXApp.PrimaryStage {
      title = "tree view"
      scene = new Scene(600, 600) {
        val texas = new TreeItem[String]("String")
        texas.children = List(new TreeItem("Houston"), new TreeItem("Dallas"), new TreeItem("San Antonio"))
        val cali = new TreeItem[String]("California")
        cali.children = List(new TreeItem[String]("LA"), new TreeItem[String]("San Francisco"), new TreeItem[String]("Sacramento"))
        val us = new TreeItem[String]("US")
        us.children = List(texas, cali)

        val tree = new TreeView(us)

        root = tree

        tree.selectionModel.apply.selectedItems.onChange{
          println("Selected " + tree.selectionModel.apply.getSelectedItems)
        }
      }
    }
  }.main(Array())
}
