package com.example.typemaster.GameLogic;

import com.example.typemaster.Data.EngWord;
import com.example.typemaster.Data.RusWord;
import com.example.typemaster.Front;
import com.example.typemaster.KeyBoard.EnBoard;
import com.example.typemaster.KeyBoard.RusBoard;
import com.example.typemaster.GameLogic.TimeCounter;
import com.example.typemaster.View.EngMode;
import com.example.typemaster.View.RusMode;
import com.example.typemaster.View.ScoreFront;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class GameEng {
    static ArrayList<String> engWord = com.example.typemaster.Data.EngWord.getEnMas();
    static int e;
    static String word;
    static char[] str;
    static int kol = 0;
    static int fl = 0;
    static Rectangle rectangle = new Rectangle();
    static Random random = new Random();
    public static void start(Scene scene) throws InterruptedException {
        TimeCounter.startTimer();
        e = random.nextInt(1000);
        word = engWord.get(e);
        Score.StartScore();
        fl = 0;
        kol = 0;
        str = word.toCharArray();
        EngMode.EngText.setText(word);
        rectangle = EnBoard.getRect(str[0]);
        EngMode.paneEng_Board.getChildren().add(rectangle);
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
                    printWord(keyEvent.getCharacter());
                }
                else if(fl==0) {
                    fl++;
                    Front.root.getChildren().remove(Front.pane);
                    try {
                        Front.pane = ScoreFront.getScoreFront(1);
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
            if(kol==word.length()){
                kol=0;
                Score.addScore(word.length());
                e = random.nextInt(1000);
                word = engWord.get(e);
                str = word.toCharArray();
                EngMode.EngText.setText(word);
            }
            EngMode.paneEng_Board.getChildren().remove(rectangle);
            rectangle = EnBoard.getRect(str[kol]);
            rectangle.setFill(null);
            if(Front.theme==1)
                rectangle.setStroke(Color.rgb(255,184,0));
            else
                rectangle.setStroke(Color.rgb(169,110,228));
            rectangle.setStrokeWidth(3);
            EngMode.paneEng_Board.getChildren().add(rectangle);
        }
        else{
            TimeCounter.subTime();
        }
    }
}
