package studentmanager.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;



    @Entity
    @Table(name = "lecture_module")
    public class Module {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer moduleId;
        @Column (name = "module_name")
        private String moduleName;
        @Column (name = "module_credits")
        private int moduleCredits;
        @Column (name = "academic_hours")
        private int academicHours;

        @ManyToMany
        @JoinTable(name = "join_groups_modules", joinColumns = {@JoinColumn(name = "moduleId")},
                inverseJoinColumns = {@JoinColumn(name = "groupId")})
        private Set<Group> groups = new HashSet<>();

        public Module() {
        }

        public String getModuleName() {
            return moduleName;
        }

        public void setModuleName(String moduleName) {
            this.moduleName = moduleName;
        }

        public int getModuleCredits() {
            return moduleCredits;
        }

        public void setModuleCredits(int moduleCredits) {
            this.moduleCredits = moduleCredits;
        }

        public int getAcademicHours() {
            return academicHours;
        }

        public void setAcademicHours(int academicHours) {
            this.academicHours = academicHours;
        }

        public Set<Group> getGroups() {
            return groups;
        }

        public void setGroups(Set<Group> groups) {
            this.groups = groups;
        }
    }
