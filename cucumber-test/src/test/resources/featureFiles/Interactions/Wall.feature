Feature: Wall

	Scenario: Wall stops the robot from the right side
	 Given a game with an empty board
	 And a wall on the board at (6, 5)
   And a robot on the board at (5, 5) facing "right"
   When the robot tries to move one step 
   Then the robot stays at (5, 5)
  
  Scenario: Wall stops the robot from the right side on first step
	 Given a game with an empty board
	 And a wall on the board at (6, 5)
   And a robot on the board at (5, 5) facing "right"
   When the robot tries to move 2 steps 
   Then the robot stays at (5, 5)
   
  Scenario: Wall stops the robot from the right side with two steps
	 Given a game with an empty board
	 And a wall on the board at (7, 5)
   And a robot on the board at (5, 5) facing "right"
   When the robot tries to move 2 steps
   Then the robot stays at (6, 5)
  
  Scenario: Wall stops the robot from the right side with three steps
	 Given a game with an empty board
	 And a wall on the board at (8, 5)
   And a robot on the board at (5, 5) facing "right"
   When the robot tries to move 3 steps 
   Then the robot stays at (7, 5)
   
  Scenario: Wall stops the robot from the left side
	 Given a game with an empty board
	 And a wall on the board at (4, 5)
   And a robot on the board at (5, 5) facing "left"
   When the robot tries to move one step
   Then the robot stays at (5, 5)
   
 	Scenario: Wall stops the robot from the left side on two steps
	 Given a game with an empty board
	 And a wall on the board at (3, 5)
   And a robot on the board at (5, 5) facing "left"
   When the robot tries to move one step
   Then the robot stays at (4, 5)
  
  Scenario: Wall stops the robot from the front side
   Given a game with an empty board
   And a wall on the board at (5, 6)
   And a robot on the board at (5, 5) facing "up"
   When the robot tries to move one step
   Then the robot stays at (5, 5)
  
  Scenario: Wall stops the robot from the front side on three steps
   Given a game with an empty board
   And a wall on the board at (5, 8)
   And a robot on the board at (5, 5) facing "up"
   When the robot tries to move 3 steps
   Then the robot stays at (5, 7)
  
  Scenario: Wall stops the robot from the back side
	 Given a game with an empty board
	 And a wall on the board at (5, 4)
   And a robot on the board at (5, 5) facing "down"
   When the robot tries to move one step
   Then the robot stays at (5, 5)
   
  Scenario: Wall stops the robot from the back side on three steps
   Given a game with an empty board
   And a wall on the board at (5, 2)
   And a robot on the board at (5, 5) facing "down"
   When the robot tries to move 3 steps
   Then the robot stays at (5, 3)
