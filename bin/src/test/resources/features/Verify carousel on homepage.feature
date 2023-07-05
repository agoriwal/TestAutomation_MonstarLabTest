@test123
Feature: To verify that each carousel on the homepage, displays 15 unique elements. Not all the carousels have 15 elements and for those cases, the test should fail.

  Background:
    Given I am on mall.cz page

    Scenario Outline: Verify each carousel on homepage displays 15 unique elements
      Given User has navigated to "<carousel_name>"
      And each carousel should display 15 unique elements
      Examples:
        |carousel_name        |
        |To nejlepší z Allegro|