package kingstech;

 import java.io.FileOutputStream;
 import java.io.File;
 import java.io.FileInputStream;
 import java.io.FileOutputStream;
 import java.io.File;
 import java.io.FileOutputStream;
 import java.io.IOException;
 import java.math.BigInteger;
 import java.net.URL;
 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;
 import java.time.DayOfWeek;
 import java.time.LocalDate;
 import java.time.Period;
 import java.util.ArrayList;
 import java.util.Collections;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import java.util.Optional;
 import java.util.ResourceBundle;
import com.itextpdf.text.pdf.PdfDocument;

import javafx.scene.Scene;
 import javafx.scene.control.Button;
 import javafx.scene.control.TableView;
 import java.text.DecimalFormat;
 import javafx.stage.Stage;
 import java.io.IOException;
 import javafx.scene.control.cell.PropertyValueFactory;
 import java.time.format.DateTimeFormatter;
 import java.time.temporal.TemporalAdjusters;
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
 import javafx.scene.chart.AreaChart;
 import javafx.scene.chart.BarChart;
 import javafx.scene.chart.LineChart;
 import javafx.scene.chart.XYChart;
 import javafx.scene.control.Alert;
 import javafx.scene.control.Alert.AlertType;
 import javafx.scene.control.ButtonType;
 import javafx.scene.control.CheckBox;
 import javafx.scene.control.ComboBox;
 import javafx.scene.control.DatePicker;
 import javafx.scene.control.Label;
 import javafx.scene.control.RadioButton;
 import javafx.scene.control.SplitPane;
 import javafx.scene.control.TableColumn;
 import javafx.scene.control.TextField;
 import javafx.scene.control.Toggle;
 import javafx.scene.control.ToggleGroup;
 import javafx.scene.image.Image;
 import javafx.scene.image.ImageView;
 import javafx.scene.input.MouseEvent;
 import javafx.scene.layout.AnchorPane;
 import javafx.stage.FileChooser;
 import javafx.stage.FileChooser.ExtensionFilter;
 import javafx.stage.StageStyle;
 
 
 
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
     private TableView<studentData> addStudents_tableView;
 
     @FXML
     private TableView<studentData> sceTableView;
 
     @FXML
     private TableView<studentData> showClass_tableView;
 
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
     private TableColumn<studentData, String> payment_col;
 
     @FXML
     private TableColumn<studentData, String> date_col;
 
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
     private Statement statement;
     private ResultSet result;
 
     private Image image;
 
     
     public int homeDisplayTotalEnrolledStudents() {
         int countEnrolled = 0;
         String academicYear = null;
     
         // Retrieve academic year from the settings table
         String sqlSettings = "SELECT academic_year FROM settings";
     
         Connection settingsConnection = null;
         Connection studentConnection = null;
     
         try {
             settingsConnection = Database.connectDb();
             prepare = settingsConnection.prepareStatement(sqlSettings);
             result = prepare.executeQuery();
     
             if (result.next()) {
                 academicYear = result.getString("academic_year");
             }
     
             // Close the resources related to the settings query
             result.close();
             prepare.close();
             settingsConnection.close();
     
             if (academicYear != null) {
                 String sqlEnrolled = "SELECT COUNT(id) FROM student WHERE academic_year = ?";
     
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
         String sqlSettings = "SELECT academic_year FROM settings";
     
         try {
             Connection settingsConnection = Database.connectDb();
             PreparedStatement prepare = settingsConnection.prepareStatement(sqlSettings);
             ResultSet result = prepare.executeQuery();
     
             if (result.next()) {
                 academicYear = result.getString("academic_year");
             }
     
             // Close the resources related to the settings query
             result.close();
             prepare.close();
             settingsConnection.close();
     
             if (academicYear != null) {
                 String sql = "SELECT COUNT(id) FROM student WHERE gender = 'female' AND academic_year = ?";
     
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
         String sqlSettings = "SELECT academic_year FROM settings";
     
         try {
             Connection settingsConnection = Database.connectDb();
             PreparedStatement prepareSettings = settingsConnection.prepareStatement(sqlSettings);
             ResultSet resultSettings = prepareSettings.executeQuery();
     
             if (resultSettings.next()) {
                 academicYear = resultSettings.getString("academic_year");
             }
     
             // Close the resources related to the settings query
             resultSettings.close();
             prepareSettings.close();
             settingsConnection.close();
     
             if (academicYear != null) {
                 String sql = "SELECT COUNT(id) FROM student WHERE status = 'incomplete' AND academic_year = ?";
     
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
         String sqlSettings = "SELECT academic_year FROM settings";
     
         try {
             Connection settingsConnection = Database.connectDb();
             PreparedStatement prepareSettings = settingsConnection.prepareStatement(sqlSettings);
             ResultSet resultSettings = prepareSettings.executeQuery();
     
             if (resultSettings.next()) {
                 academicYear = resultSettings.getString("academic_year");
             }
     
             // Close the resources related to the settings query
             resultSettings.close();
             prepareSettings.close();
             settingsConnection.close();
     
             if (academicYear != null) {
                 String sql = "SELECT SUM(amount_paid) FROM student WHERE academic_year = ?";
     
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
         String sqlSettings = "SELECT academic_year FROM settings";
     
         try {
             Connection settingsConnection = Database.connectDb();
             PreparedStatement prepareSettings = settingsConnection.prepareStatement(sqlSettings);
             ResultSet resultSettings = prepareSettings.executeQuery();
     
             if (resultSettings.next()) {
                 academicYear = resultSettings.getString("academic_year");
             }
     
             // Close the resources related to the settings query
             resultSettings.close();
             prepareSettings.close();
             settingsConnection.close();
     
             if (academicYear != null) {
                 String sql = "SELECT SUM(fees) FROM student WHERE academic_year = ?";
     
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
     
 
     public void displaySchoolName() {
 
         String sql = "SELECT school_name FROM settings ";
 
         connect = Database.connectDb();
 
         try {
             String school = "";
 
             prepare = connect.prepareStatement(sql);
             result = prepare.executeQuery();
 
             if (result.next()) {
                 school = result.getString("school_name");
             }
 
             show_SchoolName.setText(school);
 
         } catch (Exception e) {
             e.printStackTrace();
         }
 
     }
 
     public void displaySchoolYear() {
 
         String sql = "SELECT academic_year FROM settings ";
 
         connect = Database.connectDb();
 
         try {
             String school = "";
 
             prepare = connect.prepareStatement(sql);
             result = prepare.executeQuery();
 
             if (result.next()) {
                 school = result.getString("academic_year");
             }
 
             show_AcademicYear.setText(school);
             classshow_AcademicYear.setText(school);
             students_year.setText(school);
             marksheet_year.setText(school);
 
         } catch (Exception e) {
             e.printStackTrace();
         }
 
     }
 
     public void displayAddress() {
 
         String sql = "SELECT address FROM settings ";
 
         connect = Database.connectDb();
 
         try {
             String school = "";
 
             prepare = connect.prepareStatement(sql);
             result = prepare.executeQuery();
 
             if (result.next()) {
                 school = result.getString("address");
             }
 
             show_address.setText(school);
 
         } catch (Exception e) {
             e.printStackTrace();
         }
 
     }
 
     public void displayPrincipal() {
 
         String sql = "SELECT principal FROM settings ";
 
         connect = Database.connectDb();
 
         try {
             String school = "";
 
             prepare = connect.prepareStatement(sql);
             result = prepare.executeQuery();
 
             if (result.next()) {
                 school = result.getString("principal");
             }
 
             show_principal.setText(school);
 
         } catch (Exception e) {
             e.printStackTrace();
         }
 
     }
 
     public void displayTotalOwing() {
         String academicYear = null;
     
         // Retrieve academic year from the settings table
         String sqlSettings = "SELECT academic_year FROM settings";
     
         try {
             Connection settingsConnection = Database.connectDb();
             PreparedStatement prepareSettings = settingsConnection.prepareStatement(sqlSettings);
             ResultSet resultSettings = prepareSettings.executeQuery();
     
             if (resultSettings.next()) {
                 academicYear = resultSettings.getString("academic_year");
             }
     
             // Close the resources related to the settings query
             resultSettings.close();
             prepareSettings.close();
             settingsConnection.close();
     
             if (academicYear != null) {
                 String sql = "SELECT SUM(amount_owing) FROM student WHERE academic_year = ?";
     
                 Connection studentConnection = Database.connectDb();
                 PreparedStatement prepareStudent = studentConnection.prepareStatement(sql);
                 prepareStudent.setString(1, academicYear);
                 ResultSet resultStudent = prepareStudent.executeQuery();
     
                 int sumAmt = 0;
                 DecimalFormat currencyFormat = new DecimalFormat("#,##0");
                 if (resultStudent.next()) {
                     sumAmt = resultStudent.getInt(1);
                 }
     
                 // Close the resources related to the student query
                 resultStudent.close();
                 prepareStudent.close();
                 studentConnection.close();
     
                 students_total_owing.setText(currencyFormat.format(sumAmt));
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
     
 
     public void homeDisplayMaleEnrolled() {
         String academicYear = null;
     
         // Retrieve academic year from the settings table
         String sqlSettings = "SELECT academic_year FROM settings";
     
         try {
             Connection settingsConnection = Database.connectDb();
             PreparedStatement prepareSettings = settingsConnection.prepareStatement(sqlSettings);
             ResultSet resultSettings = prepareSettings.executeQuery();
     
             if (resultSettings.next()) {
                 academicYear = resultSettings.getString("academic_year");
             }
     
             // Close the resources related to the settings query
             resultSettings.close();
             prepareSettings.close();
             settingsConnection.close();
     
             if (academicYear != null) {
                 String sql = "SELECT COUNT(id) FROM student WHERE gender = 'male' AND academic_year = ?";
     
                 Connection studentConnection = Database.connectDb();
                 PreparedStatement prepareStudent = studentConnection.prepareStatement(sql);
                 prepareStudent.setString(1, academicYear);
                 ResultSet resultStudent = prepareStudent.executeQuery();
     
                 int countMale = 0;
                 if (resultStudent.next()) {
                     countMale = resultStudent.getInt("COUNT(id)");
                 }
     
                 // Close the resources related to the student query
                 resultStudent.close();
                 prepareStudent.close();
                 studentConnection.close();
     
                 home_totalMale.setText(String.valueOf(countMale));
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
     
 
     public void homeDisplayTotalEnrolledChart() {
         home_totalEnrolledChart.getData().clear();
     
         String sqlSettings = "SELECT academic_year FROM settings";
     
         try {
             Connection settingsConnection = Database.connectDb();
             PreparedStatement settingsPrepare = settingsConnection.prepareStatement(sqlSettings);
             ResultSet settingsResult = settingsPrepare.executeQuery();
     
             String academicYear = null;
             if (settingsResult.next()) {
                 academicYear = settingsResult.getString("academic_year");
             }
     
             // Close the resources related to the settings query
             settingsResult.close();
             settingsPrepare.close();
             settingsConnection.close();
     
             if (academicYear != null) {
                 String sql = "SELECT date, COUNT(id) FROM student WHERE academic_year = ? GROUP BY date ORDER BY TIMESTAMP(date) ASC";
     
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
     
     
     
     
 
     public void homeDisplayFemaleEnrolledChart() {
         home_totalFemaleChart.getData().clear();
     
         String sqlSettings = "SELECT academic_year FROM settings";
     
         try {
             Connection settingsConnection = Database.connectDb();
             PreparedStatement settingsPrepare = settingsConnection.prepareStatement(sqlSettings);
             ResultSet settingsResult = settingsPrepare.executeQuery();
     
             String academicYear = null;
             if (settingsResult.next()) {
                 academicYear = settingsResult.getString("academic_year");
             }
     
             // Close the resources related to the settings query
             settingsResult.close();
             settingsPrepare.close();
             settingsConnection.close();
     
             if (academicYear != null) {
         String sql = "SELECT date, COUNT(id) FROM student WHERE academic_year = ? AND gender = 'female' GROUP BY date ORDER BY TIMESTAMP(date) ASC";
 
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
 
     public void homeDisplayEnrolledMaleChart() {
         home_totalMaleChart.getData().clear();
     
         String sqlSettings = "SELECT academic_year FROM settings";
     
         try {
             Connection settingsConnection = Database.connectDb();
             PreparedStatement settingsPrepare = settingsConnection.prepareStatement(sqlSettings);
             ResultSet settingsResult = settingsPrepare.executeQuery();
     
             String academicYear = null;
             if (settingsResult.next()) {
                 academicYear = settingsResult.getString("academic_year");
             }
     
             // Close the resources related to the settings query
             settingsResult.close();
             settingsPrepare.close();
             settingsConnection.close();
     
             if (academicYear != null) {
         String sql = "SELECT date, COUNT(id) FROM student WHERE academic_year = ? AND gender = 'male' GROUP BY date ORDER BY TIMESTAMP(date) ASC";
 
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
         connect = Database.connectDb();
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
     String sqlSettings = "SELECT academic_year FROM settings";
     try (Connection settingsConnection = Database.connectDb();
          PreparedStatement settingsPrepare = settingsConnection.prepareStatement(sqlSettings);
          ResultSet settingsResult = settingsPrepare.executeQuery()) {
 
         if (settingsResult.next()) {
             return settingsResult.getString("academic_year");
         }
 
     } catch (SQLException e) {
         e.printStackTrace();
     }
     return null;
 }
 
 private boolean newSectionsHaveValueOfZero(boolean... newSections) {
     for (boolean sectionValue : newSections) {
         if (!sectionValue) {
             return true; // At least one section has value of 0
         }
     }
     return false; // All new sections are selected
 }
 
 public void addClassesAdd() {
     String insertData = "INSERT INTO class"
             + "(class_name, school_fees, academic_year, A1, A2, B1, B2, Arts, Science, Commercial, C) "
             + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
 
     String checkData = "SELECT DISTINCT class_name, A1, A2, B1, B2, Arts, Science, Commercial, C "
             + "FROM class WHERE class_name = ? AND academic_year = ? "
             + "AND (A1 = 1 OR A2 = 1 OR B1 = 1 OR B2 = 1 OR Arts = 1 OR Science = 1 OR Commercial = 1 OR C = 1)";
 
     try (Connection connect = Database.connectDb();
          PreparedStatement checkPrepare = connect.prepareStatement(checkData);
          PreparedStatement prepare = connect.prepareStatement(insertData)) {
 
         Alert alert;
 
         if (classes.getSelectedToggle() == null
                 || enter_fees.getText().isEmpty()
                 || (!A1_btn.isSelected()
                 && !A2_btn.isSelected()
                 && !B1_btn.isSelected()
                 && !b2_btn.isSelected()
                 && !C_btn.isSelected()
                 && !arts_btn.isSelected()
                 && !science_btn.isSelected()
                 && !commercial_btn.isSelected())) {
 
             // Handle empty fields or unselected toggles
             
             alert = new Alert(AlertType.ERROR);
             alert.setTitle("Error Message");
             alert.setHeaderText(null);
             alert.setContentText("Please fill all blank fields");
             alert.showAndWait();
         } else {
 
             // Get the academic year from the settings table
             String academicYear = getAcademicYearFromSettings();
 
             if (academicYear == null) {
                 // Academic year not found in the settings table
                 
                 alert = new Alert(AlertType.ERROR);
                 alert.setTitle("Error Message");
                 alert.setHeaderText(null);
                 alert.setContentText("Academic year not set in the settings table!");
                 alert.showAndWait();
             } else {
 
                 // Check if the class for the selected academic year already exists
                 checkPrepare.setString(1, ((RadioButton) classes.getSelectedToggle()).getText());
                 checkPrepare.setString(2, academicYear);
                 ResultSet result = checkPrepare.executeQuery();
 
                 if (result.next()) {
                     // Class already exists for the selected academic year
                     
                     Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
                     confirmationAlert.setTitle("Confirmation");
                     confirmationAlert.setHeaderText(null);
 
                     String existingSections = getCheckedSectionsFromResultSet(result);
 
                     confirmationAlert.setContentText("Class " + ((RadioButton) classes.getSelectedToggle()).getText() +
                             " already has sections (" + existingSections +
                             ") for this academic year. Do you wish to add the selected sections to it?");
 
                     Optional<ButtonType> resultButton = confirmationAlert.showAndWait();
 
                     if (resultButton.isPresent() && resultButton.get() == ButtonType.OK) {
                         boolean insertNewRow = false;
 
                         // Fetch the values from the ResultSet for existing sections
                         boolean existingA1 = result.getBoolean("A1");
                         boolean existingA2 = result.getBoolean("A2");
                         boolean existingB1 = result.getBoolean("B1");
                         boolean existingB2 = result.getBoolean("B2");
                         boolean existingArts = result.getBoolean("Arts");
                         boolean existingScience = result.getBoolean("Science");
                         boolean existingC = result.getBoolean("C");
                         boolean existingCommercial = result.getBoolean("Commercial");
 
                         // Check if any of the newly selected sections has a value of 0 in the existing row
                         if (A1_btn.isSelected() && !existingA1
                                 || A2_btn.isSelected() && !existingA2
                                 || B1_btn.isSelected() && !existingB1
                                 || b2_btn.isSelected() && !existingB2
                                 || arts_btn.isSelected() && !existingArts
                                 || science_btn.isSelected() && !existingScience
                                 || C_btn.isSelected() && !existingC
                                 || commercial_btn.isSelected() && !existingCommercial) {
                             insertNewRow = true;
                         }
 
                         if (insertNewRow) {
                             // Insert a new row with the selected sections set to 1 and existing sections to 0
                             prepare.setString(1, ((RadioButton) classes.getSelectedToggle()).getText());
                             prepare.setString(2, enter_fees.getText());
                             prepare.setString(3, academicYear);
                             // Check if each section is selected and has a value of 0 in the existing row
                             prepare.setBoolean(4, A1_btn.isSelected() && !existingA1);
                             prepare.setBoolean(5, A2_btn.isSelected() && !existingA2);
                             prepare.setBoolean(6, B1_btn.isSelected() && !existingB1);
                             prepare.setBoolean(7, b2_btn.isSelected() && !existingB2);
                             prepare.setBoolean(8, arts_btn.isSelected() && !existingArts);
                             prepare.setBoolean(9, science_btn.isSelected() && !existingScience);
                             prepare.setBoolean(10, commercial_btn.isSelected() && !existingCommercial);
                             prepare.setBoolean(11, C_btn.isSelected() && !existingC);
 
                             prepare.executeUpdate();
 
                             alert = new Alert(AlertType.INFORMATION);
                             alert.setTitle("Information Message");
                             alert.setHeaderText(null);
                             alert.setContentText("Successfully Added!");
                             alert.showAndWait();
 
                             showAllClassListData();
 
                             // Clear input fields and reset checkboxes after successful addition
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
                         } else {
                             // No new section with value 0 is selected, show warning
                             
                             alert = new Alert(AlertType.WARNING);
                             alert.setTitle("Warning");
                             alert.setHeaderText(null);
                             alert.setContentText("No new selected section. Class not added.");
                             alert.showAndWait();
                         }
                     }
                 } else {
                     // Class does not exist, proceed with the insertion
                     prepare.setString(1, ((RadioButton) classes.getSelectedToggle()).getText());
                     prepare.setString(2, enter_fees.getText());
                     prepare.setString(3, academicYear);
                     prepare.setBoolean(4, A1_btn.isSelected());
                     prepare.setBoolean(5, A2_btn.isSelected());
                     prepare.setBoolean(6, B1_btn.isSelected());
                     prepare.setBoolean(7, b2_btn.isSelected());
                     prepare.setBoolean(8, arts_btn.isSelected());
                     prepare.setBoolean(9, science_btn.isSelected());
                     prepare.setBoolean(10, commercial_btn.isSelected());
                     prepare.setBoolean(11, C_btn.isSelected());
 
                     prepare.executeUpdate();
 
                     alert = new Alert(AlertType.INFORMATION);
                     alert.setTitle("Information Message");
                     alert.setHeaderText(null);
                     alert.setContentText("Successfully Added!");
                     alert.showAndWait();
 
                     showAllClassListData();
 
                     // Clear input fields and reset checkboxes after successful addition
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
             }
         }
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }
 
 private String getCheckedSectionsFromResultSet(ResultSet resultSet) throws SQLException {
     StringBuilder sections = new StringBuilder();
 
     String[] sectionColumnNames = {"A1", "A2", "B1", "B2", "Arts", "Science", "Commercial"};
 
     for (String sectionColumnName : sectionColumnNames) {
         if (resultSet.getBoolean(sectionColumnName)) {
             if (sections.length() > 0) {
                 sections.append(", ");
             }
             sections.append(sectionColumnName);
         }
     }
 
     return sections.toString();
 }
 
 
     public void addStudentsAdd() {
         String insertData = "INSERT INTO student "
                 + "(student_id, name, date_of_birth, contact, amount_paid, amount_owing, gender, academic_year, status, section, class_id, other_fees, class_name, fees, first_payment_amount) "
                 + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
     
         connect = Database.connectDb();
 
         try {
             Alert alert;
             String academicYear = getAcademicYearFromSettings();
     
             if (
                      addStudent_class.getSelectionModel().getSelectedItem() == null
                     || addStudent_section.getSelectionModel().getSelectedItem() == null
                     || addStudents_firstName.getText().isEmpty()
                     || addStudents_gender.getSelectionModel().getSelectedItem() == null
                     || addStudents_birth.getValue() == null
                     || student_amount.getText().isEmpty()
                     || !isNumeric(student_amount.getText())
                     || !isNumeric(student_contact.getText())
                     
                     ) {
                 
                 
                 alert = new Alert(AlertType.ERROR);
                 alert.setTitle("Error Message");
                 alert.setHeaderText(null);
                 alert.setContentText("Please fill all fields correctly. Numeric values are required for Amount, Contact, and Other Amount.");
                 alert.showAndWait();
             } else {
                 // Check if the student already exists
                 String checkData = "SELECT name FROM student WHERE name = ? AND academic_year = ?";
                 prepare = connect.prepareStatement(checkData);
                 prepare.setString(1, addStudents_firstName.getText());
                 prepare.setString(2, academicYear);
                 result = prepare.executeQuery();
 
     
                 if (result.next()) {
                     
                     alert = new Alert(AlertType.ERROR);
                     alert.setTitle("Error Message");
                     alert.setHeaderText(null);
                     alert.setContentText("Student " + addStudents_firstName.getText() + " already exists for academic year" + academicYear );
                     alert.showAndWait();
                 } else {
                     String selectedSection = (String) addStudent_section.getSelectionModel().getSelectedItem();
 
                     // Get class_id based on selected class_name, section, and academic_year
                     String getClassIdQuery = "SELECT id FROM class WHERE class_name = ? AND academic_year = ? AND " +
                             selectedSection + " = 1";
                     prepare = connect.prepareStatement(getClassIdQuery);
                     prepare.setString(1, (String) addStudent_class.getSelectionModel().getSelectedItem());
                     prepare.setString(2, (String) academicYear);
                     result = prepare.executeQuery();
 
                     int classId = 0;
                     
                     
                     if (result.next()) {
                         classId = result.getInt("id");
                         
                     }
                     
     
                     // Auto-generate student_id based on class_id and section
                     String getStudentIdQuery = "SELECT COUNT(*) AS count FROM student WHERE class_id = ? AND section = ?";
                     prepare = connect.prepareStatement(getStudentIdQuery);
                     prepare.setInt(1, classId);
                     prepare.setString(2, (String) addStudent_section.getSelectionModel().getSelectedItem());
                     result = prepare.executeQuery();
     
                     int studentId = 1;
                     if (result.next()) {
                         studentId += result.getInt("count");
                     }
     
                     // Calculate amount_owing by subtracting student_amount from school_fees in class table
                     String getSchoolFeesQuery = "SELECT school_fees FROM class WHERE id = ?";
                     prepare = connect.prepareStatement(getSchoolFeesQuery);
                     prepare.setInt(1, classId);
                     result = prepare.executeQuery();
     
                     double schoolFees = 0.0;
                     if (result.next()) {
                         schoolFees = result.getDouble("school_fees");
                     }
     
                     double studentAmount = Double.parseDouble(student_amount.getText());
                     double otherAmount = other_amount.isSelected() ? 0.0 : 5000.0;
                     double amountOwing = schoolFees - studentAmount + otherAmount;
       
     
                     // Set status based on amount_owing
                     String status = (amountOwing <= 0) ? "completed" : "incomplete";
     
                     prepare = connect.prepareStatement(insertData);
                     prepare.setInt(1, studentId);
                     prepare.setString(2, addStudents_firstName.getText());
                     prepare.setString(3, String.valueOf(addStudents_birth.getValue()));
                     prepare.setString(4, student_contact.getText());
                     prepare.setString(5, String.valueOf(studentAmount));
                     prepare.setDouble(6, amountOwing);
                     prepare.setString(7, (String) addStudents_gender.getSelectionModel().getSelectedItem());
 
                      // Set photo to empty for now, modify as needed
                     prepare.setString(8, academicYear);
                     prepare.setString(9, status);
                     prepare.setString(10, (String) addStudent_section.getSelectionModel().getSelectedItem());
                     prepare.setInt(11, classId); // Save class_id instead of class_name
                     prepare.setString(12, String.valueOf(otherAmount)); // Set other_fees to 0 for now, modify as needed
                     prepare.setString(13, (String)addStudent_class.getSelectionModel().getSelectedItem()); // Set class_name based on retrieved value
                     double adjustedSchoolFees = other_amount.isSelected() ? schoolFees : schoolFees + 5000.0;
                     prepare.setDouble(14, adjustedSchoolFees);
                     prepare.setDouble(15, studentAmount);
                     prepare.executeUpdate();
 
                     
     
                     alert = new Alert(AlertType.INFORMATION);
                     alert.setTitle("Information Message");
                     alert.setHeaderText(null);
                     alert.setContentText("Successfully Added!");
                     alert.setOnCloseRequest(e -> {
                         if (alert.getResult() == ButtonType.OK) {
                             // Clear the input fields
                             addStudents_firstName.clear();
                             student_amount.clear();
                             student_contact.clear();
                             addStudent_class.getSelectionModel().clearSelection();
                             addStudent_section.getSelectionModel().clearSelection();
                             addStudents_gender.getSelectionModel().clearSelection();
                             addStudents_birth.setValue(null);
                         }
                     });
                     alert.showAndWait();
 
                     showAllClassListData();
                     addStudentsShowListData();
                     calculateTotalFirstPayments(connect, null);
                     displayWeeklyTotalPayments();
 
                 }
             }
     
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
     
     
     private boolean isNumeric(String str) {
         try {
             double d = Double.parseDouble(str);
             return true;
         } catch (NumberFormatException e) {
             return false;
         }
     }
 
     public void Scholarship() {
         String scholarship = schorlaship.getText();
     
         if (!isNumeric(scholarship)) {
             
             Alert alert = new Alert(AlertType.ERROR);
             alert.setTitle("Error Message");
             alert.setHeaderText(null);
             alert.setContentText("Please enter a valid numeric scholarship amount.");
             alert.showAndWait();
             return;
         }
     
         double scholarshipAmount = Double.parseDouble(scholarship);
     
         String updateQuery = "UPDATE student SET fees = fees - ?, amount_owing = amount_owing - ?, scholarship =  scholarship + ? WHERE id = ?";
         connect = Database.connectDb();
     
         try {
             prepare = connect.prepareStatement(updateQuery);
             prepare.setDouble(1, scholarshipAmount);
             prepare.setDouble(2, scholarshipAmount);
             prepare.setDouble(3, scholarshipAmount);
             // Assuming you have a variable studentId that holds the student's ID
             prepare.setInt(4, selectedStudentId);
     
             int rowsUpdated = prepare.executeUpdate();
     
             if (rowsUpdated > 0) {
                 // Check if the amount_owing becomes zero after scholarship
                 String checkAmountOwingQuery = "SELECT amount_owing FROM student WHERE id = ?";
                 prepare = connect.prepareStatement(checkAmountOwingQuery);
                 prepare.setInt(1, selectedStudentId);
                 ResultSet result = prepare.executeQuery();
     
                 if (result.next()) {
                     double amountOwing = result.getDouble("amount_owing");
                     if (amountOwing <= 0) {
                         // Update status to "completed"
                         String updateStatusQuery = "UPDATE student SET status = 'completed' WHERE id = ?";
                         prepare = connect.prepareStatement(updateStatusQuery);
                         prepare.setInt(1, selectedStudentId);
                         prepare.executeUpdate();
                     }
                 }
     
                 Alert alert = new Alert(AlertType.INFORMATION);
                 alert.setTitle("Information Message");
                 alert.setHeaderText(null);
                 alert.setContentText("Scholarship applied successfully!");
                 alert.showAndWait();
             } else {
                 
                 Alert alert = new Alert(AlertType.ERROR);
                 alert.setTitle("Error Message");
                 alert.setHeaderText(null);
                 alert.setContentText("Failed to apply scholarship. Please check the student ID.");
                 alert.showAndWait();
             }
         } catch (SQLException e) {
             e.printStackTrace();
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
         String material = "SELECT other_fees FROM student WHERE id = ?";
         double current = 0;
         try (PreparedStatement prepareMaterial = connect.prepareStatement(material)) {
             prepareMaterial.setInt(1, selectedStudentId);
             try (ResultSet resultSet = prepareMaterial.executeQuery()){
                 if (resultSet.next()){
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
             String updateQuery = "UPDATE student SET fees = fees + ?, amount_owing = amount_owing + ?, other_fees =  other_fees + ? WHERE id = ?";
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
 
         String updateData = "UPDATE student SET "
                 + "name = '" + update_name.getText()
                 + "', gender = '" + std_gender.getSelectionModel().getSelectedItem()
                 + "', date_of_birth = '" + dob.getValue() + "'"
                 + " WHERE id = " + selectedStudentId;
     
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
                     statement = connect.createStatement();
                     statement.executeUpdate(updateData);
     
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
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
 
      public void teacherUpdate() {
 
         String updateData = "UPDATE teachers SET "
                 + "Name = '" + updateteacher_name.getText()
                 + "', category = '" + updateteacher_category.getSelectionModel().getSelectedItem()
                 + "', subdivision_of_origin = '" + updateteacher_origin.getText()
                 + "', phone_number = '" + updateteacher_tel.getText()
                 + "', Subject = '" + updateteacher_subjects.getText()
                 + "', salary = '" + updateteacher_salary.getText()
                 + "', Work_Period = '" + updateteacher_period.getText()
                 + "', national_id = '" + updateteacher_natId.getText()
                 + "', work_Load = '" + updateteacher_hours.getText() + "'"
                 + " WHERE id = " + selectedTeacherId;
     
         connect = Database.connectDb();
     
         try {
             Alert alert;
             if (updateteacher_category.getSelectionModel().getSelectedItem() == null
                     || updateteacher_name.getText().isEmpty()
                     || updateteacher_hours.getText().isEmpty()
                     || updateteacher_period.getText().isEmpty()
                     || updateteacher_natId.getText().isEmpty()
                     || updateteacher_origin.getText().isEmpty()
                     || updateteacher_subjects.getText().isEmpty()
                     || updateteacher_tel.getText().isEmpty()
                     || updateteacher_salary.getText().isEmpty()) {
                 alert = new Alert(AlertType.ERROR);
                 alert.setTitle("Error Message");
                 alert.setHeaderText(null);
                 alert.setContentText("Please fill all fields");
                 alert.showAndWait();
             } else {
                 alert = new Alert(AlertType.CONFIRMATION);
                 alert.setTitle("Confirmation Message");
                 alert.setHeaderText(null);
                 alert.setContentText("Are you sure you want to update teacher " + updateteacher_name.getText() + "?");
                 Optional<ButtonType> option = alert.showAndWait();
     
                 if (option.get().equals(ButtonType.OK)) {
                     statement = connect.createStatement();
                     statement.executeUpdate(updateData);
     
                     alert = new Alert(AlertType.INFORMATION);
                     alert.setTitle("Information Message");
                     alert.setHeaderText(null);
                     alert.setContentText("Successfully Updated!");
                     alert.showAndWait();
     
                     // TO UPDATE THE TABLEVIEW
                     teacherShowListData();
                     // TO CLEAR THE FIELDS
                     // addStudentsClear();
     
                 } else {
                     return;
                 }
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
     
     public void processInstallmentPayment() {
         String updatePaymentQuery = "INSERT INTO payments (student_id, payment_amount, payment_date) VALUES (?, ?, ?)";
         String updateStudentQuery = "UPDATE student SET amount_paid = amount_paid + ?, amount_owing = GREATEST(amount_owing - ?, 0) WHERE id = ?";
         connect = Database.connectDb();
 
         String payment = payments.getText();
         Double paymentAmount = Double.parseDouble(payment);
 
         try {
             // Get the current amount_owing from the student table
             String getAmountOwingQuery = "SELECT amount_owing FROM student WHERE id = ?";
             prepare = connect.prepareStatement(getAmountOwingQuery);
             prepare.setInt(1, selectedStudentId);
             ResultSet result = prepare.executeQuery();
     
             double amountOwing = 0.0;
             if (result.next()) {
                 amountOwing = result.getDouble("amount_owing");
             }
     
             if (amountOwing < paymentAmount) {
                 
                 Alert alert = new Alert(AlertType.ERROR);
                 alert.setTitle("Error Message");
                 alert.setHeaderText(null);
                 alert.setContentText("Payment amount exceeds the amount owing. Please check the payment amount.");
                 alert.showAndWait();
                 return;
             }
             // Update the payments table with the new installment payment
             prepare = connect.prepareStatement(updatePaymentQuery);
             prepare.setInt(1, selectedStudentId);
             prepare.setDouble(2, paymentAmount);
             prepare.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
 
 
 
             prepare.executeUpdate();
     
             // Update the student table to reflect the payment received
             prepare = connect.prepareStatement(updateStudentQuery);
             prepare.setDouble(1, paymentAmount);
             prepare.setDouble(2, paymentAmount);
             prepare.setInt(3, selectedStudentId);
             prepare.executeUpdate();
 
             // Check if amount_owing is zero and update status accordingly
         if (amountOwing - paymentAmount == 0.0) {
             String updateStatusQuery = "UPDATE student SET status = 'completed' WHERE id = ?";
             prepare = connect.prepareStatement(updateStatusQuery);
             prepare.setInt(1, selectedStudentId);
             prepare.executeUpdate();
         }
     
             
             Alert alert = new Alert(AlertType.INFORMATION);
             alert.setTitle("Information Message");
             alert.setHeaderText(null);
             alert.setContentText("Payment of " + paymentAmount + "CFA processed successfully!");
             alert.setOnCloseRequest(e -> {
                         if (alert.getResult() == ButtonType.OK) {
                             payments.clear();
                         }
                     });
             alert.showAndWait();
 
             calculateTotalPaymentAmounts(connect, null);
             displayWeeklyTotalPayments();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
     
 
     // public void addStudentsDelete() {
 
     //     String deleteData = "DELETE FROM student WHERE studentNum = '"
     //             + addStudents_studentNum.getText() + "'";
 
     //     connect = Database.connectDb();
 
     //     try {
     //         Alert alert;
     //         if (addStudents_studentNum.getText().isEmpty()
     //                 || addStudents_year.getSelectionModel().getSelectedItem() == null
     //                 || addStudents_course.getSelectionModel().getSelectedItem() == null
     //                 || addStudents_firstName.getText().isEmpty()
     //                 || addStudents_lastName.getText().isEmpty()
     //                 || addStudents_gender.getSelectionModel().getSelectedItem() == null
     //                 || addStudents_birth.getValue() == null
     //                 || addStudents_status.getSelectionModel().getSelectedItem() == null
     //                 || getData.path == null || getData.path == "") {
     //             alert = new Alert(AlertType.ERROR);
     //             alert.setTitle("Error Message");
     //             alert.setHeaderText(null);
     //             alert.setContentText("Please fill all blank fields");
     //             alert.showAndWait();
     //         } else {
     //             alert = new Alert(AlertType.CONFIRMATION);
     //             alert.setTitle("Confirmation Message");
     //             alert.setHeaderText(null);
     //             alert.setContentText("Are you sure you want to DELETE Student #" + addStudents_studentNum.getText() + "?");
 
     //             Optional<ButtonType> option = alert.showAndWait();
 
     //             if (option.get().equals(ButtonType.OK)) {
 
     //                 statement = connect.createStatement();
     //                 statement.executeUpdate(deleteData);
 
     //                 String checkData = "SELECT studentNum FROM student_grade "
     //                         + "WHERE studentNum = '" + addStudents_studentNum.getText() + "'";
 
     //                 prepare = connect.prepareStatement(checkData);
     //                 result = prepare.executeQuery();
 
     //                 // IF THE STUDENT NUMBER IS EXIST THEN PROCEED TO DELETE
     //                 if (result.next()) {
     //                     String deleteGrade = "DELETE FROM student_grade WHERE "
     //                             + "studentNum = '" + addStudents_studentNum.getText() + "'";
 
     //                     statement = connect.createStatement();
     //                     statement.executeUpdate(deleteGrade);
 
     //                 }// IF NOT THEN NVM
 
     //                 alert = new Alert(AlertType.INFORMATION);
     //                 alert.setTitle("Information Message");
     //                 alert.setHeaderText(null);
     //                 alert.setContentText("Successfully Deleted!");
     //                 alert.showAndWait();
 
     //                 // TO UPDATE THE TABLEVIEW
     //                 addStudentsShowListData();
     //                 // TO CLEAR THE FIELDS
     //                 addStudentsClear();
 
     //             } else {
     //                 return;
     //             }
 
     //         }
     //     } catch (Exception e) {
     //         e.printStackTrace();
     //     }
 
     // }
 
     // public void addStudentsClear() {
     //     addStudents_studentNum.setText("");
     //     addStudents_year.getSelectionModel().clearSelection();
     //     addStudents_course.getSelectionModel().clearSelection();
     //     addStudents_firstName.setText("");
     //     addStudents_lastName.setText("");
     //     addStudents_gender.getSelectionModel().clearSelection();
     //     addStudents_birth.setValue(null);
     //     addStudents_status.getSelectionModel().clearSelection();
     //     addStudents_imageView.setImage(null);
 
     //     getData.path = "";
     // }
 
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
     } //WHILE WE INSERT THE DATA ON STUDENT, WE SHOULD INSERT ALSO THE DATA TO STUDENT_GRADE
 
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
     } //WHILE WE INSERT THE DATA ON STUDENT, WE SHOULD INSERT ALSO THE DATA TO STUDENT_GRADE
 
 
     public void addStudentsSearch() {
 
         FilteredList<studentData> filter = new FilteredList<>(addStudentsListD, e -> true);
 
 
         addStudents_search.textProperty().addListener((Observable, oldValue, newValue) -> {
 
             filter.setPredicate(predicateStudentData -> {
 
                 if (newValue == null || newValue.isEmpty()) {
                     return true;
                 }
 
                 String searchKey = newValue.toLowerCase();
 
                 if (predicateStudentData.getName().toLowerCase().contains(searchKey)) {
                     return true;
                 } else if (predicateStudentData.getId().toString().contains(searchKey)) {
                     return true;
                 } else if (predicateStudentData.getContact().toLowerCase().contains(searchKey)) {
                     return true;
                 } else if (predicateStudentData.getClassName().toLowerCase().contains(searchKey)) {
                     return true;
                 // } else if (predicateStudentData.getContact().toLowerCase().contains(searchKey)) {
                     // return true;
                 } else if (predicateStudentData.getGender().toLowerCase().contains(searchKey)) {
                     return true;
                 } else if (predicateStudentData.getDate_of_birth().toString().contains(searchKey)) {
                     return true;
                 } else if (predicateStudentData.getStatus().toLowerCase().contains(searchKey)) {
                     return true;
                 } else {
                     return false;
                 }
             });
         });
 
         SortedList<studentData> sortList = new SortedList<>(filter);
 
         sortList.comparatorProperty().bind(addStudents_tableView.comparatorProperty());
         addStudents_tableView.setItems(sortList);
 
     }
 
    
 
     public ObservableList<teacherData> teacherListData() {
     ObservableList<teacherData> listTeachers = FXCollections.observableArrayList();
     String academicYear = getAcademicYearFromSettings(); // Replace this with your implementation
 
     String sql = "SELECT * FROM teachers WHERE academic_year = ?";
 
     connect = Database.connectDb();
 
     try {
         teacherData teacherD;
         prepare = connect.prepareStatement(sql);
         prepare.setString(1, academicYear); // Set the academic year as a parameter in the query
         result = prepare.executeQuery();
 
         while (result.next()) {
             teacherD = new teacherData(
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
                 result.getString("category")
 
 
                 // result.getString("status")
             );
 
             listTeachers.add(teacherD);
         }
 
     } catch (Exception e) {
         e.printStackTrace();
     }
     return listTeachers;
 }
 
 // ... (rest of the code remains unchanged)
 
 
     private ObservableList<teacherData> teacherListD;
     
 
     public void teacherShowListData() {
         teacherListD = teacherListData();
 
         // addStudents_col_studentNum.setCellValueFactory(new PropertyValueFactory<>("id"));
         // showClass_col_A2.setCellValueFactory(new PropertyValueFactory<>("class_name"));
         teachernumber_col.setCellValueFactory(new PropertyValueFactory<>("contact"));
         teachername_col.setCellValueFactory(new PropertyValueFactory<>("name"));
         teacherperiod_col.setCellValueFactory(new PropertyValueFactory<>("period"));
         teachersex_col.setCellValueFactory(new PropertyValueFactory<>("gender"));
         teacherage_col.setCellValueFactory(new PropertyValueFactory<>("age"));
         // showClass_col_A2.setCellValueFactory(new PropertyValueFactory<>("className"));
         teacherhours_col.setCellValueFactory(new PropertyValueFactory<>("hours"));
 
         teachers_tableView.setItems(teacherListD);
 
     }
 
      public void teacherSearch() {
 
         FilteredList<teacherData> filter = new FilteredList<>(teacherListD, e -> true);
 
 
         teacher_search.textProperty().addListener((Observable, oldValue, newValue) -> {
 
             filter.setPredicate(predicateTeacherData -> {
 
                 if (newValue == null || newValue.isEmpty()) {
                     return true;
                 }
 
                 String searchKey = newValue.toLowerCase();
 
                 if (predicateTeacherData.getName().toLowerCase().contains(searchKey)) {
                     return true;
                 // } else if (predicateTeacherData.getId().toString().contains(searchKey)) {
                 //     return true;
                 } else if (predicateTeacherData.getContact().toLowerCase().contains(searchKey)) {
                     return true;
                 // } else if (predicateStudentData.getClassName().toLowerCase().contains(searchKey)) {
                 //     return true;
                 // } else if (predicateStudentData.getContact().toLowerCase().contains(searchKey)) {
                     // return true;
                 } else if (predicateTeacherData.getGender().toLowerCase().contains(searchKey)) {
                     return true;
                 // } else if (predicateTeacherData.getDate_of_birth().toString().contains(searchKey)) {
                 //     return true;
                 } else {
                     return false;
                 }
             });
         });
 
         SortedList<teacherData> sortList = new SortedList<>(filter);
 
         sortList.comparatorProperty().bind(teachers_tableView.comparatorProperty());
         teachers_tableView.setItems(sortList);
 
     }
 
 
 
     private String[] year = {"2023-2024", "2024-2025"};
 
     public void classYear() {
         List<String> academicYear = new ArrayList<>();
 
         for (String data : year) {
             academicYear.add(data);
         }
         ObservableList ObList = FXCollections.observableArrayList(academicYear);
         school_year.setItems(ObList);
     }
 
     private String[] category = {"Administrator", "Staff"};
 
     public void category() {
         List<String> teacherCategory = new ArrayList<>();
 
         for (String data : category) {
             teacherCategory.add(data);
         }
         ObservableList ObList = FXCollections.observableArrayList(teacherCategory);
         updateteacher_category.setItems(ObList);
     }
 
     private String[] genderList = {"Male", "Female"};
 
     public void addStudentsGenderList() {
         List<String> genderL = new ArrayList<>();
 
         for (String data : genderList) {
             genderL.add(data);
         }
 
         ObservableList ObList = FXCollections.observableArrayList(genderL);
         addStudents_gender.setItems(ObList);
         std_gender.setItems(ObList);
         addteacher_gender.setItems(ObList);
     }
 
     private void populateAcademicYears() throws SQLException {
         String query = "SELECT DISTINCT academic_year FROM class";
         Connection connection = null;
         PreparedStatement preparedStatement = null;
         ResultSet resultSet = null;
         ObservableList<String> academicYears = FXCollections.observableArrayList();
     
         try {
             connection = Database.connectDb();
             preparedStatement = connection.prepareStatement(query);
             resultSet = preparedStatement.executeQuery();
     
             while (resultSet.next()) {
                 String academicYear = resultSet.getString("academic_year");
                 academicYears.add(academicYear);
             }
     
             // Set the retrieved academic years to the ComboBox
             addStudent_year.setItems(academicYears);
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
         // Assuming you have a table called "classes" with columns "class_name" and "academic_year"
         String query = "SELECT class_name FROM class WHERE academic_year = ?";
         Connection connection = null;
         PreparedStatement preparedStatement = null;
         ResultSet resultSet = null;
         ObservableList<String> classNames = FXCollections.observableArrayList();
     
         try {
             connection = Database.connectDb();
             preparedStatement = connection.prepareStatement(query);
             preparedStatement.setString(1, academicYear);
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
          String selectedYear = getAcademicYearFromSettings();
         if (selectedClass == null) {
             return;
         }
         // Update the selected section based on the selected class
         try {
             showSectionsForClass(selectedClass, selectedYear);
         } catch (SQLException e) {
             e.printStackTrace();
             // Handle the exception if necessary
         }
     }
 
     @FXML
     private void handleStudentClass() {
         String selectedStudentClass = classRecord_Download.getValue();
          String selectedYear = getAcademicYearFromSettings();
         if (selectedStudentClass == null) {
             return;
         }
         // Update the selected section based on the selected class
         try {
             showSectionsForStudent(selectedStudentClass, selectedYear);
         } catch (SQLException e) {
             e.printStackTrace();
             // Handle the exception if necessary
         }
     }
 
     @FXML
     private void handleClassMarksheet() {
         String selectedClassMarksheet = marksheet_class.getValue();
          String selectedYear = getAcademicYearFromSettings();
         if (selectedClassMarksheet == null) {
             return;
         }
         // Update the selected section based on the selected class
         try {
             showSectionsForMarksheet(selectedClassMarksheet, selectedYear);
         } catch (SQLException e) {
             e.printStackTrace();
             // Handle the exception if necessary
         }
     }
 
 
     private void showSectionsForStudent(String className, String academicYear) throws SQLException {
         String query = "SELECT A1, A2, B1, B2, Arts, Science, Commercial, C " +
                        "FROM class WHERE class_name = ? AND academic_year = ?";
         Connection connection = null;
         PreparedStatement preparedStatement = null;
         ResultSet resultSet = null;
         String selectedStudentClass = null; // Initialize selectedSection to null
         ObservableList<String> classSections = FXCollections.observableArrayList();
     
         try {
             connection = Database.connectDb();
             preparedStatement = connection.prepareStatement(query);
             preparedStatement.setString(1, className);
             preparedStatement.setString(2, academicYear); 
             resultSet = preparedStatement.executeQuery();
     
             // Clear any previous items in the ComboBox
             SectionRecord_Download.getItems().clear();
     
             while (resultSet.next()) {
                 // Update the selected section based on the retrieved section values
                 if (resultSet.getBoolean("A1")) {
                     classSections.add("A1");
                     if (selectedStudentClass == null ) {
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
     
     @FXML
     private void handleStudentSection() {
         String selectedStudentSection = SectionRecord_Download.getValue();
         if (selectedStudentSection == null) {
             return;
         }
         // Add the logic to handle the selected section here
         try {
             
         } catch (Exception e) {
             e.printStackTrace();
             // Handle any exceptions that may occur during section selection handling
         }
     }
 
      private void showSectionsForClass(String className, String academicYear) throws SQLException {
         String query = "SELECT A1, A2, B1, B2, Arts, Science, Commercial, C " +
                        "FROM class WHERE class_name = ? AND academic_year = ?";
         Connection connection = null;
         PreparedStatement preparedStatement = null;
         ResultSet resultSet = null;
         String selectedSection = null; // Initialize selectedSection to null
         ObservableList<String> classSections = FXCollections.observableArrayList();
     
         try {
             connection = Database.connectDb();
             preparedStatement = connection.prepareStatement(query);
             preparedStatement.setString(1, className);
             preparedStatement.setString(2, academicYear); 
             resultSet = preparedStatement.executeQuery();
     
             // Clear any previous items in the ComboBox
             addStudent_section.getItems().clear();
     
             while (resultSet.next()) {
                 // Update the selected section based on the retrieved section values
                 if (resultSet.getBoolean("A1")) {
                     classSections.add("A1");
                     if (selectedSection == null ) {
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
     
     private void showSectionsForMarksheet(String className, String academicYear) throws SQLException {
         String query = "SELECT A1, A2, B1, B2, Arts, Science, Commercial, C " +
                        "FROM class WHERE class_name = ? AND academic_year = ?";
         Connection connection = null;
         PreparedStatement preparedStatement = null;
         ResultSet resultSet = null;
         String selectedClassMarksheet = null; // Initialize selectedSection to null
         ObservableList<String> classSections = FXCollections.observableArrayList();
     
         try {
             connection = Database.connectDb();
             preparedStatement = connection.prepareStatement(query);
             preparedStatement.setString(1, className);
             preparedStatement.setString(2, academicYear); 
             resultSet = preparedStatement.executeQuery();
     
             // Clear any previous items in the ComboBox
            
             marksheet_section.getItems().clear();
     
             while (resultSet.next()) {
                 // Update the selected section based on the retrieved section values
                 if (resultSet.getBoolean("A1")) {
                     classSections.add("A1");
                     if (selectedClassMarksheet == null ) {
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
         if (selectedClassMarksheet == null ) {
             return;
         }
         // Add the logic to handle the selected section here
         try {
             
         } catch (Exception e) {
             e.printStackTrace();
             // Handle any exceptions that may occur during section selection handling
         }
     }
    
 
 
     
 // //    NOW WE NEED THE COURSE, SO LETS WORK NOW THE AVAILABLE COURSE FORM : ) 
 // //    LETS WORK FIRST THE ADD STUDENTS FORM : ) 
 public ObservableList<studentData> addStudentsListData() {
     ObservableList<studentData> listStudents = FXCollections.observableArrayList();
     String academicYear = getAcademicYearFromSettings(); // Replace this with your implementation
 
     String sql = "SELECT * FROM student WHERE academic_year = ?";
 
     connect = Database.connectDb();
 
     try {
         studentData studentD;
         prepare = connect.prepareStatement(sql);
         prepare.setString(1, academicYear); // Set the academic year as a parameter in the query
         result = prepare.executeQuery();
 
         while (result.next()) {
             studentD = new studentData(
                 result.getInt("id"),
                 result.getString("name"),
                 result.getString("contact"),
                 result.getString("gender"),
                 result.getDate("date_of_birth"),
                 result.getString("class_name"),
                 result.getString("section"),
                 result.getDouble("amount_owing"),
                 result.getString("status"),
                 result.getDouble("scholarship")
 
             );
 
             listStudents.add(studentD);
         }
 
     } catch (Exception e) {
         e.printStackTrace();
     }
     return listStudents;
 }
 
 // ... (rest of the code remains unchanged)
 
 
     private ObservableList<studentData> addStudentsListD;
 
     public void addStudentsShowListData() {
         addStudentsListD = addStudentsListData();
 
         addStudents_col_studentNum.setCellValueFactory(new PropertyValueFactory<>("id"));
         // showClass_col_A2.setCellValueFactory(new PropertyValueFactory<>("class_name"));
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
 
     
 
 
     private int selectedStudentId = -1;
     private String selectedStudentName = "";
 
 
    
 
     public void addStudentsSelect() {
 
         studentData studentD = addStudents_tableView.getSelectionModel().getSelectedItem();
         int num = addStudents_tableView.getSelectionModel().getSelectedIndex();
 
         if ((num - 1) < -1) {
             return;
         }
       
         personal_form.setVisible(true);
 
         Double scholarshipValue = studentD.getScholarship();
         if (scholarshipValue != null) {
             schorlaship.setText(String.valueOf(scholarshipValue));
         } else {
             schorlaship.setText("N/A"); // Set a default value when the scholarship value is null
         }
         update_name.setText(studentD.getName());
         id.setText(String.valueOf(studentD.getId()));
         studentLabel.setText(studentD.getName());
         // id.setText(studentD.getId());
         std_gender.setValue(studentD.getGender());
         dob.setValue(LocalDate.parse(String.valueOf(studentD.getDate_of_birth())));
 
         selectedStudentId = studentD.getId();
         selectedStudentName = studentD.getName();
 
 
     }
 
     private int selectedTeacherId = -1;
     private String selectedTeacherName = "";
 
     public void teacherSelect() {
 
         teacherData teacherD = teachers_tableView.getSelectionModel().getSelectedItem();
         int num = teachers_tableView.getSelectionModel().getSelectedIndex();
 
         if ((num - 1) < -1) {
             return;
         }
       
         updateTeacher_form.setVisible(true);
 
         // Double scholarshipValue = studentD.getScholarship();
         // if (scholarshipValue != null) {
         //     schorlaship.setText(String.valueOf(scholarshipValue));
         // } else {
         //     schorlaship.setText("N/A"); // Set a default value when the scholarship value is null
         // }
         teacherName.setText(teacherD.getName());
         updateteacher_name.setText(teacherD.getName());
         updateteacher_subjects.setText(teacherD.getSubject());
         updateteacher_salary.setText(String.valueOf(teacherD.getSalary()));
         updateteacher_period.setText(String.valueOf(teacherD.getPeriod()));
         updateteacher_hours.setText(String.valueOf(teacherD.getHours()));
         updateteacher_tel.setText(String.valueOf(teacherD.getContact()));
         updateteacher_natId.setText(String.valueOf(teacherD.getNatId()));
         updateteacher_origin.setText(teacherD.getOrigin());
         // updateteacher_salary.setText(teacherD.getName());
         // id.setText(String.valueOf(teacherD.getId()));
         // studentLabel.setText(teacherD.getName());
         teacherId.setText(String.valueOf(teacherD.getId()));
         updateteacher_category.setValue(teacherD.getCategory());
         // dob.setValue(LocalDate.parse(String.valueOf(teacherD.getDate_of_birth())));
 
         selectedTeacherId = teacherD.getId();
         selectedTeacherName = teacherD.getName();
 
 
     }
 
     public void Admins(ActionEvent event) {
         // Get the connection to the database
         connect = Database.connectDb();
     
         try {
             String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
             
             // Create a FileChooser to allow the user to select a directory
             FileChooser fileChooser = new FileChooser();
             fileChooser.setTitle("Select Directory for Download");
     
             // Set initial directory (optional)
             fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
     
             // Set the suggested file name for the Save As dialog (optional)
             String suggestedFileName = "Admins_Report_" + currentDate + ".pdf";
             FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF Files (*.pdf)", "*.pdf");
             fileChooser.getExtensionFilters().add(extFilter);
             fileChooser.setInitialFileName(suggestedFileName);
     
             // Show the Save As dialog and get the selected file
             javafx.stage.Window window = ((Node) event.getSource()).getScene().getWindow();
             File selectedFile = fileChooser.showSaveDialog(window);
             String filePath = selectedFile.getAbsolutePath();
     
             try (PdfDocument pdf = new PdfDocument(new PdfWriter(filePath))) {
                 Document document = new Document(pdf);
              
                 // PageSize landscape = PageSize.A4;
                 // Document document = new Document(pdf);
     
                 // Add School Name and Date at the top of the page
                 PdfFont boldFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
                 PdfFont blueFont = PdfFontFactory.createFont(FontConstants.HELVETICA);
     
                 // Create a Div element for center alignment
                 Div headerDiv = new Div()
                         .setTextAlignment(TextAlignment.CENTER)
                         .setVerticalAlignment(VerticalAlignment.MIDDLE);
     
                 DecimalFormat currencyFormat = new DecimalFormat("#,##0.00");
                 String[] schoolInfo = getSchoolInfoFromSettings();
                 String schoolName = schoolInfo[0];
                 String Princi = schoolInfo[2];
                 String address = schoolInfo[3];
     
                 String academicYear = getAcademicYearFromSettings();
                 Paragraph schoolNameParagraph = new Paragraph(schoolName)
                         .setFont(boldFont)
                         .setFontSize(14);
     
                 Paragraph date = new Paragraph("Academic Year: " + academicYear)
                         .setFont(blueFont)
                         .setFontSize(12);
     
                 Paragraph printed = new Paragraph("Printed Date: " + currentDate)
                         .setFont(blueFont)
                         .setFontSize(12);
     
                 Paragraph Address = new Paragraph("Address: " + address)
                         .setFont(blueFont)
                         .setFontSize(12);
     
                 headerDiv.add(schoolNameParagraph);
                 document.add(date);
                 document.add(Address);
                 document.add(printed);
 
                 Image watermarkImage = new Image(ImageDataFactory.create("C:/Users/USER/Documents/Cohas Bepanda/Cohas Bepanda/src/pics/logo.png"));
                 ((com.itextpdf.layout.element.Image) watermarkImage).scaleToFit(50,50);
                 watermarkImage.setHorizontalAlignment(HorizontalAlignment.CENTER);
                 document.add(watermarkImage);
                 document.add(headerDiv);
                 // Add title
                 
     
                 // Database query to fetch administrators' information
                 String selectData = "SELECT Name, Age, Work_Load, Work_Period, Subject, Salary FROM teachers WHERE category = 'Administrator'";
                 try (PreparedStatement prepare = connect.prepareStatement(selectData)) {
                     try (ResultSet resultSet = prepare.executeQuery()) {
                         // Create a table to hold the administrator details
                         float[] columnWidths = { 150f, 50f, 80f, 80f, 150f, 80f, 100f }; // Adjust column widths as needed
                         Table adminTable = new Table(columnWidths).useAllAvailableWidth();
     
                         // Add table headers with bold font
                         PdfFont headingFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
                         adminTable.addHeaderCell(new Cell().add(new Paragraph("Name").setFont(headingFont)));
                         adminTable.addHeaderCell(new Cell().add(new Paragraph("Age").setFont(headingFont)));
                         adminTable.addHeaderCell(new Cell().add(new Paragraph("Load (hrs)").setFont(headingFont)));
                         adminTable.addHeaderCell(new Cell().add(new Paragraph("Period (mths)").setFont(headingFont)));
                         adminTable.addHeaderCell(new Cell().add(new Paragraph("Subject").setFont(headingFont)));
                         adminTable.addHeaderCell(new Cell().add(new Paragraph("Salary").setFont(headingFont)));
                         adminTable.addHeaderCell(new Cell().add(new Paragraph("Annually").setFont(headingFont)));
     
                         // Initialize a variable to calculate the sum of the annual salaries
                         double totalAnnualSalary = 0.0;
                         int adminCount = 0;
     
                         // Iterate through the administrators and add their details to the table
                         while (resultSet.next()) {
                             String name = resultSet.getString("Name");
                             int age = resultSet.getInt("Age");
                             double workLoad = resultSet.getDouble("Work_Load");
                             double workPeriod = resultSet.getDouble("Work_Period");
                             String subject = resultSet.getString("Subject");
                             double salary = resultSet.getDouble("Salary");
                             double annualSalary = workPeriod * salary;
                             
                             // Add details to the table
                             adminTable.addCell(name);
                             adminTable.addCell(String.valueOf(age));
                             adminTable.addCell(String.valueOf(workLoad));
                             adminTable.addCell(String.valueOf(workPeriod));
                             adminTable.addCell(subject);
                             adminTable.addCell(String.valueOf(currencyFormat.format(salary)));
                             adminTable.addCell(String.valueOf(currencyFormat.format(annualSalary)));
     
                             // Update the total annual salary
                             totalAnnualSalary += annualSalary;
                             adminCount++;
                         }
                         
                         Paragraph title = new Paragraph("Administrator Report" + "   |   Total: " + adminCount)
                         .setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD))
                         .setFontSize(16)
                         .setTextAlignment(TextAlignment.CENTER);
                 document.add(title);
                         // Add the table to the document
                         document.add(adminTable);
     
                         // Add the total annual salary as a footer
                         Paragraph totalAnnualSalaryParagraph = new Paragraph("Total Annual Salary: " + currencyFormat.format(totalAnnualSalary))
                                 .setFont(headingFont)
                                 .setFontSize(12)
                                 .setMarginTop(10f)
                                 .setHorizontalAlignment(HorizontalAlignment.RIGHT);
                         document.add(totalAnnualSalaryParagraph);
     
                         // ... Add other sections and details ...
                     }
                 } catch (SQLException e) {
                     e.printStackTrace();
                     return;
                 }
     
                 document.close();
                 Alert alert = new Alert(AlertType.INFORMATION);
                 alert.setTitle("Information Message");
                 alert.setHeaderText(null);
                 alert.setContentText("Staff Report PDF file downloaded successfully!");
                 alert.showAndWait();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
 
     public void Staff(ActionEvent event) {
         // Get the connection to the database
         connect = Database.connectDb();
     
         try {
             String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
             
             // Create a FileChooser to allow the user to select a directory
             FileChooser fileChooser = new FileChooser();
             fileChooser.setTitle("Select Directory for Download");
     
             // Set initial directory (optional)
             fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
     
             // Set the suggested file name for the Save As dialog (optional)
             String suggestedFileName = "Teachers_Report_" + currentDate + ".pdf";
             FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF Files (*.pdf)", "*.pdf");
             fileChooser.getExtensionFilters().add(extFilter);
             fileChooser.setInitialFileName(suggestedFileName);
     
             // Show the Save As dialog and get the selected file
             javafx.stage.Window window = ((Node) event.getSource()).getScene().getWindow();
             File selectedFile = fileChooser.showSaveDialog(window);
             String filePath = selectedFile.getAbsolutePath();
     
             try (PdfDocument pdf = new PdfDocument(new PdfWriter(filePath))) {
                 Document document = new Document(pdf);
              
                 // PageSize landscape = PageSize.A4;
                 // Document document = new Document(pdf);
     
                 // Add School Name and Date at the top of the page
                 PdfFont boldFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
                 PdfFont blueFont = PdfFontFactory.createFont(FontConstants.HELVETICA);
     
                 // Create a Div element for center alignment
                 Div headerDiv = new Div()
                         .setTextAlignment(TextAlignment.CENTER)
                         .setVerticalAlignment(VerticalAlignment.MIDDLE);
     
                 DecimalFormat currencyFormat = new DecimalFormat("#,##0.00");
                 String[] schoolInfo = getSchoolInfoFromSettings();
                 String schoolName = schoolInfo[0];
                 String Princi = schoolInfo[2];
                 String address = schoolInfo[3];
     
                 String academicYear = getAcademicYearFromSettings();
                 Paragraph schoolNameParagraph = new Paragraph(schoolName)
                         .setFont(boldFont)
                         .setFontSize(14);
     
                 Paragraph date = new Paragraph("Academic Year: " + academicYear)
                         .setFont(blueFont)
                         .setFontSize(12);
     
                 Paragraph printed = new Paragraph("Printed Date: " + currentDate)
                         .setFont(blueFont)
                         .setFontSize(12);
     
                 Paragraph Address = new Paragraph("Address: " + address)
                         .setFont(blueFont)
                         .setFontSize(12);
     
                 headerDiv.add(schoolNameParagraph);
                 document.add(date);
                 document.add(Address);
                 document.add(printed);
 
                 Image watermarkImage = new Image(ImageDataFactory.create("C:/Users/USER/Documents/Cohas Bepanda/Cohas Bepanda/src/pics/logo.png"));
                 ((com.itextpdf.layout.element.Image) watermarkImage).scaleToFit(50,50);
                 watermarkImage.setHorizontalAlignment(HorizontalAlignment.CENTER);
                 document.add(watermarkImage);
                 document.add(headerDiv);
                 
     
                 // Database query to fetch administrators' information
                 String selectData = "SELECT Name, Age, Work_Load, Work_Period, Subject, Salary FROM teachers WHERE category = 'Staff'";
                 try (PreparedStatement prepare = connect.prepareStatement(selectData)) {
                     try (ResultSet resultSet = prepare.executeQuery()) {
                         // Create a table to hold the administrator details
                         float[] columnWidths = { 150f, 50f, 80f, 80f, 150f, 80f, 100f }; // Adjust column widths as needed
                         Table adminTable = new Table(columnWidths).useAllAvailableWidth();
     
                         // Add table headers with bold font
                         PdfFont headingFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
                         adminTable.addHeaderCell(new Cell().add(new Paragraph("Name").setFont(headingFont)));
                         adminTable.addHeaderCell(new Cell().add(new Paragraph("Age").setFont(headingFont)));
                         adminTable.addHeaderCell(new Cell().add(new Paragraph("Load (hrs)").setFont(headingFont)));
                         adminTable.addHeaderCell(new Cell().add(new Paragraph("Period (mnths)").setFont(headingFont)));
                         adminTable.addHeaderCell(new Cell().add(new Paragraph("Subject").setFont(headingFont)));
                         adminTable.addHeaderCell(new Cell().add(new Paragraph("Salary").setFont(headingFont)));
                         adminTable.addHeaderCell(new Cell().add(new Paragraph("Annually").setFont(headingFont)));
     
                         // Initialize a variable to calculate the sum of the annual salaries
                         double totalAnnualSalary = 0.0;
                         int teacherCount = 0;
     
                         // Iterate through the administrators and add their details to the table
                         while (resultSet.next()) {
                             String name = resultSet.getString("Name");
                             int age = resultSet.getInt("Age");
                             double workLoad = resultSet.getDouble("Work_Load");
                             double workPeriod = resultSet.getDouble("Work_Period");
                             String subject = resultSet.getString("Subject");
                             double salary = resultSet.getDouble("Salary");
                             double annualSalary = workPeriod * salary;
                             
                             // Add details to the table
                             adminTable.addCell(name);
                             adminTable.addCell(String.valueOf(age));
                             adminTable.addCell(String.valueOf(workLoad));
                             adminTable.addCell(String.valueOf(workPeriod));
                             adminTable.addCell(subject);
                             adminTable.addCell(String.valueOf(currencyFormat.format(salary)));
                             adminTable.addCell(String.valueOf(currencyFormat.format(annualSalary)));
     
                             // Update the total annual salary
                             totalAnnualSalary += annualSalary;
                             teacherCount++;
                         }
 
                         // Add title
                 Paragraph title = new Paragraph("Staff Report" + "   |   Total: " + teacherCount)
                         .setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD))
                         .setFontSize(16)
                         .setTextAlignment(TextAlignment.CENTER);
                 document.add(title);
                         // Add the table to the document
                         document.add(adminTable);
     
                         // Add the total annual salary as a footer
                         Paragraph totalAnnualSalaryParagraph = new Paragraph("Total Annual Salary: " + currencyFormat.format(totalAnnualSalary))
                                 .setFont(headingFont)
                                 .setFontSize(12)
                                 .setMarginTop(10f)
                                 .setHorizontalAlignment(HorizontalAlignment.RIGHT);
                         document.add(totalAnnualSalaryParagraph);
     
                         // ... Add other sections and details ...
                     }
                 } catch (SQLException e) {
                     e.printStackTrace();
                     return;
                 }
     
                 document.close();
                 Alert alert = new Alert(AlertType.INFORMATION);
                 alert.setTitle("Information Message");
                 alert.setHeaderText(null);
                 alert.setContentText("Administrator Report PDF file downloaded successfully!");
                 alert.showAndWait();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
 
     public void allTeachers(ActionEvent event) {
         // Get the connection to the database
         connect = Database.connectDb();
     
         try {
             String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
             
             // Create a FileChooser to allow the user to select a directory
             FileChooser fileChooser = new FileChooser();
             fileChooser.setTitle("Select Directory for Download");
     
             // Set initial directory (optional)
             fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
     
             // Set the suggested file name for the Save As dialog (optional)
             String suggestedFileName = "Gen_Teachers_Report_" + currentDate + ".pdf";
             FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF Files (*.pdf)", "*.pdf");
             fileChooser.getExtensionFilters().add(extFilter);
             fileChooser.setInitialFileName(suggestedFileName);
     
             // Show the Save As dialog and get the selected file
             javafx.stage.Window window = ((Node) event.getSource()).getScene().getWindow();
             File selectedFile = fileChooser.showSaveDialog(window);
             String filePath = selectedFile.getAbsolutePath();
     
             try (PdfDocument pdf = new PdfDocument(new PdfWriter(filePath))) {
                 // Document document = new Document(pdf);
                 PageSize landscape = PageSize.A4.rotate();
                 Document document = new Document(pdf, landscape);
     
              
                 // PageSize landscape = PageSize.A4;
                 // Document document = new Document(pdf);
     
                 // Add School Name and Date at the top of the page
                 PdfFont boldFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
                 PdfFont blueFont = PdfFontFactory.createFont(FontConstants.HELVETICA);
     
                 // Create a Div element for center alignment
                 Div headerDiv = new Div()
                         .setTextAlignment(TextAlignment.CENTER)
                         .setVerticalAlignment(VerticalAlignment.MIDDLE);
     
                 DecimalFormat currencyFormat = new DecimalFormat("#,##0.00");
                 String[] schoolInfo = getSchoolInfoFromSettings();
                 String schoolName = schoolInfo[0];
                 String Princi = schoolInfo[2];
                 String address = schoolInfo[3];
     
                 String academicYear = getAcademicYearFromSettings();
                 Paragraph schoolNameParagraph = new Paragraph(schoolName)
                         .setFont(boldFont)
                         .setFontSize(14);
     
                 Paragraph date = new Paragraph("Academic Year: " + academicYear)
                         .setFont(blueFont)
                         .setFontSize(12);
     
                 Paragraph printed = new Paragraph("Printed Date: " + currentDate)
                         .setFont(blueFont)
                         .setFontSize(12);
     
                 Paragraph Address = new Paragraph("Address: " + address)
                         .setFont(blueFont)
                         .setFontSize(12);
     
                 headerDiv.add(schoolNameParagraph);
                 document.add(date);
                 document.add(Address);
                 document.add(printed);
 
                 Image watermarkImage = new Image(ImageDataFactory.create("C:/Users/USER/Documents/Cohas Bepanda/Cohas Bepanda/src/pics/logo.png"));
                 ((com.itextpdf.layout.element.Image) watermarkImage).scaleToFit(50,50);
                 watermarkImage.setHorizontalAlignment(HorizontalAlignment.CENTER);
                 document.add(watermarkImage);
                 document.add(headerDiv);
                                         // Add title
                     
     
                 // Database query to fetch administrators' information
                 String selectData = "SELECT Name, Age, Work_Load, Work_Period, Subject, Salary, phone_number FROM teachers";
                 try (PreparedStatement prepare = connect.prepareStatement(selectData)) {
                     try (ResultSet resultSet = prepare.executeQuery()) {
                         // Create a table to hold the administrator details
                         float[] columnWidths = { 150f, 50f, 100f, 80f, 80f, 150f, 80f, 100f }; // Adjust column widths as needed
                         Table adminTable = new Table(columnWidths).useAllAvailableWidth();
     
                         // Add table headers with bold font
                         PdfFont headingFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
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
                         int staffCount = 0;
     
                         // Iterate through the administrators and add their details to the table
                         while (resultSet.next()) {
                             String name = resultSet.getString("Name");
                             int age = resultSet.getInt("Age");
                             int tel = resultSet.getInt("phone_number");
                             double workLoad = resultSet.getDouble("Work_Load");
                             double workPeriod = resultSet.getDouble("Work_Period");
                             String subject = resultSet.getString("Subject");
                             double salary = resultSet.getDouble("Salary");
                             double annualSalary = workPeriod * salary;
                             
                             // Add details to the table
                             adminTable.addCell(name);
                             adminTable.addCell(String.valueOf(age));
                             adminTable.addCell(String.valueOf(tel));
                             adminTable.addCell(String.valueOf(workLoad));
                             adminTable.addCell(String.valueOf(workPeriod));
                             adminTable.addCell(subject);
                             adminTable.addCell(String.valueOf(currencyFormat.format(salary)));
                             adminTable.addCell(String.valueOf(currencyFormat.format(annualSalary)));
     
                             // Update the total annual salary
                             totalAnnualSalary += annualSalary;
                             staffCount++;
                         }
 
                         Paragraph title = new Paragraph("General Staff Report" + "    |   Total: " + staffCount)
                         .setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD))
                         .setFontSize(16)
                         .setTextAlignment(TextAlignment.CENTER);
                 document.add(title);
                 
                         // Add the table to the document
                         document.add(adminTable);
     
                         // Add the total annual salary as a footer
                         Paragraph totalAnnualSalaryParagraph = new Paragraph("Total Annual Salary: " + currencyFormat.format(totalAnnualSalary))
                                 .setFont(headingFont)
                                 .setFontSize(12)
                                 .setMarginTop(10f)
                                 .setHorizontalAlignment(HorizontalAlignment.RIGHT);
                         document.add(totalAnnualSalaryParagraph);
     
                         // ... Add other sections and details ...
                     }
                 } catch (SQLException e) {
                     e.printStackTrace();
                     return;
                 }
     
                 document.close();
                 Alert alert = new Alert(AlertType.INFORMATION);
                 alert.setTitle("Information Message");
                 alert.setHeaderText(null);
                 alert.setContentText("Staff List Report PDF file downloaded successfully!");
                 alert.showAndWait();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
 
 //     public void availableCourseAdd() {
 
 //         String insertData = "INSERT INTO course (course,description,degree) VALUES(?,?,?)";
 
 //         connect = Database.connectDb();
 
 //         try {
 //             Alert alert;
 
 //             if (availableCourse_course.getText().isEmpty()
 //                     || availableCourse_description.getText().isEmpty()
 //                     || availableCourse_degree.getText().isEmpty()) {
 //                 alert = new Alert(AlertType.ERROR);
 //                 alert.setTitle("Error Message");
 //                 alert.setHeaderText(null);
 //                 alert.setContentText("Please fill all blank fields");
 //                 alert.showAndWait();
 //             } else {
 // //            CHECK IF THE COURSE YOU WANT TO INSERT IS ALREADY EXIST!
 //                 String checkData = "SELECT course FROM course WHERE course = '"
 //                         + availableCourse_course.getText() + "'";
 
 //                 statement = connect.createStatement();
 //                 result = statement.executeQuery(checkData);
 
 //                 if (result.next()) {
 //                     alert = new Alert(AlertType.ERROR);
 //                     alert.setTitle("Error Message");
 //                     alert.setHeaderText(null);
 //                     alert.setContentText("Course: " + availableCourse_course.getText() + " was already exist!");
 //                     alert.showAndWait();
 //                 } else {
 //                     prepare = connect.prepareStatement(insertData);
 //                     prepare.setString(1, availableCourse_course.getText());
 //                     prepare.setString(2, availableCourse_description.getText());
 //                     prepare.setString(3, availableCourse_degree.getText());
 
 //                     prepare.executeUpdate();
 
 //                     alert = new Alert(AlertType.INFORMATION);
 //                     alert.setTitle("Information Message");
 //                     alert.setHeaderText(null);
 //                     alert.setContentText("Successfully Added!");
 //                     alert.showAndWait();
 
 //                     // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
 //                     // availableCourseShowListData();
 //                     // TO CLEAR THE TEXT FIELDS
 //                     availableCourseClear();
 
 //                 }
 //             }
 //         } catch (Exception e) {
 //             e.printStackTrace();
 //         }
 //     }
 
 //     public void availableCourseUpdate() {
 
 //         String updateData = "UPDATE course SET description = '"
 //                 + availableCourse_description.getText() + "', degree = '"
 //                 + availableCourse_degree.getText() + "' WHERE course = '"
 //                 + availableCourse_course.getText() + "'";
 
 //         connect = Database.connectDb();
 
 //         try {
 //             Alert alert;
 
 //             if (availableCourse_course.getText().isEmpty()
 //                     || availableCourse_description.getText().isEmpty()
 //                     || availableCourse_degree.getText().isEmpty()) {
 //                 alert = new Alert(AlertType.ERROR);
 //                 alert.setTitle("Error Message");
 //                 alert.setHeaderText(null);
 //                 alert.setContentText("Please fill all blank fields");
 //                 alert.showAndWait();
 //             } else {
 
 //                 alert = new Alert(AlertType.CONFIRMATION);
 //                 alert.setTitle("Confirmation Message");
 //                 alert.setHeaderText(null);
 //                 alert.setContentText("Are you sure you want to UPDATE Course: " + availableCourse_course.getText() + "?");
 //                 Optional<ButtonType> option = alert.showAndWait();
 
 //                 if (option.get().equals(ButtonType.OK)) {
 //                     statement = connect.createStatement();
 //                     statement.executeUpdate(updateData);
 
 //                     alert = new Alert(AlertType.INFORMATION);
 //                     alert.setTitle("Information Message");
 //                     alert.setHeaderText(null);
 //                     alert.setContentText("Successfully Updated!");
 //                     alert.showAndWait();
 
 //                     // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
 //                     // availableCourseShowListData();
 //                     // TO CLEAR THE TEXT FIELDS
 //                     availableCourseClear();
 
 //                 } else {
 //                     return;
 //                 }
 
 //             }
 
 //         } catch (Exception e) {
 //             e.printStackTrace();
 //         }
 
 //     }
 
 //     public void availableCourseDelete() {
 
 //         String deleteData = "DELETE FROM course WHERE course = '"
 //                 + availableCourse_course.getText() + "'";
 
 //         connect = Database.connectDb();
 
 //         try {
 //             Alert alert;
 
 //             if (availableCourse_course.getText().isEmpty()
 //                     || availableCourse_description.getText().isEmpty()
 //                     || availableCourse_degree.getText().isEmpty()) {
 //                 alert = new Alert(AlertType.ERROR);
 //                 alert.setTitle("Error Message");
 //                 alert.setHeaderText(null);
 //                 alert.setContentText("Please fill all blank fields");
 //                 alert.showAndWait();
 //             } else {
 // //                ALL GOOD GUYS! NOW LETS PROCEED TO ADD STUDENTS FORM
 //                 alert = new Alert(AlertType.CONFIRMATION);
 //                 alert.setTitle("Confirmation Message");
 //                 alert.setHeaderText(null);
 //                 alert.setContentText("Are you sure you want to DELETE Course: " + availableCourse_course.getText() + "?");
 //                 Optional<ButtonType> option = alert.showAndWait();
 
 //                 if (option.get().equals(ButtonType.OK)) {
 //                     statement = connect.createStatement();
 //                     statement.executeUpdate(deleteData);
 
 //                     alert = new Alert(AlertType.INFORMATION);
 //                     alert.setTitle("Information Message");
 //                     alert.setHeaderText(null);
 //                     alert.setContentText("Successfully Deleted!");
 //                     alert.showAndWait();
 
 //                     // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
 //                     // availableCourseShowListData();
 //                     // TO CLEAR THE TEXT FIELDS
 //                     availableCourseClear();
 
 //                 } else {
 //                     return;
 //                 }
 //             }
 
 //         } catch (Exception e) {
 //             e.printStackTrace();
 //         }
 
 //     }
 
 //     public void availableCourseClear() {
 //         availableCourse_course.setText("");
 //         availableCourse_description.setText("");
 //         availableCourse_degree.setText("");
 //     }
 
 //     public ObservableList<courseData> availableCourseListData() {
 
 //         ObservableList<courseData> listData = FXCollections.observableArrayList();
 
 //         String sql = "SELECT * FROM course";
 
 //         connect = Database.connectDb();
 
 //         try {
 //             courseData courseD;
 //             prepare = connect.prepareStatement(sql);
 //             result = prepare.executeQuery();
 
 //             while (result.next()) {
 //                 courseD = new courseData(result.getString("course"),
 //                         result.getString("description"),
 //                         result.getString("degree"));
 
 //                 listData.add(courseD);
 //             }
 
 //         } catch (Exception e) {
 //             e.printStackTrace();
 //         }
 //         return listData;
 //     }
 
 //     private ObservableList<courseData> availableCourseList;
 
 //     public void availableCourseShowListData() {
 //         availableCourseList = availableCourseListData();
 
 //         availableCourse_col_course.setCellValueFactory(new PropertyValueFactory<>("course"));
 //         availableCourse_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
 //         availableCourse_col_degree.setCellValueFactory(new PropertyValueFactory<>("degree"));
 
 //         availableCourse_tableView.setItems(availableCourseList);
 
 //     }
 
 //     public void availableCourseSelect() {
 //         courseData courseD = availableCourse_tableView.getSelectionModel().getSelectedItem();
 //         int num = availableCourse_tableView.getSelectionModel().getSelectedIndex();
 
 //         if ((num - 1) < -1) {
 //             return;
 //         }
 
 //         availableCourse_course.setText(courseD.getCourse());
 //         availableCourse_description.setText(courseD.getDescription());
 //         availableCourse_degree.setText(courseD.getDegree());
 
 //     }
 
 //     public void studentGradesUpdate() {
 //         double finalCheck1 = 0;
 //         double finalCheck2 = 0;
 
 //         String checkData = "SELECT * FROM student_grade WHERE studentNum = '"
 //                 + studentGrade_studentNum.getText() + "'";
 
 //         connect = Database.connectDb();
 
 //         double finalResult = 0;
 
 //         try {
 
 //             prepare = connect.prepareStatement(checkData);
 //             result = prepare.executeQuery();
 
 //             if (result.next()) {
 //                 finalCheck1 = result.getDouble("first_sem");
 //                 finalCheck2 = result.getDouble("second_sem");
 //             }
 
 //             if (finalCheck1 == 0 || finalCheck2 == 0) {
 //                 finalResult = 0;
 //             } else { //LIKE (X+Y)/2 AVE WE NEED TO FIND FOR FINALS
 //                 finalResult = (Double.parseDouble(studentGrade_firstSem.getText())
 //                         + Double.parseDouble(studentGrade_secondSem.getText()) / 2);
 //             }
 
 //             String updateData = "UPDATE student_grade SET "
 //                     + " year = '" + studentGrade_year.getText()
 //                     + "', course = '" + studentGrade_course.getText()
 //                     + "', first_sem = '" + studentGrade_firstSem.getText()
 //                     + "', second_sem = '" + studentGrade_secondSem.getText()
 //                     + "', final = '" + finalResult + "' WHERE studentNum = '"
 //                     + studentGrade_studentNum.getText() + "'";
 
 //             Alert alert;
 
 //             if (studentGrade_studentNum.getText().isEmpty()
 //                     || studentGrade_year.getText().isEmpty()
 //                     || studentGrade_course.getText().isEmpty()) {
 //                 alert = new Alert(AlertType.ERROR);
 //                 alert.setTitle("Error Message");
 //                 alert.setHeaderText(null);
 //                 alert.setContentText("Please fill all blank fields");
 //                 alert.showAndWait();
 
 //             } else {
 
 //                 alert = new Alert(AlertType.CONFIRMATION);
 //                 alert.setTitle("Confirmation Message");
 //                 alert.setHeaderText(null);
 //                 alert.setContentText("Are you sure you want to UPDATE Student #" + studentGrade_studentNum.getText() + "?");
 //                 Optional<ButtonType> option = alert.showAndWait();
 
 //                 if (option.get().equals(ButtonType.OK)) {
 //                     statement = connect.createStatement();
 //                     statement.executeUpdate(updateData);
 
 //                     alert = new Alert(AlertType.INFORMATION);
 //                     alert.setTitle("Information Message");
 //                     alert.setHeaderText(null);
 //                     alert.setContentText("Successfully Updated!");
 //                     alert.showAndWait();
 
 //                     // TO UPDATE THE TABLEVIEW
 //                     studentGradesShowListData();
 //                 } else {
 //                     return;
 //                 }
 
 //             }// NOT WE ARE CLOSER TO THE ENDING PART  :) LETS PROCEED TO DASHBOARD FORM 
 //         } catch (Exception e) {
 //             e.printStackTrace();
 //         }
 //     }
 
 //     public void studentGradesClear() {
 //         studentGrade_studentNum.setText("");
 //         studentGrade_year.setText("");
 //         studentGrade_course.setText("");
 //         studentGrade_firstSem.setText("");
 //         studentGrade_secondSem.setText("");
 //     }
 
 //     public ObservableList<studentData> studentGradesListData() {
 
 //         ObservableList<studentData> listData = FXCollections.observableArrayList();
 
 //         String sql = "SELECT * FROM student_grade";
 
 //         connect = Database.connectDb();
 
 //         try {
 //             studentData studentD;
 
 //             prepare = connect.prepareStatement(sql);
 //             result = prepare.executeQuery();
 
 //             while (result.next()) {
 //                 studentD = new studentData(result.getInt("studentNum"),
 //                          result.getString("year"),
 //                          result.getString("course"),
 //                          result.getDouble("first_sem"),
 //                          result.getDouble("second_sem"),
 //                          result.getDouble("final"));
 
 //                 listData.add(studentD);
 //             }
 //         } catch (Exception e) {
 //             e.printStackTrace();
 //         }
 //         return listData;
 //     }
 
 //     private ObservableList<studentData> studentGradesList;
 
 //     public void studentGradesShowListData() {
 //         studentGradesList = studentGradesListData();
 
 //         studentGrade_col_studentNum.setCellValueFactory(new PropertyValueFactory<>("studentNum"));
 //         studentGrade_col_year.setCellValueFactory(new PropertyValueFactory<>("year"));
 //         studentGrade_col_course.setCellValueFactory(new PropertyValueFactory<>("course"));
 //         studentGrade_col_firstSem.setCellValueFactory(new PropertyValueFactory<>("firstSem"));
 //         studentGrade_col_secondSem.setCellValueFactory(new PropertyValueFactory<>("secondSem"));
 //         studentGrade_col_final.setCellValueFactory(new PropertyValueFactory<>("finals"));
 // //        WE NEED TO FIX THE DELETE ON ADD STUDENT FORM 
 //         studentGrade_tableView.setItems(studentGradesList);
 
 //     }
 
 //     public void studentGradesSelect() {
 
 //         studentData studentD = studentGrade_tableView.getSelectionModel().getSelectedItem();
 //         int num = studentGrade_tableView.getSelectionModel().getSelectedIndex();
 
 //         if ((num - 1) < -1) {
 //             return;
 //         }
 
 //         studentGrade_studentNum.setText(String.valueOf(studentD.getStudentNum()));
 //         studentGrade_year.setText(studentD.getYear());
 //         studentGrade_course.setText(studentD.getCourse());
 //         studentGrade_firstSem.setText(String.valueOf(studentD.getFirstSem()));
 //         studentGrade_secondSem.setText(String.valueOf(studentD.getSecondSem()));
 //     }
 
 //     public void studentGradesSearch() {
 
 //         FilteredList<studentData> filter = new FilteredList<>(studentGradesList, e -> true);
 
 //         studentGrade_search.textProperty().addListener((Observable, oldValue, newValue) -> {
 
 //             filter.setPredicate(predicateStudentData -> {
 
 //                 if (newValue.isEmpty() || newValue == null) {
 //                     return true;
 //                 }
 //                 String searchKey = newValue.toLowerCase();
 
 //                 if (predicateStudentData.getStudentNum().toString().contains(searchKey)) {
 //                     return true;
 //                 } else if (predicateStudentData.getYear().toLowerCase().contains(searchKey)) {
 //                     return true;
 //                 } else if (predicateStudentData.getCourse().toLowerCase().contains(searchKey)) {
 //                     return true;
 //                 } else if (predicateStudentData.getFirstSem().toString().contains(searchKey)) {
 //                     return true;
 //                 } else if (predicateStudentData.getSecondSem().toString().contains(searchKey)) {
 //                     return true;
 //                 } else if (predicateStudentData.getFinals().toString().contains(searchKey)) {
 //                     return true;
 //                 } else {
 //                     return false;
 //                 }
 //             });
 //         });
 
 //         SortedList<studentData> sortList = new SortedList<>(filter);
 
 //         sortList.comparatorProperty().bind(studentGrade_tableView.comparatorProperty());
 //         studentGrade_tableView.setItems(sortList);
 
 //     }
 
     private double x = 0;
     private double y = 0;
 
     public void logout() {
 
         try {
                         
             
             Alert alert = new Alert(AlertType.CONFIRMATION);
             alert.setTitle("Confirmation Message");
             alert.setHeaderText(null);
             alert.setContentText("Are you sure you want to logout?");
 
             Optional<ButtonType> option = alert.showAndWait();
 
             if (option.get().equals(ButtonType.OK)) {
 
                 //HIDE YOUR DASHBOARD FORM
                 logout.getScene().getWindow().hide();
 
                 //LINK YOUR LOGIN FORM 
                 Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                 Stage stage = new Stage();
                 Scene scene = new Scene(root);
 
                 root.setOnMousePressed((MouseEvent event) -> {
                     x = event.getSceneX();
                     y = event.getSceneY();
                 });
 
                 root.setOnMouseDragged((MouseEvent event) -> {
                     stage.setX(event.getScreenX() - x);
                     stage.setY(event.getScreenY() - y);
 
                     stage.setOpacity(.8);
                 });
 
                 root.setOnMouseReleased((MouseEvent event) -> {
                     stage.setOpacity(1);
                 });
 
                 stage.initStyle(StageStyle.TRANSPARENT);
 
                 stage.setScene(scene);
                 stage.show();
 
             } else {
                 return;
             }
 
         } catch (Exception e) {
             e.printStackTrace();
         }
 
     }
 
     public void displayUsername(){
         username.setText(getData.username);
     }
 
     public void displaySchoolName(settingsData settingsData) {
         show_SchoolName.setText(settingsData.getSchoolName());
     }
     
     
 //     // THATS IT FOR THESE VIDEOS, THANKS FOR WATCHING!! SUBSCRIBE AND TURN ON NOTIFICATION 
 // //    TO NOTIF YOU FOR MORE UPCOMING VIDEOS THANKS FOR THE SUPPORT! : )
     public void defaultNav(){
         home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
     }
 
     public void addClasses(ActionEvent event) {
         class_sectionAdd_form.setVisible(true);
     }
 
     
     
     public void switchForm(ActionEvent event) {
         if (event.getSource() == home_btn) {
             home_form.setVisible(true);
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
 
         } else if (event.getSource() == addStudents_btn) {
             home_form.setVisible(false);
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
 
             try {
             // Call the method to populate the academic year ComboBox with unique values from the database
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
              
 
 
 //            TO BECOME UPDATED ONCE YOU CLICK THE ADD STUDENTS BUTTON ON NAV
             addStudentsShowListData();
             addStudentsSearch();
 
         } else if (event.getSource() == all_students_btn) {
             home_form.setVisible(false);
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
 
             getAcademicYearFromSettings();
 
 
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
 
             getAcademicYearFromSettings();
 
             manageClass_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
             home_btn.setStyle("-fx-background-color:transparent");
             all_students_btn.setStyle("-fx-background-color:transparent");
             marksheet_btn.setStyle("-fx-background-color:transparent");
             teacher_btn.setStyle("-fx-background-color:transparent");
             addStudents_btn.setStyle("-fx-background-color:transparent");
             setting_btn.setStyle("-fx-background-color:transparent");
             finance_btn.setStyle("-fx-background-color:transparent");
 
         }  else if (event.getSource() == setting_btn) {
             home_form.setVisible(false);
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
 
             displaySchoolName();
         displayPrincipal();
         displayAddress();
         displaySchoolYear();
 
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
             getAcademicYearFromSettings();
                         teacherSearch();
 
 
             marksheet_btn.setStyle("-fx-background-color:transparent");
             addStudents_btn.setStyle("-fx-background-color:transparent");
             all_students_btn.setStyle("-fx-background-color:transparent");
             home_btn.setStyle("-fx-background-color:transparent");
             manageClass_btn.setStyle("-fx-background-color:transparent");
             setting_btn.setStyle("-fx-background-color:transparent");
             finance_btn.setStyle("-fx-background-color:transparent");
             teacher_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
 
 
             // studentGradesShowListData();
             // studentGradesSearch();
 
         }
        
 
     }
 
     public void close() {
         System.exit(0);
     }
 
     public void maximize() {
         Stage stage = (Stage) main_form.getScene().getWindow();
         stage.setIconified(true);
     }
 
     public void minimize() {
         Stage stage = (Stage) main_form.getScene().getWindow();
         if (stage.isMaximized()) {
             stage.setMaximized(false); // Restore down
         } else {
             stage.setMaximized(true); // Maximize
         }
     }
     
     public void classSearch() {
 
 
         String selectedYear = getAcademicYearFromSettings();
     if (selectedYear == null) {
         return;
     }
         FilteredList<studentData> filter = new FilteredList<>(showClassListD, e -> true);
 
 
         class_search.textProperty().addListener((Observable, oldValue, newValue) -> {
 
             filter.setPredicate(predicateStudentData -> {
 
                 if (newValue == null || newValue.isEmpty()) {
                     return true;
                 }
 
                 String searchKey = newValue.toLowerCase();
                 if (!predicateStudentData.getAcademicYear().equals(selectedYear)) {
                     return false;
                 }
 
                 if (predicateStudentData.getClassName().toLowerCase().contains(searchKey)) {
                     return true;
                 } else if (predicateStudentData.getSchoolFees().toString().contains(searchKey)) {
                     return true;
                 } else if (predicateStudentData.getAcademicYear().toLowerCase().contains(searchKey)) {
                     return true;
                 } else if (predicateStudentData.getTotalStudents().toString().contains(searchKey)) {
                     return true;
                 } else if (predicateStudentData.getTotalExpected().toString().contains(searchKey)) {
                     return true;
                 } else if (predicateStudentData.getTotalOwing().toString().contains(searchKey)) {
                     return true;
                 } else if (predicateStudentData.getTotalPaid().toString().contains(searchKey)) {
                     return true;
                 } else if (predicateStudentData.getTotalStudentsOwing().toString().contains(searchKey)) {
                     return true;
                 // } else if (predicateStudentData.getTotalArtsStudents().toString().contains(searchKey)) {
                 //     return true;
                 // } else if (predicateStudentData.getTotalScienceStudents().toString().contains(searchKey)) {
                 //     return true;
                 // } else if (predicateStudentData.getTotalCommercialStudents().toString().contains(searchKey)) {
                 //     return true;
                 } else if (predicateStudentData.getSection().toLowerCase().contains(searchKey)) {
                     return true;
                 // } else if (predicateStudentData.getGender().toLowerCase().contains(searchKey)) {
                 //     return true;
                 // } else if (predicateStudentData.getDate_of_birth().toString().contains(searchKey)) {
                 //     return true;
                 // } else if (predicateStudentData.getStatus().toLowerCase().contains(searchKey)) {
                 //     return true;
                 } else {
                     return false;
                 }
             });
         });
 
         SortedList<studentData> sortList = new SortedList<>(filter);
 
         sortList.comparatorProperty().bind(showClass_tableView.comparatorProperty());
         showClass_tableView.setItems(sortList);
 
     }
    
     public ObservableList<studentData> showClassListData() {
     ObservableList<studentData> listClass = FXCollections.observableArrayList();
     String academicYear = getAcademicYearFromSettings(); // Replace this with your implementation
 
     String sql = "SELECT class_name, academic_year, fees, section, " +
             "COUNT(*) AS totalStudents, " +
             "SUM(CASE WHEN status = 'incomplete' THEN 1 ELSE 0 END) AS totalStudentsOwing, " +
             "SUM(fees) AS totalExpected, " +
             "SUM(amount_paid) AS totalPaid, " +
             "SUM(amount_owing) AS totalOwing " +
             "FROM student WHERE academic_year = ? GROUP BY class_id, section";
 
     connect = Database.connectDb();
 
     try {
         studentData studentF;
         prepare = connect.prepareStatement(sql);
         prepare.setString(1, academicYear); // Set the academic year as a parameter in the query
         result = prepare.executeQuery();
 
         while (result.next()) {
             studentF = new studentData(
                     result.getInt("fees"),
                     result.getString("class_name"),
                     result.getString("academic_year"),
                     result.getString("section"),
                     result.getInt("totalStudents"),
                     result.getInt("totalExpected"),
                     result.getInt("totalPaid"),
                     result.getInt("totalOwing"),
                     result.getInt("totalStudentsOwing")
                     // result.getInt("totalArtsStudents"),
                     // result.getInt("totalScienceStudents"),
                     // result.getInt("totalCommercialStudents")
             );
             // result.getDate("date_of_birth"),
             // result.getString("status"));
 
             listClass.add(studentF);
         }
 
     } catch (Exception e) {
         e.printStackTrace();
     }
     return listClass;
 }
 
 
 
     private ObservableList<studentData> showClassListD;
 
     public void showAllClassListData() {
         showClassListD = showClassListData();
 
         showClass_col_year.setCellValueFactory(new PropertyValueFactory<>("academicYear"));
         // addStudents_col_year.setCellValueFactory(new PropertyValueFactory<>("year"));
         showClass_col_name.setCellValueFactory(new PropertyValueFactory<>("className"));
         showClass_col_fees.setCellValueFactory(new PropertyValueFactory<>("schoolFees"));
         showClass_col_section.setCellValueFactory(new PropertyValueFactory<>("section"));
         showClass_col_totalStudents.setCellValueFactory(new PropertyValueFactory<>("totalStudents"));
         showClass_col_totalExpected.setCellValueFactory(new PropertyValueFactory<>("totalExpected"));
         showClass_col_totalPaid.setCellValueFactory(new PropertyValueFactory<>("totalPaid"));
         showClass_col_totalOwing.setCellValueFactory(new PropertyValueFactory<>("totalOwing"));
         showClass_col_StudentsOwing.setCellValueFactory(new PropertyValueFactory<>("totalStudentsOwing"));
         // showClass_col_arts.setCellValueFactory(new PropertyValueFactory<>("totalArtsStudents"));
         // showClass_col_science.setCellValueFactory(new PropertyValueFactory<>("totalScienceStudents"));
         // showClass_col_commercial.setCellValueFactory(new PropertyValueFactory<>("totalCommercialStudents"));
 
         showClass_tableView.setItems(showClassListD);
 
     }
     
     private String[] getSchoolInfoFromSettings() {
         String[] schoolInfo = new String[4]; // Index 0: School Name, Index 1: Logo Path
         String sqlSettings = "SELECT school_name, logo, principal, address FROM settings";
     
         try {
             Connection settingsConnection = Database.connectDb();
             PreparedStatement settingsPrepare = settingsConnection.prepareStatement(sqlSettings);
             ResultSet settingsResult = settingsPrepare.executeQuery();
     
             if (settingsResult.next()) {
                 schoolInfo[0] = settingsResult.getString("school_name");
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
     
     public boolean generateAndSavePDF(ObservableList<studentData> dataList, ActionEvent event) {
         if (dataList == null || dataList.isEmpty()) {
             System.err.println("Error: Data list is null or empty.");
             return false;
         }
     
         try {
             String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            
     
             FileChooser fileChooser = new FileChooser();
     fileChooser.setTitle("Select Directory for Download");
 
     // Set initial directory (optional)
     fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
 
     // Set the suggested file name for the Save As dialog (optional)
     String suggestedFileName = "Class_Record_"  + currentDate + ".pdf";
     FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF Files (*.pdf)", "*.pdf");
     fileChooser.getExtensionFilters().add(extFilter);
     fileChooser.setInitialFileName(suggestedFileName);
 
     // Show the Save As dialog and get the selected file
     javafx.stage.Window window = ((Node) event.getSource()).getScene().getWindow();
     File selectedFile = fileChooser.showSaveDialog(window);
     String filePath = selectedFile.getAbsolutePath();
 
     try (PdfDocument pdf = new PdfDocument(new PdfWriter(filePath))) {
                 PageSize landscape = PageSize.A4.rotate();
                 Document document = new Document(pdf, landscape);
     
                 // Add School Name and Date at the top of the page
                 PdfFont boldFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
                 PdfFont blueFont = PdfFontFactory.createFont(FontConstants.HELVETICA);
     
                 // Create a Div element for center alignment
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
                         .setFontSize(16);
     
                 Paragraph date = new Paragraph("Academic Year: " + academicYear)
                         .setFont(blueFont)
                         .setFontSize(12);
 
                 Paragraph printed = new Paragraph("Printed Date: " + currentDate)
                         .setFont(blueFont)
                         .setFontSize(12);
     
                 Paragraph Address = new Paragraph("Address: " + address)
                         .setFont(blueFont)
                         .setFontSize(12);
     
                 headerDiv.add(schoolNameParagraph);
                 document.add(date);
                 document.add(Address);
                 document.add(printed);
                 document.add(headerDiv);
 
                 Image watermarkImage = new Image(ImageDataFactory.create("C:/Users/USER/Documents/Cohas Bepanda/Cohas Bepanda/src/pics/logo.png"));
                 ((com.itextpdf.layout.element.Image) watermarkImage).scaleToFit(50,50);
                 watermarkImage.setHorizontalAlignment(HorizontalAlignment.CENTER);
                 document.add(watermarkImage);
 
                 Paragraph record = new Paragraph("General Class Record for the Academic Year: " + academicYear)
                 .setFont(blueFont)
                 .setFontSize(14);
 
                 document.add(record);
                 // Add a table to the document
                 float[] columnWidths = { 100f, 100f, 50f, 50f, 50f, 100f, 100f, 100f }; // Adjust column widths as needed
                 Table table = new Table(UnitValue.createPercentArray(columnWidths)).useAllAvailableWidth();
     
                 // Add table headers with bold font
                 PdfFont headingFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
                 DecimalFormat currencyFormat = new DecimalFormat("#,##0.00");
     
                 table.addHeaderCell(new Cell().add(new Paragraph("Class Name").setFont(headingFont)));
                 table.addHeaderCell(new Cell().add(new Paragraph("Fees").setFont(headingFont)));
                 table.addHeaderCell(new Cell().add(new Paragraph("Section").setFont(headingFont)));
                 table.addHeaderCell(new Cell().add(new Paragraph("Total Students").setFont(headingFont)));
                 table.addHeaderCell(new Cell().add(new Paragraph("Total Students Owing").setFont(headingFont)));
                 table.addHeaderCell(new Cell().add(new Paragraph("Total Expected").setFont(headingFont)));
                 table.addHeaderCell(new Cell().add(new Paragraph("Total Paid").setFont(headingFont)));
                 table.addHeaderCell(new Cell().add(new Paragraph("Total Owing").setFont(headingFont)));
     
                 // Add table rows
                 for (studentData item : dataList) {
                     table.addCell(item.getClassName());
                     table.addCell(currencyFormat.format(item.getSchoolFees()));
                     table.addCell(item.getSection());
                     table.addCell(String.valueOf(item.getTotalStudents()));
                     table.addCell(String.valueOf(item.getTotalStudentsOwing()));
                     table.addCell(currencyFormat.format(item.getTotalExpected()));
                     table.addCell(currencyFormat.format(item.getTotalPaid()));
                     table.addCell(currencyFormat.format(item.getTotalOwing()));
                 }
     
                 // Calculate the totals for the footer
                 double totalOwing = 0;
                 double totalPaid = 0;
                 double totalExpected = 0;
                 int totalStudentsOwing = 0;
                 int totalStudents = 0;
     
                 for (studentData item : dataList) {
                     totalOwing += item.getTotalOwing();
                     totalPaid += item.getTotalPaid();
                     totalExpected += item.getTotalExpected();
                     totalStudentsOwing += item.getTotalStudentsOwing();
                     totalStudents += item.getTotalStudents();
                 }
     
                 // Add table footer to show the totals
                 PdfFont footerFont = PdfFontFactory.createFont(FontConstants.HELVETICA);
                 table.addFooterCell(new Cell().add(new Paragraph("Total:").setFont(footerFont).setBold()));
                 table.addFooterCell(new Cell().add(new Paragraph("")));
                 table.addFooterCell(new Cell().add(new Paragraph(""))); // Empty cell for 'Section'
                 table.addFooterCell(new Cell().add(new Paragraph(String.valueOf(totalStudents)).setFont(footerFont).setBold()));
                 table.addFooterCell(new Cell().add(new Paragraph(String.valueOf(totalStudentsOwing)).setFont(footerFont).setBold()));
                 table.addFooterCell(new Cell().add(new Paragraph(currencyFormat.format(totalExpected)).setFont(footerFont).setBold()));
                 table.addFooterCell(new Cell().add(new Paragraph(currencyFormat.format(totalPaid)).setFont(footerFont).setBold()));
                 table.addFooterCell(new Cell().add(new Paragraph(currencyFormat.format(totalOwing)).setFont(footerFont).setBold()));
     
                 // Add the table to the document
                 document.add(table);
     
                 // Get Principal Name from principal settings table and show as signature
                 Paragraph signature = new Paragraph("Principal: " + Princi)
                         .setFont(boldFont)
                         .setFontSize(12)
                         .setMarginTop(10);
                 document.add(signature);
     
                 // Close the document after adding content
                 document.close();
     
                 Alert alert = new Alert(AlertType.INFORMATION);
                 alert.setTitle("Information Message");
                 alert.setHeaderText(null);
                 alert.setContentText("Class Record PDF file Downloaded successfully!");
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
     
     public void ClassRecord(ActionEvent event){
         generateAndSavePDF(showClassListD, event);
     }
  
 public void studentInvoice(ActionEvent event) {
     // int selectedStudentId = this.getSelectedStudentId();
     // Get the connection to the database
     connect = Database.connectDb();
     
     try {
         String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
         
 FileChooser fileChooser = new FileChooser();
     fileChooser.setTitle("Select Directory for Download");
 
     // Set initial directory (optional)
     fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
 
     // Set the suggested file name for the Save As dialog (optional)
     String suggestedFileName = "Student_Invoice_ID" + selectedStudentId + "_" + currentDate + ".pdf";
     FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF Files (*.pdf)", "*.pdf");
     fileChooser.getExtensionFilters().add(extFilter);
     fileChooser.setInitialFileName(suggestedFileName);
 
     // Show the Save As dialog and get the selected file
     javafx.stage.Window window = ((Node) event.getSource()).getScene().getWindow();
     File selectedFile = fileChooser.showSaveDialog(window);
     String filePath = selectedFile.getAbsolutePath();
 
     try (PdfDocument pdf = new PdfDocument(new PdfWriter(filePath))) {
                 // PageSize landscape = PageSize.A4;
                 Document document = new Document(pdf);
 
             // Add School Name and Date at the top of the page
             PdfFont boldFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
             PdfFont blueFont = PdfFontFactory.createFont(FontConstants.HELVETICA);
 
             // Create a Div element for center alignment
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
                     .setFontSize(16);
 
             Paragraph date = new Paragraph("Academic Year: " + academicYear + " | Address: " + address )
                     .setFont(blueFont)
                     .setFontSize(14);
 
             Paragraph printed = new Paragraph("Printed Date: " + currentDate)
                     .setFont(blueFont)
                     .setFontSize(12);
 
            
 
             
             headerDiv.add(schoolNameParagraph);
             document.add(date);
             document.add(printed);
             Image watermarkImage = new Image(ImageDataFactory.create("C:/Users/USER/Documents/Cohas Bepanda/Cohas Bepanda/src/pics/logo.png"));
                 ((com.itextpdf.layout.element.Image) watermarkImage).scaleToFit(50,50);
                 watermarkImage.setHorizontalAlignment(HorizontalAlignment.CENTER);
                 document.add(watermarkImage);
             document.add(headerDiv);
 
             // ... Continue with the student details ...
 
             // Database query to fetch student details based on the school name
             String selectData = "SELECT * FROM student WHERE id = ?";
             try (PreparedStatement prepare = connect.prepareStatement(selectData)) {
                 prepare.setInt(1, selectedStudentId); // Assuming school_name is a TextField or similar
                 try (ResultSet resultSet = prepare.executeQuery()) {
                     // Check if the student with the given school_name exists
                     double amountOwing = 0.0;
                     double amountPaid = 0.0;
                     double Scholarship = 0.0;
                     double firstPayment = 0.0;
                     double other = 0.0;
                      double fees = 0.0;
                     // double amountOwing = 0.0;
                     if (resultSet.next()) {
                         // Fetch student details from the result set and populate the PDF accordingly
                         
                         
                         // Add student details to the invoice
                         Paragraph studentNameParagraph = new Paragraph("Student Name: " + selectedStudentName)
                                 .setFont(blueFont)
                                 .setFontSize(15);
                         // ... Add other student details to the PDF ...
                         DecimalFormat currencyFormat = new DecimalFormat("#,##0.00");
                         Paragraph studentIdParagraph = new Paragraph("Student ID: " + selectedStudentId)
                                 .setFont(blueFont)
                                 .setFontSize(14);
 
                                 
                                     amountOwing = resultSet.getDouble("amount_owing");
                                     amountPaid = resultSet.getDouble("amount_paid");
                                     fees = resultSet.getDouble("fees");
                                     firstPayment = resultSet.getDouble("first_payment_amount");
                                     Scholarship = resultSet.getDouble("scholarship");
                                     other = resultSet.getDouble("other_fees");
                                  String   ClassName = resultSet.getString("class_name");
                                  String   Section = resultSet.getString("section");
                                  String Paid = currencyFormat.format(amountPaid);
       
                                         DeviceRgb paid = new DeviceRgb(0, 255, 0); // Blue color
                                         String Owe = currencyFormat.format(amountOwing);
       
                                         DeviceRgb owe = new DeviceRgb(255, 0, 0); // Blue color
                                 Paragraph amountOwingParagraph = new Paragraph("Total Amount Paid: " )
                                 .setFont(blueFont)
                                 .setFontSize(14)
                                 .add(new Text(Paid).setFontColor(paid));
     
                                 Paragraph amountPaidParagraph = new Paragraph("Amount Owing: " )
                                 .setFont(blueFont)
                                 .setFontSize(14)
                                 .add(new Text(Owe).setFontColor(owe));
 
                                 DeviceRgb scholarshipColor = new DeviceRgb(0, 0, 225); // Blue color
                                 String scholarshipText = Scholarship > 0 ? currencyFormat.format(Scholarship) : "No Scholarship awarded";
                                 Paragraph scholarshipParagraph = new Paragraph("Scholarship: " )
                                         .setFont(blueFont)
                                         .setFontSize(14)
                                         .add(new Text(scholarshipText).setFontColor(scholarshipColor));
                                                                 String Others = currencyFormat.format(other);
       
                                         DeviceRgb mat = new DeviceRgb(0, 0, 255); // Blue color
                         Paragraph otherFeesParagraph = new Paragraph("Material fee: ")
                                 .setFont(blueFont)
                                 .setFontSize(14)
                                 .add(new Text(Others).setFontColor(mat));
                                 
                                 DeviceRgb otherFeesColor = new DeviceRgb(0, 0, 255); // Blue color
                         Paragraph classNameParagraph = new Paragraph("Class Name: " + ClassName + " | Section: " + Section)
                                 .setFont(blueFont)
                                 .setFontSize(14);
                                 
                         Paragraph FirstPayment = new Paragraph(" First Payment: " + currencyFormat.format(firstPayment))
                                 .setFont(blueFont)
                                 .setFontSize(14);
         
                         
         
                         Paragraph feesParagraph = new Paragraph("Fees: " + currencyFormat.format(fees))
                                 .setFont(blueFont)
                                  .setFontSize(14);
                        
                         document.add(studentNameParagraph);
                         document.add(studentIdParagraph);
                         document.add(classNameParagraph);
                         document.add(feesParagraph);
                         // document.add(studentNameParagraph);
                         document.add(amountPaidParagraph);
                         document.add(amountOwingParagraph);
                         document.add(scholarshipParagraph);
                         document.add(otherFeesParagraph);
                         document.add(FirstPayment);
                         // ... Add other student details to the PDF ...
                     } else {
                         System.err.println("Error: Student with school name " + school_name.getText() + " not found.");
                         return; // Return early, as no student data is available for the given school_name.
                     }
                 }
             } catch (SQLException e) {
                 e.printStackTrace();
                 
             }
 
             // ... Continue with the payment information ...
 
             // Database query to fetch payments for the selected student
             String paymentQuery = "SELECT * FROM payments WHERE student_id = ?";
             try (PreparedStatement statement = connect.prepareStatement(paymentQuery)) {
                 statement.setInt(1, selectedStudentId);
                 ResultSet resultSet = statement.executeQuery();
                 
                 
                     // Add a table to show all payments made by the student
                     float[] columnWidths = { 100f, 100f }; // Adjust column widths as needed
                     Table paymentTable = new Table(UnitValue.createPercentArray(columnWidths)).useAllAvailableWidth();
                     // ... Rest of the code to populate the payment table ...
 
                     // Add table headers with bold font
                     PdfFont headingFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
                     paymentTable.addHeaderCell(new Cell().add(new Paragraph("Payment Date").setFont(headingFont)));
                     paymentTable.addHeaderCell(new Cell().add(new Paragraph("Payment Amount").setFont(headingFont)));
 
                     // Add table rows for each payment
                     DecimalFormat currencyFormat = new DecimalFormat("#,##0.00");
                     while (resultSet.next()) {
                         String paymentDate = resultSet.getString("payment_date");
                     double paymentAmount = resultSet.getDouble("payment_amount");
                         // ... Rest of the code to add the payment details to the payment table ...
 
                         paymentTable.addCell(paymentDate);
                     paymentTable.addCell(currencyFormat.format(paymentAmount));
                     }
 
                     document.add(new Paragraph("Payments Made by the Student:").setFont(headingFont));
                     document.add(paymentTable);
 
                     Paragraph signature = new Paragraph("Principal: " + Princi)
                         .setFont(boldFont)
                         .setFontSize(12)
                         .setMarginTop(10);
                 document.add(signature);
                 
             } catch (SQLException e) {
                 e.printStackTrace();
             }
 
             // ... Rest of the code ...
 
             document.close();
             Alert alert = new Alert(AlertType.INFORMATION);
             alert.setTitle("Information Message");
             alert.setHeaderText(null);
             alert.setContentText("Student Invoice PDF file downloaded successfully!");
             alert.showAndWait();
         } catch (IOException e) {
             e.printStackTrace();
         }
     } catch (Exception e) {
         e.printStackTrace();
     }
 }
 
 
     
     
 
 public void downloadClassDetails(ActionEvent event) {
     String selectedClassName = classRecord_Download.getValue();
     String selectedSection = SectionRecord_Download.getValue();
     
     // Get the connection to the database
     connect = Database.connectDb();
     
     try {
         String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
         
         FileChooser fileChooser = new FileChooser();
         fileChooser.setTitle("Select Directory for Download");
 
         // Set initial directory (optional)
         fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
 
         // Set the suggested file name for the Save As dialog (optional)
         String suggestedFileName = "Class_Details_" + selectedClassName + "_" + selectedSection + "_" + currentDate + ".pdf";
         FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF Files (*.pdf)", "*.pdf");
         fileChooser.getExtensionFilters().add(extFilter);
         fileChooser.setInitialFileName(suggestedFileName);
 
         // Show the Save As dialog and get the selected file
         javafx.stage.Window window = ((Node) event.getSource()).getScene().getWindow();
         File selectedFile = fileChooser.showSaveDialog(window);
         String filePath = selectedFile.getAbsolutePath();
 
         try (PdfDocument pdf = new PdfDocument(new PdfWriter(filePath))) {
             PageSize landscape = PageSize.A4; // Landscape mode
             Document document = new Document(pdf, landscape);
     
             // Add School Name and Date at the top of the page
             PdfFont boldFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
             PdfFont blueFont = PdfFontFactory.createFont(FontConstants.HELVETICA);
     
             // Create a Div element for center alignment
             Div headerDiv = new Div()
                     .setTextAlignment(TextAlignment.CENTER)
                     .setVerticalAlignment(VerticalAlignment.MIDDLE);
     
             DecimalFormat currencyFormat = new DecimalFormat("#,##0.00");
             String[] schoolInfo = getSchoolInfoFromSettings();
             String schoolName = schoolInfo[0];
             String Princi = schoolInfo[2];
             String address = schoolInfo[3];
     
             String academicYear = getAcademicYearFromSettings();
             Paragraph schoolNameParagraph = new Paragraph(schoolName)
                     .setFont(boldFont)
                     .setFontSize(16);
     
             Paragraph date = new Paragraph("Academic Year: " + academicYear + " | Address: " + address + " | Principal: " + Princi)
                     .setFont(blueFont)
                     .setFontSize(14);
     
             Paragraph printed = new Paragraph("Printed Date: " + currentDate)
                     .setFont(blueFont)
                     .setFontSize(12);
     
             headerDiv.add(schoolNameParagraph);
             document.add(date);
             document.add(printed);
 
             Image watermarkImage = new Image(ImageDataFactory.create("C:/Users/USER/Documents/Cohas Bepanda/Cohas Bepanda/src/pics/logo.png"));
             ((com.itextpdf.layout.element.Image) watermarkImage).scaleToFit(50,50);
             watermarkImage.setHorizontalAlignment(HorizontalAlignment.CENTER);
             document.add(watermarkImage);
             document.add(headerDiv);
     
             // Database query to fetch class details based on the selected class and section
             String selectData = "SELECT * FROM student WHERE class_name = ? AND section = ? AND academic_year = ?";
             try (PreparedStatement prepare = connect.prepareStatement(selectData)) {
                 prepare.setString(1, selectedClassName);
                 prepare.setString(2, selectedSection);
                 prepare.setString(3, academicYear);
                 try (ResultSet resultSet = prepare.executeQuery()) {
                     // Check if the class details exist
                     if (resultSet.next()) {
                         // Fetch class details from the result set and populate the PDF accordingly
                         // Extract class details from the resultSet and create Paragraphs for each detail
     
                         // Example:
                         String className = resultSet.getString("class_name");
                         String studentName = resultSet.getString("name");
     
                         // Create a table to hold the additional details for each student
                         float[] columnWidths = { 10f, 70f, 90f, 70f, 70f, 70f, 60f }; // Adjust column widths as needed
                         Table studentTable = new Table(columnWidths).useAllAvailableWidth();
                         
                         // Add table headers with bold font
                         PdfFont headingFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
                         studentTable.addHeaderCell(new Cell().add(new Paragraph("ID").setFont(headingFont)));
                         studentTable.addHeaderCell(new Cell().add(new Paragraph("Name").setFont(headingFont)));
                         studentTable.addHeaderCell(new Cell().add(new Paragraph("DOB").setFont(headingFont)));
                         studentTable.addHeaderCell(new Cell().add(new Paragraph("Contact").setFont(headingFont)));
                         studentTable.addHeaderCell(new Cell().add(new Paragraph("Amount Owing").setFont(headingFont)));
                         studentTable.addHeaderCell(new Cell().add(new Paragraph("Amount Paid").setFont(headingFont)));
                         studentTable.addHeaderCell(new Cell().add(new Paragraph("Status").setFont(headingFont)));
                         
                         // Count the number of students
                         int studentCount = 0;
                         
                         // Iterate through the students and add their details to the table
                         do {
                             int studentId = resultSet.getInt("student_id");
                             String dateOfBirth = resultSet.getString("date_of_birth");
                             String name = resultSet.getString("name");
                             String contact = resultSet.getString("contact");
                             double amountOwing = resultSet.getDouble("amount_owing");
                             double amountPaid = resultSet.getDouble("amount_paid");
                             String status = resultSet.getString("status");
 
                             if ("completed".equalsIgnoreCase(status)) {
                                 status = "OK";
                             }
 
                             studentTable.addCell(String.valueOf(studentId));
                             studentTable.addCell(name);
                             studentTable.addCell(dateOfBirth);
                             studentTable.addCell(contact);
                             studentTable.addCell(currencyFormat.format(amountOwing));
                             studentTable.addCell(currencyFormat.format(amountPaid));
                             studentTable.addCell(status);
 
                             studentCount++;
                         
                         } while (resultSet.next());
 
                        
                         // Add the student count at the top of the table
                         document.add(new Paragraph("Class and Section: " + className + " - " + selectedSection + "     |    Enrolled: " + studentCount)
                                 .setFont(headingFont)
                                 .setFontSize(14));
                         
                                 
                         document.add(studentTable);
                         String sumQuery = "SELECT SUM(amount_owing) As grandTotalOwing, SUM(amount_paid) As grandTotalPaid FROM student WHERE class_name = ? AND section = ? AND academic_year = ?";
                         try (PreparedStatement prepareSum = connect.prepareStatement(sumQuery)) {
                             prepareSum.setString(1, selectedClassName);
                             prepareSum.setString(2, selectedSection);
                             prepareSum.setString(3, academicYear);
                             try (ResultSet result = prepareSum.executeQuery()) {
                               
                                 if (result.next()) {
                                     double grandTotalPaid = result.getDouble("grandTotalPaid");
                         double grandTotalOwing = result.getDouble("grandTotalOwing");
                         document.add(new Paragraph("Total Paid: " + currencyFormat.format(grandTotalPaid) + " |  Total Owing " + currencyFormat.format(grandTotalOwing) )
                                 .setFont(headingFont)
                                 .setFontSize(14));
                                 }
                             }
                         }
 
                      
                         // ... Add other class details to the PDF ...
                     } else {
                         System.err.println("Error: Class details not found for class " + selectedClassName + " and section " + selectedSection);
                         return; // Return early if class details are not found.
                     }
                 }
             } catch (SQLException e) {
                 e.printStackTrace();
                 return;
             }
     
             // ... Add other sections and details ...
     
             document.close();
             Alert alert = new Alert(AlertType.INFORMATION);
             alert.setTitle("Information Message");
             alert.setHeaderText(null);
             alert.setContentText("Class Details PDF file downloaded successfully!");
             alert.showAndWait();
         } catch (IOException e) {
             e.printStackTrace();
         }
     } catch (Exception e) {
         e.printStackTrace();
     }
 }
 
     public void markSheet(ActionEvent event) {
         String selectedClassName = marksheet_class.getValue();
         String selectedSection = marksheet_section.getValue();
         // Get the connection to the database
         connect = Database.connectDb();
     
         try {
             String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            // Create a FileChooser to allow the user to select a directory
     FileChooser fileChooser = new FileChooser();
     fileChooser.setTitle("Select Directory for Download");
 
     // Set initial directory (optional)
     fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
 
     // Set the suggested file name for the Save As dialog (optional)
     String suggestedFileName = "MarkSheet_" + selectedClassName + "_" + selectedSection + "_" + currentDate + ".pdf";
     FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF Files (*.pdf)", "*.pdf");
     fileChooser.getExtensionFilters().add(extFilter);
     fileChooser.setInitialFileName(suggestedFileName);
 
     // Show the Save As dialog and get the selected file
     javafx.stage.Window window = ((Node) event.getSource()).getScene().getWindow();
     File selectedFile = fileChooser.showSaveDialog(window);
     String filePath = selectedFile.getAbsolutePath();
 
     try (PdfDocument pdf = new PdfDocument(new PdfWriter(filePath))) {
                 // PageSize landscape = PageSize.A4;
                 Document document = new Document(pdf);
     
                 // Add School Name and Date at the top of the page
                 PdfFont boldFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
                 PdfFont blueFont = PdfFontFactory.createFont(FontConstants.HELVETICA);
     
                 // Create a Div element for center alignment
                 Div headerDiv = new Div()
                         .setTextAlignment(TextAlignment.CENTER)
                         .setVerticalAlignment(VerticalAlignment.MIDDLE);
     
                 DecimalFormat currencyFormat = new DecimalFormat("#,##0.00");
                 String[] schoolInfo = getSchoolInfoFromSettings();
                 String schoolName = schoolInfo[0];
                 String Princi = schoolInfo[2];
                 String address = schoolInfo[3];
     
                 String academicYear = getAcademicYearFromSettings();
                 Paragraph schoolNameParagraph = new Paragraph(schoolName)
                         .setFont(boldFont)
                         .setFontSize(14);
     
                 Paragraph date = new Paragraph("Academic Year: " + academicYear)
                         .setFont(blueFont)
                         .setFontSize(12);
     
                 Paragraph printed = new Paragraph("Printed Date: " + currentDate)
                         .setFont(blueFont)
                         .setFontSize(12);
     
                 Paragraph Address = new Paragraph("Address: " + address)
                         .setFont(blueFont)
                         .setFontSize(12);
     
                 headerDiv.add(schoolNameParagraph);
                 document.add(date);
                 document.add(Address);
                 document.add(printed);
                 Image watermarkImage = new Image(ImageDataFactory.create("C:/Users/USER/Documents/Cohas Bepanda/Cohas Bepanda/src/pics/logo.png"));
                 ((com.itextpdf.layout.element.Image) watermarkImage).scaleToFit(50,50);
                 watermarkImage.setHorizontalAlignment(HorizontalAlignment.CENTER);
                 document.add(watermarkImage);
                 document.add(headerDiv);
     
                 // Database query to fetch class details based on the selected class and section
                 String selectData = "SELECT * FROM student WHERE class_name = ? AND section = ? AND academic_year = ?";
                 try (PreparedStatement prepare = connect.prepareStatement(selectData)) {
                     prepare.setString(1, selectedClassName);
                     prepare.setString(2, selectedSection);
                     prepare.setString(3, academicYear);
                     try (ResultSet resultSet = prepare.executeQuery()) {
                         // Check if the class details exist
                         if (resultSet.next()) {
                             // Fetch class details from the result set and populate the PDF accordingly
                             // Extract class details from the resultSet and create Paragraphs for each detail
     
                             // Example:
                             String className = resultSet.getString("class_name");
                             String studentName = resultSet.getString("name");
     
                             
                             // Create a table to hold the additional details for each student
                             float[] columnWidths = { 10f, 250f, 10f, 70f, 30f, 30f, 30f, 30f, 30f, 30f, }; // Adjust column widths as needed
                             Table studentTable = new Table(columnWidths).useAllAvailableWidth();
                             
                             // Add table headers with bold font
                             PdfFont headingFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
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
     
                             // Iterate through the students and add their details to the table
                             do {
                                 int studentId = resultSet.getInt("student_id");
                                 String name = resultSet.getString("name");
                                 String dateOfBirth = resultSet.getString("date_of_birth");
                                 String Gen = resultSet.getString("gender");
                                 String genderSymbol = Gen.equalsIgnoreCase("male") ? "M" : "F";
                                 studentTable.addCell(String.valueOf(studentId)); // ID
                                 studentTable.addCell(name); // Name
                                 studentTable.addCell(genderSymbol); // Gender
                                 studentTable.addCell(dateOfBirth); // Date of Birth
                                 studentTable.addCell(""); // Sq1
                                 studentTable.addCell(""); // Sq2
                                 studentTable.addCell(""); // Sq3
                                 studentTable.addCell(""); // Sq4
                                 studentTable.addCell(""); // Sq5
                                 studentTable.addCell(""); // Sq6
                             } while (resultSet.next());
     
                             // Add the table to the document
                             document.add(new Paragraph("Class and Section: " + className + " - " + selectedSection)
                                     .setFont(headingFont)
                                     .setFontSize(14));
                             document.add(studentTable);
                             // ... Add other class details to the PDF ...
                         } else {
                             System.err.println("Error: Class details not found for class " + selectedClassName + " and section " + selectedSection);
                             return; // Return early if class details are not found.
                         }
                     }
                 } catch (SQLException e) {
                     e.printStackTrace();
                     return;
                 }
     
                 // ... Add other sections and details ...
     
                 document.close();
                 Alert alert = new Alert(AlertType.INFORMATION);
                 alert.setTitle("Information Message");
                 alert.setHeaderText(null);
                 alert.setContentText("Class Details PDF file downloaded successfully!");
                 alert.showAndWait();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
     
     public void markSheet_word(ActionEvent event) {
         String selectedClassName = marksheet_class.getValue();
         String selectedSection = marksheet_section.getValue();
     int totalStudents = 0;
                                 int maleCount = 0;
                                 int femaleCount = 0;
         
         try {
             String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
     
             // Create a FileChooser to allow the user to select a directory
             FileChooser fileChooser = new FileChooser();
             fileChooser.setTitle("Select Directory for Download");
     
             // Set initial directory (optional)
             fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
     
             // Set the suggested file name for the Save As dialog (optional)
             String suggestedFileName = "MarkSheet_" + selectedClassName + "_" + selectedSection + "_" + currentDate + ".docx";
             FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Word Documents (*.docx)", "*.docx");
             fileChooser.getExtensionFilters().add(extFilter);
             fileChooser.setInitialFileName(suggestedFileName);
     
             // Show the Save As dialog and get the selected file
             javafx.stage.Window window = ((Node) event.getSource()).getScene().getWindow();
             File selectedFile = fileChooser.showSaveDialog(window);
             String filePath = selectedFile.getAbsolutePath();
     
             // Create a new Word document
             XWPFDocument document = new XWPFDocument();
     
             // Create a paragraph for the table
             XWPFParagraph paragraph = document.createParagraph();
                         String academicYear = getAcademicYearFromSettings();
             String[] schoolInfo = getSchoolInfoFromSettings();
                 String schoolName = schoolInfo[0];
                 String Princi = schoolInfo[2];
                 String address = schoolInfo[3];
 
                             
 
                 
                 XWPFParagraph printedParagraph = document.createParagraph();
                 printedParagraph.setSpacingAfter(100); // Adjust spacing as needed
 
                 XWPFParagraph dateParagraph = document.createParagraph();
                 dateParagraph.setSpacingAfter(100); // Adjust spacing as needed
 
                 XWPFParagraph addressParagraph = document.createParagraph();
                 addressParagraph.setSpacingAfter(100); // Adjust spacing as needed
 
                 XWPFParagraph schoolNameParagraph = document.createParagraph();
                 schoolNameParagraph.setSpacingAfter(200); // Adjust spacing as needed
 
                 // Add content to the paragraphs
                 
 
                 dateParagraph.setAlignment(ParagraphAlignment.LEFT);
                 XWPFRun dateRun = dateParagraph.createRun();
                 dateRun.setText("Academic Year: " + academicYear);
                 dateRun.setFontSize(14);
                 dateRun.setBold(true); // Make the text bold
 
                 printedParagraph.setAlignment(ParagraphAlignment.LEFT);
                 XWPFRun printedRun = printedParagraph.createRun();
                 printedRun.setText("Printed Date: " + currentDate);
                 printedRun.setFontSize(10);
                 printedRun.setBold(true); // Make the text bold
 
                 
                 addressParagraph.setAlignment(ParagraphAlignment.LEFT);
                 XWPFRun addressRun = addressParagraph.createRun();
                 addressRun.setText("Address: " + address);
                 addressRun.setFontSize(14);
                 addressRun.setBold(true); // Make the text bold
 
                 schoolNameParagraph.setAlignment(ParagraphAlignment.CENTER);
                 XWPFRun schoolNameRun = schoolNameParagraph.createRun();
                 schoolNameRun.setText(schoolName);
                 schoolNameRun.setFontSize(16);
                 schoolNameRun.setBold(true); // Make the text bold
 
                 // Add watermark image
                 try (FileInputStream watermarkStream = new FileInputStream("C:/Users/USER/Documents/Cohas Bepanda/Cohas Bepanda/src/pics/logo.png")) {
                     XWPFParagraph watermarkParagraph = document.createParagraph();
                     watermarkParagraph.setAlignment(ParagraphAlignment.CENTER);
 
                     watermarkParagraph.createRun().addPicture(watermarkStream, XWPFDocument.PICTURE_TYPE_PNG, "C:/Users/USER/Documents/Cohas Bepanda/Cohas Bepanda/src/pics/logo.png", Units.toEMU(50), Units.toEMU(50));
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
                 // Add counts to the document
         XWPFParagraph countsParagraph = document.createParagraph();
         countsParagraph.setAlignment(ParagraphAlignment.CENTER);
             
         // countsParagraph.createRun().setText("Total Students: " + totalStudents + "      F:" + femaleCount + "      M:" + maleCount);
         
             // Add watermark image
 
 
 
             // Create a table with 10 columns
             XWPFTable table = document.createTable(1, 10);
     
             // Set column widths (in twips)
             // int columnWidths = 100; // Adjust column widths as needed
             table.setWidth(100);
     
             // Add table headers with bold font
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
     
             // Database query to fetch class details based on the selected class and section
             String selectData = "SELECT * FROM student WHERE class_name = ? AND section = ? AND academic_year = ?";
             try (PreparedStatement prepare = connect.prepareStatement(selectData)) {
                 prepare.setString(1, selectedClassName);
                 prepare.setString(2, selectedSection);
                 prepare.setString(3, academicYear);
                 try (ResultSet resultSet = prepare.executeQuery()) {
                     // Check if the class details exist
                     if (resultSet.next()) {
                         // Iterate through the students and add their details to the table
                         do {
                             int studentId = resultSet.getInt("student_id");
                             String name = resultSet.getString("name");
                             java.sql.Date dob = resultSet.getDate("date_of_birth");
 
                             // SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yy");
                             String formattedDateOfBirth = new SimpleDateFormat("dd/MM/yyyy").format(dob);
 
                             String Gen = resultSet.getString("gender");
                             String genderSymbol = Gen.equalsIgnoreCase("male") ? "M" : "F";
     
                             XWPFTableRow dataRow = table.createRow();
                             dataRow.getCell(0).setText(String.valueOf(studentId));
                             dataRow.getCell(1).setText(name);
                             dataRow.getCell(2).setText(genderSymbol);
                             dataRow.getCell(3).setText(formattedDateOfBirth);
                             dataRow.getCell(4).setText("");
                             dataRow.getCell(5).setText("");
                             dataRow.getCell(6).setText("");
                             dataRow.getCell(7).setText("");
                             dataRow.getCell(8).setText("");
                             dataRow.getCell(9).setText("");
                                 
                             totalStudents++;
             if (Gen.equalsIgnoreCase("male")) {
                 maleCount++;
             } else {
                 femaleCount++;
             }
                         } while (resultSet.next());
                     } else {
                         System.err.println("Error: Class details not found for class " + selectedClassName + " and section " + selectedSection);
                         return; // Return early if class details are not found.
                     }
                 }
             } catch (SQLException e) {
                 e.printStackTrace();
                 return;
             }
             // Create a run for the counts paragraph
                 XWPFRun countsRun = countsParagraph.createRun();
 
                 // Set the text, font size, and bold style for the counts paragraph
                 countsRun.setText(selectedClassName + ": " + selectedSection + "  |  Total: " + totalStudents + "  |    F:" + femaleCount + "   |    M:" + maleCount);
                  countsRun.setFontSize(14);
                 countsRun.setBold(true); // Make the text bold
 
                 // Create an empty paragraph for spacing
 XWPFParagraph spacingParagraph = document.createParagraph();
 spacingParagraph.setSpacingAfter(200); // Adjust the spacing as needed
 
 // Create the "Principal" paragraph
 XWPFParagraph principalParagraph = document.createParagraph();
 
 // Set the text, font size, and bold style for the principal paragraph
 principalParagraph.setAlignment(ParagraphAlignment.CENTER);
 XWPFRun principalRun = principalParagraph.createRun();
 principalRun.setText("Principal: " + Princi);
 principalRun.setFontSize(14);
 principalRun.setBold(true); // Make the text bold
 
 
             // Save the document to a file
             FileOutputStream fileOut = new FileOutputStream(new File(filePath));
             document.write(fileOut);
             fileOut.close();
     
             // Close the document
             // document.close();
     
             Alert alert = new Alert(AlertType.INFORMATION);
             alert.setTitle("Information Message");
             alert.setHeaderText(null);
             alert.setContentText("MarkSheet Word document downloaded successfully!");
             alert.showAndWait();
         } catch (IOException e) {
             e.printStackTrace();
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
 
 
     public void markSheet_excel(ActionEvent event) {
         String selectedClassName = marksheet_class.getValue();
         String selectedSection = marksheet_section.getValue();
         // int totalStudents = 0;
         // int maleCount = 0;
         // int femaleCount = 0;
     
         try {
             String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
     
             // Create a FileChooser to allow the user to select a directory
             FileChooser fileChooser = new FileChooser();
             fileChooser.setTitle("Select Directory for Download");
     
             // Set initial directory (optional)
             fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
     
             // Set the suggested file name for the Save As dialog (optional)
             String suggestedFileName = "MarkSheet_" + selectedClassName + "_" + selectedSection + "_" + currentDate + ".xls";
             FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel Files (*.xls)", "*.xls");
             fileChooser.getExtensionFilters().add(extFilter);
             fileChooser.setInitialFileName(suggestedFileName);
     
             // Show the Save As dialog and get the selected file
             javafx.stage.Window window = ((Node) event.getSource()).getScene().getWindow();
             File selectedFile = fileChooser.showSaveDialog(window);
             String filePath = selectedFile.getAbsolutePath();
             String academicYear = getAcademicYearFromSettings();
     
             // Create a new Excel workbook
             HSSFWorkbook workbook = new HSSFWorkbook();
             HSSFSheet sheet = workbook.createSheet("MarkSheet");
     
             // Add headers to the Excel sheet with custom style
             HSSFRow headerRow = sheet.createRow(0);
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
     
             // Create a custom style for the header
             // CellStyle headerStyle = workbook.createCellStyle();
             // Font headerFont = workbook.createFont();
             // headerFont.setColor(IndexedColors.WHITE.getIndex());
             // headerStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
             // headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
             // headerStyle.setFont(headerFont);
     
             // for (int i = 0; i < headerRow.getLastCellNum(); i++) {
             //     headerRow.getCell(i).setCellStyle(headerRow);
             // }
     
             // Add the class name, section, printed date, academic year, school name, and student counts to the Excel sheet
             // HSSFRow classNameRow = sheet.createRow(1);
             // classNameRow.createCell(0).setCellValue("Class:");
             // classNameRow.createCell(1).setCellValue(selectedClassName);
             // classNameRow.createCell(2).setCellValue("Section:");
             // classNameRow.createCell(3).setCellValue(selectedSection);
     
             // HSSFRow dateRow = sheet.createRow(2);
             // dateRow.createCell(0).setCellValue("Printed Date:");
             // dateRow.createCell(1).setCellValue(currentDate);
             // dateRow.createCell(2).setCellValue("Academic Year:");
             // dateRow.createCell(3).setCellValue(academicYear);
     
             // String[] schoolInfo = getSchoolInfoFromSettings();
             // String schoolName = schoolInfo[0];
             // String Princi = schoolInfo[2];
             // String address = schoolInfo[3];
     
             // HSSFRow schoolNameRow = sheet.createRow(3);
             // schoolNameRow.createCell(0).setCellValue("School Name:");
             // schoolNameRow.createCell(1).setCellValue(schoolName);
     
             // Database query to fetch class details based on the selected class and section
             String selectData = "SELECT * FROM student WHERE class_name = ? AND section = ? AND academic_year = ?";
             try (PreparedStatement prepare = connect.prepareStatement(selectData)) {
                 prepare.setString(1, selectedClassName);
                 prepare.setString(2, selectedSection);
                 prepare.setString(3, academicYear);
                 try (ResultSet resultSet = prepare.executeQuery()) {
                     int rowNum = 2;
                     // Check if the class details exist
                     if (resultSet.next()) {
                         // Iterate through the students and add their details to the Excel sheet
                         do {
                             int studentId = resultSet.getInt("student_id");
                             String name = resultSet.getString("name");
                             // String dateOfBirth = resultSet.getString("date_of_birth");
                             // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                             java.sql.Date dob = resultSet.getDate("date_of_birth");
     
                             // SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yy");
                             String formattedDateOfBirth = new SimpleDateFormat("dd/MM/yyyy").format(dob);
     
                             String Gen = resultSet.getString("gender");
                             String genderSymbol = Gen.equalsIgnoreCase("male") ? "M" : "F";
     
                             HSSFRow dataRow = sheet.createRow(rowNum++);
                             dataRow.createCell(0).setCellValue(studentId);
                             dataRow.createCell(1).setCellValue(name);
                             dataRow.createCell(2).setCellValue(genderSymbol);
                             dataRow.createCell(3).setCellValue(formattedDateOfBirth);
                             dataRow.createCell(4).setCellValue("");
                             dataRow.createCell(5).setCellValue("");
                             dataRow.createCell(6).setCellValue("");
                             dataRow.createCell(7).setCellValue("");
                             dataRow.createCell(8).setCellValue("");
                             dataRow.createCell(9).setCellValue("");
     
                             // totalStudents++;
                             // if (Gen.equalsIgnoreCase("male")) {
                             //     maleCount++;
                             // } else {
                             //     femaleCount++;
                             // }
                         } while (resultSet.next());
                     } else {
                         System.err.println("Error: Class details not found for class " + selectedClassName + " and section " + selectedSection);
                         return; // Return early if class details are not found.
                     }
                 }
             } catch (SQLException e) {
                 e.printStackTrace();
                 return;
             }
     
             // Autosize columns to fit content after all rows are added
             for (int i = 0; i < 10; i++) {
                 sheet.autoSizeColumn(i);
             }
     
             // Write the workbook to the selected file
             FileOutputStream fileOut = new FileOutputStream(filePath);
             workbook.write(fileOut);
             fileOut.close();
     
             Alert alert = new Alert(AlertType.INFORMATION);
             alert.setTitle("Information Message");
             alert.setHeaderText(null);
             alert.setContentText("Class List Excel file downloaded successfully!");
             alert.showAndWait();
         } catch (IOException e) {
             e.printStackTrace();
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
     
    
     public void saveSettings() {
         String selectData = "SELECT * FROM settings WHERE school_name = ?";
         String updateData = "UPDATE settings SET principal = ?, address = ?, academic_year = ? WHERE school_name = ?";
         String insertData = "INSERT INTO settings (school_name, principal, address,  academic_year) VALUES (?, ?, ?, ?)";
     
         connect = Database.connectDb();
     
         try {
             Alert alert;
     
             if (school_year.getSelectionModel().getSelectedItem() == null) {
                 
                 alert = new Alert(AlertType.ERROR);
                 alert.setTitle("Error Message");
                 alert.setHeaderText(null);
                 alert.setContentText("Please Select your current school year");
                 alert.showAndWait();
             } else {
                 prepare = connect.prepareStatement(selectData);
                 prepare.setString(1, school_name.getText());
                 ResultSet resultSet = prepare.executeQuery();
     
                 if (resultSet.next()) {
                     // The record already exists, perform an update
                     prepare = connect.prepareStatement(updateData);
                     prepare.setString(1, principal.getText());
                     prepare.setString(2, address.getText());
                     // String uri = getData.path;
                     // uri = uri.replace("\\", "\\\\");
                     // prepare.setString(3, uri); // Set photo to empty for now, modify as needed
                     prepare.setString(3, (String) school_year.getSelectionModel().getSelectedItem());
                     prepare.setString(4, school_name.getText());
                     prepare.executeUpdate();
 
                 alert = new Alert(AlertType.INFORMATION);
                 alert.setTitle("Information Message");
                 alert.setHeaderText(null);
                 alert.setContentText("Successfully Updated!");
                 alert.showAndWait();
                 } else {
                     // The record doesn't exist, perform an insert
                     prepare = connect.prepareStatement(insertData);
                     prepare.setString(1, school_name.getText());
                     prepare.setString(2, principal.getText());
                     prepare.setString(3, address.getText());
                     // String uri = getData.path;
                     // uri = uri.replace("\\", "\\\\");
                     // prepare.setString(4, uri); // Set photo to empty for now, modify as needed
                     prepare.setString(4, (String) school_year.getSelectionModel().getSelectedItem());
                     prepare.executeUpdate();
 
                 alert = new Alert(AlertType.INFORMATION);
                 alert.setTitle("Information Message");
                 alert.setHeaderText(null);
                 alert.setContentText("Successfully Saved!");
                 alert.showAndWait();
                 }
             }
         } catch (SQLException e) {
             e.printStackTrace();
         } finally {
             try {
                 if (prepare != null) {
                     prepare.close();
                 }
                 if (connect != null) {
                     connect.close();
                 }
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }
     }
     
     public void recordDailyTotalPaid() {
         // Get the current date
         LocalDate currentDate = LocalDate.now();
 
         // Get the connection to the database
         try { connect = Database.connectDb();
             // Calculate the total first payments for the day
             double totalFirstPayments = calculateTotalFirstPayments(connect, currentDate);
 
             // Calculate the total payment amounts for the day
             double totalPaymentAmounts = calculateTotalPaymentAmounts(connect, currentDate);
 
             // Calculate the total payments for the day
             double totalPayments = totalFirstPayments + totalPaymentAmounts;
             DecimalFormat currencyFormat = new DecimalFormat("#,##0.00");
             String TotalPayments = currencyFormat.format(totalPayments);
     
             dailyrecord.setText(TotalPayments);
 
 
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
 
     private double calculateTotalFirstPayments(Connection connect, LocalDate currentDate) throws SQLException {
         // Query to calculate the total first payments for the day
         String query = "SELECT SUM(first_payment_amount) AS total_first_payments " +
                 "FROM student " +
                 "WHERE DATE(date) = ?";
         double totalFirstPayments = 0.0;
 
         try (PreparedStatement statement = connect.prepareStatement(query)) {
             // Set the current date as the parameter in the query
             statement.setDate(1, java.sql.Date.valueOf(currentDate));
 
             // Execute the query and get the result
             try (ResultSet resultSet = statement.executeQuery()) {
                 if (resultSet.next()) {
                     totalFirstPayments = resultSet.getDouble("total_first_payments");
                 }
             }
         }
 
         return totalFirstPayments;
     }
 
     private double calculateTotalPaymentAmounts(Connection connect, LocalDate currentDate) throws SQLException {
         // Query to calculate the total payment amounts for the day
         String query = "SELECT SUM(payment_amount) AS total_payment_amounts " +
                 "FROM payments " +
                 "WHERE DATE(payment_date) = ?";
         double totalPaymentAmounts = 0.0;
 
         try (PreparedStatement statement = connect.prepareStatement(query)) {
             // Set the current date as the parameter in the query
             statement.setDate(1, java.sql.Date.valueOf(currentDate));
 
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
     
     // Get the connection to the database
     Connection connect = Database.connectDb();
     
     // Get the current date and calculate the start and end dates for the current week (Monday to Sunday)
     LocalDate currentDate = LocalDate.now();
     LocalDate startDate = currentDate.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
     LocalDate endDate = currentDate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
 
     
     try {
         // Database query to retrieve payments made between the start and end dates of the current week from the "payments" table
         String selectPaymentsData = "SELECT payment_amount FROM payments WHERE payment_date BETWEEN ? AND ?";
         try (PreparedStatement prepare = connect.prepareStatement(selectPaymentsData)) {
             prepare.setString(1, startDate.toString());
             prepare.setString(2, endDate.toString());
             try (ResultSet resultSet = prepare.executeQuery()) {
                 // Iterate through the results and sum up the payments from the "payments" table
                 while (resultSet.next()) {
                     double paymentAmount = resultSet.getDouble("payment_amount");
                     weeklyTotalPayments += paymentAmount;
                 }
             }
         }
         
         // Database query to retrieve first payment amounts from the "student" table for the current week
         String selectStudentsData = "SELECT first_payment_amount FROM student WHERE date BETWEEN ? AND ?";
         try (PreparedStatement prepare = connect.prepareStatement(selectStudentsData)) {
             prepare.setString(1, startDate.toString());
             prepare.setString(2, endDate.toString());
             try (ResultSet resultSet = prepare.executeQuery()) {
                 // Iterate through the results and sum up the first payment amounts from the "student" table
                 while (resultSet.next()) {
                     double firstPaymentAmount = resultSet.getDouble("first_payment_amount");
                     weeklyTotalPayments += firstPaymentAmount;
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
 
 // Method to generate the weekly record and save it as a PDF
 // ...
 
 public void generateWeeklyRecordPdf() {
     // Get the connection to the database
     Connection connect = Database.connectDb();
 
     // Get the current date and calculate the start and end dates for the current week (Monday to Sunday)
     LocalDate currentDate = LocalDate.now();
     LocalDate startDate = currentDate.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
     LocalDate endDate = currentDate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
 
     // Create the file path for the PDF
     String filePath = "C:\\Users\\USER\\Downloads\\Weekly_Record_" + startDate + "_to_" + endDate + ".pdf";
 
     try (PdfDocument pdf = new PdfDocument(new PdfWriter(filePath))) {
         // PageSize landscape = PageSize.A4.rotate();
         Document document = new Document(pdf);
 
         PdfFont boldFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
                 PdfFont blueFont = PdfFontFactory.createFont(FontConstants.HELVETICA);
     
                 // Create a Div element for center alignment
                 Div headerDiv = new Div()
                         .setTextAlignment(TextAlignment.CENTER)
                         .setVerticalAlignment(VerticalAlignment.MIDDLE);
     
                 DecimalFormat currencyFormat = new DecimalFormat("#,##0.00");
                 String[] schoolInfo = getSchoolInfoFromSettings();
                 String schoolName = schoolInfo[0];
                 String Princi = schoolInfo[2];
                 String address = schoolInfo[3];
     
                 String academicYear = getAcademicYearFromSettings();
                 Paragraph schoolNameParagraph = new Paragraph(schoolName)
                         .setFont(boldFont)
                         .setFontSize(18);
     
                 Paragraph day = new Paragraph("Academic Year: " + academicYear  + " | Address: " + address + " | PRINCIPAL: " + Princi)
                         .setFont(blueFont)
                         .setFontSize(14);
     
                 Paragraph printed = new Paragraph("Printed Date: " + currentDate)
                         .setFont(blueFont)
                         .setFontSize(12);
     
                 
                 headerDiv.add(schoolNameParagraph);
                 document.add(day);
                 document.add(printed);
 
                 
                 document.add(headerDiv);
         // Define fonts and colors
         PdfFont headingFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
         PdfFont contentFont = PdfFontFactory.createFont(FontConstants.HELVETICA);
 
         // Add header
         Paragraph header = new Paragraph("Weekly Record - " + startDate + " to " + endDate)
                 .setFont(headingFont)
                 .setFontSize(14)
                 .setTextAlignment(com.itextpdf.layout.property.TextAlignment.CENTER);
 
        
         // PdfCanvas canvas = new PdfCanvas(pdf.getFirstPage());
         Image watermarkImage = new Image(ImageDataFactory.create("C:/Users/USER/Documents/Cohas Bepanda/Cohas Bepanda/src/pics/logo.png"));
         ((com.itextpdf.layout.element.Image) watermarkImage).scaleToFit(50,50);
         watermarkImage.setHorizontalAlignment(HorizontalAlignment.CENTER);
         document.add(watermarkImage);
         document.add(header);
        
         Table table = new Table(2);
         table.setWidthPercent(100);
         table.addHeaderCell(new Cell().add(new Paragraph("Date-Day").setFont(headingFont)));
         table.addHeaderCell(new Cell().add(new Paragraph("Sum").setFont(headingFont)));
 
         // Database query to retrieve daily total payments from the "payments" table for each day of the week
         String selectPaymentsData = "SELECT payment_date, SUM(payment_amount) AS total_payment FROM payments WHERE payment_date BETWEEN ? AND ? GROUP BY payment_date";
         String selectStudentsData = "SELECT date, SUM(first_payment_amount) AS total_payment FROM student WHERE date BETWEEN ? AND ? GROUP BY date";
 
         try (PreparedStatement preparePayments = connect.prepareStatement(selectPaymentsData);
              PreparedStatement prepareStudents = connect.prepareStatement(selectStudentsData)) {
             preparePayments.setString(1, startDate.toString());
             preparePayments.setString(2, endDate.toString());
             prepareStudents.setString(1, startDate.toString());
             prepareStudents.setString(2, endDate.toString());
 
             try (ResultSet paymentsResult = preparePayments.executeQuery();
                  ResultSet studentsResult = prepareStudents.executeQuery()) {
 
                 Map<LocalDate, Double> dailyTotals = new HashMap<>();
 
                 // Add payment amounts from "payments" table to the map
                 while (paymentsResult.next()) {
                     LocalDate paymentDate = paymentsResult.getDate("payment_date").toLocalDate();
                     double totalPayment = paymentsResult.getDouble("total_payment");
                     dailyTotals.merge(paymentDate, totalPayment, Double::sum);
                 }
 
                 // Add first payment amounts from "student" table to the map
                 while (studentsResult.next()) {
                     LocalDate paymentDate = studentsResult.getDate("date").toLocalDate();
                     double totalPayment = studentsResult.getDouble("total_payment");
                     dailyTotals.merge(paymentDate, totalPayment, Double::sum);
                 }
 
                 // Sort the dates in ascending order
                 List<LocalDate> dates = new ArrayList<>(dailyTotals.keySet());
                 Collections.sort(dates);
 
                 // Iterate through the sorted dates and add date-day and sum to the table
                 for (LocalDate date : dates) {
                     String formattedDate = date + " (" + date.getDayOfWeek() + ")";
                     double totalPayment = dailyTotals.getOrDefault(date, 0.0);
 
                     table.addCell(new Cell().add(new Paragraph(formattedDate).setFont(contentFont)));
                     table.addCell(new Cell().add(new Paragraph(String.valueOf(totalPayment)).setFont(contentFont)));
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
 
 
 public void feeStructure(ActionEvent event) {
     try {
         String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
 
         FileChooser fileChooser = new FileChooser();
         fileChooser.setTitle("Select Directory for Download");
         fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
 
         String suggestedFileName = "Fees_Structure" + "_" + currentDate + ".pdf";
         FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF Files (*.pdf)", "*.pdf");
         fileChooser.getExtensionFilters().add(extFilter);
         fileChooser.setInitialFileName(suggestedFileName);
 
         javafx.stage.Window window = ((Node) event.getSource()).getScene().getWindow();
         File selectedFile = fileChooser.showSaveDialog(window);
         String filePath = selectedFile.getAbsolutePath();
 
         try (PdfDocument pdf = new PdfDocument(new PdfWriter(filePath))) {
             PageSize landscape = PageSize.A4.rotate();;
             Document document = new Document(pdf, landscape);
 
             PdfFont boldFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
             PdfFont blueFont = PdfFontFactory.createFont(FontConstants.HELVETICA);
 
             Div headerDiv = new Div()
                     .setTextAlignment(TextAlignment.CENTER)
                     .setVerticalAlignment(VerticalAlignment.MIDDLE);
 
             DecimalFormat currencyFormat = new DecimalFormat("#,##0.00");
             String[] schoolInfo = getSchoolInfoFromSettings();
             String schoolName = schoolInfo[0];
             String Princi = schoolInfo[2];
             String address = schoolInfo[3];
 
             String academicYear = getAcademicYearFromSettings();
              Paragraph schoolNameParagraph = new Paragraph(schoolName)
                         .setFont(boldFont)
                         .setFontSize(18);
     
              Paragraph day = new Paragraph("Academic Year: " + academicYear  + " | Address: " + address + " | PRINCIPAL: " + Princi)
                         .setFont(blueFont)
                         .setFontSize(14);
     
                 Paragraph printed = new Paragraph("Printed Date: " + currentDate)
                         .setFont(blueFont)
                         .setFontSize(12);
     
                 
                 headerDiv.add(schoolNameParagraph);
                 document.add(day);
                 document.add(printed);
 
                 
         // Define fonts and colors
         PdfFont headingFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
         PdfFont contentFont = PdfFontFactory.createFont(FontConstants.HELVETICA);
 
         // Add header
         Paragraph header = new Paragraph("School Fees Structure")
                 .setFont(headingFont)
                 .setFontSize(14)
                 .setTextAlignment(com.itextpdf.layout.property.TextAlignment.CENTER);
 
        
         // PdfCanvas canvas = new PdfCanvas(pdf.getFirstPage());
         Image watermarkImage = new Image(ImageDataFactory.create("C:/Users/USER/Documents/Cohas Bepanda/Cohas Bepanda/src/pics/logo.png"));
         ((com.itextpdf.layout.element.Image) watermarkImage).scaleToFit(50,50);
         watermarkImage.setHorizontalAlignment(HorizontalAlignment.CENTER);
         document.add(watermarkImage);
         document.add(headerDiv);
         document.add(header);
             // Database connection
             Connection connect = Database.connectDb();
 
             String selectData = "SELECT class_name, section, amount_paid FROM student WHERE academic_year = ?";
             try (PreparedStatement prepare = connect.prepareStatement(selectData)) {
                 prepare.setString(1, academicYear);
                 try (ResultSet resultSet = prepare.executeQuery()) {
                     Map<String, Double> feesMap = new HashMap<>();
                     Map<String, Double> regFeesMap = new HashMap<>();
                     Map<String, Double> pracFeesMap = new HashMap<>();
                     Map<String, Double> projFeesMap = new HashMap<>();
                     Map<String, Double> tutFeesMap = new HashMap<>();
                     Map<String, Double> intFeesMap = new HashMap<>();
                     Map<String, Integer> studentsMap = new HashMap<>();
 
                     while (resultSet.next()) {
                         String className = resultSet.getString("class_name");
                         String section = resultSet.getString("section");
                         double amountPaid = resultSet.getDouble("amount_paid");
 
                         String classSectionKey = className + "-" + section;
                         // String classKey = className;
 
                         double regFee = calculateRegFee(className, section);
                         double tutorials = calculateTutorials(className);
                         double internship = calculateInternship(className, section);
                         double practical = calculatePractical(className, section);
                         double projectFee = calculateProjectFee(className, section);
 
                         // Calculate actual fees
                         double totalFees = regFee + tutorials + internship + practical + projectFee;
                         double actualFees = amountPaid - totalFees;
 
                         // Update feesMap and studentsMap
                         feesMap.put(classSectionKey, feesMap.getOrDefault(classSectionKey, 0.0) + actualFees);
                         regFeesMap.put(classSectionKey, regFeesMap.getOrDefault(classSectionKey, 0.0) + regFee);
                         pracFeesMap.put(classSectionKey, pracFeesMap.getOrDefault(classSectionKey, 0.0) + practical);
                         projFeesMap.put(classSectionKey, projFeesMap.getOrDefault(classSectionKey, 0.0) + projectFee);
                         tutFeesMap.put(classSectionKey, tutFeesMap.getOrDefault(classSectionKey, 0.0) + tutorials);
                         intFeesMap.put(classSectionKey, intFeesMap.getOrDefault(classSectionKey, 0.0) + internship);
                         studentsMap.put(classSectionKey, studentsMap.getOrDefault(classSectionKey, 0) + 1);
                     }
 
                     // Close database connection
                     resultSet.close();
                     prepare.close();
                     connect.close();
 
                     // Create the table for displaying data
                     float[] columnWidths = { 75f, 50f, 50f, 100f, 100f, 100f, 100f, 100f, 100f };
                     Table studentTable = new Table(columnWidths).useAllAvailableWidth();
 
                     PdfFont headingFonts = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
                     studentTable.addHeaderCell(new Cell().add(new Paragraph("Class").setFont(headingFonts)));
                     studentTable.addHeaderCell(new Cell().add(new Paragraph("Section").setFont(headingFonts)));
                     studentTable.addHeaderCell(new Cell().add(new Paragraph("Students").setFont(headingFonts)));
                     studentTable.addHeaderCell(new Cell().add(new Paragraph("RegFee").setFont(headingFonts)));
                     studentTable.addHeaderCell(new Cell().add(new Paragraph("Tutorial").setFont(headingFonts)));
                     studentTable.addHeaderCell(new Cell().add(new Paragraph("Internship").setFont(headingFont)));
                     studentTable.addHeaderCell(new Cell().add(new Paragraph("Practicals").setFont(headingFonts)));
                     studentTable.addHeaderCell(new Cell().add(new Paragraph("Project").setFont(headingFonts)));
                     studentTable.addHeaderCell(new Cell().add(new Paragraph("ActualFees").setFont(headingFonts)));
 
 
                     int footRegFee = 0;
                     double footRegstud = 0;
                         double footTutFee = 0;
                         double footIntFee = 0;
                         double footProjFee = 0;
                         double footPracFee = 0;
                         double footActFee = 0;
                     // Add rows with summed data
                     for (String classSectionKey : feesMap.keySet()) {
                         String[] parts = classSectionKey.split("-");
                         String className = parts[0];
                         String section = parts[1];
                         int studentCount = studentsMap.get(classSectionKey);
                         double totalFees = feesMap.get(classSectionKey);
                         double totalRegFees = regFeesMap.get(classSectionKey);
                         double totalPracFees = pracFeesMap.get(classSectionKey);
                         double totalTutFees = tutFeesMap.get(classSectionKey);
                         double totalIntFees = intFeesMap.get(classSectionKey);
                         double totalProjFees = projFeesMap.get(classSectionKey);
                         
                             footRegstud += studentCount;
                             footRegFee += totalRegFees;
                             footTutFee += totalTutFees;
                             footIntFee += totalIntFees;
                             footProjFee += totalProjFees;
                             footPracFee += totalPracFees;
                             footActFee += totalFees;
                         // Add cells to the table
                         studentTable.addCell(className);
                         studentTable.addCell(section);
                         studentTable.addCell(String.valueOf(studentCount));
                         studentTable.addCell(String.valueOf(currencyFormat.format(totalRegFees)));
                         studentTable.addCell(String.valueOf(currencyFormat.format(totalTutFees)));
                         studentTable.addCell(String.valueOf(currencyFormat.format(totalIntFees)));
                         studentTable.addCell(String.valueOf(currencyFormat.format(totalPracFees)));
                         studentTable.addCell(String.valueOf(currencyFormat.format(totalProjFees)));
                         studentTable.addCell(String.valueOf(currencyFormat.format(totalFees)));
 
                     }
 
                     PdfFont footerFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
                     studentTable.addCell(new Cell(1, 2).add(new Paragraph("Total").setFont(footerFont)));
                     studentTable.addCell(new Cell().add(new Paragraph(String.valueOf(footRegstud)).setFont(footerFont)));
                     studentTable.addCell(new Cell().add(new Paragraph(currencyFormat.format(footRegFee)).setFont(footerFont)));
                     studentTable.addCell(new Cell().add(new Paragraph(currencyFormat.format(footTutFee)).setFont(footerFont)));
                     studentTable.addCell(new Cell().add(new Paragraph(currencyFormat.format(footIntFee)).setFont(footerFont)));
                     studentTable.addCell(new Cell().add(new Paragraph(currencyFormat.format(footPracFee)).setFont(footerFont)));
                     studentTable.addCell(new Cell().add(new Paragraph(currencyFormat.format(footProjFee)).setFont(footerFont)));
                     studentTable.addCell(new Cell().add(new Paragraph(currencyFormat.format(footActFee)).setFont(footerFont)));
 
                     // Add table to document
                     document.add(studentTable);
                     Alert alert = new Alert(AlertType.INFORMATION);
             alert.setTitle("Information Message");
             alert.setHeaderText(null);
             alert.setContentText("School Fees structure downloaded Successfully!");
             alert.showAndWait();
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }
     } catch (IOException e) {
         e.printStackTrace();
     }
 }
 
 
     private double calculateRegFee(String className, String section) {
         if (className.equalsIgnoreCase("Form One") ||
             className.equalsIgnoreCase("Form Two") ||
             className.equalsIgnoreCase("Form Three") ||
             className.equalsIgnoreCase("Form Four") ||
             (className.equalsIgnoreCase("LowerSixth"))) {
             return 25000;
         } else if ((className.equalsIgnoreCase("Form Five") || className.equalsIgnoreCase("UpperSixth"))) {
             return 35000;
         } else {
             return 0; // Default value
         }
     }
 
     private double calculateTutorials(String className) {
         if (className.equalsIgnoreCase("Form Five") ||
             className.equalsIgnoreCase("UpperSixth")) {
             return 10000;
         } else {
             return 0; // Default value
         }
     }
 
     private double calculateInternship(String className, String section) {
         if (className.equalsIgnoreCase("Form Five") && section.equalsIgnoreCase("Commercial")) {
             return 10000;
         } else if (className.equalsIgnoreCase("UpperSixth") && section.equalsIgnoreCase("Commercial")) {
             return 15000;
         } else {
             return 0; // Default value
         }
     }
 
     private double calculatePractical(String className, String section) {
         if ((className.equalsIgnoreCase("LowerSixth") || className.equalsIgnoreCase("UpperSixth")) && section.equalsIgnoreCase("Science")) {
             return 20000;
         } else {
             return 0; // Default value
         }
     }
 
     private double calculateProjectFee(String className, String section) {
         if (className.equalsIgnoreCase("UpperSixth") && section.equalsIgnoreCase("Science")) {
             return 10000;
         } else {
             return 0; // Default value
         }
     }
 
     public void addTeacher() {
         String insertData = "INSERT INTO teachers "
                 + "(Name, Sex, date_of_birth, national_id, subdivision_of_origin, Subject, phone_number, academic_year, age) "
                 + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
 
         // Connection connection = // Obtain your database connection here
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
 
     private void showAlert(String title, String content, AlertType alertType) {
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
 
 
 
     // Method to generate the yearly record and save it as a PDF
 // public void generateYearlyRecordPdf() {
 //     // Get the connection to the database
 //     Connection connect = Database.connectDb();
 //     String academicYear = getAcademicYearFromSettings();
 //     // Create the file path for the PDF
 //     String filePath = "C:\\Users\\POPOLY\\Documents\\Bah\\Yearly_Record_" + academicYear + ".pdf";
 
 //     try (PdfDocument pdf = new PdfDocument(new PdfWriter(filePath))) {
 //         PageSize landscape = PageSize.A4.rotate();
 //         Document document = new Document(pdf, landscape);
 
 //         // Define fonts and colors
 //         PdfFont headingFont = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
 //         PdfFont contentFont = PdfFontFactory.createFont(FontConstants.HELVETICA);
 //         DeviceRgb headingBgColor = new DeviceRgb(192, 192, 192);
 //         DeviceRgb cellBgColor = new DeviceRgb(224, 224, 224);
 
 //         // Add header
 //         Paragraph header = new Paragraph("Yearly Record - Academic Year " + academicYear)
 //                 .setFont(headingFont)
 //                 .setFontSize(18)
 //                 .setBackgroundColor(headingBgColor)
 //                 .setTextAlignment(com.itextpdf.layout.property.TextAlignment.CENTER);
 
 //         document.add(header);
 
 //         // Iterate through each month of the academic year
 //         LocalDate academicYearStartDate = LocalDate.of(academicYear, Month.SEPTEMBER, 1);
 //         LocalDate academicYearEndDate = academicYearStartDate.plusYears(1).minusDays(1);
 
 //         for (LocalDate currentDate = academicYearStartDate; !currentDate.isAfter(academicYearEndDate); currentDate = currentDate.plusMonths(1)) {
 //             LocalDate monthStartDate = currentDate.withDayOfMonth(1);
 //             LocalDate monthEndDate = currentDate.withDayOfMonth(currentDate.lengthOfMonth());
 
 //             // Create the table for the month
 //             Table table = new Table(2);
 //             table.setWidthPercent(100);
 //             table.addHeaderCell(new Cell().add(new Paragraph("Date-Day").setFont(headingFont).setBackgroundColor(cellBgColor)));
 //             table.addHeaderCell(new Cell().add(new Paragraph("Sum").setFont(headingFont).setBackgroundColor(cellBgColor)));
 
 //             // Database query to retrieve total payments from the "payments" table for the current month
 //             String selectPaymentsData = "SELECT payment_date, SUM(payment_amount) AS total_payment FROM payments WHERE payment_date BETWEEN ? AND ? GROUP BY payment_date";
 //             try (PreparedStatement prepare = connect.prepareStatement(selectPaymentsData)) {
 //                 prepare.setString(1, monthStartDate.toString());
 //                 prepare.setString(2, monthEndDate.toString());
 //                 try (ResultSet resultSet = prepare.executeQuery()) {
 //                     // Iterate through the results and add date-day and sum to the table
 //                     while (resultSet.next()) {
 //                         String paymentDate = resultSet.getString("payment_date");
 //                         double totalPayment = resultSet.getDouble("total_payment");
 
 //                         // Format the date to display as "yyyy-MM-dd (Day)"
 //                         LocalDate date = LocalDate.parse(paymentDate);
 //                         String formattedDate = date + " (" + date.getDayOfWeek() + ")";
 
 //                         table.addCell(new Cell().add(new Paragraph(formattedDate).setFont(contentFont)));
 //                         table.addCell(new Cell().add(new Paragraph(String.valueOf(totalPayment)).setFont(contentFont)));
 //                     }
 //                 }
 //             } catch (SQLException e) {
 //                 e.printStackTrace();
 //             }
 
 //             // Add the table to the document
 //             document.add(new Paragraph("Month: " + currentDate.getMonth()).setFont(headingFont));
 //             document.add(table);
 //             document.add(new Paragraph("")); // Add a blank line after each month table
 //         }
 
 //         // Add summary table for the entire academic year
 //         double yearlyTotalPayments = calculateYearlyTotalPayments();
 //         Table summaryTable = new Table(2);
 //         summaryTable.setWidthPercent(100);
 //         summaryTable.addCell(new Cell().add(new Paragraph("Total for the academic year:").setFont(contentFont).setBold()));
 //         summaryTable.addCell(new Cell().add(new Paragraph(String.valueOf(yearlyTotalPayments)).setFont(contentFont).setBold()));
 
 //         document.add(new Paragraph("Summary for the Academic Year").setFont(headingFont));
 //         document.add(summaryTable);
 
 //         document.close();
 
 //         System.out.println("Yearly record PDF generated successfully!");ad
 //     } catch (Exception e) {
 //         e.printStackTrace();
 //     }
 
 
 
     // SORRY ABOUT THAT, I JUST NAMED THE DIFFERENT COMPONENTS WITH THE SAME NAME 
     // MAKE SURE THAT THE NAME YOU GAVE TO THEM ARE DIFFERENT TO THE OTHER OKAY?
     @Override
     public void initialize(URL location, ResourceBundle resources) {
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
         teacherShowListData();
         showAllClassListData();
         displayOwing();
         displayExpected();
         displayTotalOwing();
         displaySchoolName();
         displayPrincipal();
         displayAddress();
         teacherShowListData();
         displaySchoolYear();
         addStudentsGenderList();
         getAcademicYearFromSettings();
         showClassListData();
         recordDailyTotalPaid();
         displayWeeklyTotalPayments();
         // addStudentsStatusList();
         // addStudentsCourseList();
         classYear();
         category();
         
         // handleAcademicYearSelection();
         // showClassInfo();
 
         // availableCourseShowListData();
 
         // studentGradesShowListData();
 
         // addClass_year.getItems().add(year);
         try {
             // Call the method to populate the academic year ComboBox with unique values from the database
             String selectedYear = getAcademicYearFromSettings();
             showClassesForYear(selectedYear);
         } catch (SQLException e) {
             // Handle any exceptions that might occur while fetching data from the database
             e.printStackTrace();
         }
         
     }
 
 }