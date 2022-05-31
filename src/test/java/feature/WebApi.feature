Feature: TestWebAPI
  Background: User is authorized

  Scenario: User uploads a file
    When a file is uploaded
    Then uploading is successful

  Scenario: User gets the metadata of the file
    When a metadata is received
    Then a metadata receiving is successful

  Scenario: User deletes the file
    When a file is deleted
    Then deleting is successful