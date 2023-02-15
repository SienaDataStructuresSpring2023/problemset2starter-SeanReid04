/**
 * Write a description of class Asset here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StockHolding
{
    private char symbol;
    private String name;
    private int numShares;
    private double price;
    
    public StockHolding(char symbol, String name, int numShares, double price){
        this.symbol = symbol;
        this.name = name;
        this.numShares = numShares;
        this.price = price;
        
    }
    
    
    @Override
    public String toString()
    {
        //DO NOT EDIT THIS METHOD.
        return String.format("%6s%25s%,10d  $%,12.2f  $%,12.2f%n", 
            symbol, name, numShares, price, numShares * price); 
    }
}
