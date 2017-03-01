/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import model.EnrollmentDTO;
import model.EnrollmentImpDAO;
import model.EnrollmentOutputDTO;


/**
 *
 * @author Lolo
 */
@Path("Matricula")
public class EnrollmentRest implements EnrollmentResource{
    EnrollmentImpDAO enrollment = new EnrollmentImpDAO();

    @Override
    public List<EnrollmentOutputDTO> getAllEnrollments() {
        return enrollment.findAllEnrollments();
    }

    @Override
    public List<EnrollmentOutputDTO> findEnrollmentByStudentDni(String dni) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EnrollmentDTO> findEnrollmentBySubjectName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EnrollmentDTO> addEnrollment(EnrollmentDTO e) {
        return enrollment.addEnrollment(e);
    }

    @Override
    public Response editEnrollment(EnrollmentDTO enrollment) {
        List<EnrollmentDTO> listEnrollment = this.enrollment.editEnrollment(enrollment);
        
        switch(EnrollmentImpDAO.putStatus){
            case 200:
                return Response.status(200).entity(listEnrollment).build();
            case 201:
                return Response.status(201).entity(listEnrollment).build();
            default :
                return Response.status(200).entity(listEnrollment).build();
        }
    }

    @Override
    public List<EnrollmentDTO> removeEnrollment(int studentId, int subjectId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
