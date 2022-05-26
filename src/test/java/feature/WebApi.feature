Feature: TestWebAPI
  Background: User is authorized

  Scenario: User uploads a file
    Given a file to upload
    When a file is uploaded
    Then uploading is successful

  Scenario: User gets the metadata of the file
    Given a file to receive the metadata of
    When a metadata is received
    Then a metadata receiving is successful

  Scenario: User deletes the file
    Given a file to be deleted
    When a file is deleted
    Then deleting is successful