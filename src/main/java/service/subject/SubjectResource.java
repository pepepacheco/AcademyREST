/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.subject;

import model.subject.SubjectDTO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Lolo
 */
public interface SubjectResource {
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    List<SubjectDTO> getAllSubjects();
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    List<SubjectDTO> findSubjectById(@PathParam("id") int id);
    
    @GET
    @Path("nombre/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    List<SubjectDTO> findSubjectByName(@PathParam("name") String name);
    
    @GET
    @Path("ciclo/{cycle}")
    @Produces({MediaType.APPLICATION_JSON})
    List<SubjectDTO> findSujectByCycle(@PathParam("cycle") String cycle);
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    List<SubjectDTO> addSubject(SubjectDTO subject);
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    Response editSubject(SubjectDTO subject);
    
    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    List<SubjectDTO> removeSubjet(@PathParam("id") int id);
}
