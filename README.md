
# ✅ Desafio Backend Junior Itaú

API construída para resolução do desafio backend de nível junior do itáu proposta no github: `https://github.com/rafaellins-itau/desafio-itau-vaga-99-junior`

## 📋 Requisitos mínimos 

    Docker instalado e funcionando em sua máquina ou Java 21 (JDK 21) e Maven na versão 3.9.x ou superior

## ⚙️ Aplicação - Como rodar
    Faça o clone desse repositório ou baixe a versão zip e descompacte
    Abra o terminal na aplicação
    Caso possua docker instalado, digite o comando: docker-compose up
    Caso possua Java na versão 21 e Maven na versão 3.9.x ou superior, vá até o arquivo DesafioBackendItauApplication.java no caminho src/main/java/com.omar.desafio_backend_itau e rode a aplicação.
    A aplicação está no ar! http://localhost:8080

## 📄  Documentação

A Api foi documentada utilizando Swagger e springdoc-openapi. Caso queira ter acesso a documentação, acesse o link: `http://localhost:8080/swagger-ui/index.html` com a aplicação funcionando.

## ✔️ Requisitos extras cumpridos pela aplicação
1. **Testes automatizados:** Sejam unitários e/ou funcionais, testes automatizados são importantes e ajudam a evitar problemas no futuro. Se você fizer testes automatizados, atente-se na efetividade dos seus testes! Por exemplo, testar apenas os "caminhos felizes" não é muito efetivo. ✔️
2. **Containerização:** Você consegue criar meios para disponibilizar sua aplicação como um container? _OBS: Não é necessário publicar o container da sua aplicação!_ ✔️
3. **Logs:** Sua aplicação informa o que está acontecendo enquanto ela trabalha? Isso é útil para ajudar as pessoas desenvolvedoras a solucionar eventuais problemas que possam ocorrer. ✔️
4. **Observabilidade:** Sua API tem algum endpoint para verificação da saúde da aplicação (healthcheck)? ✔️
5. **Performance:** Você consegue estimar quanto tempo sua aplicação gasta para calcular as estatísticas? ❌
6. **Tratamento de Erros:** O Spring Boot dá às pessoas desenvolvedoras ferramentas para se melhorar o tratamento de erros padrão. Você consegue alterar os erros padrão para retornar _quais_ erros ocorreram? ✔️
7. **Documentação da API:** Você consegue documentar sua API? Existem [ferramentas](https://swagger.io/) e [padrões](http://raml.org/) que podem te ajudar com isso! ✔️
8. **Documentação do Sistema:** Sua aplicação provavelmente precisa ser construída antes de ser executada. Você consegue documentar como outra pessoa que pegou sua aplicação pela primeira vez pode construir e executar sua aplicação? ✔️
9. **Configurações:** Você consegue deixar sua aplicação configurável em relação a quantidade de segundos para calcular as estatísticas? Por exemplo: o padrão é 60 segundos, mas e se o usuário quiser 120 segundos? ✔️

## 💻 Tecnologias utilizadas

- Java 21
- Spring Boot
- Docker
- Swagger
- Jib para imagem da aplicação
- SonarQube
- JaCoCo
- JUnit
- Mockito
- Maven
