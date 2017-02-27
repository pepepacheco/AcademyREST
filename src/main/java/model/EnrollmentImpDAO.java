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
 * @author Lolo y Rafa
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
            Logger.getLogger(StudentImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listEnrollments;
    }

    @Override
    public List<EnrollmentOutputDTO> findByStudentDNI(String dni) {
        List<EnrollmentOutputDTO> listEnrollment = new ArrayList<EnrollmentOutputDTO>();
        
        try {
            String query = "SELECT Alumno.Nombre, Alumno.Apellidos, Asignatura.Nombre \"Asignatura\", Matricula.fecha_inicio, " +
            "Matricula.fecha_fin FROM Alumno, Asignatura, Matricula WHERE Alumno.ID = Matricula.ID_alumno " +
            "AND Asignatura.ID = Matricula.ID_asignatura AND Alumno.DNI = ?";
            
            PreparedStatement preparedStatement = CON.prepareStatement(query);
            preparedStatement.setString(1, dni);
            
            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next()) {
                String nameStudent, lastNameStudent, nameSubject;
                Date startDate, endDate;
                
                nameStudent = result.getString("Alumno.Nombre");
                lastNameStudent = result.getString("Alumno.Apellidos");
                nameSubject = result.getString("Asignatura");
                startDate = result.getDate("Matricula.fecha_inicio");
                endDate = result.getDate("Matricula.fecha_fin");
                
                EnrollmentOutputDTO enrollmentOut = new EnrollmentOutputDTO(nameStudent, lastNameStudent, nameSubject, startDate, endDate);
                listEnrollment.add(enrollmentOut);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listEnrollment;
    }

    @Override
    public List<EnrollmentOutputDTO> findBySubjectName(String name) {
        List<EnrollmentOutputDTO> listEnrollment = new ArrayList<EnrollmentOutputDTO>();
        
        try {
            String query = "SELECT Alumno.Nombre, Alumno.Apellidos, Asignatura.Nombre \"Asignatura\", Matricula.fecha_inicio, " +
            "Matricula.fecha_fin FROM Alumno, Asignatura, Matricula WHERE Alumno.ID = Matricula.ID_alumno " +
            "AND Asignatura.ID = Matricula.ID_asignatura AND Asignatura.Nombre = ?";
            
            PreparedStatement preparedStatement = CON.prepareStatement(query);
            preparedStatement.setString(1, name);
            
            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next()) {
                String nameStudent, lastNameStudent, nameSubject;
                Date startDate, endDate;
                
                nameStudent = result.getString("Alumno.Nombre");
                lastNameStudent = result.getString("Alumno.Apellidos");
                nameSubject = result.getString("Asignatura");
                startDate = result.getDate("Matricula.fecha_inicio");
                endDate = result.getDate("Matricula.fecha_fin");
                
                EnrollmentOutputDTO enrollmentOut = new EnrollmentOutputDTO(nameStudent, lastNameStudent, nameSubject, startDate, endDate);
                listEnrollment.add(enrollmentOut);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listEnrollment;
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
            Logger.getLogger(StudentImpDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(StudentImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listEnrollments;
    }

    @Override
    public List<EnrollmentDTO> removeEnrollment(int stId, int suId) {
        List<EnrollmentDTO> listEnrollment = new ArrayList<EnrollmentDTO>();
               
        try {
            String query = "SELECT * FROM Matricula Where ID_alumno = ? AND ID_asignatura = ?";
            PreparedStatement preparedStatementQuery = CON.prepareStatement(query);
            preparedStatementQuery.setInt(1, stId);
            preparedStatementQuery.setInt(2, suId);
            
            ResultSet resultSetQuery = preparedStatementQuery.executeQuery();
            
            if (resultSetQuery != null) {
                String sql = "DELETE FROM Matricula WHERE ID_alumno = ? AND ID_asignatura = ?";
                PreparedStatement preparedStatementDelete = CON.prepareStatement(sql);
                preparedStatementDelete.setInt(1, stId);
                preparedStatementDelete.setInt(2, suId);
                
                if (preparedStatementDelete.executeUpdate() == SUCCESS) {
                    
                    while (resultSetQuery.next()) {
                        int studentId, subjectId;
                        Date startDate, endDate;
                        
                        studentId = resultSetQuery.getInt("ID_alumno");
                        subjectId = resultSetQuery.getInt("ID_asignatura");
                        startDate = resultSetQuery.getDate("fecha_inicio");
                        endDate = resultSetQuery.getDate("fecha_fin");
                
                        EnrollmentDTO enrollment = new EnrollmentDTO(studentId, subjectId, startDate, endDate);
                        listEnrollment.add(enrollment);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }      
        return listEnrollment;
    }
}
