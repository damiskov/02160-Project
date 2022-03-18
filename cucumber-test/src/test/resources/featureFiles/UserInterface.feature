@tag
Feature: User Interface
  This feature handles how the user sees the game

  @tag1
  Scenario: Update board on screen
  	Given a board array
  	When update board on screen
  	Then draw board
  	
  Scenario: Update obstacles
  	Given board on screen
  	When update obstacles on screen
  	Then draw obstacles
  	
  Scenario: Update robots
  	Given board on screen
  	And obstacles on screen
  	When update robots on screen
  	Then draw robots
  	And draw robot player markers
  	
  Scenario: Show player cards
    Given a screen
    And player turn is current player
    When show current player hand
    Then draw current player cards
  	

  
