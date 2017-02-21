package model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rafael Vargas del Moral
 */
@XmlRootElement
public class StudentDTO {
    private String dni;
    private String name;
    private String lastName;
    private String eMail;
    
    public StudentDTO(){}

    public StudentDTO (String dni, String name, String lastName, String eMail) {
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.eMail = eMail;
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
