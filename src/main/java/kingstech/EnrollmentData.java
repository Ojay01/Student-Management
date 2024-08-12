package kingstech;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class EnrollmentData {

    private Integer id;
    private Integer totalStudents;
    private Integer studentsOwing;
    private String studentId;
    private String className;
    private String name;
    private String gender;
    private String date_of_birth;
    private String section;
    private String category;
    private String academicYear;
    private String status;
    private String contact;
    private Double scholarship;
    private Double owing;
    private Double schoolFees;
    private Double totalFeesPaid;
    private Double totalOwing;
    private Double totalExpected;
    private Double amountPaid;
    private String paymentDate;

    // Constructor
    public EnrollmentData(Integer id, String studentId, String className, String section, String category, String academicYear,
            String status, Double scholarship, Double schoolFees, Double totalFeesPaid, Double totalOwing,
            Double totalExpected, Integer totalStudents, Integer studentsOwing, String contact, String name,
            String gender, String date_of_birth, Double owing, Double amountPaid, String paymentDate) {
        this.id = id;
        this.studentId = studentId;
        this.className = className;
        this.section = section;
        this.category = category;
        this.academicYear = academicYear;
        this.status = status;
        this.scholarship = scholarship;
        this.schoolFees = schoolFees;
        this.totalFeesPaid = totalFeesPaid;
        this.totalOwing = totalOwing;
        this.totalExpected = totalExpected;
        this.totalStudents = totalStudents;
        this.studentsOwing = studentsOwing;
        this.contact = contact;
        this.name = name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.owing = owing;
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getClassName() {
        return className;
    }

    public String getName() {
        return name;
    }

    public String getSection() {
        return section;
    }
    public String getCategory() {
        return category;
    }

    public String getDate_of_birth() {
        try {
            long timestamp = Long.parseLong(date_of_birth);
            Date date = new Date(timestamp);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
            return sdf.format(date);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "Invalid Date";
        }
    }

    public String getGender() {
        return gender;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getContact() {
        return contact;
    }

    public String getStatus() {
        return status;
    }

    public Double getScholarship() {
        return scholarship;
    }

    public Double getSchoolFees() {
        return schoolFees;
    }

    public Double getOwing() {
        return owing;
    }

    public Double getTotalFeesPaid() {
        return totalFeesPaid;
    }

    public Double getTotalOwing() {
        return totalOwing;
    }

    public Double getTotalExpected() {
        return totalExpected;
    }

    public Integer getTotalStudents() {
        return totalStudents;
    }

    public Integer getStudentsOwing() {
        return studentsOwing;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }


    public String getPaymentDate() {
        return paymentDate;
    }
}
