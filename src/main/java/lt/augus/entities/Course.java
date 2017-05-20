package lt.augus.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.johnzon.mapper.JohnzonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "COURSE", schema = "public")
@NamedQueries(value = {
        @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
        @NamedQuery(name = "Course.findById", query = "SELECT c FROM Course c WHERE c.id = :id"),
        @NamedQuery(name = "Course.findByName", query = "SELECT c FROM Course c WHERE c.name = :name"),
        @NamedQuery(name = "Course.findByOptLockVersion", query = "SELECT c FROM Course c WHERE c.optLockVersion = :optLockVersion")})
@Getter
@Setter
@EqualsAndHashCode(of = "name")
@ToString(of = {"id", "name"})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Size(min = 4, max = 50)
    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "courseList")
    @JohnzonIgnore
    private List<Student> studentList = new ArrayList<>();

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer optLockVersion;
}
