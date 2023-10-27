@MENTUTOR
Feature: FORUM
#    POSITIVE
  Scenario: Get all Status with valid path
    Given The right authentication
    And I have a valid authentication token and valid path "forum"
    When Send request get forum with valid path
    Then Status code forum should be 200 ok
    And Response body name should be "Mayanda Kartika"
#NEGATIVE
  Scenario: Get with invalid path
    Given I have a valid authentication token and invalid path "forumaaaa"
    When Send request get forum with invalid path
    Then Status code forum should be 404 not found
    And Jsonschema should be like "GetForumInvalid.json"

  Scenario: Get with wrong method
    Given  I have a valid authentication token and valid path "forum"
    When Send request get forum with wrong method
    Then Status code forum should be 405 method is not allowed

  @POSTFORUM
#    POSTIVE
  Scenario Outline:  Post with forum with valid form data
    Given The right authentication
    And Post with forum with valid form data "<caption>" as caption and "<images>" as images
    When Send request post forum with valid form data
    Then Status code forum should be 201 created
    Examples:
      | caption          | images          |
      | ini adalah forum | gambarForum.png |

 Scenario: Post With no images
   Given The right authentication
   And Post on forum with just caption "ini forum tanpa gambar"
   When Send request post forum with just caption
   Then Status code forum should be 201 created
#   NEGATIVE
  Scenario: Post With no caption
    Given The right authentication
    And Post on forum with just images "gambarForum.png" as images
    When Send request post forum with just images
    Then Status code forum should be 400 bad request

 Scenario Outline: Post with less than five character on caption
    Given The right authentication
    And Post with forum with valid form data "<caption>" as caption and "<images>" as images
    When Send request post forum with less than five character on a caption
    Then Status code forum should be 400 bad request
   Examples:
     | caption | images          |
     | coba    | gambarForum.png |

   Scenario: Post forum with json
     Given The right authentication
     And Post forum with "ForumJson.json" as json body
     When Send request post forum with json as body
     Then Status code forum should be 400 bad request



