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

public class ModuleMenu extends Application {

    Stage moduleWindow;
    TableView<Module> moduleTable;
    TextField moduleNameInput, creditsInput, academicHoursInput;
    ObservableList<Module> obsModules = FXCollections.observableArrayList();
    ModuleDAO moduleDAO = new ModuleDAO();

    public static void main(String[] args) {
        Faculty faculty = new Faculty();
        faculty.setFacultyName("statybos fakultetas");
        faculty.setSpecialization("Inzinerija");
        FacultyDAO facultyDAO = new FacultyDAO();
        facultyDAO.addFaculty(faculty);

        Group group = new Group();
        group.setGroupName("tvg1");
        group.setAcademicYear(2005);
        group.setFaculty(faculty);
        GroupDAO groupDAO = new GroupDAO();
        groupDAO.addGroup(group);

        Set<Group> moduleGroups = new HashSet<>();
        moduleGroups.add(group);

        Module module = new Module();
        module.setModuleName("matematika");
        module.setModuleCredits(50);
        module.setAcademicHours(80);
        module.setGroups(moduleGroups);
        ModuleDAO moduleDAO = new ModuleDAO();
        moduleDAO.addModule(module);

        Student student1 = new Student();
        student1.setFirstName("Donatas");
        student1.setLastName("Pavardenis");
        student1.setEmail("pastas@asde.llt");
        student1.setPhoneNumber("+3746456446");
        student1.setGroup(group);
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.addStudent(student1);

        Student student2 = new Student();
        student2.setFirstName("Audrius");
        student2.setLastName("Lunys");
        student2.setEmail("as@asde.llt");
        student2.setPhoneNumber("+3758954223");
        student2.setGroup(group);
        studentDAO.addStudent(student2);

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        moduleWindow = primaryStage;
        moduleWindow.setTitle("Module Menu");

        TableColumn<Module, Integer> moduleIdColumn = new TableColumn<>("Module ID");
        moduleIdColumn.setMinWidth(100);
        moduleIdColumn.setCellValueFactory(new PropertyValueFactory<>("moduleId"));

        TableColumn<Module, String> moduleNameColumn = new TableColumn<>("Module Name");
        moduleNameColumn.setMinWidth(200);
        moduleNameColumn.setCellValueFactory(new PropertyValueFactory<>("moduleName"));

        TableColumn<Module, Integer> moduleCreditsColumn = new TableColumn<>("Module Credits");
        moduleCreditsColumn.setMinWidth(100);
        moduleCreditsColumn.setCellValueFactory(new PropertyValueFactory<>("moduleCredits"));

        TableColumn<Module, Integer> academicHoursColumn = new TableColumn<>("Academic Hours");
        academicHoursColumn.setMinWidth(100);
        academicHoursColumn.setCellValueFactory(new PropertyValueFactory<>("academicHours"));

        moduleNameInput = new TextField();
        moduleNameInput.setPromptText("Module Name");
        moduleNameInput.setMinWidth(100);

        creditsInput = new TextField();
        creditsInput.setPromptText("Module Credits");
        creditsInput.setMinWidth(100);

        academicHoursInput = new TextField();
        academicHoursInput.setPromptText("Module Hours");
        academicHoursInput.setMinWidth(100);

        Button addButton = new Button("Add");
        addButton.setOnAction(event -> {
            addButtonClicked();
            refreshTable();
        });

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> deleteButtonClicked());
        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> moduleWindow.close());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(moduleNameInput, creditsInput, academicHoursInput, addButton, deleteButton, exitButton);

        moduleTable = new TableView<>();
        moduleTable.setItems(getModule());
        moduleTable.getColumns().addAll(moduleIdColumn, moduleNameColumn, moduleCreditsColumn, academicHoursColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(moduleTable, hBox);
        Scene scene = new Scene(vBox);
        moduleWindow.setScene(scene);
        moduleWindow.show();

    }

    public ObservableList<Module> getModule() {
        List<Module> moduleList = moduleDAO.getModuleList();
        for (Module module : moduleList) {
            obsModules.add(module);
        }
        return obsModules;
    }

    public void addButtonClicked() {
        Module module = new Module();
        module.setModuleName(moduleNameInput.getText());
        module.setModuleCredits(Integer.parseInt(creditsInput.getText()));
        module.setAcademicHours(Integer.parseInt(academicHoursInput.getText()));
        moduleDAO.addModule(module);
        moduleNameInput.clear();
        creditsInput.clear();
        academicHoursInput.clear();

    }

    public void deleteButtonClicked() {
        ObservableList<Module> selectedRows, allModules;
        allModules = moduleTable.getItems();
        selectedRows = moduleTable.getSelectionModel().getSelectedItems();
        for (Module selectedRow : selectedRows) {
            allModules.remove(selectedRow);
            selectedRow = moduleDAO.getModule(selectedRow.getModuleId());
            moduleDAO.removeModule(selectedRow);
        }

    }

    public void refreshTable() {
        obsModules.clear();
        getModule();
        moduleTable.refresh();
    }
}