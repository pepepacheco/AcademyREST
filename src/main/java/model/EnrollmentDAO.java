/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Lolo
 */
public interface EnrollmentDAO {
    List<EnrollmentOutputDTO> findAllEnrollments();
    
    List<EnrollmentDTO> findEnrollmentByStudentDni(String dni);
    
    List<EnrollmentDTO> findEnrollmentBySubjectName(String name);
    
    List<EnrollmentDTO> addEnrollment(EnrollmentDTO subject);
    
    List<EnrollmentDTO> editEnrollment(EnrollmentDTO subject);
    
    List<EnrollmentDTO> removeEnrollment(int studentId, int subjectId);
}
