package application.model.buildables.area;

import java.util.List;

/**
 * Interface containing all the logic to build and modify an area inside the station.
 * @author Alessandro Mami
 * 
 */
public interface AreaManager{
    
    /**
     * Gets the area of a specific position.
     * @param Integer coordinate of position x.
     * @param Integer coordinate of position y.
     * @return Area of coordinates x and y.
     */
    Area getArea(final int x, final int y);
    
    /**
     * Gets every area of the station.
     * @return List of area's type.
     */
    List<Area> getAllAreas();
    
    /**
     * Adds an area to the station.
     * @param Object of area's type.
     */
    void addArea(final Area area);
    
    /**
     * Removes an area from the station.
     * @param Object of area's type.
     */
    void removeArea(final Area area);
    
    /**
     * Removes an area from the station.
     * @param Integer coordinate of position x.
     * @param Integer coordinate of position y.
     */
    void removeArea(final int x, final int y);
    
    /**
     * Removes every area from the station.
     */
    void removeAllAreas();	
}
