 Feature:
    @GETALLSTATUS
    Scenario: Get all Status with valid path
      Given I have a valid authentication token and valid path "forum"
      When Send request get forum with valid path
      Then Status code forum should be 200 ok
      And Response body name should be "Mayanda Kartika"

    Scenario: Get with invalid path
      Given I have a valid authentication token and invalid path "forumaaaa"
      When Send request get forum with invalid path
      Then Status code forum should be 404 not found
      And Jsonschema should be like "GetForumInvalid.json"

    Scenario: Get with wrong method
      Given  I have a valid authentication token and valid path "forum"
      When Send request get forum with wrong method
      Then Status code forum should be 405 method is not allowed