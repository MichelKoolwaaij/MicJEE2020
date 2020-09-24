package exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by Michel Koolwaaij on 24-09-20.
 */
@Provider
public class StudentNotFoundExceptionMapper implements ExceptionMapper<StudentNotFoundException> {
    @Override
    public Response toResponse(StudentNotFoundException e) {
        return Response.status(404).build();
    }
}
