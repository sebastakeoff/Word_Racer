/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import model.Player;
import java.util.Scanner;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author   Grupo 11 - Paradigmas de programación
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("/view/FXMLDocument.fxml"));
//        //Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLDocument.fxml"));
//        //loader.setController("/controller/Controller.java");
//        
//        Pane window = (Pane) loader.load();
//        
//        Scene scene = new Scene(window);
//        
//        stage.setScene(scene);
//        stage.show();
        
        
       try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/FXMLDocument.fxml"));
            // Cargo la ventana
            Pane ventana = (Pane) loader.load();
 
            // Cargo el scene
            Scene scene = new Scene(ventana);
 
            // Seteo la scene y la muestro
            stage.setScene(scene);
            stage.setTitle("Word-Racer   V0.1");
            stage.getIcons().add(new Image(Main.class.getResourceAsStream("/img/launch.png")));
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
         
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       // Debug porpose. To show the game in console
        boolean console = false;
        
        if(!console){
            launch(args);
        } else {
            Scanner s = new Scanner(System.in);

            Player p1 = new Player("Jugador1");
            Player p2 = new Player("Jugador2");
            Player current;

            int players = 2;
            int time = 2;
            int gameInstances = 0;

            do {

                if(gameInstances != 0) {
                    System.out.println("Hubo empate!!! A la revancha!!");
                }

                for(int i = 0; i < players; i++) {
                    if(i == 0) current = p1;
                    else current = p2;


                    System.out.println("Usa las siguientes letras: " + current.game.word.getLetters());
                    System.out.println("Palabras disponibles: " + current.game.word.getDictionary().keySet());

                    for(int j = 0; j < time; j++) {
                        System.out.println(current.getName() + " ingresa tu palabra:");
                        String insertedWord = s.nextLine().toUpperCase();
                        current.game.addWord(insertedWord);
                        if(!current.game.word.isInLetters(insertedWord))
                            System.out.println("Debe utilizar las letras dadas");
                        else if(!current.game.word.searchWord(insertedWord))
                            System.out.println("No existe esa palabra");
                        else {
                            System.out.println("Correcto!");
                            current.setPoints();
                        }
                    }
                }
                gameInstances++;
            } while(p1.getPoints() == p2.getPoints());


            System.out.print("Jugador 1: " + p1.game.getInsertedWords());
            System.out.println(" puntos: " + p1.getPoints());
            System.out.print("Jugador 2: " + p2.game.getInsertedWords());
            System.out.println(" puntos: " + p2.getPoints());

            if(p1.getPoints() > p2.getPoints()) System.out.println("Ganó Jugador 1!");
            else System.out.println("Ganó Jugador 2!");
            
        }
    }
    
}
