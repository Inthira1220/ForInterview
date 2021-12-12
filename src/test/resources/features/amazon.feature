Feature: Google search functionality
  Agile Story: As a user, when I am on the google
  search page, I should be able to search whatever
  I want, and see relevant information

  Scenario: Search page title verification
  Given User is on landing the Google Home Page
  When User searches for amazon
  Then User should see amazon is in the Title
