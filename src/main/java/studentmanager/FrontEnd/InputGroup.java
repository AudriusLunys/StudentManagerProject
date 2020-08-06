package studentmanager.FrontEnd;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import studentmanager.dao.GroupDAO;
import studentmanager.domain.Group;


public class InputGroup extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane rootGridPane = new GridPane();
        rootGridPane.setHgap(10);
        rootGridPane.setVgap(10);
        rootGridPane.setAlignment(Pos.TOP_LEFT);
        Label firstLabel = new Label("Group Name");
        Label secondLabel = new Label("Academic Year");
        Label thirdLabel = new Label("Faculty ID");


        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();

        Button button1 = new Button("Save");
        Button button2 = new Button("Exit");

        rootGridPane.add(firstLabel, 0, 0);
        rootGridPane.add(textField1, 0, 1);

        rootGridPane.add(secondLabel, 0, 2);
        rootGridPane.add(textField2, 0, 3);

        rootGridPane.add(thirdLabel, 0, 4);
        rootGridPane.add(textField3, 0, 5);


        rootGridPane.add(button1, 0, 6);
        rootGridPane.add(button2, 1, 6);

        Group group = new Group();
        GroupDAO groupDAO = new GroupDAO();


        button1.setOnAction(event -> {
            group.setGroupName(textField1.getText());
            int academicYear = Integer.parseInt(textField2.getText());
            group.setAcademicYear(academicYear);
            groupDAO.addGroup(group);

        });

        button2.setOnAction(event -> primaryStage.close());

        Scene scene = new Scene(rootGridPane);
        primaryStage.setTitle("Add Group");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
