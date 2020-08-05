package studentmanager.FrontEnd;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import studentmanager.dao.FacultyDAO;
import studentmanager.domain.Faculty;

public class InputFaculty extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane rootGridPane = new GridPane();
        rootGridPane.setHgap(10);
        rootGridPane.setVgap(10);
        rootGridPane.setAlignment(Pos.TOP_LEFT);
        Label firstLabel = new Label("Faculty name");
        Label secondLabel = new Label("Faculty specialisation");


        TextField textField1 = new TextField();
        TextField textField2 = new TextField();

        Button button1 = new Button("Save");
        Button button2 = new Button("Exit");

        rootGridPane.add(firstLabel, 0, 0);
        rootGridPane.add(textField1, 0, 1);

        rootGridPane.add(secondLabel, 0, 2);
        rootGridPane.add(textField2, 0, 3);

        rootGridPane.add(button1, 0, 4);
        rootGridPane.add(button2, 1, 4);

        Faculty faculty = new Faculty();
        FacultyDAO facultyDAO =new FacultyDAO();

        button1.setOnAction(event -> {
            faculty.setFacultyName(textField1.getText());
            faculty.setSpecialization(textField2.getText());
            facultyDAO.addFaculty(faculty);

        });

        button2.setOnAction(event -> primaryStage.close());
        Scene scene = new Scene(rootGridPane);
        primaryStage.setTitle("Add Faculty");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
