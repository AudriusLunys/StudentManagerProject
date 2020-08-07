package studentmanager.FrontEnd.Menus;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import studentmanager.dao.FacultyDAO;
import studentmanager.domain.Faculty;

import java.util.List;

public class FacultyMenu extends Application {
    Stage facultyWindow;
    TableView<Faculty> facultyTable ;
    TextField facultyNameInput, facultySpecializationInput;


    public static void main(String[] args) {
      //for test purposes
        Faculty faculty1 = new Faculty();
        faculty1.setFacultyName("Statybos Fakultetas");
        faculty1.setSpecialization("Inzinerija");

        Faculty faculty2 = new Faculty();
        faculty2.setFacultyName("Informatikos Fakultetas");
        faculty2.setSpecialization("Informacines technologijos");

        Faculty faculty3 = new Faculty();
        faculty3.setFacultyName("Filologijos Fakultetas");
        faculty3.setSpecialization("Filologija");

        FacultyDAO facultyDAO = new FacultyDAO();
        facultyDAO.addFaculty(faculty1);
        facultyDAO.addFaculty(faculty2);
        facultyDAO.addFaculty(faculty3);

  launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
      facultyWindow = primaryStage;
      facultyWindow.setTitle("Faculty Menu");


        TableColumn<Faculty,Integer> facultyIdColumn = new TableColumn<>("Faculty ID");
        facultyIdColumn.setMinWidth(100);
        facultyIdColumn.setCellValueFactory(new PropertyValueFactory<>("facultyId"));

        TableColumn<Faculty,String> facultyNameColumn = new TableColumn<>("Faculty Name");
        facultyNameColumn.setMinWidth(200);
        facultyNameColumn.setCellValueFactory(new PropertyValueFactory<>("facultyName"));

        TableColumn<Faculty,String> facultySpecializationColumn = new TableColumn<>("Faculty Specialization");
        facultySpecializationColumn.setMinWidth(200);
        facultySpecializationColumn.setCellValueFactory(new PropertyValueFactory<>("specialization"));

        facultyNameInput = new TextField();
        facultyNameInput.setPromptText("Faculty Name");
        facultyNameInput.setMinWidth(100);

        facultySpecializationInput = new TextField();
        facultySpecializationInput.setPromptText("Faculty Specialization");
        facultySpecializationInput.setMinWidth(100);

        Button addButton = new Button("Add");
        addButton.setOnAction(event -> addButtonClicked());

        Button deleteButton = new Button("Delete");
       // deleteButton.setOnAction(event -> deleteButtonClicked);
        Button editButton = new Button("Edit");
       // editButton.setOnAction(event -> editButtonClicked);


        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(facultyNameInput,facultySpecializationInput,addButton,deleteButton,editButton);


        facultyTable = new TableView<>();
        facultyTable.setItems(getFaculty());
        facultyTable.getColumns().addAll(facultyIdColumn,facultyNameColumn,facultySpecializationColumn);


        VBox vBox = new VBox();
        vBox.getChildren().addAll(facultyTable,hBox);
        Scene scene = new Scene(vBox);
        facultyWindow.setScene(scene);
        facultyWindow.show();

    }

    public ObservableList<Faculty> getFaculty (){
        ObservableList<Faculty> obsFaculties = FXCollections.observableArrayList();
        FacultyDAO facultyDAO = new FacultyDAO();
        List<Faculty> facultyList = facultyDAO.getFacultyList();
        for (Faculty faculty : facultyList) {
            obsFaculties.add(faculty);
        }return  obsFaculties;
    }

    public void addButtonClicked () {
        Faculty faculty = new Faculty();
        faculty.setFacultyName(facultyNameInput.getText());
        faculty.setSpecialization(facultySpecializationInput.getText());
        FacultyDAO facultyDAO = new FacultyDAO();
        facultyDAO.addFaculty(faculty);
        facultyNameInput.clear();
        facultySpecializationInput.clear();

    }
    public void refreshTable() {
        facultyTable.refresh();
    }
}
