Feature: Change language test

  Rule:Language can be changed to English or Hungarian

    Background:
      Given I open home page
      And I accept cookies

    Scenario Outline: Change language
      Given the language is set to "<defaultLanguage>"
      When I change the language to "<newLanguage>"
      Then language is changed to "<newLanguage>"

      Examples:
        | defaultLanguage | newLanguage |
        | hungarian       | english     |
        | english         | hungarian   |



