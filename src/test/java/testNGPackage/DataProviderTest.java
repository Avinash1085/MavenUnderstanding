package testNGPackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest 
{
	@DataProvider (name = "data-provider_2DArray")
	 public Object[][] dpMethod(){
	 return new Object[][] {{"Row 0 value-Avi","Col 0 value-Ambavale"}, {"Row 1 value-Pooja","Col 1 value-Ambavale"}};
	 }
	 
	    @Test (dataProvider = "data-provider_2DArray")
	    public void myTest (String val,String arg2) {
	        System.out.println("Passed Parameter Is : " + val + " Argument2 : "+arg2);
	        
	        String s1=null;
	        for(int i=0;i<=1;i++)
	        {
	        	if(i==0)
	        	s1=val;
	        }
	        System.out.println("Value of S1 is : "+s1);
	    }

	    
		@DataProvider (name = "SingleElement")
		 public Object[][] dpMethod_orig(){
		 return new Object[][] {{"Element at 0th Index"}, {"Element at 1st Index"}};
		 }
		 
		    @Test (dataProvider = "SingleElement")
		    public void myTest_orig (String val) {
		        System.out.println("Passed Parameter Is : " + val);
		    }

}
