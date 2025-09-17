package kingstech;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Div;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.properties.VerticalAlignment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class DashboardController implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private AnchorPane updateTeacher_form;

    @FXML
    private AnchorPane teachers_form;

    @FXML
    private AnchorPane personal_form;

    @FXML
    private Button close;

    @FXML
    private Button word;

    @FXML
    private Button excel;

    @FXML
    private Button delete_Button;

    @FXML
    private Button invoice_Button;

    @FXML
    private Button scholarshipButton;

    @FXML
    private Button payments_btn;

    @FXML
    private Button minimize;

    @FXML
    private Button maximize;

    @FXML
    private Label username;

    @FXML
    private Label teacherName;

    @FXML
    private Label teacherId;

    @FXML
    private Label showClassName;

    @FXML
    private Label showclassA1;

    @FXML
    private Label showClassA2;

    @FXML
    private Label showClassB1;

    @FXML
    private Label showClassB2;

    @FXML
    private Label showClassArts;

    @FXML
    private Label students_year;

    @FXML
    private Label dailyrecord;

    @FXML
    private Label weaklyrecord;

    @FXML
    private Label marksheet_year;

    @FXML
    private Label showClassScience;

    @FXML
    private Label showclassfees;

    @FXML
    private Label showClassCommercial;

    @FXML
    private Button home_btn;

    @FXML
    private Button setting_btn;

    @FXML
    private Button Admins_btn;

    @FXML
    private Button teachers_btn;

    @FXML
    private Button All_btn;

    @FXML
    private Button add_teacher_btn;

    @FXML
    private Button teacher_btn;

    @FXML
    private Button save_setting_btn;

    @FXML
    private Button finance_btn;

    @FXML
    private Button print_Demo;

    @FXML
    private Button addStudents_btn;

    @FXML
    private Button classSectionRecord_Download;

    @FXML
    private ComboBox<String> school_year;

    @FXML
    private ComboBox<String> promoteDepartment;

    @FXML
    private ComboBox<String> promoteClass;

    @FXML
    private ComboBox<String> PromoteSection;

    @FXML
    private ComboBox<String> department;

    @FXML
    private ComboBox<String> department_details;

    @FXML
    private ComboBox<String> department_addStudent;

    @FXML
    private ComboBox<String> department_marksheet;

    @FXML
    private ComboBox<String> classRecord_Download;

    @FXML
    private ComboBox<String> SectionRecord_Download;

    @FXML
    private ComboBox<String> marksheet_class;

    @FXML
    private ComboBox<String> marksheet_section;

    @FXML
    private Button all_students_btn;

    @FXML
    private Button promoteBtn;

    @FXML
    private Button promoteStudent;

    @FXML
    private Button marksheet_Pdf;

    @FXML
    private Button export_excel;

    @FXML
    private Button marksheet_btn;

    @FXML
    private RadioButton formOne_btn;

    @FXML
    private RadioButton formTwo_btn;

    @FXML
    private RadioButton formThree_btn;

    @FXML
    private RadioButton formFour_btn;

    @FXML
    private RadioButton formFive_btn;

    @FXML
    private RadioButton lowerSixth_btn;

    @FXML
    private RadioButton upperSixth_btn;

    @FXML
    private RadioButton yes;

    @FXML
    private RadioButton no;

    @FXML
    private CheckBox A1_btn;

    @FXML
    private CheckBox A2_btn;

    @FXML
    private CheckBox B1_btn;

    @FXML
    private CheckBox b2_btn;

    @FXML
    private CheckBox C_btn;

    @FXML
    private CheckBox material_btn;

    @FXML
    private CheckBox arts_btn;

    @FXML
    private CheckBox science_btn;

    @FXML
    private CheckBox commercial_btn;

    @FXML
    private Button logout;

    @FXML
    private AnchorPane home_form;

    @FXML
    private AnchorPane promoteForm;

    @FXML
    private AnchorPane female_form;

    @FXML
    private AnchorPane male_form;

    @FXML
    private SplitPane settings_form;

    @FXML
    private AnchorPane finances_form;

    @FXML
    private Button feeStructure;

    @FXML
    private Label home_totalEnrolled;

    @FXML
    private Label home_totalFemale;

    @FXML
    private Label students_owing;

    @FXML
    private Label students_total_owing;

    @FXML
    private Label students_total_expected;

    @FXML
    private Label home_totalMale;

    @FXML
    private BarChart<?, ?> home_totalEnrolledChart;

    @FXML
    private AreaChart<?, ?> home_totalFemaleChart;

    @FXML
    private LineChart<?, ?> home_totalMaleChart;

    @FXML
    private AnchorPane addStudents_form;

    @FXML
    private AnchorPane addClass_form;

    @FXML
    private AnchorPane class_sectionAdd_form;

    @FXML
    private AnchorPane showClass;

    @FXML
    private TextField updateteacher_name;

    @FXML
    private TextField promoteStudent_paid;

    @FXML
    private TextField updateteacher_subjects;

    @FXML
    private TextField updateteacher_salary;

    @FXML
    private TextField updateteacher_hours;

    @FXML
    private TextField updateteacher_period;

    @FXML
    private TextField updateteacher_natId;

    @FXML
    private TextField updateteacher_origin;

    @FXML
    private TextField updateteacher_tel;

    @FXML
    private TextField addStudents_search;

    @FXML
    private TextField class_search;

    @FXML
    private TextField enter_fees;

    @FXML
    private Label fees_collected;

    @FXML
    private TableColumn<studentData, String> showClass_col_year;

    @FXML
    private TableColumn<studentData, String> showClass_col_section;

    @FXML
    private TableColumn<studentData, String> showClass_col_name;

    @FXML
    private TableColumn<studentData, String> showClass_col_StudentsOwing;

    @FXML
    private TableColumn<studentData, String> showClass_col_A2;

    @FXML
    private TableColumn<studentData, String> showClass_col_B1;

    @FXML
    private TableColumn<studentData, String> showClass_col_B2;

    @FXML
    private TableColumn<studentData, String> showClass_col_science;

    @FXML
    private TableColumn<studentData, String> showClass_col_arts;

    @FXML
    private TableColumn<studentData, String> showClass_col_commercial;

    @FXML
    private TableColumn<studentData, String> showClass_col_totalStudents;

    @FXML
    private TableColumn<studentData, String> showClass_col_totalExpected;

    @FXML
    private TableColumn<studentData, String> showClass_col_totalOwing;

    @FXML
    private TableColumn<studentData, String> showClass_col_fees;

    @FXML
    private TableColumn<studentData, String> showClass_col_totalPaid;

    @FXML
    private TableView<EnrollmentData> addStudents_tableView;

    @FXML
    private TableView<EnrollmentData> personaTableView;

    @FXML
    private TableView<studentData> sceTableView;

    @FXML
    private TableView<EnrollmentData> showClass_tableView;

    @FXML
    private TableColumn<studentData, String> addStudents_col_studentNum;

    @FXML
    private TableColumn<studentData, String> addStudents_col_year;

    @FXML
    private TableColumn<studentData, String> addStudents_col_course;

    @FXML
    private TableColumn<studentData, String> addStudents_col_firstName;

    @FXML
    private TableColumn<studentData, String> addStudents_col_lastName;

    @FXML
    private TableColumn<studentData, String> addStudents_col_gender;

    @FXML
    private TableColumn<studentData, String> addStudents_col_birth;

    @FXML
    private TableColumn<studentData, String> addStudents_col_status;

    @FXML
    private TextField addStudents_studentNum;

    @FXML
    private ComboBox<String> addClass_year;

    @FXML
    private ComboBox<String> addStudent_year;

    @FXML
    private ComboBox<String> addStudent_class;

    @FXML
    private ComboBox<String> addStudent_section;

    @FXML
    private ComboBox<?> addStudents_course;

    @FXML
    private TextField addStudents_firstName;

    @FXML
    private TextField student_amount;

    @FXML
    private CheckBox other_amount;

    @FXML
    private TextField student_contact;

    @FXML
    private TextField addStudents_lastName;

    @FXML
    private DatePicker addStudents_birth;

    @FXML
    private DatePicker dob;

    @FXML
    private DatePicker teachers_dob;

    @FXML
    private ComboBox<?> addStudents_status;

    @FXML
    private ComboBox<String> std_gender;

    @FXML
    private ComboBox<?> addStudents_gender;

    @FXML
    private ComboBox<String> updateteacher_category;

    @FXML
    private ComboBox<?> addteacher_gender;

    @FXML
    private ImageView addStudents_imageView;

    @FXML
    private ImageView school_logo;

    @FXML
    private Button addschool_logo;

    @FXML
    private Button updateTeacher;

    @FXML
    private Button maintainTeacher;

    @FXML
    private Button weaklyRecord_Download;

    @FXML
    private Button yearlyRecord_Download;

    @FXML
    private Button addStudents_insertBtn;

    @FXML
    private Button addStudents_addBtn;

    @FXML
    private Button manageClass_btn;

    @FXML
    private Button addClass_btn;

    @FXML
    private Button classAdd_btn;

    @FXML
    private Button class_sectionAdd_btn;

    @FXML
    private Button addStudents_updateBtn;

    @FXML
    private Button addStudents_deleteBtn;

    @FXML
    private Button addStudents_clearBtn;

    @FXML
    private AnchorPane all_students_form;

    @FXML
    private TextField school_name;

    @FXML
    private TextField principal;

    @FXML
    private TextField address;

    @FXML
    private Label show_address;

    @FXML
    private Label promoteStudentName;

    @FXML
    private Label promoteStudentMat;

    @FXML
    private Label promoteStudentYear;

    @FXML
    private TextField teacher_name;

    @FXML
    private TextField teacher_number;

    @FXML
    private TextField teacher_subject;

    @FXML
    private TextField teacher_id;

    @FXML
    private TextField teacher_origin;

    @FXML
    private TextField teacher_search;

    @FXML
    private Label studentLabel;

    @FXML
    private Label id;

    @FXML
    private Label show_principal;

    @FXML
    private Label show_SchoolName;

    @FXML
    private Label show_AcademicYear;

    @FXML
    private Label classshow_AcademicYear;

    @FXML
    private Button availableCourse_updateBtn;

    @FXML
    private Button availableCourse_clearBtn;

    @FXML
    private Button availableCourse_deleteBtn;

    @FXML
    private Button material_sbmt;

    @FXML
    private ToggleGroup classes;

    @FXML
    private ToggleGroup material;

    @FXML
    private AnchorPane marksheet_form;

    @FXML
    private TextField studentGrade_studentNum;

    @FXML
    private TextField update_name;
    @FXML
    private TextField update_contact;

    @FXML
    private TextField schorlaship;

    @FXML
    private TextField payments;

    @FXML
    private Label studentGrade_year;

    @FXML
    private Label studentGrade_course;

    @FXML
    private TextField studentGrade_firstSem;

    @FXML
    private TextField studentGrade_secondSem;

    @FXML
    private Button studentGrade_updateBtn;

    @FXML
    private Button studentGrade_clearBtn;

    @FXML
    private TableView<teacherData> teachers_tableView;

    @FXML
    private TableColumn<studentData, String> teachername_col;

    @FXML
    private TableColumn<studentData, String> teachernumber_col;

    @FXML
    private TableColumn<studentData, String> teacherage_col;

    @FXML
    private TableColumn<studentData, String> teachersex_col;

    @FXML
    private TableColumn<studentData, String> teacherhours_col;

    @FXML
    private TableColumn<studentData, String> teacherperiod_col;

    @FXML
    private TableView<studentData> studentGrade_tableView;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_studentNum;

    @FXML
    private TableColumn<EnrollmentData, String> payment_col;

    @FXML
    private TableColumn<EnrollmentData, String> date_col;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_year;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_course;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_firstSem;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_secondSem;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_final;

    @FXML
    private TextField studentGrade_search;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private File imageFile = new File("src/main/resources/pics/logo.jpg");
    private int selectedStudentId = -1;
    private String selectedStudentMatricule = "";
    private String academicYear = "";
    private String selectedStudentName = "";
    private Image image;

    public int homeDisplayTotalEnrolledStudents() {
        int countEnrolled = 0;
        String academicYear = null;

        // Retrieve academic year from the settings table
        String sqlSettings = "SELECT academicYear FROM settings";

        Connection settingsConnection = null;
        Connection studentConnection = null;

        try {
            settingsConnection = Database.connectDb();
            prepare = settingsConnection.prepareStatement(sqlSettings);
            result = prepare.executeQuery();

            if (result.next()) {
                academicYear = result.getString("academicYear");
            }

            // Close the resources related to the settings query
            result.close();
            prepare.close();
            settingsConnection.close();

            if (academicYear != null) {
                String sqlEnrolled = "SELECT COUNT(id) FROM enrollments WHERE academic_year = ?";

                studentConnection = Database.connectDb();
                prepare = studentConnection.prepareStatement(sqlEnrolled);
                prepare.setString(1, academicYear);
                result = prepare.executeQuery();

                if (result.next()) {
                    countEnrolled = result.getInt(1); // Use column index instead of column name
                }

                home_totalEnrolled.setText(String.valueOf(countEnrolled));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources (result, prepare, connect, etc.) here
            try {
                if (result != null) {
                    result.close();
                }
                if (prepare != null) {
                    prepare.close();
                }
                if (settingsConnection != null) {
                    settingsConnection.close();
                }
                if (studentConnection != null) {
                    studentConnection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return countEnrolled;
    }

    public void homeDisplayFemaleEnrolled() {
        String academicYear = null;

        // Retrieve academic year from the settings table
        String sqlSettings = "SELECT academicYear FROM settings";

        try {
            Connection settingsConnection = Database.connectDb();
            PreparedStatement prepare = settingsConnection.prepareStatement(sqlSettings);
            ResultSet result = prepare.executeQuery();

            if (result.next()) {
                academicYear = result.getString("academicYear");
            }

            // Close the resources related to the settings query
            result.close();
            prepare.close();
            settingsConnection.close();

            if (academicYear != null) {
                String sql = "SELECT COUNT(e.id) " +
                        "FROM enrollments e " +
                        "JOIN students s ON e.student_id = s.matricule " +
                        "WHERE s.gender = 'Female' AND e.academic_year = ?";

                Connection studentConnection = Database.connectDb();
                PreparedStatement prepareStudent = studentConnection.prepareStatement(sql);
                prepareStudent.setString(1, academicYear);
                ResultSet resultStudent = prepareStudent.executeQuery();

                int countFemale = 0;
                if (resultStudent.next()) {
                    countFemale = resultStudent.getInt(1);
                }

                // Close the resources related to the student query
                resultStudent.close();
                prepareStudent.close();
                studentConnection.close();

                home_totalFemale.setText(String.valueOf(countFemale));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayOwing() {
        String academicYear = null;

        // Retrieve academic year from the settings table
        String sqlSettings = "SELECT academicYear FROM settings";

        try {
            Connection settingsConnection = Database.connectDb();
            PreparedStatement prepareSettings = settingsConnection.prepareStatement(sqlSettings);
            ResultSet resultSettings = prepareSettings.executeQuery();

            if (resultSettings.next()) {
                academicYear = resultSettings.getString("academicYear");
            }

            // Close the resources related to the settings query
            resultSettings.close();
            prepareSettings.close();
            settingsConnection.close();

            if (academicYear != null) {
                String sql = "SELECT COUNT(id) FROM enrollments WHERE status = 'incomplete' AND academic_year = ?";

                Connection studentConnection = Database.connectDb();
                PreparedStatement prepareStudent = studentConnection.prepareStatement(sql);
                prepareStudent.setString(1, academicYear);
                ResultSet resultStudent = prepareStudent.executeQuery();

                int countOwing = 0;
                if (resultStudent.next()) {
                    countOwing = resultStudent.getInt(1);
                }

                // Close the resources related to the student query
                resultStudent.close();
                prepareStudent.close();
                studentConnection.close();

                students_owing.setText(String.valueOf(countOwing));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void homeCollectedFees() {
        String academicYear = null;

        // Retrieve academic year from the settings table
        String sqlSettings = "SELECT academicYear FROM settings";

        try {
            Connection settingsConnection = Database.connectDb();
            PreparedStatement prepareSettings = settingsConnection.prepareStatement(sqlSettings);
            ResultSet resultSettings = prepareSettings.executeQuery();

            if (resultSettings.next()) {
                academicYear = resultSettings.getString("academicYear");
            }

            // Close the resources related to the settings query
            resultSettings.close();
            prepareSettings.close();
            settingsConnection.close();

            if (academicYear != null) {
                String sql = "SELECT SUM(total_fees_paid) FROM enrollments WHERE academic_year = ?";

                Connection studentConnection = Database.connectDb();
                PreparedStatement prepareStudent = studentConnection.prepareStatement(sql);
                prepareStudent.setString(1, academicYear);
                ResultSet resultStudent = prepareStudent.executeQuery();

                int sumFees = 0;
                DecimalFormat currencyFormat = new DecimalFormat("#,##0");
                if (resultStudent.next()) {
                    sumFees = resultStudent.getInt(1);
                }

                // Close the resources related to the student query
                resultStudent.close();
                prepareStudent.close();
                studentConnection.close();

                fees_collected.setText(currencyFormat.format(sumFees));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayExpected() {
        String academicYear = null;

        // Retrieve academic year from the settings table
        String sqlSettings = "SELECT academicYear FROM settings";

        try {
            Connection settingsConnection = Database.connectDb();
            PreparedStatement prepareSettings = settingsConnection.prepareStatement(sqlSettings);
            ResultSet resultSettings = prepareSettings.executeQuery();

            if (resultSettings.next()) {
                academicYear = resultSettings.getString("academicYear");
            }

            // Close the resources related to the settings query
            resultSettings.close();
            prepareSettings.close();
            settingsConnection.close();

            if (academicYear != null) {
                String sql = "SELECT SUM(school_fees) FROM enrollments WHERE academic_year = ?";

                Connection studentConnection = Database.connectDb();
                PreparedStatement prepareStudent = studentConnection.prepareStatement(sql);
                prepareStudent.setString(1, academicYear);
                ResultSet resultStudent = prepareStudent.executeQuery();

                int sumFees = 0;
                DecimalFormat currencyFormat = new DecimalFormat("#,##0");
                if (resultStudent.next()) {
                    sumFees = resultStudent.getInt(1);
                }

                // Close the resources related to the student query
                resultStudent.close();
                prepareStudent.close();
                studentConnection.close();

                students_total_expected.setText(currencyFormat.format(sumFees));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displaySchoolInfo() {
        String sql = "SELECT schoolName, principal, address, academicYear FROM settings";

        connect = Database.connectDb();

        try {
            String school = "";
            String princi = "";
            String add = "";
            String academicYear = "";

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                school = result.getString("schoolName");
                princi = result.getString("principal");
                add = result.getString("address");
                academicYear = result.getString("academicYear");
            }

            show_SchoolName.setText(school);
            school_name.setText(school);
            principal.setText(princi);
            address.setText(add);
            school_year.setValue(academicYear);
            show_principal.setText(princi);
            show_address.setText(add);
            show_AcademicYear.setText(academicYear);
            classshow_AcademicYear.setText(academicYear);
            students_year.setText(academicYear);
            marksheet_year.setText(academicYear);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null)
                    result.close();
                if (prepare != null)
                    prepare.close();
                if (connect != null)
                    connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void displayTotalOwing() {
        String academicYear = null;
        Connection settingsConnection = null;
        PreparedStatement prepareSettings = null;
        ResultSet resultSettings = null;

        try {
            // Retrieve academic year from the settings table
            String sqlSettings = "SELECT academicYear FROM settings";
            settingsConnection = Database.connectDb();
            prepareSettings = settingsConnection.prepareStatement(sqlSettings);
            resultSettings = prepareSettings.executeQuery();

            if (resultSettings.next()) {
                academicYear = resultSettings.getString("academicYear");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSettings != null)
                    resultSettings.close();
                if (prepareSettings != null)
                    prepareSettings.close();
                if (settingsConnection != null)
                    settingsConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (academicYear != null) {
            Connection studentConnection = null;
            PreparedStatement prepareStudent = null;
            ResultSet resultStudent = null;

            try {
                String sql = "SELECT SUM(e.school_fees - e.total_fees_paid) AS amount_owing " +
                        "FROM enrollments e " +
                        "WHERE e.academic_year = ?";

                studentConnection = Database.connectDb();
                prepareStudent = studentConnection.prepareStatement(sql);
                prepareStudent.setString(1, academicYear);
                resultStudent = prepareStudent.executeQuery();

                int sumAmt = 0;
                DecimalFormat currencyFormat = new DecimalFormat("#,##0");
                if (resultStudent.next()) {
                    sumAmt = resultStudent.getInt(1);
                }

                students_total_owing.setText(currencyFormat.format(sumAmt));
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (resultStudent != null)
                        resultStudent.close();
                    if (prepareStudent != null)
                        prepareStudent.close();
                    if (studentConnection != null)
                        studentConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void homeDisplayMaleEnrolled() {
        String academicYear = null;
        Connection settingsConnection = null;
        PreparedStatement prepareSettings = null;
        ResultSet resultSettings = null;

        try {
            // Retrieve academic year from the settings table
            String sqlSettings = "SELECT academicYear FROM settings";
            settingsConnection = Database.connectDb();
            prepareSettings = settingsConnection.prepareStatement(sqlSettings);
            resultSettings = prepareSettings.executeQuery();

            if (resultSettings.next()) {
                academicYear = resultSettings.getString("academicYear");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSettings != null)
                    resultSettings.close();
                if (prepareSettings != null)
                    prepareSettings.close();
                if (settingsConnection != null)
                    settingsConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (academicYear != null) {
            Connection studentConnection = null;
            PreparedStatement prepareStudent = null;
            ResultSet resultStudent = null;

            try {
                String sql = "SELECT COUNT(e.id) " +
                        "FROM enrollments e " +
                        "JOIN students s ON e.student_id = s.matricule " +
                        "WHERE s.gender = 'Male' AND e.academic_year = ?";
                studentConnection = Database.connectDb();
                prepareStudent = studentConnection.prepareStatement(sql);
                prepareStudent.setString(1, academicYear);
                resultStudent = prepareStudent.executeQuery();

                int countMale = 0;
                if (resultStudent.next()) {
                    countMale = resultStudent.getInt(1);
                }

                home_totalMale.setText(String.valueOf(countMale));
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (resultStudent != null)
                        resultStudent.close();
                    if (prepareStudent != null)
                        prepareStudent.close();
                    if (studentConnection != null)
                        studentConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void homeDisplayTotalEnrolledChart() {
        home_totalEnrolledChart.getData().clear();

        String sqlSettings = "SELECT academicYear FROM settings";

        try {
            Connection settingsConnection = Database.connectDb();
            PreparedStatement settingsPrepare = settingsConnection.prepareStatement(sqlSettings);
            ResultSet settingsResult = settingsPrepare.executeQuery();

            String academicYear = null;
            if (settingsResult.next()) {
                academicYear = settingsResult.getString("academicYear");
            }

            // Close the resources related to the settings query
            settingsResult.close();
            settingsPrepare.close();
            settingsConnection.close();

            if (academicYear != null) {
                String sql = "SELECT DATE(created_at) AS created_date, COUNT(id) " +
                        "FROM enrollments " +
                        "WHERE academic_year = ? " +
                        "GROUP BY DATE(created_at) " +
                        "ORDER BY DATE(created_at) ASC";

                connect = Database.connectDb();

                try {
                    XYChart.Series chart = new XYChart.Series();

                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, academicYear);
                    result = prepare.executeQuery();

                    while (result.next()) {
                        chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
                    }

                    home_totalEnrolledChart.getData().add(chart);

                    // Close the resources related to the student query
                    result.close();
                    prepare.close();
                    connect.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void homeDisplayFemaleEnrolledChart() {
        home_totalFemaleChart.getData().clear();

        String sqlSettings = "SELECT academicYear FROM settings";

        try {
            Connection settingsConnection = Database.connectDb();
            PreparedStatement settingsPrepare = settingsConnection.prepareStatement(sqlSettings);
            ResultSet settingsResult = settingsPrepare.executeQuery();

            String academicYear = null;
            if (settingsResult.next()) {
                academicYear = settingsResult.getString("academicYear");
            }

            // Close the resources related to the settings query
            settingsResult.close();
            settingsPrepare.close();
            settingsConnection.close();

            if (academicYear != null) {
                String sql = "SELECT DATE(e.created_at) AS created_date, COUNT(e.id) " +
                        "FROM enrollments e " +
                        "JOIN students s ON e.student_id = s.matricule " +
                        "WHERE e.academic_year = ? AND s.gender = 'Female' " +
                        "GROUP BY DATE(e.created_at) " +
                        "ORDER BY DATE(e.created_at) ASC";

                connect = Database.connectDb();

                try {
                    XYChart.Series chart = new XYChart.Series();

                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, academicYear);
                    result = prepare.executeQuery();

                    while (result.next()) {
                        chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
                    }

                    home_totalFemaleChart.getData().add(chart);

                    // Close the resources related to the student query
                    result.close();
                    prepare.close();
                    connect.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void homeDisplayEnrolledMaleChart() {
        home_totalMaleChart.getData().clear();

        String sqlSettings = "SELECT academicYear FROM settings";

        try {
            Connection settingsConnection = Database.connectDb();
            PreparedStatement settingsPrepare = settingsConnection.prepareStatement(sqlSettings);
            ResultSet settingsResult = settingsPrepare.executeQuery();

            String academicYear = null;
            if (settingsResult.next()) {
                academicYear = settingsResult.getString("academicYear");
            }

            // Close the resources related to the settings query
            settingsResult.close();
            settingsPrepare.close();
            settingsConnection.close();

            if (academicYear != null) {
                String sql = "SELECT DATE(e.created_at) AS created_date, COUNT(e.id) " +
                        "FROM enrollments e " +
                        "JOIN students s ON e.student_id = s.matricule " +
                        "WHERE e.academic_year = ? AND s.gender = 'Male' " +
                        "GROUP BY DATE(e.created_at) " +
                        "ORDER BY DATE(e.created_at) ASC";

                connect = Database.connectDb();

                try {
                    XYChart.Series chart = new XYChart.Series();

                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, academicYear);
                    result = prepare.executeQuery();

                    while (result.next()) {
                        chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
                    }

                    home_totalMaleChart.getData().add(chart);

                    // Close the resources related to the student query
                    result.close();
                    prepare.close();
                    connect.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showClassInfo(String classNameParam) {
        // connect = Database.connectDb();
        try {
            String query = "SELECT * FROM class WHERE class_name = ?";
            prepare = connect.prepareStatement(query);
            prepare.setString(1, classNameParam);
            result = prepare.executeQuery();

            if (result.next()) {
                String className = result.getString("class_name");
                double schoolFees = result.getDouble("school_fees");
                boolean A1 = result.getBoolean("A1");
                boolean A2 = result.getBoolean("A2");
                boolean B1 = result.getBoolean("B1");
                boolean B2 = result.getBoolean("B2");
                boolean Arts = result.getBoolean("Arts");
                boolean Science = result.getBoolean("Science");
                boolean Commercial = result.getBoolean("Commercial");
                boolean C = result.getBoolean("C");

                // Set the text of the labels to display class info
                showClassName.setText("Class Name: " + className);
                showclassfees.setText("School Fees: " + schoolFees);
                showclassA1.setText("A1: " + A1);
                showClassA2.setText("A2: " + A2);
                showClassB1.setText("B1: " + B1);
                showClassB2.setText("B2: " + B2);
                showClassArts.setText("Arts: " + Arts);
                showClassScience.setText("Science: " + Science);
                showClassCommercial.setText("Commercial: " + Commercial);
                showClassCommercial.setText("C: " + C);
            } else {
                // Class not found in the database
                // Hide the labels and display an error message
                showClassName.setVisible(false);
                showclassfees.setVisible(false);
                showclassA1.setVisible(false);
                showClassA2.setVisible(false);
                showClassB1.setVisible(false);
                showClassB2.setVisible(false);
                showClassArts.setVisible(false);
                showClassScience.setVisible(false);
                showClassCommercial.setVisible(false);

                // errorMessageLabel.setVisible(true);
                // errorMessageLabel.setText("Class not created yet.");
                // errorMessageLabel.setTextFill(Color.RED);
                // errorMessageLabel.setStyle("-fx-font-size: 18;");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any exceptions that occur during the database query
        }
    }

    private String getAcademicYearFromSettings() {
        String sqlSettings = "SELECT academicYear FROM settings";
        try (Connection settingsConnection = Database.connectDb();
                PreparedStatement settingsPrepare = settingsConnection.prepareStatement(sqlSettings);
                ResultSet settingsResult = settingsPrepare.executeQuery()) {

            if (settingsResult.next()) {
                return settingsResult.getString("academicYear");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    // public void addClassesAdd() {
    //     String insertData = "INSERT INTO class "
    //             + "(class_name, school_fees, academic_year, A1, A2, B1, B2, Arts, Science, Commercial, C, category) "
    //             + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    //     String checkData = "SELECT DISTINCT class_name, school_fees, A1, A2, B1, B2, Arts, Science, Commercial, C, category "
    //             + "FROM class WHERE class_name = ? AND academic_year = ? AND category = ?";

    //     String updateData = "UPDATE class SET school_fees = ?, A1 = ?, A2 = ?, B1 = ?, B2 = ?, Arts = ?, Science = ?, Commercial = ?, C = ?, category = ? "
    //             + "WHERE class_name = ? AND academic_year = ? AND category = ?";

    //     Connection connect = null;
    //     PreparedStatement checkPrepare = null;
    //     PreparedStatement prepare = null;
    //     PreparedStatement updatePrepare = null;

    //     try {
    //         connect = Database.connectDb();
    //         if (connect == null) {
    //             showAlert("Database Error", "Database connection could not be established.", Alert.AlertType.ERROR);
    //             return;
    //         }

    //         checkPrepare = connect.prepareStatement(checkData);
    //         prepare = connect.prepareStatement(insertData);
    //         updatePrepare = connect.prepareStatement(updateData);

    //         if (classes.getSelectedToggle() == null
    //                 || enter_fees.getText().isEmpty()
    //                 || department.getSelectionModel().isEmpty()
    //                 || (!A1_btn.isSelected()
    //                         && !A2_btn.isSelected()
    //                         && !B1_btn.isSelected()
    //                         && !b2_btn.isSelected()
    //                         && !C_btn.isSelected()
    //                         && !arts_btn.isSelected()
    //                         && !science_btn.isSelected()
    //                         && !commercial_btn.isSelected())) {

    //             showAlert("Error Message", "Please fill all blank fields", Alert.AlertType.ERROR);
    //         } else {
    //             String academicYear = getAcademicYearFromSettings();
    //             String selectedCategory = department.getSelectionModel().getSelectedItem();

    //             if (academicYear == null) {
    //                 showAlert("Error Message", "Academic year not set in the settings table!", Alert.AlertType.ERROR);
    //             } else {
    //                 checkPrepare.setString(1, ((RadioButton) classes.getSelectedToggle()).getText());
    //                 checkPrepare.setString(2, academicYear);
    //                 checkPrepare.setString(3, selectedCategory);
    //                 ResultSet result = checkPrepare.executeQuery();

    //                 if (result.next()) {
    //                     String existingSections = getCheckedSectionsFromResultSet(result);
    //                     Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
    //                     confirmationAlert.setTitle("Confirmation");
    //                     confirmationAlert.setHeaderText(null);

    //                     confirmationAlert.setContentText("Class "
    //                             + ((RadioButton) classes.getSelectedToggle()).getText() +
    //                             " already has sections (" + existingSections +
    //                             ") for this academic year and category (" + selectedCategory
    //                             + "). Do you wish to update the sections and school fees?");

    //                     Optional<ButtonType> resultButton = confirmationAlert.showAndWait();

    //                     if (resultButton.isPresent() && resultButton.get() == ButtonType.OK) {
    //                         boolean existingA1 = result.getBoolean("A1");
    //                         boolean existingA2 = result.getBoolean("A2");
    //                         boolean existingB1 = result.getBoolean("B1");
    //                         boolean existingB2 = result.getBoolean("B2");
    //                         boolean existingArts = result.getBoolean("Arts");
    //                         boolean existingScience = result.getBoolean("Science");
    //                         boolean existingC = result.getBoolean("C");
    //                         boolean existingCommercial = result.getBoolean("Commercial");

    //                         updatePrepare.setString(1, enter_fees.getText());
    //                         updatePrepare.setBoolean(2, A1_btn.isSelected() ? true : existingA1);
    //                         updatePrepare.setBoolean(3, A2_btn.isSelected() ? true : existingA2);
    //                         updatePrepare.setBoolean(4, B1_btn.isSelected() ? true : existingB1);
    //                         updatePrepare.setBoolean(5, b2_btn.isSelected() ? true : existingB2);
    //                         updatePrepare.setBoolean(6, arts_btn.isSelected() ? true : existingArts);
    //                         updatePrepare.setBoolean(7, science_btn.isSelected() ? true : existingScience);
    //                         updatePrepare.setBoolean(8, commercial_btn.isSelected() ? true : existingCommercial);
    //                         updatePrepare.setBoolean(9, C_btn.isSelected() ? true : existingC);
    //                         updatePrepare.setString(10, selectedCategory);
    //                         updatePrepare.setString(11, ((RadioButton) classes.getSelectedToggle()).getText());
    //                         updatePrepare.setString(12, academicYear);

    //                         // updatePrepare.executeUpdate();

    //                         int rowsUpdated = updatePrepare.executeUpdate();
    //                         if (rowsUpdated > 0) {
    //                             showAlert("Information Message", "Class updated successfully!", Alert.AlertType.INFORMATION);
    //                         } else {
    //                             showAlert("Information Message", "No class was updated. Please check the input data.", Alert.AlertType.WARNING);
    //                         }
    //                         showAllClassListData();
    //                         clearInputs();
    //                     }
    //                 } else {
    //                     prepare.setString(1, ((RadioButton) classes.getSelectedToggle()).getText());
    //                     prepare.setString(2, enter_fees.getText());
    //                     prepare.setString(3, academicYear);
    //                     prepare.setBoolean(4, A1_btn.isSelected());
    //                     prepare.setBoolean(5, A2_btn.isSelected());
    //                     prepare.setBoolean(6, B1_btn.isSelected());
    //                     prepare.setBoolean(7, b2_btn.isSelected());
    //                     prepare.setBoolean(8, arts_btn.isSelected());
    //                     prepare.setBoolean(9, science_btn.isSelected());
    //                     prepare.setBoolean(10, commercial_btn.isSelected());
    //                     prepare.setBoolean(11, C_btn.isSelected());
    //                     prepare.setString(12, selectedCategory);

    //                     prepare.executeUpdate();

    //                     showAlert("Information Message", "Successfully Added!", Alert.AlertType.INFORMATION);

    //                     showAllClassListData();
    //                     clearInputs();
    //                 }
    //             }
    //         }
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         showAlert("Database Error", "Error occurred while accessing the database: " + e.getMessage(),
    //                 Alert.AlertType.ERROR);
    //     } finally {
    //         try {
    //             if (checkPrepare != null)
    //                 checkPrepare.close();
    //             if (prepare != null)
    //                 prepare.close();
    //             if (updatePrepare != null)
    //                 updatePrepare.close();
    //             if (connect != null)
    //                 connect.close();
    //         } catch (SQLException e) {
    //             e.printStackTrace();
    //             showAlert("Database Error", "Error occurred while closing the database connection: " + e.getMessage(),
    //                     Alert.AlertType.ERROR);
    //         }
    //     }
    // }

public void addClassesAdd() {
    String insertData = "INSERT INTO class (class_name, school_fees, academic_year, A1, A2, B1, B2, Arts, Science, Commercial, C, category) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    // We'll format this template with the column name (controlled list) e.g. "Arts"
    String checkDataTemplate = "SELECT id, school_fees FROM class WHERE class_name = ? AND academic_year = ? AND category = ? AND %s = 1";
    String updateData = "UPDATE class SET school_fees = ? WHERE id = ?";

    try (Connection connect = Database.connectDb()) {
        if (connect == null) {
            showAlert("Database Error", "Database connection could not be established.", Alert.AlertType.ERROR);
            return;
        }

        // Basic UI validation
        if (classes.getSelectedToggle() == null
                || enter_fees.getText().isEmpty()
                || department.getSelectionModel().isEmpty()
                || (!A1_btn.isSelected() && !A2_btn.isSelected() && !B1_btn.isSelected()
                    && !b2_btn.isSelected() && !C_btn.isSelected()
                    && !arts_btn.isSelected() && !science_btn.isSelected() && !commercial_btn.isSelected())) {

            showAlert("Error Message", "Please fill all blank fields", Alert.AlertType.ERROR);
            return;
        }

        String className = ((RadioButton) classes.getSelectedToggle()).getText().trim();
        String academicYear = getAcademicYearFromSettings();
        String selectedCategory = department.getSelectionModel().getSelectedItem().trim();
        String feesText = enter_fees.getText().trim();

        if (academicYear == null || academicYear.trim().isEmpty()) {
            showAlert("Error Message", "Academic year not set in the settings table!", Alert.AlertType.ERROR);
            return;
        }

        // Validate fee numeric value
        final java.math.BigDecimal feeValue;
        try {
            feeValue = new java.math.BigDecimal(feesText);
        } catch (NumberFormatException nfe) {
            showAlert("Error Message", "Enter a valid numeric fee amount.", Alert.AlertType.ERROR);
            return;
        }

        // Use AtomicBoolean because the lambda needs an effectively final mutable flag
        final java.util.concurrent.atomic.AtomicBoolean anyChange = new java.util.concurrent.atomic.AtomicBoolean(false);

        // Helper that processes a single section (column name must be from the controlled set below)
        java.util.function.BiConsumer<String, Boolean> processSection = (section, selected) -> {
            if (!selected) return;

            // Build the check query for this exact section column
            String formattedCheck = String.format(checkDataTemplate, section);

            try (PreparedStatement checkStmt = connect.prepareStatement(formattedCheck)) {
                checkStmt.setString(1, className);
                checkStmt.setString(2, academicYear);
                checkStmt.setString(3, selectedCategory);

                try (ResultSet rs = checkStmt.executeQuery()) {
                    if (rs.next()) {
                        // A row already exists for this specific section -> ask for confirmation before updating
                        int existingId = rs.getInt("id");
                        String existingFee = rs.getString("school_fees"); // safe to show as string

                        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
                        confirmationAlert.setTitle("Confirm Update");
                        confirmationAlert.setHeaderText(null);
                        confirmationAlert.setContentText(
                                "Section \"" + section + "\" already exists for class \"" + className + "\"\n"
                                + "Category: " + (selectedCategory == null ? "N/A" : selectedCategory) + "\n"
                                + "Academic Year: " + academicYear + "\n"
                                + "Existing fee: " + existingFee + "\n\n"
                                + "Do you want to update its fee to: " + feeValue.toPlainString() + " ?"
                        );

                        Optional<ButtonType> res = confirmationAlert.showAndWait();
                        if (res.isPresent() && res.get() == ButtonType.OK) {
                            try (PreparedStatement updateStmt = connect.prepareStatement(updateData)) {
                                updateStmt.setBigDecimal(1, feeValue);
                                updateStmt.setInt(2, existingId);
                                int updated = updateStmt.executeUpdate();
                                if (updated > 0) {
                                    anyChange.set(true);
                                }
                            }
                        } else {
                            // User cancelled update for this section — skip it.
                        }
                    } else {
                        // No row for this section -> insert a new row with only this section = 1 (others 0)
                        try (PreparedStatement insertStmt = connect.prepareStatement(insertData)) {
                            insertStmt.setString(1, className);
                            insertStmt.setBigDecimal(2, feeValue);
                            insertStmt.setString(3, academicYear);

                            insertStmt.setInt(4, section.equals("A1") ? 1 : 0);         // A1
                            insertStmt.setInt(5, section.equals("A2") ? 1 : 0);         // A2
                            insertStmt.setInt(6, section.equals("B1") ? 1 : 0);         // B1
                            insertStmt.setInt(7, section.equals("B2") ? 1 : 0);         // B2
                            insertStmt.setInt(8, section.equals("Arts") ? 1 : 0);       // Arts
                            insertStmt.setInt(9, section.equals("Science") ? 1 : 0);    // Science
                            insertStmt.setInt(10, section.equals("Commercial") ? 1 : 0);// Commercial
                            insertStmt.setInt(11, section.equals("C") ? 1 : 0);         // C

                            insertStmt.setString(12, selectedCategory);
                            int inserted = insertStmt.executeUpdate();
                            if (inserted > 0) anyChange.set(true);
                        }
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        };

        processSection.accept("A1", A1_btn.isSelected());
        processSection.accept("A2", A2_btn.isSelected());
        processSection.accept("B1", B1_btn.isSelected());
        processSection.accept("B2", b2_btn.isSelected());
        processSection.accept("C", C_btn.isSelected());
        processSection.accept("Arts", arts_btn.isSelected());
        processSection.accept("Science", science_btn.isSelected());
        processSection.accept("Commercial", commercial_btn.isSelected());

        // Final feedback to the user
        if (anyChange.get()) {
            showAlert("Information Message", "Class/Section saved successfully!", Alert.AlertType.INFORMATION);
        } else {
            showAlert("Information Message", "No changes were made.", Alert.AlertType.INFORMATION);
        }

        showAllClassListData();
        clearInputs();

    } catch (SQLException e) {
        e.printStackTrace();
        showAlert("Database Error", "Error occurred while accessing the database: " + e.getMessage(), Alert.AlertType.ERROR);
    }
}

    
    

    private void clearInputs() {
        classes.getSelectedToggle().setSelected(false);
        enter_fees.clear();
        A1_btn.setSelected(false);
        A2_btn.setSelected(false);
        B1_btn.setSelected(false);
        b2_btn.setSelected(false);
        C_btn.setSelected(false);
        arts_btn.setSelected(false);
        science_btn.setSelected(false);
        commercial_btn.setSelected(false);
    }

    private String getCheckedSectionsFromResultSet(ResultSet result) throws SQLException {
        StringBuilder sections = new StringBuilder();
        if (result.getBoolean("A1"))
            sections.append("A1 ");
        if (result.getBoolean("A2"))
            sections.append("A2 ");
        if (result.getBoolean("B1"))
            sections.append("B1 ");
        if (result.getBoolean("B2"))
            sections.append("B2 ");
        if (result.getBoolean("Arts"))
            sections.append("Arts ");
        if (result.getBoolean("Science"))
            sections.append("Science ");
        if (result.getBoolean("Commercial"))
            sections.append("Commercial ");
        if (result.getBoolean("C"))
            sections.append("C ");
        return sections.toString().trim();
    }

    public void addStudentsAdd() {
        String insertStudent = "INSERT INTO students (matricule, name, date_of_birth, contact, gender, image) VALUES (?, ?, ?, ?, ?, ?)";
        String insertEnrollment = "INSERT INTO enrollments (student_id, class_name, section, academic_year, status, scholarship, school_fees, total_fees_paid, created_at, category) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String insertPayment = "INSERT INTO fees (enrollment_id, amount_paid, payment_date) VALUES (?, ?, ?)";

        try {
            Connection connect = Database.connectDb();
            if (connect == null) {
                showAlert("Database Error", "Database connection could not be established.", Alert.AlertType.ERROR);
                return;
            }

            Alert alert;
            String academicYear = getAcademicYearFromSettings();

            if (addStudent_class.getSelectionModel().getSelectedItem() == null
                    || addStudent_section.getSelectionModel().getSelectedItem() == null
                    || department_addStudent.getSelectionModel().getSelectedItem() == null
                    || addStudents_firstName.getText().isEmpty()
                    || addStudents_gender.getSelectionModel().getSelectedItem() == null
                    || addStudents_birth.getValue() == null
                    || student_amount.getText().isEmpty()
                    || !isNumeric(student_amount.getText())
                    || !isNumeric(student_contact.getText())) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Please fill all fields correctly. Numeric values are required for Amount and Contact.");
                alert.showAndWait();
                return;
            }

            String selectedSection = (String) addStudent_section.getSelectionModel().getSelectedItem();
            String selectedDepartment = (String) department_addStudent.getSelectionModel().getSelectedItem();
            String className = (String) addStudent_class.getSelectionModel().getSelectedItem();

            // Check if the student already exists
            String checkData = "SELECT matricule FROM students WHERE name = ?";
            try (PreparedStatement checkPrepare = connect.prepareStatement(checkData)) {
                checkPrepare.setString(1, addStudents_firstName.getText());
                ResultSet result = checkPrepare.executeQuery();
                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Student " + addStudents_firstName.getText() + " already exists.");
                    alert.showAndWait();
                    return;
                }
            }

            // Get class_id based on selected class_name, section, and academic_year
            String getClassIdQuery = "SELECT id, school_fees FROM class WHERE class_name = ? AND " 
            + selectedSection + " = 1 AND category = ? AND academic_year = ?";    
            @SuppressWarnings("unused")
            int classId = 0;
            double schoolFees = 0.0;
            try (PreparedStatement classPrepare = connect.prepareStatement(getClassIdQuery)) {
                classPrepare.setString(1, className);
                classPrepare.setString(2, selectedDepartment);
                classPrepare.setString(3, academicYear);
                ResultSet result = classPrepare.executeQuery();
                if (result.next()) {
                    classId = result.getInt("id");
                    schoolFees = result.getDouble("school_fees");
                } else {
                    showAlert("Error", "Class not found for the selected section and academic year.",
                            Alert.AlertType.ERROR);
                    return;
                }
            }

            // Calculate amounts
            double studentAmount = Double.parseDouble(student_amount.getText());
            if (studentAmount > schoolFees) {
                showAlert("Error Message", "The student amount cannot exceed the school fees.", Alert.AlertType.ERROR);
                return;
            }

            // Generate unique matricule for the student
            String matricule = generateMatricule();

            // Insert student record
            try (PreparedStatement studentPrepare = connect.prepareStatement(insertStudent)) {
                studentPrepare.setString(1, matricule);
                studentPrepare.setString(2, addStudents_firstName.getText());
                studentPrepare.setDate(3, Date.valueOf(addStudents_birth.getValue()));
                studentPrepare.setString(4, student_contact.getText());
                studentPrepare.setString(5, (String) addStudents_gender.getSelectionModel().getSelectedItem());
                studentPrepare.setString(6, ""); // Placeholder for image
                studentPrepare.executeUpdate();

                double amountOwing = schoolFees - studentAmount;
                String status = (amountOwing <= 0) ? "OK" : "incomplete";
                String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                // Insert enrollment record
                try (PreparedStatement enrollPrepare = connect.prepareStatement(insertEnrollment,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
                    enrollPrepare.setString(1, matricule);
                    enrollPrepare.setString(2, className);
                    enrollPrepare.setString(3, selectedSection);
                    enrollPrepare.setString(4, academicYear);
                    enrollPrepare.setString(5, status);
                    enrollPrepare.setDouble(6, 0.0); // Assuming no scholarship
                    enrollPrepare.setDouble(7, schoolFees); // Adjusted school fees
                    enrollPrepare.setDouble(8, studentAmount);
                    enrollPrepare.setString(9, currentDate);
                    enrollPrepare.setString(10, selectedDepartment);
                    enrollPrepare.executeUpdate();

                    ResultSet enrollmentKeys = enrollPrepare.getGeneratedKeys();
                    if (enrollmentKeys.next()) {
                        int enrollmentId = enrollmentKeys.getInt(1);

                        // Insert initial payment record
                        try (PreparedStatement paymentPrepare = connect.prepareStatement(insertPayment)) {
                            paymentPrepare.setInt(1, enrollmentId);
                            paymentPrepare.setDouble(2, studentAmount);
                            paymentPrepare.setString(3, currentDate);
                            paymentPrepare.executeUpdate();
                        }
                    }
                }

                showAlert("Information Message", "Successfully Added!", Alert.AlertType.INFORMATION);
                clearInputFields();
                showAllClassListData();
                addStudentsShowListData();
                displayWeeklyTotalPayments();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Database Error", "Error occurred while adding the student: " + e.getMessage(),
                    Alert.AlertType.ERROR);
        }
    }

    private void clearInputFields() {
        addStudents_firstName.clear();
        student_amount.clear();
        student_contact.clear();
        addStudent_class.getSelectionModel().clearSelection();
        addStudent_section.getSelectionModel().clearSelection();
        addStudents_gender.getSelectionModel().clearSelection();
        addStudents_birth.setValue(null);
    }

    @SuppressWarnings("unused")
    private boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void Scholarship() {
        String scholarshipText = schorlaship.getText();

        if (!isNumeric(scholarshipText)) {
            showAlert("Error Message", "Please enter a valid numeric scholarship amount.", Alert.AlertType.ERROR);
            return;
        }

        double scholarshipAmount = Double.parseDouble(scholarshipText);

        String checkStatusQuery = "SELECT status, (school_fees - total_fees_paid) AS amountOwing FROM enrollments WHERE id = ?";
        String updateQuery = "UPDATE enrollments SET school_fees = school_fees - ?, scholarship = scholarship + ? WHERE id = ?";
        String updateStatusQuery = "UPDATE enrollments SET status = 'OK' WHERE id = ?";

        Connection connect = Database.connectDb();
        if (connect == null) {
            showAlert("Database Error", "Database connection could not be established.", Alert.AlertType.ERROR);
            return;
        }

        try {
            // Start a transaction
            connect.setAutoCommit(false);

            // Check the student's status and amount owing
            try (PreparedStatement checkStmt = connect.prepareStatement(checkStatusQuery)) {
                checkStmt.setInt(1, selectedStudentId);
                try (ResultSet result = checkStmt.executeQuery()) {
                    if (result.next()) {
                        String status = result.getString("status");
                        double amountOwing = result.getDouble("amountOwing");

                        if ("OK".equalsIgnoreCase(status)) {
                            showAlert("Error Message",
                                    "Scholarship cannot be applied. The student's status is already 'OK'.",
                                    Alert.AlertType.ERROR);
                            return;
                        }

                        if (scholarshipAmount > amountOwing) {
                            showAlert("Error Message", "Scholarship amount cannot be more than the amount owing.",
                                    Alert.AlertType.ERROR);
                            return;
                        }

                        // Apply the scholarship
                        try (PreparedStatement updateStmt = connect.prepareStatement(updateQuery)) {
                            updateStmt.setDouble(1, scholarshipAmount);
                            updateStmt.setDouble(2, scholarshipAmount);
                            updateStmt.setInt(3, selectedStudentId);

                            int rowsUpdated = updateStmt.executeUpdate();

                            if (rowsUpdated > 0) {
                                // Check if the amount owing becomes zero after scholarship
                                if (amountOwing - scholarshipAmount <= 0) {
                                    try (PreparedStatement statusStmt = connect.prepareStatement(updateStatusQuery)) {
                                        statusStmt.setInt(1, selectedStudentId);
                                        statusStmt.executeUpdate();
                                    }
                                }

                                connect.commit();

                                showAlert("Information Message", "Scholarship applied successfully!",
                                        Alert.AlertType.INFORMATION);
                            } else {
                                connect.rollback();
                                showAlert("Error Message", "Failed to apply scholarship. Please check the student ID.",
                                        Alert.AlertType.ERROR);
                            }
                        } catch (SQLException e) {
                            connect.rollback();
                            throw e;
                        } finally {
                            connect.setAutoCommit(true);
                        }
                    } else {
                        showAlert("Error Message", "Student not found.", Alert.AlertType.ERROR);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Database Error", "Error occurred while applying scholarship: " + e.getMessage(),
                    Alert.AlertType.ERROR);
        } finally {
            try {
                if (connect != null && !connect.isClosed()) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean material_sbmt() {
        Toggle selectedToggle = material.getSelectedToggle();

        if (selectedToggle == null) {
            System.err.println("Error: No toggle selected.");
            return true;
        }

        // Determine the fee and other_fee values based on the selected toggle
        // double fees = 0;
        double otherFees = 0;
        RadioButton selectedbtn = (RadioButton) selectedToggle;
        if (selectedbtn.getId().equals("yes")) {
            // If "Yes" is selected, set fees to 0 and otherFees to 0
            // fees = 0;
            otherFees = 0;
        } else if (selectedbtn.getId().equals("no")) {
            // If "No" is selected, set fees to 5000 and otherFees to 5000
            // fees = 5000;
            otherFees = 5000;
        }

        // Get the connection to the database
        Connection connect = Database.connectDb();

        try {
            String material = "SELECT other_fees FROM students WHERE id = ?";
            double current = 0;
            try (PreparedStatement prepareMaterial = connect.prepareStatement(material)) {
                prepareMaterial.setInt(1, selectedStudentId);
                try (ResultSet resultSet = prepareMaterial.executeQuery()) {
                    if (resultSet.next()) {
                        current = resultSet.getDouble("other_fees");
                    }
                }
            }

            // If other_fees is 0, set selected toggle to "No"; otherwise, set to "Yes"
            if (current == 0) {
                yes.setSelected(true);
            } else {
                no.setSelected(true);
            }

            // Ask for confirmation before submitting the changes
            Alert confirmAlert = new Alert(AlertType.CONFIRMATION);
            confirmAlert.setTitle("Confirmation");
            confirmAlert.setHeaderText("Confirm Fees Update");
            confirmAlert.setContentText("Are you sure you want to update Material fees?");

            // Show the confirmation alert and wait for user response
            ButtonType result = confirmAlert.showAndWait().orElse(ButtonType.CANCEL);

            if (result == ButtonType.OK) {
                // Update the fees and other_fees columns in the student table
                String updateQuery = "UPDATE students SET fees = fees + ?, amount_owing = amount_owing + ?, other_fees =  other_fees + ? WHERE id = ?";
                connect = Database.connectDb();

                try (PreparedStatement prepareUpdate = connect.prepareStatement(updateQuery)) {

                    prepareUpdate.setDouble(1, otherFees);
                    prepareUpdate.setDouble(2, otherFees);
                    prepareUpdate.setDouble(3, otherFees);
                    // Assuming you have a variable studentId that holds the student's ID
                    prepareUpdate.setInt(4, selectedStudentId);

                    int rowsAffected = prepareUpdate.executeUpdate();

                    if (rowsAffected > 0) {
                        Alert successAlert = new Alert(AlertType.INFORMATION);
                        successAlert.setTitle("Success");
                        successAlert.setHeaderText(null);
                        successAlert.setContentText(" Material Fees updated successfully.");
                        successAlert.showAndWait();
                    } else {
                        Alert errorAlert = new Alert(AlertType.ERROR);
                        errorAlert.setTitle("Error");
                        errorAlert.setHeaderText(null);
                        errorAlert.setContentText("Error updating fees and other fees.");
                        errorAlert.showAndWait();
                    }
                }
            } else {
                // User clicked Cancel or closed the dialog, no action needed
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addStudentsUpdate() {
        String updateData = "UPDATE students SET "
                + "name = ?, gender = ?, date_of_birth = ?, contact = ? "
                + "WHERE matricule = ?";

        connect = Database.connectDb();

        try {
            Alert alert;
            if (std_gender.getSelectionModel().getSelectedItem() == null
                    || update_name.getText().isEmpty()
                    || dob.getValue() == null) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all fields");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to update Student " + update_name.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    PreparedStatement preparedStatement = connect.prepareStatement(updateData);
                    preparedStatement.setString(1, update_name.getText());
                    preparedStatement.setString(2, std_gender.getSelectionModel().getSelectedItem());
                    preparedStatement.setDate(3, Date.valueOf(dob.getValue()));
                    preparedStatement.setString(4, update_contact.getText());
                    preparedStatement.setString(5, selectedStudentMatricule);

                    preparedStatement.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    // TO UPDATE THE TABLEVIEW
                    addStudentsShowListData();
                    // TO CLEAR THE FIELDS
                    // addStudentsClear();
                } else {
                    return;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void teacherUpdate() {
        String updateData = "UPDATE teachers SET "
                + "Name = ?, category = ?, subdivision_of_origin = ?, phone_number = ?, "
                + "Subject = ?, salary = ?, Work_Period = ?, national_id = ?, work_Load = ? "
                + "WHERE id = ?";

        try (Connection connect = Database.connectDb()) {
            // Check if any field is empty
            if (updateteacher_category.getSelectionModel().getSelectedItem() == null
                    || updateteacher_name.getText().isEmpty()
                    || updateteacher_hours.getText().isEmpty()
                    || updateteacher_period.getText().isEmpty()
                    || updateteacher_natId.getText().isEmpty()
                    || updateteacher_origin.getText().isEmpty()
                    || updateteacher_subjects.getText().isEmpty()
                    || updateteacher_tel.getText().isEmpty()
                    || updateteacher_salary.getText().isEmpty()) {
                showAlert("Error Message", "Please fill all fields", Alert.AlertType.ERROR);
                return;
            }

            // Validate numeric fields
            StringBuilder errorMessage = new StringBuilder();
            if (!updateteacher_hours.getText().matches("\\d+")) {
                errorMessage.append("Work Load must be a number in hours.(e.g. 40) hours\n");
            }
            if (!updateteacher_period.getText().matches("\\d+")) {
                errorMessage.append("Work Period must be a number in months. (e.g. 10) months\n");
            }
            if (!updateteacher_tel.getText().matches("\\d+")) {
                errorMessage.append("Phone Number must be a number.(e.g. 673909858)\n");
            }
            if (!updateteacher_salary.getText().matches("\\d+")) {
                errorMessage.append("Salary must be a number.(e.g. 200000) XAF\n");
            }

            if (errorMessage.length() > 0) {
                showAlert("Error Message", errorMessage.toString(), Alert.AlertType.ERROR);
                return;
            }

            // Confirm the update action
            Toolkit.getDefaultToolkit().beep();
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to update teacher " + updateteacher_name.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.isPresent() && option.get().equals(ButtonType.OK)) {
                try (PreparedStatement preparedStatement = connect.prepareStatement(updateData)) {
                    // Set the parameters for the prepared statement
                    preparedStatement.setString(1, updateteacher_name.getText());
                    preparedStatement.setString(2, updateteacher_category.getSelectionModel().getSelectedItem());
                    preparedStatement.setString(3, updateteacher_origin.getText());
                    preparedStatement.setString(4, updateteacher_tel.getText());
                    preparedStatement.setString(5, updateteacher_subjects.getText());
                    preparedStatement.setString(6, updateteacher_salary.getText());
                    preparedStatement.setString(7, updateteacher_period.getText());
                    preparedStatement.setString(8, updateteacher_natId.getText());
                    preparedStatement.setString(9, updateteacher_hours.getText());
                    preparedStatement.setInt(10, selectedTeacherId);

                    // Execute the update
                    preparedStatement.executeUpdate();

                    // Show success message
                    showAlert("Success", "Successfully Updated!", Alert.AlertType.INFORMATION);

                    // Update the TableView
                    teacherShowListData();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void processInstallmentPayment() {
        String insertPaymentQuery = "INSERT INTO fees (enrollment_id, amount_paid, payment_date) VALUES (?, ?, ?)";
        String updateEnrollmentQuery = "UPDATE enrollments SET total_fees_paid = total_fees_paid + ? WHERE id = ?";
        Connection connect = null;
        PreparedStatement prepare = null;
        ResultSet result = null;

        try {
            connect = Database.connectDb();

            String payment = payments.getText();
            Double paymentAmount = Double.parseDouble(payment);

            // Get the current school_fees and total_fees_paid from the enrollments table
            String getEnrollmentDataQuery = "SELECT school_fees, total_fees_paid FROM enrollments WHERE id = ?";
            prepare = connect.prepareStatement(getEnrollmentDataQuery);
            prepare.setInt(1, selectedStudentId);
            result = prepare.executeQuery();

            double schoolFees = 0.0;
            double totalFeesPaid = 0.0;
            if (result.next()) {
                schoolFees = result.getDouble("school_fees");
                totalFeesPaid = result.getDouble("total_fees_paid");
            }

            double amountOwing = schoolFees - totalFeesPaid;

            if (amountOwing < paymentAmount) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Payment amount exceeds the amount owing. Please check the payment amount.");
                alert.showAndWait();
                return;
            }

            String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            // Update the fees table with the new installment payment
            prepare = connect.prepareStatement(insertPaymentQuery);
            prepare.setInt(1, selectedStudentId);
            prepare.setDouble(2, paymentAmount);
            prepare.setString(3, currentDate);
            prepare.executeUpdate();

            // Update the enrollments table to reflect the payment received
            prepare = connect.prepareStatement(updateEnrollmentQuery);
            prepare.setDouble(1, paymentAmount);
            prepare.setInt(2, selectedStudentId);
            prepare.executeUpdate();

            // Check if the total fees paid equals the school fees and update status
            // accordingly
            if ((totalFeesPaid + paymentAmount) >= schoolFees) {
                String updateStatusQuery = "UPDATE enrollments SET status = 'OK' WHERE id = ?";
                prepare = connect.prepareStatement(updateStatusQuery);
                prepare.setInt(1, selectedStudentId);
                prepare.executeUpdate();
            }

            studentPaymentData();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Payment of " + paymentAmount + " CFA processed successfully!");
            alert.showAndWait();
            payments.clear();

            calculateTotalPaymentAmounts(connect, null);
            displayWeeklyTotalPayments();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources in the reverse order of their creation
            try {
                if (result != null && !result.isClosed()) {
                    result.close();
                }
                if (prepare != null && !prepare.isClosed()) {
                    prepare.close();
                }
                if (connect != null && !connect.isClosed()) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void addStudentsInsertImage() {

        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new ExtensionFilter("Image File", "*jpg", "*png"));

        File file = open.showOpenDialog(main_form.getScene().getWindow());

        if (file != null) {

            image = new Image(file.toURI().toString(), 120, 149, false, true);
            addStudents_imageView.setImage(image);

            getData.path = file.getAbsolutePath();

        }
    }

    public void addlogo() {

        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new ExtensionFilter("Image File", "*jpg", "*png"));

        File file = open.showOpenDialog(main_form.getScene().getWindow());

        if (file != null) {

            image = new Image(file.toURI().toString(), 120, 149, false, true);
            school_logo.setImage(image);

            getData.path = file.getAbsolutePath();

        }
    }

    public void addStudentsSearch() {

        FilteredList<EnrollmentData> filter = new FilteredList<>(addStudentsListD, e -> true);

        addStudents_search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateStudentData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateStudentData.getStatus().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getStudentId().toString().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getClassName().toLowerCase().contains(searchKey)) {
                    return true;
                    // } else if
                    // (predicateStudentData.getContact().toLowerCase().contains(searchKey)) {
                    // return true;
                } else if (predicateStudentData.getSection().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getOwing().toString().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getGender().toLowerCase().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<EnrollmentData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(addStudents_tableView.comparatorProperty());
        addStudents_tableView.setItems(sortList);

    }

    public ObservableList<teacherData> teacherListData() {
        ObservableList<teacherData> listTeachers = FXCollections.observableArrayList();
        String academicYear = getAcademicYearFromSettings();

        String sql = "SELECT * FROM teachers WHERE academic_year = ?";

        try (Connection connect = Database.connectDb();
                PreparedStatement prepare = connect.prepareStatement(sql)) {

            prepare.setString(1, academicYear);
            try (ResultSet result = prepare.executeQuery()) {
                while (result.next()) {
                    teacherData teacherD = new teacherData(
                            result.getString("name"),
                            result.getInt("Age"),
                            result.getString("Sex"),
                            result.getString("phone_number"),
                            result.getInt("work_Load"),
                            result.getInt("Work_Period"),
                            result.getString("Subject"),
                            result.getString("subdivision_of_origin"),
                            result.getInt("national_id"),
                            result.getInt("Salary"),
                            result.getInt("id"),
                            result.getString("category"));

                    listTeachers.add(teacherD);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTeachers;
    }

    private ObservableList<teacherData> teacherListD;

    public void teacherShowListData() {
        teacherListD = teacherListData();

        teachernumber_col.setCellValueFactory(new PropertyValueFactory<>("contact"));
        teachername_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        teacherperiod_col.setCellValueFactory(new PropertyValueFactory<>("period"));
        teachersex_col.setCellValueFactory(new PropertyValueFactory<>("gender"));
        teacherage_col.setCellValueFactory(new PropertyValueFactory<>("age"));
        teacherhours_col.setCellValueFactory(new PropertyValueFactory<>("hours"));

        teachers_tableView.setItems(teacherListD);
    }

    public void teacherSearch() {
        FilteredList<teacherData> filter = new FilteredList<>(teacherListD, e -> true);

        teacher_search.textProperty().addListener((observable, oldValue, newValue) -> {
            filter.setPredicate(predicateTeacherData -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                // Check all relevant fields for a match
                if (predicateTeacherData.getName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (String.valueOf(predicateTeacherData.getId()).contains(searchKey)) {
                    return true;
                } else if (predicateTeacherData.getContact().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateTeacherData.getGender().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (String.valueOf(predicateTeacherData.getSalary()).contains(searchKey)) {
                    return true;
                } else if (predicateTeacherData.getSubject().toLowerCase().contains(searchKey)) {
                    return true;
                }

                return false;
            });
        });

        SortedList<teacherData> sortList = new SortedList<>(filter);
        sortList.comparatorProperty().bind(teachers_tableView.comparatorProperty());
        teachers_tableView.setItems(sortList);
    }

    private String[] year = { "2024-2025", "2025-2026" };

    @SuppressWarnings("unchecked")
    public void classYear() {
        List<String> academicYear = new ArrayList<>();

        for (String data : year) {
            academicYear.add(data);
        }
        @SuppressWarnings("rawtypes")
        ObservableList ObList = FXCollections.observableArrayList(academicYear);
        school_year.setItems(ObList);
    }

    public void classes() {
        List<String> classNames = new ArrayList<>();
        String query = "SELECT DISTINCT class_name FROM class";

        try (Connection connect = Database.connectDb();
                PreparedStatement prepare = connect.prepareStatement(query);
                ResultSet result = prepare.executeQuery()) {

            while (result.next()) {
                classNames.add(result.getString("class_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Database Error", "Error occurred while fetching classes: " + e.getMessage(),
                    Alert.AlertType.ERROR);
        }

        ObservableList<String> obList = FXCollections.observableArrayList(classNames);
        addStudent_class.setItems(obList);
        classRecord_Download.setItems(obList);
        marksheet_class.setItems(obList);

    }

    private String[] category = { "Administrator", "Staff" };

    @SuppressWarnings("unchecked")
    public void category() {
        List<String> teacherCategory = new ArrayList<>();

        for (String data : category) {
            teacherCategory.add(data);
        }
        @SuppressWarnings("rawtypes")
        ObservableList ObList = FXCollections.observableArrayList(teacherCategory);
        updateteacher_category.setItems(ObList);
    }

    private String[] genderList = { "Male", "Female" };

    @SuppressWarnings("unchecked")
    public void addStudentsGenderList() {
        List<String> genderL = new ArrayList<>();

        for (String data : genderList) {
            genderL.add(data);
        }

        @SuppressWarnings("rawtypes")
        ObservableList ObList = FXCollections.observableArrayList(genderL);
        addStudents_gender.setItems(ObList);
        std_gender.setItems(ObList);
        addteacher_gender.setItems(ObList);
    }

    private String[] departmentList = { "General", "Industrial", "Commercial" };

    @SuppressWarnings("unchecked")
    public void selectDepartment() {
        List<String> departmentL = new ArrayList<>();

        for (String data : departmentList) {
            departmentL.add(data);
        }

        @SuppressWarnings("rawtypes")
        ObservableList ObList = FXCollections.observableArrayList(departmentL);
        department_marksheet.setItems(ObList);
        department.setItems(ObList);
        department_details.setItems(ObList);
        department_addStudent.setItems(ObList);
        promoteDepartment.setItems(ObList);
    }

    @FXML
    private void handleAcademicYearSelection() {
        String selectedYear = getAcademicYearFromSettings();
        if (selectedYear == null) {
            return;
        }

        try {
            // Call the method to retrieve and show classes for the selected year
            showClassesForYear(selectedYear);

        } catch (SQLException e) {
            // Handle any exceptions that might occur while fetching data from the database
            e.printStackTrace();
        }
    }

    private void showClassesForYear(String academicYear) throws SQLException {
        // Assuming you have a table called "classes" with columns "class_name" and
        // "academic_year"
        String query = "SELECT class_name FROM class";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ObservableList<String> classNames = FXCollections.observableArrayList();

        try {
            // connection = Database.connectDb();
            preparedStatement = connect.prepareStatement(query);
            // preparedStatement.setString(1, academicYear);
            resultSet = preparedStatement.executeQuery();

            // Clear any previous items in the ComboBox
            addStudent_class.getItems().clear();

            while (resultSet.next()) {
                String className = resultSet.getString("class_name");
                if (!classNames.contains(className)) {
                    classNames.add(className);
                }
            }

            // Add all class names to the ComboBox
            addStudent_class.setItems(classNames);
            classRecord_Download.setItems(classNames);
            marksheet_class.setItems(classNames);
            promoteClass.setItems(classNames);

        } finally {
            // Close resources in a finally block to ensure they are always closed
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @FXML
    private void handleClassSelection() {
        String selectedClass = addStudent_class.getValue();
        String selectedDep = department_addStudent.getValue();
        if (selectedClass == null) {
            return;
        }
        // Update the selected section based on the selected class
        try {
            showSectionsForClass(selectedClass, selectedDep);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception if necessary
        }
    }

    @FXML
    private void handlePromoteSection() {
        String selectedClass = promoteClass.getValue();
        String selectedYear = promoteDepartment.getValue();
        if (selectedClass == null) {
            return;
        }
        // Update the selected section based on the selected class
        try {
            showPromoteSectionsForClass(selectedClass, selectedYear);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception if necessary
        }
    }

    @FXML
    private void handleStudentClass() {
        String selectedStudentClass = classRecord_Download.getValue();
        String selectedDep = department_details.getValue();
        if (selectedStudentClass == null) {
            return;
        }
        // Update the selected section based on the selected class
        try {
            showSectionsForStudent(selectedStudentClass, selectedDep);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception if necessary
        }
    }

    @FXML
    private void handleClassMarksheet() {
        String selectedClassMarksheet = marksheet_class.getValue();
        String selectedDep = department_marksheet.getValue();
        if (selectedClassMarksheet == null) {
            return;
        }
        // Update the selected section based on the selected class
        try {
            showSectionsForMarksheet(selectedClassMarksheet, selectedDep);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception if necessary
        }
    }

    private void showSectionsForStudent(String className, String academicDep) throws SQLException {
        String query = "SELECT A1, A2, B1, B2, Arts, Science, Commercial, C " +
                "FROM class WHERE class_name = ? AND category = ? AND academic_year = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String selectedStudentClass = null; // Initialize selectedSection to null
        ObservableList<String> classSections = FXCollections.observableArrayList();
         String academicYear = getAcademicYearFromSettings();
        try {
            // connection = Database.connectDb();
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, className);
            preparedStatement.setString(2, academicDep);
            preparedStatement.setString(3, academicYear);
            resultSet = preparedStatement.executeQuery();

            // Clear any previous items in the ComboBox
            SectionRecord_Download.getItems().clear();

            while (resultSet.next()) {
                // Update the selected section based on the retrieved section values
                if (resultSet.getBoolean("A1")) {
                    classSections.add("A1");
                    if (selectedStudentClass == null) {
                        selectedStudentClass = "A1";
                    }
                }
                if (resultSet.getBoolean("A2")) {
                    classSections.add("A2");
                    if (selectedStudentClass == null) {
                        selectedStudentClass = "A2";
                    }
                }
                if (resultSet.getBoolean("B1")) {
                    classSections.add("B1");
                    if (selectedStudentClass == null) {
                        selectedStudentClass = "B1";
                    }
                }
                if (resultSet.getBoolean("B2")) {
                    classSections.add("B2");
                    if (selectedStudentClass == null) {
                        selectedStudentClass = "B2";
                    }
                }
                if (resultSet.getBoolean("Arts")) {
                    classSections.add("Arts");
                    if (selectedStudentClass == null) {
                        selectedStudentClass = "Arts";
                    }
                }
                if (resultSet.getBoolean("Science")) {
                    classSections.add("Science");
                    if (selectedStudentClass == null) {
                        selectedStudentClass = "Science";
                    }
                }
                if (resultSet.getBoolean("Commercial")) {
                    classSections.add("Commercial");
                    if (selectedStudentClass == null) {
                        selectedStudentClass = "Commercial";
                    }
                }
                if (resultSet.getBoolean("C")) {
                    classSections.add("C");
                    if (selectedStudentClass == null) {
                        selectedStudentClass = "C";
                    }
                }
            }
        } catch (SQLException e) {
            // Handle any database errors
            e.printStackTrace();
        } finally {
            // Close the resources (ResultSet, PreparedStatement, and Connection)
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Set the selected section in the ComboBox
        SectionRecord_Download.setItems(classSections);
        if (selectedStudentClass != null) {
            SectionRecord_Download.setValue(selectedStudentClass);
        }
    }

    private void showSectionsForClass(String className, String academicDep) throws SQLException {
        String query = "SELECT A1, A2, B1, B2, Arts, Science, Commercial, C " +
                "FROM class WHERE class_name = ? AND category = ? AND academic_year = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String selectedSection = null; // Initialize selectedSection to null
        ObservableList<String> classSections = FXCollections.observableArrayList();
        String academicYear = getAcademicYearFromSettings();

        try {
            connection = Database.connectDb();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, className);
            preparedStatement.setString(2, academicDep);
            preparedStatement.setString(3, academicYear);
            resultSet = preparedStatement.executeQuery();

            // Clear any previous items in the ComboBox
            addStudent_section.getItems().clear();

            while (resultSet.next()) {
                // Update the selected section based on the retrieved section values
                if (resultSet.getBoolean("A1")) {
                    classSections.add("A1");
                    if (selectedSection == null) {
                        selectedSection = "A1";
                    }
                }
                if (resultSet.getBoolean("A2")) {
                    classSections.add("A2");
                    if (selectedSection == null) {
                        selectedSection = "A2";
                    }
                }
                if (resultSet.getBoolean("B1")) {
                    classSections.add("B1");
                    if (selectedSection == null) {
                        selectedSection = "B1";
                    }
                }
                if (resultSet.getBoolean("B2")) {
                    classSections.add("B2");
                    if (selectedSection == null) {
                        selectedSection = "B2";
                    }
                }
                if (resultSet.getBoolean("Arts")) {
                    classSections.add("Arts");
                    if (selectedSection == null) {
                        selectedSection = "Arts";
                    }
                }
                if (resultSet.getBoolean("Science")) {
                    classSections.add("Science");
                    if (selectedSection == null) {
                        selectedSection = "Science";
                    }
                }
                if (resultSet.getBoolean("Commercial")) {
                    classSections.add("Commercial");
                    if (selectedSection == null) {
                        selectedSection = "Commercial";
                    }
                }
                if (resultSet.getBoolean("C")) {
                    classSections.add("C");
                    if (selectedSection == null) {
                        selectedSection = "C";
                    }
                }
            }
        } catch (SQLException e) {
            // Handle any database errors
            e.printStackTrace();
        } finally {
            // Close the resources (ResultSet, PreparedStatement, and Connection)
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Set the selected section in the ComboBox
        addStudent_section.setItems(classSections);
        if (selectedSection != null) {
            addStudent_section.setValue(selectedSection);
        }
    }

    private void showPromoteSectionsForClass(String className, String academicDep) throws SQLException {
        String query = "SELECT A1, A2, B1, B2, Arts, Science, Commercial, C " +
                "FROM class WHERE class_name = ? AND category = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String selectedSection = null; // Initialize selectedSection to null
        ObservableList<String> classSections = FXCollections.observableArrayList();

        try {
            connection = Database.connectDb();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, className);
            preparedStatement.setString(2, academicDep);
            resultSet = preparedStatement.executeQuery();

            // Clear any previous items in the ComboBox
            PromoteSection.getItems().clear();

            while (resultSet.next()) {
                // Update the selected section based on the retrieved section values
                if (resultSet.getBoolean("A1")) {
                    classSections.add("A1");
                    if (selectedSection == null) {
                        selectedSection = "A1";
                    }
                }
                if (resultSet.getBoolean("A2")) {
                    classSections.add("A2");
                    if (selectedSection == null) {
                        selectedSection = "A2";
                    }
                }
                if (resultSet.getBoolean("B1")) {
                    classSections.add("B1");
                    if (selectedSection == null) {
                        selectedSection = "B1";
                    }
                }
                if (resultSet.getBoolean("B2")) {
                    classSections.add("B2");
                    if (selectedSection == null) {
                        selectedSection = "B2";
                    }
                }
                if (resultSet.getBoolean("Arts")) {
                    classSections.add("Arts");
                    if (selectedSection == null) {
                        selectedSection = "Arts";
                    }
                }
                if (resultSet.getBoolean("Science")) {
                    classSections.add("Science");
                    if (selectedSection == null) {
                        selectedSection = "Science";
                    }
                }
                if (resultSet.getBoolean("Commercial")) {
                    classSections.add("Commercial");
                    if (selectedSection == null) {
                        selectedSection = "Commercial";
                    }
                }
                if (resultSet.getBoolean("C")) {
                    classSections.add("C");
                    if (selectedSection == null) {
                        selectedSection = "C";
                    }
                }
            }
        } catch (SQLException e) {
            // Handle any database errors
            e.printStackTrace();
        } finally {
            // Close the resources (ResultSet, PreparedStatement, and Connection)
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Set the selected section in the ComboBox
        PromoteSection.setItems(classSections);
        if (selectedSection != null) {
            PromoteSection.setValue(selectedSection);
        }
    }

    @FXML
    private void handleSectionSelection() {
        String selectedSection = addStudent_section.getValue();
        if (selectedSection == null) {
            return;
        }
        // Add the logic to handle the selected section here
        try {

        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exceptions that may occur during section selection handling
        }
    }

    private void showSectionsForMarksheet(String className, String academicDep) throws SQLException {
        String query = "SELECT A1, A2, B1, B2, Arts, Science, Commercial, C " +
                "FROM class WHERE class_name = ? AND category = ? AND academic_year = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String selectedClassMarksheet = null; // Initialize selectedSection to null
        ObservableList<String> classSections = FXCollections.observableArrayList();
        String academicYear = getAcademicYearFromSettings();

        try {
            connection = Database.connectDb();
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, className);
            preparedStatement.setString(2, academicDep);
            preparedStatement.setString(3, academicYear);
            resultSet = preparedStatement.executeQuery();

            // Clear any previous items in the ComboBox

            marksheet_section.getItems().clear();

            while (resultSet.next()) {
                // Update the selected section based on the retrieved section values
                if (resultSet.getBoolean("A1")) {
                    classSections.add("A1");
                    if (selectedClassMarksheet == null) {
                        selectedClassMarksheet = "A1";
                    }
                }
                if (resultSet.getBoolean("A2")) {
                    classSections.add("A2");
                    if (selectedClassMarksheet == null) {
                        selectedClassMarksheet = "A2";
                    }
                }
                if (resultSet.getBoolean("B1")) {
                    classSections.add("B1");
                    if (selectedClassMarksheet == null) {
                        selectedClassMarksheet = "B1";
                    }
                }
                if (resultSet.getBoolean("B2")) {
                    classSections.add("B2");
                    if (selectedClassMarksheet == null) {
                        selectedClassMarksheet = "B2";
                    }
                }
                if (resultSet.getBoolean("Arts")) {
                    classSections.add("Arts");
                    if (selectedClassMarksheet == null) {
                        selectedClassMarksheet = "Arts";
                    }
                }
                if (resultSet.getBoolean("Science")) {
                    classSections.add("Science");
                    if (selectedClassMarksheet == null) {
                        selectedClassMarksheet = "Science";
                    }
                }
                if (resultSet.getBoolean("Commercial")) {
                    classSections.add("Commercial");
                    if (selectedClassMarksheet == null) {
                        selectedClassMarksheet = "Commercial";
                    }
                }
                if (resultSet.getBoolean("C")) {
                    classSections.add("C");
                    if (selectedClassMarksheet == null) {
                        selectedClassMarksheet = "C";
                    }
                }
            }
        } catch (SQLException e) {
            // Handle any database errors
            e.printStackTrace();
        } finally {
            // Close the resources (ResultSet, PreparedStatement, and Connection)
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Set the selected section in the ComboBox

        marksheet_section.setItems(classSections);
        if (selectedClassMarksheet != null) {
            marksheet_section.setValue(selectedClassMarksheet);
        }
    }

    @FXML
    private void handleSectionMarksheet() {
        String selectedClassMarksheet = marksheet_section.getValue();
        // String selectedSectionMarksheet = marksheet_section.getValue();
        if (selectedClassMarksheet == null) {
            return;
        }
        // Add the logic to handle the selected section here
        try {

        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exceptions that may occur during section selection handling
        }
    }

    public ObservableList<EnrollmentData> addStudentsListData(String selectedStudentMatricule) {
        ObservableList<EnrollmentData> listStudents = FXCollections.observableArrayList();
        String academicYear = getAcademicYearFromSettings();

        String sql = "SELECT e.id, e.class_name, e.section, e.academic_year, e.status, e.school_fees, e.total_fees_paid, e.student_id, e.scholarship, e.category,"
                +
                "s.name, s.date_of_birth, s.contact, s.gender, " +
                "e.school_fees - e.total_fees_paid AS owing " +
                "FROM enrollments e " +
                "JOIN students s ON e.student_id = s.matricule " +
                "WHERE e.academic_year = ?";
        if (selectedStudentMatricule != null) {
            sql += " AND e.student_id = ?";
        }

        connect = Database.connectDb();

        try {
            EnrollmentData studentD;
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, academicYear);
            if (selectedStudentMatricule != null) {
                prepare.setString(2, selectedStudentMatricule);
            }
            result = prepare.executeQuery();

            while (result.next()) {
                studentD = new EnrollmentData(
                        result.getInt("id"),
                        result.getString("student_id"),
                        result.getString("class_name"),
                        result.getString("section"),
                        null,
                        academicYear,
                        result.getString("status"),
                        result.getDouble("scholarship"),
                        result.getDouble("school_fees"),
                        null,
                        null,
                        null,
                        null,
                        null,
                        result.getString("contact"),
                        result.getString("name"),
                        result.getString("gender"),
                        result.getString("date_of_birth"),
                        result.getDouble("owing"),
                        null,
                        null

                );

                listStudents.add(studentD);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listStudents;
    }

    // ... (rest of the code remains unchanged)

    private ObservableList<EnrollmentData> addStudentsListD;

    public void addStudentsShowListData() {
        addStudentsListD = addStudentsListData(null);

        addStudents_col_studentNum.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        addStudents_col_course.setCellValueFactory(new PropertyValueFactory<>("contact"));
        addStudents_col_firstName.setCellValueFactory(new PropertyValueFactory<>("name"));
        showClass_col_B1.setCellValueFactory(new PropertyValueFactory<>("section"));
        addStudents_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        addStudents_col_birth.setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));
        showClass_col_A2.setCellValueFactory(new PropertyValueFactory<>("className"));
        addStudents_col_lastName.setCellValueFactory(new PropertyValueFactory<>("owing"));
        addStudents_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        addStudents_tableView.setItems(addStudentsListD);

    }

    public void studentPaymentData() {
        ObservableList<EnrollmentData> paymentDataList = FXCollections.observableArrayList();
        String academicYear = getAcademicYearFromSettings();
        String sql = "SELECT f.amount_paid, f.payment_date " +
                "FROM fees f " +
                "JOIN enrollments e ON f.enrollment_id = e.id " +
                "WHERE e.student_id = ? AND e.academic_year = ?";

        connect = Database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, selectedStudentMatricule);
            prepare.setString(2, academicYear);
            result = prepare.executeQuery();

            while (result.next()) {
                EnrollmentData paymentData = new EnrollmentData(
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        result.getDouble("amount_paid"),
                        result.getString("payment_date"));
                paymentDataList.add(paymentData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        date_col.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        payment_col.setCellValueFactory(new PropertyValueFactory<>("amountPaid"));

        personaTableView.setItems(paymentDataList);
    }

    public void addStudentsSelect() {

        EnrollmentData studentD = addStudents_tableView.getSelectionModel().getSelectedItem();
        int num = addStudents_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        personal_form.setVisible(true);

        Double scholarshipValue = studentD.getScholarship();
        if (scholarshipValue != null) {
            schorlaship.setText(String.valueOf(scholarshipValue));
        } else {
            schorlaship.setText("N/A");
        }
        update_name.setText(studentD.getName());
        update_contact.setText(studentD.getContact());
        id.setText(studentD.getStudentId());
        studentLabel.setText(studentD.getName());
        std_gender.setValue(studentD.getGender());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        try {
            LocalDate dateOfBirth = LocalDate.parse(studentD.getDate_of_birth(), formatter);
            dob.setValue(dateOfBirth);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            // Handle invalid date format if necessary
        }

        selectedStudentId = studentD.getId();
        selectedStudentMatricule = studentD.getStudentId();
        selectedStudentName = studentD.getName();

        studentPaymentData();

        promoteStudentName.setText(selectedStudentName);
        promoteStudentMat.setText(selectedStudentMatricule);
    }

    private int selectedTeacherId = -1;

    public void teacherSelect() {
        teacherData teacherD = teachers_tableView.getSelectionModel().getSelectedItem();
        int num = teachers_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        updateTeacher_form.setVisible(true);
        teacherName.setText(teacherD.getName());
        updateteacher_name.setText(teacherD.getName());
        updateteacher_subjects.setText(teacherD.getSubject());
        updateteacher_salary.setText(String.valueOf(teacherD.getSalary()));
        updateteacher_period.setText(String.valueOf(teacherD.getPeriod()));
        updateteacher_hours.setText(String.valueOf(teacherD.getHours()));
        updateteacher_tel.setText(String.valueOf(teacherD.getContact()));
        updateteacher_natId.setText(String.valueOf(teacherD.getNatId()));
        updateteacher_origin.setText(teacherD.getOrigin());
        teacherId.setText(String.valueOf(teacherD.getId()));
        updateteacher_category.setValue(teacherD.getCategory());
        selectedTeacherId = teacherD.getId();

    }

    @SuppressWarnings("resource")
    public void Admins(@SuppressWarnings("exports") ActionEvent event) {
        Connection connect = Database.connectDb();
        if (connect == null) {
            showAlert("Database Error", "Database connection could not be established.", Alert.AlertType.ERROR);
            return;
        }

        try {
            String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            // Create a FileChooser to allow the user to select a directory
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Directory for Download");
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            String suggestedFileName = "Admins_Report_" + currentDate + ".pdf";
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF Files (*.pdf)", "*.pdf");
            fileChooser.getExtensionFilters().add(extFilter);
            fileChooser.setInitialFileName(suggestedFileName);

            // Show the Save As dialog and get the selected file
            javafx.stage.Window window = ((Node) event.getSource()).getScene().getWindow();
            File selectedFile = fileChooser.showSaveDialog(window);
            if (selectedFile == null) {
                showAlert("File Selection", "File selection was cancelled.", Alert.AlertType.WARNING);
                return;
            }

            String filePath = selectedFile.getAbsolutePath();

            try (PdfDocument pdf = new PdfDocument(new PdfWriter(filePath))) {
                Document document = new Document(pdf);

                // Add School Name and Date at the top of the page
                PdfFont boldFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
                PdfFont blueFont = PdfFontFactory.createFont(StandardFonts.HELVETICA);
                // Create a Div element
                Div headerDiv = new Div();
                DecimalFormat currencyFormat = new DecimalFormat("#,##0.00");
                String[] schoolInfo = getSchoolInfoFromSettings();
                String schoolName = schoolInfo[0];
                String principal = schoolInfo[2];
                String address = schoolInfo[3];
                String academicYear = getAcademicYearFromSettings();

                Paragraph schoolNameParagraph = new Paragraph(schoolName)
                        .setFont(boldFont)
                        .setFontSize(14)
                        .setTextAlignment(TextAlignment.CENTER); // Centered alignment

                Paragraph date = new Paragraph("Academic Year: " + academicYear).setFont(blueFont).setFontSize(12);
                Paragraph printed = new Paragraph("Printed Date: " + currentDate).setFont(blueFont).setFontSize(12);
                Paragraph addressParagraph = new Paragraph("Address: " + address).setFont(blueFont).setFontSize(12);
                Paragraph principalParagraph = new Paragraph("Principal: " + principal).setFont(blueFont)
                        .setFontSize(12);

                // Create a table with two columns
                Table table = new Table(2);
                table.setWidth(UnitValue.createPercentValue(100));

                // Add the paragraphs to the table with alignments
                table.addCell(new Cell().add(date).setTextAlignment(TextAlignment.LEFT).setBorder(Border.NO_BORDER));
                table.addCell(
                        new Cell().add(printed).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER));
                table.addCell(new Cell().add(addressParagraph).setTextAlignment(TextAlignment.LEFT)
                        .setBorder(Border.NO_BORDER));
                table.addCell(new Cell().add(principalParagraph).setTextAlignment(TextAlignment.RIGHT)
                        .setBorder(Border.NO_BORDER));

                headerDiv.add(schoolNameParagraph);
                headerDiv.add(table);

                com.itextpdf.layout.element.Image watermarkImage = Logo
                        .createWatermarkImage(imageFile.getAbsolutePath());
                document.add(watermarkImage);
                document.add(headerDiv);

                // Database query to fetch administrators' information
                String selectData = "SELECT Name, age, work_Load, Work_Period, Subject, salary FROM teachers WHERE category = 'Administrator'";
                try (PreparedStatement prepare = connect.prepareStatement(selectData)) {
                    try (ResultSet resultSet = prepare.executeQuery()) {
                        float[] columnWidths = { 150f, 50f, 80f, 80f, 150f, 80f, 100f };
                        Table adminTable = new Table(columnWidths).useAllAvailableWidth();

                        PdfFont headingFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
                        adminTable.addHeaderCell(new Cell().add(new Paragraph("Name").setFont(headingFont)));
                        adminTable.addHeaderCell(new Cell().add(new Paragraph("Age").setFont(headingFont)));
                        adminTable.addHeaderCell(new Cell().add(new Paragraph("Load (hrs)").setFont(headingFont)));
                        adminTable.addHeaderCell(new Cell().add(new Paragraph("Period (mths)").setFont(headingFont)));
                        adminTable.addHeaderCell(new Cell().add(new Paragraph("Subject").setFont(headingFont)));
                        adminTable.addHeaderCell(new Cell().add(new Paragraph("Salary").setFont(headingFont)));
                        adminTable.addHeaderCell(new Cell().add(new Paragraph("Annually").setFont(headingFont)));

                        double totalAnnualSalary = 0.0;
                        int adminCount = 0;

                        while (resultSet.next()) {
                            String name = resultSet.getString("Name");
                            int age = resultSet.getInt("age");
                            double workLoad = resultSet.getDouble("work_Load");
                            double workPeriod = resultSet.getDouble("Work_Period");
                            String subject = resultSet.getString("Subject");
                            double salary = resultSet.getDouble("salary");
                            double annualSalary = workPeriod * salary;

                            adminTable.addCell(name);
                            adminTable.addCell(String.valueOf(age));
                            adminTable.addCell(String.valueOf(workLoad));
                            adminTable.addCell(String.valueOf(workPeriod));
                            adminTable.addCell(subject);
                            adminTable.addCell(currencyFormat.format(salary));
                            adminTable.addCell(currencyFormat.format(annualSalary));

                            totalAnnualSalary += annualSalary;
                            adminCount++;
                        }

                        Paragraph title = new Paragraph("Administrator Report" + "   |   Total: " + adminCount)
                                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                                .setFontSize(16)
                                .setTextAlignment(TextAlignment.CENTER);
                        document.add(title);
                        document.add(adminTable);

                        Paragraph totalAnnualSalaryParagraph = new Paragraph(
                                "Total Annual Salary: " + currencyFormat.format(totalAnnualSalary))
                                .setFont(headingFont)
                                .setFontSize(12)
                                .setMarginTop(10f)
                                .setTextAlignment(TextAlignment.RIGHT);
                        document.add(totalAnnualSalaryParagraph);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    showAlert("Database Error", "Failed to fetch administrators' information: " + e.getMessage(),
                            Alert.AlertType.ERROR);
                    return;
                }

                document.close();
                showAlert("Success", "Admin Report PDF file downloaded successfully!", Alert.AlertType.INFORMATION);
            } catch (IOException e) {
                e.printStackTrace();
                showAlert("File Error", "Failed to save the PDF file: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Unexpected Error", "An unexpected error occurred: " + e.getMessage(), Alert.AlertType.ERROR);
        } finally {
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    showAlert("Database Error", "Failed to close the database connection: " + e.getMessage(),
                            Alert.AlertType.ERROR);
                }
            }
        }
    }

    @SuppressWarnings("resource")
    public void Staff(@SuppressWarnings("exports") ActionEvent event) {
        Connection connect = Database.connectDb();
        if (connect == null) {
            showAlert("Database Error", "Database connection could not be established.", Alert.AlertType.ERROR);
            return;
        }

        try {
            String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            // Create a FileChooser to allow the user to select a directory
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Directory for Download");
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            String suggestedFileName = "Teachers_Report_" + currentDate + ".pdf";
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF Files (*.pdf)", "*.pdf");
            fileChooser.getExtensionFilters().add(extFilter);
            fileChooser.setInitialFileName(suggestedFileName);

            // Show the Save As dialog and get the selected file
            javafx.stage.Window window = ((Node) event.getSource()).getScene().getWindow();
            File selectedFile = fileChooser.showSaveDialog(window);
            if (selectedFile == null) {
                showAlert("File Selection", "File selection was cancelled.", Alert.AlertType.WARNING);
                return;
            }

            String filePath = selectedFile.getAbsolutePath();

            try (PdfDocument pdf = new PdfDocument(new PdfWriter(filePath))) {
                Document document = new Document(pdf);

                // Add School Name and Date at the top of the page
                PdfFont boldFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
                PdfFont blueFont = PdfFontFactory.createFont(StandardFonts.HELVETICA);
                // Create a Div element
                Div headerDiv = new Div();
                DecimalFormat currencyFormat = new DecimalFormat("#,##0.00");
                String[] schoolInfo = getSchoolInfoFromSettings();
                String schoolName = schoolInfo[0];
                String principal = schoolInfo[2];
                String address = schoolInfo[3];
                String academicYear = getAcademicYearFromSettings();

                Paragraph schoolNameParagraph = new Paragraph(schoolName)
                        .setFont(boldFont)
                        .setFontSize(14)
                        .setTextAlignment(TextAlignment.CENTER); // Centered alignment

                Paragraph date = new Paragraph("Academic Year: " + academicYear).setFont(blueFont).setFontSize(12);
                Paragraph printed = new Paragraph("Printed Date: " + currentDate).setFont(blueFont).setFontSize(12);
                Paragraph addressParagraph = new Paragraph("Address: " + address).setFont(blueFont).setFontSize(12);
                Paragraph principalParagraph = new Paragraph("Principal: " + principal).setFont(blueFont)
                        .setFontSize(12);

                // Create a table with two columns
                Table table = new Table(2);
                table.setWidth(UnitValue.createPercentValue(100));

                // Add the paragraphs to the table with alignments
                table.addCell(new Cell().add(date).setTextAlignment(TextAlignment.LEFT).setBorder(Border.NO_BORDER));
                table.addCell(
                        new Cell().add(printed).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER));
                table.addCell(new Cell().add(addressParagraph).setTextAlignment(TextAlignment.LEFT)
                        .setBorder(Border.NO_BORDER));
                table.addCell(new Cell().add(principalParagraph).setTextAlignment(TextAlignment.RIGHT)
                        .setBorder(Border.NO_BORDER));

                headerDiv.add(schoolNameParagraph);
                headerDiv.add(table);

                com.itextpdf.layout.element.Image watermarkImage = Logo
                        .createWatermarkImage(imageFile.getAbsolutePath());
                document.add(watermarkImage);
                document.add(headerDiv);

                // Database query to fetch administrators' information
                String selectData = "SELECT Name, Age, Work_Load, Work_Period, Subject, Salary FROM teachers WHERE category = 'Staff'";
                try (PreparedStatement prepare = connect.prepareStatement(selectData)) {
                    try (ResultSet resultSet = prepare.executeQuery()) {
                        float[] columnWidths = { 150f, 50f, 80f, 80f, 150f, 80f, 100f };
                        Table adminTable = new Table(columnWidths).useAllAvailableWidth();

                        PdfFont headingFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
                        adminTable.addHeaderCell(new Cell().add(new Paragraph("Name").setFont(headingFont)));
                        adminTable.addHeaderCell(new Cell().add(new Paragraph("Age").setFont(headingFont)));
                        adminTable.addHeaderCell(new Cell().add(new Paragraph("Load (hrs)").setFont(headingFont)));
                        adminTable.addHeaderCell(new Cell().add(new Paragraph("Period (mnths)").setFont(headingFont)));
                        adminTable.addHeaderCell(new Cell().add(new Paragraph("Subject").setFont(headingFont)));
                        adminTable.addHeaderCell(new Cell().add(new Paragraph("Salary").setFont(headingFont)));
                        adminTable.addHeaderCell(new Cell().add(new Paragraph("Annually").setFont(headingFont)));

                        double totalAnnualSalary = 0.0;
                        int teacherCount = 0;

                        while (resultSet.next()) {
                            String name = resultSet.getString("Name");
                            int age = resultSet.getInt("Age");
                            double workLoad = resultSet.getDouble("Work_Load");
                            double workPeriod = resultSet.getDouble("Work_Period");
                            String subject = resultSet.getString("Subject");
                            double salary = resultSet.getDouble("Salary");
                            double annualSalary = workPeriod * salary;

                            adminTable.addCell(name);
                            adminTable.addCell(String.valueOf(age));
                            adminTable.addCell(String.valueOf(workLoad));
                            adminTable.addCell(String.valueOf(workPeriod));
                            adminTable.addCell(subject);
                            adminTable.addCell(currencyFormat.format(salary));
                            adminTable.addCell(currencyFormat.format(annualSalary));

                            totalAnnualSalary += annualSalary;
                            teacherCount++;
                        }

                        Paragraph title = new Paragraph("Staff Report" + "   |   Total: " + teacherCount)
                                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                                .setFontSize(16)
                                .setTextAlignment(TextAlignment.CENTER);
                        document.add(title);
                        document.add(adminTable);

                        Paragraph totalAnnualSalaryParagraph = new Paragraph(
                                "Total Annual Salary: " + currencyFormat.format(totalAnnualSalary))
                                .setFont(headingFont)
                                .setFontSize(12)
                                .setMarginTop(10f)
                                .setTextAlignment(TextAlignment.RIGHT);
                        document.add(totalAnnualSalaryParagraph);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    showAlert("Database Error", "Failed to fetch staff information: " + e.getMessage(),
                            Alert.AlertType.ERROR);
                    return;
                }

                document.close();
                showAlert("Success", "Staff Report PDF file downloaded successfully!", Alert.AlertType.INFORMATION);
            } catch (IOException e) {
                e.printStackTrace();
                showAlert("File Error", "Failed to save the PDF file: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Unexpected Error", "An unexpected error occurred: " + e.getMessage(), Alert.AlertType.ERROR);
        } finally {
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    showAlert("Database Error", "Failed to close the database connection: " + e.getMessage(),
                            Alert.AlertType.ERROR);
                }
            }
        }
    }

    @SuppressWarnings({ "exports", "resource" })
    public void allTeachers(ActionEvent event) {
        Connection connect = Database.connectDb();
        if (connect == null) {
            showAlert("Database Error", "Database connection could not be established.", Alert.AlertType.ERROR);
            return;
        }

        try {
            String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            // Create a FileChooser to allow the user to select a directory
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Directory for Download");
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            String suggestedFileName = "Gen_Teachers_Report_" + currentDate + ".pdf";
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF Files (*.pdf)", "*.pdf");
            fileChooser.getExtensionFilters().add(extFilter);
            fileChooser.setInitialFileName(suggestedFileName);

            // Show the Save As dialog and get the selected file
            javafx.stage.Window window = ((Node) event.getSource()).getScene().getWindow();
            File selectedFile = fileChooser.showSaveDialog(window);
            if (selectedFile == null) {
                showAlert("File Selection", "File selection was cancelled.", Alert.AlertType.WARNING);
                return;
            }

            String filePath = selectedFile.getAbsolutePath();

            try (PdfDocument pdf = new PdfDocument(new PdfWriter(filePath))) {
                PageSize landscape = PageSize.A4.rotate();
                Document document = new Document(pdf, landscape);

                // Add School Name and Date at the top of the page
                PdfFont boldFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
                PdfFont blueFont = PdfFontFactory.createFont(StandardFonts.HELVETICA);
                // Create a Div element
                Div headerDiv = new Div();
                DecimalFormat currencyFormat = new DecimalFormat("#,##0.00");
                String[] schoolInfo = getSchoolInfoFromSettings();
                String schoolName = schoolInfo[0];
                String principal = schoolInfo[2];
                String address = schoolInfo[3];
                String academicYear = getAcademicYearFromSettings();

                Paragraph schoolNameParagraph = new Paragraph(schoolName)
                        .setFont(boldFont)
                        .setFontSize(14)
                        .setTextAlignment(TextAlignment.CENTER); // Centered alignment

                Paragraph date = new Paragraph("Academic Year: " + academicYear).setFont(blueFont).setFontSize(12);
                Paragraph printed = new Paragraph("Printed Date: " + currentDate).setFont(blueFont).setFontSize(12);
                Paragraph addressParagraph = new Paragraph("Address: " + address).setFont(blueFont).setFontSize(12);
                Paragraph principalParagraph = new Paragraph("Principal: " + principal).setFont(blueFont)
                        .setFontSize(12);

                // Create a table with two columns
                Table table = new Table(2);
                table.setWidth(UnitValue.createPercentValue(100));

                // Add the paragraphs to the table with alignments
                table.addCell(new Cell().add(date).setTextAlignment(TextAlignment.LEFT).setBorder(Border.NO_BORDER));
                table.addCell(
                        new Cell().add(printed).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER));
                table.addCell(new Cell().add(addressParagraph).setTextAlignment(TextAlignment.LEFT)
                        .setBorder(Border.NO_BORDER));
                table.addCell(new Cell().add(principalParagraph).setTextAlignment(TextAlignment.RIGHT)
                        .setBorder(Border.NO_BORDER));

                headerDiv.add(schoolNameParagraph);
                headerDiv.add(table);

                com.itextpdf.layout.element.Image watermarkImage = Logo
                        .createWatermarkImage(imageFile.getAbsolutePath());
                document.add(watermarkImage);
                document.add(headerDiv);
                document.add(new Paragraph("General Teachers Report").setTextAlignment(TextAlignment.CENTER)
                        .setFont(boldFont).setFontSize(16));

                // Database query to fetch teachers' information
                String selectData = "SELECT Name, Age, Work_Load, Work_Period, Subject, Salary, phone_number FROM teachers";
                try (PreparedStatement prepare = connect.prepareStatement(selectData)) {
                    try (ResultSet resultSet = prepare.executeQuery()) {
                        // Create a table to hold the teacher details
                        float[] columnWidths = { 150f, 50f, 100f, 80f, 80f, 150f, 80f, 100f }; // Adjust column widths
                                                                                               // as needed
                        Table adminTable = new Table(columnWidths).useAllAvailableWidth();

                        // Add table headers with bold font
                        PdfFont headingFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
                        adminTable.addHeaderCell(new Cell().add(new Paragraph("Name").setFont(headingFont)));
                        adminTable.addHeaderCell(new Cell().add(new Paragraph("Age").setFont(headingFont)));
                        adminTable.addHeaderCell(new Cell().add(new Paragraph("Tel").setFont(headingFont)));
                        adminTable.addHeaderCell(new Cell().add(new Paragraph("Load (hrs)").setFont(headingFont)));
                        adminTable.addHeaderCell(new Cell().add(new Paragraph("Period (mths)").setFont(headingFont)));
                        adminTable.addHeaderCell(new Cell().add(new Paragraph("Subject").setFont(headingFont)));
                        adminTable.addHeaderCell(new Cell().add(new Paragraph("Salary").setFont(headingFont)));
                        adminTable.addHeaderCell(new Cell().add(new Paragraph("Annually").setFont(headingFont)));

                        // Initialize a variable to calculate the sum of the annual salaries
                        double totalAnnualSalary = 0.0;
                        @SuppressWarnings("unused")
                        int staffCount = 0;

                        // Iterate through the teachers and add their details to the table
                        while (resultSet.next()) {
                            String name = resultSet.getString("Name");
                            int age = resultSet.getInt("Age");
                            String tel = resultSet.getString("phone_number");
                            double workLoad = resultSet.getDouble("Work_Load");
                            double workPeriod = resultSet.getDouble("Work_Period");
                            String subject = resultSet.getString("Subject");
                            double salary = resultSet.getDouble("Salary");
                            double annualSalary = workPeriod * salary;

                            // Add details to the table
                            adminTable.addCell(name);
                            adminTable.addCell(String.valueOf(age));
                            adminTable.addCell(tel);
                            adminTable.addCell(String.valueOf(workLoad));
                            adminTable.addCell(String.valueOf(workPeriod));
                            adminTable.addCell(subject);
                            adminTable.addCell(currencyFormat.format(salary));
                            adminTable.addCell(currencyFormat.format(annualSalary));

                            // Update the total annual salary
                            totalAnnualSalary += annualSalary;
                            staffCount++;
                        }

                        Paragraph totalAnnualSalaryParagraph = new Paragraph(
                                "Total Annual Salary: " + currencyFormat.format(totalAnnualSalary))
                                .setFont(headingFont)
                                .setFontSize(12)
                                .setMarginTop(10f)
                                .setTextAlignment(TextAlignment.RIGHT);
                        document.add(adminTable);
                        document.add(totalAnnualSalaryParagraph);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    showAlert("Database Error", "Failed to fetch teachers' information: " + e.getMessage(),
                            Alert.AlertType.ERROR);
                    return;
                }

                document.close();
                showAlert("Success", "Teachers Report PDF file downloaded successfully!", Alert.AlertType.INFORMATION);
            } catch (IOException e) {
                e.printStackTrace();
                showAlert("File Error", "Failed to save the PDF file: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Unexpected Error", "An unexpected error occurred: " + e.getMessage(), Alert.AlertType.ERROR);
        } finally {
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    showAlert("Database Error", "Failed to close the database connection: " + e.getMessage(),
                            Alert.AlertType.ERROR);
                }
            }
        }
    }

    @SuppressWarnings("unused")
    private double x = 0;
    @SuppressWarnings("unused")
    private double y = 0;

    public void logout() {

        try {

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

                // HIDE YOUR DASHBOARD FORM
                logout.getScene().getWindow().hide();

                // LINK YOUR LOGIN FORM
                Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setTitle("SAINT PETERS COMPREHENSIVE HIGH SCHOOL (ST.PCHS)");
                stage.setMinWidth(660);
                stage.setMinHeight(480);
                stage.setScene(scene);
                stage.show();

            } else {
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void displayUsername() {
        username.setText(getData.username.toUpperCase());
    }

    // // THATS IT FOR THESE VIDEOS, THANKS FOR WATCHING!! SUBSCRIBE AND TURN ON
    // NOTIFICATION
    // // TO NOTIF YOU FOR MORE UPCOMING VIDEOS THANKS FOR THE SUPPORT! : )
    public void defaultNav() {
        home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
    }

    public void addClasses(@SuppressWarnings("exports") ActionEvent event) {
        class_sectionAdd_form.setVisible(true);
        addClass_form.setVisible(false);
    }

    @SuppressWarnings("exports")
    public void switchForm(ActionEvent event) {
        if (event.getSource() == home_btn) {
            home_form.setVisible(true);
            main_form.setVisible(true);
            female_form.setVisible(true);
            addStudents_form.setVisible(false);
            all_students_form.setVisible(false);
            marksheet_form.setVisible(false);
            addClass_form.setVisible(false);
            class_sectionAdd_form.setVisible(false);
            settings_form.setVisible(false);
            finances_form.setVisible(false);
            personal_form.setVisible(false);
            teachers_form.setVisible(false);
            updateTeacher_form.setVisible(false);
            promoteForm.setVisible(false);

            home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            addStudents_btn.setStyle("-fx-background-color:transparent");
            all_students_btn.setStyle("-fx-background-color:transparent");
            marksheet_btn.setStyle("-fx-background-color:transparent");
            manageClass_btn.setStyle("-fx-background-color:transparent");
            teacher_btn.setStyle("-fx-background-color:transparent");
            setting_btn.setStyle("-fx-background-color:transparent");
            finance_btn.setStyle("-fx-background-color:transparent");

            homeDisplayTotalEnrolledStudents();
            homeDisplayMaleEnrolled();
            homeDisplayFemaleEnrolled();
            homeDisplayEnrolledMaleChart();
            homeDisplayFemaleEnrolledChart();
            homeDisplayTotalEnrolledChart();
            homeCollectedFees();
            showAllClassListData();

        } else if (event.getSource() == addStudents_btn) {
            home_form.setVisible(false);
            main_form.setVisible(false);
            addStudents_form.setVisible(true);
            all_students_form.setVisible(false);
            marksheet_form.setVisible(false);
            addClass_form.setVisible(false);
            class_sectionAdd_form.setVisible(false);
            settings_form.setVisible(false);
            finances_form.setVisible(false);
            personal_form.setVisible(false);
            teachers_form.setVisible(false);
            updateTeacher_form.setVisible(false);
            promoteForm.setVisible(false);

            try {
                // Call the method to populate the academic year ComboBox with unique values
                // from the database
                String selectedYear = getAcademicYearFromSettings();
                showClassesForYear(selectedYear);
            } catch (SQLException e) {
                // Handle any exceptions that might occur while fetching data from the database
                e.printStackTrace();
            }

            addStudents_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            home_btn.setStyle("-fx-background-color:transparent");
            all_students_btn.setStyle("-fx-background-color:transparent");
            marksheet_btn.setStyle("-fx-background-color:transparent");
            teacher_btn.setStyle("-fx-background-color:transparent");
            manageClass_btn.setStyle("-fx-background-color:transparent");
            setting_btn.setStyle("-fx-background-color:transparent");
            finance_btn.setStyle("-fx-background-color:transparent");

            // TO BECOME UPDATED ONCE YOU CLICK THE ADD STUDENTS BUTTON ON NAV
            addStudentsShowListData();
            addStudentsSearch();

        } else if (event.getSource() == all_students_btn) {
            home_form.setVisible(false);
            main_form.setVisible(false);
            addStudents_form.setVisible(false);
            all_students_form.setVisible(true);
            marksheet_form.setVisible(false);
            addClass_form.setVisible(false);
            class_sectionAdd_form.setVisible(false);
            settings_form.setVisible(false);
            finances_form.setVisible(false);
            personal_form.setVisible(false);
            teachers_form.setVisible(false);
            updateTeacher_form.setVisible(false);
            promoteForm.setVisible(false);

            getAcademicYearFromSettings();
            addStudentsShowListData();

            all_students_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            addStudents_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            teacher_btn.setStyle("-fx-background-color:transparent");
            marksheet_btn.setStyle("-fx-background-color:transparent");
            manageClass_btn.setStyle("-fx-background-color:transparent");
            setting_btn.setStyle("-fx-background-color:transparent");
            finance_btn.setStyle("-fx-background-color:transparent");

            // availableCourseShowListData();

        } else if (event.getSource() == marksheet_btn) {
            home_form.setVisible(false);
            main_form.setVisible(false);
            addStudents_form.setVisible(false);
            all_students_form.setVisible(false);
            marksheet_form.setVisible(true);
            addClass_form.setVisible(false);
            class_sectionAdd_form.setVisible(false);
            settings_form.setVisible(false);
            finances_form.setVisible(false);
            personal_form.setVisible(false);
            teachers_form.setVisible(false);
            updateTeacher_form.setVisible(false);
            getAcademicYearFromSettings();
            promoteForm.setVisible(false);

            marksheet_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            addStudents_btn.setStyle("-fx-background-color:transparent");
            all_students_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            teacher_btn.setStyle("-fx-background-color:transparent");
            manageClass_btn.setStyle("-fx-background-color:transparent");
            setting_btn.setStyle("-fx-background-color:transparent");
            finance_btn.setStyle("-fx-background-color:transparent");

            // studentGradesShowListData();
            // studentGradesSearch();

        } else if (event.getSource() == manageClass_btn) {
            home_form.setVisible(false);
            main_form.setVisible(false);
            addStudents_form.setVisible(false);
            all_students_form.setVisible(false);
            marksheet_form.setVisible(false);
            addClass_form.setVisible(true);
            class_sectionAdd_form.setVisible(false);
            settings_form.setVisible(false);
            finances_form.setVisible(false);
            personal_form.setVisible(false);
            teachers_form.setVisible(false);
            updateTeacher_form.setVisible(false);
            promoteForm.setVisible(false);

            getAcademicYearFromSettings();
            showAllClassListData();

            manageClass_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            home_btn.setStyle("-fx-background-color:transparent");
            all_students_btn.setStyle("-fx-background-color:transparent");
            marksheet_btn.setStyle("-fx-background-color:transparent");
            teacher_btn.setStyle("-fx-background-color:transparent");
            addStudents_btn.setStyle("-fx-background-color:transparent");
            setting_btn.setStyle("-fx-background-color:transparent");
            finance_btn.setStyle("-fx-background-color:transparent");

        } else if (event.getSource() == setting_btn) {
            home_form.setVisible(false);
            main_form.setVisible(false);
            addStudents_form.setVisible(false);
            all_students_form.setVisible(false);
            marksheet_form.setVisible(false);
            addClass_form.setVisible(false);
            class_sectionAdd_form.setVisible(false);
            settings_form.setVisible(true);
            finances_form.setVisible(false);
            personal_form.setVisible(false);
            teachers_form.setVisible(false);
            updateTeacher_form.setVisible(false);
            promoteForm.setVisible(false);

            displaySchoolInfo();

            addStudents_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            teacher_btn.setStyle("-fx-background-color:transparent");
            all_students_btn.setStyle("-fx-background-color:transparent");
            marksheet_btn.setStyle("-fx-background-color:transparent");
            manageClass_btn.setStyle("-fx-background-color:transparent");
            setting_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            finance_btn.setStyle("-fx-background-color:transparent");

        } else if (event.getSource() == finance_btn) {
            home_form.setVisible(false);
            main_form.setVisible(false);
            addStudents_form.setVisible(false);
            all_students_form.setVisible(false);
            marksheet_form.setVisible(false);
            addClass_form.setVisible(false);
            class_sectionAdd_form.setVisible(false);
            settings_form.setVisible(false);
            finances_form.setVisible(true);
            personal_form.setVisible(false);
            teachers_form.setVisible(false);
            updateTeacher_form.setVisible(false);
            promoteForm.setVisible(false);

            displayOwing();
            getAcademicYearFromSettings();
            displayTotalOwing();
            displayExpected();
            recordDailyTotalPaid();
            displayWeeklyTotalPayments();

            addStudents_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            teacher_btn.setStyle("-fx-background-color:transparent");
            all_students_btn.setStyle("-fx-background-color:transparent");
            marksheet_btn.setStyle("-fx-background-color:transparent");
            manageClass_btn.setStyle("-fx-background-color:transparent");
            setting_btn.setStyle("-fx-background-color:transparent");
            finance_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");

        } else if (event.getSource() == teacher_btn) {
            home_form.setVisible(false);
            main_form.setVisible(false);
            addStudents_form.setVisible(false);
            all_students_form.setVisible(false);
            marksheet_form.setVisible(false);
            addClass_form.setVisible(false);
            class_sectionAdd_form.setVisible(false);
            settings_form.setVisible(false);
            finances_form.setVisible(false);
            personal_form.setVisible(false);
            teachers_form.setVisible(true);
            updateTeacher_form.setVisible(false);
            promoteForm.setVisible(false);

            getAcademicYearFromSettings();
            teacherSearch();
            teacherShowListData();

            marksheet_btn.setStyle("-fx-background-color:transparent");
            addStudents_btn.setStyle("-fx-background-color:transparent");
            all_students_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            manageClass_btn.setStyle("-fx-background-color:transparent");
            setting_btn.setStyle("-fx-background-color:transparent");
            finance_btn.setStyle("-fx-background-color:transparent");
            teacher_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");

        }

    }

    public void classSearch() {

        String selectedYear = getAcademicYearFromSettings();
        if (selectedYear == null) {
            return;
        }
        FilteredList<EnrollmentData> filter = new FilteredList<>(showClassListD, e -> true);

        class_search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateStudentData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateStudentData.getClassName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getSchoolFees().toString().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getCategory().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getSection().toLowerCase().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<EnrollmentData> sortList = new SortedList<>(filter);
        sortList.comparatorProperty().bind(showClass_tableView.comparatorProperty());
        showClass_tableView.setItems(sortList);

    }

    public ObservableList<EnrollmentData> showClassListData() {
        ObservableList<EnrollmentData> listClass = FXCollections.observableArrayList();
        String academicYear = getAcademicYearFromSettings(); // Replace this with your implementation

        Connection connect = Database.connectDb();
        if (connect == null) {
            System.err.println("Error: Database connection could not be established.");
            return listClass;
        }

        try {
            // First, check if there are enrollments for the specified academic year
            String sqlCheckEnrollments = "SELECT COUNT(*) AS count FROM enrollments WHERE academic_year = ?";
            PreparedStatement checkPrepare = connect.prepareStatement(sqlCheckEnrollments);
            checkPrepare.setString(1, academicYear);
            ResultSet checkResult = checkPrepare.executeQuery();

            boolean hasEnrollments = false;
            if (checkResult.next() && checkResult.getInt("count") > 0) {
                hasEnrollments = true;
            }

            checkResult.close();
            checkPrepare.close();

            if (hasEnrollments) {
                // Retrieve the enrollment data
                String sql = "SELECT class_name, school_fees, section, category, " +
                        "COUNT(*) AS totalStudents, " +
                        "COUNT(CASE WHEN school_fees - total_fees_paid > 0 THEN 1 END) AS studentsOwing, " +
                        "SUM(school_fees) AS totalExpected, " +
                        "SUM(total_fees_paid) AS totalFeesPaid, " +
                        "SUM(school_fees - total_fees_paid) AS totalOwing " +
                        "FROM enrollments WHERE academic_year = ? GROUP BY class_name, section, category";

                PreparedStatement prepare = connect.prepareStatement(sql);
                prepare.setString(1, academicYear);
                ResultSet result = prepare.executeQuery();

                while (result.next()) {
                    EnrollmentData enrollmentData = new EnrollmentData(
                            null,
                            null,
                            result.getString("class_name"),
                            result.getString("section"),
                            result.getString("category"),
                            null,
                            null,
                            null,
                            result.getDouble("school_fees"),
                            result.getDouble("totalFeesPaid"),
                            result.getDouble("totalOwing"),
                            result.getDouble("totalExpected"),
                            result.getInt("totalStudents"),
                            result.getInt("studentsOwing"),
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null);
                    listClass.add(enrollmentData);
                }

                result.close();
                prepare.close();
            } else {
                // If there are no enrollments, retrieve class details from class table
                String sql = "SELECT class_name, school_fees, " +
                        "CASE WHEN A1 = 1 THEN 'A1, ' ELSE '' END || " +
                        "CASE WHEN A2 = 1 THEN 'A2, ' ELSE '' END || " +
                        "CASE WHEN B1 = 1 THEN 'B1, ' ELSE '' END || " +
                        "CASE WHEN B2 = 1 THEN 'B2, ' ELSE '' END || " +
                        "CASE WHEN Arts = 1 THEN 'Arts, ' ELSE '' END || " +
                        "CASE WHEN Science = 1 THEN 'Science, ' ELSE '' END || " +
                        "CASE WHEN Commercial = 1 THEN 'Commercial, ' ELSE '' END || " +
                        "CASE WHEN C = 1 THEN 'C, ' ELSE '' END AS sections " +
                        "FROM class";

                PreparedStatement prepare = connect.prepareStatement(sql);
                ResultSet result = prepare.executeQuery();

                while (result.next()) {
                    String sections = result.getString("sections").replaceAll(", $", "");

                    EnrollmentData enrollmentData = new EnrollmentData(
                            null,
                            null,
                            result.getString("class_name"),
                            sections,
                            null,
                            academicYear,
                            null,
                            null,
                            result.getDouble("school_fees"),
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null);
                    listClass.add(enrollmentData);
                }

                result.close();
                prepare.close();
            }

            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listClass;
    }

    private ObservableList<EnrollmentData> showClassListD;

    public void showAllClassListData() {
        showClassListD = showClassListData();

        showClass_col_year.setCellValueFactory(new PropertyValueFactory<>("category"));
        showClass_col_name.setCellValueFactory(new PropertyValueFactory<>("className"));
        showClass_col_fees.setCellValueFactory(new PropertyValueFactory<>("schoolFees"));
        showClass_col_section.setCellValueFactory(new PropertyValueFactory<>("section"));
        showClass_col_totalStudents.setCellValueFactory(new PropertyValueFactory<>("totalStudents"));
        showClass_col_totalExpected.setCellValueFactory(new PropertyValueFactory<>("totalExpected"));
        showClass_col_totalPaid.setCellValueFactory(new PropertyValueFactory<>("totalFeesPaid"));
        showClass_col_totalOwing.setCellValueFactory(new PropertyValueFactory<>("totalOwing"));
        showClass_col_StudentsOwing.setCellValueFactory(new PropertyValueFactory<>("studentsOwing"));
        showClass_tableView.setItems(showClassListD);

    }

    private String[] getSchoolInfoFromSettings() {
        String[] schoolInfo = new String[4]; // Index 0: School Name, Index 1: Logo Path
        String sqlSettings = "SELECT schoolName, logo, principal, address FROM settings";

        try {
            Connection settingsConnection = Database.connectDb();
            PreparedStatement settingsPrepare = settingsConnection.prepareStatement(sqlSettings);
            ResultSet settingsResult = settingsPrepare.executeQuery();

            if (settingsResult.next()) {
                schoolInfo[0] = settingsResult.getString("schoolName");
                schoolInfo[1] = settingsResult.getString("logo");
                schoolInfo[2] = settingsResult.getString("principal");
                schoolInfo[3] = settingsResult.getString("address");
            }

            // Close the resources related to the settings query
            settingsResult.close();
            settingsPrepare.close();
            settingsConnection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return schoolInfo;
    }

    @SuppressWarnings("exports")
public boolean generateAndSavePDF(ObservableList<EnrollmentData> dataList, ActionEvent event) {
    if (dataList == null || dataList.isEmpty()) {
        System.err.println("Error: Data list is null or empty.");
        return false;
    }

    try {
        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Directory for Download");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

                    // Set the suggested file name for the Save As dialog (optional)
            String suggestedFileName = "Class_Record_" + currentDate + ".pdf";
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF Files (*.pdf)", "*.pdf");
            fileChooser.getExtensionFilters().add(extFilter);
            fileChooser.setInitialFileName(suggestedFileName);

            javafx.stage.Window window = ((Node) event.getSource()).getScene().getWindow();

            File selectedFile = fileChooser.showSaveDialog(window);
            if (selectedFile == null) {
                return false; // User cancelled the dialog
            }
            String filePath = selectedFile.getAbsolutePath();

            try (PdfDocument pdf = new PdfDocument(new PdfWriter(filePath))) {
                PageSize landscape = PageSize.A4.rotate();
                Document document = new Document(pdf, landscape);

                // Add School Name and Date at the top of the page
                PdfFont boldFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
                PdfFont blueFont = PdfFontFactory.createFont(StandardFonts.HELVETICA);
                // Create a Div element for center alignment
                Div headerDiv = new Div()
                        .setTextAlignment(TextAlignment.CENTER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
                DecimalFormat currencyFormat = new DecimalFormat("#,##0.00");
                String[] schoolInfo = getSchoolInfoFromSettings();
                String schoolName = schoolInfo[0];
                String principal = schoolInfo[2];
                String address = schoolInfo[3];
                String academicYear = getAcademicYearFromSettings();

                Paragraph schoolNameParagraph = new Paragraph(schoolName).setFont(boldFont).setFontSize(14);
                Table infoTable = new Table(2);
                infoTable.setWidth(UnitValue.createPercentValue(100));

                // Add the paragraphs to the table, with each row having two cells
                infoTable.addCell(new Cell().add(new Paragraph("Academic Year: " + academicYear)
                        .setFont(blueFont).setFontSize(12)).setBorder(Border.NO_BORDER));

                infoTable.addCell(new Cell().add(new Paragraph("Printed Date: " + currentDate)
                        .setFont(blueFont).setFontSize(12)).setBorder(Border.NO_BORDER));

                infoTable.addCell(new Cell().add(new Paragraph("Address: " + address)
                        .setFont(blueFont).setFontSize(12)).setBorder(Border.NO_BORDER));

                infoTable.addCell(new Cell().add(new Paragraph("Principal: " + principal)
                        .setFont(blueFont).setFontSize(12)).setBorder(Border.NO_BORDER));

                // Add the table to the document
                document.add(infoTable);
                headerDiv.add(schoolNameParagraph);

                com.itextpdf.layout.element.Image watermarkImage = Logo
                        .createWatermarkImage(imageFile.getAbsolutePath());
                document.add(watermarkImage);
                document.add(headerDiv);

                Paragraph record = new Paragraph("General Class Record for the Academic Year: " + academicYear)
                        .setFont(blueFont)
                        .setFontSize(14);

                document.add(record);

            // Group data by department
            Map<String, List<EnrollmentData>> groupedByDepartment = dataList.stream()
                    .collect(Collectors.groupingBy(EnrollmentData::getCategory,
                            LinkedHashMap::new, Collectors.toList()));

            float[] columnWidths = {100f, 100f, 100f, 50f, 50f, 50f, 100f, 100f, 100f};
            PdfFont headingFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);

            Table table = new Table(UnitValue.createPercentArray(columnWidths)).useAllAvailableWidth();

            // Headers
            table.addHeaderCell(new Cell().add(new Paragraph("Class Name").setFont(headingFont)));
            table.addHeaderCell(new Cell().add(new Paragraph("Department").setFont(headingFont)));
            table.addHeaderCell(new Cell().add(new Paragraph("Fees").setFont(headingFont)));
            table.addHeaderCell(new Cell().add(new Paragraph("Section").setFont(headingFont)));
            table.addHeaderCell(new Cell().add(new Paragraph("Total Students").setFont(headingFont)));
            table.addHeaderCell(new Cell().add(new Paragraph("Total Students Owing").setFont(headingFont)));
            table.addHeaderCell(new Cell().add(new Paragraph("Total Expected").setFont(headingFont)));
            table.addHeaderCell(new Cell().add(new Paragraph("Total Paid").setFont(headingFont)));
            table.addHeaderCell(new Cell().add(new Paragraph("Total Owing").setFont(headingFont)));

            // Totals
            double totalOwing = 0, totalPaid = 0, totalExpected = 0;
            int totalStudentsOwing = 0, totalStudents = 0;

            for (Map.Entry<String, List<EnrollmentData>> entry : groupedByDepartment.entrySet()) {
                String department = entry.getKey();
                List<EnrollmentData> deptData = entry.getValue();

                // Department header row
                Cell deptHeader = new Cell(1, 9)
                        .add(new Paragraph("Department: " + department).setBold())
                        .setBackgroundColor(ColorConstants.LIGHT_GRAY);
                table.addCell(deptHeader);

                for (EnrollmentData item : deptData) {
                    table.addCell(new Cell().add(new Paragraph(item.getClassName())));
                    table.addCell(new Cell().add(new Paragraph(item.getCategory())));
                    table.addCell(new Cell().add(new Paragraph(currencyFormat.format(item.getSchoolFees()))));
                    table.addCell(new Cell().add(new Paragraph(item.getSection())));
                    table.addCell(new Cell().add(new Paragraph(String.valueOf(item.getTotalStudents()))));
                    table.addCell(new Cell().add(new Paragraph(String.valueOf(item.getStudentsOwing()))));
                    table.addCell(new Cell().add(new Paragraph(currencyFormat.format(item.getTotalExpected()))));
                    table.addCell(new Cell().add(new Paragraph(currencyFormat.format(item.getTotalFeesPaid()))));
                    table.addCell(new Cell().add(new Paragraph(currencyFormat.format(item.getTotalOwing()))));

                    totalOwing += item.getTotalOwing();
                    totalPaid += item.getTotalFeesPaid();
                    totalExpected += item.getTotalExpected();
                    totalStudentsOwing += item.getStudentsOwing();
                    totalStudents += item.getTotalStudents();
                }
            }

            // Add main table
            document.add(table);

            // Add totals table separately (only once, at the end)
            Table totalsTable = new Table(UnitValue.createPercentArray(columnWidths)).useAllAvailableWidth();
            totalsTable.addCell(new Cell().add(new Paragraph("Grand Total:").setBold()));
            totalsTable.addCell(new Cell().add(new Paragraph(""))); // Department
            totalsTable.addCell(new Cell().add(new Paragraph(""))); // Fees
            totalsTable.addCell(new Cell().add(new Paragraph(""))); // Section
            totalsTable.addCell(new Cell().add(new Paragraph(String.valueOf(totalStudents)).setBold()));
            totalsTable.addCell(new Cell().add(new Paragraph(String.valueOf(totalStudentsOwing)).setBold()));
            totalsTable.addCell(new Cell().add(new Paragraph(currencyFormat.format(totalExpected)).setBold()));
            totalsTable.addCell(new Cell().add(new Paragraph(currencyFormat.format(totalPaid)).setBold()));
            totalsTable.addCell(new Cell().add(new Paragraph(currencyFormat.format(totalOwing)).setBold()));

            document.add(totalsTable);

            // Signature
            Paragraph signature = new Paragraph("Principal: " + principal)
                    .setFont(boldFont)
                    .setFontSize(12)
                    .setMarginTop(10);
            document.add(signature);

            document.close();

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Class Record PDF file downloaded successfully!");
            alert.showAndWait();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

    public void ClassRecord(@SuppressWarnings("exports") ActionEvent event) {
        generateAndSavePDF(showClassListD, event);
    }

    @SuppressWarnings({ "exports", "resource" })
    public void studentInvoice(ActionEvent event) {
        if (selectedStudentMatricule == null) {
            showAlert("Error", "No student selected.", Alert.AlertType.ERROR);
            return;
        }

        Connection connect = Database.connectDb();
        if (connect == null) {
            showAlert("Database Error", "Database connection could not be established.", Alert.AlertType.ERROR);
            return;
        }

        try {
            String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Directory for Download");
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            String suggestedFileName = "Student_Invoice_" + selectedStudentMatricule + "_" + currentDate + ".pdf";
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF Files (*.pdf)", "*.pdf");
            fileChooser.getExtensionFilters().add(extFilter);
            fileChooser.setInitialFileName(suggestedFileName);

            javafx.stage.Window window = ((Node) event.getSource()).getScene().getWindow();
            File selectedFile = fileChooser.showSaveDialog(window);
            if (selectedFile == null) {
                return;
            }
            String filePath = selectedFile.getAbsolutePath();

            try (PdfDocument pdf = new PdfDocument(new PdfWriter(filePath))) {
                Document document = new Document(pdf);

                PdfFont boldFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
                PdfFont blueFont = PdfFontFactory.createFont(StandardFonts.HELVETICA);
                DecimalFormat currencyFormat = new DecimalFormat("#,##0.00");

                String[] schoolInfo = getSchoolInfoFromSettings();
                String schoolName = schoolInfo[0];
                String principal = schoolInfo[2];
                String address = schoolInfo[3];
                String academicYear = getAcademicYearFromSettings();

                Div headerDiv = new Div()
                        .setTextAlignment(TextAlignment.CENTER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE);

                Paragraph schoolNameParagraph = new Paragraph(schoolName).setFont(boldFont).setFontSize(14);
                // Create a table with two columns
                Table infoTable = new Table(2);
                infoTable.setWidth(UnitValue.createPercentValue(100));

                // Add the paragraphs to the table, with each row having two cells
                infoTable.addCell(new Cell().add(new Paragraph("Academic Year: " + academicYear)
                        .setFont(blueFont).setFontSize(12)).setBorder(Border.NO_BORDER));

                infoTable.addCell(new Cell().add(new Paragraph("Printed Date: " + currentDate)
                        .setFont(blueFont).setFontSize(12)).setBorder(Border.NO_BORDER));

                infoTable.addCell(new Cell().add(new Paragraph("Address: " + address)
                        .setFont(blueFont).setFontSize(12)).setBorder(Border.NO_BORDER));

                infoTable.addCell(new Cell().add(new Paragraph("Principal: " + principal)
                        .setFont(blueFont).setFontSize(12)).setBorder(Border.NO_BORDER));

                // Add the table to the document
                document.add(infoTable);

                headerDiv.add(schoolNameParagraph);

                com.itextpdf.layout.element.Image watermarkImage = Logo
                        .createWatermarkImage(imageFile.getAbsolutePath());
                document.add(watermarkImage);
                document.add(headerDiv);

                String selectData = "SELECT e.id, e.class_name, e.section, e.academic_year, e.status, e.school_fees, e.total_fees_paid, e.student_id, e.scholarship, "
                        +
                        "s.name, s.date_of_birth, s.contact, s.gender, " +
                        "(e.school_fees - e.total_fees_paid) AS owing " +
                        "FROM enrollments e " +
                        "JOIN students s ON e.student_id = s.matricule " +
                        "WHERE e.academic_year = ? AND e.student_id = ?";
                try (PreparedStatement prepare = connect.prepareStatement(selectData)) {
                    prepare.setString(1, academicYear);
                    prepare.setString(2, selectedStudentMatricule);
                    try (ResultSet resultSet = prepare.executeQuery()) {
                        if (resultSet.next()) {

                            double amountOwing = resultSet.getDouble("owing");
                            double amountPaid = resultSet.getDouble("total_fees_paid");
                            double schoolFees = resultSet.getDouble("school_fees");
                            double scholarship = resultSet.getDouble("scholarship");

                            // Create a table with two columns
                            Table detailTable = new Table(2);
                            detailTable.setWidth(UnitValue.createPercentValue(100));

                            // Add the paragraphs to the table in pairs, with each pair occupying a row
                            detailTable.addCell(new Cell()
                                    .add(new Paragraph(
                                            "Class Name: " + resultSet.getString("class_name") + " | Section: "
                                                    + resultSet.getString("section"))
                                            .setFont(blueFont).setFontSize(14))
                                    .setBorder(Border.NO_BORDER));

                            detailTable.addCell(new Cell()
                                    .add(new Paragraph("Fees: " + currencyFormat.format(schoolFees))
                                            .setFont(blueFont).setFontSize(14))
                                    .setBorder(Border.NO_BORDER));

                            detailTable.addCell(new Cell()
                                    .add(new Paragraph("Total Amount Paid: " + currencyFormat.format(amountPaid))
                                            .setFont(blueFont).setFontSize(14))
                                    .setBorder(Border.NO_BORDER));

                            detailTable.addCell(new Cell()
                                    .add(new Paragraph("Amount Owing: " + currencyFormat.format(amountOwing))
                                            .setFont(blueFont).setFontSize(14))
                                    .setBorder(Border.NO_BORDER));

                            // Add cells that span both columns
                            detailTable.addCell(new Cell(1, 2).add(new Paragraph("Scholarship: "
                                    + (scholarship > 0 ? currencyFormat.format(scholarship) : "No Scholarship awarded"))
                                    .setFont(blueFont).setFontSize(14)).setBorder(Border.NO_BORDER));

                            detailTable.addCell(new Cell().add(new Paragraph("Student Name: "
                                    + resultSet.getString("name"))
                                    .setFont(blueFont).setFontSize(15)).setBorder(Border.NO_BORDER));

                            detailTable.addCell(new Cell(1, 2).add(new Paragraph("Student Matricule: "
                                    + selectedStudentMatricule)
                                    .setFont(blueFont).setFontSize(15)).setBorder(Border.NO_BORDER));

                            // Add the table to the document
                            document.add(detailTable);

                        } else {
                            showAlert("Error", "No data found for the selected student.", Alert.AlertType.ERROR);
                            return;
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    showAlert("Error", "Error occurred while fetching student data: " + e.getMessage(),
                            Alert.AlertType.ERROR);
                    return;
                }

                String paymentQuery = "SELECT payment_date, amount_paid FROM fees WHERE enrollment_id = ?";
                try (PreparedStatement statement = connect.prepareStatement(paymentQuery)) {
                    statement.setInt(1, selectedStudentId);
                    ResultSet resultSet = statement.executeQuery();

                    float[] columnWidths = { 100f, 100f }; // Adjust column widths as needed
                    Table paymentTable = new Table(UnitValue.createPercentArray(columnWidths)).useAllAvailableWidth();
                    PdfFont headingFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
                    paymentTable.addHeaderCell(new Cell().add(new Paragraph("Payment Date").setFont(headingFont)));
                    paymentTable.addHeaderCell(new Cell().add(new Paragraph("Payment Amount").setFont(headingFont)));

                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy");
                    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Assuming the input
                                                                                                  // date format is
                                                                                                  // "yyyy-MM-dd"

                    while (resultSet.next()) {
                        String paymentDateString = resultSet.getString("payment_date");

                        // Parse the string to a LocalDate
                        LocalDate paymentDate = LocalDate.parse(paymentDateString, inputFormatter);

                        // Format the date
                        String formattedDate = paymentDate.format(dateFormatter);

                        double paymentAmount = resultSet.getDouble("amount_paid");

                        // Add the formatted date and amount to the table
                        paymentTable.addCell(new Cell().add(new Paragraph(formattedDate)));
                        paymentTable.addCell(new Cell().add(new Paragraph(currencyFormat.format(paymentAmount))));
                    }

                    document.add(new Paragraph("Payments Made by the Student:").setFont(headingFont));
                    document.add(paymentTable);

                    Paragraph signature = new Paragraph("Principal: " + principal)
                            .setFont(boldFont).setFontSize(12).setMarginTop(10);
                    document.add(signature);

                } catch (SQLException e) {
                    e.printStackTrace();
                    showAlert("Error", "Error occurred while fetching payment data: " + e.getMessage(),
                            Alert.AlertType.ERROR);
                }

                document.close();
                showAlert("Information Message", "Student Invoice PDF file downloaded successfully!",
                        Alert.AlertType.INFORMATION);
            } catch (IOException e) {
                e.printStackTrace();
                showAlert("Error", "Error occurred while creating the PDF: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Unexpected error: " + e.getMessage(), Alert.AlertType.ERROR);
        } finally {
            try {
                if (connect != null && !connect.isClosed()) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeStudent(String selectedStudentMatricule) {
        String studentName = getStudentName(selectedStudentMatricule);
        String academicYear = getAcademicYearFromSettings();

        if (studentName == null) {
            showAlert("Error", "Student not found.", Alert.AlertType.ERROR);
            return;
        }
    
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation Dialog");
        confirmationAlert.setHeaderText(null);
        confirmationAlert.setContentText(
                "Are you sure you want to delete the student '" + studentName + "' and all related records for the academic year " + academicYear + "?");
    
        Optional<ButtonType> result = confirmationAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            String deleteEnrollmentsQuery = "DELETE FROM enrollments WHERE student_id = ? AND academic_year = ?";
            String deleteFeesQuery = "DELETE FROM fees WHERE enrollment_id IN (SELECT id FROM enrollments WHERE student_id = ?)";
            String checkOtherEnrollmentsQuery = "SELECT COUNT(*) AS count FROM enrollments WHERE student_id = ?";
            String deleteStudentQuery = "DELETE FROM students WHERE matricule = ?";
    
            Connection connect = Database.connectDb();
            if (connect == null) {
                showAlert("Database Error", "Database connection could not be established.", Alert.AlertType.ERROR);
                return;
            }
    
            try {
                connect.setAutoCommit(false); // Start transaction
    
                // Delete fees records related to the student's enrollments for the specific academic year
                try (PreparedStatement deleteFeesStmt = connect.prepareStatement(deleteFeesQuery)) {
                    deleteFeesStmt.setString(1, selectedStudentMatricule);
                    deleteFeesStmt.executeUpdate();
                }
    
                // Delete enrollments records related to the student for the specific academic year
                try (PreparedStatement deleteEnrollmentsStmt = connect.prepareStatement(deleteEnrollmentsQuery)) {
                    deleteEnrollmentsStmt.setString(1, selectedStudentMatricule);
                    deleteEnrollmentsStmt.setString(2, academicYear);
                    deleteEnrollmentsStmt.executeUpdate();
                }
    
                // Check if there are any other enrollments for the student
                boolean hasOtherEnrollments = false;
                try (PreparedStatement checkEnrollmentsStmt = connect.prepareStatement(checkOtherEnrollmentsQuery)) {
                    checkEnrollmentsStmt.setString(1, selectedStudentMatricule);
                    try (ResultSet rs = checkEnrollmentsStmt.executeQuery()) {
                        if (rs.next()) {
                            int count = rs.getInt("count");
                            hasOtherEnrollments = (count > 0);
                        }
                    }
                }
    
                // If no other enrollments exist, delete the student record
                if (!hasOtherEnrollments) {
                    try (PreparedStatement deleteStudentStmt = connect.prepareStatement(deleteStudentQuery)) {
                        deleteStudentStmt.setString(1, selectedStudentMatricule);
                        deleteStudentStmt.executeUpdate();
                    }
                }
    
                connect.commit(); // Commit transaction
    
                showAlert("Information Message", "Student and related records for the academic year " + academicYear + " deleted successfully!",
                        Alert.AlertType.INFORMATION);
                personal_form.setVisible(false);
                all_students_form.setVisible(true);
                addStudentsShowListData();
    
            } catch (SQLException e) {
                try {
                    if (connect != null) {
                        connect.rollback(); // Rollback transaction on error
                    }
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
                e.printStackTrace();
                showAlert("Error", "Error occurred while deleting the student: " + e.getMessage(),
                        Alert.AlertType.ERROR);
            } finally {
                try {
                    if (connect != null && !connect.isClosed()) {
                        connect.setAutoCommit(true); // Reset auto-commit
                        connect.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            showAlert("Information Message", "Student deletion cancelled.", Alert.AlertType.INFORMATION);
        }
    }
    

    private String getStudentName(String studentMatricule) {
        String query = "SELECT name FROM students WHERE matricule = ?";
        Connection connect = Database.connectDb();
        if (connect == null) {
            return null;
        }
        try (PreparedStatement preparedStatement = connect.prepareStatement(query)) {
            preparedStatement.setString(1, studentMatricule);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connect != null && !connect.isClosed()) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void deleletStudent(@SuppressWarnings("exports") ActionEvent event) {
        removeStudent(selectedStudentMatricule);
    }

    public void downloadClassDetails(@SuppressWarnings("exports") ActionEvent event) {
        String selectedClassName = classRecord_Download.getValue();
        String selectDepartment = department_details.getValue();
        String selectedSection = SectionRecord_Download.getValue();

        if (selectedClassName == null || selectedSection == null || selectDepartment == null) {
            showAlert("Input Error", "Please select both class name and section.", Alert.AlertType.ERROR);
            return;
        }

        Connection connect = Database.connectDb();
        if (connect == null) {
            showAlert("Database Error", "Database connection could not be established.", Alert.AlertType.ERROR);
            return;
        }

        try {
            String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Directory for Download");
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            String suggestedFileName = "Class_Details_" + selectDepartment + "_" + selectedClassName + "_"
                    + selectedSection + "_" + currentDate
                    + ".pdf";
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF Files (*.pdf)", "*.pdf");
            fileChooser.getExtensionFilters().add(extFilter);
            fileChooser.setInitialFileName(suggestedFileName);

            javafx.stage.Window window = ((Node) event.getSource()).getScene().getWindow();
            File selectedFile = fileChooser.showSaveDialog(window);
            if (selectedFile == null) {
                return;
            }
            String filePath = selectedFile.getAbsolutePath();

            try (PdfDocument pdf = new PdfDocument(new PdfWriter(filePath))) {
                // PageSize landscape = PageSize.A4.rotate();
                Document document = new Document(pdf);

                PdfFont boldFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
                PdfFont blueFont = PdfFontFactory.createFont(StandardFonts.HELVETICA);
                DecimalFormat currencyFormat = new DecimalFormat("#,##0.00");

                String[] schoolInfo = getSchoolInfoFromSettings();
                String schoolName = schoolInfo[0];
                String principal = schoolInfo[2];
                String address = schoolInfo[3];
                String academicYear = getAcademicYearFromSettings();

                Div headerDiv = new Div()
                        .setTextAlignment(TextAlignment.CENTER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE);

                Paragraph schoolNameParagraph = new Paragraph(schoolName).setFont(boldFont).setFontSize(14);
                // Create a table with two columns
                Table infoTable = new Table(2);
                infoTable.setWidth(UnitValue.createPercentValue(100));

                // Add the paragraphs to the table, with each row having two cells
                infoTable.addCell(new Cell().add(new Paragraph("Academic Year: " + academicYear)
                        .setFont(blueFont).setFontSize(12)).setBorder(Border.NO_BORDER));

                infoTable.addCell(new Cell().add(new Paragraph("Printed Date: " + currentDate)
                        .setFont(blueFont).setFontSize(12)).setBorder(Border.NO_BORDER));

                infoTable.addCell(new Cell().add(new Paragraph("Address: " + address)
                        .setFont(blueFont).setFontSize(12)).setBorder(Border.NO_BORDER));

                infoTable.addCell(new Cell().add(new Paragraph("Principal: " + principal)
                        .setFont(blueFont).setFontSize(12)).setBorder(Border.NO_BORDER));

                // Add the table to the document
                document.add(infoTable);

                headerDiv.add(schoolNameParagraph);

                com.itextpdf.layout.element.Image watermarkImage = Logo
                        .createWatermarkImage(imageFile.getAbsolutePath());
                document.add(watermarkImage);
                document.add(headerDiv);

                String selectData = "SELECT e.*, s.name, s.date_of_birth, s.contact FROM enrollments e " +
                        "JOIN students s ON e.student_id = s.matricule " +
                        "WHERE e.class_name = ? AND e.section = ? AND e.academic_year = ? AND e.category = ?";
                try (PreparedStatement prepare = connect.prepareStatement(selectData)) {
                    prepare.setString(1, selectedClassName);
                    prepare.setString(2, selectedSection);
                    prepare.setString(3, academicYear);
                    prepare.setString(4, selectDepartment);
                    try (ResultSet resultSet = prepare.executeQuery()) {
                        if (!resultSet.next()) {
                            showAlert("No Data", "No data found for the selected class and section.",
                                    Alert.AlertType.INFORMATION);
                            return;
                        }

                        float[] columnWidths = { 10f, 120f, 70f, 70f, 70f, 70f, 40f };
                        Table studentTable = new Table(columnWidths).useAllAvailableWidth();

                        PdfFont headingFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
                        studentTable.addHeaderCell(new Cell().add(new Paragraph("ID").setFont(headingFont)));
                        studentTable.addHeaderCell(new Cell().add(new Paragraph("Name").setFont(headingFont)));
                        studentTable.addHeaderCell(new Cell().add(new Paragraph("DOB").setFont(headingFont)));
                        studentTable.addHeaderCell(new Cell().add(new Paragraph("Contact").setFont(headingFont)));
                        studentTable.addHeaderCell(new Cell().add(new Paragraph("Amount Owing").setFont(headingFont)));
                        studentTable.addHeaderCell(new Cell().add(new Paragraph("Amount Paid").setFont(headingFont)));
                        studentTable.addHeaderCell(new Cell().add(new Paragraph("Status").setFont(headingFont)));

                        int studentCount = 0;

                        do {
                            int studentId = resultSet.getInt("id");
                            String dateOfBirth = formatDate(resultSet.getString("date_of_birth"));
                            String name = resultSet.getString("name");
                            String contact = resultSet.getString("contact");
                            double schoolFees = resultSet.getDouble("school_fees");
                            double totalFeesPaid = resultSet.getDouble("total_fees_paid");
                            double amountOwing = schoolFees - totalFeesPaid;
                            String status = resultSet.getString("status");
                            studentTable.addCell(String.valueOf(studentId));
                            studentTable.addCell(name);
                            studentTable.addCell(dateOfBirth);
                            studentTable.addCell(contact);
                            studentTable.addCell(currencyFormat.format(amountOwing));
                            studentTable.addCell(currencyFormat.format(totalFeesPaid));
                            studentTable.addCell(status);

                            studentCount++;
                        } while (resultSet.next());

                        document.add(new Paragraph("Class and Section: " + selectedClassName + " - " + selectedSection
                                + " => " + selectDepartment + "     |    Enrolled: " + studentCount)
                                .setFont(headingFont)
                                .setFontSize(14));

                        document.add(studentTable);

                        String sumQuery = "SELECT SUM(school_fees - total_fees_paid) AS grandTotalOwing, SUM(total_fees_paid) AS grandTotalPaid "
                                +
                                "FROM enrollments WHERE class_name = ? AND section = ? AND academic_year = ? AND category = ?";
                        try (PreparedStatement prepareSum = connect.prepareStatement(sumQuery)) {
                            prepareSum.setString(1, selectedClassName);
                            prepareSum.setString(2, selectedSection);
                            prepareSum.setString(3, academicYear);
                            prepareSum.setString(4, selectDepartment);
                            try (ResultSet result = prepareSum.executeQuery()) {
                                if (result.next()) {
                                    double grandTotalPaid = result.getDouble("grandTotalPaid");
                                    double grandTotalOwing = result.getDouble("grandTotalOwing");
                                    document.add(new Paragraph("Total Paid: " + currencyFormat.format(grandTotalPaid)
                                            + " |  Total Owing " + currencyFormat.format(grandTotalOwing))
                                            .setFont(headingFont)
                                            .setFontSize(14));
                                }
                            }
                        }
                    }
                }

                document.close();
                showAlert("Information Message", "Class Details PDF file downloaded successfully!",
                        Alert.AlertType.INFORMATION);
            } catch (IOException e) {
                e.printStackTrace();
                showAlert("Error", "Error occurred while creating the PDF: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Unexpected error: " + e.getMessage(), Alert.AlertType.ERROR);
        } finally {
            try {
                if (connect != null && !connect.isClosed()) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private String formatDate(String timestampString) {
        try {
            long timestamp = Long.parseLong(timestampString);
            Date date = new Date(timestamp);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
            return sdf.format(date);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "Invalid Date";
        }
    }

    public void promote(@SuppressWarnings("exports") ActionEvent event) {

        promoteForm.setVisible(true);
        promoteStudentName.setText(selectedStudentName);
        promoteStudentMat.setText(selectedStudentMatricule);
        promoteStudentYear.setText("2025-2026");
    }

    public void promoteStudent(@SuppressWarnings("exports") ActionEvent event) {
        String insertEnrollment = "INSERT INTO enrollments (student_id, class_name, section, academic_year, status, scholarship, school_fees, total_fees_paid, created_at, category) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String insertPayment = "INSERT INTO fees (enrollment_id, amount_paid, payment_date) VALUES (?, ?, ?)";

        Connection connect = null;
        PreparedStatement prepare = null;
        ResultSet resultSet = null;

        try {
            connect = Database.connectDb();
            if (connect == null) {
                showAlert("Database Error", "Database connection could not be established.", Alert.AlertType.ERROR);
                return;
            }

            String academicYear = promoteStudentYear.getText();
            String className = (String) promoteClass.getSelectionModel().getSelectedItem();
            String selectedSection = (String) PromoteSection.getSelectionModel().getSelectedItem();
            String selectedDepartment = (String) promoteDepartment.getSelectionModel().getSelectedItem();

            if (promoteStudent_paid.getText().isEmpty()) {
                showAlert("Error Message", "Amount field cannot be empty.", Alert.AlertType.ERROR);
                return;
            }
            // Check if the student is already enrolled for the new academic year
            String checkEnrollment = "SELECT id FROM enrollments WHERE student_id = ? AND class_name = ? AND section = ? AND academic_year = ?";
            try (PreparedStatement checkPrepare = connect.prepareStatement(checkEnrollment)) {
                checkPrepare.setString(1, selectedStudentMatricule);
                checkPrepare.setString(2, className);
                checkPrepare.setString(3, selectedSection);
                checkPrepare.setString(4, academicYear);
                resultSet = checkPrepare.executeQuery();
                if (resultSet.next()) {
                    showAlert("Error Message", "Student is already enrolled for the selected academic year.",
                            Alert.AlertType.ERROR);
                    return;
                }
            }

            // Get class_id and school_fees based on selected class_name, section, and
            // academic_year
            String getClassIdQuery = "SELECT id, school_fees FROM class WHERE class_name = ? AND " 
            + selectedSection + " = 1 AND category = ? AND academic_year = ?";
    
            @SuppressWarnings("unused")
            int classId = 0;
            double schoolFees = 0.0;
            try (PreparedStatement classPrepare = connect.prepareStatement(getClassIdQuery)) {
                classPrepare.setString(1, className);
                classPrepare.setString(2, selectedDepartment);
                classPrepare.setString(3, academicYear);
                resultSet = classPrepare.executeQuery();
                if (resultSet.next()) {
                    classId = resultSet.getInt("id");
                    schoolFees = resultSet.getDouble("school_fees");
                } else {
                    showAlert("Error", "Class not found for the selected section and academic year.",
                            Alert.AlertType.ERROR);
                    return;
                }
            }

            // Assume the student is promoted without a payment; you can update the logic as
            // needed
            double studentAmount = Double.parseDouble(promoteStudent_paid.getText());
            if (studentAmount > schoolFees) {
                showAlert("Error Message", "The student amount cannot exceed the school fees.", Alert.AlertType.ERROR);
                return;
            }

            double amountOwing = schoolFees - studentAmount;
            String status = (amountOwing <= 0) ? "OK" : "incomplete";
            String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            // Insert enrollment record for the new academic year
            try (PreparedStatement enrollPrepare = connect.prepareStatement(insertEnrollment,
                    PreparedStatement.RETURN_GENERATED_KEYS)) {
                enrollPrepare.setString(1, selectedStudentMatricule);
                enrollPrepare.setString(2, className);
                enrollPrepare.setString(3, selectedSection);
                enrollPrepare.setString(4, academicYear);
                enrollPrepare.setString(5, status);
                enrollPrepare.setDouble(6, 0.0); // Assuming no scholarship
                enrollPrepare.setDouble(7, schoolFees); // Adjusted school fees
                enrollPrepare.setDouble(8, studentAmount);
                enrollPrepare.setString(9, currentDate);
                enrollPrepare.setString(10, selectedDepartment);
                enrollPrepare.executeUpdate();

                ResultSet enrollmentKeys = enrollPrepare.getGeneratedKeys();
                if (enrollmentKeys.next()) {
                    int enrollmentId = enrollmentKeys.getInt(1);

                    // Insert initial payment record (if any)
                    if (studentAmount > 0) {
                        try (PreparedStatement paymentPrepare = connect.prepareStatement(insertPayment)) {
                            paymentPrepare.setInt(1, enrollmentId);
                            paymentPrepare.setDouble(2, studentAmount);
                            paymentPrepare.setString(3, currentDate);
                            paymentPrepare.executeUpdate();
                        }
                    }
                }
            }

            showAlert("Information Message",
                    "Student successfully promoted to " + className + " for the academic year " + academicYear + "!",
                    Alert.AlertType.INFORMATION);
            clearInputFields();
            showAllClassListData();
            displayWeeklyTotalPayments();

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Database Error", "Error occurred while promoting the student: " + e.getMessage(),
                    Alert.AlertType.ERROR);
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (prepare != null)
                    prepare.close();
                if (connect != null)
                    connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("resource")
    public void markSheet(@SuppressWarnings("exports") ActionEvent event) {
        String selectedClassName = marksheet_class.getValue();
        String selectedSection = marksheet_section.getValue();
        String selectedDepartment = department_marksheet.getValue();

        if (selectedClassName == null || selectedSection == null || selectedDepartment == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select a class, section, and department before downloading the mark sheet.");
            alert.showAndWait();
            return;
        }

        // Get the connection to the database
        connect = Database.connectDb();

        if (connect == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setHeaderText(null);
            alert.setContentText("Database connection could not be established.");
            alert.showAndWait();
            return;
        }

        try {
            String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            // Database query to check if class details exist
            String checkData = "SELECT COUNT(*) FROM enrollments e " +
                    "INNER JOIN students s ON e.student_id = s.matricule " +
                    "WHERE e.class_name = ? AND e.section = ? AND e.academic_year = ? AND e.category = ?";
            try (PreparedStatement checkPrepare = connect.prepareStatement(checkData)) {
                checkPrepare.setString(1, selectedClassName);
                checkPrepare.setString(2, selectedSection);
                checkPrepare.setString(3, getAcademicYearFromSettings());
                checkPrepare.setString(4, selectedDepartment);
                try (ResultSet checkResultSet = checkPrepare.executeQuery()) {
                    if (checkResultSet.next() && checkResultSet.getInt(1) == 0) {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText("No records found for the selected class, section, and department.");
                        alert.showAndWait();
                        return;
                    }
                }
            }

            // Create a FileChooser to allow the user to select a directory
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Directory for Download");

            // Set initial directory (optional)
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

            // Set the suggested file name for the Save As dialog (optional)
            String suggestedFileName = "MarkSheet_" + selectedDepartment + "_" + selectedClassName + "_"
                    + selectedSection + "_" + currentDate + ".pdf";
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF Files (*.pdf)", "*.pdf");
            fileChooser.getExtensionFilters().add(extFilter);
            fileChooser.setInitialFileName(suggestedFileName);

            // Show the Save As dialog and get the selected file
            javafx.stage.Window window = ((Node) event.getSource()).getScene().getWindow();
            File selectedFile = fileChooser.showSaveDialog(window);

            if (selectedFile == null) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("No file selected.");
                alert.showAndWait();
                return;
            }

            String filePath = selectedFile.getAbsolutePath();

            try (PdfDocument pdf = new PdfDocument(new PdfWriter(filePath))) {
                Document document = new Document(pdf);

                // Add School Name and Date at the top of the page
                PdfFont boldFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
                PdfFont blueFont = PdfFontFactory.createFont(StandardFonts.HELVETICA);

                Div headerDiv = new Div()
                        .setTextAlignment(TextAlignment.CENTER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE);

                String[] schoolInfo = getSchoolInfoFromSettings();
                String schoolName = schoolInfo[0];
                String Princi = schoolInfo[2];
                String address = schoolInfo[3];

                String academicYear = getAcademicYearFromSettings();
                Paragraph schoolNameParagraph = new Paragraph(schoolName)
                        .setFont(boldFont)
                        .setFontSize(14);

                // Create a table with two columns
                Table infoTable = new Table(2);
                infoTable.setWidth(UnitValue.createPercentValue(100));

                // Add the paragraphs to the table, with each row having two cells
                infoTable.addCell(new Cell().add(new Paragraph("Academic Year: " + academicYear)
                        .setFont(blueFont).setFontSize(12)).setBorder(Border.NO_BORDER));

                infoTable.addCell(new Cell().add(new Paragraph("Printed Date: " + currentDate)
                        .setFont(blueFont).setFontSize(12)).setBorder(Border.NO_BORDER));

                infoTable.addCell(new Cell().add(new Paragraph("Address: " + address)
                        .setFont(blueFont).setFontSize(12)).setBorder(Border.NO_BORDER));

                infoTable.addCell(new Cell().add(new Paragraph("Principal: " + Princi)
                        .setFont(blueFont).setFontSize(12)).setBorder(Border.NO_BORDER));

                // Add the table to the document
                document.add(infoTable);

                headerDiv.add(schoolNameParagraph);
                com.itextpdf.layout.element.Image watermarkImage = Logo
                        .createWatermarkImage(imageFile.getAbsolutePath());
                document.add(watermarkImage);
                document.add(headerDiv);

                // Database query to fetch class details based on the selected class and section
                String selectData = "SELECT e.student_id, s.name, s.date_of_birth, s.gender, e.class_name " +
                        "FROM enrollments e " +
                        "INNER JOIN students s ON e.student_id = s.matricule " +
                        "WHERE e.class_name = ? AND e.section = ? AND e.academic_year = ? AND e.category = ?";
                try (PreparedStatement prepare = connect.prepareStatement(selectData)) {
                    prepare.setString(1, selectedClassName);
                    prepare.setString(2, selectedSection);
                    prepare.setString(3, academicYear);
                    prepare.setString(4, selectedDepartment);
                    try (ResultSet resultSet = prepare.executeQuery()) {
                        if (resultSet.next()) {
                            float[] columnWidths = { 10f, 250f, 10f, 70f, 30f, 30f, 30f, 30f, 30f, 30f };
                            Table studentTable = new Table(columnWidths).useAllAvailableWidth();

                            PdfFont headingFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
                            studentTable.addHeaderCell(new Cell().add(new Paragraph("ID").setFont(headingFont)));
                            studentTable.addHeaderCell(new Cell().add(new Paragraph("Name").setFont(headingFont)));
                            studentTable.addHeaderCell(new Cell().add(new Paragraph("Sex").setFont(headingFont)));
                            studentTable.addHeaderCell(new Cell().add(new Paragraph("DOB").setFont(headingFont)));
                            studentTable.addHeaderCell(new Cell().add(new Paragraph("Sq1").setFont(headingFont)));
                            studentTable.addHeaderCell(new Cell().add(new Paragraph("Sq2").setFont(headingFont)));
                            studentTable.addHeaderCell(new Cell().add(new Paragraph("Sq3").setFont(headingFont)));
                            studentTable.addHeaderCell(new Cell().add(new Paragraph("Sq4").setFont(headingFont)));
                            studentTable.addHeaderCell(new Cell().add(new Paragraph("Sq5").setFont(headingFont)));
                            studentTable.addHeaderCell(new Cell().add(new Paragraph("Sq6").setFont(headingFont)));

                            do {
                                String studentId = resultSet.getString("student_id");
                                String name = resultSet.getString("name");
                                String dateOfBirth = getDateOfBirth(resultSet.getString("date_of_birth"));
                                String Gen = resultSet.getString("gender");
                                String genderSymbol = Gen.equalsIgnoreCase("Male") ? "M" : "F";
                                studentTable.addCell(studentId);
                                studentTable.addCell(name);
                                studentTable.addCell(genderSymbol);
                                studentTable.addCell(dateOfBirth);
                                studentTable.addCell("");
                                studentTable.addCell("");
                                studentTable.addCell("");
                                studentTable.addCell("");
                                studentTable.addCell("");
                                studentTable.addCell("");
                            } while (resultSet.next());

                            document.add(
                                    new Paragraph("Class and Section: " + selectedClassName + " - " + selectedSection
                                            + " => " + selectedDepartment)
                                            .setFont(headingFont)
                                            .setFontSize(14));
                            document.add(studentTable);
                        } else {
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Error Message");
                            alert.setHeaderText(null);
                            alert.setContentText("No records found for the selected class, section, and department.");
                            alert.showAndWait();
                            return;
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Database Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Error occurred while accessing the database.");
                    alert.showAndWait();
                    return;
                }

                document.close();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Class Details PDF file downloaded successfully!");
                alert.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("File Error");
                alert.setHeaderText(null);
                alert.setContentText("Error occurred while creating the PDF file.");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("An unexpected error occurred.");
            alert.showAndWait();
        }
    }

    public String getDateOfBirth(String dateOfBirth) {
        try {
            long timestamp = Long.parseLong(dateOfBirth);
            Date date = new Date(timestamp);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
            return sdf.format(date);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "Invalid Date";
        }
    }

    public void markSheet_word(@SuppressWarnings("exports") ActionEvent event) {
        String selectedClassName = marksheet_class.getValue();
        String selectedSection = marksheet_section.getValue();
        String selectedDepartment = department_marksheet.getValue();
        int totalStudents = 0;
        int maleCount = 0;
        int femaleCount = 0;

        if (selectedClassName == null || selectedSection == null || selectedDepartment == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select a class, section, and department before downloading the mark sheet.");
            alert.showAndWait();
            return;
        }

        // Get the connection to the database
        connect = Database.connectDb();

        if (connect == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setHeaderText(null);
            alert.setContentText("Database connection could not be established.");
            alert.showAndWait();
            return;
        }

        try {
            String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            // Database query to check if class details exist
            String checkData = "SELECT COUNT(*) FROM enrollments e " +
                    "INNER JOIN students s ON e.student_id = s.matricule " +
                    "WHERE e.class_name = ? AND e.section = ? AND e.academic_year = ? AND e.category = ?";
            try (PreparedStatement checkPrepare = connect.prepareStatement(checkData)) {
                checkPrepare.setString(1, selectedClassName);
                checkPrepare.setString(2, selectedSection);
                checkPrepare.setString(3, getAcademicYearFromSettings());
                checkPrepare.setString(4, selectedDepartment);
                try (ResultSet checkResultSet = checkPrepare.executeQuery()) {
                    if (checkResultSet.next() && checkResultSet.getInt(1) == 0) {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText("No records found for the selected class, section, and department.");
                        alert.showAndWait();
                        return;
                    }
                }
            }

            // Create a FileChooser to allow the user to select a directory
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Directory for Download");

            // Set initial directory (optional)
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

            // Set the suggested file name for the Save As dialog (optional)
            String suggestedFileName = "MarkSheet_" + selectedClassName + "_" + selectedSection + "_" + currentDate
                    + ".docx";
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Word Documents (*.docx)",
                    "*.docx");
            fileChooser.getExtensionFilters().add(extFilter);
            fileChooser.setInitialFileName(suggestedFileName);

            // Show the Save As dialog and get the selected file
            javafx.stage.Window window = ((Node) event.getSource()).getScene().getWindow();
            File selectedFile = fileChooser.showSaveDialog(window);

            if (selectedFile == null) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("No file selected.");
                alert.showAndWait();
                return;
            }

            String filePath = selectedFile.getAbsolutePath();

            // Create a new Word document
            try (XWPFDocument document = new XWPFDocument()) {

                // Add School Name and Date at the top of the document
                String academicYear = getAcademicYearFromSettings();
                String[] schoolInfo = getSchoolInfoFromSettings();
                String schoolName = schoolInfo[0];
                String Princi = schoolInfo[2];
                String address = schoolInfo[3];

                // Add content to the document
                addParagraph(document, "Academic Year: " + academicYear, 14, true, ParagraphAlignment.LEFT);
                addParagraph(document, "Printed Date: " + currentDate, 10, true, ParagraphAlignment.LEFT);
                addParagraph(document, "Address: " + address, 14, true, ParagraphAlignment.LEFT);
                addParagraph(document, schoolName, 16, true, ParagraphAlignment.CENTER);

                // Add watermark image
                try (FileInputStream watermarkStream = new FileInputStream(imageFile.getAbsolutePath())) {
                    XWPFParagraph watermarkParagraph = document.createParagraph();
                    watermarkParagraph.setAlignment(ParagraphAlignment.CENTER);
                    watermarkParagraph.createRun().addPicture(watermarkStream, XWPFDocument.PICTURE_TYPE_PNG,
                            imageFile.getAbsolutePath(), Units.toEMU(50), Units.toEMU(50));
                } catch (IOException e) {
                    e.printStackTrace();
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("File Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Error occurred while adding the watermark image.");
                    alert.showAndWait();
                }

                // Create a table with 10 columns
                XWPFTable table = document.createTable(1, 10);
                setTableHeader(table);

                // Database query to fetch class details based on the selected class and section
                String selectData = "SELECT e.student_id, s.name, s.date_of_birth, s.gender, e.class_name " +
                        "FROM enrollments e " +
                        "INNER JOIN students s ON e.student_id = s.matricule " +
                        "WHERE e.class_name = ? AND e.section = ? AND e.academic_year = ? AND e.category = ?";
                try (PreparedStatement prepare = connect.prepareStatement(selectData)) {
                    prepare.setString(1, selectedClassName);
                    prepare.setString(2, selectedSection);
                    prepare.setString(3, academicYear);
                    prepare.setString(4, selectedDepartment);
                    try (ResultSet resultSet = prepare.executeQuery()) {
                        if (resultSet.next()) {
                            // Iterate through the students and add their details to the table
                            do {
                                String studentId = resultSet.getString("student_id");
                                String name = resultSet.getString("name");
                                String dateOfBirth = getDateOfBirth(resultSet.getString("date_of_birth"));

                                String Gen = resultSet.getString("gender");
                                String genderSymbol = Gen.equalsIgnoreCase("Male") ? "M" : "F";

                                XWPFTableRow dataRow = table.createRow();
                                dataRow.getCell(0).setText(String.valueOf(studentId));
                                dataRow.getCell(1).setText(name);
                                dataRow.getCell(2).setText(genderSymbol);
                                dataRow.getCell(3).setText(dateOfBirth);
                                for (int i = 4; i < 10; i++) {
                                    dataRow.getCell(i).setText("");
                                }

                                totalStudents++;
                                if (Gen.equalsIgnoreCase("Male")) {
                                    maleCount++;
                                } else {
                                    femaleCount++;
                                }
                            } while (resultSet.next());
                        } else {
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Error Message");
                            alert.setHeaderText(null);
                            alert.setContentText("No records found for the selected class, section, and department.");
                            alert.showAndWait();
                            return;
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Database Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Error occurred while accessing the database.");
                    alert.showAndWait();
                    return;
                }

                // Add counts to the document
                addParagraph(
                        document, selectedClassName + ": " + selectedSection + "  |  Total: " + totalStudents
                                + "  |    F:" + femaleCount + "   |    M:" + maleCount,
                        14, true, ParagraphAlignment.CENTER);

                // Create the "Principal" paragraph
                addParagraph(document, "Principal: " + Princi, 14, true, ParagraphAlignment.CENTER);

                // Save the document to a file
                try (FileOutputStream fileOut = new FileOutputStream(new File(filePath))) {
                    document.write(fileOut);
                }

                // Show success message
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("MarkSheet Word document downloaded successfully!");
                alert.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("File Error");
                alert.setHeaderText(null);
                alert.setContentText("Error occurred while creating the Word document.");
                alert.showAndWait();
            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("An unexpected error occurred.");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("An unexpected error occurred.");
            alert.showAndWait();
        }
    }

    private void addParagraph(XWPFDocument document, String text, int fontSize, boolean isBold,
            ParagraphAlignment alignment) {
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(alignment);
        XWPFRun run = paragraph.createRun();
        run.setText(text);
        run.setFontSize(fontSize);
        run.setBold(isBold);
    }

    private void setTableHeader(XWPFTable table) {
        XWPFTableRow headerRow = table.getRow(0);
        headerRow.getCell(0).setText("ID");
        headerRow.getCell(1).setText("Name");
        headerRow.getCell(2).setText("Sex");
        headerRow.getCell(3).setText("DOB");
        headerRow.getCell(4).setText("Sq1");
        headerRow.getCell(5).setText("Sq2");
        headerRow.getCell(6).setText("Sq3");
        headerRow.getCell(7).setText("Sq4");
        headerRow.getCell(8).setText("Sq5");
        headerRow.getCell(9).setText("Sq6");
    }

    @SuppressWarnings("exports")
    public void markSheet_excel(ActionEvent event) {
        String selectedClassName = marksheet_class.getValue();
        String selectedSection = marksheet_section.getValue();
        String selectedDepartment = department_marksheet.getValue();

        if (selectedClassName == null || selectedSection == null || selectedDepartment == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select a class, section, and department before downloading the mark sheet.");
            alert.showAndWait();
            return;
        }

        // Get the connection to the database
        connect = Database.connectDb();

        if (connect == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setHeaderText(null);
            alert.setContentText("Database connection could not be established.");
            alert.showAndWait();
            return;
        }

        try {
            String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            // Database query to check if class details exist
            String checkData = "SELECT COUNT(*) FROM enrollments e " +
                    "INNER JOIN students s ON e.student_id = s.matricule " +
                    "WHERE e.class_name = ? AND e.section = ? AND e.academic_year = ? AND e.category = ?";
            try (PreparedStatement checkPrepare = connect.prepareStatement(checkData)) {
                checkPrepare.setString(1, selectedClassName);
                checkPrepare.setString(2, selectedSection);
                checkPrepare.setString(3, getAcademicYearFromSettings());
                checkPrepare.setString(4, selectedDepartment);
                try (ResultSet checkResultSet = checkPrepare.executeQuery()) {
                    if (checkResultSet.next() && checkResultSet.getInt(1) == 0) {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText("No records found for the selected class, section, and department.");
                        alert.showAndWait();
                        return;
                    }
                }
            }

            // Create a FileChooser to allow the user to select a directory
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Directory for Download");

            // Set initial directory (optional)
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

            // Set the suggested file name for the Save As dialog (optional)
            String suggestedFileName = "MarkSheet_" + selectedClassName + "_" + selectedSection + "_" + currentDate
                    + ".xls";
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel Files (*.xls)", "*.xls");
            fileChooser.getExtensionFilters().add(extFilter);
            fileChooser.setInitialFileName(suggestedFileName);

            // Show the Save As dialog and get the selected file
            javafx.stage.Window window = ((Node) event.getSource()).getScene().getWindow();
            File selectedFile = fileChooser.showSaveDialog(window);

            if (selectedFile == null) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("No file selected.");
                alert.showAndWait();
                return;
            }

            String filePath = selectedFile.getAbsolutePath();
            String academicYear = getAcademicYearFromSettings();

            // Create a new Excel workbook
            try (HSSFWorkbook workbook = new HSSFWorkbook()) {
                HSSFSheet sheet = workbook.createSheet("MarkSheet");

                // Add headers to the Excel sheet with custom style
                HSSFRow headerRow = sheet.createRow(0);
                setExcelHeader(headerRow);

                // Database query to fetch class details based on the selected class and section
                String selectData = "SELECT e.student_id, s.name, s.date_of_birth, s.gender, e.class_name " +
                        "FROM enrollments e " +
                        "INNER JOIN students s ON e.student_id = s.matricule " +
                        "WHERE e.class_name = ? AND e.section = ? AND e.academic_year = ? AND e.category = ?";
                try (PreparedStatement prepare = connect.prepareStatement(selectData)) {
                    prepare.setString(1, selectedClassName);
                    prepare.setString(2, selectedSection);
                    prepare.setString(3, academicYear);
                    prepare.setString(4, selectedDepartment);
                    try (ResultSet resultSet = prepare.executeQuery()) {
                        int rowNum = 1;
                        if (resultSet.next()) {
                            // Iterate through the students and add their details to the Excel sheet
                            do {
                                String studentId = resultSet.getString("student_id");
                                String name = resultSet.getString("name");
                                String dateOfBirth = getDateOfBirth(resultSet.getString("date_of_birth"));
                                String Gen = resultSet.getString("gender");
                                String genderSymbol = Gen.equalsIgnoreCase("Male") ? "M" : "F";

                                HSSFRow dataRow = sheet.createRow(rowNum++);
                                dataRow.createCell(0).setCellValue(studentId);
                                dataRow.createCell(1).setCellValue(name);
                                dataRow.createCell(2).setCellValue(genderSymbol);
                                dataRow.createCell(3).setCellValue(dateOfBirth);
                                for (int i = 4; i < 10; i++) {
                                    dataRow.createCell(i).setCellValue("");
                                }
                            } while (resultSet.next());
                        } else {
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Error Message");
                            alert.setHeaderText(null);
                            alert.setContentText("No records found for the selected class, section, and department.");
                            alert.showAndWait();
                            return;
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Database Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Error occurred while accessing the database.");
                    alert.showAndWait();
                    return;
                }

                // Autosize columns to fit content after all rows are added
                for (int i = 0; i < 10; i++) {
                    sheet.autoSizeColumn(i);
                }

                // Write the workbook to the selected file
                try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                    workbook.write(fileOut);
                }

                // Show success message
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Class List Excel file downloaded successfully!");
                alert.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("File Error");
                alert.setHeaderText(null);
                alert.setContentText("Error occurred while creating the Excel file.");
                alert.showAndWait();
            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("An unexpected error occurred.");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("An unexpected error occurred.");
            alert.showAndWait();
        }
    }

    private void setExcelHeader(HSSFRow headerRow) {
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("Sex");
        headerRow.createCell(3).setCellValue("DOB");
        headerRow.createCell(4).setCellValue("Sq1");
        headerRow.createCell(5).setCellValue("Sq2");
        headerRow.createCell(6).setCellValue("Sq3");
        headerRow.createCell(7).setCellValue("Sq4");
        headerRow.createCell(8).setCellValue("Sq5");
        headerRow.createCell(9).setCellValue("Sq6");
    }

    public void saveSettings() {
        String selectData = "SELECT * FROM settings WHERE schoolName = ?";
        String updateData = "UPDATE settings SET principal = ?, address = ?, academicYear = ? WHERE schoolName = ?";
        String insertData = "INSERT INTO settings (schoolName, principal, address, academicYear) VALUES (?, ?, ?, ?)";

        try (Connection connect = Database.connectDb()) {
            // Check if any field is empty
            if (school_name.getText().isEmpty() || principal.getText().isEmpty() || address.getText().isEmpty()
                    || school_year.getSelectionModel().getSelectedItem() == null) {
                showAlert("Error Message", "Please fill in all fields and select your current school year",
                        Alert.AlertType.ERROR);
                return;
            }

            try (PreparedStatement selectStmt = connect.prepareStatement(selectData)) {
                selectStmt.setString(1, school_name.getText());
                try (ResultSet resultSet = selectStmt.executeQuery()) {
                    if (resultSet.next()) {
                        // The record already exists, perform an update
                        try (PreparedStatement updateStmt = connect.prepareStatement(updateData)) {
                            updateStmt.setString(1, principal.getText());
                            updateStmt.setString(2, address.getText());
                            updateStmt.setString(3, (String) school_year.getSelectionModel().getSelectedItem());
                            updateStmt.setString(4, school_name.getText());
                            updateStmt.executeUpdate();
                        }
                        showAlert("Success", "Successfully Updated School Details!", Alert.AlertType.INFORMATION);
                    } else {
                        // The record doesn't exist, perform an insert
                        try (PreparedStatement insertStmt = connect.prepareStatement(insertData)) {
                            insertStmt.setString(1, school_name.getText());
                            insertStmt.setString(2, principal.getText());
                            insertStmt.setString(3, address.getText());
                            insertStmt.setString(4, (String) school_year.getSelectionModel().getSelectedItem());
                            insertStmt.executeUpdate();
                        }
                        showAlert("Success", "Successfully Saved Settings!", Alert.AlertType.INFORMATION);
                    }
                    displaySchoolInfo();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void recordDailyTotalPaid() {
        // Get the current date
        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // Get the connection to the database
        try {
            connect = Database.connectDb();
            // Calculate the total first payments for the day

            // Calculate the total payment amounts for the day
            double totalPaymentAmounts = calculateTotalPaymentAmounts(connect, currentDate);

            // Calculate the total payments for the day
            double totalPayments = totalPaymentAmounts;
            DecimalFormat currencyFormat = new DecimalFormat("#,##0.00");
            String TotalPayments = currencyFormat.format(totalPayments);

            dailyrecord.setText(TotalPayments);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private double calculateTotalPaymentAmounts(Connection connect, String currentDate) throws SQLException {
        // Query to calculate the total payment amounts for the day
        String query = "SELECT SUM(amount_paid) AS total_payment_amounts " +
                "FROM fees " +
                "WHERE payment_date = ?";

        double totalPaymentAmounts = 0.0;

        try (PreparedStatement statement = connect.prepareStatement(query)) {
            // Set the current date as the parameter in the query
            statement.setString(1, currentDate);

            // Execute the query and get the result
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    totalPaymentAmounts = resultSet.getDouble("total_payment_amounts");

                }
            }
        }

        return totalPaymentAmounts;
    }

    public double calculateWeeklyTotalPayments() {
        double weeklyTotalPayments = 0.0;
        LocalDate currentDate = LocalDate.now();
        LocalDate startDate = currentDate.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        LocalDate endDate = currentDate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String formattedStartDate = startDate.format(formatter);
        String formattedEndDate = endDate.format(formatter);

        try {
            // Database query to retrieve payments made between the start and end dates of
            // the current week from the "payments" table
            String selectPaymentsData = "SELECT amount_paid FROM fees WHERE payment_date BETWEEN ? AND ?";
            try (PreparedStatement prepare = connect.prepareStatement(selectPaymentsData)) {
                prepare.setString(1, formattedStartDate.toString());
                prepare.setString(2, formattedEndDate.toString());
                try (ResultSet resultSet = prepare.executeQuery()) {
                    // Iterate through the results and sum up the payments from the "payments" table
                    while (resultSet.next()) {
                        double paymentAmount = resultSet.getDouble("amount_paid");
                        weeklyTotalPayments += paymentAmount;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return weeklyTotalPayments;
    }

    public void displayWeeklyTotalPayments() {
        // Call the method to calculate the weekly total payments
        double weeklyTotalPayments = calculateWeeklyTotalPayments();

        DecimalFormat currencyFormat = new DecimalFormat("#,##0.00");
        String weaklyTotalPayments = currencyFormat.format(weeklyTotalPayments);

        weaklyrecord.setText(weaklyTotalPayments);

    }

    @SuppressWarnings("exports")
    public void generateWeeklyRecordPdf(ActionEvent event) {
        // Get the current date and calculate the start and end dates for the current
        // week (Monday to Sunday)
        LocalDate currentDate = LocalDate.now();
        LocalDate startLocalDate = currentDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate endLocalDate = currentDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String startDate = startLocalDate.format(formatter);
        String endDate = endLocalDate.format(formatter);

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Directory for Download");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        String suggestedFileName = "Weekly_Record_" + startDate + "_to_" + endDate + ".pdf";
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF Files (*.pdf)", "*.pdf");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setInitialFileName(suggestedFileName);

        javafx.stage.Window window = ((Node) event.getSource()).getScene().getWindow();
        File selectedFile = fileChooser.showSaveDialog(window);

        // Ensure that a file has been selected before proceeding
        if (selectedFile == null) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("No file selected! Please select a location to save the PDF.");
            alert.showAndWait();
            return;
        }

        String filePath = selectedFile.getAbsolutePath();

        try (PdfDocument pdf = new PdfDocument(new PdfWriter(filePath))) {
            @SuppressWarnings("resource")
            Document document = new Document(pdf);

            PdfFont boldFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
            PdfFont blueFont = PdfFontFactory.createFont(StandardFonts.HELVETICA);

            // Create a Div element for center alignment
            Div headerDiv = new Div().setTextAlignment(TextAlignment.CENTER)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE);

            DecimalFormat currencyFormat = new DecimalFormat("#,##0.00"); // Define currencyFormat here

            String[] schoolInfo = getSchoolInfoFromSettings();
            String schoolName = schoolInfo[0];
            String principal = schoolInfo[2];
            String address = schoolInfo[3];

            String academicYear = getAcademicYearFromSettings();
            Paragraph schoolNameParagraph = new Paragraph(schoolName).setFont(boldFont).setFontSize(18);

            // Create a table with two columns to arrange the information in two columns
            Table infoTable = new Table(2);
            infoTable.setWidth(UnitValue.createPercentValue(100));

            // Add cells for the first row (Academic Year and Address)
            Cell leftColumnCell1 = new Cell().add(new Paragraph("Academic Year: " + academicYear)
                    .setFont(blueFont).setFontSize(14))
                    .setTextAlignment(TextAlignment.LEFT)
                    .setBorder(Border.NO_BORDER);

            Cell rightColumnCell1 = new Cell().add(new Paragraph("Address: " + address)
                    .setFont(blueFont).setFontSize(14))
                    .setTextAlignment(TextAlignment.RIGHT)
                    .setBorder(Border.NO_BORDER);

            // Add cells for the second row (Principal and Printed Date)
            Cell leftColumnCell2 = new Cell().add(new Paragraph("Principal: " + principal)
                    .setFont(blueFont).setFontSize(14))
                    .setTextAlignment(TextAlignment.LEFT)
                    .setBorder(Border.NO_BORDER);

            Cell rightColumnCell2 = new Cell().add(new Paragraph("Printed Date: " + currentDate)
                    .setFont(blueFont).setFontSize(12))
                    .setTextAlignment(TextAlignment.RIGHT)
                    .setBorder(Border.NO_BORDER);

            // Add the cells to the table
            infoTable.addCell(leftColumnCell1);
            infoTable.addCell(rightColumnCell1);
            infoTable.addCell(leftColumnCell2);
            infoTable.addCell(rightColumnCell2);

            // Add the school name and table to the header div
            headerDiv.add(schoolNameParagraph);
            headerDiv.add(infoTable);

            // Add header
            Paragraph header = new Paragraph("Weekly Record - " + startDate + " to " + endDate)
                    .setFont(boldFont).setFontSize(14).setTextAlignment(TextAlignment.CENTER);

            // Adding the watermark image
            com.itextpdf.layout.element.Image watermarkImage = Logo.createWatermarkImage(imageFile.getAbsolutePath());
            document.add(watermarkImage);
            document.add(headerDiv);
            document.add(header);

            Table table = new Table(2);
            table.setWidth(UnitValue.createPercentValue(100));
            table.addHeaderCell(new Cell().add(new Paragraph("Date-Day").setFont(boldFont)));
            table.addHeaderCell(new Cell().add(new Paragraph("Sum").setFont(boldFont)));

            // Database query to retrieve daily total payments from the "fees" table for
            // each day of the week
            String selectPaymentsData = "SELECT payment_date, SUM(amount_paid) AS total_payment FROM fees WHERE payment_date BETWEEN ? AND ? GROUP BY payment_date";

            try (PreparedStatement preparePayments = connect.prepareStatement(selectPaymentsData)) {
                preparePayments.setString(1, startDate);
                preparePayments.setString(2, endDate);

                try (ResultSet paymentsResult = preparePayments.executeQuery()) {

                    Map<LocalDate, Double> dailyTotals = new HashMap<>();

                    // Add payment amounts from "fees" table to the map
                    while (paymentsResult.next()) {
                        // Retrieve the date as a String
                        String paymentDateString = paymentsResult.getString("payment_date");

                        // Parse the string to a LocalDate
                        LocalDate paymentDate = LocalDate.parse(paymentDateString,
                                DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                        double totalPayment = paymentsResult.getDouble("total_payment");
                        dailyTotals.merge(paymentDate, totalPayment, Double::sum);
                    }

                    // Sort the dates in ascending order
                    List<LocalDate> dates = new ArrayList<>(dailyTotals.keySet());
                    Collections.sort(dates);

                    // Iterate through the sorted dates and add date-day and sum to the table
                    for (LocalDate date : dates) {
                        String formattedDate = date.format(formatter) + " (" + date.getDayOfWeek() + ")";
                        double totalPayment = dailyTotals.getOrDefault(date, 0.0);

                        table.addCell(new Cell().add(new Paragraph(formattedDate).setFont(blueFont)));
                        table.addCell(
                                new Cell().add(new Paragraph(currencyFormat.format(totalPayment)).setFont(blueFont)));
                    }

                    document.add(table);

                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Weekly Record Downloaded successfully, Check Downloads folder!");
                    alert.showAndWait();
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

public void feeStructure(@SuppressWarnings("exports") ActionEvent event) {
    Connection connect = null;
    PreparedStatement prepare = null;
    ResultSet resultSet = null;

    try {
        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Directory for Download");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        String suggestedFileName = "Fees_Structure_" + currentDate + ".pdf";
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF Files (*.pdf)", "*.pdf");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setInitialFileName(suggestedFileName);

        javafx.stage.Window window = ((Node) event.getSource()).getScene().getWindow();
        File selectedFile = fileChooser.showSaveDialog(window);
        if (selectedFile == null) return; // user cancelled
        String filePath = selectedFile.getAbsolutePath();

        try (PdfDocument pdf = new PdfDocument(new PdfWriter(filePath))) {
            Document document = new Document(pdf, PageSize.A4.rotate());

            PdfFont boldFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
            PdfFont blueFont = PdfFontFactory.createFont(StandardFonts.HELVETICA);
            PdfFont contentFont = PdfFontFactory.createFont(StandardFonts.HELVETICA);

            DecimalFormat currencyFormat = new DecimalFormat("#,##0.00");
            String[] schoolInfo = getSchoolInfoFromSettings();
            String schoolName = schoolInfo[0];
            String principal = schoolInfo[2];
            String address = schoolInfo[3];
            String academicYear = getAcademicYearFromSettings();

         Div headerDiv = new Div()
                        .setTextAlignment(TextAlignment.CENTER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE);     
Paragraph schoolNameParagraph = new Paragraph(schoolName)
                        .setFont(boldFont)
                        .setFontSize(18);

                // Create a table with two columns to arrange the information in two columns
                Table infoTable = new Table(2);
                infoTable.setWidth(UnitValue.createPercentValue(100));

                // Add cells for the first row (Academic Year and Address)
                Cell leftColumnCell1 = new Cell().add(new Paragraph("Academic Year: " + academicYear)
                        .setFont(blueFont).setFontSize(14))
                        .setTextAlignment(TextAlignment.LEFT)
                        .setBorder(Border.NO_BORDER);

                Cell rightColumnCell1 = new Cell().add(new Paragraph("Address: " + address)
                        .setFont(blueFont).setFontSize(14))
                        .setTextAlignment(TextAlignment.RIGHT)
                        .setBorder(Border.NO_BORDER);

                // Add cells for the second row (Principal and Printed Date)
                Cell leftColumnCell2 = new Cell().add(new Paragraph("Principal: " + principal)
                        .setFont(blueFont).setFontSize(14))
                        .setTextAlignment(TextAlignment.LEFT)
                        .setBorder(Border.NO_BORDER);

                Cell rightColumnCell2 = new Cell().add(new Paragraph("Printed Date: " + currentDate)
                        .setFont(blueFont).setFontSize(12))
                        .setTextAlignment(TextAlignment.RIGHT)
                        .setBorder(Border.NO_BORDER);

                // Add the cells to the table
                infoTable.addCell(leftColumnCell1);
                infoTable.addCell(rightColumnCell1);
                infoTable.addCell(leftColumnCell2);
                infoTable.addCell(rightColumnCell2);

                // Add the school name and table to the header div
                headerDiv.add(schoolNameParagraph);
                headerDiv.add(infoTable);

                // Define fonts and colors
                PdfFont headingFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
                // Add header
                Paragraph header = new Paragraph("School Fees Structure")
                        .setFont(headingFont)
                        .setFontSize(14)
                        .setTextAlignment(TextAlignment.CENTER);

                // Adding the watermark image
                com.itextpdf.layout.element.Image watermarkImage = Logo
                        .createWatermarkImage(imageFile.getAbsolutePath());            document.add(watermarkImage);
            document.add(headerDiv);

           document.add(header);

            // Query
            connect = Database.connectDb();
            String selectData = "SELECT category, class_name, section, total_fees_paid FROM enrollments WHERE academic_year = ? ORDER BY category, class_name, section";
            prepare = connect.prepareStatement(selectData);
            prepare.setString(1, academicYear);
            resultSet = prepare.executeQuery();

            // Group by Department (category)
            Map<String, List<Map<String, Object>>> groupedData = new LinkedHashMap<>();

            while (resultSet.next()) {
                String category = resultSet.getString("category");
                String className = resultSet.getString("class_name");
                String section = resultSet.getString("section");
                double amountPaid = resultSet.getDouble("total_fees_paid");

                Map<String, Object> row = new HashMap<>();
                row.put("className", className);
                row.put("section", section);
                row.put("amountPaid", amountPaid);

                groupedData.computeIfAbsent(category, k -> new ArrayList<>()).add(row);
            }

            // Table setup
            float[] columnWidths = {75f, 50f, 100f, 100f, 100f, 100f, 100f};
            Table studentTable = new Table(columnWidths).useAllAvailableWidth();

            studentTable.addHeaderCell(new Cell().add(new Paragraph("Class").setFont(boldFont)));
            studentTable.addHeaderCell(new Cell().add(new Paragraph("Section").setFont(boldFont)));
            studentTable.addHeaderCell(new Cell().add(new Paragraph("Students").setFont(boldFont)));
            studentTable.addHeaderCell(new Cell().add(new Paragraph("RegFee").setFont(boldFont)));
            studentTable.addHeaderCell(new Cell().add(new Paragraph("Practicals").setFont(boldFont)));
            studentTable.addHeaderCell(new Cell().add(new Paragraph("Internship").setFont(boldFont)));
            studentTable.addHeaderCell(new Cell().add(new Paragraph("ActualFees").setFont(boldFont)));

            int totalStudents = 0;
            double totalRegFees = 0, totalPracFees = 0, totalInternshipFees = 0, totalActualFees = 0;

            // Loop departments
            for (String category : groupedData.keySet()) {
                // Department header row
                Cell deptHeader = new Cell(1, 7).add(new Paragraph("Department: " + category).setBold()).setBackgroundColor(ColorConstants.LIGHT_GRAY);
                studentTable.addCell(deptHeader);

                for (Map<String, Object> row : groupedData.get(category)) {
                    String className = (String) row.get("className");
                    String section = (String) row.get("section");
                    double amountPaid = (double) row.get("amountPaid");

                    int studentCount = 1; // assume 1 row = 1 student (adjust if you aggregate counts)
                    double regFee = calculateRegFee(className, section) * studentCount;
                    double pracFee = calculatePractical(className, section) * studentCount;
                    double internshipFee = calculateInternship(className, section) * studentCount;
                    double actualFees = amountPaid - (regFee + pracFee + internshipFee);

                    totalStudents += studentCount;
                    totalRegFees += regFee;
                    totalPracFees += pracFee;
                    totalInternshipFees += internshipFee;
                    totalActualFees += actualFees;

                    studentTable.addCell(new Cell().add(new Paragraph(className).setFont(contentFont)));
                    studentTable.addCell(new Cell().add(new Paragraph(section).setFont(contentFont)));
                    studentTable.addCell(new Cell().add(new Paragraph(String.valueOf(studentCount)).setFont(contentFont)));
                    studentTable.addCell(new Cell().add(new Paragraph(currencyFormat.format(regFee)).setFont(contentFont)));
                    studentTable.addCell(new Cell().add(new Paragraph(currencyFormat.format(pracFee)).setFont(contentFont)));
                    studentTable.addCell(new Cell().add(new Paragraph(currencyFormat.format(internshipFee)).setFont(contentFont)));
                    studentTable.addCell(new Cell().add(new Paragraph(currencyFormat.format(actualFees)).setFont(contentFont)));
                }
            }

            // Totals
            studentTable.addCell(new Cell(1, 2).add(new Paragraph("Grand Total").setFont(boldFont)));
            studentTable.addCell(new Cell().add(new Paragraph(String.valueOf(totalStudents)).setFont(boldFont)));
            studentTable.addCell(new Cell().add(new Paragraph(currencyFormat.format(totalRegFees)).setFont(boldFont)));
            studentTable.addCell(new Cell().add(new Paragraph(currencyFormat.format(totalPracFees)).setFont(boldFont)));
            studentTable.addCell(new Cell().add(new Paragraph(currencyFormat.format(totalInternshipFees)).setFont(boldFont)));
            studentTable.addCell(new Cell().add(new Paragraph(currencyFormat.format(totalActualFees)).setFont(boldFont)));

            document.add(studentTable);

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("School Fees structure downloaded Successfully!");
            alert.showAndWait();
        }

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (resultSet != null) resultSet.close();
            if (prepare != null) prepare.close();
            if (connect != null) connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    private double calculateRegFee(String className, String section) {
        if (className.equalsIgnoreCase("Form One") ||
                className.equalsIgnoreCase("Form Two") ||
                className.equalsIgnoreCase("Form Three") ||
                className.equalsIgnoreCase("Form Four") ||
                (className.equalsIgnoreCase("LowerSixth"))) {
            return 20000;
        } else if ((className.equalsIgnoreCase("Form Five") || className.equalsIgnoreCase("UpperSixth"))) {
            return 20000;
        } else {
            return 0; // Default value
        }
    }

    // Add internship calculation
private double calculateInternship(String className, String section) {
    if ((className.equalsIgnoreCase("Form Five") && section.equalsIgnoreCase("C")) ||
        (className.equalsIgnoreCase("UpperSixth") && section.equalsIgnoreCase("C"))) {
        return 10000;
    } else {
        return 0;
    }
}


    private double calculatePractical(String className, String section) {
        if ((className.equalsIgnoreCase("LowerSixth") || className.equalsIgnoreCase("UpperSixth"))
                && section.equalsIgnoreCase("Science")) {
            return 20000;
        } else {
            return 0; // Default value
        }
    }

    public void addTeacher() {
        String insertData = "INSERT INTO teachers "
                + "(Name, Sex, date_of_birth, national_id, subdivision_of_origin, Subject, phone_number, academic_year, age) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        connect = Database.connectDb();

        try {
            String academicYear = getAcademicYearFromSettings();

            if (teacher_name.getText().isEmpty() || teachers_dob.getValue() == null ||
                    addteacher_gender.getSelectionModel().getSelectedItem() == null ||
                    teacher_id.getText().isEmpty() || teacher_origin.getText().isEmpty() ||
                    teacher_subject.getText().isEmpty() || teacher_number.getText().isEmpty()) {

                showAlert("Error", "Please fill all fields.", AlertType.ERROR);
            } else {
                String name = teacher_name.getText();
                String gender = (String) addteacher_gender.getSelectionModel().getSelectedItem();
                LocalDate dateOfBirth = teachers_dob.getValue();
                String nationalId = teacher_id.getText();
                String origin = teacher_origin.getText();
                String subject = teacher_subject.getText();
                String phoneNumber = teacher_number.getText();
                int age = calculateAge(dateOfBirth);

                PreparedStatement preparedStatement = connect.prepareStatement(insertData);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, gender);
                preparedStatement.setDate(3, java.sql.Date.valueOf(dateOfBirth));
                preparedStatement.setString(4, nationalId);
                preparedStatement.setString(5, origin);
                preparedStatement.setString(6, subject);
                preparedStatement.setString(7, phoneNumber);
                preparedStatement.setString(8, academicYear);
                preparedStatement.setInt(9, age);

                preparedStatement.executeUpdate();
                showAlert("Success", "Teacher added successfully!", AlertType.INFORMATION);
                clearFields();
                teacherShowListData();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "An error occurred while adding the teacher.", AlertType.ERROR);
        }
    }

    private void showAlert(String title, String content, Alert.AlertType alertType) {
        if (!title.equalsIgnoreCase("Success")) {
            Toolkit.getDefaultToolkit().beep();
        }
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void clearFields() {
        teacher_name.clear();
        teachers_dob.setValue(null);
        addteacher_gender.getSelectionModel().clearSelection();
        teacher_id.clear();
        teacher_origin.clear();
        teacher_subject.clear();
        teacher_number.clear();
    }

    private int calculateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    private String generateMatricule() {
        String prefix = "SP";
        String year = new SimpleDateFormat("yy").format(new java.util.Date());
        String middle = generateRandomString(4);
        return prefix + middle + year;
    }

    private String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        school_name.textProperty().addListener((observable, oldValue, newValue) -> {
            school_name.setText(newValue.toUpperCase());
        });
        principal.textProperty().addListener((observable, oldValue, newValue) -> {
            principal.setText(newValue.toUpperCase());
        });
        address.textProperty().addListener((observable, oldValue, newValue) -> {
            address.setText(newValue.toUpperCase());
        });
        teacher_name.textProperty().addListener((observable, oldValue, newValue) -> {
            teacher_name.setText(newValue.toUpperCase());
        });
        teacher_id.textProperty().addListener((observable, oldValue, newValue) -> {
            teacher_id.setText(newValue.toUpperCase());
        });
        teacher_origin.textProperty().addListener((observable, oldValue, newValue) -> {
            teacher_origin.setText(newValue.toUpperCase());
        });
        teacher_subject.textProperty().addListener((observable, oldValue, newValue) -> {
            teacher_subject.setText(newValue.toUpperCase());
        });
        teacher_number.textProperty().addListener((observable, oldValue, newValue) -> {
            teacher_number.setText(newValue.toUpperCase());
        });
        updateteacher_name.textProperty().addListener((observable, oldValue, newValue) -> {
            updateteacher_name.setText(newValue.toUpperCase());
        });
        addStudents_firstName.textProperty().addListener((observable, oldValue, newValue) -> {
            addStudents_firstName.setText(newValue.toUpperCase());
        });
        updateteacher_subjects.textProperty().addListener((observable, oldValue, newValue) -> {
            updateteacher_subjects.setText(newValue.toUpperCase());
        });
        updateteacher_hours.textProperty().addListener((observable, oldValue, newValue) -> {
            updateteacher_hours.setText(newValue.toUpperCase());
        });
        updateteacher_origin.textProperty().addListener((observable, oldValue, newValue) -> {
            updateteacher_origin.setText(newValue.toUpperCase());
        });
        updateteacher_salary.textProperty().addListener((observable, oldValue, newValue) -> {
            updateteacher_salary.setText(newValue.toUpperCase());
        });
        updateteacher_tel.textProperty().addListener((observable, oldValue, newValue) -> {
            updateteacher_tel.setText(newValue.toUpperCase());
        });
        updateteacher_period.textProperty().addListener((observable, oldValue, newValue) -> {
            updateteacher_period.setText(newValue.toUpperCase());
        });
        updateteacher_natId.textProperty().addListener((observable, oldValue, newValue) -> {
            updateteacher_natId.setText(newValue.toUpperCase());
        });
        update_name.textProperty().addListener((observable, oldValue, newValue) -> {
            update_name.setText(newValue.toUpperCase());
        });
        displayUsername();
        defaultNav();

        homeDisplayTotalEnrolledStudents();
        homeDisplayMaleEnrolled();
        homeDisplayFemaleEnrolled();
        homeDisplayEnrolledMaleChart();
        homeDisplayFemaleEnrolledChart();
        homeDisplayTotalEnrolledChart();
        homeCollectedFees();
        // addStudent_year.setOnAction(event -> handleAcademicYearSelection());
        addStudent_class.setOnAction(event -> handleClassSelection());
        addStudent_section.setOnAction(event -> handleSectionSelection());
        // // TO SHOW IMMIDIATELY WHEN WE PROCEED TO DASHBOARD APPLICATION FORM
        addStudentsShowListData();
        // studentPaymentData(null);
        teacherShowListData();
        showAllClassListData();
        displayOwing();
        displayExpected();
        displayTotalOwing();
        displaySchoolInfo();
        teacherShowListData();
        addStudentsGenderList();
        getAcademicYearFromSettings();
        showClassListData();
        recordDailyTotalPaid();
        displayWeeklyTotalPayments();
        // addStudentsStatusList();
        // addStudentsCourseList();
        classYear();
        category();
        classes();
        selectDepartment();

        // handleAcademicYearSelection();
        // showClassInfo();

        // availableCourseShowListData();

        // studentGradesShowListData();

        // addClass_year.getItems().add(year);
        try {
            // Call the method to populate the academic year ComboBox with unique values
            // from the database
            String selectedYear = getAcademicYearFromSettings();
            showClassesForYear(selectedYear);
        } catch (SQLException e) {
            // Handle any exceptions that might occur while fetching data from the database
            e.printStackTrace();
        }

    }

}