package jailbreak;

import environment.Direction;
import environment.Environment;
import environment.GraphicsPalette;
import environment.Grid;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sabrina
 */
public class JailBreakEnvironment extends Environment {

    private Grid grid;

    public JailBreakEnvironment(Image background) {
        super(background);

    }

    @Override
    public void initializeEnvironment() {
        
    }

    @Override
    public void timerTaskHandler() {
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
    }

    @Override
    public void paintEnvironment(Graphics graphics) {
//        Font font = new Font("Tahoma", Font.BOLD, 28);
        this.grid.paintComponent(graphics);
    }
}
