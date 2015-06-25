package au.com.optus.domain;

public interface DictionaryService {
	public void put(Object key, Object value);

	public Object get(Object key);

	public void clear();

}
