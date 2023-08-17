package com.example.typemaster.GameLogic;

import com.example.typemaster.Front;
import com.example.typemaster.KeyBoard.RusBoard;
import com.example.typemaster.Text.Text1;
import com.example.typemaster.Text.Text2;
import com.example.typemaster.Text.Text3;
import com.example.typemaster.View.RusMode;
import com.example.typemaster.View.ScoreFront;
import com.example.typemaster.View.TextMode;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Random;

public class GameText {
    static int e;
    static String word;
    static char[] str;
    static int kol = 0;
    static int fl = 0;
    static Rectangle rectangle = new Rectangle();
    public static Rectangle rectShift = new Rectangle(788, 202, 134, 54) ; //shift

    static Random random = new Random();
    static String[] allText;
    public static void start(Scene scene) throws InterruptedException {
        rectShift.setFill(null);
        if(Front.theme==1)
            rectShift.setStroke(Color.rgb(255,184,0));
        else
            rectShift.setStroke(Color.rgb(249,110,228));
        rectShift.setStrokeWidth(3);
        TimeCounter.startTimer();
        e = random.nextInt(3)+1;
        if(e==1) {
            allText = Text1.text;
        }
        else if(e==2) {
            allText = Text2.text;
        }
        else
            allText = Text3.text;
        Score.StartScore();
        fl = 0;
        kol = 0;
        int eMax = allText.length;
        e=0;
        word = allText[e];
        str = word.toCharArray();
        TextMode.RusText.setText(word);
        if(RusBoard.check(str[kol])) {
            TextMode.paneRus_Board.getChildren().add(rectShift);
        }
        rectangle = RusBoard.getRect(str[0]);
        TextMode.paneRus_Board.getChildren().add(rectangle);
        rectangle.setFill(null);
        if(Front.theme==1)
            rectangle.setStroke(Color.rgb(255,184,0));
        else
            rectangle.setStroke(Color.rgb(169,110,228));
        rectangle.setStrokeWidth(3);
        Scene newScene = scene;

        newScene.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (TimeCounter.time[0] > 0) {
                    System.out.println("символ:"+ keyEvent.getCharacter());
                    printWord(keyEvent.getCharacter());
                }
                else if(fl==0) {
                    fl++;
                    Front.root.getChildren().remove(Front.pane);
                    try {
                        Front.pane = ScoreFront.getScoreFront(3);
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    Front.root.getChildren().add(Front.pane);
                }
                newScene.removeEventHandler(KeyEvent.ANY,this);
            }

        });
    }

    public static void printWord(String el){
        if(el.equals(String.valueOf(str[kol]))){
            kol++;
            if(kol==word.length()-1){
                kol=0;
                Score.addScore(word.length());
                e++;
                if(e!=allText.length) {
                    word = allText[e];
                    str = word.toCharArray();
                    TextMode.RusText.setText(word);
                }

            }

            TextMode.paneRus_Board.getChildren().remove(rectShift);
            TextMode.paneRus_Board.getChildren().remove(rectangle);
            if(RusBoard.check(str[kol])) {
                TextMode.paneRus_Board.getChildren().add(rectShift);
            }
            rectangle = RusBoard.getRect(str[kol]);
            rectangle.setFill(null);
            if(Front.theme==1)
                rectangle.setStroke(Color.rgb(255,184,0));
            else
                rectangle.setStroke(Color.rgb(169,110,228));
            rectangle.setStrokeWidth(3);
            TextMode.paneRus_Board.getChildren().add(rectangle);
        }
        else{
            TimeCounter.subTime();
        }
    }
}


