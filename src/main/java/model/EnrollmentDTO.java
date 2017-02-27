package model;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafa
 */
@XmlRootElement
public class EnrollmentDTO {
    @XmlElement
    private int studentId;
    
    @XmlElement
    private int subjectId;
    
    @XmlElement
    private Date startDate;
    
    @XmlElement
    private Date endDate;
    
    public EnrollmentDTO() {}
    
    public EnrollmentDTO(int studentId, int subjectId, Date startDate, Date endDate)  {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
