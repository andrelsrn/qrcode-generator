# 🏷️ QR Code Generator - AWS S3

## 🚀 Visão Geral

Este é um serviço web desenvolvido em **Java** (usando Maven) para a geração de QR Codes. A aplicação é totalmente **Dockerizada** para garantir portabilidade e é integrada ao **Amazon S3** para armazenamento persistente e durável dos códigos gerados.

### ✨ Principais Tecnologias

* **Linguagem/Framework:** Java / SpringBoot
* **Build Tool:** Maven
* **Containerização:** Docker
* **Armazenamento de Objetos:** AWS S3 (Amazon Simple Storage Service)
* **SDK da AWS:** AWS SDK for Java 2.24.12

---

## ⚙️ Arquitetura do Projeto

O serviço funciona da seguinte forma:

1.  O usuário envia uma requisição para o *endpoint* de geração de QR Code.
2.  A aplicação, rodando em um *container* Docker, recebe a requisição.
3.  O QR Code é gerado como um arquivo de imagem (`.png`).
4.  O arquivo é enviado diretamente para um *bucket* configurado no AWS S3.
5.  O *endpoint* retorna para o usuário a URL pública do QR Code no S3.

---

## 🛠️ Pré-requisitos

Para rodar o projeto localmente ou em seu ambiente:

* **Java 21**
* **Maven** 
* **Docker** e **Docker Compose**
* **Conta AWS** com credenciais configuradas (IAM User com acesso ao S3)

---

## 📦 Como Rodar Localmente

Siga os passos para construir a imagem Docker e iniciar o serviço.

### 1. Configurar Variáveis de Ambiente

Crie um arquivo chamado `.env` na raiz do projeto e preencha com suas configurações da AWS:

    # Variáveis de Ambiente (.env)
    AWS_ACCESS_KEY_ID=[SUA CHAVE DE ACESSO AWS]
    AWS_SECRET_ACCESS_KEY=[SUA CHAVE SECRETA AWS]
    AWS_REGION=[A REGIAO DO SEU BUCKET - Ex: us-east-2]
    S3_BUCKET_NAME=[O NOME EXATO DO SEU BUCKET NO S3]

### 2. Construir e Executar o Container

Use o Docker Compose para automatizar a construção da imagem e a execução do container:

    # Constrói a imagem (baseada no Dockerfile)
    docker-compose build

    # Inicia o container, expondo a porta [Ex: 8080]
    docker-compose up

O serviço estará acessível em `http://localhost:8080`.


---

## 🔒 Segurança e Durabilidade (S3)

Para garantir a segurança e a não-perda dos dados:

1.  **Versionamento:** O *bucket* S3 `[S3_BUCKET_NAME]` deve ter o **Versionamento** ativado. Isso protege contra exclusão acidental e permite a recuperação de versões antigas dos QR Codes.
2.  **Permissões de Acesso:** O **IAM User** utilizado pelas credenciais deve ter apenas as permissões necessárias (`s3:PutObject`, `s3:GetObject`, etc.) para o *bucket* específico (**Princípio do Menor Privilégio**).

---

## 🧑‍💻 Contribuição

Contribuições são bem-vindas! Se você encontrou um bug ou tem uma sugestão de melhoria:

1.  Faça um **Fork** do projeto.
2.  Crie uma **Branch** para sua *feature* (`git checkout -b feature/minha-feature`).
3.  Faça o **Commit** das suas alterações.
4.  Envie o **Pull Request**.

---

## 👤 Autor

* **andrelsrn** - https://www.linkedin.com/in/andre-nunes-03866b55/
---

