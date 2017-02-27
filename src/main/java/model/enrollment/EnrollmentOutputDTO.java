package model.enrollment;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lolo y rafa
 */
@XmlRootElement
public class EnrollmentOutputDTO {
    @XmlElement
    private String studentName;
    
    @XmlElement
    private String studentLastName;
    
    @XmlElement
    private String subject;
    
    @XmlElement
    private Date startDate;
    
    @XmlElement
    private Date endDate;
    
    public EnrollmentOutputDTO() {}
    
    public EnrollmentOutputDTO(String nameStudent, String lastNameStudent, String nameSubject, Date startDate, Date endDate) {
        this.studentName = nameStudent;
        this.studentLastName = lastNameStudent;
        this.subject = nameSubject;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getSubject() {
        return subject;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
}
