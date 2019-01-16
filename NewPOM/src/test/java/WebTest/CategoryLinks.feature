Feature = Verify category links are working

Scenario Outline = All category links on the homepage should be working

Given the user is already on the homepage
When the user clicks on <category>
Then the user should be able to navigate to the related category page <related category page URL>

Examples:
|category|related category page URL|
|Computers|https://demo.nopcommerce.com/computers|
|Electronics|https://demo.nopcommerce.com/electronics|
|Apparel|https://demo.nopcommerce.com/apparel|
|Digital Downloads|https://demo.nopcommerce.com/digital-downloads|
|Books|https://demo.nopcommerce.com/books|
|Jewelery|https://demo.nopcommerce.com/jewelry|
|Gift Cards|https://demo.nopcommerce.com/gift-cards|