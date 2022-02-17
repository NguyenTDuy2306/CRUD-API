package com.axonactive.jpa.service.impl;

import com.axonactive.jpa.controller.request.ProjectRequest;
import com.axonactive.jpa.entities.Department;
import com.axonactive.jpa.entities.Project;
import com.axonactive.jpa.entities.mapper.ProjectMapper;
import com.axonactive.jpa.service.DepartmentService;
import com.axonactive.jpa.service.ProjectService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
@RequestScoped
@Transactional
public class ProjectServiceImpl implements ProjectService {
//    @Inject
//    ProjectMapper projectMapper;
    @PersistenceContext(unitName = "jpa")
    private EntityManager em;
    @Inject
    DepartmentService departmentService;
    @Override
    public Project getProjectById(int id) {
        return em.find(Project.class, id);
    }

    @Override
    public List<Project> getAllProject() {
//        Query query = em.createQuery("SELECT p FROM Project p", Project.class);
        TypedQuery<Project> query = em.createNamedQuery(Project.GET_PROJECT, Project.class);
        return query.getResultList();
    }

    @Override
    public List<Project> getProjectByDepartmentId(int departmentId) {
        TypedQuery<Project> query = em.createNamedQuery(Project.GET_PROJECT_BY_DEPARTMENT, Project.class);
//        Query query = em.createQuery("SELECT p FROM Project p WHERE p.department.id = :departmentId", Project.class);
        query.setParameter("departmentId", departmentId);
        return query.getResultList();
    }

    @Override
    public Project addProject(int departmentId, ProjectRequest projectRequest) {
//        Project project = projectMapper.projectRequestToProject(projectRequest);
        Project project = new Project();
        project.setArea(projectRequest.getArea());
        project.setName(projectRequest.getName());
        Department department = departmentService.getDepartmentById(departmentId);
        project.setDepartment(department);
        em.persist(project);
        return project;
    }

    @Override
    public void deleteProject(int id) {
        Project project = em.find(Project.class, id);
        if(!Objects.isNull(project)){
            em.remove(project);
        }
    }

    @Override
    public Project updateProject(int projectId,int departmentId,  ProjectRequest projectRequest) {
        Project project = em.find(Project.class, projectId);
        project.setArea(projectRequest.getArea());
        project.setName(projectRequest.getName());
        Department department = departmentService.getDepartmentById(departmentId);
        project.setDepartment(department);
        em.merge(project);
        return project;
    }
}
