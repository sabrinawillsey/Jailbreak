/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JailBreak;

import environment.Actor;
import environment.Velocity;
import java.awt.Image;
import java.awt.Point;

public class Prisoner extends Actor {

    public Prisoner(Image image, Point position, Velocity velocity) {
        super(position, velocity);
        this.setImage(image);
    }

    public Prisoner(Point position, Velocity velocity) {
        super(position, velocity);
    }
}