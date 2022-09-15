package com.kainos.ea.resources;

import com.kainos.ea.db.GetEmployee;
import com.kainos.ea.db.InsertEmployee;
import io.swagger.annotations.Api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
@Api("employee")
public class WebService {

    @GET
    @Path("/getEmployees")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployees() {

        List<Employee> emps = GetEmployee.getEmployees();
        return emps;

    }

    @POST
    @Path("/addEmployees")
    @Consumes(MediaType.APPLICATION_JSON)
    public void getEmployees(List<Employee> employees) {

        InsertEmployee.insertEmployees(employees);

    }
}
