package studentmanager.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "faculty")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer facultyId;
    @Column (name = "faculty_name")
    private String facultyName;
    private String specialization;
    @OneToMany(mappedBy = "faculty", cascade = CascadeType.REMOVE)
    private Set<Group> groups=new HashSet<>();


    public Faculty() {
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
