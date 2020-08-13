package studentmanager.FrontEnd.Menus;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import studentmanager.dao.FacultyDAO;
import studentmanager.dao.GroupDAO;
import studentmanager.domain.Faculty;
import studentmanager.domain.Group;

import java.util.List;

public class GroupMenu extends Application {
    Stage groupWindow;
    TableView<Group> groupTable;
    TextField groupNameInput, academicYearInput, facultyIdInput;
    ChoiceBox facultySelect;
    ObservableList<Group> obsGroups = FXCollections.observableArrayList();
    GroupDAO groupDAO = new GroupDAO();

    public static void main(String[] args) {

    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        groupWindow = primaryStage;
        groupWindow.setTitle("Group Menu");

        TableColumn<Group, Integer> groupIdColumn = new TableColumn<>("Group ID");
        groupIdColumn.setMinWidth(100);
        groupIdColumn.setCellValueFactory(new PropertyValueFactory<>("groupId"));

        TableColumn<Group, String> groupNameColumn = new TableColumn<>("Group Name");
        groupNameColumn.setMinWidth(150);
        groupNameColumn.setCellValueFactory(new PropertyValueFactory<>("groupName"));

        TableColumn<Group, Integer> academicYearColumn = new TableColumn<>("Academic Year");
        academicYearColumn.setMinWidth(100);
        academicYearColumn.setCellValueFactory(new PropertyValueFactory<>("academicYear"));

        //   TableColumn<Group, Integer> facultyIdColumn = new TableColumn<>("faculty ID");
        //  facultyIdColumn.setMinWidth(100);
        //   facultyIdColumn.setCellValueFactory(new PropertyValueFactory<>("faculty"));
        //   facultyIdColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Group, Integer>, ObservableValue<Integer>>() {
        //      @Override
        //       public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Group, Integer> param) {
        //           return new SimpleObjectProperty<>(param.getValue().getFaculty().getFacultyId());
        //      }
        //    });
        // TableColumn<Group, String> facultyNameColumn = new TableColumn<>("faculty Name");
        // facultyNameColumn.setMinWidth(200);
        //   facultyNameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Group, String>, ObservableValue<String>>() {
        //     @Override
        //     public ObservableValue<String> call(TableColumn.CellDataFeatures<Group, String> param) {
        //         return new SimpleObjectProperty(param.getValue().getFaculty().getFacultyName());
        //      }
        //   });

        groupNameInput = new TextField();
        groupNameInput.setPromptText("Group Name");
        groupNameInput.setMinWidth(100);

        academicYearInput = new TextField();
        academicYearInput.setPromptText("Academic year");
        academicYearInput.setMinWidth(50);

        facultyIdInput = new TextField();
        facultyIdInput.setPromptText("Faculty ID");
        academicYearInput.setMinWidth(50);

        Button addButton = new Button("Add");
        addButton.setOnAction(event -> {
            addButtonClicked();
            refreshTable();
        });

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> deleteButtonClicked());

        Button exitButton = new Button("Exit");
        MainMenu mainMenu = new MainMenu();
        exitButton.setOnAction(event -> {
            try {
                mainMenu.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(groupNameInput, academicYearInput, facultyIdInput, addButton, deleteButton, exitButton);

        groupTable = new TableView<>();
        groupTable.setItems(getGroup());
        groupTable.getColumns().addAll(groupIdColumn, groupNameColumn, academicYearColumn);  //facultyNameColumn,  facultyIdColumn

        VBox vBox = new VBox();
        vBox.getChildren().addAll(groupTable, hBox);
        Scene scene = new Scene(vBox);
        groupWindow.setScene(scene);
        groupWindow.show();
    }

    public ObservableList<Group> getGroup() {
        GroupDAO groupDAO = new GroupDAO();
        List<Group> groupList = groupDAO.getGroupList();
        for (Group group : groupList) {
            obsGroups.add(group);
        }
        return obsGroups;
    }


    public void addButtonClicked() {
        Group group = new Group();
        Faculty faculty;
        FacultyDAO facultyDAO = new FacultyDAO();
        group.setGroupName(groupNameInput.getText());
        group.setAcademicYear(Integer.parseInt(academicYearInput.getText()));
        faculty = facultyDAO.getFaculty(Integer.parseInt(facultyIdInput.getText()));
        group.setFaculty(faculty);
        groupDAO.addGroup(group);
        groupNameInput.clear();
        academicYearInput.clear();
        facultyIdInput.clear();
    }


    public void deleteButtonClicked() {
        ObservableList<Group> selectedRows, allGroups;
        allGroups = groupTable.getItems();
        selectedRows = groupTable.getSelectionModel().getSelectedItems();
        for (Group selectedRow : selectedRows) {
            allGroups.remove(selectedRow);
            selectedRow = groupDAO.getGroup(selectedRow.getGroupId());
            groupDAO.removeGroup(selectedRow);
        }

    }


    public void refreshTable() {
        obsGroups.clear();
        getGroup();
        groupTable.refresh();
    }
}