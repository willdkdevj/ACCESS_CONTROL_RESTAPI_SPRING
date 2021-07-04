## API REST para o Controle de Acesso a Usuários
> O projeto consiste na criação de uma API REST utilizando o recurso de auditoria do JPA através do Hibernate Envers, na qual monitorará ações realizadas em um Sistema de Controle de Acesso a Funcionários a fim de checar os responsáveis, informações, data e horário que ocorreram acessos a base de dados a fim de assegurar a integridade do dados presentes no banco de dados relacional.

[![Spring Badge](https://img.shields.io/badge/-Spring-brightgreen?style=flat-square&logo=Spring&logoColor=white&link=https://spring.io/)](https://spring.io/)
[![Maven Badge](https://img.shields.io/badge/-Maven-000?style=flat-square&logo=Apache-Maven&logoColor=white&link=https://maven.apache.org/)](https://maven.apache.org/)
[![Hibernate Badge](https://img.shields.io/badge/-Hibernate-gold?style=flat-square&logo=Hibernate&logoColor=white&link=https://hibernate.org/orm/envers/)](https://hibernate.org/orm/envers/)


<img align="right" width="400" height="300" src="https://github.com/willdkdevj/assets/blob/main/Spring/spring-framework.png">

## Descrição da Aplicação
O objetivo desta API é de ser a intermediadora entre a aplicação (*Front-End*) e o Banco de Dados, na qual consistem em um sistema de Controle de Acesso de Funcionários a uma empresa, onde é impresindível que seja válidado o acesso do mesmo confirmando o seu vínculo empregatício com a mesma. Como o intuito principal é a abordagem em auditar os dados que são persistidos no banco de dados a fim de conhecer seus manipuladores, não entramos em como é utilizado tal interface, mas como estes dados podem ser enviados para o banco e como o mesmo se comporta para evidênciar modificações em sua estrutura.

A necessidade de monitorar as ações realizadas por um usuário frente às complexidades de um processo de segurança, sejam do usuário ou da própria instituição são reais. Muitas vezes esta motivação é até um fator legal, como é realizado atuamente com a vigência da Lei Geral de Proteção de Dados (LGPD).

Resguardar a integridade das informações administradas por um sistema geralmente é uma exigência da área de Segurança da Informação da corporação, na qual é necessário a resguarda da integridade das informações administradas por um sistema.

Onde o DBA pode realizar este procedimento de registrar toda e qualquer operação de CRUD dos registros utilizando recursos, como *Stored Procedure* e *Triggers*, mas este tipo de estratégica necessidade de um alto acoplamento entre a aplicação e o Banco de Dados. Outra opção, é o desenvolvedor realizar uma implmentação a fim de registrar todas as alterações realizadas em tabelas auditáveis, que são tabelas exclusivas com o intuito de registrar todo o histórico. No entanto, esta estratégica requer um ajuste fino entre o código e o banco de daados, na qual requer que a persistência ocorra primeiro na tabela da função e depois na tabela auditável.

Uma dos grandes *frameworks* adotado pela Comunidade Java é o *Hibernate* **(Red Hat)**, que permite mitigar a complexidade no Mapeamento Objeto Relacional (ORM) possibilitando construir aplicações adaptáveis a Banco de Dados Relacionais, onde diante deste cenário, de auditar as operaçôes realizadas ao registros persistidos a fim de rastrear as ações realizadas e seus responsáveis, é que surgiu o projeto [Envers](https://hibernate.org/orm/envers/).

Além disso, um processo de auditoria bem estruturado deve fornecer informações básicas sobre as operações realizadas sobre a aplicação, como:
* Nome do responsável por realizar operações (CRUD);
* Elencar quais informações foram requisitadas;
* Registro apontando o estado antes da modificação;
* Data e horário das operações realizadas que ocasionaram modificações.

Estas informações possibilitam ao administrador a realizar as tratativas a fim de recuperar, corrigir e evidênciar ações que ocasionaram qualquer tipo de manipulação da informação.

## Principais Frameworks do Projeto
Os frameworks são pacotes de códigos prontos que facilita o desenvolvimento de aplicações, desta forma, utilizamos estes para obter funcionalidades para agilizar a construção da aplicação. Abaixo segue os frameworks utilizados para o desenvolvimento este projeto:

**Pré-Requisito**: Java 11 (11.0.10 2021-01-19 LTS)
			   Maven 3.6.3

| Framework           | Versão  |
|---------------------|:-------:|
| Spring Boot         | 2.4.4   |
| Spring Data JPA     | 2.4.4   |
| Hibernate Envers    | 5.5.3   |
| Hibernate Validator | 6.1.7   |
| H2 Database         | 1.4.200 |
| Lombok              | 1.18.18 |
| Swagger             | 2.9.2   |

## Sobre o Hibernate Envers
O [Hibernate Enver](https://hibernate.org/orm/envers/) possibilita organizar históricos das versões dos dados gerenciados pela aplicação, através das entidades mapeadas para a persistência JPA, ou somente um atributo especifico da classe a persistir, a fim de auditar as modificações ocorridas referente aos dados trafegados. Ele é uma biblioteca que permite auditar classes persistentes através do controle de versões em ORM.

Para cada entidade mapeada, uma tabela versionada é criada no banco de dados, contendo todo o histórico das alterações efetuadas na entidade em questão, desta forma, cada transação realizada no banco é classificada como uma espécie de *revisão* (isto no caso de haver a modificação do registro - em caso de consulta isto não ocorre), na qual cada nova revisão é gerada um incremento automático das tabelas (auditada e versionada) que permitem o versionamento das classes persistentes.

Resumindo, cada vez que uma tabela auditada sofre modificações em seus registros (dados), uma nova "versão" é gerada pelo Envers e armazenada em outra tabela, que contém como chave primária o atributo de revisão, além do tipo de operação realizada e dos campos auditáveis da tabela auditada. Este processo é similar ao processo que o *Git* executa para manter as revisões globais para todas as alterações ocorridas no código.

![Hibernate Envers](https://github.com/willdkdevj/assets/blob/main/Spring/hibernate-envers/hibernate-envers.png)

## Sobre a Estrutura da API REST utilizando o Hibernate Envers
Como apresentado no tópio *Principais Frameworks do Projeto*, utilizando o gerenciador de *Build*, o **Maven**, foi incluso as dependências necessárias para documentar, mapear os ORM e desenvolver uma API. Isso é possível através do arquivo de configuração **pom.xml** (*Project Object Model*), que permite configurar as dependências do projeto apontando para os identificadores de seus respectivas versões, abstraindo a necessidade de procurar *jars* a fim de adicioná-los ao *classpath* do projeto, desta forma, a configuração para o Hibernate ficará da seguinte forma:
```xml
    <!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-envers -->
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-envers</artifactId>
        <version>5.5.3.Final</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-validator -->
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-validator</artifactId>
        <version>6.1.7.Final</version>
    </dependency>
```

É possível utilizar o Hibernate Envers com qualquer Banco de Dados Relacional, mas para exemplificação de seu uso será utilizado o **H2 Database**, que é um banco de dados *Open Source* que funciona em memória, na qual seu armazenamento acaba sendo votátil. Isto significa que, ao iniciar e desligar a aplicação os dados armazenados são descartados, mas como é só para testar a biblioteca será útil para averiguar a eficácia do Hibernate.
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

Desta forma, será deixado que a dependência do *Spring Data* faça com que Spring dê suporte ao uso de Entidades e Repositorios para conexão com o banco, ao trazer consigo também o Hibernate e a JPA. Já na dependencia do H2, será definido o escopo como runtime, pois é necessário para especificar que utilizaremos a biblioteca somente durante a execução.

### Configuração da API, Hibernate e H2
Foi utilizado o **application.yml** para realizar a configuração do *Spring Boot*, mas nada impede de ser utilizado o **application.properties**, é que eu acho que o formato é conveniente para especificar dados de configuração, deste modo hierárquico, que lembra muito um JSON, que facilita a leitura.
```yml
// NOME DO PROJETO
spring:
  application:
    name: accesscontrol

// CAMINHO DA URI PARA ENCONTRAR O CONSOLE DO BANCO DE DADOS (localhost:8080/access-control/h2)
  h2:
    console:
      enabled: true
      path: /h2
// O CAMINHO DO ESCOPO DO BANCO DE DADOS (JDBC URL), DRIVER UTILIZADO E CREDENCIAS DE ACESSO
  datasource:
    url: jdbc:h2:mem:testdb
    username: sa
    password:
    driver-class-name: org.h2.Driver

// ESPECIFICA PARA O HIBERNATE GERENCIE AS ATUALIZAÇÕES DAS ENTIDADE E QUE APRESENTE OS SQL QUE SÃO GERADOS AO PROCESSA-LAS
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

// A PORTA A SER UTILIZADA PELO TOMCAT - E O CAMINHO PARA ENCONTRAR O PROJETO (localhost:8080/access-control)
server:
  port: 8080
  servlet:
    context-path: /access-control
```

## Como Auditar uma Entidade


## Como Está Documentado o Projeto
O framework ``Swagger UI`` auxilia na criação da documentação do projeto, por possuir uma variedade de ferramentas que permite modelar a descrição, consumo e visualização de serviços da API REST. No projeto foi incluída suas dependências (Swagger-UI, Swagger-Core) para habilitá-lo para uso na aplicação, desta forma, no *snippet* abaixo é apresentado o Bean principal para sua configuração, presente na classe SwaggerConfig.

```java
@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(apis()) // RequestHandlerSelectors.any()
                .paths(PathSelectors.any())
                .build()
                .apiInfo(constructorApiInfo())
                .globalOperationParameters(
                        Collections.singletonList(
                                new ParameterBuilder()
                                    .name("Authorization")
                                    .description("Header to Token JWT")
                                    .modelRef(new ModelRef("string"))
                                    .parameterType("header")
                                    .required(false)
                                    .build()
                        )
                );
    }
```

A especificação da API consiste na determinação de parâmetros de identificação e os modelos de dados que serão aplicados pela API, além de suas funcionalidades. Entretanto, o Swagger por padrão lista todos os endpoints retornando os códigos 200, 201, 204,401,403 e 404, mas é possível especificar quais são os códigos do protocolo HTTP que sua aplicação utiliza ao utilizar a anotação @ApiResponses.

![Framework Project - Access-Control](https://github.com/willdkdevj/assets/blob/main/Spring/access-control/swagger-doc.png)

O método apis() permite utilizar a classe **RequestHandlerSelectors** para filtrar qual é o pacote base (*basePackage*) a fim de ser listado apenas os seus endpoints. Já o método apiInfo() possibilita inserir parâmetros para descrever dados de informação sobre a aplicação e seu desenvolvedor. Desta forma, o framework Swagger possibilita documentar a API REST de um modo ágil de eficiente as suas funcionalidades. Sua exposição é feita através do link <http://localhost:8080/acces-control/swagger-ui.html>

## Como Executar o Projeto

```bash
# Para clonar o repositório do projeto, através do terminal digite o comando abaixo
git clone https://github.com/willdkdevj/ACCESS_CONTROL_RESTAPI_SPRING.git
# Para acessar o diretório do projeto digite o comando a seguir
cd /ACCESS_CONTROL_RESTAPI_SPRING

# Executar projeto via terminal, digite o seguinte comando
./mvnw spring-boot:run

# Para Executar a suíte de testes desenvolvidas, basta executar o seguinte comando
./mvnw clean test
```

Para testar a API, como a aplicação consome e produz JSON, é necessário utilizar uma ferramenta que permite realizar requisições HTTP neste formato, como o Postman, Insomnia, entre outras. Na diretório ``JSON-TEST-HTTP/``  há um arquivo que pode ser importado a qualquer uma destas ferramentas, onde já estarão formatados os tipos de requisições suportadas pela API para a realização dos testes.

## Agradecimentos
Obrigado por ter acompanhado aos meus esforços para desenvolver este Projeto utilizando a estrutura do Spring para criação de uma API REST 100% funcional, utilizando os recursos do Spring data JPA e o Hibernate Envers para realizar a auditoria dos dados registrados em um banco de dados relacional. Espero que este projeto o auxilie a construir uma API que atenda as suas necessidades! :octocat:

Como diria um velho mestre:
> *"Cedo ou tarde, você vai aprender, assim como eu aprendi, que existe uma diferença entre CONHECER o caminho e TRILHAR o caminho."*
>
> *Morpheus - The Matrix*