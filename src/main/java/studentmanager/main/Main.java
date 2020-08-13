package studentmanager.main;

import javafx.application.Application;
import javafx.stage.Stage;
import studentmanager.FrontEnd.Menus.MainMenu;
import studentmanager.utils.InitData;


public class Main extends Application {

    public static void main(String[] args) {

        InitData initData = new InitData();
        initData.loadInitData();
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        MainMenu mainMenu = new MainMenu();
        mainMenu.start(primaryStage);
    }
}
