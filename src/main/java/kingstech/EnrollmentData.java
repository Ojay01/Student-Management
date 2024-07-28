package kingstech;

public class EnrollmentData {

    private Integer id;
    private Integer totalStudents;
    private Integer studentsOwing;
    private String studentId;
    private String className;
    private String section;
    private String academicYear;
    private String status;
    private Double scholarship;
    private Double schoolFees;
    private Double totalFeesPaid;
    private Double totalOwing;
    private Double totalExpected;

    // Constructor
    public EnrollmentData(Integer id, String studentId, String className, String section, String academicYear, String status, Double scholarship, Double schoolFees, Double totalFeesPaid, Double totalOwing, Double totalExpected, Integer totalStudents, Integer studentsOwing) {
        this.id = id;
        this.studentId = studentId;
        this.className = className;
        this.section = section;
        this.academicYear = academicYear;
        this.status = status;
        this.scholarship = scholarship;
        this.schoolFees = schoolFees;
        this.totalFeesPaid = totalFeesPaid;
        this.totalOwing = totalOwing;
        this.totalExpected = totalExpected;
        this.totalStudents = totalStudents;
        this.studentsOwing = studentsOwing;
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

    public String getSection() {
        return section;
    }

    public String getAcademicYear() {
        return academicYear;
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
}
