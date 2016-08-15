package application.model.buildables.reserve;

import java.util.ArrayList;
import java.util.List;

import application.model.services.Fuel;

public class ReserveManagerImpl implements ReserveManager {
	
    private final List<Reserve> reserve;
	
    public ReserveManagerImpl() {
        this.reserve = new ArrayList<Reserve>();
    }
	
    @Override
    public Reserve getReserve(final Fuel type) {
	for(Reserve r : this.reserve){
	    if(r.getType() == type){
		return r;
	    }
	}
	return null;
    }

    @Override
    public List<Reserve> getAllReserves() {
	return new ArrayList<Reserve> (this.reserve);
    }

    @Override
    public void removeAllReserves() {
        this.reserve.clear();
    }
}
