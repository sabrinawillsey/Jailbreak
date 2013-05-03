/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jailbreak;

/**
 *
 * @author Thomas
 */
public class ConfigurationData {
    private String name = "";
    private Difficulty difficulty = Difficulty.EASY;

    /**
     * @return the difficulty
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }

    /**
     * @param difficulty the difficulty to set
     */
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
