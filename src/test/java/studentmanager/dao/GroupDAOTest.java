package studentmanager.dao;

import org.junit.jupiter.api.Test;
import studentmanager.domain.Faculty;
import studentmanager.domain.Group;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroupDAOTest {

   private GroupDAO groupDAO = new GroupDAO();

    @Test
    void addGroup() {
        Faculty faculty = new Faculty();
        faculty.setFacultyName("TestFaculty");
        faculty.setSpecialization("TestSpec");
        FacultyDAO facultyDAO = new FacultyDAO();
        facultyDAO.addFaculty(faculty);
        Group group = new Group();
        group.setGroupName("test");
        group.setAcademicYear(2015);
        group.setFaculty(faculty);
        groupDAO.addGroup(group);

        assertNotNull(faculty);
        assertNotNull(group);
        assertEquals(group.getGroupName(),"test");
        assertEquals(group.getAcademicYear(),2015);
    }

    @Test
    void getGroup() {
        Faculty faculty = new Faculty();
        faculty.setFacultyName("TestFaculty11");
        faculty.setSpecialization("TestSpec111");
        FacultyDAO facultyDAO = new FacultyDAO();
        facultyDAO.addFaculty(faculty);
        Group group = new Group();
        group.setGroupName("testTest");
        group.setAcademicYear(2018);
        group.setFaculty(faculty);
        groupDAO.addGroup(group);

        assertEquals(group.getGroupId(),1);
    }

    @Test
    void removeGroup() {

    }

    @Test
    void updateGroup() {
        Faculty faculty = new Faculty();
        faculty.setFacultyName("TestF");
        faculty.setSpecialization("TestS");
        FacultyDAO facultyDAO = new FacultyDAO();
        facultyDAO.addFaculty(faculty);
        Group group = new Group();
        group.setGroupName("testGr");
        group.setAcademicYear(2020);
        group.setFaculty(faculty);
        groupDAO.addGroup(group);
        assertNotNull(faculty);
        assertNotNull(group);
        if (group.getGroupName() =="testGr" ) {
            group=new Group();
            group.setGroupName("group1");
            group.setAcademicYear(1983);
            groupDAO.updateGroup(group);
            assertNotNull(group);
            assertEquals(group.getGroupName(),"group1");
        }
    }

    @Test
    void getGroupList() {
        Faculty faculty = new Faculty();
        faculty.setFacultyName("TestF");
        faculty.setSpecialization("TestS");
        FacultyDAO facultyDAO = new FacultyDAO();
        facultyDAO.addFaculty(faculty);
        Group group = new Group();
        group.setGroupName("testGr");
        group.setAcademicYear(2020);
        group.setFaculty(faculty);
        groupDAO.addGroup(group);
        List<Group> groups = new ArrayList<>();
       groups=groupDAO.getGroupList();
        assertFalse(groups.isEmpty());
        assertFalse(groups.equals(null));
    }
}