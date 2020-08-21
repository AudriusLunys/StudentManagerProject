package studentmanager.dao;

import org.junit.jupiter.api.Test;
import studentmanager.domain.Module;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModuleDAOTest {

    private ModuleDAO moduleDAO = new ModuleDAO();
    private Module module = new Module();


    @Test
    void addModule() {
        module.setModuleName("Name");
        module.setAcademicHours(15);
        module.setModuleCredits(55);
        moduleDAO.addModule(module);
        assertNotNull(module);
        assertEquals(module.getModuleName(),"Name");
        assertEquals(module.getAcademicHours(),15);
        assertEquals(module.getModuleCredits(),55);
    }

    @Test
    void getModule() {
        module.setModuleName("Pavadinimas");
        module.setAcademicHours(66);
        module.setModuleCredits(35);
        moduleDAO.addModule(module);
        assertNotNull(module);
        assertEquals(module.getModuleId(),1);
    }

    @Test
    void removeModule() {
    }

    @Test
    void updateModule() {
        module.setModuleName("Pavadinimas");
        module.setAcademicHours(66);
        module.setModuleCredits(35);
        moduleDAO.addModule(module);
        assertNotNull(module);
        if(module.getModuleName()=="Pavadinimas") {
            module=new Module();
            module.setModuleName("Name");
            module.setAcademicHours(26);
            module.setModuleCredits(15);
            moduleDAO.updateModule(module);
            assertNotNull(module);
            assertEquals(module.getModuleName(),"Name");
            assertEquals(module.getAcademicHours(),26);
            assertEquals(module.getModuleCredits(),15);
        }
    }

    @Test
    void getModuleList() {
        module.setModuleName("Name");
        module.setAcademicHours(28);
        module.setModuleCredits(45);
        moduleDAO.addModule(module);
        List<Module> modules = new ArrayList<>();
        modules=moduleDAO.getModuleList();
        assertFalse(modules.isEmpty());
        assertFalse(modules.equals(null));
    }
}