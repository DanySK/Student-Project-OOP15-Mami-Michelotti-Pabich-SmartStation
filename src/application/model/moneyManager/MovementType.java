package application.model.moneyManager;

public enum MovementType {
	
    BUILD("Build"), REPAIR("Repair"), REFILL("Refill"), SELL("Sell"), SERVICE("Service");
	
    private final String actualName ;

    private MovementType (final String actualName){
	this.actualName = actualName ;
    }
    
    public String getActualName(){
	return this.actualName ;
    }
}
