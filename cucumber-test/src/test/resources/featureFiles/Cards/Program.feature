Feature: Executing program

Scenario: Taking and executing card at top of program
	Given a game with an empty board
	And a robot on the board
	And a program for the robot
	When the first card is executed 
	Then the top card is removed
