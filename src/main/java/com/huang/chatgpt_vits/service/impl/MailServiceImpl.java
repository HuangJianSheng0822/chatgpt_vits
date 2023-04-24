package com.huang.chatgpt_vits.service.impl;

import com.huang.chatgpt_vits.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.from}")
    private String from;

    @Override
    public boolean sendSimpleCode(String email, String subject, String content) {
        boolean flag = false;
        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setFrom(from);
            mail.setTo(email);
            mail.setSubject(subject);
            mail.setText(content);
            javaMailSender.send(mail);
            flag = true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return flag;
    }
}
