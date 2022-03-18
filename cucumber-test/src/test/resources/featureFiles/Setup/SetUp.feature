@tag
Feature: Setting up game

	@tag1
	Scenario: Board set up
		Given A Host
		When A difficulty is selected by Host
		Then Create a Board
  	
	Scenario: Robot assignment 
		Given A Player
		When Robot selected by Player
		Then Assign Robot to Player
  	
	Scenario: Select Robot skin
		Given A Player
		And A Robot
		When the Player selects a Robot skin
		Then Robot acquires skin
	  