package drinkeet.securityjwt;

import drinkeet.securityjwt.models.AuthenticationRequest;
import drinkeet.securityjwt.models.AuthenticationResponse;
import drinkeet.securityjwt.services.MyUDS;
import drinkeet.securityjwt.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUDS userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;


    //requestmapping /authenticate going to take in username and password as an input argument and returns jwt.
    //created authenticate method endpoint, which is mapped to createAuthenticateToken, takes in authenticationRequest (payload in postbody)
    //contains username and password
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try{
            //authenticates username and password
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
        );
        } catch (BadCredentialsException e){
            throw new Exception("wrong username or password", e);
        }

        //generates jwt using userdetails. userdetails is only username at the moment
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }


}
