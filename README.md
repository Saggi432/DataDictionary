# Outline
This code represents a small Spring based Dictionary controller. The controller maintains a mapping or words to
their description, and has methods to:
	* Add a new word / definition
	* Lookup a word
	* Clear all
	* Clear all and bulk add new definitions

# Task
Your task is to:

- Cleanup & refactor the existing code, fix any defects you find, using best practices and any libraries or 
standard classes you feel are appropriate.

- Add unit tests and appropriate test coverage, using an appropriate unit test library.

- Make sure all methods return the correct responses, as detailed in the sample request/responses below.

- Add a new controller method to return the contents of the dictionary, sorted in reverse alphabetical case insensitive 
order, by word (see the last operation below for an example of the output).

- Clean up the pom.xml file such that I can run "mvn clean install" to run tests and compile successfully, using Java
version 1.6 and upwards.

- BONUS POINTS: Convert this to a regular Spring based .war file, or a Spring boot application (http://projects.spring.io/spring-boot/) that can be started at the command line, and provide brief instructions about how startup and run the app.


- Ensure you code is compatible with Java 1.6.

# Interface Contract
I should get the following output when I execute the below sequence of HTTP calls against the controller:

/put?word=car,description=something to get you from A to B -> "ok"

/put?word=dog,description=An animal -> "ok"

/lookup?word=car -> "something to get you from A to B"

/lookup?word=animal -> "no result"

/clearAllAndAdd?word=java&word=c++&description=Java can run anywhere&description=C++ is a hard language -> "ok"

/clearAllAndAdd?word=alien&word=bike&description=strange  -> "error"

/sortedDictionary -> "Java, C++, bird"

# Submission
Push your code up to github and sent back the URL to your repo.
 
https://github.com/Saggi432/DataDictionary


Basic Setup Instructions:
------------------------

1) Clone the Project from GIT Hub using the below URL.

https://github.com/Saggi432/DataDictionary.git

satish@satish-Lenovo-V570:~/Downloads$ git clone https://github.com/Saggi432/DataDictionary.git
Cloning into 'DataDictionary'...
remote: Counting objects: 120, done.
remote: Compressing objects: 100% (84/84), done.
remote: Total 120 (delta 24), reused 100 (delta 6), pack-reused 0
Receiving objects: 100% (120/120), 26.76 MiB | 3.13 MiB/s, done.
Resolving deltas: 100% (24/24), done.
Checking connectivity... done.


2) Once Complete, in the DataDictionary Directory, please execute the command "mvn spring-boot:run"

3) Perform the below test case execution steps ..

                       Basic Test Case Execution:
                       ------------------------


	a) put?word=car,description=something to get you from A to B -> "ok"

	This requirement is working as is tested with the below URL on the system.

	http://localhost:8080/put?word=car&description=something%20to%20get%20you%20from%20A%20to%20B

	b)/put?word=dog,description=An animal -> "ok"

	This requirement is working as is tested with the below URL on the system.

	http://localhost:8080/put?word=dog&description=animal


	c) /lookup?word=car -> "something to get you from A to B"

	/lookup?word=animal -> "no result"

	d) /clearAllAndAdd?word=java&word=c++&description=Java can run anywhere&description=C++ is a hard language -> "ok"

	/clearAllAndAdd?word=alien&word=bike&description=strange  -> "error"

	Below is the ClearAllAndAdd execution

	http://localhost:8080/clearAndAdd?word=hello&description=greeting&word=day&description=monday


/sortedDictionary -> "Java, C++, bird"



 
BONUS POINTS: Convert this to a regular Spring based .war file, or a Spring boot application (http://projects.spring.io/spring-boot/) that can be started at the command line, and provide brief instructions about how startup and run the app.

[Satish] Currently we are able to use the "mvn spring-boot:run" to get the application running on tomcat. By changing pom.xml "packaging" paremeter to "war" we are able to generate war. But by default it is a jar for now.


