package com.proyecto.faan.emailRecover.Services;


import com.proyecto.faan.emailRecover.Dtos.EmailValuesDTO;

public interface EmailService {
    boolean sendEmail(EmailValuesDTO values);

}
