package com.example.typemaster.View;

import com.example.typemaster.Front;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class StartFront {
    static Button enter;
    public static TextField input_login;

    public static PasswordField passwordField;

    static Button reg;
    public static Pane getStartFront() throws FileNotFoundException {
        Pane pane = new Pane();
        pane.setLayoutX(0);
        pane.setLayoutY(0);
        FileInputStream Url;
        if(Front.theme==1)
           Url = new FileInputStream("png/intro_day.png");
        else
            Url = new FileInputStream("png/intro_night.png");
        Image url = new Image(Url);
        ImageView front = new ImageView(url);
        front.setX(0);
        front.setY(0);
        pane.getChildren().add(front);

        input_login = new TextField();
        input_login.setMinWidth(600);
        input_login.setMaxWidth(600);
        input_login.setMinHeight(100);
        input_login.setMaxHeight(100);
        input_login.setLayoutX(320);
        input_login.setLayoutY(300);
        input_login.setPromptText("login");
        input_login.setFont(Font.font("STXihei", 20));
        input_login.setBackground(null);
        pane.getChildren().add(input_login);

        passwordField = new PasswordField();
        passwordField.setPrefSize(600,100);
        passwordField.setBackground(null);
        passwordField.setPromptText("password");
        passwordField.setLayoutX(320);
        passwordField.setLayoutY(477);
        passwordField.setFont(Font.font("STXihei", 20));
        pane.getChildren().add(passwordField);
        if(Front.theme == 2){
            passwordField.setStyle("-fx-text-fill: rgb(129, 127, 127);");
            input_login.setStyle("-fx-text-fill: rgb(129, 127, 127);");
        }

        enter = new Button();
        enter.setBackground(null);
        enter.setLayoutX(300);
        enter.setLayoutY(654);
        enter.setMaxSize(225,100);
        enter.setMinSize(225,100);
        enter.setOnAction(t->{
            try {
                if(Front.login())
                    Front.mainMenu();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        pane.getChildren().add(enter);

        reg = new Button();
        reg.setBackground(null);
        reg.setLayoutX(570);
        reg.setLayoutY(654);
        reg.setMaxSize(330,100);
        reg.setMinSize(330,100);
        reg.setOnAction(t->{
            try {
                Front.registration();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        pane.getChildren().add(reg);


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
