package me.afua.appdemo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class SSUDS implements UserDetailsService {
    AppUserRepository users;

    public SSUDS(AppUserRepository userRepository) {
        this.users = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        AppUser thisUser = users.findByEmail(s);
        if(thisUser==null)
        {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        else{
            return new User(thisUser.getEmail(),thisUser.getPassword(),grantedAuthorities(thisUser));
        }
    }
    Set <GrantedAuthority> grantedAuthorities(AppUser user)
    {
        Set authorities = new HashSet<>();
        for(AppRole eachAuthority:user.getRoles())
        {
            authorities.add(new SimpleGrantedAuthority(eachAuthority.getRoleName()));
        }
        return authorities;
    }

}
