package au.com.optus.domain.impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import au.com.optus.domain.DictionaryService;

@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(DictionaryServiceImpl.class);
	
	private Object[] keys = new Object[20];
	private Object[] values = new Object[20];	
	
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
	
	public String sortedList() {
		
		String finalString = "\n";
		
		ArrayList<String> sortedList = new ArrayList<String>();
		for (int i = 0; i < keys.length; i++) {
			sortedList.add((String) values[i]);
		}
		
		if (sortedList.isEmpty()) {
			LOGGER.info("No values found in the dictionary");
			return null;
		}
		
		for (String str : sortedList) {
			
			if (str != null) {
			finalString += str;
			finalString += ",";
			}
		}
		
		return finalString;
	}


	public void clear() {
		for (int i = 0; i < keys.length; i++) {
			keys[i] = null;
			values[i] = null;
		}
		LOGGER.info("cleared  {} no of items from dictionary", keys.length);
	}
	
	public synchronized void setValue(int i, Object value) {
		values[i] = value;
	}
	

}
