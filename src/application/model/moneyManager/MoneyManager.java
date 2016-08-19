package application.model.moneyManager;

import java.util.List;

public interface MoneyManager {
	
    Movement getMovement(final int i);
    	
    List<Movement> getAllMovements();
    	
    int getActualBalance();
    	
    void addMovement(final MovementType type , final int money, final String description);
}
