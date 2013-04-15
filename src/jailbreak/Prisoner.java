/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jailbreak;

import environment.Direction;
import environment.Grid;
import image.ResourceTools;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Sabrina
 */
public class Prisoner {
//    public void draw(Graphics graphics) {
//                    graphics.drawImage(ResourceTools.loadImageFromResource("resources/prisoner.jpg"), 550, 100, 200, 300, Color.yellow, null);
//    }
//    private ArrayList<Point> body = new ArrayList<Point>();
     public void move() {
        if (this.body != null) {
            this.body.remove(this.body.size() - 1);

//            if (this.direction == Direction.RIGHT) {
//                this.body.add(0, new Point(getHead().x + 1, getHead().y));
//            } else if (this.direction == Direction.LEFT) {
//                this.body.add(0, new Point(getHead().x - 1, getHead().y));
//            } 
        }
   }

    public void grow(int increase) {
        for (int i = 0; i < increase; i++) {
            this.body.add(new Point(Integer.MIN_VALUE, Integer.MIN_VALUE));
        }
    }

    public void shrink(int decrease) {
        for (int i = 0; i < decrease; i++) {
            this.body.remove(this.body.size()-1);
        }
    }
    public Point getHead() {
        return this.body.get(HEAD_INDEX);
    }

    public boolean hitTest(ArrayList<Point> locations) {
//          return true if the head of the snake intersects with any of the locations
        for (Point location : locations) {
            if (this.getHead().equals(location)) {
                return true;
                
            }

        }
        return false;
        
      
    }
//    public void draw(Graphics graphics) {
//        Point bodyPartLocation;
//        if (body != null) {        //(0,1)
//            graphics.setColor(color);
//            for (int i = 0; i < body.size(); i++) {
//                //draw each part of the snake
////                bodyPartLocation = grid.getCellPosition(body.get(i));
//                if (i == 0) {
//                    //draw head
//                    graphics.fillRect(bodyPartLocation.x, bodyPartLocation.y, 200, 300);
//                } else { //draw body
//                    graphics.setColor(this.color);
//                    graphics.fillOval(bodyPartLocation.x, bodyPartLocation.y, 200, 300);
//
//                }
//            }
//        }
//    }
    //</editor-fold>
// <editor-fold defaultstate="collapsed" desc="Constructors">    
//    private Direction direction = Direction.RIGHT;
    private final int HEAD_INDEX = 0;
    private ArrayList<Point> body = new ArrayList<Point>();
    private Color color = Color.RED;

//    public ASnake(ArrayList<Point> body) {
//        this.body = body;
//    }
// </editor-fold>    
// <editor-fold defaultstate="collapsed" desc="Properties">

    /**
     * @return the body
     */
    public ArrayList<Point> getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(ArrayList<Point> body) {
        this.body = body;
    }

    /**
     * @return the direction
     */
//    public Direction getDirection() {
//        return direction;
//    }
//
//    /**
//     * @param direction the direction to set
//     */
//    public void setDirection(Direction direction) {
//        this.direction = direction;
//    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }
    //  </editor-fold>
}

     
//}
