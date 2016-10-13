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


//WaterChargeCalculator Main Class 
public class WaterChargeCalculatorTest
{              
	//Method main creates WaterChargeCalculator object, calls beginCharge and displayInfo
	public static void main (String[] args)	{
           
             WaterChargeCalculator app;
               app = new WaterChargeCalculator();
               app.beginCharge();
               app.displayInfo();
                       
        }//End method main


}//End WaterChargeCalculatorTest