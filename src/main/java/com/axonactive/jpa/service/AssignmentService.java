package com.axonactive.jpa.service;

import com.axonactive.jpa.entities.Assignment;

import java.util.List;

public interface AssignmentService {
    Assignment getAssignmentById(int id);
    List<Assignment> getAssignmentByEmployeeId(int employeeId);
    List<Assignment> getAssignmentByProjectId(int projectId);

}
