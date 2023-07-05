@test123
Feature: To verify that each carousel on the homepage, displays 15 unique elements. Not all the carousels have 15 elements and for those cases, the test should fail.

    Scenario Outline: Verify each carousel on homepage displays 15 unique elements
      Given I am on mall.cz page
      And User has navigated to "<carousel_name>"
      And each carousel "<carousel_name>" should display 15 unique elements
      And the carousel "<carousel_name>" which has less than 15 elements the test case should fail
      Examples:
        |carousel_name                         |
        |To nejlepší z Allegro                 |
        |ZCHLAĎTE SE S NAŠIMI NÍZKÝMI CENAMI   |
        |NEJLEPŠÍ VODNÍ HRAČKY                 |
        |STOVKY PRODUKTŮ S DOPRAVOU ZDARMA     |

    Scenario: User Should close the Browser
      Given the User close the Web Browser