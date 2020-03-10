Feature: subscription in a new program
  Scenario: Check a premium user can subscribe for a new program
  Given I am a premium user
  When I choose a program
  And I insert my basic information
  And I save the program
  Then I get redirected to dashboard view
  And I receive a message about new program in dashboard
