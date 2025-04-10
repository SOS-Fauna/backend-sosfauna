package com.sosfauna.sosfaunaBackend.model.dto;

import com.sosfauna.sosfaunaBackend.model.entity.StatusDenuncia;

public record ProtocoloResponse(
         String protocolo,
         StatusDenuncia statusDenuncia,
         String telefoneOrgao,
         String redeSocialOrgao,
         String nomeOrgao
) {
}
