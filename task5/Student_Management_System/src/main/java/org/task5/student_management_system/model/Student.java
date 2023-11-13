package org.task5.student_management_system.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    public Student() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_Id")
    private int studentId;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "contact_number")
    private String contact_number;

    @Column(name = "email")
    private String email;

//    @Temporal(TemporalType.DATE)
    @Column(name = "d_o_b")
    private String d_o_b;

    @Column(name = "address")
    private String address;

//    @Temporal(TemporalType.DATE)
    @Column(name = "enrollment_date")
    private String enrollment_date;

    public Student(String first_name, String last_name, String contact_number, String email, String d_o_b, String address, String enrollment_date) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.contact_number = contact_number;
        this.email = email;
        this.d_o_b = d_o_b;
        this.address = address;
        this.enrollment_date = enrollment_date;
    }

    public Student(int studentId, String first_name, String last_name, String contact_number, String email, String d_o_b, String address, String enrollment_date) {
        this.studentId = studentId;
        this.first_name = first_name;
        this.last_name = last_name;
        this.contact_number = contact_number;
        this.email = email;
        this.d_o_b = d_o_b;
        this.address = address;
        this.enrollment_date = enrollment_date;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", contact_number='" + contact_number + '\'' +
                ", email='" + email + '\'' +
                ", d_o_b=" + d_o_b +
                ", address='" + address + '\'' +
                ", enrollment_date=" + enrollment_date +
                '}';
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getfirst_name() {
        return first_name;
    }

    public void setfirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getlast_name() {
        return last_name;
    }

    public void setlast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getcontact_number() {
        return contact_number;
    }

    public void setcontact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getd_o_b() {
        return d_o_b;
    }

    public void setd_o_b(String d_o_b) {
        this.d_o_b = d_o_b;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getenrollment_date() {
        return enrollment_date.toLowerCase();
    }

    public void setenrollment_date(String enrollment_date) {
        this.enrollment_date = enrollment_date;
    }
}
