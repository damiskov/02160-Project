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