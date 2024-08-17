package kingstech;

import java.sql.Date;

public class studentData {

    private Integer id;
    private String academic_year;
    // private String course;
    private String lastName;
    private String gender;
    private Double scholarship;
    private Date date_of_birth;
    private String status;
    private String image;
    private Double firstSem;
    private Double owing;
    private Double secondSem;
    private Double other_fees;
    private String class_name;
    // private String firstName;
    private String section;
    private Integer school_fees;
    private Boolean A1;
    private Boolean A2;
    private Boolean B1;
    private Boolean B2;
    private Boolean Arts;
    private Boolean C;
    private Boolean Science;
    private Boolean Commercial;
    private String name;
    private String contact;
    private Integer totalStudents;
    // private int totalStudents;
    private Integer totalExpected;
    private Integer totalPaid;
    private Integer totalOwing;
    private Integer totalStudentsOwing;
    private Integer totalScienceStudents;
    private Integer totalArtsStudents;
    private Integer totalCommercialStudents;
    



    public studentData(Integer school_fees, String name, String academic_year, Boolean A1, Boolean A2, Boolean B1, Boolean B2, Boolean Arts, Boolean Science, Boolean Commercial, Boolean C, String class_name) {
        this.school_fees = school_fees;
        this.academic_year = academic_year;
        this.class_name = class_name;
        this.A1 = A1;
        this.A2 = A2;
        this.B1 = B1;
        this.C = C;
        this.B2 = B2;
        this.Arts = Arts;
        this.Commercial = Commercial;
        this.Science = Science;
        this.class_name = class_name;
    }

    // MAKE SURE THAT SAME DATATYPE THAT YOU WILL PUT THERE 
    public studentData(Integer id, String name, String contact, String gender, @SuppressWarnings("exports") Date date_of_birth, String class_name, String section, Double owing, String status, Double scholarship ) {
        this.id = id;
        this.class_name = class_name;
        this.contact = contact;
        this.name = name;
        this.section = section;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.status = status;
        this.owing = owing;
        this.scholarship = scholarship;
    }

    public studentData(Double scholarship) {
        // this.scholarship = scholarship;
        // this.year = year;
        // this.course = course;
        // this.firstSem = firstSem;
        // this.secondSem = secondSem;
        // this.finals = finals;
    }

    public studentData(Integer school_fees, String class_name, String academic_year, String section, Integer totalStudents, Integer totalExpected, Integer totalPaid, Integer totalOwing, Integer totalStudentsOwing ) {
        this.school_fees = school_fees;
        this.class_name = class_name;
        this.academic_year = academic_year;
        this.section = section;
        this.totalStudents = totalStudents;
        this.totalExpected = totalExpected;
        this.totalPaid = totalPaid;
        this.totalOwing = totalOwing;
        this.totalStudentsOwing = totalStudentsOwing;
        // this.totalArtsStudents = totalArtsStudents;
        // this.totalScienceStudents = totalScienceStudents;
        // this.totalCommercialStudents = totalCommercialStudents;
    
        
    }
    

    public Integer getSchoolFees() {
        return school_fees;
    }

    public Integer getId() {
        return id;
    }  
    
    public Integer getTotalStudents() {
        return totalStudents;
    }  

    public Integer getTotalExpected(){
        return totalExpected;
    }

    public Integer getTotalPaid(){
        return totalPaid;
    }

    public Integer getTotalOwing(){
        return totalOwing;
    }

    public Integer getTotalStudentsOwing(){
        return totalStudentsOwing;
    }

    public Integer getTotalArtsStudents(){
        return totalArtsStudents;
    }

    public Integer getTotalScienceStudents(){
        return totalScienceStudents;
    }

    public Integer getTotalCommercialStudents(){
        return totalCommercialStudents;
    }

    public String getAcademicYear() {
        return academic_year;
    }

    public String getSection() {
        return section;
    }

    public String getClassName() {
        return class_name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName(){
        return name;
    }


    public String getGender() {
        return gender;
    }

    @SuppressWarnings("exports")
    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public String getStatus() {
        return status;
    }

    public Double getScholarship() {
        return scholarship;
    }

    public Boolean getA1() {
        return A1;
    }

    public Boolean getA2() {
        return A2;
    }

    public Boolean getC() {
        return C;
    }

    public Boolean getB1() {
        return B1;
    }

    public Boolean getB2() {
        return B2;
    }

    public Boolean getArts() {
        return Arts;
    }

    public Boolean getCommercial() {
        return Commercial;
    }

    public Boolean getScience() {
        return Science;
    }

    public String getImage() {
        return image;
    }

    public String getContact() {
        return contact;
    }

    public Double getFirstSem() {
        return firstSem;
    }

    public Double getSecondSem() {
        return secondSem;
    }

    public Double getOtherFees() {
        return other_fees;
    }

    public Double getOwing() {
        return owing;
    }

    // PLEASE FOLLOW ME IF THE VARS ARE THE SAME TO ME 
}