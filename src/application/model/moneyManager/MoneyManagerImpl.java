package application.model.moneyManager;

import java.util.ArrayList;
import java.util.List;

public class MoneyManagerImpl implements MoneyManager{
	
    private final List<Movement> movements;
    	
    public MoneyManagerImpl() {
        this.movements = new ArrayList<Movement>();
    }
    
    @Override
    public Movement getMovement(final int i) {
    	return this.movements.get(i);
    }
    	
    @Override
    public List<Movement> getAllMovements() {
    	return new ArrayList<>(this.movements);
    }
    
    @Override
    public int getActualBalance() {
    	int totBalance = 0;
    	for(Movement m : this.movements){
    		totBalance += m.getMoney();
    	}
    	return totBalance;
    }
    
    @Override
    public void addMovement(final Movement movement) {
    	this.movements.add(movement);	
    }
}
