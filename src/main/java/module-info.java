module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires opencsv;
    requires java.sql;

    opens org.example;
    exports org.example;
}