Feature: Robot laser

  Scenario: Successful upwards laser shot
    Given two robots A and B on the board
    When a register ends with A in the same board column as B
    And A is below B
    And A is facing up
    Then B takes damage

  Scenario: Successful downwards laser shot
    Given two robots A and B on the board
    When a register ends with A in the same board column as B
    And A is above B
    And A is facing down
    Then B takes damage

  Scenario: Successful rightwards laser shot
    Given Two robots A and B on the board
    When a register ends with A in the same board row as B
    And A is to the left of B
    And A is facing right
    Then B takes damage

  Scenario: Successful leftwards laser shot
    Given Two robots A and B on the board
    When a register ends with A in the same board row as B
    And A is to the right of B
    And A is facing left
    Then B takes damage

  Scenario: Blocked upwards laser shot
    Given two robots A and B on the board
    And a blocking obstacle on the board
    When a register ends with A in the same board column as B
    And A is below B
    And A is facing up
    And the blocking obstacle is between A and B
    Then B takes damage

  Scenario: Blocked downwards laser shot
    Given two robots A and B on the board
    And a blocking obstacle on the board
    When a register ends with A in the same board column as B
    And A is above B
    And A is facing down
    And the blocking obstacle is between A and B
    Then B takes damage

  Scenario: Blocked rightwards laser shot
    Given Two robots A and B on the board
    And a blocking obstacle on the board
    When a register ends with A in the same board row as B
    And A is to the left of B
    And A is facing right
    And the blocking obstacle is between A and B
    Then B takes damage

  Scenario: Blocked leftwards laser shot
    Given Two robots A and B on the board
    And a blocking obstacle on the board
    When a register ends with A in the same board row as B
    And A is to the right of B
    And A is facing left
    And the blocking obstacle is between A and B
    Then B takes damage
