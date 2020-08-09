package studentmanager.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.hibernate.Criteria;
import org.hibernate.query.Query;
import studentmanager.FrontEnd.InputGroup;
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

public class Main extends Application {


    public static void main(String[] args) {
      //  launch(args);

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


        System.out.println(groupDAO.getGroupList());

        }






 @Override
  public void start(Stage primaryStage) throws Exception {
          InputGroup inputGroup = new InputGroup();
        inputGroup.start(primaryStage);
    }
}
