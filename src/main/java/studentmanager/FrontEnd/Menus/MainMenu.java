package studentmanager.FrontEnd.Menus;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainMenu extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane rootGridPane = new GridPane();
        rootGridPane.setHgap(10);
        rootGridPane.setVgap(10);
        rootGridPane.setAlignment(Pos.TOP_CENTER);

        Button button1 = new Button("Faculties");
      //  button1.setOnAction(event -> );
        button1.setMinSize(250,40);
        Button button2 = new Button("Groups");
        button2.setMinSize(250,40);
        Button button3 = new Button("Modules");
        button3.setMinSize(250,40);
        Button button4 = new Button("Students");
        button4.setMinSize(250,40);

        rootGridPane.add(button1,0,0);
        rootGridPane.add(button2,0,1);
        rootGridPane.add(button3,0,2);
        rootGridPane.add(button4,0,3);


        Scene scene = new Scene(rootGridPane);
        primaryStage.setTitle("Main Menu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
