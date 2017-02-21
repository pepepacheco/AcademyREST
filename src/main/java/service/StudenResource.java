package service;

import model.StudentDTO;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
 
public interface StudenResource {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    List<StudentDTO> getAllStudens();
    
}