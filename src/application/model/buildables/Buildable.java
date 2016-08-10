package application.model.buildables;

public interface Buildable {
	
int getCost();
	
	void setCost(int cost);
	
	int getDurability();
	
	void setMaxDurability(int durability);
	
    int getRepairCost();
	
	void setRepairCost(int repairCost);
	
	void repair(int percentage);
}
