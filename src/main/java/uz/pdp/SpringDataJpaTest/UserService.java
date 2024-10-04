package uz.pdp.SpringDataJpaTest;

import org.springframework.expression.AccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
    public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(rollbackFor = AccessException.class)
    public void m1() throws IOException{
        userRepository.save(new Users(null,"sama1n","samanjon1"));
        throw new IOException("hello world");
    }
}

