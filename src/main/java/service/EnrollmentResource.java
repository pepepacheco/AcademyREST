/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.EnrollmentDTO;
import model.EnrollmentOutputDTO;


/**
 *
 * @author Lolo
 */
public interface EnrollmentResource {
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    List<EnrollmentOutputDTO> getAllEnrollments();
    
    @GET
    @Path("alumno/{dni}")
    @Produces({MediaType.APPLICATION_JSON})
    List<EnrollmentOutputDTO> findEnrollmentByStudentDni(@PathParam("dni") String dni);
    
    @GET
    @Path("asignatura/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    List<EnrollmentDTO> findEnrollmentBySubjectName(@PathParam("name") String name);
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    List<EnrollmentDTO> addEnrollment(EnrollmentDTO enrollment);
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    Response editEnrollment(EnrollmentDTO enrollment);
    
    @DELETE
    @Path("delete")
    @Produces({MediaType.APPLICATION_JSON})
    List<EnrollmentDTO> removeEnrollment(@QueryParam("studentId") int studentId, @QueryParam("subjectId") int subjectId);
    
}
