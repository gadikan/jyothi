Feature: scenario outline

  Scenario Outline: Posting multiple posts
    Given  I perform  post operation with <id> and <title> and <author>

    Examples:
      | id | title   | author   |
      | 11 | title11 | author11 |
      | 12 | title12 | author12 |
      | 13 | title13 | author13 |
      | 14 | title14 | author14 |
      | 15 | title15 | author15 |