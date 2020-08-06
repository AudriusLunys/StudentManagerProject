package studentmanager.FrontEnd;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import studentmanager.dao.StudentDAO;
import studentmanager.domain.Student;

public class InputStudent extends Application {

    public static void main(String[] args) {

        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane rootGridPane = new GridPane();
        rootGridPane.setHgap(10);
        rootGridPane.setVgap(10);
        rootGridPane.setAlignment(Pos.TOP_LEFT);
        Label firstLabel = new Label("First name");
        Label secondLabel = new Label("Last name");
        Label thirdLabel = new Label("Phone number");
        Label fourthLabel = new Label("Email");

        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();
        TextField textField4 = new TextField();
        Button button1 = new Button("Save");
        Button button2 = new Button("Exit");

        rootGridPane.add(firstLabel, 0, 0);
        rootGridPane.add(textField1, 0, 1);

        rootGridPane.add(secondLabel, 0, 2);
        rootGridPane.add(textField2, 0, 3);

        rootGridPane.add(thirdLabel, 0, 4);
        rootGridPane.add(textField3, 0, 5);

        rootGridPane.add(fourthLabel, 0, 6);
        rootGridPane.add(textField4, 0, 7);

        rootGridPane.add(button1, 0, 8);
        rootGridPane.add(button2, 1, 8);

        Student student = new Student();
        StudentDAO studentDAO = new StudentDAO();


       button1.setOnAction(event -> {
           student.setFirstName(textField1.getText());
           student.setLastName(textField2.getText());
           student.setPhoneNumber(textField3.getText());
           student.setEmail(textField4.getText());
           studentDAO.addStudent(student);

       });

        button2.setOnAction(event -> primaryStage.close());

        Scene scene = new Scene(rootGridPane);
        primaryStage.setTitle("Add Student");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(500);
        primaryStage.setScene(scene);
        primaryStage.show();



    }


}
