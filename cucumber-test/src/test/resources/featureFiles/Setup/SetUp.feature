@tag
Feature: Setting up game

	@tag1
	Scenario: Board set up
		Given A Host
		And a Difficulty
		When Start button pressed
		Then Generate Board
		
	Scenario: Robot assignment 
		Given A Player
		When Robot selected by Player
		Then Assign Robot to Player
