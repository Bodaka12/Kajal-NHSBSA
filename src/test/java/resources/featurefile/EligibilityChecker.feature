Feature: Eligibility Checker

  @Regression
  Scenario: Wales Test Ticket - Acceptance Criteria
    Given I am a person from Wales
    When I put my GP Practice
    And I Put my Dental Practice
    And I put my Date Of Birth
    And I live with a partner or not
    And I put my or my partner claim any benefits or tax credits?
    And I Put my pregnant or have you given birth in the last 12 months?
    And I put my have an injury or illness caused by serving in the armed forces?
    And I put my or my partner live permanently in a care home?
    And I put my and my partner have more than £16,000 in savings, investments or property?
    Then I should get a result of whether I will get help or not