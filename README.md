#
git init

git config --global user.email "you@example.com"
git config --global user.name "Your Name"


for java >8, use testng version as = 6.*
for java >=11, use testng latest version.

### Tricky parts to be considered/sturggled/confused while developing this suite, These needs to be understood closely. And searched for websites for answers and fixes, which are given as referce.
    #### while using WebElement.findElement() insted of WebDriver.findElement() method in Selenium and use Xpath as loator,
    for WebElement.getElement() do not added extra "/" in the beginning.
    Example:

    public String getProduct_Title_from_ProductCardElement(WebElement prodCard){
        WebElement elm = null;

        if (prodCard.getAttribute("class").equalsIgnoreCase("newcategory_box")){
            //get product image element
            elm = prodCard.findElement(By.xpath("/p/a"));
        }
        return elm.getText().trim();

    }

    In the above example if we use "/p/a" , then it will not work, , error with element not found. use only "p/a"


## Interview questions to be discussed
