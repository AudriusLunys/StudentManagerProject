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
    TableView<Faculty> facultyTable;
    TextField facultyNameInput, facultySpecializationInput;
    ObservableList<Faculty> obsFaculties = FXCollections.observableArrayList();
    FacultyDAO facultyDAO = new FacultyDAO();

    public static void main(String[] args) {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        facultyWindow = primaryStage;
        facultyWindow.setTitle("Faculty Menu");


        TableColumn<Faculty, Integer> facultyIdColumn = new TableColumn<>("Faculty ID");
        facultyIdColumn.setMinWidth(100);
        facultyIdColumn.setCellValueFactory(new PropertyValueFactory<>("facultyId"));

        TableColumn<Faculty, String> facultyNameColumn = new TableColumn<>("Faculty Name");
        facultyNameColumn.setMinWidth(200);
        facultyNameColumn.setCellValueFactory(new PropertyValueFactory<>("facultyName"));

        TableColumn<Faculty, String> facultySpecializationColumn = new TableColumn<>("Faculty Specialization");
        facultySpecializationColumn.setMinWidth(200);
        facultySpecializationColumn.setCellValueFactory(new PropertyValueFactory<>("specialization"));

        facultyNameInput = new TextField();
        facultyNameInput.setPromptText("Faculty Name");
        facultyNameInput.setMinWidth(100);

        facultySpecializationInput = new TextField();
        facultySpecializationInput.setPromptText("Faculty Specialization");
        facultySpecializationInput.setMinWidth(100);

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
        hBox.getChildren().addAll(facultyNameInput, facultySpecializationInput, addButton, deleteButton, exitButton);

        facultyTable = new TableView<>();
        facultyTable.setItems(getFaculty());
        facultyTable.getColumns().addAll(facultyIdColumn, facultyNameColumn, facultySpecializationColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(facultyTable, hBox);
        Scene scene = new Scene(vBox);
        facultyWindow.setScene(scene);
        facultyWindow.show();
    }

    public ObservableList<Faculty> getFaculty() {
        List<Faculty> facultyList = facultyDAO.getFacultyList();
        for (Faculty faculty : facultyList) {
            obsFaculties.add(faculty);
        }
        return obsFaculties;
    }

    public void addButtonClicked() {
        Faculty faculty = new Faculty();
        faculty.setFacultyName(facultyNameInput.getText());
        faculty.setSpecialization(facultySpecializationInput.getText());
        facultyDAO.addFaculty(faculty);
        facultyNameInput.clear();
        facultySpecializationInput.clear();
        // reikia ifo kuris tikrintu textbox inputo ilgi

    }
    public void deleteButtonClicked() {
        ObservableList<Faculty> selectedRows, allFaculties;
        allFaculties = facultyTable.getItems();
        selectedRows = facultyTable.getSelectionModel().getSelectedItems();
        for (Faculty faculty : selectedRows) {
            allFaculties.remove(faculty);
            faculty = facultyDAO.getFaculty(selectedRows.get(0).getFacultyId());
            facultyDAO.removeFaculty(faculty);
        }
    }
    public void refreshTable() {
        obsFaculties.clear();
        getFaculty();
        facultyTable.refresh();
    }
}
