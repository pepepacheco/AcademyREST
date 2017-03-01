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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lolo
 */
public class EnrollmentImpDAO implements EnrollmentDAO{
    private final Connection CON = ConnectionDB.getConnection();
    private final int SUCCESS = 1;
    public static int putStatus = 0;

    @Override
    public List<EnrollmentOutputDTO> findAllEnrollments() {
        List<EnrollmentOutputDTO> listEnrollments = new ArrayList<EnrollmentOutputDTO>();
        try {
            Statement statement = CON.createStatement();
            String query = "SELECT Alumno.Nombre, Alumno.Apellidos, Asignatura.Nombre \"Asignatura\", Matricula.fecha_inicio, " +
                "Matricula.fecha_fin FROM Alumno, Asignatura, Matricula WHERE Alumno.ID = Matricula.ID_alumno " +
                "AND Asignatura.ID = Matricula.ID_asignatura";
            ResultSet result = statement.executeQuery(query);
               
            EnrollmentOutputDTO enrollmentOut;
            while (result.next()) {
                String studentName, studentLastName, subject;
                Date startDate, endDate;
                
                studentName = result.getString("Alumno.Nombre");
                studentLastName = result.getString("Alumno.Apellidos");
                subject = result.getString("Asignatura");
                startDate = result.getDate("Matricula.fecha_inicio");
                endDate = result.getDate("Matricula.fecha_fin");
                
                enrollmentOut = new EnrollmentOutputDTO(studentName, studentLastName, subject, startDate, endDate);
                listEnrollments.add(enrollmentOut);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listEnrollments;
    }

    @Override
    public List<EnrollmentDTO> findEnrollmentByStudentDni(String dni) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EnrollmentDTO> findEnrollmentBySubjectName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EnrollmentDTO> addEnrollment(EnrollmentDTO enrollment) {
        List<EnrollmentDTO> listEnrollments = new ArrayList<EnrollmentDTO>();
        
        try {
            String query = "INSERT INTO Matricula VALUES(?, ?, ?, ?)";
            PreparedStatement statement = CON.prepareStatement(query);
            statement.setInt(1, enrollment.getStudentId());
            statement.setInt(2, enrollment.getSubjectId());
            statement.setDate(3, new java.sql.Date(enrollment.getStartDate().getTime()));
            statement.setDate(4, new java.sql.Date(enrollment.getEndDate().getTime()));
            
            if(statement.executeUpdate() == SUCCESS){
                listEnrollments.add(enrollment);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listEnrollments;
    }

    @Override
    public List<EnrollmentDTO> editEnrollment(EnrollmentDTO enrollment) {
        List<EnrollmentDTO> listEnrollments = new ArrayList<EnrollmentDTO>();
        
        try {
            String sql = "CALL putMatricula(?, ?, ?, ?)";
            CallableStatement statement = CON.prepareCall(sql);
           
            statement.setInt(1, enrollment.getStudentId());
            statement.setInt(2, enrollment.getSubjectId());
            statement.setDate(3, new java.sql.Date(enrollment.getStartDate().getTime()));
            statement.setDate(4, new java.sql.Date(enrollment.getEndDate().getTime()));
               
            if(statement.execute()){
                listEnrollments.add(enrollment);
                
                ResultSet result = statement.getResultSet();
                int resultCode = 0;
                while (result.next()){
                    resultCode = Integer.parseInt(result.getString("code"));
                }
                
                putStatus = resultCode;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listEnrollments;
    }

    @Override
    public List<EnrollmentDTO> removeEnrollment(int studentId, int subjectId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
