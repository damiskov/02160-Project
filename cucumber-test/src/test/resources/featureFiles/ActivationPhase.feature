Feature: Activation phase

  Scenario: The activation phase activates a conveyor belt, and then a gear 
  	Given a board
  	And an activation phase
  	And an upward-pointing robot on the board
  	And an upward-pointing conveyor belt in the same cell as the robot
  	And a clockwise gear in the cell above the conveyor belt
  	When the activation phase is executed
  	Then the robot is at the position of the gear and pointing right
