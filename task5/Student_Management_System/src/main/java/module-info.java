module org.task5.student_management_system {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;
    requires java.persistence;
    requires java.transaction;
    requires sqlite.dialect;
//    opens org.task5.student_management_system to javafx.fxml;
    opens org.task5.student_management_system;
    opens org.task5.student_management_system.model to javafx.fxml, org.hibernate.orm.core, javafx.base;
    opens org.task5.student_management_system.gui to javafx.fxml;
    opens org.task5.student_management_system.dao to java.transaction.xa;
//    opens org.task5.student_management_system.model;
    exports org.task5.student_management_system.gui to javafx.fxml;
}