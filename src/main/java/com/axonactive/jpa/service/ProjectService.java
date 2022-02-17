package com.axonactive.jpa.service;

import com.axonactive.jpa.controller.request.ProjectRequest;
import com.axonactive.jpa.entities.Project;

import java.util.List;

public interface ProjectService {
    Project getProjectById(int id);
    List<Project> getAllProject();
    List<Project> getProjectByDepartmentId(int departmentId);
    Project addProject(int departmentId, ProjectRequest projectRequest);
    void deleteProject(int id);
    Project updateProject(int id,int departmentId, ProjectRequest projectRequest);
}
