package model;

/**
 * @author Grupo 11 - Paradigmas de programación
 */

import java.util.ArrayList;

public class WordRacer {
    
    // Almacena las palabras ingresadas por el jugador
    private ArrayList<String> insertedWords;
    public Word word;
    
    /**
     * Constructor: inicializa el juego
     */
    public WordRacer() {
        insertedWords = new ArrayList<>();
        word = new Word();
        
    }
    
    /**
     * Método para insertar las palabras ingresadas por el jugador
     * @param w to add the word
     */
    public void addWord(String w) {
        insertedWords.add(w);
    }
    
    /**
     * Método para obtener las palabras ingresadas por los jugadores
     * @return insterdeWords by players
     */
    public ArrayList<String> getInsertedWords(){
        return insertedWords;
    }

    
}
