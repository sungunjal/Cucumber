Feature: Contact Email

Scenario Outline: Login into application and send parameterized mail email
Given user open DemoQa app
Then navigate to contact tab
And provide username as "<userName>" email as "<email>" subject as "<subject>" and message as "<message>"
And click on send button
And close browser

Examples:
    | userName | email                | subject | message      |
    | #{TestContext.abc}  | sunilmail@aq.com     | Testing | test message |