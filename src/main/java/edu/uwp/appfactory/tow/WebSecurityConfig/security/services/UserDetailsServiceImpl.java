package edu.uwp.appfactory.tow.WebSecurityConfig.security.services;

import edu.uwp.appfactory.tow.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.uwp.appfactory.tow.WebSecurityConfig.repository.UsersRepository;

/**
 * user details service implementation
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsersRepository userRepository;

    /**
     * load a user by their username, exception if not found
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return UserDetailsImpl.build(user);
    }

    /**
     * load a user by their username, exception if not found
     */
    public UserDetails loadUserByUUID(String uuid) {
        Users user = userRepository.findByUUID(uuid)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + uuid));
        return UserDetailsImpl.build(user);
    }
}
