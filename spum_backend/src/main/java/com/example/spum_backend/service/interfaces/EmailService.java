package com.example.spum_backend.service.interfaces;

public interface EmailService {

    void SendMail(String to, String subject, String text);

}
