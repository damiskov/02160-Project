
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
  

#only for coverage
Scenario: Generate a super hard board and creating an instance of BoardFactory (for 100% although useless)
  Given two players
	And robots for the players
  And a super hard difficulty 
  And a BoardFactory
  When a board is generated
  Then no board is generated
  
#only for coverage
Scenario: Naming a custom board
  Given a board
  When a name is set
  Then the board has its name set
  

#only for coverage
Scenario: Checking robot on the board
  Given a game with an empty board
  When a robot on the board at (5, 5)
  Then the robot is at five, five

 #only for coverage
 Scenario: Generate a 12 x 12 easy board
	Given two players
	And robots for the players
  And an easy difficulty 
  When a board is generated
  Then an easy board is generated 
  And the board has 12 rows and 12 columns
  
  
#only for coverage  
 Scenario: Generate a hard board
  Given two players
	And robots for the players
  And a hard difficulty 
  When a board is generated
  Then the board has a game
  
  


