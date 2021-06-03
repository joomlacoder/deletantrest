package xyz.ignatev.deletantrest.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import xyz.ignatev.deletantrest.entity.User;

@Service
public class JavaMailSenderService {
    @Autowired
    JavaMailSenderImpl mailSender;
    @Value("${spring.mail.username}")
    private String emailFrom;

    Logger log = LoggerFactory.getLogger(JavaMailSenderService.class);

    @Async
    void sendMail(User user) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setText(String.format("Привет! \n" +
                        "Добро пожаловать. Пожалуйста, перейдите по ссылке: http://localhost:8080/subscription/%s",
                user.getActivationCode()));
        mailMessage.setSubject("Подтверждение почты");
        mailMessage.setFrom(emailFrom);
        mailSender.send(mailMessage);
        log.info("Письмо отправлено");
    }
}
