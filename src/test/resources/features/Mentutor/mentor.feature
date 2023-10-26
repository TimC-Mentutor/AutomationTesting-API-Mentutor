@MENTUTOR
Feature: mentor
#   -------GET ALL TASK BY ID MENTOR--------
#Feature: Mentutor
#  Positive
  Scenario:Get all task
    Given Get list task
    When Send request mentor get all task
    Then response code mentor should be 200
    And Validate JSON Schema "GetAllTaskJsonSchema.json"
#  Positive
  Scenario:Get all task with valid query param
    Given get list user query params title "biologi"
    When Send request Get list task with param
    Then response code mentor should be 200
#  Negative
  Scenario:Get all task with invalid query param
    Given get list user query params title "nama"
    When Get all task with invalid query param
    Then response code mentor should be 400
#    And Responses body should be ""
#    And Validate JSON Schema "GetAllTaskInvalidQueryJsonSchema.json"





#  ---------GET DETAIL TASK ---------
#  Positive
  Scenario:Get task detail with valid id
    Given get task with valid id 1
    When send request Get task detail with valid id
    Then response code mentor should be 200
    And Responses body should be "success get single task"
    And Validate JSON Schema "GetDetailValidIdJsonSchema.json"
#  Negative
  Scenario:Get task detail using special char on id
    Given Get task detail using special char on id "&%$"
    When send request Get task detail using special char on id
    Then response code mentor should be 404
    And Responses body message error should be "Task not found"
    And Validate JSON Schema "GetTaskDetailSpecialCharIdJsonSchema.json"
#  Negative
  Scenario:Get task detail with doesn't exist id
    Given Get task detail with doesn't exist id 23
    When send request Get task detail with doesn't exist id
    Then response code mentor should be 404
    And Responses body message error should be "Task not found"
    And Validate JSON Schema "MentorGetDetailDoesn'tExistIdJsonSchema.json"
#  Negative
  Scenario:Get task detail using alphabeth on id
    Given Get task detail using alphabeth on id "lima"
    When send request Get task detail using alphabeth on id
    Then response code mentor should be 404
    And Responses body message error should be "Task not found"
    And Validate JSON Schema "MentorGetDetailAlphabethOnIdJsonSchema.json"


#  -----------PUT UPDATE PROFILE MENTOR----------
#  Positive
  Scenario:Put update profile mentor with valid name
    Given change body to name "Amanda heriska" email "amanda@gmail.com" password "Amanda1234*" images "PutUpdateMentor.png"
    When Send request mentor update profile user
    Then response code mentor should be 200
    And Responses body should be "success update profile"
    And Validate JSON Schema "PutUpdateProfileMentorJsonSchema.json"
#  Negative
  Scenario:Put update profile mentor without using space on field name
    Given change body to name "Amandaheriska" email "amanda@gmail.com" password "Amanda1234*" images "PutUpdateMentor.png"
    When Send request mentor update profile user
    Then response code mentor should be 200
    And Responses body should be "success update profile"
    And Validate JSON Schema "PutUpdateProfileMentorJsonSchema.json"
#  Negative
  Scenario:Put update profile mentor witohut using uppercase on field name
    Given change body to name "amanda heriska" email "amanda@gmail.com" password "Amanda1234*" images "PutUpdateMentor.png"
    When Send request mentor update profile user
    Then response code mentor should be 200
    And Responses body should be "success update profile"
    And Validate JSON Schema "PutUpdateProfileMentorJsonSchema.json"
#  Negative
  Scenario:Put update profile mentor with invalid email
    Given change body to name "Amanda heriska" email "amandagmail.com" password "Amanda1234*" images "PutUpdateMentor.png"
    When Send request mentor update profile user
    Then response code mentor should be 400
    And Responses body message error should be "Invalid Input From Client"
    And Validate JSON Schema "MentorPutUpdateProfileMentorInvalidEmailJsonSchema.json"
#  Negative
  Scenario:Put update profile mentor without input name,email,password
    Given change body to name "" email "" password "" images ""
    When Send request mentor update profile user without input name,email,password
    Then response code mentor should be 400
    And Responses body message error should be "Invalid Input From Client"
    And Validate JSON Schema "MentorPutUpdateProfileMentorInvalidEmailJsonSchema.json"

#  -----------PUT UPDATE TASK BY MENTOR----------
#  Positive
  Scenario:Put update task with valid id and valid body
    Given change id 1 and body to title "sosial" description "tugas" due date "2023-4-12" attachment "MentorUpdateTask.docx" images "MentorUpdateTaskPetapng.png"
    When Send request mentor update task
    Then response code mentor should be 201
    And Responses body should be "success get single task"
    And Validate JSON Schema "MentorPutUpdateTaskValidIdJsonSchema.json"
#  Negative
  Scenario Outline:Put update task with invalid id and valid body
    Given change id "<id>" and body to title "<title>" description "<description>" due date "<due date>" attachment "<attachment>" images "<images>"
    When Send request mentor update task
    Then response code mentor should be 400
    And Responses body message error should be "Invalid Input From Client"
    And Validate JSON Schema "MentorPutUpdateTaskInvalidIdJsonSchema.json"
    Examples:
      | id   | title  | description | due date  | attachment            | images                      |
      | satu | sosial | tugas       | 2023-4-12 | MentorUpdateTask.docx | MentorUpdateTaskPetapng.png |
      | ^&*  | sosial | tugas       | 2023-4-12 | MentorUpdateTask.docx | MentorUpdateTaskPetapng.png |
#  Negative
  Scenario Outline:Put update task with valid id and invalid due date
    Given change id <id> and body to title "<title>" description "<description>" due date "<due date>" attachment "<attachment>" images "<images>"
    When Send request mentor update task
    Then response code mentor should be 400
    And Responses body message error should be "Invalid Input From Client"
    And Validate JSON Schema "MentorPutUpdateTaskInvalidIdJsonSchema.json"
    Examples:
      | id | title  | description | due date   | attachment            | images                      |
      | 1  | sosial | tugas       | 2023-14-12 | MentorUpdateTask.docx | MentorUpdateTaskPetapng.png |
      | 4  | sosial | tugas       | 2023-4-50  | MentorUpdateTask.docx | MentorUpdateTaskPetapng.png |
      | 6  | sosial | tugas       | 2023-60-50 | MentorUpdateTask.docx | MentorUpdateTaskPetapng.png |
#  Negative
  Scenario:Put update task with invalid id and invalid body
    Given change id "satu" and body to title "materi" description "baba 1" due date "2023-60-50" attachment "MentorUpdateTask.docx" images "MentorUpdateTaskPetapng.png"
    When Send request mentor update task
    Then response code mentor should be 400
    And Responses body message error should be "Invalid Input From Client"
    And Validate JSON Schema "MentorPutUpdateTaskInvalidIdJsonSchema.json"


#  -----------ADD TASK BY MENTOR----------
#  Positive
  Scenario:Post task with valid title,describtion,due date,attachment,Images
    Given change body to title "sosial" description "tugas" due date "2023-12-12" file "MentorPostTask.docx" images "MentorPostTaskPetapng.png"
    When Send request mentor post task
    Then response code mentor should be 201
    And Responses body should be "Success insert task"
    And Validate JSON Schema "MentorPostTaskValidBodyJsonSchema.json"
#  Negative
  Scenario:Post task without input title,describtion,due date,attachment,Images
    Given change body to title "" description "" due date "" file "" images ""
    When Send request mentor post task without input title,describtion,due date,attachment,Images
    Then response code mentor should be 400
    And Responses body message error should be "Invalid Input From Client"
    And Validate JSON Schema "MentorPostTaskInvalidBodyJsonSchema.json"
  Scenario:Post task without input attachment
    Given change body to title "sosial" description "tugas" due date "2023-12-12" file "" images "MentorPostTaskPetapng.png"
    When Send request mentor post task without input attachment
    Then response code mentor should be 201
    And Responses body should be "Success insert task"
    And Validate JSON Schema "MentorPostTaskValidBodyJsonSchema.json"
  Scenario:Post task without input due date
    Given change body to title "sosial" description "tugas" due date "2023-12-12" file "" images "MentorPostTaskPetapng.png"
    When Send request mentor post task without input due date
    Then response code mentor should be 400
    And Responses body message error should be "Invalid Input From Client"
    And Validate JSON Schema "MentorPostTaskInvalidBodyJsonSchema.json"

#  -----------ADD COMMENTS ON STATUS----------
  Scenario:Post with valid id and valid comment
    Given Post with id 3 and valid caption "veryy good"
    When Send request Post with valid id and valid comment
    Then response code mentor should be 201
    And Responses body should be "success insert comment"
    And Validate JSON Schema "MentorPostAddCommentValidIdValidCommentBodyJsonSchema.json"
  Scenario:Post with valid id without input comment
    Given Post with id 3 and valid caption ""
    When send request post with valid id without input comment
    Then response code mentor should be 400
    And Responses body should be "Not Found"
    And Validate JSON Schema "MentorPostAddCommentValidIdWithoutCommentBodyJsonSchema.json"
  Scenario:Post with valid id and input comment lass than 5
    Given Post with id 3 and valid caption "nice"
    When Send request Post with valid id and valid comment
    Then response code mentor should be 400
    And Responses body should be "Not Found"
  Scenario:Post with doesn't exist id and valid comment
    Given Post with id 11100 and valid caption "verry good"
    When Send request Post with valid id and valid comment
    Then response code mentor should be 400
    And Responses body should be "Not Found"
    And Validate JSON Schema "MentorPostAddCommentDoesn'tExistIdWithoutCommentBodyJsonSchema.json"
  Scenario:Post with using special char on id and valid comment
    Given Post with id "%&" and valid caption "verry good"
    When Send request Post with valid id and valid comment
    Then response code mentor should be 400
    And Responses body should be "Not Found"
    And Validate JSON Schema "MentorPostAddCommentDoesn'tExistIdWithoutCommentBodyJsonSchema.json"
  Scenario:Post with using alphabet on id and valid comment
    Given Post with id "satu" and valid caption "verry good"
    When Send request Post with valid id and valid comment
    Then response code mentor should be 400
    And Responses body should be "Not Found"
    And Validate JSON Schema "MentorPostAddCommentDoesn'tExistIdWithoutCommentBodyJsonSchema.json"

#  -----------POST SUBMIT SCORE BY MENTOR----------
  Scenario:Post submission with valid id task and valid score
    Given Post submission with id submission 30 id task 123 and score 70
    When Send request Post submission
    Then response code mentor should be 201
    And Responses body should be "success insert score"
    And Validate JSON Schema "MentorPostSubmitScoreValidIdValidScoreBodyJsonSchema.json"
  Scenario:Post submission with using special char on id task
    Given Post submission with id submission 30 id task "satu" and score 70
    When Send request Post submission
    Then response code mentor should be 400
    And Responses body message error should be "Invalid Input From Client"
    And Validate JSON Schema "MentorPostSubmitScoreValidIdInvalidIdTaskScoreBodyJsonSchema.json"
  Scenario:Post submission with using alphabeth on id submission and valid score
    Given Post submission with id submission "dua" id task 123 and score 70
    When Send request Post submission
    Then response code mentor should be 400
    And Responses body message error should be "Invalid Input From Client"
    And Validate JSON Schema "MentorPostSubmitScoreValidIdInvalidIdTaskScoreBodyJsonSchema.json"
  Scenario:Post submission with valid id task and invalid score
    Given Post submission with id submission 30 id task 123 and score "lima"
    When Send request Post submission
    Then response code mentor should be 400
    And Responses body message error should be "Invalid Input From Client"
    And Validate JSON Schema "MentorPostSubmitScoreValidIdInvalidIdTaskScoreBodyJsonSchema.json"
#  -----------DELETE TASK BY MENTOR----------
  Scenario:Delete task with valid id
    Given Delete task with id 6
    When Send request delete task
    Then response code mentor should be 200
    And Responses body should be "Delete Success"
    And Validate JSON Schema "MentorDeleteValidIdBodyJsonSchema.json"
  Scenario:Delete task with doesn't exist id
    Given Delete task with id 23
    When Send request delete task
    Then response code mentor should be 400
    And Responses body message error should be "Invalid Input From Client"
    And Validate JSON Schema "MentorPostSubmitScoreValidIdInvalidIdTaskScoreBodyJsonSchema.json"
  Scenario:Delete task with using special char on id
    Given Delete task with id "^%%$"
    When Send request delete task
    Then response code mentor should be 400
    And Responses body message error should be "Invalid Input From Client"
    And Validate JSON Schema "MentorPostSubmitScoreValidIdInvalidIdTaskScoreBodyJsonSchema.json"
  Scenario Outline:Delete task with using alphabet on id
    Given Delete task with id "<id>"
    When Send request delete task
    Then response code mentor should be 400
    And Responses body message error should be "Invalid Input From Client"
    And Validate JSON Schema "MentorPostSubmitScoreValidIdInvalidIdTaskScoreBodyJsonSchema.json"
    Examples:
      | id             |
      | satu           |
      | dela@gmail.com |




