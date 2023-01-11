module ru.fuzzy.meter {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires com.google.gson;



    opens ru.fuzzy.meter to javafx.fxml;
    exports ru.fuzzy.meter;
    exports ru.fuzzy.meter.controller;
    exports ru.fuzzy.meter.model;
    opens ru.fuzzy.meter.controller to javafx.fxml;
    opens ru.fuzzy.meter.model to com.google.gson;
}