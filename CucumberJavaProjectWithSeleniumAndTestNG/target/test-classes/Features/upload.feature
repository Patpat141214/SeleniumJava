@tag
Feature: File Upload

@UploadTesting
  Scenario: Upload PDF/WORD File
    Given I am on the file upload page
    When I upload the PDF file
    Then I should see the upload success message
