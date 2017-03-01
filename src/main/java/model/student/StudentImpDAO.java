package model.student;

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
import model.ConnectionDB;

/**
 *
 * @author Rafael Vargas del Moral
 */
public class StudentImpDAO implements StudentDAO {
    private final Connection CON = ConnectionDB.getConnection();
    private static final int SUCCESS = 1;
    public static int putStatus = 0;
    
    @Override
    public List<StudentDTO> findAll() {
        List<StudentDTO> listStudents = new ArrayList<StudentDTO>();
        try {
            Statement statement = CON.createStatement();
            String query = "SELECT * FROM Alumno";
            
            ResultSet result = statement.executeQuery(query);
               
            StudentDTO student;
            while (result.next()) {
                int id;
                String dni, name, lastName, email;
                
                id = result.getInt("ID");
                dni = result.getString("DNI");
                name = result.getString("Nombre");
                lastName = result.getString("Apellidos");
                email = result.getString("email");
                
                student = new StudentDTO(id, dni, name, lastName, email);
                listStudents.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listStudents;
    }

    @Override
    public List<StudentDTO> findById(int idQuery) {
        List<StudentDTO> listStudents = new ArrayList<StudentDTO>();
        try {
            String query = "SELECT * FROM Alumno WHERE id = ?";
            PreparedStatement prepareStatement = CON.prepareStatement(query);
            prepareStatement.setInt(1, idQuery);
            
            ResultSet result = prepareStatement.executeQuery();
            
            StudentDTO student;
            while (result.next()) {
                int id;
                String dni, name, lastName, email;
                
                id = result.getInt("ID");
                dni = result.getString("DNI");
                name = result.getString("Nombre");
                lastName = result.getString("Apellidos");
                email = result.getString("email");
                
                student = new StudentDTO(id, dni, name, lastName, email);
                listStudents.add(student);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listStudents;
    }

    @Override
    public List<StudentDTO> findByDni(String dniStudent) {
        List<StudentDTO> listStudents = new ArrayList<StudentDTO>();
        try {
            String query = "SELECT * FROM Alumno WHERE dni = ?";
            PreparedStatement prepareStatement = CON.prepareStatement(query);
            prepareStatement.setString(1, dniStudent);
            
            ResultSet result = prepareStatement.executeQuery();
            
            StudentDTO student;
            while (result.next()) {
                int id;
                String dni, name, lastName, email;
                
                id = result.getInt("ID");
                dni = result.getString("DNI");
                name = result.getString("Nombre");
                lastName = result.getString("Apellidos");
                email = result.getString("email");
                
                student = new StudentDTO(id, dni, name, lastName, email);
                listStudents.add(student);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listStudents;
    }

    @Override
    public List<StudentDTO> findByName(String nameStudent) {
        List<StudentDTO> listStudents = new ArrayList<StudentDTO>();
        try {
            String query = "SELECT * FROM Alumno WHERE Nombre = ?";
            PreparedStatement prepareStatement = CON.prepareStatement(query);
            prepareStatement.setString(1, nameStudent);
            
            ResultSet result = prepareStatement.executeQuery();
            
            StudentDTO student;
            while (result.next()) {
                int id;
                String dni, name, lastName, email;
                
                id = result.getInt("ID");
                dni = result.getString("DNI");
                name = result.getString("Nombre");
                lastName = result.getString("Apellidos");
                email = result.getString("email");
                
                student = new StudentDTO(id, dni, name, lastName, email);
                listStudents.add(student);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listStudents;
    }

    @Override
    public List<StudentDTO> addStudent(StudentDTO student) {
        List<StudentDTO> listStudents = new ArrayList<StudentDTO>();
        String sql = "INSERT INTO Alumno VALUES(null, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = CON.prepareStatement(sql);
            preparedStatement.setString(1, student.getDni());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getLastName());
            preparedStatement.setString(4, student.geteMail());
            
            if (preparedStatement.executeUpdate() == SUCCESS);
                listStudents.add(student);

        } catch (SQLException ex) {
            Logger.getLogger(StudentImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listStudents;
    }

    @Override
    public List<StudentDTO> editStudent(StudentDTO student) {
        List<StudentDTO> listStudent = new ArrayList<StudentDTO>();
        String sql = "CALL putAlumno(?, ?, ?, ?)";
        
        try {
            CallableStatement statement = CON.prepareCall(sql);
            statement.setString(1, student.getDni());
            statement.setString(2, student.getName());
            statement.setString(3, student.getLastName());
            statement.setString(4, student.geteMail());

            if (statement.execute()) {
                listStudent.add(student);
                
                ResultSet result = statement.getResultSet();
                int resultCode = 0;
                while (result.next()) {
                    resultCode = Integer.parseInt(result.getString("code"));
                }
                putStatus = resultCode;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listStudent;
    }

    @Override
    public List<StudentDTO> removeStudent(int id) {
        List<StudentDTO> listStudent = findById(id);
        
        if (listStudent.size() > 0) {
            try {
                String sql = "DELETE FROM Alumno WHERE id = ?";
                PreparedStatement preparedStatement = CON.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                
                if (preparedStatement.executeUpdate()== SUCCESS) {
                    return listStudent;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(StudentImpDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listStudent;
    }    
}
