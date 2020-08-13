package studentmanager.FrontEnd.Menus;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainMenu extends Application {
    Stage startingWindow;
    public static void main(String[] args) {
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        startingWindow = primaryStage;
        GridPane rootGridPane = new GridPane();
        rootGridPane.setHgap(20);
        rootGridPane.setVgap(20);
        rootGridPane.setAlignment(Pos.TOP_CENTER);

        Button facultyButton = new Button("Faculties");
        facultyButton.setMinSize(350, 60);
        FacultyMenu facultyMenu = new FacultyMenu();
        facultyButton.setOnAction(event -> {
            try {
                facultyMenu.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Button groupButton = new Button("Groups");
        groupButton.setMinSize(350, 60);
        GroupMenu groupMenu = new GroupMenu();
        groupButton.setOnAction(event -> {
            try {
                groupMenu.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Button modulesButton = new Button("Modules");
        modulesButton.setMinSize(350, 60);
        ModuleMenu moduleMenu = new ModuleMenu();
        modulesButton.setOnAction(event -> {
            try {
                moduleMenu.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Button studentsButton = new Button("Students");
        studentsButton.setMinSize(350, 60);
        StudentMenu studentMenu = new StudentMenu();
        studentsButton.setOnAction(event -> {
            try {
                studentMenu.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        rootGridPane.add(facultyButton, 0, 0);
        rootGridPane.add(groupButton, 0, 1);
        rootGridPane.add(modulesButton, 0, 2);
        rootGridPane.add(studentsButton, 0, 3);

        Scene scene = new Scene(rootGridPane);
        primaryStage.setTitle("Main Menu");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(500);
        primaryStage.setScene(scene);
        startingWindow.show();
    }

}
