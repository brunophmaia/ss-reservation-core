package com.place2play.account.service;

import com.place2play.account.configuration.exception.CustomGeneralException;
import org.springframework.stereotype.Service;

@Service
public class EmailSendingService {

//    @Autowired
//    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String body) {

        try {
//            MimeMessage message = mailSender.createMimeMessage();
//
//            MimeMessageHelper helper = new MimeMessageHelper(message);
//
//            helper.setFrom("email@email.com");
//            helper.setTo(to);
//            helper.setSubject(subject);
//            helper.setText(body, true);
//
//            mailSender.send(message);
        }
        catch (Exception e) {
            throw new CustomGeneralException("createAccount.codeGenerationError");
        }
    }
}
