package repository;

import java.util.HashMap;
import java.util.Map;

import pojo.TradeAccount;

public class TradeAccountRepository {
    private Map<String, TradeAccount> dataStore = new HashMap<>();

    /** 
     * Create a method to clone a TradeAccount object in the datastore using the id field as the key
     * @param, a TradeAccount object, and return no value.
     */
    public void createTradeAccount(TradeAccount tradeAccount){
        if(tradeAccount == null){
            throw new IllegalArgumentException("Trade account cannot be null.");
        }

        this.dataStore.put(tradeAccount.getId(), tradeAccount.clone());
    }

    /** Create a method to retrieve a Trade Account. 
     * @param a String id, 
     * return a TradeAccount object.
     * return a clone of the TradeAccount object stored in the datastore with the specified id. 
     */
    public TradeAccount retrieveTradeAccount(String id){
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("ID cannot be null or blank.");
        }

        return this.dataStore.get(id).clone();
    }

    /** 
     * Create a method to update a Trade Account using the id field as the key and 
     * storing a clone of the TradeAccount object to ensure that the original object is not modified
     * @param a TradeAccount object
     * return no value.
     */

     public void updateTradeAccount(TradeAccount tradeAccount){
        if(tradeAccount == null){
            throw new IllegalArgumentException("Trade account cannot be null.");
        }

        this.dataStore.put(tradeAccount.getId(), tradeAccount.clone());
     }

     /** Create a method to deletea Trade Account in the TradeAccountRepository class.
      * @param one parameter, a String id
      * return no value
      */
     public void deleteTradeAccount(String id){
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("ID cannot be null or blank.");
        }

        this.dataStore.remove(id);
     }
}
