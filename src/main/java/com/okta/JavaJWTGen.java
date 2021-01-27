package com.okta;

import io.jsonwebtoken.Jwts;
import java.security.Key;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.time.Instant;

import java.util.Date;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.UUID;

public class JavaJWTGen {
    public static void main(String[] args) throws Exception{
        String privateKeyString = "-----BEGIN PRIVATE KEY-----\n" +
            "MIIasdfasdfasdfasdftvlKuGJOQ/1\n" +
            "BGKqfzlfzasdfasdfasdfpXXPMotCeOCVi8ghUqJd\n" +
            "9B9JPasdfasdfasoZOvbPL\n" +
            "nwxFijy6asdfasdfw6tg/qPOX\n" +
            "elUy/+syx+asdfsfdeZiWQ67eGuEf6Pe3dCzbs\n" +
            "DMasdfH3asdfsadfO8ushev0bDkn81iVUFc\n" +
            "GQasdfsduPWRRqA==\n" +
            "-----END PRIVATE KEY-----";
        Key privateKey = getKeyFromString(privateKeyString); // Load an RSA private key from configuration
        Instant now = Instant.now();
        String clientId = "<clientID>";

        String jwt = Jwts.builder()
                .setAudience("https://${yourOktaDomain}/oauth2/default/v1/token")
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(5L, ChronoUnit.MINUTES)))
                .setIssuer(clientId)
                .setSubject(clientId)
                .setId(UUID.randomUUID().toString())
                .signWith(privateKey)
                .compact();
        System.out.println(jwt);
    }
    
    static RSAPrivateCrtKey getKeyFromString(String key) throws Exception{
        String privateKeyPEM = key
      .replace("-----BEGIN PRIVATE KEY-----", "")
      .replaceAll("\n", "")
      .replace("-----END PRIVATE KEY-----", "");

    byte[] encoded =  Base64.getDecoder().decode(privateKeyPEM);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
    return (RSAPrivateCrtKey) keyFactory.generatePrivate(keySpec);
    }
}