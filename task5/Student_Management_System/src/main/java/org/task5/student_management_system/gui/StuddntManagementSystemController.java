package org.task5.student_management_system.gui;

//import com.gluonhq.charm.glisten.control.TextField;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.task5.student_management_system.Main;
import org.task5.student_management_system.dao.StudentDAO;
import org.task5.student_management_system.model.Student;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class StuddntManagementSystemController implements Initializable {

    private StudentDAO studentDAO;

    @FXML
    private TableColumn<Student, String> address_col;

    @FXML
    private TableColumn<Student, String> d_o_b_col;

    @FXML
    private TableColumn<Student, String> email_col;

    @FXML
    private TableColumn<Student, String> enrollment_date_col;

    @FXML
    private TableColumn<Student, String> first_name_col;

    @FXML
    private TableColumn<Student, String> last_name_col;

    @FXML
    private AnchorPane main_window;

    @FXML
    private TableColumn<Student, String> mobile_number_col;

    @FXML
    private TableColumn<Student, String> student_id_col;

    @FXML
    private TextField student_search;

    @FXML
    private TableView<Student> students_view_table;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        refreshData();
    }

    @FXML
    public void createStudent(ActionEvent event) throws IOException {
        Stage parentStage = (Stage)((Node)event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/add_student_window.fxml"));
        Parent parent = (Parent) loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(parentStage);
        stage.show();
    }

    @FXML
    public void refreshData(){
        studentDAO = new StudentDAO();
        List<Student> students = studentDAO.getAllStudents();
        System.out.println(students);
        student_id_col.setCellValueFactory(data ->{
            return new SimpleStringProperty(String.valueOf(data.getValue().getStudentId()));
        });
        first_name_col.setCellValueFactory(data ->{
            return new SimpleStringProperty(data.getValue().getfirst_name());
        });
        last_name_col.setCellValueFactory(data -> {
            return new SimpleStringProperty(data.getValue().getlast_name());
        });
        email_col.setCellValueFactory(data ->{
            return new SimpleStringProperty(data.getValue().getEmail());
        });
        address_col.setCellValueFactory(data ->{
            return new SimpleStringProperty(data.getValue().getAddress());
        });
        mobile_number_col.setCellValueFactory(data ->{
            return new SimpleStringProperty(data.getValue().getcontact_number());
        });
        enrollment_date_col.setCellValueFactory(data ->{
            return new SimpleStringProperty(data.getValue().getenrollment_date());
        });
        d_o_b_col.setCellValueFactory(data ->{
            return new SimpleStringProperty(data.getValue().getd_o_b());
        });
        ObservableList<Student> students_in_system = students_view_table.getItems();
        students_in_system.clear();
        students_in_system.addAll(students);
        students_view_table.setItems(students_in_system);
    }

    @FXML
    public void removeStudent(){
        Student student = students_view_table.getSelectionModel().getSelectedItem();
        studentDAO.deleteStudent(student.getStudentId());
        refreshData();
    }
}
