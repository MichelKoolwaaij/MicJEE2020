package resources;

import dto.MicStudent;
import services.StudentService;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Michel Koolwaaij on 17-09-20.
 */
@Path("/demo/")
public class MicResource {


    private StudentService service;

    @Inject
    public void setService(StudentService service) {
        this.service = service;
    }

    @Path("test")
    @Produces(MediaType.TEXT_HTML)
    @GET
    public String printHTML(){
        return ("Another cool webpage in OOSE DEA");

    }

    @Path("students")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getJSONStudenten(){
        return Response.ok().entity(service.getStudents()).build();
    }

    @Path("student")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public MicStudent getJSONStudent(@QueryParam("nummer") int nummer){
        return service.getStudent(nummer);
    }

    @Path("student/{nummer}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getJSONStudentPath(@PathParam("nummer") int nummer){
        return Response.ok().entity(service.getStudent(nummer)).build();
    }

    @Path("student/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Response addStudent(MicStudent student){
        service.addStudent(student);
        return Response.status(201).build();
    }

}
