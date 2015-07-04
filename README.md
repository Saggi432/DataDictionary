# Outline
This code represents a small Spring based Dictionary controller. The controller maintains a mapping or words to
their description, and has methods to:
	* Add a new word / definition
	* Lookup a word
	* Clear all
	* Clear all and bulk add new definitions

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


2) Once Complete, in the DataDictionary Directory, please execute the command "mvn spring-boot:run" or you can Import the project into eclipse and select the option to Run as --> "Spring Boot App". I am using Spring tool suite, there should not be much change in eclipse as well.

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
        
	http://localhost:8080/lookup?word=bird


	d) /clearAllAndAdd?word=java&word=c++&description=Java can run anywhere&description=C++ is a hard language -> "ok"

	/clearAllAndAdd?word=alien&word=bike&description=strange  -> "error"

	Below is the ClearAllAndAdd execution

	http://localhost:8080/clearAndAdd?word=hello&description=greeting&word=day&description=monday


	e) /sortedDictionary -> "Java, C++, bird"
	
	Below is the sortedDictionary execution.

	http://localhost:8080/SortedDictionary


 
Currently we are able to use the "mvn spring-boot:run" to get the application running on tomcat. By changing pom.xml "packaging" paremeter to "war" we are able to generate war. But by default it is a jar for now.


