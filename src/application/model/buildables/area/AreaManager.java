package application.model.buildables.area;

import java.util.List;

public interface AreaManager{
	
	Area getArea(int x, int y);
	
	List<Area> getAllAreas();
	
	void addArea(Area area);
	
	public void removeArea(Area area);
	
	void removeArea(int x, int y);
	
	void removeAllAreas();
	
	
}
