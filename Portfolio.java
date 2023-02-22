import java.util.ArrayList;

/**
 * Write a description of class Portfolio here.
 *
 * @author Sean Reid
 * @version (a version number or a date)
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
    
    private int getIndex(String symbol){
        for (int i = 0; i < stocks.size(); i++){
            if (stocks.get(i).getSymbol().equalsIgnoreCase(symbol)){
                return i;
            }
        }
        return -1;
    }
    
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
