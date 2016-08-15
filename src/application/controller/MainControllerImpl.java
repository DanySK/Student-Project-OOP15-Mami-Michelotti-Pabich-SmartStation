package application.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import application.controller.tabs.*;
import application.model.Station;
import application.model.buildables.area.*;
import application.model.buildables.pump.*;
import application.model.services.*;
import application.view.MainContent;
import javafx.scene.paint.Color;

/**
 * Class that implements the logic of the main controller.
 * @author Matteo Michelotti
 */
public class MainControllerImpl implements MainController {

    private Station station;
    private MainContent view;
    
    private final FuelsEditorCtrl fuelsEditorCtrl;
    private final MovementsViewerCtrl movementsViewerCtrl;
    private final OverviewCtrl overviewCtrl;
    private final PumpsEditorCtrl pumpsEditorCtrl;
    private final ReservesEditorCtrl reservesEditorCtrl;
    private final StationEditorCtrl stationEditorCtrl;
    
    private Fuel f;
    private Pump p;
    private Area a;
    
    private boolean name = false;
    private boolean open = false;
    private boolean maxareas = false;
    private boolean maxpumps = false;
    private boolean balance = false;
    private boolean price = false;
    private boolean wholesaleprice = false;
    private boolean color = false;
    private boolean type = false;
    private boolean capacity = false;
    private boolean remaining = false;
    private boolean fuel = false;
    private boolean speed = false;
    private boolean durability = false;
    private boolean repairCost = false;
    private boolean actualDurability = false;
    private boolean xPos = false;
    private boolean yPos = false;
    private boolean position = false;
    
    private String dName, dFuel;
    private int dPrice, dWPrice, dSpeed, dDurability, dRepairCost, dActualDurability;
    private int dCapacity, dRemaining, dXPos, dYPos, dPosition;
    private Color dColor;

    public MainControllerImpl() {
	this.fuelsEditorCtrl = new FuelsEditorCtrlImpl(this);
	this.movementsViewerCtrl = new MovementsViewerCtrlImpl(this);
	this.overviewCtrl = new OverviewCtrlImpl(this);
	this.pumpsEditorCtrl = new PumpsEditorCtrlImpl(this);
	this.reservesEditorCtrl = new ReservesEditorCtrlImpl(this);
        this.stationEditorCtrl = new StationEditorCtrlImpl(this);
    }

    @Override
    public FuelsEditorCtrl getFuelsEditorController() {
	return this.fuelsEditorCtrl;
    }

    @Override
    public MovementsViewerCtrl getMovementsViewerController() {
	return this.movementsViewerCtrl;
    }
    
    @Override
    public OverviewCtrl getOverviewController() {
	return this.overviewCtrl;
    }

    @Override
    public PumpsEditorCtrl getPumpsEditorController() {
	return this.pumpsEditorCtrl;
    }

    @Override
    public ReservesEditorCtrl getReservesEditorController() {
	return this.reservesEditorCtrl;
    }

    @Override
    public StationEditorCtrl getStationEditorController() {
	return this.stationEditorCtrl;
    }

    @Override
    public void setModel(Station station) {
	this.station = station;
    }

    @Override
    public Station getModel() {
	return this.station;
    }

    @Override
    public void setView(MainContent mainContent) {
	this.view = mainContent;
	
	this.fuelsEditorCtrl.setView(this.view.getFuelsEditorTab());
	this.movementsViewerCtrl.setView(this.view.getMovementsViewerTab());
	this.overviewCtrl.setView(this.view.getOverviewTab());
	this.pumpsEditorCtrl.setView(this.view.getPumpsEditorTab());
	this.reservesEditorCtrl.setView(this.view.getReservesEditorTab());
	this.stationEditorCtrl.setView(this.view.getStationEditorTab());
    }

    @Override
    public void loadConfiguration() {
	try {	    
	    XMLInputFactory factory = XMLInputFactory.newInstance();
	    XMLEventReader eventReader =
	    factory.createXMLEventReader(new FileReader(new File(getClass()
		    .getResource("/resources/configuration.xml").toURI())));
	    
	    while(eventReader.hasNext()) {
		XMLEvent event = eventReader.nextEvent();
		switch(event.getEventType()) {
		    case XMLStreamConstants.START_ELEMENT:
		    StartElement startElement = event.asStartElement();
                    String sName = startElement.getName().getLocalPart();
                    
		    if(sName.equalsIgnoreCase("name")) {
			name = true;
		    } else if (sName.equalsIgnoreCase("open")) {
			open = true;
		    } else if (sName.equalsIgnoreCase("maxareas")) {
			maxareas = true;
		    } else if (sName.equalsIgnoreCase("maxpumps")) {
			maxpumps = true;
		    } else if (sName.equalsIgnoreCase("balance")) {
			balance = true;
		    } else if (sName.equalsIgnoreCase("fuels")) {
			fileFuel(eventReader);
		    }
		    break;
		    case XMLStreamConstants.CHARACTERS:
	            Characters characters = event.asCharacters();
	            if(name) {
	        	//
	        	System.out.println(characters.getData());
	        	name = false;
	            }
	            if(open) {
	        	if(Boolean.parseBoolean(characters.getData())) {
	        	    this.station.open();
	        	} else {
	        	    this.station.close();
	        	    System.out.println(characters.getData());
	        	}
	        	open = false;
	            }
	            if(maxareas) {
	        	this.stationEditorCtrl.loadData(Integer.parseInt(characters.getData()),
	        					Integer.parseInt(characters.getData()));
	        	System.out.println(characters.getData());
	        	maxareas = false;
	            }
	            if(maxpumps) {
	        	//
	        	System.out.println(characters.getData());
	        	maxpumps = false;
	            }
	            if(balance) {
	        	//
	        	System.out.println(characters.getData());
	        	balance = false;
	            }
	            break;
	        }
	    }
	} catch (FileNotFoundException e) {
            e.printStackTrace();  
            
	} catch (XMLStreamException e) {
	    e.printStackTrace();

	} catch (Exception e) {
	    e.printStackTrace();
        }
    }
    
    private void fileFuel(XMLEventReader eventReader) throws Exception{
	while(eventReader.hasNext()) {
	    XMLEvent event = eventReader.nextEvent();
	    switch(event.getEventType()) {
	        case XMLStreamConstants.START_ELEMENT:
		StartElement startElement = event.asStartElement();
                String sName = startElement.getName().getLocalPart();
                
                if(sName.equalsIgnoreCase("name")) {
                    name = true;
		} else if (sName.equalsIgnoreCase("price")) {
		    price = true;
		} else if (sName.equalsIgnoreCase("wholesaleprice")) {
		    wholesaleprice = true;
		} else if (sName.equalsIgnoreCase("color")) {
		    color = true;
		} else if (sName.equalsIgnoreCase("reserves")) {
		    fileReserve(eventReader);
		}
                break;
	        case XMLStreamConstants.CHARACTERS:
	        Characters characters = event.asCharacters();
	        if(name) {
	            this.dName = characters.getData();
	            System.out.println(characters.getData());
	            name = false;
	        }
	        if(price) {
	            this.dPrice = Integer.parseInt(characters.getData());
	            System.out.println(characters.getData());
	            price = false;
	        }
	        if(wholesaleprice) {
	            this.dWPrice = Integer.parseInt(characters.getData());
	            System.out.println(characters.getData());
	            wholesaleprice = false;
	        }
	        if(color) {
	            this.dColor = Color.valueOf(characters.getData());
	            //this.f = new FuelImpl(this.dName, this.dPrice, this.dWPrice, this.dColor);
		    //this.fManager.addFuel(this.f);
		    System.out.println(characters.getData());
	            color = false;
	        }
	        break;
            }
	}
    }
    
    private void fileReserve(XMLEventReader eventReader) throws Exception{
	while(eventReader.hasNext()) {
	    XMLEvent event = eventReader.nextEvent();
	    switch(event.getEventType()) {
	        case XMLStreamConstants.START_ELEMENT:
		StartElement startElement = event.asStartElement();
                String sName = startElement.getName().getLocalPart();
                
                if(sName.equalsIgnoreCase("type")) {
                    type = true;
		} else if (sName.equalsIgnoreCase("capacity")) {
		    capacity = true;
		} else if (sName.equalsIgnoreCase("remaining")) {
		    remaining = true;
		} else if (sName.equalsIgnoreCase("pumps")) {
		    filePump(eventReader);
		}
                break;
	        case XMLStreamConstants.CHARACTERS:
	        Characters characters = event.asCharacters();
	        if(type) {
	            //this.f = this.fManager.getFuel(characters.getData());
	            System.out.println(characters.getData());
	            type = false;
	        }
	        if(capacity) {
	            this.dCapacity = Integer.parseInt(characters.getData());
	            System.out.println(characters.getData());
	            capacity = false;
	        }
	        if(remaining) {
	            this.dRemaining = Integer.parseInt(characters.getData());
	            //inserire riserve
	            //nel model
	            System.out.println(characters.getData());
	            remaining = false;
	        }
	        break;
            }
	}
    }

    private void filePump(XMLEventReader eventReader) throws Exception{
	while(eventReader.hasNext()) {
	    XMLEvent event = eventReader.nextEvent();
	    switch(event.getEventType()) {
	        case XMLStreamConstants.START_ELEMENT:
		StartElement startElement = event.asStartElement();
                String sName = startElement.getName().getLocalPart();
                
                if(sName.equalsIgnoreCase("name")) {
                    name = true;
		} else if (sName.equalsIgnoreCase("fuel")) {
		    fuel = true;
		} else if (sName.equalsIgnoreCase("speed")) {
		    speed = true;
		} else if (sName.equalsIgnoreCase("durability")) {
		    durability = true;
		} else if (sName.equalsIgnoreCase("price")) {
		    price = true;
		} else if (sName.equalsIgnoreCase("repairCost")) {
		    repairCost = true;
		} else if (sName.equalsIgnoreCase("actualDurability")) {
		    actualDurability = true;
		} else if (sName.equalsIgnoreCase("areas")) {
		    fileArea(eventReader);
		}
                break;
	        case XMLStreamConstants.CHARACTERS:
	        Characters characters = event.asCharacters();
	        if(name) {
	            this.dName = characters.getData();
	            System.out.println(characters.getData());
	            name = false;
	        }
	        if(fuel) {
	            this.dFuel = characters.getData();
	            System.out.println(characters.getData());
	            fuel = false;
	        }
	        if(speed) {
	            this.dSpeed = Integer.parseInt(characters.getData());
	            System.out.println(characters.getData());
	            speed = false;
	        }
	        if(durability) {
	            this.dDurability = Integer.parseInt(characters.getData());
	            System.out.println(characters.getData());
	            durability = false;
	        }
	        if(price) {
	            this.dPrice = Integer.parseInt(characters.getData());
	            System.out.println(characters.getData());
	            price = false;
	        }
	        if(repairCost) {
	            this.dRepairCost = Integer.parseInt(characters.getData());
	            System.out.println(characters.getData());
	            repairCost = false;
	        }
	        if(actualDurability) {
	            this.dActualDurability = Integer.parseInt(characters.getData());
	            //this.p = new PumpImpl(this.dDurability, this.dPrice, this.dRepairCost, this.dName, this.fManager.getFuel(this.dFuel), this.dSpeed);
	            //this.pManager.addPump(this.p);
	            System.out.println(characters.getData());
	            actualDurability = false;
	        }
	        break;
	    }
	}
    }

    private void fileArea(XMLEventReader eventReader) throws Exception{
	final List<Pump> list = new ArrayList<>();
        //list.addAll(this.pManager.getAllPumps());
        
	while(eventReader.hasNext()) {
	    XMLEvent event = eventReader.nextEvent();
	    switch(event.getEventType()) {
	        case XMLStreamConstants.START_ELEMENT:
		StartElement startElement = event.asStartElement();
                String sName = startElement.getName().getLocalPart();
                
                if(sName.equalsIgnoreCase("xpos")) {
                    xPos = true;
		} else if (sName.equalsIgnoreCase("ypos")) {
		    yPos = true;
		} else if(sName.equalsIgnoreCase("name")) {
	            name = true;
		} else if (sName.equalsIgnoreCase("position")) {
		    position = true;
		}
                break;
	        case XMLStreamConstants.CHARACTERS:
	        Characters characters = event.asCharacters();
	        if(xPos) {
	            this.dXPos = Integer.parseInt(characters.getData());
	            System.out.println(characters.getData());
	            xPos = false;
	        }
	        if(yPos) {
	            this.dYPos = Integer.parseInt(characters.getData());
	            //this.a = new AreaImpl(this.dDurability, this.dPrice, this.dRepairCost, this.dXPos, this.dYPos);
	            System.out.println(characters.getData());
	            yPos = false;
	        }
	        if(name) {
	            this.dName = characters.getData();
	            for (Pump p : list) {
	                if(p.getName() == this.dName) {
	                    System.out.println("usafibfsaiub");
	                    this.a.addPump(p);
	                }
	            }
	            System.out.println(characters.getData());
	            name = false;
	        }
	        if(position) {
	            this.dPosition = Integer.parseInt(characters.getData());
	            //this.aManager.addArea(this.a);
	            System.out.println(characters.getData());
	            position = false;
	        }
	        break;
            }
	}
    }
}
