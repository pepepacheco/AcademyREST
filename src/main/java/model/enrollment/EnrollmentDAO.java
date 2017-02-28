package model.enrollment;

import java.util.List;

/**
 *
 * @author Lolo y Rafa
 */
public interface EnrollmentDAO {
    
    List<EnrollmentOutputDTO> findAllEnrollments();
    
    List<EnrollmentOutputDTO> findByStudentDNI(String dni);
    
    List<EnrollmentOutputDTO> findBySubjectName(String name);
    
    List<EnrollmentDTO> addEnrollment(EnrollmentDTO enrollment);
    
    List<EnrollmentDTO> editEnrollment(EnrollmentDTO enrollment);
    
    List<EnrollmentDTO> removeEnrollment(int studentId, int subjectId);
    
}
