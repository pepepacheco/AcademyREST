/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lolo
 */
public class SubjectImpDAO implements SubjectDAO {
    private final Connection CON = ConnectionDB.getConnection();
    private final int SUCCESS = 1;
    public static int putStatus = 0;

    @Override
    public List<SubjectDTO> findAllSubjects() {
        List<SubjectDTO> listSubjects = new ArrayList<SubjectDTO>();
        try {
            Statement statement = CON.createStatement();
            String query = "SELECT * FROM Asignatura";
            ResultSet result = statement.executeQuery(query);
               
            SubjectDTO subject;
            while (result.next()) {
                int hours;
                String name, cycle, course;
                
                name = result.getString("Nombre");
                cycle = result.getString("Ciclo");
                course = result.getString("Curso");
                hours = result.getInt("Horas");
                
                subject = new SubjectDTO(name, cycle, course, hours);
                listSubjects.add(subject);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSubjects;
        
    }

    @Override
    public List<SubjectDTO> findSubjectById(int n) {
        List<SubjectDTO> listSubjects = new ArrayList<SubjectDTO>();
        try {
            String query = "SELECT * FROM Asignatura WHERE ID = ?";
            PreparedStatement statement = CON.prepareStatement(query);
            statement.setInt(1, n);
            ResultSet result = statement.executeQuery();
               
            SubjectDTO subject;
            while (result.next()) {
                int hours;
                String name, cycle, course;
                
                name = result.getString("Nombre");
                cycle = result.getString("Ciclo");
                course = result.getString("Curso");
                hours = result.getInt("Horas");
                
                subject = new SubjectDTO(name, cycle, course, hours);
                listSubjects.add(subject);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSubjects;
    }

    @Override
    public List<SubjectDTO> findSubjectByName(String n) {
        List<SubjectDTO> listSubjects = new ArrayList<SubjectDTO>();
        try {
            String query = "SELECT * FROM Asignatura WHERE Nombre = ?";
            PreparedStatement statement = CON.prepareStatement(query);
            statement.setString(1, n);
            ResultSet result = statement.executeQuery();
               
            SubjectDTO subject;
            while (result.next()) {
                int hours;
                String name, cycle, course;
                
                name = result.getString("Nombre");
                cycle = result.getString("Ciclo");
                course = result.getString("Curso");
                hours = result.getInt("Horas");
                
                subject = new SubjectDTO(name, cycle, course, hours);
                listSubjects.add(subject);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSubjects;
    }

    @Override
    public List<SubjectDTO> findSubjectByCycle(String n) {
        List<SubjectDTO> listSubjects = new ArrayList<SubjectDTO>();
        try {
            String query = "SELECT * FROM Asignatura WHERE Ciclo = ?";
            PreparedStatement statement = CON.prepareStatement(query);
            statement.setString(1, n);
            ResultSet result = statement.executeQuery();
               
            SubjectDTO subject;
            while (result.next()) {
                int hours;
                String name, cycle, course;
                
                name = result.getString("Nombre");
                cycle = result.getString("Ciclo");
                course = result.getString("Curso");
                hours = result.getInt("Horas");
                
                subject = new SubjectDTO(name, cycle, course, hours);
                listSubjects.add(subject);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSubjects;
    }

    @Override
    public List<SubjectDTO> addSubject(SubjectDTO s) {
        List<SubjectDTO> listSubjects = new ArrayList<SubjectDTO>();
        
        try {
            String query = "INSERT INTO Asignatura VALUES (null, ?, ?, ?, ?)";
            PreparedStatement statement = CON.prepareStatement(query);
            statement.setString(1, s.getName());
            statement.setString(2, s.getCycle());
            statement.setString(3, s.getCourse());
            statement.setInt(4, s.getHours());
               
            if(statement.executeUpdate() == SUCCESS){
                listSubjects.add(s);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSubjects;
    }

    @Override
    public List<SubjectDTO> editSubject(SubjectDTO s) {
        List<SubjectDTO> listSubjects = new ArrayList<SubjectDTO>();
        
        try {
            String sql = "CALL putAsignatura(?, ?, ?, ?)";
            CallableStatement statement = CON.prepareCall(sql);
           
            statement.setString(1, s.getName());
            statement.setString(2, s.getCycle());
            statement.setString(3, s.getCourse());
            statement.setInt(4, s.getHours());
               
            if(statement.execute()){
                listSubjects.add(s);
                
                ResultSet result = statement.getResultSet();
                int resultCode = 0;
                while (result.next()){
                    resultCode = Integer.parseInt(result.getString("code"));
                }
                putStatus = resultCode;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSubjects;
    }

    @Override
    public List<SubjectDTO> removeSubject(int id) {
        List<SubjectDTO> listSubjects = findSubjectById(id);
        
        if(listSubjects.size() > 0){
            try {
                String sql = "DELETE FROM Asignatura WHERE id = ?";
                PreparedStatement statement = CON.prepareStatement(sql);
                statement.setInt(1, id);
            
                if(statement.executeUpdate() == SUCCESS){
                    return listSubjects;
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(SubjectImpDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return listSubjects;
    }
   
}