package com.example.fitness.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Enquiry")
public class Enquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date Dateofeq;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String address;
    private String pincode;
    private String firstNameOfPar;
    @Column(name = "last_nameofpar", nullable = true)
    private String lastNameOfPar;
    private String contactNumber;
    private String status;
    private String referred_by;
    private String referred_personname;
    public String getReferred_by() {
        return referred_by;
    }

    public void setReferred_by(String referred_by) {
        this.referred_by = referred_by;
    }

    public String getReferred_personname() {
        return referred_personname;
    }

    public void setReferred_personname(String referred_personname) {
        this.referred_personname = referred_personname;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    private String about;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "program_id", referencedColumnName = "idofprog")
    private Program program;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "area_id", referencedColumnName = "idofarea")
    private Area area;

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getFirstNameOfPar() {
        return firstNameOfPar;
    }

    public void setFirstNameOfPar(String firstNameOfPar) {
        this.firstNameOfPar = firstNameOfPar;
    }

    public String getLastNameOfPar() {
        return lastNameOfPar;
    }

    public void setLastNameOfPar(String lastNameOfPar) {
        this.lastNameOfPar = lastNameOfPar;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Enquiry{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", about='" + about + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", pincode='" + pincode + '\'' +
                ", firstNameOfPar='" + firstNameOfPar + '\'' +
                ", lastNameOfPar='" + lastNameOfPar + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", status='" + status + '\'' +
                ", program=" + (program != null ? program.getName() : "null") +
                ", area=" + (area != null ? area.getName() : "null") +
                '}';
    }

    public Date getDateofeq() {
        return Dateofeq;
    }

    public void setDateofeq(Date dateofeq) {
        Dateofeq = dateofeq;
    }
}

