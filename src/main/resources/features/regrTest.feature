Feature: As a Tester
  I want to run regression suite
  So that i can verify my test results

  Scenario: Latest News
    Given I navigate to Home page
    Then I can see the latest News display
    |Latest news|
    And I finally tear out


  Scenario: Verify About page headers
    Given I navigate to Home page
    And I click About link
    Then I can see the following About page header
    |About|
    |We are Valtech, a global digital agency focused on business transformation.|
    And I finally tear out

  Scenario: Verify Service page header
    Given I navigate to Home page
    And I click Service link
    Then I can see the following Service page header
    |Services|
    |Our service offerings span the entire customer journey.|
    And I finally tear out

  Scenario: Verify Work page headers
    Given I navigate to Home page
    And I click Work link
    Then I can see the following work page header
    |Work|
    |Different needs require different solutions. This is what we've done for just some of our clients who came to us with their business challenges.|
    And I finally tear out

  Scenario: Verify contact page headers
    Given I navigate to Home page
    And I click Contact link
    Then I can see the following contact page header
    |Contact our other offices|
    And I finally tear out