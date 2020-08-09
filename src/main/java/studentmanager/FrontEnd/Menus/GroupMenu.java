package studentmanager.FrontEnd.Menus;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
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
import javafx.util.Callback;
import studentmanager.dao.FacultyDAO;
import studentmanager.dao.GroupDAO;
import studentmanager.domain.Faculty;
import studentmanager.domain.Group;

import java.util.List;

public class GroupMenu extends Application {
    Stage groupWindow;
    TableView<Group> groupTable;
    TextField groupNameInput, academicYearInput;
    ObservableList<Group> obsGroups = FXCollections.observableArrayList();

    public static void main(String[] args) {

        // for test purposes
        Faculty faculty1 = new Faculty();
        faculty1.setFacultyName("Statybos Fakultetas");
        faculty1.setSpecialization("Inzinerija");

        Group group1 = new Group();
        group1.setGroupName("STV2019");
        group1.setAcademicYear(2019);
        group1.setFaculty(faculty1);

        Group group2 = new Group();
        group2.setGroupName("STA2018");
        group2.setAcademicYear(2018);
        group2.setFaculty(faculty1);

        FacultyDAO facultyDAO = new FacultyDAO();
        facultyDAO.addFaculty(faculty1);
        GroupDAO groupDAO= new GroupDAO();
        groupDAO.addGroup(group1);
        groupDAO.addGroup(group2);

        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        groupWindow = primaryStage;
        groupWindow.setTitle("Group Menu");

        TableColumn<Group, Integer> groupIdColumn = new TableColumn<>("Group ID");
        groupIdColumn.setMinWidth(100);
        groupIdColumn.setCellValueFactory(new PropertyValueFactory<>("groupId"));

        TableColumn<Group, String> groupNameColumn = new TableColumn<>("Group Name");
        groupNameColumn.setMinWidth(200);
        groupNameColumn.setCellValueFactory(new PropertyValueFactory<>("groupName"));

        TableColumn<Group, Integer> academicYearColumn = new TableColumn<>("Academic Year");
        academicYearColumn.setMinWidth(200);
        academicYearColumn.setCellValueFactory(new PropertyValueFactory<>("academicYear"));

        //sitas abejotinas ar reikia
       TableColumn<Group, Integer> facultyIdColumn = new TableColumn<>("Faculty ID");
       facultyIdColumn.setMinWidth(100);
       facultyIdColumn.setCellValueFactory();




        groupNameInput = new TextField();
        groupNameInput.setPromptText("Group Name");
        groupNameInput.setMinWidth(100);

        academicYearInput = new TextField();
        academicYearInput.setPromptText("Academic year");
        academicYearInput.setMinWidth(100);

        Button addButton = new Button("Add");
        Button deleteButton = new Button("Delete");
        Button exitButton = new Button("Exit");

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(groupNameInput,academicYearInput,addButton,deleteButton,exitButton);

        groupTable = new TableView<>();
        groupTable.setItems(getGroup());
        groupTable.getColumns().addAll(groupIdColumn, groupNameColumn, academicYearColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(groupTable, hBox);
        Scene scene = new Scene(vBox);
        groupWindow.setScene(scene);
        groupWindow.show();
    }

    public ObservableList<Group> getGroup() {
        GroupDAO groupDAO = new GroupDAO();
        List<Group> groupList = groupDAO.getGroupList();
        for (Group group: groupList) {
            obsGroups.add(group);
        }
        return obsGroups;
    }
}
