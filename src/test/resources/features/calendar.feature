Feature: Calendar Test

  Scenario Outline: User creates a calendar event
    Given User is logged in with email "<email>", password "<password>", and phone number "<phoneNumber>"
    When User navigates to the specific day "<date>"
    And User creates a new event "<eventText>"
    Then The event "<eventText>" is present in the calendar
    Examples:
      | email                   | password | phoneNumber | date       | eventText          |
      | testuser13@gmail.com    | pass123  | 1234567895  | 2024-07-15 | Training with John |
      | testuser11114@gmail.com | pass123  | 123456786   | 2024-07-16 | Training with Mark |
      | testuser7@gmail.com     | pass123  | 123456787   | 2024-07-16 | Training with Mark |
      | testuser8@gmail.com     | pass123  | 123456788   | 2024-07-16 | Training with Mark |
      | testuser9@gmail.com     | pass123  | 123456789   | 2024-07-16 | Training with Mark |

