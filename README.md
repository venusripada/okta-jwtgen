# okta-jwtgen

## Node JS instructions
### 1. Clone this repository
```
git clone https://github.com/venusripada/okta-jwtgen.git
```
### 2. Run npm install
```
cd okta-jwtgen

npm install
```
### 3. Copy private, clientID, and Okta org in the code 
```
const privateKey = 
const clientId = "<clientID>";
aud: "https://<Okta org>/oauth2/v1/token",
```
### 4. Run the file 
```
node node-jwtgen.js
```


## Java instructions
### 1. Clone this repository
```
git clone https://github.com/venusripada/okta-jwtgen.git
```
### 2.Copy private, clientID, and Okta org in the code 
```
cd okta-jwtgen

```
### 3. Maven package
```
mvn package

```
### 4. Run the file 
```
java -jar target/jwt-gen-1.0-SNAPSHOT-jar-with-dependencies.jar
```
