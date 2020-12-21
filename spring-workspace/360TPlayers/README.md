### Given a Player class - an instance of which can communicate with other Players.

The requirements are as follows:

1. create 2 Player instances
2. one of the players should send a message to second player (let's call this player "initiator")
3. when a player receives a message, it should reply with a message that contains the received message 
concatenated with the value of a counter holding the number of messages this player already sent.
4. finalize the program (gracefully) after the initiator sent 10 messages and received back 10 messages (stop condition)
5. both players should run in the same java process (strong requirement)
6. document for every class the responsibilities it has.
7. additional challenge (nice to have) opposite to 5: have every player in a separate JAVA process.

Please use core Java as much as possible without additional frameworks like Spring etc; focus on design and not on the technology.
Please include a maven project with the source code to build the jar and a shell script to start the program.
Everything not specified is to be decided by you; everything specified is a hard requirement.


### Compile the Java application:

1. Execute the **players.sh** script included in the root folder
2. At the root folder level execute the following command:
    ```
	mvn clean compile assembly:single
	```
  
1. Execute the application, if the port parameter isn't specified will be defined by value at the **application.properties** file.
    
   ```
   java -jar target/360TPlayers-0.0.1-SNAPSHOT-jar-with-dependencies.jar [port]   
   ``` 
    
1. Execution example end stop
    ```
    λ ./players.sh
	
	[...maven compile..]
	
    2020-08-25 13:12:34 INFO  Player:38 - Greetings, I'am Initiator and I've sent 1 messages
	2020-08-25 13:12:34 INFO  Player:38 - Greetings, I'am Receptor and I've sent 1 messages
	2020-08-25 13:12:34 INFO  Player:38 - Greetings, I'am Initiator and I've sent 2 messages
	2020-08-25 13:12:34 INFO  Player:38 - Greetings, I'am Receptor and I've sent 2 messages
	2020-08-25 13:12:34 INFO  Player:38 - Greetings, I'am Initiator and I've sent 3 messages
	2020-08-25 13:12:34 INFO  Player:38 - Greetings, I'am Receptor and I've sent 3 messages
	2020-08-25 13:12:34 INFO  Player:38 - Greetings, I'am Initiator and I've sent 4 messages
	2020-08-25 13:12:34 INFO  Player:38 - Greetings, I'am Receptor and I've sent 4 messages
	2020-08-25 13:12:34 INFO  Player:38 - Greetings, I'am Initiator and I've sent 5 messages
	2020-08-25 13:12:34 INFO  Player:38 - Greetings, I'am Receptor and I've sent 5 messages
	2020-08-25 13:12:34 INFO  Player:38 - Greetings, I'am Initiator and I've sent 6 messages
	2020-08-25 13:12:34 INFO  Player:38 - Greetings, I'am Receptor and I've sent 6 messages
	2020-08-25 13:12:34 INFO  Player:38 - Greetings, I'am Initiator and I've sent 7 messages
	2020-08-25 13:12:34 INFO  Player:38 - Greetings, I'am Receptor and I've sent 7 messages
	2020-08-25 13:12:34 INFO  Player:38 - Greetings, I'am Initiator and I've sent 8 messages
	2020-08-25 13:12:34 INFO  Player:38 - Greetings, I'am Receptor and I've sent 8 messages
	2020-08-25 13:12:34 INFO  Player:38 - Greetings, I'am Initiator and I've sent 9 messages
	2020-08-25 13:12:34 INFO  Player:38 - Greetings, I'am Receptor and I've sent 9 messages
	2020-08-25 13:12:34 INFO  Player:38 - Greetings, I'am Initiator and I've sent 10 messages
	2020-08-25 13:12:34 INFO  Player:38 - Greetings, I'am Receptor and I've sent 10 messages
   ```