package jailbreak;

import JailBreak.Prisoner;
import environment.Environment;
import environment.Velocity;
import image.ResourceTools;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class JailBreakEnvironment extends Environment {

    private int backgroundSpeed = 0;
    private Prisoner prisoner;
    private long jumpStartTimeMillis;
    private boolean jumping;

    public JailBreakEnvironment(Image background) {
        super(background);
    }

    @Override
    public void paintBackground(Graphics2D graphics2D) {
        graphics2D.drawImage(this.getBackgroundImage(), this.getBackgroundImagePosition().x, this.getBackgroundImagePosition().y, this);
        graphics2D.drawImage(this.getBackgroundImage(), this.getBackgroundImagePosition().x + this.getBackgroundImage().getWidth(this), this.getBackgroundImagePosition().y, this);
    }

    @Override
    public void initializeEnvironment() {

        this.prisoner = new Prisoner(ResourceTools.loadImageFromResource("resources/prisoner 3.png"), new Point(525, 325), new Velocity(0, 0));
        this.getActors().add(prisoner);
    }

    @Override
    public void timerTaskHandler() {
        this.getBackgroundImagePosition().x += this.backgroundSpeed;
        //test if background needs to be reset
        if (this.getBackgroundImagePosition().x <= -this.getBackgroundImage().getWidth(this)) {
            this.getBackgroundImagePosition().x = 0;
            System.out.println("reset");
        }

        //test if the prisoner is jumping, and stop fall if he is at or below the floor
        if (prisoner.getPosition().y > 325) {
            this.jumping = false;
            this.prisoner.getPosition().y = 325;
        }
        if (prisoner.getPosition().y < 0) {
            this.prisoner.getPosition().y = 0;
        }
        
        //has he been in the air for more than 2 seconds?
        if ((this.jumping ) && (System.currentTimeMillis() - this.jumpStartTimeMillis >= 600)){
            this.prisoner.getVelocity().y = 20;
        }
        
        
        if (prisoner.getPosition().y <= 325) {
        }
    }

    @Override
    public void keyPressedHandler(KeyEvent ke) {
//        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
//            this.prisoner.getVelocity().x = 8;
//        }
//        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
//            this.prisoner.getVelocity().x = -8;
//        }
        if (ke.getKeyCode() == KeyEvent.VK_S) {
            this.backgroundSpeed = -15;
        }
        //       if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
        //           this.backgroundSpeed = +7;
        //       }
        if ((ke.getKeyCode() == KeyEvent.VK_UP) && (this.jumping == false)){
            this.jumping = true;
            this.jumpStartTimeMillis = System.currentTimeMillis();
            this.prisoner.getVelocity().y = -30;
        }
        
        if ((ke.isControlDown()) && (ke.getKeyCode() == ke.VK_M)) {
            System.out.println("Menu");
            displayMenu();
        }
    }

    @Override
    public void keyReleasedHandler(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_UP) {
            this.prisoner.getVelocity().y = 30;
        }
//        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
//            this.prisoner.getVelocity().x = 0;
//        }
//        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
//            this.prisoner.getVelocity().x = 0;
//        }
        //      if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
        //          this.backgroundSpeed = 0;
        //      }
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
    }

    @Override
    public void paintEnvironment(Graphics graphics) {
//        Font font = new Font("Tahoma", Font.BOLD, 28);
//        this.grid.paintComponent(graphics);
    }

    private void displayMenu() {
        JDialog menu = new JDialog();
        menu.setModal(true);
        menu.setTitle("Game Configuration");
        
        ConfigurationMenu cm = new ConfigurationMenu();
        menu.add(cm);
        menu.setSize(new Dimension(270, 250));
        menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        menu.setVisible(true);
    }
}
