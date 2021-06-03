package xyz.ignatev.deletantrest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import xyz.ignatev.deletantrest.entity.User;
import xyz.ignatev.deletantrest.repository.UserRepository;
import xyz.ignatev.deletantrest.service.UserService;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    JavaMailSenderService mailSenderService;

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean addUser(User user) {
        if (getUserByEmail(user.getEmail()) != null)
            return false;
        user.setActivationCode(UUID.randomUUID().toString());
        userRepository.save(user);

        if (StringUtils.hasText(user.getEmail())) {
            mailSenderService.sendMail(user);
        }
        return true;
    }


    @Override
    public boolean activateUser(String code) {
        User user = userRepository.findByActivationCode(code);
        if (user != null) {
            user.setActivationCode(null);
            return true;
        }
        return false;
    }


}
