import java.util.Scanner;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    Investor j = new Investor();
    double costInBillions = 5000;
    String s = "";
    ArrayList<Investor> investors = new ArrayList<Investor>();
    String name="";
    double annualEnergyCost=0;
    double annualEnergy=0;
    boolean b = true;
    final double worldEnergy = 21776;
    String q = "";

  System.out.println("You may edit all data after input is complete");     
  System.out.println("Do you want to add a new country as an investor? (Yes/No)");
    s = scan.nextLine();

   while(!(s.equals("Yes")||s.equals("No"))){
        System.out.println("Command not recognized. Do you want to add a new country as an investor? (Yes/No)");
          s = scan.nextLine();
   }
    
      while(s.equals("Yes")){
        b = true;
        System.out.print("\nEnter name of country: ");
          name = scan.nextLine();
        System.out.print("\nEnter amount of money the country spends on energy year (billions USD): $");
          annualEnergyCost = scan.nextDouble();
        System.out.print("\nEnter amount of energy the country consumes per year (teraWatt hours): ");
          annualEnergy = scan.nextDouble();
        
        if(investors.size()==0)
               b=true;
        else{
          for(int i = 0; i<investors.size();i++){
            if(name.substring(1).equals(investors.get(i).getName().substring(1))){
                b = false;
                System.out.println("\nYou have already added a country with this name.");
                i = investors.size();
              }
          }
        
          }
      
          if(b){
            j = new Investor(name, annualEnergyCost, annualEnergy);
            investors.add(j);
          }
          
          System.out.println("\nDo you want to add a new country as an investor? (Yes/No)");
            scan.next();
            s = scan.nextLine();
                    
          while(!(s.equals("Yes")||s.equals("No"))){
            System.out.println("\nCommand not recognized. Do you want to add a new country as an investor? (Yes/No)");
            s = scan.nextLine();
          } 
       
          }
        


  System.out.println("\nWould you like to edit any data (Yes/No)?\n");  
      s = scan.next(); 
      while(!(s.equals("Yes")||s.equals("No"))){
            System.out.println("Command not recognized. Do you want to add a new country as an investor? (Yes/No)");
            s = scan.nextLine();
          }  
                
      String answer = "";
      int index = 0;
      String countryName = "";
      boolean x = false;

    while(s.equals("Yes")){

      x = false;
      System.out.println("\nWould you like to edit the country name, energy consumption, or energy cost?");
          answer = scan.next();
      if(answer.equals("country name")||answer.indexOf("ame")!=-1){
          System.out.println("\nWhat is the current name of the country");
            countryName = scan.next();
          
          for(int i = 0; i<investors.size(); i++){
            if(investors.get(i).getName().equals(countryName)){
              x = true;
              index = i;
              }
            }

          if(x){
            System.out.println("\nWhat name would you like to change "+countryName+" to?");
              investors.get(index).setName(scan.next());
            }

            else{
              System.out.println("\nNo country is currently called "+countryName);   
          }
      }
          
      else if(answer.equals("energy consumption")||answer.indexOf("onsumption")!=-1){
        System.out.println("\nWhat is the current name of the country");
            countryName = scan.next();
          
          for(int i = 0; i<investors.size(); i++){
            if(investors.get(i).getName().equals(countryName)){
                x = true;
                index = i;
            }
          }

          if(x){
            System.out.println("\nWhat value would you like to change the energy consumption to?");
            investors.get(index).setAnnualEnergy(scan.nextDouble());
            }
          else
            System.out.println("\nNo country is currently called "+countryName); 
          }
      else if(answer.equals("energy cost")||answer.indexOf("ost")!=-1){
        System.out.println("\nWhat is the current name of the country");
            countryName = scan.next();
          
          for(int i = 0; i<investors.size(); i++){
            if(investors.get(i).getName().equals(countryName)){
              x = true;
              index = i;
              }
          }

          if(x){
            System.out.println("\nWhat value would you like to change the annual energy cost to?");
            investors.get(index).setAnnualEnergyCost(scan.nextDouble());
            }
          else
            System.out.println("\nNo country is currently called "+countryName); 
                }

        System.out.println("\nWould you like to edit any data (Yes/No)?");  
           s = scan.next();
        }   



    int countries=investors.size();
    double investorConsumption1 = 0;
    double investorConsumption2 = 0;

    for(int i = 0; i<investors.size()/2; i++){
        investorConsumption1+=investors.get(i).getAnnualEnergyConsumption();
    }
    for(int i = investors.size()/2; i< investors.size(); i++){
        investorConsumption2+=investors.get(i).getAnnualEnergyConsumption();
    }

    double nonInvestorConsumption = 0.9*(worldEnergy - investorConsumption1-investorConsumption2);


  System.out.println("\n\nInitial cost per country: $"+costInBillions*10000*100000/countries);
    //cost per country calculation 

  System.out.println("Annual profit per country: $"+nonInvestorConsumption*38.0*1000*1000);

  for(int i = 0; i<investors.size(); i++){
        System.out.println("Years before "+investors.get(i).getName()+" breaks even: "+(costInBillions*10000*100000/countries)/(nonInvestorConsumption*38.0+investors.get(i).getAnnualEnergyCost()*10000*100000));
          //cost per country / (annual profit+money saved)
    }

  }
}
