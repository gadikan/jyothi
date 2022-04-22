Feature:GETPosts
  Verify different GET operation using rest-assured

  Scenario: Verify one author of the post
    Given I perform GET operation for "/posts"
    Then I should see author name as "Vinayak"

  Scenario: Verify collection of authors in the posts
    Given I perform GET operation for "/posts"
    Then I should see author names

  Scenario:Verify parameter of GET
    Given I perform GET operation for "http://localhost:3000/posts"
    Then  For GET parameters "1" I see author name as "Vinayak"



