/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  /* your code here - attributes */
  public int score;
  private String name;

  /* your code here - constructor(s) */ 
  public Player() {
    Scanner nameScanner = new Scanner(System.in);
    String name = nameScanner.nextLine();
    this.name = name;
    nameScanner.close();

    System.out.println("Welcome " + name + " to the game!");

    score = 0;
  }

  public Player(String name) {
    this.name = name;

    score = 0;
  }

  /* your code here - accessor(s) */
  public String getName() {
    return name;
  }

  /* your code here - mutator(s) */
  public void addScore(int scoreToAdd) {
    score += scoreToAdd;
  }
}