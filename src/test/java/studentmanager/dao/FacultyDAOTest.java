package studentmanager.dao;

import studentmanager.domain.Faculty;



import static org.junit.jupiter.api.Assertions.*;

class FacultyDAOTest {

    private FacultyDAO facultyDAO = new FacultyDAO();

    @org.junit.jupiter.api.Test
    void addFaculty() {
        Faculty faculty = new Faculty();
        faculty.setFacultyName("TestFaculty");
        faculty.setSpecialization("TestSpec");
        facultyDAO.addFaculty(faculty);
        assertNotNull(faculty);
        assertEquals(faculty.getFacultyName(),"TestFaculty");
        assertEquals(faculty.getSpecialization(),"TestSpec");

    }

    @org.junit.jupiter.api.Test
    void getFaculty() {
        Faculty faculty = new Faculty();
        faculty.setFacultyName("OneFaculty");
        faculty.setSpecialization("BestSpec");
        facultyDAO.addFaculty(faculty);
        assertEquals(faculty.getFacultyId(),1);
    }

    @org.junit.jupiter.api.Test
    void removeFaculty() {
        Faculty faculty = new Faculty();
        faculty.setFacultyName("Test");
        faculty.setSpecialization("TestTest");
        assertNotNull(faculty);
        assertEquals(faculty.getFacultyName(),"Test");
        if (faculty.getFacultyId()!=null) {
            faculty = new Faculty();
            faculty.setFacultyName("");
            faculty.setSpecialization("");
            facultyDAO.updateFaculty(faculty);
            assertNull(faculty);
            assertEquals(faculty.getFacultyName(), "");
        }

    }

    @org.junit.jupiter.api.Test
    void updateFaculty() {
        Faculty faculty = new Faculty();
        faculty.setFacultyName("One");
        faculty.setSpecialization("SpecialOne");
        assertNotNull(faculty);
        if (faculty.getFacultyName()=="One") {
            faculty = new Faculty();
            faculty.setFacultyName("OneTwo");
            faculty.setSpecialization("SpecialOneTwo");
            facultyDAO.updateFaculty(faculty);
            assertNotNull(faculty);
            assertEquals(faculty.getFacultyName(),"OneTwo");
        }
    }

    @org.junit.jupiter.api.Test
    void getFacultyList() {

        }
    }
