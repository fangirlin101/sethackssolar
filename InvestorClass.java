public class Investor{
  private String name;
  private double annualEnergyCost;
  private double annualEnergy;

  public Investor(String n, double a, double b){
    name = n;
    annualEnergyCost =a;
    annualEnergy = b;
  }

  public Investor(){
    name = "";
    annualEnergyCost = 0;
    annualEnergy = 0;
  }

  public String getName(){
    return name;
  }
  public double getAnnualEnergyCost(){
    return annualEnergyCost;
  }
  public double getAnnualEnergyConsumption(){
    return annualEnergy;
  }
  public void setName(String n){
    name = n;
  }
  public void setAnnualEnergyCost(double a){
    annualEnergyCost= a;
  }
  public void setAnnualEnergy(double b){
    annualEnergy=b;
  }
  
}
