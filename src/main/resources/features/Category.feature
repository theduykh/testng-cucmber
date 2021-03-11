Feature: Category

  Scenario: Verify able to browse categories on page:
    Given I login successfully to "http://automationpractice.com/index.php" with email "ninjavantest@autotest.com" & password "12345"
    When I browse following categories as below:
      | Categories | Sub Categories  |
      | Women      | T-shirts      |
      | Women      | Evening Dresses |
      | Dresses    | Summer Dresses  |
      | T-shirts   |                 |
    Then The page display correctly with selected category.