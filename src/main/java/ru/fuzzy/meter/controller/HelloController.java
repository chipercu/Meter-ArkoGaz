package ru.fuzzy.meter.controller;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import ru.fuzzy.meter.HelloApplication;

public class HelloController {

    public static Stage getAddMeterStage() {
        return addMeterStage;
    }

    public static void setAddMeterStageNull() {
       addMeterStage = null;
    }

    private static Stage addMeterStage;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button editButton;

    @FXML
    private Pane mainPane;

    @FXML
    private Button meterButton;

    @FXML
    private Button nextButton;

    @FXML
    private TextArea ownerField;

    @FXML
    private Button prevButton;
    @FXML
    private MenuItem addNewOwnerMenu;

    @FXML
    private TextArea serialField;

    @FXML
    private Label timeLabel;
    @FXML
    private Label monthLabel;
    @FXML
    private TextArea meterData;

    @FXML
    void initialize() {
        Calendar calendar = Calendar.getInstance();
        String[] monthNames = { "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь" };
        String month = monthNames[calendar.get(Calendar.MONTH)];
        monthLabel.setText(month);
        timeLabel.setTextAlignment(TextAlignment.RIGHT);


        addNewOwnerMenu.setOnAction(actionEvent -> {
            if (addMeterStage == null){
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addNewMeter.fxml"));
                    addMeterStage = new Stage();
                    addMeterStage.setScene(new Scene(fxmlLoader.load(), 180, 140));
                    addMeterStage.setResizable(false);
                    addMeterStage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        editButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (serialField.isEditable()){
                serialField.setEditable(false);
                ownerField.setEditable(false);
                editButton.setText("Ред.");
            }else {
                serialField.setEditable(true);
                ownerField.setEditable(true);
                editButton.setText("Сохр.");
            }

        });


        new AnimationTimer() {
            @Override
            public void handle(long l) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy  HH:mm:ss");
                String format = sdf.format(new Date());
                timeLabel.setText(format);
            }
        }.start();
    }

}
