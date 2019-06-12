## MyRetail Application


### What Does It Do
  * Responds to HTTP CRUD requests and update product information in mongodb
  * Retrieve product name from an external API


### Application Set Up

#### Set Up Mongodb
  * Users need to install mongodb on their machines
  * To install and run mongodb, visit https://docs.mongodb.com/manual/administration/install-community/
  * There is no need to set up authentication such as username and password after installing mongodb
  * After the installation, open up the terminal and run mongodb by typing mongo
  * Any data persisted by the application will be saved to test database
  * In the terminal, type "use test" to use database test, hit enter
  * To see all data in test, type: db.product.find({})
  
#### Running the Application
  * The application is a maven project
  * Download the project and open it in an IDE, preferrable Eclipse
  * Open MyRetailApp.java in com.myretail.myretail_restful_service
  * Right click on anywhere of the file, select "Run As -> Java Application"
  
#### Add Initial Data to Mongodb
  * Data can be added to test database after the app starts running
  * Postman is used to add some initial data. Download Postman here: https://www.getpostman.com/downloads/
  * In Postman, select Post to add data
  * Enter localhost:8080/product/add next to Post
  * Select Body, raw (radio button), and JSON(application/json)
  * Copy and paste the following, and then hit send<br/>
    {"id":15117729, "name":"The Big Lebowski (Blu-ray)(Widescreen)", "currentPrice":{"value":150, "currencyCode":"USD"}}
  * After sending the json body, you should see status shown as 200 OK and the response below
  * You can add more data if interested:<br/>
    {"id":16483589, "name":"Black+Becker Microwave", "currentPrice":{"value":50, "currencyCode":"USD"}}<br/>
    {"id":16696652, "name":"Threshold 1 Set of Diningware", "currentPrice":{"value":25, "currencyCode":"USD"}}<br/>
    {"id":15643793, "name":"Tropicana Orange Juice", "currentPrice":{"value":2.5, "currencyCode":"USD"}}<br/>
    {"id":16483999, "name":"Threshold 6ft futon", "currentPrice":{"value":350, "currencyCode":"USD"}}<br/>

### Testing
  * Run the JUnit tests found in the test folder
  * Use an application like Postman to test the endpoints of the application
