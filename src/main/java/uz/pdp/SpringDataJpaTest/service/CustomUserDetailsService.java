package uz.pdp.SpringDataJpaTest.service;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.SpringDataJpaTest.model.User;
import uz.pdp.SpringDataJpaTest.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findFirstByUsername(username)
                .orElseThrow(() -> new BadCredentialsException("Username or password incorrect"));
        UserDetails build = org.springframework.security.core.userdetails.User.withUsername(username)
                .password(user.getPassword())
                .roles("ADMIN")
//                .accountExpired(true)
                .build();
        return build;
    }
}
