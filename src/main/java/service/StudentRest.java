package service;

import java.util.List;
import javax.ws.rs.Path;
import model.StudentDTO;
import model.StudentImpDAO;

/**
 *
 * @author Rafael Vargas del Moral
 */
@Path("Alumno")
public class StudentRest implements StudenResource {
    StudentImpDAO studenDB = new StudentImpDAO();
    
    @Override
    public List<StudentDTO> getAllStudens() {
        return studenDB.findAll();
    }
    
}
