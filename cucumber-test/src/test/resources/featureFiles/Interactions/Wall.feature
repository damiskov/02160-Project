Feature: Wall

	Scenario: Wall stops the robot from the right side
	 Given a game with an empty board
	 And a wall on the board at (6, 5)
   And a robot on the board at (5, 5) facing "right"
   When the robot tries to move one step 
   Then the robot stays at (5, 5)
  
  #Scenario: Wall stops the robot from the right side with two steps
#	 Given a game with an empty board
#	 And a wall on the board at (7, 5)
   #And a robot on the board at (5, 5) facing "right"
   #When the robot tries to move 2 steps
   #Then the robot stays at (6, 5)
  
  #Scenario: Wall stops the robot from the right side with three steps
#	 Given a game with an empty board
#	 And a wall on the board at (8, 5)
   #And a robot on the board at (5, 5) facing "right"
   #When the robot tries to move three steps 
   #Then the robot stays at (7, 5)
   
  Scenario: Wall stops the robot from the left side
	 Given a game with an empty board
	 And a wall on the board at (4, 5)
   And a robot on the board at (5, 5) facing "left"
   When the robot tries to move one step
   Then the robot stays at (5, 5)
  
  Scenario: Wall stops the robot from the front side
   Given a game with an empty board
   And a wall on the board at (5, 6)
   And a robot on the board at (5, 5) facing "up"
   When the robot tries to move one step
   Then the robot stays at (5, 5)
  
  
  Scenario: Wall stops the robot from the back side
	 Given a game with an empty board
	 And a wall on the board at (5, 4)
   And a robot on the board at (5, 5) facing "down"
   When the robot tries to move one step
   Then the robot stays at (5, 5)
   
   
  #Scenario: Wall stops the robot from the back side
#	 Given a game with an empty board
#	 And a wall on the board at (6, 5)
   #And a robot on the board at (5, 5) facing "down"
   #When the robot moves one step "down"
   #Then the robot stays at (5, 5)
   #
   #
  #Scenario: Wall stops the robot from the back side
#	 Given a game with an empty board
#	 And a wall on the board at (6, 5)
   #And a robot on the board at (5, 5) facing "down"
   #When the robot moves one step "down"
   #Then the robot stays at (5, 5)
  #
  #Scenario: Wall stops the robot from the front side
#	 Given a game with an empty board
#	 And a wall on the board at (6, 5)
   #And a robot on the board at (5, 5) facing "left"
   #When the robot moves one step to the "left"
   #Then the robot stays at (5, 5)
  
  #Scenario: Wall stops the robot from the right side
#	 Given a game with an empty board
#	 And a wall on the board at (6, 5)
   #And a robot on the board at (5, 5) facing "right"
   #When the robot moves three steps to the "right"
   #Then the robot moves to (6, 5) is the same as staying at (5, 5)
#
#	Scenario: Wall stops the robot from the left side
#	 Given a game with an empty board
#	 And a wall on the board at (6, 5)
   #And a robot on the board at (5, 5) facing "right"
   #When the robot moves one step to the "right"
   #Then the robot moves to (6, 5) is the same as staying at (5, 5)
#
#	Scenario: Wall stops the robot from the left side
#	 Given a game with an empty board
#	 And a wall on the board at (6, 5)
   #And a robot on the board at (5, 5) facing "right"
   #When the robot moves one step to the "right"
   #Then the robot moves to (6, 5) is the same as staying at (5, 5)
   #
  #Scenario: Wall stops the robot from the left side
#	 Given a game with an empty board
#	 And a wall on the board at (6, 5)
   #And a robot on the board at (5, 5) facing "right"
   #When the robot moves one step to the "right"
   #Then the robot moves to (6, 5) is the same as staying at (5, 5)
#
   #
   #
#	Scenario: Wall stops the robot from the left side
#	 Given a wall on the left side of the robot
#	 And a robot on the board
#	 When robot bumps into the wall from the left side
#	 Then wall stops the robot from the left
#	 
#	Scenario: Wall stops the robot in the direction it is facing
#	 Given a wall standing infront of the robot
#	 And a robot on the board
#	 When robot bumps into the wall in its facing direction
#	 Then wall stops the robot from moving forward
#	 
#	Scenario: Wall stops the robot from the opposite direction
#	 Given a wall standing behined the robot
#	 And a robot on the board
#	 When robot bumps in the wall from behind
#	 Then wall stops the robot from moving backward