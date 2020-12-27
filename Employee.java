package com.abrahamspw.springhwone.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="emplist")
@NoArgsConstructor
@JsonIgnoreProperties

public class Employee {
    @Id
    @SequenceGenerator(name="student_seq", sequenceName = "student_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    private Long id;
    private String name;
    private String designation;

    /**
    public Employee(String empName, String designation) {
        this.empName = empName;
        this.designation = designation;
    }

    public Employee() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    */

}
