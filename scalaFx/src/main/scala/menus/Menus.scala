package menus

import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.Includes._
import scalafx.scene.input.{KeyCode, KeyCodeCombination, KeyCombination}
import scalafx.stage.FileChooser

/**
  * define TODO
  *
  * @author yuqili
  *         Date 14/11/18  16:44
  * @version 1.0
  **/
object Menus extends App{
  new JFXApp {
    stage = new JFXApp.PrimaryStage {
      title = "Menu"
      scene = new Scene(600, 600) {
        val menuBar = new MenuBar

        val fileMenu = new Menu("File")
        val openItem = new MenuItem("Open")
        openItem.accelerator = new KeyCodeCombination(KeyCode.O, KeyCombination.ControlDown)
        val saveItem = new MenuItem("Save")
        saveItem.accelerator = new KeyCodeCombination(KeyCode.S, KeyCombination.ControlDown)
        val exitItem = new MenuItem("Exit")
        exitItem.accelerator = new KeyCodeCombination(KeyCode.X, KeyCombination.ControlDown)
        fileMenu.items = List(openItem, saveItem, new SeparatorMenuItem, exitItem)

        val checkMenu = new Menu("Check")
        val check1 = new CheckMenuItem("Check 1")
        val check2 = new CheckMenuItem("Check 2")
        checkMenu.items = List(check1, check2)

        val radioMenu = new Menu("Radio")
        val radio1 = new RadioMenuItem("Radio 1")
        val radio2 = new RadioMenuItem("Radio 2")
        val radio3 = new RadioMenuItem("Radio 3")
        val group = new ToggleGroup
        group.toggles = List(radio1, radio2, radio3)
        radioMenu.items = List(radio1, radio2, radio3)

        val typeMenu = new Menu("Types")
        typeMenu.items = List(checkMenu, radioMenu)

        menuBar.menus = List(fileMenu, typeMenu)
        menuBar.prefWidth = 600

        val menuButton = new MenuButton("Menu Button")
        menuButton.items = List(new MenuItem("Button 1"), new MenuItem("Button 2"))
        menuButton.layoutX = 20
        menuButton.layoutY = 50

        val splitMenuButton = new SplitMenuButton(new MenuItem("Split 1"), new MenuItem("Split 2"), new MenuItem("Split 3"))
        splitMenuButton.text = "Split Menu"
        splitMenuButton.layoutX = 20
        splitMenuButton.layoutY = 100

        val label = new Label("Right Click for context menu")
        label.layoutX = 20
        label.layoutY = 150
        val labelContextMenu = new ContextMenu(new MenuItem("Context 1"), new MenuItem("Context 2"), new MenuItem("Context 3"))
        label.contextMenu = labelContextMenu

        content = List(menuBar, menuButton, splitMenuButton, label)

        exitItem.onAction = handle {
          sys.exit(0)
        }

        openItem.onAction = handle {
          val fileChooser = new FileChooser
          val selectedFile = fileChooser.showOpenDialog(stage)
          label.text = "Open: " + selectedFile
        }

        saveItem.onAction = handle {
          val fileChooser = new FileChooser
          val savedFile = fileChooser.showSaveDialog(stage)
          label.text = "Save: " + savedFile
        }
      }
    }
  }.main(Array())
}
