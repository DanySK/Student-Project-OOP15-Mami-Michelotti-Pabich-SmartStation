package application.model.buildables;

public interface Buildable {
	
    int getCost();
	
    void setCost(final int cost);
	
    int getDurability();
    
    int getMaxDurability();
	
    void setMaxDurability(final int durability);
	
    int getRepairCost();
	
    void setRepairCost(final int repairCost);
    
    void consume();
    
    void repair(final int percentage);
}
