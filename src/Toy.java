//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Toy
// Course: CS 300 Spring 2024
//
// Author: Muhammad Naheel
// Email: naheel@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////////// ASSISTANCE/HELP CITATIONS ////////////////////////////
//
// Persons: None
// Online Sources: None
//
///////////////////////////////////////////////////////////////////////////////


import java.io.File;
import processing.core.PImage;

public class Toy {

    // These are the fields.
    public final PImage IMAGE;
    private int x;
    private int y;
    private boolean isDragging;
    private int rotations;

    // These are the constructors with specified positions.
    public Toy(String name, int x, int y) {
        this.x = x;
        this.y = y;
        this.isDragging = false;
        this.rotations = 0;
        this.IMAGE = Utility.loadImage("images" + File.separator + name + ".png");
    }

    // This is a constructor with default center position
    public Toy(String name) {
        this(name, Utility.width() / 2, Utility.height() / 2);
    }

    /**
     * Getter method for x-coordinate of the toy.
     * 
     * @return x x-coordinate of the toy.
     */
    public int getX() {
        return x;
    }

    /**
     * This method sets the x-coordinate of the toy to the x-coordinate found from the getX method. 
     * @param x x-coordinate of the toy.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Getter method for y-coordinate of the toy.
     * 
     * @return y y-coordinate of the toy.
     */
    public int getY() {
        return y;
    }

    /**
     * This method sets the y-coordinate of the toy to the y-coordinate found from the getX method. 
     * @param x x-coordinate of the toy.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Getter method for number of rotations of toy.
     * 
     * @return rotations Number of rotations of toy.
     */
    public int getRotationsCount() {
        return rotations;
    }

    /**
     * Getter method which gets the current boolean value of the isDragging variable.
     * 
     * @return isDragging variable either True or False.
     */
    public boolean isDragging() {
        return isDragging;
    }

    /**
     * Setter method which sets the isDragging variable to True when called upon.
     */
    public void startDragging() {
        isDragging = true;
    }

    /**
     * Setter method which sets the isDragging variable to False when called upon.
     */
    public void stopDragging() {
        isDragging = false;
    }

    /**
     * This method increments the variable rotations which is the number of rotations of toy by 1
     * each time it is called.
     * 
     */
    public void rotate() {
        rotations = (rotations + 1);
    }

    /**
     * This method moves the toy. It adds dx and dy values to the x and y fields, respectively.
     * If the updated x or y value is outside the bounds of the window, it is reset to the closest
     * value which is inside the window.
     * 
     * @param dx integer value and the distance from previous x-coordinate to current.
     * @param dy integer value and the distance from previous y-coordinate to current.
     */
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
        
        x = Math.max(0, Math.min(x, Utility.width() - getWidth()));
        y = Math.max(0, Math.min(y, Utility.height() - getHeight()));
    }

    /**
     * This method first updates the position of the toy using move method if it is dragging and
     * then draws the toy at the new updates position. It moves the toy by the difference between
     * the current and previous positions.
     */
    public void draw() {
        if (isDragging) {
            int dx = Utility.mouseX() - Utility.pmouseX();
            int dy = Utility.mouseY() - Utility.pmouseY();
            move(dx, dy);
        }
        drawToyImage();
    }

    /**
     * Helper method to draw an image accounting for any rotations to the screen.
     * The implementation of this method is fully provided in the write-up.
     */
    private void drawToyImage() {
        Utility.pushMatrix();
        Utility.translate(x, y);
        Utility.rotate(this.rotations * Utility.PI / 2);
        Utility.image(IMAGE, 0.0f, 0.0f);
        Utility.popMatrix();
    }

    /**
     * This method checks if the mouse pointer is over a toy.
     * 
     * @param x x-coordinate of the toy.
     * @param y y-coordinate of the toy.
     * @return True if the mouse pointer is within the boundaries of the toy else returns false.
     */
    public boolean isOver(int x, int y) {
      int toyWidth = getWidth();
      int toyHeight = getHeight();
      return (x >= this.x - toyWidth / 2 && x <= this.x + toyWidth / 2 &&
              y >= this.y - toyHeight / 2 && y <= this.y + toyHeight / 2);
  }


    /**
     * This overloaded method checks whether the image of this toy overlaps with the image 
     * of the given furniture object.
     * 
     * @param other boundaries of the furniture object.
     * @return True if any point within the toy image is within the furniture image else 
     * returns false.
     */
    public boolean isOver(Furniture other) {

      if (this.IMAGE == null || other.IMAGE == null) {
          return false;
      }
      int toyWidth = getWidth();
      int toyHeight = getHeight();
      int furnitureWidth = other.IMAGE.width;
      int furnitureHeight = other.IMAGE.height;

      int toyLeft = x - toyWidth / 2;
      int toyRight = x + toyWidth / 2;
      int toyTop = y - toyHeight / 2;
      int toyBottom = y + toyHeight / 2;

      int furnitureLeft = other.getX() - furnitureWidth / 2;
      int furnitureRight = other.getX() + furnitureWidth / 2;
      int furnitureTop = other.getY() - furnitureHeight / 2;
      int furnitureBottom = other.getY() + furnitureHeight / 2;

      return toyRight >= furnitureLeft && toyLeft <= furnitureRight &&
              toyBottom >= furnitureTop && toyTop <= furnitureBottom;
  }



    /**
     * This method gets the width of the toy image. If the image is rotated odd times, the height
     * now becomes the width of this image.
     * 
     * @return width of image if the number of rotations is even else returns height of image if
     * number of rotations is odd.
     */
    private int getWidth() {
      if (rotations % 2 == 0) {
          return IMAGE.width;
      } else {
          return IMAGE.height;
      }
  }


    /**
     * This method gets the height of the toy image. If the image is rotated even times, the width
     * now becomes the height of this image.
     * 
     * @return height of image if the number of rotations is even else returns width of image if
     * number of rotations is odd.
     */
    private int getHeight() {
        if (rotations % 2 == 0) {
            return IMAGE.height;
        } else {
            return IMAGE.width;
        }
    }
}

