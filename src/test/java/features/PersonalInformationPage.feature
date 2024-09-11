@PersonalInformationPage @All
Feature: PersonalInformationPage Feature

  Background:
    Given go to Logged Home Page

  Scenario: Check Personal Information and Member Number
    When retrieves the Member Number on the Home Page
    When taps the Account on the Home Page
    When taps the Tv Close on the Account Page
    Then should see "Account" Page
    When taps the Personal Information button on the Account Page
    Then should see "Personal Information" Page
    Then displayed member number should match the retrieved member number on the Personal Information Page
