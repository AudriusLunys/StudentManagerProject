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

    public void loadInitData() {

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

        Faculty faculty4 = new Faculty();
        faculty4.setFacultyName("Technologiju Fakultetas");
        faculty4.setSpecialization("IT technologijos");


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

        Group group4 = new Group();
        group4.setGroupName("Prancuzu Filologija");
        group4.setAcademicYear(2017);
        group4.setFaculty(faculty2);

        Group group5 = new Group();
        group5.setGroupName("Inf. Technologijos");
        group5.setAcademicYear(2020);
        group5.setFaculty(faculty4);

        Group group6 = new Group();
        group6.setGroupName("Baudziamoji Teise");
        group6.setAcademicYear(2019);
        group6.setFaculty(faculty3);

        FacultyDAO facultyDAO = new FacultyDAO();
        facultyDAO.addFaculty(faculty1);
        facultyDAO.addFaculty(faculty2);
        facultyDAO.addFaculty(faculty3);
        facultyDAO.addFaculty(faculty4);

        GroupDAO groupDAO = new GroupDAO();
        groupDAO.addGroup(group1);
        groupDAO.addGroup(group2);
        groupDAO.addGroup(group3);
        groupDAO.addGroup(group4);
        groupDAO.addGroup(group5);
        groupDAO.addGroup(group6);

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

        Student student6 = new Student();
        student6.setFirstName("Zita");
        student6.setLastName("Zvonke");
        student6.setEmail("Zvonke@yahoo.com");
        student6.setPhoneNumber("+37166666");
        student6.setGroup(group4);

        Student student7 = new Student();
        student7.setFirstName("Algirdas-Mykolas");
        student7.setLastName("Brazauskas");
        student7.setEmail("AMB@yandex.ru");
        student7.setPhoneNumber("+370568466");
        student7.setGroup(group1);

        Student student8 = new Student();
        student8.setFirstName("Saulius");
        student8.setLastName("Varnelis");
        student8.setEmail("sv2020@gmail.com");
        student8.setPhoneNumber("+378999632");
        student8.setGroup(group6);

        Student student9 = new Student();
        student9.setFirstName("Vincas");
        student9.setLastName("Odetonevicius");
        student9.setEmail("Vincuxxx@yahoo.com");
        student9.setPhoneNumber("+374785552");
        student9.setGroup(group5);

        Student student10 = new Student();
        student10.setFirstName("Ruta");
        student10.setLastName("Valentaviciute");
        student10.setEmail("RutaV@mailbox.lt");
        student10.setPhoneNumber("+3702228965");
        student10.setGroup(group6);

        Student student11 = new Student();
        student11.setFirstName("Edita");
        student11.setLastName("Mikolaite");
        student11.setEmail("edm@delfi.lt");
        student11.setPhoneNumber("+3702564782");
        student11.setGroup(group3);

        Student student12 = new Student();
        student12.setFirstName("Zilvinas");
        student12.setLastName("Zvengulis");
        student12.setEmail("zigulys@yahoo.com");
        student12.setPhoneNumber("+370525552");
        student12.setGroup(group1);

        Student student13 = new Student();
        student13.setFirstName("Natalija");
        student13.setLastName("Grabnickaite");
        student13.setEmail("granata@gmail.com");
        student13.setPhoneNumber("+370085852");
        student13.setGroup(group2);

        Student student14 = new Student();
        student14.setFirstName("Bair");
        student14.setLastName("Grill");
        student14.setEmail("Grillxx@gmail.com");
        student14.setPhoneNumber("+375056322");
        student14.setGroup(group3);

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.addStudent(student1);
        studentDAO.addStudent(student2);
        studentDAO.addStudent(student3);
        studentDAO.addStudent(student4);
        studentDAO.addStudent(student5);
        studentDAO.addStudent(student6);
        studentDAO.addStudent(student7);
        studentDAO.addStudent(student8);
        studentDAO.addStudent(student9);
        studentDAO.addStudent(student10);
        studentDAO.addStudent(student11);
        studentDAO.addStudent(student12);
        studentDAO.addStudent(student13);
        studentDAO.addStudent(student14);

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

        Module module4 = new Module();
        module4.setModuleName("Teorine Mechanika");
        module4.setModuleCredits(89);
        module4.setAcademicHours(200);

        Module module5 = new Module();
        module5.setModuleName("Programaivimo Pagrindai");
        module5.setModuleCredits(760);
        module5.setAcademicHours(120);

        Module module6 = new Module();
        module6.setModuleName("Prancuzu kalba");
        module6.setModuleCredits(70);
        module6.setAcademicHours(160);

        ModuleDAO moduleDAO = new ModuleDAO();
        moduleDAO.addModule(module1);
        moduleDAO.addModule(module2);
        moduleDAO.addModule(module3);
        moduleDAO.addModule(module4);
        moduleDAO.addModule(module5);
        moduleDAO.addModule(module6);
    }
}
