/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import model.SubjectDTO;
import model.SubjectImpDAO;

/**
 *
 * @author Lolo
 */
@Path("Asignatura")
public class SubjectRest implements SubjectResource{
    SubjectImpDAO subjectDB = new SubjectImpDAO();
    
    @Override
    public List<SubjectDTO> getAllSubjects() {
        return subjectDB.findAllSubjects();
    }

    @Override
    public List<SubjectDTO> findSubjectById(int id) {
        return subjectDB.findSubjectById(id);
    }

    @Override
    public List<SubjectDTO> findSubjectByName(String name) {
        return subjectDB.findSubjectByName(name);
    }

    @Override
    public List<SubjectDTO> findSujectByCycle(String cycle) {
        return subjectDB.findSubjectByCycle(cycle);
    }

    @Override
    public List<SubjectDTO> addSubject(SubjectDTO subject) {
        return subjectDB.addSubject(subject);
    }

    @Override
    public Response editSubject(SubjectDTO subject) {
        List<SubjectDTO> listSubject = subjectDB.editSubject(subject);
        
        switch(SubjectImpDAO.putStatus){
            case 200:
                return Response.status(200).entity(listSubject).build();
            case 201:
                return Response.status(201).entity(listSubject).build();
            default :
                return Response.status(200).entity(listSubject).build();
        }
    }

    @Override
    public List<SubjectDTO> removeSubjet(int id) {
        return subjectDB.removeSubject(id);
    }

    
}
