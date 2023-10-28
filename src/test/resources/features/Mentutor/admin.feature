Feature: Admin

  #post register user
  @Admin @Mentutor
  @Positive-Case
  Scenario: Register new user with valid request body
    Given Post register new user with valid request body "RegisterNewUser.json"
    When Send post register new user
    Then Response code admin should be 201 Created
    And Register new user response body contain "Nasir Rahman"
    And Validate register new user JSON schema "RegisterNewUserSchema.json"
  @Admin @Mentutor
  @Positive-Case
  Scenario: Register new user with name value more than 5 characters
    Given Post register new user with name value more than five characters "RegisterNewUserWithMoreChar.json"
    When Send post register new user
    Then Response code admin should be 201 Created
    And Register new user response body contain "Kamal Sodiq"
    And Validate register new user JSON schema "RegisterNewUserWithMoreCharSchema.json"

  @Admin @Mentutor
  @Negative-Case
  Scenario: Register new user with invalid request body
    Given Post register new user with invalid request body "RegisterNewUserFailed.json"
    When Send post register new user
    Then Response code admin should be 400 Bad Request
    And Validate register new user JSON schema "RegisterNewUserFailedSchema.json"
  @Admin @Mentutor
  @Negative-Case
  Scenario: Register new user with blank request body
    Given Post register new user with blank request body "RegisterNewUserFailed.json"
    When Send post register new user
    Then Response code admin should be 400 Bad Request
    And Validate register new user JSON schema "RegisterNewUserFailedSchema.json"
  @Admin @Mentutor
  @Negative-Case
  Scenario: Register new user with name value less than 5 characters
    Given Post register new user with name value less than five characters "RegisterNewUserFailed.json"
    When Send post register new user
    Then Response code admin should be 400 Bad Request
    And Validate register new user JSON schema "RegisterNewUserFailedSchema.json"

  #post register class
  @Admin @Mentutor
  @Positive-Case
  Scenario: Register new class with valid request body
    Given Post register new class with valid request body "RegisterNewClass.json"
    When Send post register new class
    Then Response code admin should be 201 Created
    And Register new class response body contain "Success created"
    And Validate register new class JSON schema "RegisterNewClassSchema.json"
  @Admin @Mentutor
  @Positive-Case
  Scenario: Register new class with class name value more than 5 characters
    Given Post register new class with class name value more than five characters "RegisterNewClassWithMoreChar.json"
    When Send post register new class
    Then Response code admin should be 201 Created
    And Register new class response body contain "Success created"
    And Validate register new class JSON schema "RegisterNewClassWithMoreCharSchema.json"

  @Admin @Mentutor
  @Negative-Case
  Scenario: Register new class with invalid request body
    Given Post register new class with invalid request body "RegisterNewClassFailed.json"
    When Send post register new class
    Then Response code admin should be 400 Bad Request
    And Validate register new class JSON schema "RegisterNewClassFailedSchema.json"
  @Admin @Mentutor
  @Negative-Case
  Scenario: Register new class with blank request body
    Given Post register new class with blank request body "RegisterNewClassFailed.json"
    When Send post register new class
    Then Response code admin should be 400 Bad Request
    And Validate register new class JSON schema "RegisterNewClassFailedSchema.json"
  @Admin @Mentutor
  @Negative-Case
  Scenario: Register new class with class name value less than 5 characters
    Given Post register new class with blank request body "RegisterNewClassFailed.json"
    When Send post register new class
    Then Response code admin should be 400 Bad Request
    And Validate register new class JSON schema "RegisterNewClassFailedSchema.json"
  @Admin @Mentutor
  @Negative-Case
  Scenario: Register new class with value contain special characters
    Given Post register new class with value contain special characters "RegisterNewClassFailed.json"
    When Send post register new class
    Then Response code admin should be 400 Bad Request
    And Validate register new class JSON schema "RegisterNewClassFailedSchema.json"


#-----------------------------------------------#
  #get all users
  @Admin @Mentutor
  @Positive-Case
  Scenario: Get all users with valid path
    Given Get all users with valid path
    When Send get all users
    Then Response code admin should be 200 OK
    And Get all class response body contain "Fahrul Rozi"
    And Validate get all users JSON schema "GetAllUsersSchema.json"
  @Admin @Mentutor
  @Negative-Case
  Scenario: Get all users with invalid path
    Given Get all users with invalid path
    When Send get all users fail
    Then Response code admin should be 404 Not Found
    And Validate get all users JSON schema "GetAllUsersFailedSchema.json"

    #get all classes
  @Admin @Mentutor
  @Positive-Case
  Scenario: Get all classes with valid path
    Given Get all classes with valid path
    When Send get all classes
    Then Response code admin should be 200 OK
    And Get all classes response body contain "QE - 11"
    And Validate get all classes JSON schema "GetAllClassesSchema.json"
  @Admin @Mentutor
  @Negative-Case
  Scenario: Get all classes with invalid path
    Given Get all classes with invalid path
    When Send get all classes fail
    Then Response code admin should be 404 Not Found
    And Validate get all classes JSON schema "GetAllClassesFailedSchema.json"

    #get other user
  @Admin @Mentutor
  @Positive-Case
  Scenario Outline: Get other user with valid id 83
    Given Get other user with valid id <id>
    When Send get other user
    Then Response code admin should be 200 OK
    And Get other user response body contain "QE - 11"
    And Validate get other user JSON schema "GetOtherUserSchema.json"
    Examples:
      | id |
      | 83 |
  @Admin @Mentutor
  @Negative-Case
  Scenario Outline: Get other user with invalid id
    Given Get other user with invalid id <id>
    When Send get other user fail
    Then Response code admin should be 400 Bad Request
    And Validate get other user JSON schema "GetOtherUserFailedSchema.json"
    Examples:
    |id|
    |  830|



  #-----------------------------------------------#
  #put update user
  @Admin @Mentutor
  @Positive-Case
  Scenario: Put update user with valid id and body
    Given Put update with valid id and body to name "Bhakti UGP" email "bhakt11@gmail.com" password "BhaktiU123$" images "putUpdateAdmin.png" id_class 1
    When Send put update
    Then Response code admin should be 201 Created
    And Put update user response body contain "update profile successful"
    And Validate put update user JSON schema "PutUpdateUserSchema.json"
  @Admin @Mentutor
  @Positive-Case
  Scenario: Put update user with name value more than 5 characters
    Given Put update with name value more than five characters name "Bhakti UGP" email "bhakt11@gmail.com" password "BhaktiU123$" images "putUpdateAdmin.png" id_class 1
    When Send put update
    Then Response code admin should be 201 Created
    And Put update user response body contain "update profile successful"
    And Validate put update user JSON schema "PutUpdateUserSchema.json"

  @Admin @Mentutor
  @Negative-Case
  Scenario Outline: Put update user with invalid id
    Given Put update user with invalid id <id>
    When Send put update user fail
    Then Response code admin should be 400 Bad Request
    And Validate put update user JSON schema "PutUpdateUserFailedSchema.json"
    Examples:
      | id   |
      | 1340 |
  @Admin @Mentutor
  @Negative-Case
  Scenario Outline: Put update user blank request body
    Given Put update user with blank id <id> request body "PutUpdateUserFail.json"
    When Send put update user fail
    Then Response code admin should be 400 Bad Request
    And Validate put update user JSON schema "PutUpdateUserFailedSchema.json"
    Examples:
      | id |
      | 83 |
  @Admin @Mentutor
  @Negative-Case
  Scenario: Put update user with name value less than 5 characters
    Given Put update user with name value less than five characters name "Bhak" email "bhakt11@gmail.com" password "BhaktiU123$" images "putUpdateAdmin.png" id_class 1
    When Send put update user failed
    Then Response code admin should be 400 Bad Request
    And Validate put update user JSON schema "PutUpdateUserFailedSchema.json"

  #put update class
  @Admin @Mentutor
  @Positive-Case
  Scenario Outline: Put update class with valid id and request body
    Given Put update class with valid id <id> and request body "PutUpdateClass.json"
    When Send put update class
    Then Response code admin should be 201 Created
    And Put update class response body contain "Update Class Successful"
    And Validate put update class JSON schema "PutUpdateClassSchema.json"
    Examples:
      | id |
      | 44  |
  @Admin @Mentutor
    @Positive-Case
  Scenario Outline: Put update class with valid id and class name value more than 5 characters
    Given Put update class with valid id <id> and class name value more than five characters "PutUpdateClass.json"
    When Send put update class
    Then Response code admin should be 201 Created
    And Put update class response body contain "Update Class Successful"
    And Validate put update class JSON schema "PutUpdateClassSchema.json"
    Examples:
      | id |
      | 44  |

  @Admin @Mentutor
    @Negative-Case
  Scenario Outline: Put update class with invalid id and valid request body
    Given Put update class with invalid id <id> and valid request body "PutUpdateClass.json"
    When Send put update class fail
    Then Response code admin should be 400 Bad Request
    And Validate put update class JSON schema "PutUpdateUserFailedSchema.json"
    Examples:
      | id  |
      | 440 |
  @Admin @Mentutor
  @Negative-Case
  Scenario Outline: Put update class with valid id and invalid request body
    Given Put update class with valid id <id> and invalid request body "PutUpdateClassFail.json"
    When Send put update class fail
    Then Response code admin should be 400 Bad Request
    And Validate put update class JSON schema "PutUpdateUserFailedSchema.json"
    Examples:
      | id |
      | 44 |
  @Admin @Mentutor
    @Negative-Case
  Scenario Outline: Put update class with valid id and class name value less than 5 characters
    Given Put update class with valid id <id> and class name value less than five characters "PutUpdateClassFail.json"
    When Send put update class fail
    Then Response code admin should be 400 Bad Request
    And Validate put update class JSON schema "PutUpdateUserFailedSchema.json"
    Examples:
      | id |
      | 44 |


#-----------------------------------------------#
  #delete user
  @Admin @Mentutor
  @Positive-Case
  Scenario Outline: Delete user with valid id 132
    Given Delete user with valid id <id>
    When Send delete user
    Then Response code admin should be 200 OK
    And Delete user response body contain "Delete Success"
    And Validate delete user JSON schema "DeleteUserValidSchema.json"
    Examples:
      | id  |
      | 132 |
  @Admin @Mentutor
  @Negative-Case
  Scenario Outline: Delete user with ivalid id 1320
    Given Delete user with invalid id <id>
    When Send delete user
    Then Response code admin should be 400 Bad Request
    And Validate delete user JSON schema "DeleteUserFailedSchema.json"
    Examples:
      | id   |
      | 1320 |

    #delete class
  @Admin @Mentutor
    @Positive-Case
  Scenario Outline: Delete class with valid id 72
    Given Delete class with valid id <id>
    When Send delete class
    Then Response code admin should be 200 OK
    And Delete class response body contain "Success Delete Class"
    And Validate delete class JSON schema "DeleteClassValidSchema.json"
    Examples:
      | id |
      | 72 |

  @Admin @Mentutor
    @Negative-Case
  Scenario Outline: Delete class with invalid id 720
    Given Delete class with invalid id <id>
    When Send delete class
    Then Response code admin should be 400 Bad Request
    And Validate delete class JSON schema "DeleteClassFailedSchema.json"
    Examples:
      | id  |
      | 720 |