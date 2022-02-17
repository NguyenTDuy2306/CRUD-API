package com.axonactive.jpa.controller;

import com.axonactive.jpa.controller.request.EmployeeRequest;
import com.axonactive.jpa.enumerate.Gender;
import com.axonactive.jpa.service.EmployeeService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Path("/departments/{departmentId}/employees")
@Transactional
public class EmployeeController {
    @Inject
    private EmployeeService employeeService;

    @GET
    @Path("/{id}")
    public Response getEmployeeByID(@PathParam("id") int id){
        return Response.ok(employeeService.getEmployeeById(id)).build();
    }

    @GET
    public Response getEmployeeByDepartment(@PathParam("departmentId") int departmentId){
        return Response.ok(employeeService.getEmployeeByDepartment(departmentId)).build();
    }

    @POST
    public Response addEmployee(@PathParam("departmentId") int departmentId, EmployeeRequest employeeRequest){
        return Response.ok(employeeService.addEmployee(departmentId, employeeRequest)).build();
    }

    @PUT
    @Path("/{employeeId}")
    public Response updateEmployee(@PathParam("employeeId") int employeeId, EmployeeRequest employeeRequest)
    {
        return Response.ok(employeeService.updateEmployee(employeeId, employeeRequest)).build();
    }

    @GET
    @Path("/search")
    public  Response getEmployeeByGender(@QueryParam("gender")Gender gender){
        return Response.ok(employeeService.getEmployeeByGender(gender)).build();
    }
    @GET
    @Path("/search-age")
    public Response getEmployeeByAge(@QueryParam("age") int age){
        return Response.ok(employeeService.getEmployeeByAge(age)).build();
    }

}
