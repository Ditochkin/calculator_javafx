package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class Calculator extends Application {
    private Button shortButton(String nameBtn)
    {
        Button btn = new Button(nameBtn);
        btn.setMinWidth(60);
        btn.setMinHeight(50);
        btn.setFont(new Font(20));
        return btn;
    }

    private Button longButton(String nameBtn)
    {
        Button btn = new Button(nameBtn);
        btn.setMinWidth(135);
        btn.setMinHeight(50);
        btn.setFont(new Font(20));
        return btn;
    }

    private void AlexeyButton(Button btn)
    {
        btn.setMinWidth(12);
        btn.setMinHeight(12);
    }

    @Override
    public void start(Stage stage) throws IOException
    {
        Integer marg = 12;
        HBox row1 = new HBox(marg);
        row1.setAlignment(Pos.CENTER);
        Button button1 = shortButton("1");
        Button button2 = shortButton("2");
        Button button3 = shortButton("3");
        Button buttonDiv = shortButton("/");
        row1.getChildren().addAll(button1, button2, button3, buttonDiv);

        HBox row2 = new HBox(marg);
        row2.setAlignment(Pos.CENTER);
        Button button4 = shortButton("4");
        Button button5 = shortButton("5");
        Button button6 = shortButton("6");
        Button buttonMul = shortButton("*");
        row2.getChildren().addAll(button4, button5, button6, buttonMul);

        HBox row3 = new HBox(marg);
        row3.setAlignment(Pos.CENTER);
        Button button7 = shortButton("7");
        Button button8 = shortButton("8");
        Button button9 = shortButton("9");
        Button buttonMinus = shortButton("-");
        row3.getChildren().addAll(button7, button8, button9, buttonMinus);

        HBox row4 = new HBox(marg);
        row4.setAlignment(Pos.CENTER);
        Button button0 = longButton("0");
        Button buttonEq = shortButton("=");
        Button buttonPlus = shortButton("+");
        row4.getChildren().addAll(button0, buttonEq, buttonPlus);

        Label text = new Label();
        text.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        text.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
        text.setMinWidth(button1.getMinWidth() * 4 + marg * 3);
        text.setMinHeight(65);

        VBox root = new VBox(marg);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(text, row1, row2, row3, row4);

        Scene scene = new Scene(root, 300, 380, Color.KHAKI);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        scene.getWidth();
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
