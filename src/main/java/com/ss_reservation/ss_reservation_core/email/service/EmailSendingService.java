package com.ss_reservation.ss_reservation_core.email.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSendingService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String body) {

        try {
            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom("bruno.ph.maia08@gmail.com");
            helper.setTo("maiaphbruno@gmail.com");
            helper.setSubject(subject);
            helper.setText(body, true);

            mailSender.send(message);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
