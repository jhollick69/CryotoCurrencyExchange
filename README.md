# CryotoCurrencyExchange
SpringBoot Rest API calling api's from Deribit Exchnage


**To Build :**
maven package

Or

mvn install / mvn clean install


**To run use**:
mvn spring-boot:run

Or

java -jar target/Crypto-Exchange-demo-0.0.1-SNAPSHOT.jar


**to view API through Swagger**: http://localhost:8083/swagger-ui/#/crypto-controller

Copper Deribit Interview Demo
A SpringBoot application to integrate into the Derbit test exchange over REST. 

Services are:

1) Account Balance API
This returns the details for each account including balances

Example curl:

curl -X GET "http://localhost:8083/api/v1/account/balances?clientSecret=7h-87QJdS67dJV1J6MRoibPKomseuB-qb3_FQ8gMIqI&clientID=UoSQ1r2d&withPortfolio=true"
 -H "accept: */*"

Getting the user's current balances and reserved funds for all available currencies (‘reserved’ means are not available for withdrawal).

2) Account Deposit History
This returns the deposit history for a currency.

Example curl:

curl -X GET "http://localhost:8083/api/v1/deposit/history?clientSecret=7h-87QJdS67dJV1J6MRoibPKomseuB-qb3_FQ8gMIqI&clientID=UoSQ1r2d&currency=BTC&count=10&offset=1" -H "accept: */*"


3) Account Withdrawal History
This returns the withdrawal history for a currency

Example curl:

curl -X GET "http://localhost:8083/api/v1/withdrawal/history?clientSecret=7h-87QJdS67dJV1J6MRoibPKomseuB-qb3_FQ8gMIq&clientID=oSQ1r2d&currency=BTC&count=0&offset=0" -H "accept: */*"

4) Transfer from main account to sub account
This will transfer assets to its sub account
c
5) Transfer to an external account
This transfers asset to an  external accounts
