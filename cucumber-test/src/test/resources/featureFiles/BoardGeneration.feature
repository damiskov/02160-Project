
Feature: Board Generation

Scenario: Generate an easy Board
	Given two players
	And robots for the players
  And an easy difficulty 
  When a board is generated
  Then an easy board is generated
    
Scenario: Generate a medium board
	Given two players
	And robots for the players
  And a medium difficulty 
  When a board is generated
  Then a medium board is generated  

Scenario: Generate a hard board
  Given two players
	And robots for the players
  And a hard difficulty 
  When a board is generated
  Then a hard board is generated
