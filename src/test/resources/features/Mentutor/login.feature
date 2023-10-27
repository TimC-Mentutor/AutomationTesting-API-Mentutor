@MENTUTOR
Feature: login on mentutor web

  @POSTLOGIN
  # POSITIVE
  Scenario: Post login with valid admin email and password
    Given Post login with valid admin email and password "adminAcc.json"
    When Send request login with valid admin email and password
    Then Status code login should be 200 ok

  Scenario: Post login with valid mentor email and password
    Given Post login with valid mentor email and password "mentorAcc.json"
    When Send request login with valid mentor email and password
    Then Status code login should be 200 ok

  Scenario: Post login with valid mentee email and password
    Given Post login with valid mentee email and password "menteeAcc.json"
    When Send request login with valid mentee email and password
    Then Status code login should be 200 ok

  #NEGATIVE
  Scenario: Post login with unregistered email and password
    Given Post login with unregistered email and password "unregisteredAcc.json"
    When Send request login with unregistered email and password
    Then Status code login should be 400 bad request

  Scenario: Post login with wrong password
    Given Post login with wrong password "wrongPass.json"
    When Send request login with wrong password
    Then Status code login should be 400 bad request

