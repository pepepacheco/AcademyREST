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
public interface SubjectDAO {
    List<SubjectDTO> findAllSubjects();
    
    List<SubjectDTO> findSubjectById(int id);
    
    List<SubjectDTO> findSubjectByName(String name);
    
    List<SubjectDTO> findSubjectByCycle(String cycle);
    
    List<SubjectDTO> addSubject(SubjectDTO subject);
    
    List<SubjectDTO> editSubject(SubjectDTO subject);
    
    List<SubjectDTO> removeSubject(int id);
}
