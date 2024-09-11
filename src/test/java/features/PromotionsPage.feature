@PromotionsPage @All
Feature: PromotionsPage Feature

  Background:
    Given go to Logged Home Page

  Scenario: Verify and Apply Promotions Code
    When taps the Account on the Home Page
    When taps the Tv Close on the Account Page
    Then should see "Account" Page
    When taps the Promotions button on the Account Page
    Then should see "Promotions" Page
    When enter a random value into the Promotion textbox on the Promotions Page
    When taps the Close button on the Promotions Page
    Then should see "Account" Page
