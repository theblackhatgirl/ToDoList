module com.example.todolist {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.todolist to javafx.fxml;
    exports com.example.todolist;
}