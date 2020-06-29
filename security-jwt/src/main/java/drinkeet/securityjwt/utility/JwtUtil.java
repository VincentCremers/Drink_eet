package drinkeet.securityjwt.utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.cglib.core.internal.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtUtil {

    //secret key base64 encoded
    private String key = "random_secret_key";
    private String base64Key = DatatypeConverter.printBase64Binary(key.getBytes());
    private byte[] secretBytes = DatatypeConverter.parseBase64Binary(base64Key);

    //extracts username from token
    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    //extracts expiration date from token
    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    // uses a claim resolver to figure out what claims are from token
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    //extracts all claims from token and validates token. Throws exception if invalid signature and token is expired.
    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(secretBytes).parseClaimsJws(token).getBody();
    }

    //checks if token is expired
    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    //takes in userdetails object, creates JWT based of UD
    //pass in map with any claims that want to include in payload, creates JWT for username
    // (CLAIMS IS EMPTY RIGHT NOW)
    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    //call jwts API using builder pattern and setting the claims
    //subject is the person who is being authenticated
    //creates token and sets expiration 10 hours from current time
    //signs token with HS256 method
    private String createToken(Map<String, Object> claims, String subject){
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 36000000))
                .signWith(SignatureAlgorithm.HS256, secretBytes).compact();
    }

    //checks if username from token is same as userdetails and if token is not expired for validation
    public boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
