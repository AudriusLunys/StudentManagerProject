package studentmanager.utils;

import studentmanager.dao.FacultyDAO;
import studentmanager.dao.GroupDAO;
import studentmanager.dao.ModuleDAO;
import studentmanager.dao.StudentDAO;
import studentmanager.domain.Faculty;
import studentmanager.domain.Group;
import studentmanager.domain.Module;
import studentmanager.domain.Student;

public class InitData {

    public void loadInitData () {

        // for test purposes
        Faculty faculty1 = new Faculty();
        faculty1.setFacultyName("Statybos Fakultetas");
        faculty1.setSpecialization("Inzinerija");

        Faculty faculty2 = new Faculty();
        faculty2.setFacultyName("Filologijos Fakultetas");
        faculty2.setSpecialization("Filologija");

        Faculty faculty3 = new Faculty();
        faculty3.setFacultyName("Teises Fakultetas");
        faculty3.setSpecialization("Teise");

        Group group1 = new Group();
        group1.setGroupName("Statyba1");
        group1.setAcademicYear(2019);
        group1.setFaculty(faculty1);

        Group group2 = new Group();
        group2.setGroupName("Civ. Teise");
        group2.setAcademicYear(2018);
        group2.setFaculty(faculty3);

        Group group3 = new Group();
        group3.setGroupName("Anglu Filologija");
        group3.setAcademicYear(2020);
        group3.setFaculty(faculty2);

        FacultyDAO facultyDAO = new FacultyDAO();
        facultyDAO.addFaculty(faculty1);
        facultyDAO.addFaculty(faculty2);
        facultyDAO.addFaculty(faculty3);

        GroupDAO groupDAO = new GroupDAO();
        groupDAO.addGroup(group1);
        groupDAO.addGroup(group2);
        groupDAO.addGroup(group3);

        Student student1 = new Student();
        student1.setFirstName("Vacys");
        student1.setLastName("Maslionka");
        student1.setEmail("vacys@gmail.com");
        student1.setPhoneNumber("+3705589452");
        student1.setGroup(group1);

        Student student2 = new Student();
        student2.setFirstName("Jonas");
        student2.setLastName("Jonka");
        student2.setEmail("Jonka2000@gmail.com");
        student2.setPhoneNumber("+3705587852");
        student2.setGroup(group1);

        Student student3 = new Student();
        student3.setFirstName("Ona");
        student3.setLastName("Variene");
        student3.setEmail("OnaV@inbox.com");
        student3.setPhoneNumber("+370119452");
        student3.setGroup(group2);

        Student student4 = new Student();
        student4.setFirstName("Zuzana");
        student4.setLastName("Preilyte");
        student4.setEmail("Zp@yahoo.com");
        student4.setPhoneNumber("+370558466");
        student4.setGroup(group3);

        Student student5 = new Student();
        student5.setFirstName("Aldute");
        student5.setLastName("Maziene");
        student5.setEmail("AMZ@yahoo.com");
        student5.setPhoneNumber("+371558466");
        student5.setGroup(group3);

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.addStudent(student1);
        studentDAO.addStudent(student2);
        studentDAO.addStudent(student3);
        studentDAO.addStudent(student4);
        studentDAO.addStudent(student5);

        Module module1 = new Module();
        module1.setModuleName("Matematika");
        module1.setModuleCredits(89);
        module1.setAcademicHours(50);

        Module module2 = new Module();
        module2.setModuleName("Filosofija");
        module2.setModuleCredits(20);
        module2.setAcademicHours(30);

        Module module3 = new Module();
        module3.setModuleName("Teise");
        module3.setModuleCredits(70);
        module3.setAcademicHours(145);
        ModuleDAO moduleDAO = new ModuleDAO();
        moduleDAO.addModule(module1);
        moduleDAO.addModule(module2);
        moduleDAO.addModule(module3);
    }
}
