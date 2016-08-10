package application.model.moneyManager;

public enum MovementType {
	
	//TODO 1) Code alla fine non so quanto serve... l'enum viene identificato direttamente dal suo nome (BUILD, REPAIR ecc..)
	//2) Fai un metodo pubblico getActualName() che permette di risalire al nome del tipo, che ritorna sempicemente la String actualName
	
	BUILD("Build"), REPAIR("Repair"), REFILL("Refill"), SELL("Sell"), SERVICE("Service");
	
	private final String actualName ;
	
	private MovementType (final String actualName){
		this.actualName = actualName ;
	}
	
	public String getActualName(){
		return this.actualName ;
	}
}
