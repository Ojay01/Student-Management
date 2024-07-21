package kingstech;

public class settingsData {
    private String schoolName;
    private String principal;
    private String address;
    private String logo;
    private String academicYear;

    public settingsData() {
    }

    public settingsData(String schoolName, String principal, String address, String logo, String academicYear) {
        this.schoolName = schoolName;
        this.principal = principal;
        this.address = address;
        this.logo = logo;
        this.academicYear = academicYear;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getPrincipal() {
        return principal;
    }

    public String getAddress() {
        return address;
    }


    public String getLogo() {
        return logo;
    }


    public String getAcademicYear() {
        return academicYear;
    }


}