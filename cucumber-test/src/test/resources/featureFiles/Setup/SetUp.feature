@tag
Feature: Setting up game

# Gave an error because the step definition for "given a difficulty" takes a string as argument, but no string is passed here

#	@tag1
#	Scenario: Board set up
#		Given A Host
#		And a Difficulty
#		When Start button pressed
#		Then Generate Board
		
	Scenario: Robot assignment 
		Given A Player
		When Robot selected by Player
		Then Assign Robot to Player
