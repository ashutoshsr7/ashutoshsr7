package com.dodreamsdigital.connect4;

import javafx.application.Application;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class Main extends Application {

    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane = loader.load();

        controller = loader.getController();
        controller.createPlayground();

        MenuBar menuBar = createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());


        Pane menuPane  = (Pane) rootGridPane.getChildren().get(0);

        menuPane.getChildren().add(menuBar);


        Scene scene = new Scene(rootGridPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect4");
        primaryStage.setResizable(false);
        primaryStage.show();



    }

    private MenuBar createMenu(){


        //file menu
        Menu fileMenu = new Menu("File");


        MenuItem newGame = new MenuItem("New Game");                // action Menu
        newGame.setOnAction(event -> controller.resetGame());


        MenuItem resetGame =  new MenuItem("Reset Game");       //action Reset
        resetGame.setOnAction(event -> controller.resetGame());


        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

        MenuItem exitGame = new MenuItem("Exit Game");              //action Reset
        exitGame.setOnAction(event -> exitGame());

        fileMenu.getItems().addAll(newGame, resetGame,separatorMenuItem ,exitGame);



        // Help Menu

        Menu helpMenu = new Menu("Help");

        MenuItem aboutGame = new MenuItem("About Connect4 ");
        aboutGame.setOnAction(event -> aboutConnect4());

        SeparatorMenuItem separator = new SeparatorMenuItem();

        MenuItem aboutMe = new MenuItem("About Me");
        aboutMe.setOnAction(event -> aboutGame() );



        helpMenu.getItems().addAll(aboutGame,aboutMe);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        return menuBar;



    }

    private void aboutGame() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About the Developer");
        alert.setHeaderText("Ashutosh Sr");
        alert.setContentText("Hello!!! \n" +
		        "I am Ashutosh.\n" +
		        "I love to Play around with code and create games" +
                "Connect4 is one of them. " +
		        "In free time , I like to spend time with nears and dears." +
		        " Hope! You are enjoying this game with friends." +
		        "\n" +
		        "\n" +
		        "                        ****** Har Har Mahadev ******");
        alert.show();

    }

    private void aboutConnect4() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect4");
        alert.setHeaderText("How to Play ?");
        alert.setContentText("Connect Four is a two-Player Connection game in which\n "+
                "* The Player first Choose a color and then takes turn drooping colored discs"+
                "   from the top into a Seven-column , six-row vertically suspended grid.\n " +
                "* The pieces fall through Straight Down  and Occupying the next available spaces within in the column \n"+
                "* The objective of the game is be the first to form a Horizontal , vertical " +"" +
                "  or diagonal line of the four of one's own discs. Connect Four is a Solved game \n" +
                "* The first player can always win by playing the right moves\n");

        alert.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    private void resetGame() {


    }


    public static void main(String[] args) {
        launch(args);
    }
}
