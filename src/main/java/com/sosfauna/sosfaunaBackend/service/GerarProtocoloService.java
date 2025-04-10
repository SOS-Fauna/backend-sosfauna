package com.sosfauna.sosfaunaBackend.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GerarProtocoloService {

    public String gerar() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8).toUpperCase();
    }

}
