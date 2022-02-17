package com.axonactive.jpa.service.impl;

import com.axonactive.jpa.entities.Assignment;
import com.axonactive.jpa.service.AssignmentService;
import com.axonactive.jpa.service.EmployeeService;
import com.axonactive.jpa.service.ProjectService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
@RequestScoped
@Transactional
public class AssignmentServiceImpl implements AssignmentService {
    @Inject
    EmployeeService employeeService;
    @Inject
    ProjectService projectService;
    @PersistenceContext(unitName = "jpa")
    private EntityManager em;
    @Override
    public Assignment getAssignmentById(int id) {
        return em.find(Assignment.class, id);
    }

    @Override
    public List<Assignment> getAssignmentByEmployeeId(int employeeId) {
        Query query = em.createQuery("SELECT a FROM Assignment WHERE a.employee.id =: employeeId", Assignment.class);
        query.setParameter("employeeId", employeeId);
        return query.getResultList();
    }

    @Override
    public List<Assignment> getAssignmentByProjectId(int projectId) {
        Query query = em.createQuery("SELECT a FROM Assignment WHERE a.project.id =: projectId", Assignment.class);
        query.setParameter("projectId", projectId);
        return query.getResultList();
    }
}
