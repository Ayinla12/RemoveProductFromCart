Test Cases: Remove Product from Cart
Test Case 1: Launch Homepage
Objective: Verify that the website's homepage loads successfully.
Steps:
1.	Launch the browser.
2.	Navigate to https://automationexercise.com.
3.	Handle the cookie consent pop-up if displayed.
4.	Verify the page title is "Automation Exercise".
Expected Result:
The browser displays the homepage, and the title matches the expected value.
Test Case 2: Add Products to Cart
Objective: Add products to the shopping cart and verify the cart page.
Steps:
1.	Select a product from the homepage and click "Add to Cart".
2.	On the modal that appears, click "Continue Shopping".
3.	Select another product and click "Add to Cart".
4.	On the modal, click "View Cart" to navigate to the cart page.
5.	Verify the URL of the cart page is https://automationexercise.com/view_cart.
Expected Result:
The selected products are added to the cart successfully, and the cart page is displayed with the correct URL.
Test Case 3: Remove Product from Cart
Objective: Remove a product from the cart and verify that the cart updates correctly.
Steps:
1.	Count the total number of products in the cart.
2.	Click the "X" button next to the first product to remove it.
3.	Wait for the product to disappear from the cart.
4.	Count the total number of products in the updated cart.
5.	Compare the initial and updated counts.
Expected Result:
The product is removed successfully, and the total number of items in the cart decreases by 1.
Test Case 4: Tear Down
Objective: Clean up resources after test execution.
Steps:
1.	Close the browser.
Expected Result:
The browser is closed successfully, and the WebDriver instance is terminated.

