package com.example.typemaster;

import com.example.typemaster.Data.Crypto;
import com.example.typemaster.Data.Postgre;
import com.example.typemaster.GameLogic.*;
import com.example.typemaster.View.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class Front extends Application {
    public static String password = "";
    public static int theme = 1;
    public static String login ="";

    public static String id = "";
    public static Pane pane;
    public static Group root;
    public static Scene scene;


    @Override
    public void start(Stage stage) throws FileNotFoundException {
        root = new Group();
        scene = new Scene(root, 1200, 800);
        stage.initStyle(StageStyle.DECORATED);
        pane = StartFront.getStartFront();
        root.getChildren().add(pane);

//        enter_start.setOnAction(t1 ->{
//            try {
//                if(login())
//                    mainMenu();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        });
//
//        reg_start.setOnAction(t1 ->{
//             try {
//                registration();
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//        });

        stage.setTitle("Project");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, ParseException {
        launch();
    }

    public static void registration() throws FileNotFoundException {
        root.getChildren().remove(pane);
        pane = RegFront.getStartFront();
        root.getChildren().add(pane);
    }

    public static boolean login() throws SQLException {
        login = StartFront.input_login.getText();
        password = StartFront.passwordField.getText();
//        Postgre postgre = new Postgre();
        byte[] salt = new byte[3];
        password = Crypto.hash(password,salt);
        id = Postgre.getID(login,password);
        if(id.equals("error")) {
            Toast.show("Неверный логин или пароль", pane, 240, 640);
            StartFront.passwordField.setText("");
            return false;
        }
        else {
            return true;
        }
    }
    public static void mainMenu(){
        root.getChildren().removeAll(pane);
        try {
            pane = MainFront.getStartFront();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        root.getChildren().add(pane);
//        MainFront.RusChar.setOnAction(t2->{
//            startRus();
//        });
//        MainFront.EngChar.setOnAction(t2->{
//            startEng();
//        });
//        MainFront.Text.setOnAction(t2->{
//            startText();
//        });
//        MainFront.Result.setOnAction(t2->{
//            result();
//        });
    }
    public static void startRus(){
        TimeCounter.time[0] = 60;
        Score.score = 0;
        root.getChildren().removeAll(pane);
        try {
            pane = RusMode.getStartFront();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        root.getChildren().add(pane);
        try {
            GameRus.start(scene);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void startEng(){
        TimeCounter.time[0] = 60;
        Score.score = 0;
        root.getChildren().removeAll(pane);
        try {
            pane = EngMode.getStartFront();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        root.getChildren().add(pane);
        try {
            GameEng.start(scene);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void startText(){
        TimeCounter.time[0] = 60;
        Score.score = 0;
        root.getChildren().removeAll(pane);
        try {
            pane = TextMode.getStartFront();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        root.getChildren().add(pane);
        try {
            GameText.start(scene);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void result(){
        root.getChildren().removeAll(pane);
        try {
            pane = ResultFront.getStartFront();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        root.getChildren().add(pane);
    }
}



