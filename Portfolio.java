import java.util.ArrayList;

/**
 * Write a description of class Portfolio here.
 *
 * @author Sean Reid
 * @version Spring 2023
 */
public class Portfolio
{
    private ArrayList<StockHolding> stocks;
    
    private double lifeI;
    
    private double lifeP;
    
    /**
     * Constructs and returns a Portfolio object initializing all the instance variables
     */
    public Portfolio(){
        stocks = new ArrayList<StockHolding>();
        lifeI = 0;
        lifeP = 0;
    }

    /**
     * Returns the lifetime investment for this stock
     * 
     * @return lifeI the lifetime investment for this stock
     */
    public double getLifeI(){
        return lifeI;
    }
    
    /**
     * Returns the lifetime payout for this stock
     * 
     * @return lifeP the lifetime payout for this stock
     */
    public double getLifeP(){
        return lifeP;
    }
    
    /**
     * Returns the index of the ArrayList the matches the symbol passed in
     * 
     * @param symbol the symbol for the stock
     * @return the index of the ArrayList the matches the symbol passed in or -1 if the symbol is not found
     */
    private int getIndex(String symbol){
        for (int i = 0; i < stocks.size(); i++){
            if (stocks.get(i).getSymbol().equalsIgnoreCase(symbol)){
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Buys more shares of the stock if stock is already owned, otherwise the stock is bought and added to the ArrayList, also returns the cost of buying the stock
     * 
     * @param symbol the symbol for the stock
     * @param name the name of the stock
     * @param numShares the number shares owned for this stock
     * @param price the price of the stock per share
     * @return the cost of buying of the stock
     */
    public double buyStock(String symbol, String name, int numShares, double price){
        for (int i = 0; i < stocks.size(); i++){
            if (stocks.get(i).getSymbol().equalsIgnoreCase(symbol)){
                stocks.get(i).buyShares(numShares, price);
                return numShares * price;
            }
        
        }
        StockHolding st = new StockHolding(symbol, name, numShares, price);
        stocks.add(st);
        lifeI = numShares * price;
        return lifeI;    
    }
    
    /**
     * Returns the profit made from selling shares if unable to sell shares then 0 is returned
     * 
     * @param symbol the symbol for the stock
     * @param numShares the number shares owned for this stock
     * @return the amount of profit made from selling the shares
     */
    public double sellStock(String symbol, int numShares){
        double cost = 0;
        for (int i = 0; i < stocks.size(); i++){
            if (stocks.get(i).getSymbol().equalsIgnoreCase(symbol)){
                cost = stocks.get(i).sellShares(numShares);
                if (stocks.get(i).getNumShares() == 0){
                    stocks.remove(i);
                }
                lifeP += cost;
            }
        
        }
        return cost;
    }
    
    /**
     * Returns the current value of the stock portfolio
     * 
     * @return currentV the current value of the stock portfolio
     */
    public double getCurrentValue(){
        double currentV = 0;
        for (int i =0; i < stocks.size(); i++){
            int numS = stocks.get(i).getNumShares();
            double price = stocks.get(i).getPrice();
            currentV += (numS * price);
        }
        return currentV;
    }
    
    /**
     * Returns an output string formatted nicely
     * 
     * @return an output string formatted nicely
     */
    @Override
    public String toString()
    {
        //DO NOT EDIT THIS METHOD.
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("%6s%25s%10s%15s%15s%n", 
                 "Symbol", "Name", "Shares", "@Price", "Total"));
                sb.append("-----------------------------------------------------------------------\n");

        for(StockHolding s : stocks){
            sb.append(s.toString());
        }
        return sb.toString();
    }
}
