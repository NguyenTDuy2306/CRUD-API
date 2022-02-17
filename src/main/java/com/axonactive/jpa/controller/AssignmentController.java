package com.axonactive.jpa.controller;
import com.axonactive.jpa.service.AssignmentService;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Transactional
@Produces(MediaType.APPLICATION_JSON)
@Path("/assignments")
public class AssignmentController {
    @Inject
    AssignmentService assignmentService;

    @GET
    public Response getAssignmentById(@QueryParam("id") int id){
        return Response.ok(assignmentService.getAssignmentById(id)).build();
    }
    @GET
    public Response getAssignmentByProjectId(@QueryParam("projectId") int projectId){
        return Response.ok(assignmentService.getAssignmentByProjectId(projectId)).build();
    }

    @GET
    public Response getAssignmentByEmployeeId(@QueryParam("employeeId") int employeeId){
        return Response.ok(assignmentService.getAssignmentByEmployeeId(employeeId)).build();
    }
}
