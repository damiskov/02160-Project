Feature: Activation phase

  Scenario: The activation phase activates a conveyor belt, and then a gear 
  	Given a board
  	And a robot on the board at (5, 5) facing "up"
  	And a conveyor belt on the board at (5, 5) facing "up"
  	And a gear on the board at (5, 6) spinning "clockwise"
  	When the activation phase activates the board elements
  	Then the robot is at (5, 6) and pointing "right"
