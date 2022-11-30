
/**
 * Represents an Item you might buy at the store
 * 
 * @author  APCSA section1 at <b><a href="http://www.hb.edu">Hathaway Brown</a></b>
 * @version 2022-09-20
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String itemName;
    private int quantity;
    private double priceEach;

    /**
     * Constructor for objects of class Item
     * 
     * @param   name   The name of the item to buy
     * @param   num    The quantity of the item to buy
     * @param   price  The price for each item
     */
    public Item(String name, int num, double price)
    {
        // initialise instance variables
        itemName = name;
        quantity = num;
        priceEach = price;
    }

    /** Constructor based on a String in the format ItemName,Quantity,PriceEach
     *  @param str   A comma-delimited String in the format "itemName,quantity,priceEach"
     */
    public Item (String str)
    {
        int commaLoc = str.indexOf(',');
        itemName = str.substring(0, commaLoc);
        str = str.substring(commaLoc + 1);
        
        commaLoc = str.indexOf(',');
        quantity = Integer.parseInt(str.substring(0, commaLoc));
        
        priceEach = Double.parseDouble(str.substring(commaLoc + 1));
    }
    
    // ----------------------------------------------------------------
    //  Accessor Methods
    // ----------------------------------------------------------------
    /**  Returns the total cost for buying the items
     *  @return  The total cost for buying the items in the given quantity at the given price
     */
    public double getTotalCost()
    {
        return Math.round(100 * quantity * priceEach) / 100.0;
    }
    
    /** Returns the number of items purchased
     *  @return  The number of items purchased
     */
    public int getQuantity()
    {
        return quantity;
    }
    
    // ----------------------------------------------------------------
    //  Mutator Methods
    // ----------------------------------------------------------------
    /** Sets the quantity of items purchased
     *  @param  n  The new number of items to purchase
     */
    public void setQuantity (int n)
    {
        quantity = n;
    }
    
    // ----------------------------------------------------------------
    //  Other Methods
    // ----------------------------------------------------------------
    /** Pads a string with blank spaces to get a total length of 30 
     *  @param  str  The String to pad
     *  @return  The string parameter with spaces added to get a total length of 30 characters
     */
    public String printIn30(String str)
    {
        String ans = str;
        for (int i = str.length(); i < 30; i++)
        {
            ans += ' ';
        }
        return ans;
    }
    
    /** Returns the Item represented as a String
     *  @return A String representation of the Item, showing the quantity, item name, price each, and total cost
     */
    public String toString()
    {
        String ans = "";
        ans += quantity + "\t";
        ans += printIn30(itemName) + "\t";
        ans += "$" + priceEach + " each";
        ans += "\tTotalCost:   $" + getTotalCost();
        
        return ans;
    }
}
