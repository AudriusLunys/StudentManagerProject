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
import studentmanager.FrontEnd.Alerts.ConfirmBox;
import studentmanager.dao.GroupDAO;
import studentmanager.dao.ModuleDAO;
import studentmanager.domain.Group;
import studentmanager.domain.Module;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ModuleMenu extends Application {

    Stage moduleWindow;
    TableView<Module> moduleTable;
    TextField moduleNameInput, creditsInput, academicHoursInput, moduleIdInput, groupIdInput;
    ObservableList<Module> obsModules = FXCollections.observableArrayList();
    ModuleDAO moduleDAO = new ModuleDAO();

    @Override
    public void start(Stage primaryStage) throws Exception {

        displayModuleMenu(primaryStage);

    }

    public void displayModuleMenu(Stage primaryStage) {
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

        moduleIdInput = new TextField();
        moduleIdInput.setPromptText("Module ID");
        moduleIdInput.setMinWidth(100);

        groupIdInput = new TextField();
        groupIdInput.setPromptText("Group ID");
        groupIdInput.setMinWidth(100);

        Button addButton = new Button("Add");
        addButton.setOnAction(event -> {
            addButtonClicked();
            refreshTable();
        });

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> {
            boolean result = ConfirmBox.display("Confirm", "Delete- are you sure?");
            if (result == true) {
                deleteButtonClicked();
            }
        });

        Button exitButton = new Button("Exit");
        MainMenu mainMenu = new MainMenu();
        exitButton.setOnAction(event -> {
            try {
                mainMenu.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Button assignButton = new Button("Assign");
        assignButton.setOnAction(event -> assignButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(moduleNameInput, creditsInput, academicHoursInput, addButton, deleteButton, exitButton);

        HBox hBox1 = new HBox();
        hBox1.setPadding(new Insets(10, 10, 10, 10));
        hBox1.setSpacing(10);
        hBox1.getChildren().addAll(moduleIdInput, groupIdInput, assignButton);

        moduleTable = new TableView<>();
        moduleTable.setItems(getModule());
        moduleTable.getColumns().addAll(moduleIdColumn, moduleNameColumn, moduleCreditsColumn, academicHoursColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(moduleTable, hBox, hBox1);
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

    public void assignButtonClicked() {
        Module module = moduleDAO.getModule(Integer.parseInt(moduleIdInput.getText()));
        GroupDAO groupDAO = new GroupDAO();
        Set<Group> groupsOfModule = new HashSet<>();
        groupsOfModule.add(groupDAO.getGroup(Integer.parseInt(groupIdInput.getText())));
        module.setGroups(groupsOfModule);
        moduleDAO.updateModule(module);
        moduleIdInput.clear();
        groupIdInput.clear();
    }
}