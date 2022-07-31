
package com.portfolioap.ap.security.service;

import com.portfolioap.ap.security.model.User;
import com.portfolioap.ap.security.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    
    @Autowired
    UserRepository userRepo;
    
    public Optional<User> getByEmail(String email){
        return userRepo.findByEmail(email);
    }
    
    public boolean existsByEmail(String email){
        return userRepo.existsByEmail(email);
    }
    
    public void save(User user){
        userRepo.save(user);
    }
    
}
