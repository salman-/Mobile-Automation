Feature: Onboarding

  Scenario Outline: User makes his profile before he starts using the App.
    Given I tap Get started button
    And   I insert my name as "<Name>"
    And   I select my "<Gender>"
    And   I insert my age as "<Age>"
    And   I click on "<Symptoms>"
    And   I click on the "<Condition>"
    And   I specify "<severity-level>" of my problem
    And   I  am receiving "<treatment>"
    And   I am taking "<medication>"
    And   I insert my Email as "<Email>"
    And   I hear about the app in an "<advertisement>"
    When  I click on OK
    Then  I am in Dashboard view

    Examples:
      | Name | Gender | Age | Symptoms | Condition | severity-level |treatment | medication | Email   | advertisement |
      | Jim  | Male   | 32  | Bloating | IBS       | 2              | No       | No         | Not Now |  Play Store   |