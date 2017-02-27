package model.student;

import java.util.List;

/**
 *
 * @author Rafael Vargas del Moral
 */

public interface StudentDAO {
    List<StudentDTO> findAll();
    
    List<StudentDTO> findById(int id);
    
    List<StudentDTO> findByDni(String dni);
    
    List<StudentDTO> findByName(String name);
    
    List<StudentDTO> addStudent(StudentDTO student);
    
    List<StudentDTO> editStudent(StudentDTO student);
    
    List<StudentDTO> removeStudent(int id);
    
}
