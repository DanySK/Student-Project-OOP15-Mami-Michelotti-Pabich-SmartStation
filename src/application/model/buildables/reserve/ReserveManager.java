package application.model.buildables.reserve;

import java.util.List;

import application.model.services.Fuel;

public interface ReserveManager{
	
    Reserve getReserve(final Fuel type);
	
    List<Reserve> getAllReserves();
    
    void removeAllReserves();
}
