package service.student;

import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import model.student.StudentDTO;
import model.student.StudentImpDAO;

/**
 *
 * @author Rafael Vargas del Moral
 */
@Path("Alumno")
public class StudentRest implements StudenResource {
    StudentImpDAO studentDB = new StudentImpDAO();
    
    @Override
    public List<StudentDTO> getAllStudens() {
        return studentDB.findAll();
    }
    
    @Override
    public List<StudentDTO> getStudentById(int id) {
        return studentDB.findById(id);
    }

    @Override
    public List<StudentDTO> getStudentByDni(String dni) {
        return studentDB.findByDni(dni);
    }

    @Override
    public List<StudentDTO> getStudentBy(String name) {
        return studentDB.findByName(name);
    }

    @Override
    public List<StudentDTO> postStudent(StudentDTO student) {
        return studentDB.addStudent(student);
    }

    @Override
    public Response putStudent(StudentDTO student) {
        List<StudentDTO> listStudent = studentDB.editStudent(student);
        
        switch (StudentImpDAO.putStatus) {
            case 200:
                return Response.status(200).entity(listStudent).build();
            case 201:
                return Response.status(201).entity(listStudent).build();
            default:
                return Response.status(500).entity(listStudent).build();
        } 
    }

    @Override
    public List<StudentDTO> deleteStudent(int id) {
        return studentDB.removeStudent(id);
    }
}
