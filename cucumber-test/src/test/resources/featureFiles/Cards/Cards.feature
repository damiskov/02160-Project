Feature: Programming Cards


	Scenario: Accept the programming card
  	Given a player
  	And a Deck
    When a Hand is created 
    Then the player accepts nine cards
    
  Scenario: Programming the cards
  	Given a player with a robot
  	And a non empty program
    When a card is taken from the front of the program
    Then the robot executes the action on the card

  #ROBOT TURNING RIGHT
 	Scenario: A robot turns right from pointing up
  	Given a game with an empty board
  	And a robot on the board at (5, 5) facing "up"
    When a turn right command is executed
    Then the robot is at (5, 5) facing "right"
    
  Scenario: A robot turns right from pointing right
  	Given a game with an empty board
  	And a robot on the board at (5, 5) facing "right"
    When a turn right command is executed
    Then the robot is at (5, 5) facing "down"
  
  Scenario: A robot turns right from pointing down
  	Given a game with an empty board
  	And a robot on the board at (5, 5) facing "down"
    When a turn right command is executed
    Then the robot is at (5, 5) facing "left"
    
  Scenario: A robot turns right from pointing left
  	Given a game with an empty board
  	And a robot on the board at (5, 5) facing "left"
    When a turn right command is executed
    Then the robot is at (5, 5) facing "up"
    
  #ROBOT TURNING LEFT
  Scenario: A robot turns left from pointing up
  	Given a game with an empty board
  	And a robot on the board at (5, 5) facing "up"
    When a turn left command is executed
    Then the robot is at (5, 5) facing "left"
    
  Scenario: A robot turns left from pointing left
  	Given a game with an empty board
  	And a robot on the board at (5, 5) facing "left"
    When a turn left command is executed
    Then the robot is at (5, 5) facing "down"
  
  Scenario: A robot turns left from pointing down
  	Given a game with an empty board
  	And a robot on the board at (5, 5) facing "down"
    When a turn left command is executed
    Then the robot is at (5, 5) facing "right"
    
  Scenario: A robot turns left from pointing right
  	Given a game with an empty board
  	And a robot on the board at (5, 5) facing "right"
    When a turn left command is executed
    Then the robot is at (5, 5) facing "up"
    
  #ROBOT MOVING FORWARD
  
  Scenario: A robot moves forward when pointing right
  	Given a game with an empty board
  	And a robot on the board at (5, 5) facing "right"
    When a move forward command is executed
    Then the robot is at (6, 5) facing "right"
    
 
 	Scenario: A robot moves forward when pointing left
  	Given a game with an empty board
  	And a robot on the board at (5, 5) facing "left"
    When a move forward command is executed
    Then the robot is at (4, 5) facing "left"
    
 	Scenario: A robot moves forward when pointing up
  	Given a game with an empty board
  	And a robot on the board at (5, 5) facing "up"
    When a move forward command is executed
    Then the robot is at (5, 6) facing "up"
    
	Scenario: A robot moves forward when pointing down
  	Given a game with an empty board
  	And a robot on the board at (5, 5) facing "down"
    When a move forward command is executed
    Then the robot is at (5, 4) facing "down"
  
  
  #ROBOT MOVING BACKWARD
  
 	Scenario: A robot moves backward when pointing right
  	Given a game with an empty board
  	And a robot on the board at (5, 5) facing "right"
    When a move backward command is executed
    Then the robot is at (4, 5) facing "right"
    
 
 	Scenario: A robot moves backward when pointing left
  	Given a game with an empty board
  	And a robot on the board at (5, 5) facing "left"
    When a move backward command is executed
    Then the robot is at (6, 5) facing "left"
    
 	Scenario: A robot moves backward when pointing up
  	Given a game with an empty board
  	And a robot on the board at (5, 5) facing "up"
    When a move backward command is executed
    Then the robot is at (5, 4) facing "up"
    
	Scenario: A robot moves backward when pointing down
  	Given a game with an empty board
  	And a robot on the board at (5, 5) facing "down"
    When a move backward command is executed
    Then the robot is at (5, 6) facing "down"
    
  #moves 2 times 
  
	Scenario: A robot moves forward two spaces when pointing down
  	Given a game with an empty board
  	And a robot on the board at (5, 5) facing "down"
    When a move forward 2 command is executed
    Then the robot is at (5, 3) facing "down"
  
 	Scenario: A robot moves forward two spaces when pointing down
  	Given a game with an empty board
  	And a robot on the board at (5, 5) facing "down"
    When a move forward 3 command is executed
    Then the robot is at (5, 2) facing "down"
  
  

  Scenario: Move the robot one step in the direction it is facing
  	Given a game with an empty board
  	And a Move1 card
    And a robot on the board
    When the card is executed
    Then the robot moves one step in its direction
    
   

  Scenario: Move the robot two steps in the direction it is facing
  	Given a game with an empty board
  	And a Move2 card
  	And a robot on the board
    When the card is executed
    Then the robot moves two steps in its direction
    
  Scenario: Move the robot three steps in the direction it is facing
  	Given a game with an empty board
  	And a Move3 card
    And a robot on the board
    When the card is executed
    Then the robot moves three steps in its direction
    
      
  Scenario: Rotate robot to the right through ninety degrees
  	Given a game with an empty board
  	And Right Direction card
    And a robot on the board
    When the card is executed
    Then the robot moves ninety degrees to the right
    
    
  Scenario: Rotate robot to the right through ninety degrees
  	Given a game with an empty board
  	And Left turn card
    And a robot on the board
    When the card is executed
    Then the robot moves ninety degrees to the left 


  Scenario: Move the robot at one hundred eighty degrees angle
  	Given a game with an empty board
  	And UTurn card
    And a robot on the board
    When the card is executed
    Then the robot faces opposite orientation
    
    
  Scenario: Move the robot in the downwards direction
  	Given a game with an empty board
  	And Backup card
    And a robot on the board
    When the card is executed
    Then the robot moves one space back without changing its direction
    
  Scenario: Move the robot back in two steps
  	Given a game with an empty board
  	And a robot on the board at (5, 5) facing "up"
    When a move backwards two command is executed
    Then the robot is at (5, 3) facing "up"
    
  Scenario: Move the robot back in three steps
  	Given a game with an empty board
  	And a robot on the board at (5, 5) facing "up"
    When a move backwards three command is executed
    Then the robot is at (5, 2) facing "up"
   