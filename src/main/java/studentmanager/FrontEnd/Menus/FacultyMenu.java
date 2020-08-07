package studentmanager.FrontEnd.Menus;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.bytebuddy.build.Plugin;
import studentmanager.dao.FacultyDAO;
import studentmanager.domain.Faculty;

import java.util.List;

public class FacultyMenu extends Application {
    Stage facultyWindow;
    TableView<Faculty> facultyTable ;

    public static void main(String[] args) {
      //for test purposes
        Faculty faculty = new Faculty();
        faculty.setFacultyName("statybos fakultetas");
        faculty.setSpecialization("Inzinerija");
        FacultyDAO facultyDAO = new FacultyDAO();
        facultyDAO.addFaculty(faculty);

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

        facultyTable = new TableView<>();
        facultyTable.setItems(getFaculty());
        facultyTable.getColumns().addAll(facultyIdColumn,facultyNameColumn,facultySpecializationColumn);


        VBox vBox = new VBox();
        vBox.getChildren().addAll(facultyTable);
        Scene scene = new Scene(vBox);
        facultyWindow.setScene(scene);
        facultyWindow.show();

    }

    public ObservableList<Faculty> getFaculty (){
        ObservableList<Faculty> obsFaculties = FXCollections.observableArrayList();
        FacultyDAO facultyDAO = new FacultyDAO();
        List<Faculty> facultyList = facultyDAO.getFacultyList();
        for (Faculty faculty : facultyList) {
            faculty.getFacultyId();
            faculty.getFacultyName();
            faculty.getSpecialization();
            obsFaculties.add(faculty);
        }return  obsFaculties;
    }
}
