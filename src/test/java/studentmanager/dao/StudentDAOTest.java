package studentmanager.dao;

import org.junit.jupiter.api.Test;
import studentmanager.domain.Student;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {
     private StudentDAO studentDAO = new StudentDAO();
     private Student student = new Student();

    @Test
    void addStudent() {
        student.setFirstName("Jonas");
        student.setLastName("Jonaitis");
        student.setPhoneNumber("35865554");
        student.setEmail("test@test.com");
        studentDAO.addStudent(student);
        assertNotNull(student);
        assertEquals(student.getFirstName(),"Jonas");
        assertEquals(student.getLastName(),"Jonaitis");
        assertEquals(student.getPhoneNumber(),"35865554");
        assertEquals(student.getEmail(),"test@test.com");
    }

    @Test
    void getStudent() {
        student.setFirstName("Jonas");
        student.setLastName("Jonaitis");
        student.setPhoneNumber("35865554");
        student.setEmail("test@test.com");
        studentDAO.addStudent(student);
        assertEquals(student.getStudentId(),1);
    }

    @Test
    void removeStudent() {
    }

    @Test
    void updateStudent() {
        student.setFirstName("Jonas");
        student.setLastName("Jonaitis");
        student.setPhoneNumber("35865554");
        student.setEmail("test@test.com");
        studentDAO.addStudent(student);
        assertNotNull(student);
        if (student.getFirstName()=="Jonas"){
            student=new Student();
            student.setFirstName("Jo");
            student.setLastName("Jon");
            student.setPhoneNumber("54");
            student.setEmail("test.com");
            studentDAO.updateStudent(student);
            assertNotNull(student);
            assertEquals(student.getFirstName(),"Jo");
            assertEquals(student.getLastName(),"Jon");
            assertEquals(student.getPhoneNumber(),"54");
            assertEquals(student.getEmail(),"test.com");
        }
    }

    @Test
    void getStudentList() {
        student.setFirstName("Jon");
        student.setLastName("Petraitis");
        student.setPhoneNumber("5554");
        student.setEmail("test@test.com");
        studentDAO.addStudent(student);
        List<Student> students = new ArrayList<>();
        students = studentDAO.getStudentList();
        assertFalse(students.isEmpty());
        assertFalse(students.equals(null));

    }
}