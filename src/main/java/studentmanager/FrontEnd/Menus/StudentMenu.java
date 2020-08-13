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
import studentmanager.dao.GroupDAO;
import studentmanager.dao.ModuleDAO;
import studentmanager.dao.StudentDAO;
import studentmanager.domain.Faculty;
import studentmanager.domain.Group;
import studentmanager.domain.Module;
import studentmanager.domain.Student;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentMenu extends Application {

    Stage studentWindow;
    TableView<Student> studentTable;
    TextField firstNameInput, lastNameInput, phoneNumberInput, emailInput, groupIdInput;
    ObservableList<Student> obsStudents = FXCollections.observableArrayList();
    StudentDAO studentDAO = new StudentDAO();

    public static void main(String[] args) {

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        studentWindow = primaryStage;
        studentWindow.setTitle("Student Menu");

        TableColumn<Student, Integer> studentIdColumn = new TableColumn<>("Student ID");
        studentIdColumn.setMinWidth(100);
        studentIdColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));

        TableColumn<Student, String> firstNameColumn = new TableColumn<>("FirstName");
        firstNameColumn.setMinWidth(150);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Student, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setMinWidth(150);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Student, String> phoneColumn = new TableColumn<>("Phone Number");
        phoneColumn.setMinWidth(150);
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        TableColumn<Student, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setMinWidth(150);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));


        firstNameInput = new TextField();
        firstNameInput.setPromptText("First Name");
        firstNameInput.setMinWidth(100);

        lastNameInput = new TextField();
        lastNameInput.setPromptText("Last Name");
        lastNameInput.setMinWidth(100);

        phoneNumberInput = new TextField();
        phoneNumberInput.setPromptText("Phone Number");
        phoneNumberInput.setMinWidth(100);

        emailInput = new TextField();
        emailInput.setPromptText("Email Number");
        emailInput.setMinWidth(100);

        groupIdInput = new TextField();
        groupIdInput.setPromptText("Group ID");
        groupIdInput.setMinWidth(100);


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
        hBox.getChildren().addAll(firstNameInput, lastNameInput, phoneNumberInput, emailInput, groupIdInput, addButton, deleteButton, exitButton);

        studentTable = new TableView<>();
        studentTable.setItems(getStudent());
        studentTable.getColumns().addAll(studentIdColumn, firstNameColumn, lastNameColumn, phoneColumn, emailColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(studentTable, hBox);
        Scene scene = new Scene(vBox);
        studentWindow.setScene(scene);
        studentWindow.show();
    }

    public void addButtonClicked() {
        Student student = new Student();
        student.setFirstName(firstNameInput.getText());
        student.setLastName(lastNameInput.getText());
        student.setPhoneNumber(phoneNumberInput.getText());
        student.setEmail(emailInput.getText());
        Group group = new Group();
        GroupDAO groupDAO = new GroupDAO();
        group = groupDAO.getGroup(Integer.parseInt(groupIdInput.getText()));
        student.setGroup(group);
        studentDAO.addStudent(student);
        firstNameInput.clear();
        lastNameInput.clear();
        phoneNumberInput.clear();
        emailInput.clear();

    }

    public void deleteButtonClicked() {
        ObservableList<Student> selectedRows, allStudents;
        allStudents = studentTable.getItems();
        selectedRows = studentTable.getSelectionModel().getSelectedItems();
        for (Student selectedRow : selectedRows) {
            allStudents.remove(selectedRow);
            selectedRow = studentDAO.getStudent(selectedRow.getStudentId());
            studentDAO.removeStudent(selectedRow);
        }

    }


    public ObservableList<Student> getStudent() {
        List<Student> studentList = studentDAO.getStudentList();
        for (Student student : studentList) {
            obsStudents.add(student);
        }
        return obsStudents;
    }

    public void refreshTable() {
        obsStudents.clear();
        getStudent();
        studentTable.refresh();
    }
}
