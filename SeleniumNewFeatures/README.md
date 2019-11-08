### Selenium 4 New Features

**Take Screen Shot of WebElement:**
WebElement object has now a new method called as "getScreenshotAs" which enables you to take a screenshot of a specific WebElement.Earlier versions, this method is available at driver object level and now with new release of Selenium 4, this is been added at WebElement level as well.

**Open Window of Tab:**
You can now open a blank window or a tab on your browser.After opening a new tab, you can use navigate().to() methods to go to another page.

**Getting Object Location and Size:**
In the previous version of Selenium, there was a method to access the Dimension of a WebElement. Now, there’s a Rectangle object. By using this Rectangle property, you can access the location and size of the WebElement.

**Load Insecure Web Site:**
Sometimes, web sites have SSL issues. You need to approve that you want to continue navigating the web site. However, ChromeDevTools allows you to accept that warning easily.

**Relative Locators:**
Selenium 4 brings Relative Locators (originally named Friendly Locators). This functionality was added to help us locate elements that are nearby other elements. The available options are:

     above(): sought-after element appears above specified element
     below(): sought-after element appears below specified element
     toLeftOf(): sought-after element appears to the left of specified element
     toRightOf(): sought-after element appears to the right of specified element
     near(): sought-after element is at most 50 pixels away from specified element.
All of these methods are overloaded to accept a By or a WebElement.
