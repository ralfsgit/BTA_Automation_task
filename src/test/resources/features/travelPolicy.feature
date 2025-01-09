Feature: Travel policy

  Scenario Outline: Travel policy test
    Given I open BTA home page
    And I click "Accept Cookies" Button
    When I click on "Travel" Button
    Then I am in Travel Insurance Page
    And I click on "Change Destination" Button
    And I click "Choose country" button
    When I change destination to "<destination>"
    Then Travel Destination is changed to "<changedDestination>"
    And I change activity to "<activity>"
    And I click "Get Offer" button
    When I choose program "<program>"
    Then I can see form "Add more protection" and "My Policy" with data
    And I click on "Edit details" button
    When I and change Insurance sum to "<sum>"
    Then Insurance sum has changed
    And I click on Continue Button
    Then I am in travelers page
    And I see empty and visible data fields

    Examples:
      | destination  | changedDestination | activity                          | program  | sum  |
      | Indija       | Visa pasaule       | Ar paaugstināta riska aktivitātēm | Optimālā | 2000 |
