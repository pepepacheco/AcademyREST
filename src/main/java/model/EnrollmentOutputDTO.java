/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lolo
 */
@XmlRootElement
public class EnrollmentOutputDTO {
    @XmlElement
    private String studentName;
    @XmlElement
    private String studentLasName;
    @XmlElement
    private String subject;
    @XmlElement
    private Date startDate;
    @XmlElement
    private Date endDate;

    public EnrollmentOutputDTO() {
    }

    public EnrollmentOutputDTO(String studentName, String studentLasName, String subject, Date startDate, Date endDate) {
        this.studentName = studentName;
        this.studentLasName = studentLasName;
        this.subject = subject;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getStudentLasName() {
        return studentLasName;
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

    public void setStudentLasName(String studentLasName) {
        this.studentLasName = studentLasName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }  
}
