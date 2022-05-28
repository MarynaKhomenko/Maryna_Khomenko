Feature: TestWebUI
  Background: User has an account

  Scenario: Purchase a laptop
    Given User connects to website
    When User logs in
    * choose category 'Laptops'
    * choose model 'Dell i7 8gb'
    * add to cart
    * open cart and click 'Place order'
    * fill in the order form:
      | Maryna | Ukraine | Pervomay | neskazhy | February | 2012 |
    Then pop-up 'Thank you for your purchase!' appears