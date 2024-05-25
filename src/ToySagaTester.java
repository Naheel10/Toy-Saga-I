//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Toy Saga Tester
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

/**
 * This class implements tester methods to ensure the correctness of the implementation of Furniture
 * and Toy classes in p03 Toy Saga I program.
 */
public class ToySagaTester {

  /**
   * This tester ensures the Furniture constructor which takes a String as input Furniture(String
   * name) correctly constructs a new Furniture object located at the center of the display window,
   * and assigned it a PImage and the name passed as input to the method call.
   * 
   * @return true when this test verifies a correct functionality (ALL test scenarios PASS), and
   *         false otherwise
   */
  public static boolean testFurnitureConstructor1Getters() {
    String furnitureName = "bed"; 

    // Creating a new Furniture object using the constructor
    Furniture furniture = new Furniture(furnitureName);

    // Checking that getX() returns Utility.width() / 2
    if (furniture.getX() != Utility.width() / 2) {
        return false;
    }

    // Checking that getY() returns Utility.height() / 2
    if (furniture.getY() != Utility.height() / 2) {
        return false;
    }

    // Checking that getName() returns the name passed as input to the constructor
    if (!furniture.name().equals(furnitureName)) {
        return false;
    }

    // Checking that the IMAGE field returns a NON-null reference
    if (furniture.IMAGE == null) {
        return false;
    }

    // If everything passes, return True.
    return true;
}


  /**
   * This tester ensures the Furniture constructor which takes a String, and two integers as input
   * Furniture(String name, int x, int y) correctly constructs a new Furniture object located at the
   * (x,y) input position, assigned it the name passed as input to the method call, and an image.
   * 
   * @return true when this test verifies a correct functionality (ALL test scenarios PASS), and
   *         false otherwise
   */
  public static boolean testFurnitureConstructor2Getters() {
    String furnitureName = "box"; 
    int xCoordinate = 100; 
    int yCoordinate = 200; 

    // Creating a new Furniture object using the constructor Furniture(String, int, int)
    Furniture furniture = new Furniture(furnitureName, xCoordinate, yCoordinate);

    // Checking that getX() returns the input x coordinate
    if (furniture.getX() != xCoordinate) {
        return false;
    }

    // Checking that getY() returns the input y coordinate
    if (furniture.getY() != yCoordinate) {
        return false;
    }

    //  Checking getName() returns the name passed as input to the constructor
    if (!furniture.name().equals(furnitureName)) {
        return false;
    }

    // Checking  that the IMAGE field returns a NON-null reference
    if (furniture.IMAGE == null) {
        return false;
    }

    // If everything passes, returns True.
    return true;
}


  /**
   * This tester ensures the Toy constructors, getters and setters of the x and y positions, and the
   * image field.
   * 
   * @return true when this test verifies a correct functionality (ALL test scenarios PASS), and
   *         false otherwise
   */
  public static boolean testToyConstructorsGettersSetters() {
    String toyName = "car"; 
    int xCoordinate = 100; 
    int yCoordinate = 200; 

    // Test Toy(String) constructor
    Toy toy1 = new Toy(toyName);
    // Checking that getX() returns Utility.width() / 2
    if (toy1.getX() != Utility.width() / 2) {
        return false;
    }
    // Checking   that getY() returns Utility.height() / 2
    if (toy1.getY() != Utility.height() / 2) {
        return false;
    }

    // Test Toy(String, int, int) constructor
    Toy toy2 = new Toy(toyName, xCoordinate, yCoordinate);
    // cHecking that getX() returns the input x coordinate
    if (toy2.getX() != xCoordinate) {
        return false;
    }
    // checking that getY() returns the input y coordinate
    if (toy2.getY() != yCoordinate) {
        return false;
    }

    int newX = 300; 
    int newY = 400; 
    toy2.setX(newX);
    toy2.setY(newY);
    // Checking that setX() and setY() methods set the positions correctly
    if (toy2.getX() != newX || toy2.getY() != newY) {
        return false;
    }

    // Checking  that the IMAGE field contains a NON-null reference
    if (toy1.IMAGE == null || toy2.IMAGE == null) {
        return false;
    }

    // checking that isDragging() returns false on a newly constructed Toy object
    if (toy1.isDragging() || toy2.isDragging()) {
        return false;
    }

    // If everything passes, return True.
    return true;
}


  /**
   * This tester ensures the correctness of Toy.startDragging() and Toy.stopDragging instance
   * methods
   * 
   * @return true when this test verifies a correct functionality (ALL test scenarios PASS), and
   *         false otherwise
   */
  public static boolean testToyStartStopDragging() {
    Toy toy = new Toy("car");


    toy.startDragging();

    // Checking isDragging() returns true after calling startDragging()
    if (!toy.isDragging()) {
        return false;
    }

    toy.stopDragging();

    // Checking isDragging() returns false after calling stopDragging()
    if (toy.isDragging()) {
        return false;
    }

    // If everything passes, return True.
    return true;
}


  /**
   * This tester ensures the correctness of Toy.move() method
   * 
   * @return true when this test verifies a correct functionality (ALL test scenarios PASS), and
   *         false otherwise
   */
  public static boolean testToyMove() {

    int initialX = 100;
    int initialY = 200;
    Toy toy = new Toy("car", initialX, initialY);


    int dxPositive = 50;
    int dyPositive = 30;
    toy.move(dxPositive, dyPositive);

    // Checking that the toy's position has been updated correctly
    if (toy.getX() != initialX + dxPositive || toy.getY() != initialY + dyPositive) {
        return false;
    }


    int dxNegative = -30;
    int dyNegative = -20;
    toy.move(dxNegative, dyNegative);

    //  Checking that the toy's position has been updated correctly
    if (toy.getX() != initialX + dxPositive + dxNegative || toy.getY() != initialY + dyPositive + dyNegative) {
        return false;
    }

    // If everything passes, return True.
    return true;
}


  /**
   * This tester ensures the correctness of Toy.rotate() method.
   * 
   * @author Mouna
   * 
   * @return true when this test verifies a correct functionality (ALL test scenarios PASS), and
   *         false otherwise
   * 
   */
  public static boolean testToyRotate() {
    // This method's implementation is entirely provided to you
    // Create two Toy objects
    Toy car1 = new Toy("car");
    Toy car2 = new Toy("car");

    // Ensures getRotationsCount() returns zero when called on newly constructed Toy objects
    if (car1.getRotationsCount() != 0) {
      System.out.println(
          "Toy.getRotationsCount() should return zero when called on a new created Toy object.");
      return false;
    }

    if (car2.getRotationsCount() != 0) {
      System.out.println(
          "Toy.getRotationsCount() should return zero when called on a new created Toy object.");
      return false;
    }
    // rotate car1 5 times
    for (int i = 0; i < 5; i++) {
      car1.rotate();
    }
    // Ensure the getRotationsCount returns the expected output
    if (car1.getRotationsCount() != 5) {
      System.out.println(
          "Toy.getRotationsCount() did not return the expected output after calling the rotate() "
              + "method multiple times.");
      return false;
    }
    // rotate car2 3 times
    for (int i = 0; i < 3; i++) {
      car2.rotate();
    }
    // Ensure the getRotationsCount returns the expected output
    if (car2.getRotationsCount() != 3) {
      System.out.println(
          "Toy.getRotationsCount() did not return the expected output after calling the rotate() "
              + "method multiple times.");
      return false;
    }
    return true; // Test passes with no errors
  }



  /**
   * This tester checks the correctness of Toy.isOver(int, int) method
   * 
   * @return true when this test verifies a correct functionality (ALL test scenarios PASS), and
   *         false otherwise
   */
  public static boolean testToyIsOverPoint() {

    int initialX = 100;
    int initialY = 200;
    Toy toy = new Toy("car", initialX, initialY);

    // case 1: Point inside the area of the image of the toy
    int insideX = initialX + 10; 
    int insideY = initialY + 10;
    if (!toy.isOver(insideX, insideY)) {
        return false;
    }

    // case 2: Point outside the area of the image of the toy
    int outsideX = initialX - 50; 
    int outsideY = initialY - 50;
    if (toy.isOver(outsideX, outsideY)) {
        return false;
    }

    toy.rotate();

    // case 3: Point inside the area of the rotated toy's image
    
    // After rotation, width and height dimensions are switched
    int rotatedInsideX = initialX + 10;
    int rotatedInsideY = initialY + 10;
    if (!toy.isOver(rotatedInsideX, rotatedInsideY)) {
        return false;
    }

    // case 4: Point outside the area of the rotated toy's image
    int rotatedOutsideX = initialX - 50; 
    int rotatedOutsideY = initialY - 50;
    if (toy.isOver(rotatedOutsideX, rotatedOutsideY)) {
        return false;
    }

    // If everything passes, return True.
    return true;
}


  /**
   * This tester checks the correctness of Toy.isOver(Furniture) method
   * 
   * @return true when this test verifies a correct functionality (ALL test scenarios PASS), and
   *         false otherwise
   */
  public static boolean testToyIsOverFurniture() {

    Furniture furniture = new Furniture("bed", 200, 200);
    
    Toy intersectingToy = new Toy("car", 150, 150); 
    Toy enclosedToy = new Toy("teddyBear", 220, 220); 
    Toy nonOverlappingToy = new Toy("car", 500, 500); 

    // case 1: Toy intersecting with furniture object
    if (!intersectingToy.isOver(furniture)) {
      return false;

  }

  // case 2: Toy enclosed by the Furniture object
  if (!enclosedToy.isOver(furniture)) {
      return false;
  }

  // case 3: Toy not overlapping with the Furniture object
  if (nonOverlappingToy.isOver(furniture)) {
      return false;
  }

    // If everything passes, return True.
    return true;
}





  /**
   * Runs all the tester methods defined in this class
   * 
   * @return true when this test verifies a correct functionality (ALL test scenarios PASS), and
   *         false otherwise
   */
  public static boolean runAllTests() {
    System.out.println("Class Furniture Testers:");
    boolean test1Result = testFurnitureConstructor1Getters();
    System.out.println("testFurnitureConstructor1Getters: " + (test1Result ? "PASS" : "FAIL"));

    boolean test2Result = testFurnitureConstructor2Getters();
    System.out.println("testFurnitureConstructor2Getters: " + (test2Result ? "PASS" : "FAIL"));

    System.out.println();
    System.out.println("Class Toy Testers:");
    boolean test3Result = testToyConstructorsGettersSetters();
    System.out.println("testToyConstructorsGettersSetters: " + (test3Result ? "PASS" : "FAIL"));

    boolean test4Result = testToyStartStopDragging();
    System.out.println("testToyStartStopDragging: " + (test4Result ? "PASS" : "FAIL"));

    boolean testToyMove = testToyMove();
    System.out.println("testToyMove: " + (testToyMove ? "PASS" : "FAIL"));

    boolean testToyRotate = testToyRotate();
    System.out.println("testToyRotate: " + (testToyRotate ? "PASS" : "FAIL"));

    boolean testToyIsOverPoint = testToyIsOverPoint();
    System.out.println("testToyIsOverPoint: " + (testToyIsOverPoint ? "PASS" : "FAIL"));

    boolean testToyIsOverFurniture = testToyIsOverFurniture();
    System.out.println("testToyIsOverFurniture: " + (testToyIsOverFurniture ? "PASS" : "FAIL"));

    return test1Result && test2Result && test3Result && test4Result && testToyMove && testToyRotate
        && testToyIsOverPoint && testToyIsOverFurniture;
  }


  /**
   * Driver method to run all the tests defined in this class
   * 
   * @param args list of command-line input arguments if any.
   */
  public static void main(String[] args) {
    // DO NOT MAKE ANY CHANGES TO THE IMPLEMENTATION OF THIS METHOD
    Utility.runTester();
  }

}
