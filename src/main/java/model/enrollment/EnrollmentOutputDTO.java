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
    private int studentId;
    
    @XmlElement
    private String studentName;
    
    @XmlElement
    private String studentLastName;
    
    @XmlElement
    private int subjectId;
    
    @XmlElement
    private String subject;
    
    @XmlElement
    private Date startDate;
    
    @XmlElement
    private Date endDate;
    
    public EnrollmentOutputDTO() {}
    
    public EnrollmentOutputDTO(int studentId, String nameStudent, String lastNameStudent, int subjectId, String nameSubject, Date startDate, Date endDate) {
        this.studentId = studentId;
        this.studentName = nameStudent;
        this.studentLastName = lastNameStudent;
        this.subjectId = subjectId;
        this.subject = nameSubject;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getSubjectId() {
        return subjectId;
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
