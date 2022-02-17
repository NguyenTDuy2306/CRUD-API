package com.axonactive.jpa.service.impl;

import com.axonactive.jpa.controller.request.DepartmentRequest;
import com.axonactive.jpa.entities.Department;
import com.axonactive.jpa.service.DepartmentService;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@RequestScoped
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @PersistenceContext(unitName = "jpa")
    private EntityManager em;

    @Override
    public Department getDepartmentById(int id) {
        return em.find(Department.class,id);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Department addDepartment(DepartmentRequest departmentRequest) {
        Department department = new Department();
        department.setName(departmentRequest.getName());
        department.setStartDate(departmentRequest.getStartDate());

        em.persist(department);
        return department;
    }

    @Override
    public List<Department> getAllDepartment() {
        return em.createQuery("SELECT d FROM Department d",Department.class).getResultList();
    }

    @Override
    public void deleteDepartmentById(int id) {
        Department department = em.find(Department.class, id);
        if(!Objects.isNull(department)) {
            em.remove(department);
        }
    }

    @Override
    public Department updateDepartment(int id, DepartmentRequest departmentRequest) {
        Department department = em.find(Department.class, id);
        department.setName(departmentRequest.getName());
        department.setStartDate(departmentRequest.getStartDate());
        return em.merge(department);
    }
}
