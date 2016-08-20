package application.model.buildables.area;

import java.util.ArrayList;
import java.util.List;

import application.model.buildables.pump.Pump;
import application.model.services.FuelImpl;

/**
 * Implements the AreaManager interface.
 * @author Alessandro Mami
 *
 */
public class AreaManagerImpl implements AreaManager {
    
    /**
     * List of areas inside the station.
     */
    private final List<Area> areas;
    
    /**
     * Constructor for the AreaManagerImpl that stores avery area.
     */
    public AreaManagerImpl() {
	this.areas = new ArrayList<Area>();
    }
    
    //AREA GETTERS
    @Override
    public Area getArea(final int x, final int y) {
        for(Area a : this.areas){
            if(a.getXPosition() == x && a.getYPosition() == y){
		return a;
            }
        }
	return null;
    }
	
    @Override
    public List<Area> getAllAreas() {
        return new ArrayList<>(this.areas);
    }
	
    //AREA ADDERS AND REMOVERS
    @Override
    public void addArea(int x, int y, List<Pump> pumps) {
        this.areas.add(new AreaImpl(x, y, pumps));	
    }
    
    @Override
    public void removeArea(final int x, final int y) {
	for(Area a : this.areas){
	    if(a.getXPosition() == x && a.getYPosition() == y){
		areas.remove(a);
	    }
	}	
    }

    @Override
    public void removeAllAreas() {
	areas.clear();
    }
}
