package pojo;

/** an abstract TradeAccount class */
public abstract class TradeAccount {
    private String id;

    public TradeAccount(String id) {
        setId(id);;
    }

    public TradeAccount(TradeAccount tradeAccount){
        if(tradeAccount == null){
            throw new IllegalArgumentException("Trade account cannot be null.");
        }

        setId(tradeAccount.id);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("ID cannot be null or blank.");
        }

        this.id = id;
    }

    /** an abstract clone without parameters and return a TradeAccount object */
    public abstract TradeAccount clone();
}
