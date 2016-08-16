package application.model.moneyManager;

public class MovementImpl implements Movement {
	
    private MovementType type;
    private int money;
    private String description;
    
    public MovementImpl(final MovementType type , final int money, final String description) {
        this.type = type;
        this.money = money;
        this.description = description;
    }

    @Override
    public MovementType getType() {
    	return this.type;
    }
    
    @Override
    public void setType(final MovementType type) {
    	this.type = type;	
    }
    
    @Override
    public int getMoney() {
    	return this.money;
    }
    
    @Override
    public void setMoney(final int money) {
    	this.money = money;
    }
    
    @Override
    public String getDescription() {
    	return this.description;
    }
    
    @Override
    public void setDescription(final String description) {
    	this.description = description;		
    }
}
