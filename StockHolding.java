/**
 * This class creates a stockholding object along with methods in order to manipulate the object in a desired manner. 
 *
 * @author Sean Reid.
 * @version Spring 2023.
 */
public class StockHolding
{
    private String symbol;
    private String name;
    private int numShares;
    private double price;
    
    /**
     * Creates a stockholding object with four parameters.
     * 
     * @param symbol the symbol for the stock.
     * @param name the name of the stock.
     * @param numShares the number shares owned for this stock.
     * @param price the price of the stock per share.
     */
    public StockHolding(String symbol, String name, int numShares, double price){
        this.symbol = symbol;
        this.name = name;
        this.numShares = numShares;
        this.price = price;
        
    }
    
    /**
     * Returns the symbol of the stock.
     * 
     * @return symbol the symbol for the stock.
     */
    public String getSymbol(){
        return symbol;
    }
    
    /**
     * Returns the name of the stock.
     * 
     * @return name the name of the stock.
     */
    public String getName(){
        return name;
    }
    
    /**
     * Returns the number of shares owned for this stock.
     * 
     * @return numShares the number shares owned for this stock.
     */
    public int getNumShares(){
        return numShares;
    }
    
    /**
     * Returns the price of this stock per share.
     * 
     * @return price the price of the stock per share.
     */
    public double getPrice(){
        return price;
    }
    
    /**
     * Buys more shares of the stock and updates the amount of shares owned and the price of the stock.
     * 
     * @param numShares the number shares owned for this stock.
     * @param price the price of the stock per share.
     */
    public void buyShares(int numShares, double price){
        this.numShares += numShares;
        this.price = price;
    }
    
    /**
     * Returns the profit made from selling shares if unable to sell shares then 0 is returned.
     * 
     * @param soldShares the amount of shares to sell.
     * @return the amount of profit made from selling the shares.
     */
    public double sellShares(int soldShares){
        if (numShares >= soldShares){
            numShares = numShares - soldShares;
            return price * soldShares;
             
        } else {
            return 0;
        }
    }
    
    /**
     * Returns an output string formatted nicely.
     * 
     * @return an output string formatted nicely.
     */
    @Override
    public String toString()
    {
        //DO NOT EDIT THIS METHOD.
        return String.format("%6s%25s%,10d  $%,12.2f  $%,12.2f%n", 
            symbol, name, numShares, price, numShares * price); 
    }
}
