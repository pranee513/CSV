
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

/**
 * Created by pbathini on 2/15/2019.
 */
public class ProductCSVTest {
	
	/*
	 * this test verifies the processing valid data and returns Sorted by price
	 */

	 @Test
	 public void testSortingValidData() {
		 
	  //Preparing test Data
	  String header = "Category, Part #, Description, UOM, price, discount";	 
	  String line1 = "66447,Keyboard,wired keyboard box,$38.30/Box ,$20,12%";
	  String line2 = "88834,Mouse,wireless mouse box,$38.30/Box ,$17,3%";
	  ArrayList<String> testData = new ArrayList<>();
	  testData.add(header);
	  testData.add(line1);
	  testData.add(line2);
	  
	 //Verifying using implementation class
	  ArrayList<Product> result = ProductCSV.convertToProducts(testData);
	  
	  //asserting the result
	  assertNotNull(result);
	  //header will be removed
	  assertEquals(result.size(), testData.size());
	  //Sorting by Price
	  assertEquals(result.get(0).part, "Mouse");//17$
	  assertEquals(result.get(1).part, "Keyboard");//20$
	  
	}
	 
   /*
    * this test verify the invalid columns will not process,expected empty result
    */
   @Test 
   public void invalidColumns() {
	   
	 //Preparing test Data
	 String header = "Category, Part #, Description, UOM, price, discount";	   
	 String line ="FMC013, Toilet Paper, $0.45/Each";
	 ArrayList<String> testData = new ArrayList<>();
	 testData.add(header);
	 testData.add(line);
	 
	//Verifying using implementation class
	 ArrayList<Product> result = ProductCSV.convertToProducts(testData);
	  
	 //asserting the result
	  assertTrue(result.isEmpty());
	 
   }
}
