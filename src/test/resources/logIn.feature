Feature: Log in with email and password

  Rule: You can only login after registration

      Background:
        Given I open home page
        And I accept cookies
        And I open Sign in page

      Scenario: Successful Login to the page
        When I login with following credentials:
          |          email         |     password   |
          | testacc9741@gmail.com  |     Pwd1234*   |
        Then headline contains the word "Teszt"
        When I click logout button
        Then login button is present