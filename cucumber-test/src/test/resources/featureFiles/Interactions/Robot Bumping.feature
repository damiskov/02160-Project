Feature: Robot Bumping

Scenario: Robot as an obstacle on the right side
	 Given a game with an empty board
	 And a robot on the board at (5, 5) facing "right"
	 And a second robot on the board at (6, 5) facing "right"
	 When one robot moves 
	 Then the first robot is at (6, 5)
	 Then the second robot is at (7, 5)
	 
Scenario: Robot as an obstacle on the right side on three steps
	 Given a game with an empty board
	 And a robot on the board at (3, 5) facing "right"
	 And a second robot on the board at (6, 5) facing "right"
	 When the robot tries to move 3 steps
	 Then the first robot is at (6, 5)
	 Then the second robot is at (7, 5)

Scenario: Robot as an obstacle on the left side
	 Given a game with an empty board
	 And a robot on the board at (6, 5) facing "left"
	 And a second robot on the board at (5, 5) facing "left"
	 When one robot moves 
	 Then the first robot is at (5, 5)
	 Then the second robot is at (4, 5)
	 
Scenario: Robot as an obstacle in the forward direction
	 Given a game with an empty board
	 And a robot on the board at (5, 5) facing "up"
	 And a second robot on the board at (5, 6) facing "up"
	 When one robot moves 
	 Then the first robot is at (5, 6)
	 Then the second robot is at (5, 7)
	 
Scenario: Robot as an obstacle in the backward direction
	 Given a game with an empty board
	 And a robot on the board at (5, 5) facing "down"
	 And a second robot on the board at (5, 4) facing "down"
	 When one robot moves 
	 Then the first robot is at (5, 4)
	 Then the second robot is at (5, 3)
	 
Scenario: Third Robot as an obstacle in the way of second robot in the right direction
	 Given a game with an empty board
	 And a robot on the board at (5, 5) facing "right"
	 And a second robot on the board at (6, 5) facing "right"
	 And a third robot on the board at (7, 5) facing "right"
	 When one robot moves 
	 Then the first robot is at (6, 5)
	 Then the second robot is at (7, 5)
	 Then the third robot is at (8, 5)
	 
Scenario: Wall as an obstacle in the way of second robot in the right direction
	 Given a game with an empty board
	 And a robot on the board at (5, 5) facing "right"
	 And a second robot on the board at (6, 5) facing "right"
	 And a wall on the board at (7, 5)
	 When one robot moves 
	 Then the first robot is at (5, 5)
	 Then the second robot is at (6, 5)

Scenario: Wall as an obstacle in the way of second robot in the right direction after three steps
	 Given a game with an empty board
	 And a robot on the board at (3, 5) facing "right"
	 And a second robot on the board at (4, 5) facing "right"
	 And a wall on the board at (7, 5)
	 When the robot tries to move 3 steps 
	 Then the first robot is at (5, 5)
	 Then the second robot is at (6, 5)
	 
Scenario: Wall as an obstacle in the way of second robot in the forward direction
	 Given a game with an empty board
	 And a robot on the board at (5, 5) facing "up"
	 And a second robot on the board at (5, 6) facing "up"
	 And a wall on the board at (5, 7)
	 When one robot moves 
	 Then the first robot is at (5, 5)
	 Then the second robot is at (5, 6)
Scenario: Wall as an obstacle in the way of second robot in the backward direction
	 Given a game with an empty board
	 And a robot on the board at (5, 5) facing "down"
	 And a second robot on the board at (5, 4) facing "down"
	 And a wall on the board at (5, 3)
	 When one robot moves 
	 Then the first robot is at (5, 5)
	 Then the second robot is at (5, 4)
Scenario: Wall as an obstacle in the way of second robot in the left direction
	 Given a game with an empty board
	 And a robot on the board at (6, 5) facing "left"
	 And a second robot on the board at (5, 5) facing "left"
	 And a wall on the board at (4, 5)
	 When one robot moves 
	 Then the first robot is at (6, 5)
	 Then the second robot is at (5, 5)

