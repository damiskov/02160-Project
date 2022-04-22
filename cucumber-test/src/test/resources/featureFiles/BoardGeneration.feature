
Feature: Board Generation

Scenario: Generate an easy Board
	Given two players
	And robots for the players
  And an easy difficulty 
  Then An easy board is generated
    
Scenario: Generate a medium board
	Given two players
	And robots for the players
  And a medium difficulty 
  Then A medium board is generated  

Scenario: Generate a hard board
  Given two players
	And robots for the players
  And a hard difficulty 
  Then A hard board is generated
