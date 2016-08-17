package application.model.area;

import java.util.List;

public interface AreaManager{
	
    Area getArea(final int x, final int y);
    	
    List<Area> getAllAreas();
    	
    void addArea(final Area area);
    	
    public void removeArea(final Area area);
    	
    void removeArea(final int x, final int y);
    	
    void removeAllAreas();	
}
