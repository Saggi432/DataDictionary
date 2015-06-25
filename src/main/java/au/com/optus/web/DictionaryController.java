package au.com.optus.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import au.com.optus.domain.impl.DictionaryServiceImpl;

/**
 * Controller that provides a dictionary style service to users.
 *
 */
@RestController
public class DictionaryController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(DictionaryController.class);

	// The dictionary will store a mapping of String words to String
	// explanations.
	@Autowired
	private DictionaryServiceImpl dictionaryService;

	private Object tempWord;
	private Object tempDescription;

	@RequestMapping("/")
	public String greeting() {
		LOGGER.info("Hello All");
		return "Hi Optus . Greetings from Spring Boot!";
	}

	@RequestMapping(value = "/lookup", method = RequestMethod.GET)
	@ResponseBody
	public String lookupWord(@RequestParam String word) {
		Object x = dictionaryService.get(word);
		if (x == null) {
			return "no result";
		}
		String xs = x.toString();
		return xs;
	}

	@RequestMapping(value = "/put", method = RequestMethod.GET)
	@ResponseBody
	public String putDescription(@RequestParam String word,
			@RequestParam String description) {
		tempWord = word;
		tempDescription = description;
		putInDictionary();
		return "ok";
	}

	private void putInDictionary() {
		LOGGER.info("Put key {} and  value {} in dictionary ",tempWord , tempDescription);
		dictionaryService.put(tempWord, tempDescription);
	}

	@RequestMapping(value = "/clear", method = RequestMethod.GET)
	@ResponseBody
	public String clear() {
		System.out.println("Clearing keys.");
		dictionaryService.clear();
		return "ok";
	}

	@RequestMapping(value = "/clearAndAdd")
	@ResponseBody
	public String clearAndAdd(@RequestParam String[] word,
			@RequestParam String[] description) {
		LOGGER.info("Clearing keys.");
		LOGGER.info("word lenghth " + word.length);
		if (word.length != description.length) {
			System.exit(1);
		}

		dictionaryService.clear();
		
		for (int i = 0; i < word.length; i++) {
			dictionaryService.put(word[i], description[i]);
		}

		return "ok";
	}


   	@RequestMapping(value = "/SortedDictionary")
        @ResponseBody
        public String SortedDictionary() {
                LOGGER.info("In the sorted Dictionary Method.");

                return dictionaryService.sortedList();
        }



}
