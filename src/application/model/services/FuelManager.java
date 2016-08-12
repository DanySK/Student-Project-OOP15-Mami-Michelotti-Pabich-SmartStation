package application.model.services;

import java.util.List;

public interface FuelManager {
	
    //TODO ti devo dare in ingresso una stringa (tipo BENZINA) e tu indipendentemente se sia scritto BenZinA, benzina, Benzina o BENZINA devi capire che
    //si tratta effettivamente di lei e darmi l'oggetto FUEL corrispondente
    Fuel getFuel(String fuel);
    
    List<Fuel> getAllFuels();
    
    void addFuel(final Fuel name);
    
    void removeFuel(final Fuel name);
    
    void removeFuels();
}
