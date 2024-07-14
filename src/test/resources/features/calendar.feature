Feature: Calendar Test

  Scenario Outline: User creates a calendar event
    Given User is logged in with email "<email>", password "<password>", and phone number "<phoneNumber>"
    When User navigates to the specific day "<date>"
    And User creates a new event "<eventText>"
    Then The event "<eventText>" is present in the calendar

    Examples:
      | email                 | password | phoneNumber | date       | eventText          |
      | testuser3@example.com | pass123  | 1234567892  | 2024-07-14 | Training with John |
      | testuser4@example.com | pass456  | 0987654322  | 2024-07-15 | Training with Mark |
