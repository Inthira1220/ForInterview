Feature: Youtube search functionality
  As user, i should be able to search and play the video
  Case: search for "Thailand"
@wip
  Scenario: Youtube search functionality Title verification
    Given User is landing on youtube Page
    When User search for Thailand in the youtube search box
    And User should be able to click the search button
    Then User should be able to play
