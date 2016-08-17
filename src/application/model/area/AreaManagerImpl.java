package application.model.area;

import java.util.ArrayList;
import java.util.List;

public class AreaManagerImpl implements AreaManager {
	
    private final List<Area> areas;
	
    public AreaManagerImpl() {
	this.areas = new ArrayList<Area>();
    }

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
	
    @Override
    public void addArea(final Area area) {
	this.areas.add(area);	
    }

    @Override
    public void removeArea(final Area area) {
	this.areas.remove(area);	
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
