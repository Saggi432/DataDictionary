package au.com.optus.domain.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DictionaryServiceImplTest {
	
	DictionaryServiceImpl dictionaryService;
	
	@Before
    public void init() {
        dictionaryService = new DictionaryServiceImpl();
    }
	
	@Test
    public void test_put() {
		//Arrange and Act
		dictionaryService.put("Java", "Good Language");
		dictionaryService.put("C", "Good Old Language");
		dictionaryService.put(".Net", "Microsoft Language");
		dictionaryService.put("COBOL", "Very old Language");
	}
	
	@Test
    public void test_get() {
		//Arrange and Act
		dictionaryService.put("Java", "Good Language");
		dictionaryService.put("C", "Good Old Language");
		dictionaryService.put(".Net", "Microsoft Language");
		dictionaryService.put("COBOL", "Very old Language");

		//Assert
		String description = null; 
		description = (String) dictionaryService.get("Java");
		Assert.assertTrue("Good Language".equals(description));
		description = (String) dictionaryService.get("C");
		Assert.assertTrue("Good Old Language".equals(description));
		description = (String) dictionaryService.get(".Net");
		Assert.assertTrue("Microsoft Language".equals(description));
		description = (String) dictionaryService.get("COBOL");
		Assert.assertTrue("Very old Language".equals(description));
	}
	
	@Test
    public void test_clear() {
		//Arrange
		dictionaryService.put("Java", "Good Language");
		dictionaryService.put("C", "Good Old Language");
		dictionaryService.put(".Net", "Microsoft Language");
		dictionaryService.put("COBOL", "Very old Language");

		//Act
		dictionaryService.clear();
		
		//Assert
		Assert.assertNull(dictionaryService.get("Java"));
		Assert.assertNull(dictionaryService.get("C"));
		Assert.assertNull(dictionaryService.get(".Net"));
		Assert.assertNull(dictionaryService.get("COBOL"));
	}
	@Test
    public void test_sorted() {
        //Arrange
        dictionaryService.put("Java", "Good Language");
        dictionaryService.put("C", "Good Old Language");
        dictionaryService.put(".Net", "Microsoft Language");
        dictionaryService.put("COBOL", "Very old Language");

        //Act
        String sorted = dictionaryService.sortedList();
        
        System.out.println("The sorted String is" + sorted);
        
        String Sort1 = sorted.replaceAll("\\s+","");                  
        
        Assert.assertTrue("Java,COBOL,C,.Net,".equals(Sort1));
    }
}
