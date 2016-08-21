package application.model.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import application.model.Station;
import application.model.StationImpl;
import application.model.buildables.area.AreaManager;
import application.model.buildables.pump.Pump;
import application.model.buildables.pump.PumpManager;
import application.model.buildables.reserve.ReserveManager;
import application.model.consumers.Vehicle;
import application.model.consumers.VehicleImpl;
import application.model.moneyManager.MoneyManager;
import application.model.moneyManager.MovementType;
import application.model.services.FuelManager;
import javafx.scene.paint.Color;

/**
 * JUnit class that test the model.
 */
public class MyTest {

    /**
     * General method that test all the things
     */
    @Test
    public void generalTester() {
        Station station = new StationImpl();
        
        //Test for the name
        station.setStationName("test");
        assertEquals("name should be test", "test", station.getStationName());
        
        //Test for areas
        station.setMaxAreas(10);
        assertEquals("max areas shoud be 10", 10, station.getMaxAreas());
        
        //Test for pumps
        station.setMaxPumps(4);
        assertEquals("max pumps shoud be 4", 4, station.getMaxPumps());
        
        //Test for objects getters
        assertNotNull(station.getAreaManager());
        assertNotNull(station.getPumpManager());
        assertNotNull(station.getReserveManager());
        assertNotNull(station.getFuelManager());
        assertNotNull(station.getMoneyManager());
        
        //Creating references for methods
        FuelManager fManager = station.getFuelManager();
        ReserveManager rManager = station.getReserveManager();
        PumpManager pManager = station.getPumpManager();   
        AreaManager aManager = station.getAreaManager();
        MoneyManager mManager = station.getMoneyManager();
        
        this.testFuelManager(fManager);      
        this.testReserveManager(rManager, fManager);
        this.testPumpManager(pManager);
        this.testAreaManager(aManager, pManager);
        this.testMoneyManager(mManager);
        this.testConsumers(new VehicleImpl(fManager.getFuel("testFuel"), 50), fManager);

        
    }
    
    
    /**
     * Tester for the fuelManager.
     * @param fManager fuelManager from main model
     */
    public void testFuelManager(final FuelManager fManager) {       
        //Insert a new fuel, testing if it's there and if i can get it
        assertNotNull(fManager.getFuel("testFuel"));
        assertNotNull(fManager.getAllFuels());
        assertEquals("there must be only one pump", 1, fManager.getAllFuels().size());
        
        //Insert second fuel, testing if it's there and if i can get it
        assertNotNull(fManager.getFuel("testFuel2"));
        assertNotNull(fManager.getAllFuels());
        assertEquals("there must be 2 pumps", 2, fManager.getAllFuels().size());
        
        //Removing the second fuel
        assertNull(fManager.getFuel("testFuel2"));
        assertEquals("there must be only 1 pump", 1, fManager.getAllFuels().size());
        
        //Reinsert the second fuel
        assertNotNull(fManager.getFuel("testFuel2"));
        assertNotNull(fManager.getAllFuels());
        assertEquals("there must be 2 pumps", 2, fManager.getAllFuels().size());
        
        //Testing for getters
        assertEquals("the name should be testFuel", "testFuel", fManager.getFuel("testFuel").getName());
        assertNotNull(fManager.getFuel("testFuel").getColor());
        assertEquals("the price should be 125", 125, fManager.getFuel("testFuel").getPrice());
        assertEquals("the wholesale price should be 100", 100, fManager.getFuel("testFuel").getWholeSalePrice());
        
        //Testing for setters
        assertEquals("the price should be 150", 150, fManager.getFuel("testFuel").getPrice());
        assertEquals("the wholesale price should be 200", 200, fManager.getFuel("testFuel").getWholeSalePrice());
    }
    
    
    /**
     * Test for the reserveManager.
     * @param rManager Reserve manager from main model
     * @param fManager Fuel manager from main model
     */
    public void testReserveManager(final ReserveManager rManager, final FuelManager fManager) {
        //Adding first reserve and testing if it's there     
        assertEquals("the reserve type should be testFuel", "testFuel", rManager.getReserve(fManager.getFuel("testFuel")).getType().getName());
        assertNotNull(rManager.getAllReserves());
        assertEquals("the reserve count should be 1", 1, rManager.getAllReserves().size());
        
        //Adding second reserve and testing if all are there
        assertEquals("the reserve type should be testFuel2", "testFuel2", rManager.getReserve(fManager.getFuel("testFuel2")).getType().getName());
        assertNotNull(rManager.getAllReserves());
        assertEquals("the reserve count should be 2", 2, rManager.getAllReserves().size());
        
        //Remove and test
        assertEquals("the reserve count should be 1", 1, rManager.getAllReserves().size());
        
        //Reinsert and test
        assertEquals("the reserve count should be 2", 2, rManager.getAllReserves().size());
       
        //Setter and getter tester
        assertEquals("the capacity should be 55000", 55000, rManager.getReserve(fManager.getFuel("testFuel")).getCapacity());
        
        //assertTrue(rManager.getReserve(fManager.getFuel("testFuel")).setCost(2500));
        assertEquals("the cost should be 2500", 2500, rManager.getReserve(fManager.getFuel("testFuel")).getCost());
        
        //assertTrue(rManager.getReserve(fManager.getFuel("testFuel")).setMaxDurability(1500));
        assertEquals("the max durability should be 1500", 1500, rManager.getReserve(fManager.getFuel("testFuel")).getMaxDurability());
        
        //assertTrue(rManager.getReserve(fManager.getFuel("testFuel")).setRemaining(200));
        assertEquals("the remaining should be 200", 200, rManager.getReserve(fManager.getFuel("testFuel")).getRemaining());
        
        //assertTrue(rManager.getReserve(fManager.getFuel("testFuel")).setRepairCost(1));
        assertEquals("the repair cost should be 1", 1, rManager.getReserve(fManager.getFuel("testFuel")).getRepairCost());
    }

    
    /**
     * Test for the pumpManager.
     * @param pManager Pump manager from the main model
     */
    public void testPumpManager(final PumpManager pManager) {
        //Insert the first pump and testing if it's there
        assertNotNull(pManager.getPumpByName("pumpTest"));
        assertNotNull(pManager.getPump(0));
        assertNotNull(pManager.getAllPumps());
        assertEquals("there must be only 1 pump", 1, pManager.getAllPumps().size());
        
        //Insert the second pump and testing if it's there
        assertNotNull(pManager.getPumpByName("pumpTest2"));
        assertNotNull(pManager.getPump(1));
        assertNotNull(pManager.getAllPumps());
        assertEquals("there must be 2 pumps", 2, pManager.getAllPumps().size());
              
        //Removing pump and reinsert it
        assertEquals("there must be 1 pump", 1, pManager.getAllPumps().size());
        assertEquals("there must be 2 pumps", 2, pManager.getAllPumps().size());
        
        assertNotNull(pManager.getPumpByName("pumpTest3"));
        assertEquals("the name should be pumpTest3", "pumpTest3", pManager.getPumpByName("pumpTest3").getName());
        
        //Testing getters and setters
        assertEquals("the max durability should be 1500", 1500, pManager.getPumpByName("pumpTest3").getMaxDurability());
        
        assertEquals("the cost should be 2500", 2500, pManager.getPumpByName("pumpTest3").getCost());
        
        assertEquals("the repair cost should be 15", 15, pManager.getPumpByName("pumpTest3").getRepairCost());
        
        pManager.getPumpByName("pumpTest3").consume();
        assertEquals("the durability should be 1999", 1999, pManager.getPumpByName("pumpTest3").getDurability());
        
        assertEquals("the speed should be 150", 150, pManager.getPumpByName("pumpTest3").getSpeed());
    }
    
    /**
      * Tester for the areaManager.
     * @param aManager the areaManager from the main model
     * @param pManager the pumpManager from the main model
     */
    public void testAreaManager(final AreaManager aManager, final PumpManager pManager) { 
        //Creating list of pumps
        List<Pump> pumps = new ArrayList<>();
        pumps.add(pManager.getPumpByName("pumpTest"));
        pumps.add(pManager.getPumpByName("pumpTest3")); 
        
        //Insert the first area and removing it
        assertTrue(aManager.addArea(0, 0, pumps));
        assertNotNull(aManager.getArea(0, 0));
        assertEquals("the area count should be 1", 1, aManager.getAllAreas().size());        
        assertTrue(aManager.removeArea(0, 0));
        assertEquals("the area count should be 0", 0, aManager.getAllAreas().size()); 
        
        //Testing some inserts right and wrong
        assertTrue(aManager.addArea(0, 0, pumps));
        assertFalse(aManager.addArea(0, 0, pumps));
        assertTrue(aManager.addArea(1, 1, pumps));
        
        //Testing getters of area
        assertNull(aManager.getArea(2, 2));
        assertNotNull(aManager.getArea(0, 0));
        assertNotNull(aManager.getArea(1, 1));
        
        //Testing getters
        assertTrue(aManager.getArea(0, 0).setPosition(3, 3));
        assertEquals("the x position should be 3", 3, aManager.getArea(0, 0).getXPosition());
        assertEquals("the y position should be 3", 3, aManager.getArea(0, 0).getYPosition());
        
        //Testing adding and removing pump
        assertTrue(aManager.getArea(3, 3).addPump(pManager.getPumpByName("pumpTest")));
        assertEquals("the pump count should be 3", 3, aManager.getArea(3, 3).getPumpsCount());      
        assertTrue(aManager.getArea(3, 3).removePump(pManager.getPumpByName("pumpTest2")));
        assertEquals("the pump count should be 2", 2, aManager.getArea(3, 3).getPumpsCount());
        
        //Testing the occupy of the area
        assertTrue(aManager.getArea(3, 3).isOccupied());
    }
    
    /**
     * Test the moneyManager.
     * @param mManager Money Manager from the main model
     */
    public void testMoneyManager(final MoneyManager mManager) {
        
        //Controlling number of movements
        assertNotNull(mManager.getAllMovements());
        assertEquals("the count should be 3", 3, mManager.getAllMovements().size());
        
        //Controlling balance
        assertEquals("the balance should be 10000", 10000, mManager.getActualBalance());
    }
    
    /**
     * Test the consumers.
     * @param vehicle vehicle to test
     * @param fManager fuel manager from the main model
     */
    public void testConsumers(final Vehicle vehicle, final FuelManager fManager) {
        
        //Controlling getters
        assertEquals("the request should be 100", 100, vehicle.getRequest());
        assertEquals("the request should be 100", 100, vehicle.getFuel());
    }
}
