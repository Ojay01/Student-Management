package kingstech;

import java.sql.Date;

public class teacherData {

    private Integer id;
    private Integer national_id;
    private Integer phone_number;
    private String academic_year;
    private String subject;
    private String origin;
    private String gender;
    private Double scholarship;
    private Date date_of_birth;
    private String category;
    private Integer salary;
    private Double firstSem;
    private Double secondSem;
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
    private Integer hours;
    private Integer period;
    private Integer age;
    private Integer totalScienceStudents;
    private Integer totalArtsStudents;


    // MAKE SURE THAT SAME DATATYPE THAT YOU WILL PUT THERE 
    public teacherData(String name, Integer age, String gender, String contact,   Integer hours, Integer period, String subject, String origin, Integer national_id, Integer salary, Integer id, String category ) {
        // this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
        this.period = period;
        this.hours = hours;
        this.subject = subject;
        this.origin = origin;
        this.national_id = national_id;
        this.salary = salary;
        this.id = id;
        this.category = category;


    }

    public teacherData(String name, Integer phone_number) {
        this.phone_number = phone_number;
        this.name = name;
        // this.age = age;
        // this.gender = gender;
        // this.contact = contact;
        // this.period = period;
        // this.date_of_birth = date_of_birth;
        // this.hours = hours;
        // this.image = image;
    }


    


    public Integer getSchoolFees() {
        return school_fees;
    }

    public int getId() {
        return id;
    }  
    
    public Integer getTotalStudents() {
        return totalStudents;
    }  

    public Integer getPeriod(){
        return period;
    }

    public Integer getHours(){
        return hours;
    }

    public Integer getAge(){
        return age;
    }

    public Integer getNatId(){
        return national_id;
    }

    public Integer getTotalArtsStudents(){
        return totalArtsStudents;
    }

    public Integer getTotalScienceStudents(){
        return totalScienceStudents;
    }

    public Integer getPhoneNumber(){
        return phone_number;
    }

    public String getAcademicYear() {
        return academic_year;
    }

    public String getOrigin() {
        return origin;
    }

    public String getCategory() {
        return category;
    }

    public String getName(){
        return name;
    }


    public String getGender() {
        return gender;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public String getSubject() {
        return subject;
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

    public Integer getSalary() {
        return salary;
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


    // PLEASE FOLLOW ME IF THE VARS ARE THE SAME TO ME 
}