package uz.pdp.SpringDataJpaTest.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import uz.pdp.SpringDataJpaTest.dto.AuthenticationDto;
import uz.pdp.SpringDataJpaTest.exception.UsernameOrPasswordWrong;
import uz.pdp.SpringDataJpaTest.model.User;
import uz.pdp.SpringDataJpaTest.repositories.UserRepository;
import uz.pdp.SpringDataJpaTest.utils.JwtUtil;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        String encode = passwordEncoder.encode(user.getPassword());
        user.setPassword(encode);
        User save = userRepository.save(user);
        return user;
    }
    @PostMapping("/authentication")
    public ResponseEntity<AuthenticationDto> authentication(@RequestParam("username")String username, @RequestParam("password")String password){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        String accessToken = jwtUtil.generateToken(username);
        return ResponseEntity.ok(new AuthenticationDto(accessToken));
    }



}
