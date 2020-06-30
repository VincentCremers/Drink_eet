package drinkeet.securityjwt.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//USER DETAIL SERVICE
@Service
public class MyUDS implements UserDetailsService {

    //TODO load user from database
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return new User("naam", "wachtwoord", new ArrayList<>());
    }
}
