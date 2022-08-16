module application.crudjavafxjdbc {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.base;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;

    exports model.entities;
    opens model.entities to javafx.fxml;

    exports application;
    opens application to javafx.fxml, javafx.base;

    exports gui;
    opens gui to javafx.fxml, javafx.base;

    exports gui.util;
    opens gui.util to javafx.fxml;


}