Feature: Mentee

@GETALLTASK
Scenario: Get all task as mentee with valid path
  Given Get all task as mentee with valid path "tasks"
  When Send request get all task as mentee with valid path
  Then Status code Mentee should be 200 ok
  And the response body title should be "Coba WEB Manual"

Scenario: Get all task as mentee with invalid path
  Given Get all task as mentee with invalid path "taskssss"
  When Send request get all task as mentee with invalid path
  Then Status code mentee should be 404 not found
  And there should be an error message for invalid path "Not Found"

Scenario: Get all task as mentee with wrong method
  Given Get all task as mentee with valid path "tasks"
  When Send request get all task as mentee with wrong method
  Then Status code Mentee should be 405 method not allowed
  And there should be an error message for wrong method "Method Not Allowed"

@POSTTASK
Scenario: Post task with valid file and id_task
  Given Post task with valid file "MenteePostTask.pdf" and valid id task 145
  When Send request post task with valid file and id
  Then Status code Mentee Should be 201 created
  And There should be a message saying "success insert submission"

Scenario: Post task with empty file and invalid id task
  Given Post task with empty file and invalid id task 123333333
  When Send request post task with empty file and invalid id task
  Then Status code mentee should be 404 not found

Scenario: Post with valid file and invalid id tasks
  Given Post task with valid file "MenteePostTask.pdf" and invalid id task 123333333
  When Send request post task with valid file and invalid id task
  Then Status code mentee should be 404 not found

Scenario: Post with wrong format file and valid id tasks
  Given post with wrong format file "MenteeWrongFormatPostTask.png" and valid id tasks 141
  When Send request post task with wrong format and valid id task
  Then Status code mentee should be 400 bad request

Scenario: Post with empty file and valid id tasks
  Given post with empty file and valid id tasks 142
  When Send request post with empty file and valid id tasks
  Then Status code mentee should be 400 bad request

@POSTCOMMENT
Scenario: Post comment with valid json
  Given Post comment with valid json "PostCommentValid.json" and valid id status 130
  When Send request post comment with valid json
  Then Status code Mentee Should be 201 created

Scenario: Post comment with multi form
  Given Post comment with valid multiform "ini form" multi form and valid id status 130
  When Send request post commment with multi form
  Then Status code Mentee Should be 201 created

Scenario: Post comment with valid json and invalid id status
  Given Post comment with valid json "PostCommentValid.json" and invalid id status "aaaaaaa"
  When Send request post comment with valid json and invalid id status
  Then Status code mentee should be 404 not found

Scenario: Post comment with empty data
  Given Post comment with empty data on json "PostCommentEmpty.json" and valid id status 130
  When Send request post comment with empty data and valid id status
  Then Status code mentee should be 400 bad request
  And validate jsonSchema on post comment with empty data "PostCommentErrorSchema.json"

Scenario: Post comment with less than 5 character
  Given post comment with less than five characters on json "PostCommentLessCharacters.json" and valid id status 130
  When Send request post comment with less than five characters and valid id status
  Then Status code mentee should be 400 bad request
  And validate jsonSchema on post comment with less than five characters "PostCommentErrorSchema.json"

@PUTUPDATEMENTEE
Scenario Outline: Put update user with valid data and param
  Given Put update user with valid data and param on "<name>" as name and "<email>" as email and "<password>" as password and "<images>" as images file
  When send request put update user with valid data and param
  Then Status code Mentee Should be 201 created
  Examples:
    | name | email                        | password   | images             |
    | Fian | mentee.menteemtk01@gmail.com | Mentee123$ | PutValidImages.png |

#Scenario : Put with wrong images format data and valid param
#  Given "Fian" as name and "mentee.menteemtk01@gmail.com" as email and "Mentee123$" and "PutInvalidImages.jpg" as images
#  When send request put update user with wrong images format data and valid param
#  Then Status code mentee should be 400 bad request
#
#
#Scenario Outline: put with empty data and valid param
#  Given Put update user with empty data and valid param on "<name>" as name and "<email>" as email and "<password>" as password and "<images>" as images file
#  When Send request put update user with empty data and valid param
#  Then Status code mentee should be 400 bad request
#  Examples:
#    | name | email | password | images |
#    | ""   | ""    | ""       | ""     |

Scenario: put with json file as body instead with form-data
  Given Put update user with "PutUpdateUser.json" json file as body instead with form-data
  When Send request put user with json file as body instead with form-data
  Then Status code mentee should be 400 bad request
#
#Scenario Outline: Put name without space in beetween or with just one word
#  Given email
#  When Send request put user without space in beetween or with just one word
#  Then Status code mentee should be 400 bad request
#  Examples:
#    | name | email | password | images |
#    | ""   | ""    | ""       | ""     |
#
#


