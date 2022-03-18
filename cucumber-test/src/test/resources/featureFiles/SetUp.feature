@tag
Feature: Setting up game

	@tag1
	Scenario: Board set up
		Given A Host
		And A difficulty
		Then Create a Board
  	
	Scenario: Robot assignment 
		Given A Robot
		And A Player 
		Then Assign Robot to Player
  	
	Scenario: Select Robot skin
		Given A Player
		Then Assign robot to player
		When the Player selects a robot skin
		Then Robot acquires this skin
	  
	Scenario: Difficulty change
		Given a difficulty
		Then Generate map