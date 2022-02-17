package com.axonactive.jpa.controller;

import com.axonactive.jpa.controller.request.ProjectRequest;
import com.axonactive.jpa.service.ProjectService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Path("/departments/{departmentId}/projects")
@Transactional
public class ProjectController {
    @Inject
    private ProjectService projectService;

    @GET
    @Path("/{id}")
    public Response getProjectById(@PathParam("id") int id){
        return Response.ok(projectService.getProjectById(id)).build();
    }

    @GET
    public Response getProjectById(){
        return Response.ok(projectService.getAllProject()).build();
    }
    @GET
    @Path("/search")
    public Response getProjectByDepartmentId(@QueryParam("departmentId") int departmentId){
        return Response.ok(projectService.getProjectByDepartmentId(departmentId)).build();
    }

    @POST
    public Response addProject(@PathParam("departmentId") int departmentId, ProjectRequest projecrRequest){
        return  Response.ok(projectService.addProject(departmentId, projecrRequest)).build();
    }

    @DELETE
    @Path("/{projectId}")
    public  Response deleteProject(@PathParam("projectId") int id){
        projectService.deleteProject(id);
        return Response.ok().build();
    }
    @PUT
    @Path("/{projectId}")
    public Response updateProject(@PathParam("projectId") int projectId, @QueryParam("departmentId") int departmentId, ProjectRequest projectRequest){
        return Response.ok(projectService.updateProject(projectId,departmentId,projectRequest)).build();
    }

}
