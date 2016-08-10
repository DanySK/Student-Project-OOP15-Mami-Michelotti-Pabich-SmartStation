package application.model.moneyManager;

public interface Movement {
	
	MovementType getType();
    
    void setType(MovementType type);
	
	int getMoney();
	
	void setMoney(int money);
	
	String getDescription();
	
	void setDescription(String description);
	
}
