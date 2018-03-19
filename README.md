# Anagram-Finder
To find anagrams in a dictionary
To configure and run the app.
-	To run the program, make sure that you need to install the Java development Kit and have a proper java Run time environment.
-	For example: I have used the version jdk version – 1.8.0_112.
-	Initially you need to set the path in the Environment System Variables.
-	For example, 
The following path is set: C:\Program Files\Java\jdk1.8.0_112
-	Select one from below to run the program.

Running program in command prompt:
-	Make sure that the environment variable is set properly by typing javac in the command prompt. It needs to display some set of suggestions on how to use the command.
-	If everything above is set properly, to compile the given code enter:
-	To run 1st version - javac AnagramFinder1.java
-	To run 2nd version - javac AnagramFinder2.java
-	This compiles the given java file
-	Then to run the 1st version of program type:  java AnagramFinder1 dictionary.txt
-	For 2nd version - java AnagramFinder2 dictionary.txt
-	Here dictionary.txt is the input file, if the file is not in the same folder as that of java files, make sure to give the path of the input file.

Running program in eclipse:
-	Make sure you install Eclipse.
-	Open the project.
-	Select the AnagramFinder1.java file or AnagramFinder2.java
-	Right click and run as Run Configurations.
-	In the arguments tab, give the path of the dictionary file and run the program.
-	path example - C:\Users\Varshini\Desktop\dictionary.txt

Anagram Finder Version 1
-	The time complexity for loading the dictionary – O(n) 
-	To find the anagram words O(n)
-	Space complexity is O(n)

Anagram Finder Version 2
-	Time complexity for loading the dictionary and preprocessing – klogk
Where k is the number of characters in the word. 
-	To find the anagram words O(1).
-	Space complexity is O(n)

Time taken to complete the task
-	I took around 2 hours to complete 1st version of the program.
-	Around 3 – 4 hours to complete 2nd version considering all test cases.
