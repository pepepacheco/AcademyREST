package model.student;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rafael Vargas del Moral
 */
@XmlRootElement
public class StudentDTO {
    @XmlElement
    private int id;
    
    @XmlElement
    private String dni;
    
    @XmlElement
    private String name;
    
    @XmlElement
    private String lastName;
    
    @XmlElement
    private String eMail;
    
    public StudentDTO(){}

    public StudentDTO (int id, String dni, String name, String lastName, String eMail) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.eMail = eMail;
    }

    public int getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String geteMail() {
        return eMail;
    }

}
