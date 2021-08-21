Feature: Login

  Scenario: Verify able to login with valid credentials
    Given I have URL web page as "http://automationpractice.com/index.php"
    And   Valid user email as "example@autotest.com"
    And   Valid password as "123456"
    When  I navigate to this URL on Chrome browser
    And   I input username password
    Then  User sign in successfully.
