package service.enrollment;

import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import model.enrollment.EnrollmentDTO;
import model.enrollment.EnrollmentImpDAO;
import model.enrollment.EnrollmentOutputDTO;

/**
 *
 * @author lolo y rafa
 */
@Path("enrollment")
public class EnrollmentRest implements EnrollmentResource{
    EnrollmentImpDAO enrollmentDB = new EnrollmentImpDAO();
    
    @Override
    public List<EnrollmentOutputDTO> getAllEnrollments() {
        return enrollmentDB.findAllEnrollments();
    }

    @Override
    public List<EnrollmentOutputDTO> getEnrollmentByStudentDNI(String dni) {
        return enrollmentDB.findByStudentDNI(dni);
    }

    @Override
    public List<EnrollmentOutputDTO> getEnrollmentBySubjectName(String name) {
        return enrollmentDB.findBySubjectName(name);
    }
    
    @Override
    public List<EnrollmentDTO> addEnrollment(EnrollmentDTO enrollment) {
        return enrollmentDB.addEnrollment(enrollment);
    }

    @Override
    public Response editEnrollment(EnrollmentDTO enrollment) {
        List<EnrollmentDTO> listEnrollment = this.enrollmentDB.editEnrollment(enrollment);
        
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
    public List<EnrollmentDTO> deleteEnrollment(int studentId, int subjectId) {
        return enrollmentDB.removeEnrollment(studentId, subjectId);
    }
}
