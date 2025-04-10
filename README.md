


```mermaid
erDiagram
    ORGAOS {
        VARCHAR id PK
        VARCHAR nome
        VARCHAR cnpj
        TEXT descricao
        VARCHAR telefone
        VARCHAR rede_social
        VARCHAR rua
        INT numero
        VARCHAR bairro
        VARCHAR cidade
        VARCHAR cep
        LONGBLOB foto_perfil
        BOOLEAN acesso
        DATETIME data_criacao
    }
    USUARIOS {
        VARCHAR id PK
        VARCHAR cpf
        VARCHAR nome
        DATETIME dt_nascimento
        VARCHAR telefone
        BLOB foto_perfil
        DATETIME dataCriacao
        BOOLEAN acesso
        VARCHAR email
        VARCHAR public_id
    }
    DENUNCIAS {
        VARCHAR id PK
        VARCHAR animal
        VARCHAR denunciado
        TEXT descricao
        DATE data_ocorrido
        TIME hora_ocorrido
        VARCHAR bairro
        VARCHAR numero
        VARCHAR rua
        VARCHAR cep
        DATETIME data_criacao
        ENUM status_denuncia
        VARCHAR usuario_id FK
        VARCHAR orgaos_id FK
    }
    ANIMAIS_ADOCAO {
        INT id PK
        VARCHAR nome
        VARCHAR especie
        INT idade
        ENUM sexo
        LONGBLOB foto
        DATETIME data_criacao
        ENUM status_adocao
        VARCHAR orgaos_id FK
    }

    USUARIOS ||--o{ DENUNCIAS : realiza
    ORGAOS ||--o{ DENUNCIAS : recebe
    ORGAOS ||--o{ ANIMAIS_ADOCAO : disponibiliza

```
