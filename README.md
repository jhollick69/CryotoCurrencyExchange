# CryptoCurrencyExchange
SpringBoot Rest API calling api's from Deribit Exchange
TODO: a) Junits/integration to do
	  b) common code collated and refactored
	  c) better credential handling , could put in application.properties rather than each call
	  


**To Build :**
maven package

Or

mvn install / mvn clean install


**To run use**:
mvn spring-boot:run
java -jar target/Crypto-Exchange-demo-0.0.1-SNAPSHOT.jar

Or

**To Run in Docker**
A local Postgress intance running on port 5432 or in a docker container with the following command 
docker run --name some-postgres -p 5432:5432 -e POSTGRES_PASSWORD=test -d postgres

docker-compose up


**to view API through Swagger**: http://localhost:8083/swagger-ui/#/crypto-controller

Copper Deribit Interview Demo
A SpringBoot application to integrate into the Derbit test exchange over REST. 

Services are:

1) ***Account Balance API***
This returns the details for each account including balances

Example curl:

curl -X GET "http://localhost:8083/api/v1/account/balances?clientSecret=7h-87QJdS67dJV1J6MRoibPKomseuB-qb3_FQ8gMIqI&clientID=UoSQ1r2d&withPortfolio=true"
 -H "accept: */*"

Getting the user's current balances and reserved funds for all available currencies (‘reserved’ means are not available for withdrawal).

2) ***Account Deposit History***
This returns the deposit history for a currency.

Example curl:

curl -X GET "http://localhost:8083/api/v1/deposit/history?clientSecret=7h-87QJdS67dJV1J6MRoibPKomseuB-qb3_FQ8gMIqI&clientID=UoSQ1r2d&currency=BTC&count=10&offset=1" -H "accept: */*"

3) ***Both withdrawal and deposit history for a currency***

Example curl:

curl -X GET "http://localhost:8083/api/v1/assets/history?clientSecret=7h-87QJdS67dJV1J6MRoibPKomseuB-qb3_FQ8gMIqI&clientID=UoSQ1r2d&currency=btc&count=3&offset=0" -H "accept: */*"

4) ***Account Withdrawal History***
This returns the withdrawal history for a currency

Example curl:

curl -X GET "http://localhost:8083/api/v1/withdrawal/history?clientSecret=7h-87QJdS67dJV1J6MRoibPKomseuB-qb3_FQ8gMIqI&clientID=UoSQ1r2d&currency=btc&count=5&offset=0" -H "accept: */*"

5) ***Transfer from main account to sub account***
This will transfer assets to its sub account

Example curl:

curl -X GET "http://localhost:8083/api/v1/transfer/subaccount?clientSecret=7h-87QJdS67dJV1J6MRoibPKomseuB-qb3_FQ8gMIqI&clientID=UoSQ1r2d&currency=btc&amount=1&destination=34098" -H "accept: */*"

6) ***Transfer to an external account***

This transfers asset to an  external accounts
curl -X GET "http://localhost:8083/api/v1/transfer/external?clientSecret=7h-87QJdS67dJV1J6MRoibPKomseuB-qb3_FQ8gMIqI&clientID=UoSQ1r2d&currency=btc&amount=1&destination=3LmiRtpFsQYMBZ5gswrUqqvYXVn5oZCwG9" -H "accept: */*"

