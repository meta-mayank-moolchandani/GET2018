package cart;

import java.time.*;
import java.util.*;

public class PromotionEnum {

	final String FixedOrderPromoCode = "ABCDE";
	final String FixedProductPromoCode = "EDCBA";
	final String startDate = "1-7-2018";
	final String endDate = "30-7-2018";
	
	
	public boolean inBetween(){
		
		LocalDate today = java.time.LocalDate.now();
		
		String dateArray[] = endDate.split("-");  
		
		int year = Integer.parseInt(dateArray[2]);
		int month = Integer.parseInt(dateArray[1]);
		int date = Integer.parseInt(dateArray[0]);
	    
		LocalDate endDate = LocalDate.of(year,month,date);
		
		
		Period period = Period.between(today , endDate );
		Integer daysElapsed = period.getDays ();
		int days = Integer.parseInt(daysElapsed.toString());
		
		if(days>=0){
			return true;
		}else{
			return false;
		}
	}

}
