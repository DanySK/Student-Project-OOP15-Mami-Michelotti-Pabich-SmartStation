package application.model.buildables.reserve;

import java.util.List;

import application.model.services.Fuel;

public interface ReserveManager{
	
	public Reserve getReserve(Fuel type);
	
	List<Reserve> getAllReserves();
}
