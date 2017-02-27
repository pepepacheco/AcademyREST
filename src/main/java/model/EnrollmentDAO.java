/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author rafa
 */
public interface EnrollmentDAO {
    
    List<EnrollmentOutputDTO> findAllEnrollments();
    
    List<EnrollmentOutputDTO> findByStudentDNI(String dni);
    
    List<EnrollmentOutputDTO> findBySubjectName(String name);
    
    List<EnrollmentDTO> addEnrollment(EnrollmentDTO enrollment);
    
    List<EnrollmentDTO> editEnrollment(EnrollmentDTO enrollment);
    
    List<EnrollmentDTO> removeEnrollment(int studentId, int subjectId);
    
}
