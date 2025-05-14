# 💡 **Eficiência Energética – Sistema de Monitoramento de Consumo**

**Projeto acadêmico da FIAP** desenvolvido para o curso de **Análise e Desenvolvimento de Sistemas**. O sistema tem como objetivo monitorar e calcular o consumo de energia elétrica de dispositivos, utilizando **Spring Security** para autenticação, **Hibernate** para persistência e **JWT** para segurança e controle de acesso.

---

## 📌 **Objetivo do Projeto**

O sistema foi criado com o objetivo de ajudar os usuários a monitorarem seu **consumo energético**, fornecendo uma plataforma onde é possível registrar e visualizar o uso de energia de diferentes dispositivos. Utilizando informações como o **tempo de uso** e o **consumo por hora** em kWh, o sistema calcula e exibe o **consumo total de energia**. Além disso, a plataforma inclui funcionalidades de **registro e autenticação de usuários** com **roles específicas (usuário/admin)** e uma **API segura e escalável**.

---

## 🚀 Tecnologias Utilizadas
- **Linguagem:** Java
- **Framework:** Spring Boot
- **Segurança:** Spring Security
- **ORM:** Hibernate
- **Banco de Dados:** Oracle SQL Developer (JDBC)
- **Controle de Versão:** Git
- **Gerenciador de Dependências:** Maven
- **Migração de Banco de Dados:** Flyway
- **Dependências:** Lombok, Jakarta Annotations
- **Containerização:** Docker
- **Outros:** JWT (JSON Web Tokens), Spring Data JPA

---

## 🧑‍💻 **Funcionalidades**

- **Cadastro e Autenticação de Usuários:** Registro de novos usuários e login com **tokens JWT**, permitindo uma autenticação segura e sem estado (stateless).
- **Controle de Acesso com Roles:** Definição de permissões para **usuários** e **admins** através de **roles**.
- **Registro de Consumo de Energia:** Funcionalidade para registrar o **consumo energético** de dispositivos, incluindo:
  - Nome do dispositivo consumido
  - Consumo por hora (kWh)
  - Tempo de utilização (minutos)
  - Data da utilização
- **Cálculo Automático de Consumo:** O sistema calcula automaticamente o consumo em kWh a partir do **tempo de uso** e do **consumo por hora**, ajudando o usuário a entender seu impacto energético.
- **DTOs** para manipulação e formatação dos dados antes de exibi-los, garantindo maior controle sobre as informações retornadas ao usuário.

---

## 🧪 **Testes e Uso**

Todos os testes e interações com a API foram realizados utilizando a ferramenta **Insomnia**, que permitiu validar as principais funcionalidades, incluindo:

- **Registro e Login de Usuários** com autenticação via JWT.
- **Cadastro e Consulta de Consumo de Energia**, garantindo que os cálculos estejam corretos e funcionando conforme esperado.

---

## 🛠️ **Como Executar**

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/Projeto-Eficiencia-Energetica.git

2. Importe o projeto na sua IDE (IntelliJ IDEA / Eclipse).

3. Configure o banco de dados e execute as migrações com Flyway.

4. Execute a aplicação utilizando Spring Boot.

5. Acesse a API para interagir com o sistema em:
http://localhost:8080.

---

## 👥 **Colaboradores**
Este projeto foi realizado em colaboração com:

[Matheus Webber](https://github.com/I1SWebber)

[Miquéias Martins](https://github.com/miqueias2020)

[Pedro Andrade](https://github.com/sadnek0)

---

## 🧑‍💼 **Autor**
Enrique Bastos
[GitHub](https://github.com/EnriqueAraujoBastos) • [LinkedIn](https://www.linkedin.com/in/enriquearaujobastos/)

---

## 🔗 **Link para o Projeto**
👉 [Acesse o projeto no GitHub](https://github.com/EnriqueAraujoBastos/consumo-energia)
