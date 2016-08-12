package application.model.moneyManager;

public interface Movement {
	
    MovementType getType();
    
    void setType(final MovementType type);
    	
    int getMoney();
    	
    void setMoney(final int money);
    	
    String getDescription();
    	
    void setDescription(final String description);	
}
