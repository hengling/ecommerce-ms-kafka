# E-commerce

Implementação de uma rotina de checkout e pagamento de um e-commerce utilizando arquitetura de microserviços e
integração orientada a eventos com Apache Kafka.

## Ambiente

* JDK 11
* Docker & Docker compose
* Node
* NPM

## Estrutura do projeto

* **checkout**: microserviço de checkout
* **payment**: microserviço de pagamento
* **frontend**: frontend da aplicação
* **docker**: contém as dependências necessárias para subir o ambiente

## Executando o projeto

1. No terminal, entre na pasta *docker* e execute o comando `docker-compose up --build`
2. No terminal, entre na pasta *frontend* e execute o comando `npm i && npm run serve`
3. No terminal, entre na pasta *checkout* e execute o comando `./gradlew bootRun`
4. No terminal, entre na pasta *payment* e execute o comando `./gradlew bootRun`
