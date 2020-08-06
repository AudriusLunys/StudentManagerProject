package studentmanager.FrontEnd;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import studentmanager.dao.ModuleDAO;
import studentmanager.dao.StudentDAO;
import studentmanager.domain.Module;
import studentmanager.domain.Student;

public class InputModule extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane rootGridPane = new GridPane();
        rootGridPane.setHgap(10);
        rootGridPane.setVgap(10);
        rootGridPane.setAlignment(Pos.TOP_LEFT);
        Label firstLabel = new Label("Module Name");
        Label secondLabel = new Label("Academic Hours");
        Label thirdLabel = new Label("Credits");


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

        Module module = new Module();
        ModuleDAO moduleDAO = new ModuleDAO();

        button1.setOnAction(event -> {
            module.setModuleName(textField1.getText());
            int academicHours = Integer.parseInt(textField2.getText());
            module.setAcademicHours(academicHours);
            int credits = Integer.parseInt(textField3.getText());
            module.setModuleCredits(credits);
            moduleDAO.addModule(module);

        });

        button2.setOnAction(event -> primaryStage.close());

        Scene scene = new Scene(rootGridPane);
        primaryStage.setTitle("Add Module");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(500);
        primaryStage.setScene(scene);
        primaryStage.show();



    }

}

