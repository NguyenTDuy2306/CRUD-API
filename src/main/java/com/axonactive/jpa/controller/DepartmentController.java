package com.axonactive.jpa.controller;

import com.axonactive.jpa.controller.request.DepartmentRequest;
import com.axonactive.jpa.service.DepartmentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Produces(MediaType.APPLICATION_JSON)
@Path("/departments")
public class DepartmentController {
    //CDI, Autowired
    @Inject
    private DepartmentService departmentService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartmentById(@PathParam("id") int id) {
        return Response.ok(departmentService.getDepartmentById(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addDepartment(DepartmentRequest department) {
        return Response.ok(departmentService.addDepartment(department)).build();
    }

    @GET
    public Response getAllDepartments(){
        return Response.ok(departmentService.getAllDepartment()).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDepartment(@PathParam("id") int id){
        departmentService.deleteDepartmentById(id);
        return Response.ok().build();
    }

    @PUT
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response updateDepart(@PathParam("id") int id, DepartmentRequest departmentRequest){
        return Response.ok(departmentService.updateDepartment(id, departmentRequest)).build();
    }

}
