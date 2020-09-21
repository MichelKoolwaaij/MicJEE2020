package resources;

import dto.MicStudent;
import services.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Michel Koolwaaij on 17-09-20.
 */
@Path("/demo/")
public class MicResource {

    private StudentService service = new StudentService();

    @Path("test")
    @Produces(MediaType.TEXT_HTML)
    @GET
    public String printHTML(){
        return ("Another cool webpage in OOSE DEA");

    }

    @Path("student")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public MicStudent getJSONStudent(){
        return service.getStudent();
    }

}
