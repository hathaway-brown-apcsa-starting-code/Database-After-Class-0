
/**
 * Reads a shopping list from a data file and processes it
 *
 * @author  APCS-A @ HB 
 * @version 2022-11-30
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class ShoppingList
{
    
  // in your code, change the type of the ArrayList
  public static void readFile (ArrayList<Item> list, String fileName)
  {
    // open the file
    File file = new File(fileName);
    Scanner input = null;
    try
    {
        input = new Scanner(file);
    }
    catch (FileNotFoundException ex)
    {
        System.out.println("*** Cannot open " + fileName + " ***");
        System.exit(1);        // quit the program
    } 

    // read the items from the file
    while (input.hasNext())
    {
        String itemText = input.nextLine();
        // System.out.println (itemText);
        list.add(new Item(itemText));
    }
      
    input.close();
  }
  
  /** The main method creates a new shopping list
   *  from the data file and processes the info
   */
  public static void main (String[] args)
  {
      // Change the type for the ArrayList
      ArrayList<Item> shoppingList = new ArrayList<Item>();
      // Use your own variable and file name
      readFile(shoppingList, "ShoppingList.csv");
      
      double grandTotal = 0.0;
      for (Item itm : shoppingList)
      {
          System.out.println(itm);
          grandTotal += itm.getTotalCost();
      }
      
      System.out.println("\n  Grand total:  $" + grandTotal);
  }
}
