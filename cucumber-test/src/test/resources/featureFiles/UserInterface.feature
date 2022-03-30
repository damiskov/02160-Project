@tag
Feature: User Interface
  This feature handles how the user sees the game

  @tag1
  Scenario: Update board on screen
  	Given a screen
  	And a board array
  	When update board on screen
  	Then display board on screen
  	
  Scenario: Update obstacles
  	Given a screen
  	And a board on screen
  	When update obstacles on screen
  	Then display obstacles on screen
  	
  Scenario: Update robots
  	Given a screen
  	And a board on screen
  	And obstacles on screen
  	When update robots on screen
  	Then display robots with markers and HP on screen
  	
  Scenario: Show player cards
    Given a screen
    And player turn is current player
    When show current player hand
    Then display current player cards on screen
    
  Scenario: Show player turn
  	Given a screen
  	When show current player number
  	Then display current player number on screen
  	

  
