
> Você pode usar o formato `export VAR=valor` no Linux/macOS ou `set VAR=valor` no Windows.

---

## ⚙️. Configure as variáveis de ambiente no IntelliJ IDEA

1. **Abra** a janela de Run Configurations:
    - Menu superior **Run → Edit Configurations…**
    - Ou clique na setinha ao lado do botão verde ▶️ e escolha **Edit Configurations…**.

2. **Selecione** a sua configuração de execução (por exemplo, “Application” ou o nome do seu script).

3. No campo **Environment variables**, clique no ícone de três pontinhos `…`.

4. Na janela que se abre, adicione cada variável:

   | Name       | Value                                              |
      | ---------- | -------------------------------------------------- |
   | BD_URL     | jdbc:oracle:thin:@//localhost:1521/ORCLPDB1        |
   | BD_USUARIO | seu_usuario                                       |
   | BD_SENHA   | sua_senha                                          |

5. Clique em **OK** para fechar e **Apply** para salvar a configuração.

---

## 💻 . Acesse as variáveis no seu código Java

Se você estiver usando **Spring Boot**, no seu `application.properties` (ou `application.yml`) defina:

```properties
spring.datasource.url=${BD_URL}
spring.datasource.username=${BD_USUARIO}
spring.datasource.password=${BD_SENHA}
