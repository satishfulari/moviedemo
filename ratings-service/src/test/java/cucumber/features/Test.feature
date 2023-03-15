Feature: User Certification

  Scenario: User is Passed
    Given that the user Garry has given ratings to movie The Avenger
    When Movie The Avenger is released in 2015
    Then Garry has given ratings for the movie The Avenger