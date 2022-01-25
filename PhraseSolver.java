/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  /* your code here - attributes */
  private Player player1;
  private Player player2;
  private Board board;
  private boolean solved = false;

  /* your code here - constructor(s) */ 
  public PhraseSolver() {
    solved = false;
  }

  /* your code here - accessor(s) */
  
  /* your code here - mutator(s)  */

  public void play()
  {
    Scanner input = new Scanner(System.in);

    System.out.println("What is player 1's name? ");
    player1 = new Player(input.nextLine());

    System.out.println("What is player 2's name? ");
    player2 = new Player(input.nextLine());

    board = new Board();

    boolean player1Turn = true;

    while (!solved) 
    {
      /* your code here - game logic */
      System.out.println("Current phrase: " + board.getSolvedPhrase());
      System.out.println((player1Turn ? player1.getName() : player2.getName()) + "'s turn. What's your guess? ");

      String guess = input.nextLine();

      if (guess.length() > 1) {
        if (board.getPhrase().equalsIgnoreCase(guess)) {
          solved = true;
        } else {
          System.out.println("That's not the correct full phrase!");
        }
      } else {
        boolean wasGuessCorrect = board.guessLetter(guess);
        if (wasGuessCorrect) {
          if (player1Turn) player1.addScore(board.getCurrentLetterValue());
          else player2.addScore(board.getCurrentLetterValue());
        }
        System.out.println(wasGuessCorrect ? "Correct guess!" : "That letter is not in the phrase.");

        player1Turn = !player1Turn;
      }
      System.out.println();
    }
    System.out.println("You guessed it! Congrats! The winner is " + (player1Turn ? player1.getName() : player2.getName()));
    input.close();
  }
}