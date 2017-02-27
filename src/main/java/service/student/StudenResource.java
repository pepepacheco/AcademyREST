package service.student;
import javax.ws.rs.Path;
import model.student.StudentDTO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
public interface StudenResource {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    List<StudentDTO> getAllStudens();
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    List<StudentDTO> getStudentById(@PathParam("id") int id);
    
    @GET
    @Path("dni/{dni}")
    @Produces({MediaType.APPLICATION_JSON})
    List<StudentDTO> getStudentByDni(@PathParam("dni") String dni);
    
    @GET
    @Path("nombre/{nombre}")
    @Produces({MediaType.APPLICATION_JSON})
    List<StudentDTO> getStudentBy(@PathParam("nombre") String name);
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    List<StudentDTO> postStudent(StudentDTO student);
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    Response putStudent(StudentDTO student);
    
    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    List<StudentDTO> deleteStudent(@PathParam("id") int id);
    
    
}