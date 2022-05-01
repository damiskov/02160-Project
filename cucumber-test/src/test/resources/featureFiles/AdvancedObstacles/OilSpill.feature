Feature: Oil Spill

  Scenario: Oil spill ignites
  	Given a game with an empty board
    And an oil spill on the board at (5, 5)
    And a robot on the board at (5, 5)
    When the board elements activate
    Then the oil spill ignites
    And the robot loses life points