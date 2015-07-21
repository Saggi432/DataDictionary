package au.com.optus.domain.impl;

import java.util.ArrayList;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import au.com.optus.domain.DictionaryService;

@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(DictionaryServiceImpl.class);
	
	private Object[] keys = new Object[20];
	private Object[] values = new Object[20];	


	
     /*************************************
      The put function, which inserts the
      word and corresponding description	
     * 
     * @param key
     * @param value
     * @return void
     *******************************************/

	public void put(Object key, Object value) {
		LOGGER.info("Put key {} - value {} ", key , value);
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] == null || value.equals(keys[i])) {
				// Make sure no one else can update the dictionary.
				LOGGER.info("added valueat at {} ", i);
				synchronized (key) {
					keys[i] = key;
					values[i] = value;
				}
				break;
			}
		}
	}

     /*************************************
      The get function to retrieve the
      values for a given key
     * 
     * @param key
     * @return object
     *******************************************/
	
	public Object get(Object key) {
		LOGGER.info("Getting  value  for key {} ", key);
		for (int i = 0; i < keys.length; i++) {
			if (key.equals(keys[i])) {
				LOGGER.info(" values[i] {} ", values[i]);
				return values[i];
			}
		}
		LOGGER.info("No values found in the dictionary for key {} ", key);
		return null;
	}


     /*************************************
      The SortedList function used to
      sort the keys and reverse the order
     * 
     * @param none
     * @return String
     *******************************************/
	
	public String sortedList() {
        
        	String finalString = "\n";
        
        	ArrayList<String> sortedList = new ArrayList<String>();
        	for (int i = 0; i < keys.length; i++) {
            		if(null != keys[i]) {
                	sortedList.add((String) keys[i]);
            		}
        	}
        
        	if (sortedList.isEmpty()) {
            		LOGGER.info("No values found in the dictionary");
            		return null;
        	}
        
        	Collections.sort(sortedList, Collections.reverseOrder());
        
        	for (String str : sortedList) {
            
            	if (str != null) {
            		finalString += str;
            		finalString += ",";
            	}
              }
        
        	return finalString.replaceAll("\\s+","");
        }

       



     /*************************************
       The clear method erases the  current
       contents of keys and values and assigns to null
     * 
     * @param none
     * @return none
     *******************************************/

	public void clear() {
		for (int i = 0; i < keys.length; i++) {
			keys[i] = null;
			values[i] = null;
		}
		LOGGER.info("cleared  {} no of items from dictionary", keys.length);
	}


     /*************************************
	Synchronized method of setValue
     * 
     * @param int
     * @param object
     * @return none
     *******************************************/

	
	public synchronized void setValue(int i, Object value) {
		values[i] = value;
	}
	

}
