module Data.Structures.and.Algorhtythems.CA1.Eric.Butler {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;
    requires org.junit.jupiter.api;
    requires xstream;


    opens sample to javafx.fxml, xstream;
    exports sample;
}