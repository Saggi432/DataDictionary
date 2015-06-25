package au.com.optus.domain;

// This interface helps us with the basic operations
// such as put, get clear..etc; 

public interface DictionaryService {
	public void put(Object key, Object value);

	public Object get(Object key);

	public void clear();
  
        public String sortedList();

}
