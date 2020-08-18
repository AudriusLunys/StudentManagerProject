package studentmanager.FrontEnd.Menus;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import studentmanager.FrontEnd.Alerts.ConfirmBox;

public class MainMenu extends Application {
    Stage startingWindow;
    public static void main(String[] args) {
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        displayMainMenu(primaryStage);
    }

    public void displayMainMenu(Stage primaryStage) {
        startingWindow = primaryStage;
        GridPane rootGridPane = new GridPane();
        rootGridPane.setHgap(20);
        rootGridPane.setVgap(20);
        rootGridPane.setAlignment(Pos.TOP_CENTER);

        Button facultyButton = new Button("Faculties");
        facultyButton.setMinSize(350, 60);
        facultyButtonClicked(primaryStage, facultyButton);

        Button groupButton = new Button("Groups");
        groupButton.setMinSize(350, 60);
        groupButtonClicked(primaryStage, groupButton);

        Button modulesButton = new Button("Modules");
        modulesButton.setMinSize(350, 60);
        moduleButtonClicked(primaryStage, modulesButton);

        Button studentsButton = new Button("Students");
        studentsButton.setMinSize(350, 60);
        studentButtonClicked(primaryStage, studentsButton);

        Button exitButton = new Button("Close Program");
        exitButton.setAlignment(Pos.CENTER);
        exitButton.setMinSize(100, 30);
        exitButton.setOnAction(event -> {
           boolean result = ConfirmBox.display("Confirm", "Are you sure you want to Exit?");
           if(result==true) {
               primaryStage.close();
           }
        });

        rootGridPane.add(facultyButton, 0, 0);
        rootGridPane.add(groupButton, 0, 1);
        rootGridPane.add(modulesButton, 0, 2);
        rootGridPane.add(studentsButton, 0, 3);
        rootGridPane.add(exitButton,0,4);

        Scene scene = new Scene(rootGridPane);
        primaryStage.setTitle("Main Menu");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(500);
        primaryStage.setScene(scene);
        startingWindow.show();
    }

    private void studentButtonClicked(Stage primaryStage, Button studentsButton) {
        StudentMenu studentMenu = new StudentMenu();
        studentsButton.setOnAction(event -> {
            try {
                studentMenu.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void moduleButtonClicked(Stage primaryStage, Button modulesButton) {
        ModuleMenu moduleMenu = new ModuleMenu();
        modulesButton.setOnAction(event -> {
            try {
                moduleMenu.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void groupButtonClicked(Stage primaryStage, Button groupButton) {
        GroupMenu groupMenu = new GroupMenu();
        groupButton.setOnAction(event -> {
            try {
                groupMenu.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void facultyButtonClicked(Stage primaryStage, Button facultyButton) {
        FacultyMenu facultyMenu = new FacultyMenu();
        facultyButton.setOnAction(event -> {
            try {
                facultyMenu.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
