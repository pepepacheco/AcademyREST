package service.enrollment;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.enrollment.EnrollmentDTO;
import model.enrollment.EnrollmentOutputDTO;

/**
 *
 * @author lolo y rafa
 */
public interface EnrollmentResource {
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    List<EnrollmentOutputDTO> getAllEnrollments();
        
    @GET
    @Path("alumno/{dni}")
    @Produces({MediaType.APPLICATION_JSON})
    List<EnrollmentOutputDTO> getEnrollmentByStudentDNI(@PathParam("dni") String dni);
    
    @GET
    @Path("asignatura/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    List<EnrollmentOutputDTO> getEnrollmentBySubjectName(@PathParam("name") String name);
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    List<EnrollmentDTO> addEnrollment(EnrollmentDTO enrollment);
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    Response editEnrollment(EnrollmentDTO enrollment);
    
    @DELETE
    @Path("delete")
    @Produces({MediaType.APPLICATION_JSON})
    List<EnrollmentDTO> deleteEnrollment(@QueryParam("studentId") int studentId, @QueryParam("subjectId") int subjectId);
   
}

