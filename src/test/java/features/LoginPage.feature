@LoginPage @All
Feature: LoginPage Feature

  Background:
    Given go to Login Page

  Scenario: User Successfully Logs in with Correct Credentials
    Then should see "Login" Page
    When enter User Name into the Username field on the Login Page
    When enter Password into the Password field on the Login Page
    When taps the Login button on the Login Page
    Then should see the correct Logged-in User Name on the Home Page
    When taps the Account on the Home Page
    When taps the Tv Close on the Account Page
    Then should see "Account" Page
    When taps the Log Out button on the Account Page
    Then should see the Log Out popup on the Account Page
    When taps the Continue button on the Log Out popup on the Account Page
    Then should see Not Logged on the Home Page

  Scenario Outline: User Fails to Log in Due to Invalid Password
    Then should see "Login" Page
    When enter User Name into the Username field on the Login Page
    When enter random Password into the Password field on the Login Page
    When taps the Login button on the Login Page
    Then should see the error message "<errorMessage>" on the Login Page
    Examples:
      | errorMessage                                                                                     |
      | Üye numaranız, TC kimlik numaranız veya şifreniz hatalıdır! Lütfen bilgilerinizi kontrol ediniz. |
