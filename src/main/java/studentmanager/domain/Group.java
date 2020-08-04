package studentmanager.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;




    @Entity
    @Table(name = "student_group")
    public class Group {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer groupId;
        @Column (name = "group_name")
        private String groupName;
        @Column (name = "academic_year")
        private int academicYear;
        @OneToMany(mappedBy = "group", cascade = CascadeType.REMOVE)
        private Set<Student> students = new HashSet<>();
        @ManyToOne
        @JoinColumn(name = "facultyId")
        private Faculty faculty;

        @ManyToMany
        @JoinTable (name= "join_groups_modules", joinColumns = {@JoinColumn(name="groupId")},
                inverseJoinColumns ={@JoinColumn(name = "moduleId")} )
        private Set<Module> modules = new HashSet<>();

        public Group() {
        }


        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public int getAcademicYear() {
            return academicYear;
        }

        public void setAcademicYear(int academicYear) {
            this.academicYear = academicYear;
        }

        public Set<Student> getStudents() {
            return students;
        }

        public void setStudents(Set<Student> students) {
            this.students = students;
        }

        public Faculty getFaculty() {
            return faculty;
        }

        public void setFaculty(Faculty faculty) {
            this.faculty = faculty;
        }

        public Set<Module> getModules() {
            return modules;
        }

        public void setModules(Set<Module> modules) {
            this.modules = modules;
        }
    }

