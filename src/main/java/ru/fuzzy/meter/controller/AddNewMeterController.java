package ru.fuzzy.meter.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;
import ru.fuzzy.meter.HelloApplication;

public class AddNewMeterController {
    private Pattern p = Pattern.compile("(\\d+\\.?\\d*)?");

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField currentData;

    @FXML
    private TextField owner;

    @FXML
    private Button save;

    @FXML
    private TextField serial;

    @FXML
    private Button cancel;

    @FXML
    void initialize() {

        cancel.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {

            final Stage stage = (Stage) cancel.getScene().getWindow();
            stage.close();
            HelloController.setAddMeterStageNull();
        });


        currentData.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) currentData.setText(oldValue);
        });



    }

}
