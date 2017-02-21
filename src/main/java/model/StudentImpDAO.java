package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael Vargas del Moral
 */
public class StudentImpDAO implements StudentDAO {
    private final Connection CON = ConnectionDB.getConnection();
    
    @Override
    public List<StudentDTO> findAll() {
        List<StudentDTO> listStudents = new ArrayList<StudentDTO>();
        try {
            Statement statement = CON.createStatement();
            String query = "SELECT * FROM Alumno";
            ResultSet result = statement.executeQuery(query);
               
            StudentDTO student;
            while (result.next()) {
                String dni, name, lastName, email;
                dni = result.getString("DNI");
                name = result.getString("Nombre");
                lastName = result.getString("Apellidos");
                email = result.getString("email");
                
                student = new StudentDTO(dni, name, lastName, email);
                listStudents.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listStudents;
    }
    
}
