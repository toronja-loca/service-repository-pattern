package models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Data
@Entity
@Table(name = "registerTable")
public class Register {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "studentId")
    private int studentId;
    @Column(name = "discipline")
    private String discipline;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Register register = (Register) o;
        return id == register.id && studentId == register.studentId && Objects.equals(discipline, register.discipline);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, studentId, discipline);
    }

    public Register(int id, int studentId, String discipline) {
        this.id = id;
        this.studentId = studentId;
        this.discipline = discipline;
    }

    public Register() {
    }
}
