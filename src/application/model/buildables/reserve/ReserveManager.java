package application.model.buildables.reserve;

import java.util.List;

import application.model.services.Fuel;

public interface ReserveManager{
	
    Reserve getReserve(final Fuel type);
	
    List<Reserve> getAllReserves();
    
    void addReserve(final int maxDurability, final int actualDurability, final int cost, final int repairCost, final Fuel type, final int capacity, final int durability);
    
    void removeAllReserves();
}
