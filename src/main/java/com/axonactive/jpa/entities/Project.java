package com.axonactive.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "project")
@NamedQueries({
        @NamedQuery(name = Project.GET_PROJECT, query = "SELECT p FROM Project p"),
        @NamedQuery(name = Project.GET_PROJECT_BY_DEPARTMENT, query = "SELECT p FROM Project p WHERE p.department.id = :departmentId")
})
public class Project {
    private static final String QUALIFIED = "com.axonactive.jpa.entities";
    public static final String GET_PROJECT = QUALIFIED + "getProject";
    public static final String GET_PROJECT_BY_DEPARTMENT = QUALIFIED + "getProjectByDepartment";
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, columnDefinition = "varchar(100)")
    private String name;

    @Column(nullable = false, columnDefinition = "varchar(100)")
    private String area;

    @ManyToOne
    @JoinColumn(name = "managed_department", referencedColumnName = "id")
    private Department department;

}
