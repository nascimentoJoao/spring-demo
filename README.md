# Spring Demo
Repositório contendo uma demo utilizando Spring Boot.

## Ambiente Docker
Para executar a aplicação utilizando o Docker, é necessário iniciar uma instância de PostgreSQL utilizando os seguintes comandos:
```sudo docker run -d --name <nome-container> -e POSTGRES_DB=<database> -e POSTGRES_USER=<database_user>-e POSTGRES_PASSWORD=<database_password> postgres:10.4```

Iniciado o container, execute o comando:

```docker exec -it <nome-container> /bin/bash```

Dentro do container, execute o comando:

```hostname -i```

O resultado será o endereço da imagem Docker do seu banco de dados.
Alterar o arquivo de ```application.properties``` para refletir o endereço obtido no passo anterior.

Agora devemos compilar e empacotar a aplicação.

```mvn package -DskipTests```

A flag '-DskipTests' é utilizada para o comando package não realizar os testes da aplicação, incluindo os de conexão com banco de dados antes de construir empacotar o arquivo Jar.

Estando na raíz do projeto, utilize o comando:

```docker build -t <nome-imagem> . ```

O Dockerfile na raíz do projeto será responsável por construir o container e armazenar a aplicação para futura execução.

Execute o container da aplicação e a ligação com o banco de dados utilizando:

```docker build run -it --link <nome-container-banco-dados> -p <porta:porta> <nome-container-aplicacao>```

Seu ambiente estará pronto para uso de maneira local!

## Heroku

O aplicativo está disponível no Heroku:

https://spring-demo-joaonascimento.herokuapp.com/

## Postman

As rotas disponíveis para consulta estão na Collection abaixo:
