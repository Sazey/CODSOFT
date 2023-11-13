package org.task5.student_management_system.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.task5.student_management_system.dao.StudentDAO;
import org.task5.student_management_system.model.Student;

import java.text.DateFormat;

public class AddStudentController {

    @FXML
    private TextField adress;

    @FXML
    private Button create_button;

    @FXML
    private DatePicker d_o_b;

    @FXML
    private DatePicker enrollment_date;

    @FXML
    private TextField email;

    @FXML
    private TextField first_name;

    @FXML
    private TextField last_name;

    @FXML
    private TextField mobile_number;


    @FXML
    public void createStudent(ActionEvent event){
        StudentDAO studentDAO = new StudentDAO();
        String first_name = this.first_name.getText();
        String last_name = this.last_name.getText();
        String mobile_number = this.mobile_number.getText();
        String email = this.email.getText();
        String date = this.d_o_b.getValue().toString();
        String adress = this.adress.getText();
        String enrolled_date = this.enrollment_date.getValue().toString();

        Student student = new Student(
                first_name,
                last_name,
                mobile_number,
                email,
                date,
                adress,
                enrolled_date
        );

        studentDAO.addStudent(student);
//        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    }

}
