package application.model.moneyManager;

import java.util.List;

public interface MoneyManager {
	
	Movement getMovement(int i);
	
	List<Movement> getAllMovements();
	
	int getActualBalance();
	
	void addMovement(Movement movement);
}
