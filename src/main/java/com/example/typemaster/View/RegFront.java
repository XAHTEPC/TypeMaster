package com.example.typemaster.View;

import com.example.typemaster.Data.Crypto;
import com.example.typemaster.Data.Postgre;
import com.example.typemaster.Front;
import com.example.typemaster.GameLogic.Toast;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class RegFront {
    static Button reg;


    public static Pane getStartFront() throws FileNotFoundException {
        Pane pane = new Pane();
        pane.setLayoutX(0);
        pane.setLayoutY(0);
        FileInputStream Url;
        if(Front.theme ==1)
            Url = new FileInputStream("png/reg_day.png");
        else
            Url = new FileInputStream("png/reg_night.png");
        Image url = new Image(Url);
        ImageView front = new ImageView(url);
        front.setX(0);
        front.setY(0);
        pane.getChildren().add(front);
        TextField input_login = new TextField();
        input_login.setMinWidth(600);
        input_login.setMaxWidth(600);
        input_login.setMinHeight(100);
        input_login.setMaxHeight(100);
        input_login.setLayoutX(330);
        input_login.setLayoutY(178);
        input_login.setPromptText("login");
        input_login.setFont(Font.font("STXihei", 20));
        input_login.setBackground(null);
        pane.getChildren().add(input_login);

        PasswordField passwordField = new PasswordField();
        passwordField.setPrefSize(600,100);
        passwordField.setBackground(null);
        passwordField.setPromptText("password");
        passwordField.setLayoutX(330);
        passwordField.setLayoutY(355);
        passwordField.setFont(Font.font("STXihei", 20));
        pane.getChildren().add(passwordField);

        PasswordField passwordField2 = new PasswordField();
        passwordField2.setPrefSize(600,100);
        passwordField2.setBackground(null);
        passwordField2.setPromptText("password");
        passwordField2.setLayoutX(330);
        passwordField2.setLayoutY(532);
        passwordField2.setFont(Font.font("STXihei", 20));
        pane.getChildren().add(passwordField2);
        if(Front.theme == 2){
            passwordField2.setStyle("-fx-text-fill: rgb(129, 127, 127);");
            passwordField.setStyle("-fx-text-fill: rgb(129, 127, 127);");
            input_login.setStyle("-fx-text-fill: rgb(129, 127, 127);");
        }

        reg = new Button();
        reg.setBackground(null);
        reg.setLayoutX(296);
        reg.setLayoutY(665);
        reg.setMaxSize(389,100);
        reg.setMinSize(389,100);
        pane.getChildren().add(reg);

        reg.setOnAction(t ->{
            Boolean flag = true;
            try {
                flag = Postgre.checkLogin(input_login.getText());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if(passwordField.getText().equals(passwordField2.getText()) && !passwordField.getText().isEmpty()
                    && !input_login.getText().isEmpty() && flag){
                try {
                    byte[] salt = new byte[3];
                    String pass = Crypto.hash(passwordField.getText(),salt);
                    Postgre.addUser(input_login.getText(),pass);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                Front.mainMenu();
            } else if(input_login.getText().isEmpty()){
                Toast.show("Введите логин!", pane, 160, 700);
            }else if(!flag){
                Toast.show("Данный логин занят!", pane, 160, 700);
                input_login.setText("");
            }
            else if(passwordField.getText().isEmpty()){
                Toast.show("Введите пароль!",pane,340, 700);
                passwordField.setText("");
                passwordField2.setText("");
            }
            else{
                Toast.show("Пароли не совпадают!",pane,340,700);
                passwordField.setText("");
                passwordField2.setText("");
            }
        });

        Button back = new Button();
        back.setLayoutY(665);
        back.setLayoutX(703);
        back.setMaxSize(200,100);
        back.setMinSize(200,100);
        back.setBackground(null);
        pane.getChildren().add(back);
        back.setOnAction(t1 ->{
            Front.root.getChildren().remove(Front.pane);
            try {
                Front.pane = StartFront.getStartFront();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            Front.root.getChildren().add(Front.pane);
        });

        Button changeTheme = new Button();
        changeTheme.setBackground(null);
        changeTheme.setLayoutX(1074);
        changeTheme.setLayoutY(666);
        changeTheme.setMaxSize(100,100);
        changeTheme.setMinSize(100,100);
        pane.getChildren().add(changeTheme);
        changeTheme.setOnAction(t1 ->{
            if(Front.theme==1)
                Front.theme++;
            else
                Front.theme = 1;
            Front.root.getChildren().remove(Front.pane);
            try {
                Front.pane = getStartFront();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            Front.root.getChildren().add(Front.pane);
        });

        return pane;
    }

}
