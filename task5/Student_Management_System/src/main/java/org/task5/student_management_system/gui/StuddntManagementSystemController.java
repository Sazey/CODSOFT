package org.task5.student_management_system.gui;

//import com.gluonhq.charm.glisten.control.TextField;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class StuddntManagementSystemController {

    @FXML
    private TableColumn<?, ?> address_col;

    @FXML
    private TableColumn<?, ?> d_o_b_col;

    @FXML
    private TableColumn<?, ?> email_col;

    @FXML
    private TableColumn<?, ?> enrollment_date_col;

    @FXML
    private TableColumn<?, ?> first_name_col;

    @FXML
    private TableColumn<?, ?> last_name_col;

    @FXML
    private AnchorPane main_window;

    @FXML
    private TableColumn<?, ?> mobile_number_col;

    @FXML
    private TableColumn<?, ?> student_id_col;

    @FXML
    private TextField student_serach;

    @FXML
    private TableView<?> students_view_table;

}
