const njwt = require('njwt');

const privateKey = `-----BEGIN PRIVATE KEY-----

-----END PRIVATE KEY-----`;
;// Load an RSA private key from configuration
const clientId = "<clientID>"; // Or load from configuration
const now = Math.floor( new Date().getTime() / 1000 ); // seconds since epoch
const plus5Minutes = new Date( ( now + (60*60) ) * 1000); // Date object

const claims = {
  aud: "https://<Okta org>/oauth2/v1/token", // audience
  iss: clientId,
  sub: clientId
};

const jwt = njwt.create(claims, privateKey,'RS256')
  .setIssuedAt(now)
  .setExpiration(plus5Minutes)
  .setIssuer(clientId)
  .setSubject(clientId)
  .compact();
console.log(jwt);
