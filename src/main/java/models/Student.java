package models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Data
@Entity
@Table(name = "studenttable")
public class Student {
    @Id
    @Column(name="id")
    private int id ;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="groupNum")
    private int groupNum;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && groupNum == student.groupNum && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, groupNum);
    }

    public Student(int id, String firstName, String lastName, int groupNum) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.groupNum = groupNum;
    }

    public Student() {

    }
}
