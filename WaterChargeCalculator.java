/**
 *******************************************************************
 * All code contained within is released under the GNU v3 license
 * 
 * Please respect and support open source software and it's creators
 * 
 * Project Name - Water Charge Calculator
 * Project Purpose - To determine the total charge owed from a pre-
 * determined number of clients. Total charge will be determined via
 * a sliding rate scale according to usage amount.
 * 
 * 
 * Initial Creation Date is Jul 24, 2013
 * Written by Josh Cannons
 */
import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class WaterChargeCalculator {
    
    // User Defined Variables
    private int tier_max = 24;  // Rate (in kL) at which tiers change
    private double rate = 0.7; //Rate (as a decimal) at which water is charged per kL
    final int N = 8; //Higest number in strudent number
    
    // Do Not Edit Past This Line
    public double charge;
    public String name;
    public int usage;
    public double avg;
    public double max;
    public double tot;
    String project = "Water Use Charge Caluclator";
    Scanner input = new Scanner(System.in);
    String results = "";
    DecimalFormat d;   

      
    // Initialise Usage Constructor
    public WaterChargeCalculator () {
        usage = 0;
        } // end usage constructor
    
    
    // Start Method beginCharge
    public void beginCharge( ) {
        int count = 0;  
        d= new DecimalFormat("$# 00.00");
        
            System.out.printf("\n\n**** Welcome to the %s ****\n\n", project);
            while ( count < N) {     
                System.out.print("Enter Resident's Name Please : ");
                name = input.nextLine(); 
                System.out.printf("\nEnter %s's Usage Please : ", name);
                usage = input.nextInt();   
                
                while (usage < 1 || usage > 200) {
                      System.out.print("Water usage is too low, Please enter an amount between 1 and 200\n");
                      System.out.printf("Enter %s's Usage Please : ", name);
                      usage = input.nextInt();
                      }
                
           calculateCharge (usage);              
           System.out.printf("\nThe total charge for resident - %s is : %s\n\n-----------------------------------------------\n\n", name, d.format(charge));
           
           if (charge > max){
               max = charge;
           }
           
           tot = tot + charge;
           
           avg = (tot / N);
           
           results = results +""+name+"                 "+usage+"kL         "+d.format(charge)+"\n";
           input.nextLine();
           count++;
           }
    }
    
    
    // Start Method calculateCharge
    public double calculateCharge (int u) {
        if (u <= tier_max)
            charge = usage*rate;
        
        else if (u <=(2*tier_max))
            charge= (24*rate)+(usage-24)*(rate*1.05);
        
        else if (u <=(3*tier_max))
            charge= (24*rate )+(25*(rate*1.05))+(usage-49)*(rate*1.10);
        
        else
            charge= (24*rate)+(25*(rate*1.05))+(25*(rate*1.10))+(usage-74)*(rate*1.15);               
        
        return charge;
    } // end calculateCharge
    
    // Start Method displayInfo
    public void displayInfo() {

                
        System.out.println("          Water Charge Calculator          ");
        System.out.println("===========================================");
        System.out.println("Name                  Usage         Charge ");
        System.out.println("===========================================");
        System.out.println(results+"\n");
       
        String message = String.format("The total charge for all residents is: %s\nThe average charge for all users is: %s\nThe maximum charge is: %s\n", d.format(tot), d.format(avg), d.format(max));
        System.out.printf("%s",message);
        System.out.printf("\n\nThankyou for using the %s. \nPlease have a nice day, and remember...\nWe are in short supplies, Be water wise!!!", project);
        JOptionPane.showMessageDialog(null,message);
        
    } // end displayInfo
    
      
} //End Class WaterChargeCalculator
