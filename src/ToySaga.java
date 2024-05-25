//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Toy Saga
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
import java.util.ArrayList;
import processing.core.PImage;

/**
 * This class contains the code to draw a ToySaga. It can add toys and remove them by putting in
 * the box. This class also uses other classes. This class has methods which add a symbol upon
 * pressing key, rotating them and moving them around.
 */
public class ToySaga {

    // These are the static fields
    private static PImage backgroundImage;
    private static ArrayList<Furniture> furnitureList;
    private static ArrayList<Toy> toyList;
    private static final String BOX_NAME = "box";
    private static final int MAX_TOYS_COUNT = 8;

    /**
     * This method sets up the background by declaring a variable and assigns the background image.
     * It also initializes array lists and assigns furniture items to them.
     */
    public static void setup() {
      
        backgroundImage = Utility.loadImage("images" + File.separator + "background.png");

        furnitureList = new ArrayList<>();
        toyList = new ArrayList<>();

        furnitureList.add(new Furniture("bed", 520, 270));
        furnitureList.add(new Furniture("rug", 220, 370));
        furnitureList.add(new Furniture("nightstand", 325, 240));
        furnitureList.add(new Furniture(BOX_NAME, 90, 230));
    }

    /**
     * This method draws the background and the furniture items.
     */
    public static void draw() {
        Utility.background(Utility.color(255, 250, 250));
        Utility.image(backgroundImage, Utility.width() / 2, Utility.height() / 2); 
        updateToyList();
        drawFurniture(); 
        drawToys(); 
    }

    /**
     * This method checks if a toy is over the toyBox, if it is then it calls the toyList array list
     * and removes the toy from it and so it disappears.
     */
    private static void updateToyList() {
      Furniture toyBox = getToyBox();
      if (toyBox != null) {
          ArrayList<Toy> toysToRemove = new ArrayList<>();
          for (int i = 0; i < toyList.size(); i++) {
              Toy toy = toyList.get(i);
              if (toy.isOver(toyBox)) {
                  toysToRemove.add(toy);
              }
          }
          toyList.removeAll(toysToRemove);
      }
  }


    /**
     * Helper method to draw Furniture items
     */
    private static void drawFurniture() {
      for (int i = 0; i < furnitureList.size(); i++) {
          Furniture furniture = furnitureList.get(i);
          furniture.draw();
      }
  }


    /**
     * Helper method to draw toy items
     */
    private static void drawToys() {
      for (int i = 0; i < toyList.size(); i++) {
          Toy toy = toyList.get(i);
          toy.draw();
      }
  }


    /**
     * This method loops through the furniture array list and checks if item is over the box,
     * if any of the item is over the box then it returns that specific furniture item.
     * 
     * @return furniture The specific furniture item which is over the box else returns null.
     */
    public static Furniture getToyBox() {
      for (int i = 0; i < furnitureList.size(); i++) {
          Furniture furniture = furnitureList.get(i);
          if (furniture.name().equals(BOX_NAME)) {
              return furniture;
          }
      }
      return null;
  }


    /**
     * This method loops through the Toy array list and checks if the toy is being dragged, if it
     * is being dragged then it returns that specific toy.
     * 
     * @return toy The specific toy item which is being dragged else returns null.
     */
    public static Toy getDraggingToy() {
      for (int i = 0; i < toyList.size(); i++) {
          Toy toy = toyList.get(i);
          if (toy.isDragging()) {
              return toy;
          }
      }
      return null;
  }


    /**
     * This method checks whether mouse is pressed and if mouse is pressed and there is a toy in
     * that position, the startDragging method is called and the symbol can be dragged to a 
     * different location.
     */
    public static void mousePressed() {
      if (getDraggingToy() == null) {
          for (int i = 0; i < toyList.size(); i++) {
              Toy toy = toyList.get(i);
              if (toy.isOver(Utility.mouseX(), Utility.mouseY())) {
                  toy.startDragging();
                  return;
              }
          }
      }
  }


    /**
     * This method checks whether the mouse button is released and if it is released then the toy
     * which was being dragged in that position is stopped being dragged using the stopDragging
     * method.
     */
    public static void mouseReleased() {
        Toy draggingToy = getDraggingToy();
        if (draggingToy != null) {
            draggingToy.stopDragging();
        }
    }

    /**
     * This method checks which key is pressed, converts it to upper case and performs the action
     * accordingly. It can add a toy and rotate a toy.
     */
    public static void keyPressed() {
      char key = Utility.key();
      char upperCaseKey = Character.toUpperCase(key);

      if (toyList.size() < MAX_TOYS_COUNT) {
          switch (upperCaseKey) {
              case 'C':
                  toyList.add(new Toy("car", Utility.mouseX(), Utility.mouseY()));
                  break;
              case 'T':
                  toyList.add(new Toy("teddyBear", Utility.mouseX(), Utility.mouseY()));
                  break;
                  
          }
      }

      if (upperCaseKey == 'R') {
          for (int i = 0; i < toyList.size(); i++) {
              Toy toy = toyList.get(i);
              if (toy.isOver(Utility.mouseX(), Utility.mouseY())) {
                  toy.rotate();
                  break;
              }
          }
      }
  }



  /**
   * Main method which calls the run application method from the Utility class. This method
   * runs the whole program
   * 
   * @param args unused.
   */
  public static void main(String[] args) {
    Utility.runApplication();

  }

}
