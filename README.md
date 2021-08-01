# Avaliação Java


## Descrição

  O teste consiste em construir a camada de serviço de um pseudo ecommerce de games mobile utilizando Java

## Como executar os testes
  
  O projeto usa o maven wrapper (mvnw).
  Para executar os testes de exemplo basta o comando abaixo:
  ```sh
  ./mvnw clean test
  ```

## Requisitos

  - Existe um exemplo de carga de banco de dados em memória em [ProductDaoExampleTest.java](./src/test/java/br/com/supera/game/store/ProductDaoExampleTest.java)
  - Os valores exibidos no checkout (frete, subtotal e total) devem ser calculados dinamicamente
  - O usuário poderá adicionar e remover produtos do carrinho
  - O usuário poderá ordenar os produtos por preço, popularidade (score) e ordem alfabética.
  - A cada produto adicionado, deve-se somar R$ 10,00 ao frete.
  - Quando o valor dos produtos adicionados ao carrinho for igual ou superior a R$ 250,00, o frete é grátis.

## O que iremos avaliar

Levaremos em conta os seguintes critérios:

  - Cumprimento dos requisitos
  - Qualidade do projeto de API e fluidez da DX
  - Organização do código e boas práticas
  - Domínio das linguagens, bibliotecas e ferramentas utilizadas
  - Organização dos commits
  - Escrita e cobertura de testes

## Sobre a entrega

  - A API pode ser HTTP, Restful, WSDL/SOAP, HATEOAS ou gRCP mas deverá ser documentado no [README.md](./README.md) como executar/compilar/empacotar o projeto e quais os endpoints solicitados nos requisitos acima. 
  - A versão do Java pode ser atualizada para 11 ou 14.
  - Não existe restrição de framework (EE, Spring, Quarkus etc) mas será melhor avaliado se justificado no [README.md](./README.md) os motivos da decisão.

## As tecnologias que foram utilizadas, para o desenvolvimento do desafio:

  - Java 11
  - Spring Boot
  - H2 Database
  - Liquibase
  - Lombok
  - Validation
  - jUnit

## Requisitos para configuração do Projeto

  - Java 11
  - Maven
  - Git

## Configurações do Sistema

Este projeto, foi desenvolvido, utilizando Spring boot em arquitetura REST, possui endpoints para lista de produtos, e um crud para carrinho de compras.



### Importando as Dependencias

Para importar as dependencias basta ir no pacote principal e rodar o comando abaixo:

    mvn package
  
  
### Levantamento de Serviços
  
Para levantar o serviço fora da IDE, basta executar o comando abaixo:
  
    mvn spring-boot:run

O serviço estará disponivel na rota abaixo:

    http://localhost:8080
  
## Endpoints

Nessa seção, será explicado, os endpoints da aplicação. Existe uma coleção do postman, onde os endpoints estarão localizados. 

    src/main/resources/collection-postman/sistema-game.postman_collection               

### Produtos

Serviço de produto,se encontra na rota /product . O usuário poderá ordenar os produtos por preço, popularidade (score) e ordem alfabética.

    http://localhost:8080/product?page=0&linesPerPage=10&orderBy=name&direction=ASC
  
### Carrinho de Compras

O serviço de carrinho de compras, se encontra na rota /shopping-cart . Abaixo será informado os serviços do carrinho de compras.

  - Listar todos os carrinhos: GET - http://localhost:8080/shopping-cart
  - Buscar um carrinho de compras: GET - http://localhost:8080/shopping-cart/1
  - Deletar um carrinho de compras: DELETE - http://localhost:8080/shopping-cart/1
  - Criar carrinho com itens: POST - http://localhost:8080/shopping-cart

Body:
 ```
 {
    "itens": [
        {
            "product": {
                "id": 4,
                "name": "Call Of Duty WWII",
                "price": 249.99,
                "score": 205,
                "image": "call-of-duty-wwii.png"
            }
        },
        {
            "product": {
                "id": 2,
                "name": "Call Of Duty Infinite Warfare",
                "price": 49.99,
                "score": 80,
                "image": "call-of-duty-infinite-warfare.png"
            }
        },
        {
             "product": {
                "id": 8,
                "name": "FIFA 18",
                "price": 195.39,
                "score": 325,
                "image": "fifa-18.pn"
            }
        }
    ]
}
```
 - O usuário poderá adicionar e remover produtos do carrinho através de: PUT - http://localhost:8080/shopping-cart/1

Body
```
{
    "statusEnum": "PENDENTE",
    "itens": [
        {
            "product": {
                "id": 2,
                "name": "Call Of Duty Infinite Warfare",
                "price": 49.99,
                "score": 80,
                "image": "call-of-duty-infinite-warfare.png"
            }
        },
        {
             "product": {
                "id": 8,
                "name": "FIFA 18",
                "price": 195.39,
                "score": 325,
                "image": "fifa-18.pn"
            }
        }
    ]
}
```
