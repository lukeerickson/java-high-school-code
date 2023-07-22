package cellPhone;

import java.util.Scanner;
import java.text.DecimalFormat;
/** 
 * Take the VERY LONG calculateOverageCharge() method and deconstruct it into private helper methods.
 *      - Calculate data overage
 *      - Calculate minutes overage
 *      - Print bill
 *      
 * Does the driver program need to change at all?
 * 
 * @author Mr. Nichols 
 * @version 9-21-16
 */
public class CellPhone
{  
    private String accountName;
    private boolean hasData1, hasData2, hasMinute1, hasMinute2;
    private double dataCharge, minuteCharge;
    
    private final int DATA_PLAN_1_GIGS = 2;
    private final int DATA_PLAN_2_GIGS = 5;
    
    private final int MINUTE_PLAN_1_MINUTES = 100;
    private final int MINUTE_PLAN_2_MINUTES = 250;    
    
    private final int DATA_OVERAGE_CHARGE = 10;
    private final double MINUTE_OVERAGE_CHARGE = 0.1;
    
    public CellPhone()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("What would you like to name your account?");
        accountName = in.nextLine();
        System.out.println("Please select your data plan:");
        System.out.println("\t1) 2 Gigabytes \n\t2) 5 Gigabytes");
        int dataChoice = in.nextInt();
        System.out.println("Please select your minutes plan:");
        System.out.println("\t1) 100 Minutes \n\t2) 250 Minutes");
        int minuteChoice = in.nextInt();
        if (dataChoice == 1)
        {
            hasData1 = true;
            hasData2 = false;
        }
        else
        {
            hasData1 = false;
            hasData2 = true;
        }
        
        if (minuteChoice == 1)
        {
            hasMinute1 = true;
            hasMinute2 = false;
        }
        else
        {
            hasMinute1 = false;
            hasMinute2 = true;
        }
    }
    
    /*
     *  Calls appropriate helper methods to calculate total overage bill.
     *  @param minutesUsed integer value of minutes used
     *  @param gigsUsed double value of gigabites used
     */
    public void calculateOverageCharge(int minutesUsed, double gigsUsed)
    {
    	
        calculateMinutes(minutesUsed);
        calculateData(gigsUsed);
        printBill();
        
    }
    
    public void calculateMinutes(double minutesUsed) {
		
    	if (hasMinute1)
        {
            if (minutesUsed > MINUTE_PLAN_1_MINUTES)
                {
                    minuteCharge = (minutesUsed - MINUTE_PLAN_1_MINUTES) * MINUTE_OVERAGE_CHARGE;
                }
        }
        
        else
        {
            if (minutesUsed > MINUTE_PLAN_2_MINUTES)
                {
                    minuteCharge = (minutesUsed - MINUTE_PLAN_2_MINUTES) * MINUTE_OVERAGE_CHARGE;
                }
        }
    	
	}
    
    public void calculateData(double gigsUsed) {
    	
    	 if (hasData1)
         {
             if (gigsUsed > DATA_PLAN_1_GIGS)
                 {
                     dataCharge = (gigsUsed - DATA_PLAN_1_GIGS) * DATA_OVERAGE_CHARGE;
                 }
         }
         
         else
         {
             if (gigsUsed > DATA_PLAN_2_GIGS)
                 {
                     dataCharge = (gigsUsed - DATA_PLAN_2_GIGS) * DATA_OVERAGE_CHARGE;
                 }
         }  
    	
    }
    
    public void printBill() {
    	
    	 DecimalFormat money = new DecimalFormat("$###,###.##");
         
         System.out.println("**********************************************************");
         System.out.println("***************** YOUR OVERAGES OVERAGES *****************");
         System.out.println("**********************************************************");
         System.out.println();
         System.out.println();
         System.out.println("         Your data overage charge: " + money.format(dataCharge));
         System.out.println("         Your minute overage charge: " + money.format(minuteCharge));
         System.out.println();
         System.out.println();
         System.out.println("**********************************************************");
         System.out.println("********************** THANK YOU! ************************");
         System.out.println("************** PLEASE PAY YOUR BILL ON TIME **************");
         System.out.println("**********************************************************");
    	
    }
    
}

	
