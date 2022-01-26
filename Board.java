/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 */
import java.util.Scanner;
import java.io.File;

public class  Board
{
  private String phrase = "";
  private String solvedPhrase = "";
  private int currentLetterValue; 

  /* your code here - constructor(s) */ 
  public Board() {
    phrase = loadPhrase();
  }
  
  /* your code here - accessor(s) */
  public String getPhrase() {
    return phrase;
  }

  public String getSolvedPhrase() {
    return solvedPhrase;
  }

  public int getCurrentLetterValue() {
    return currentLetterValue;
  }
  
  /* your code here - mutator(s)  */


  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess)
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

  private String loadPhrase()
  {
    String tempPhrase = "";

    int numOfLines = 0;
    try
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }

    int randomInt = (int) ((Math.random() * numOfLines) + 1);

    try
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }

    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }
      else
      {
        solvedPhrase += "_ ";
      }
    }

    return tempPhrase;
  }

  /* Creates a new solved phrase substituting unguessed letters with the guessed letter if the
   * guessed letter matches the unguessed letter.
   * 
   * Preconditions:
   *  - A phrase has been loaded
   *  - A guessed letter has been inputed
   * Postconditions:
   *  - The solvedPhrase variable now has the guessed letter
   *    in all places that that guessed letter should be
   */
  public boolean guessLetter(String guess)
  {
    // Define variables
    boolean foundLetter = false;
    String newSolvedPhrase = "";
    
    // For every character in the phrase
    for (int i = 0; i < phrase.length(); i++)
    {
      // If the character at the current position is equal to the guessed letter then...
      if (phrase.substring(i, i + 1).equals(guess))
      {
        // Add the guessed letter to the solved phrase
        newSolvedPhrase += guess + " ";
        foundLetter = true;
      }
      // If not, then...
      else
      {
        // Add empty spaces
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";  
      }
    }
    // Set the old solved phrase to the new one we just generated
    solvedPhrase = newSolvedPhrase;
    return foundLetter;
  } 
} 