# Desafio back-end

  Simples API Rest com Spring Boot, MapStruct, Validations 2.0, Hibernate, Swagger, Gradle , Teste Unitário, Teste de Integração, Liquibase, PostgreSQL e principios de programação oriendata a desingn.

## Iniciando a aplicação

  É necessário ter um banco de dados PostgreSQL instalada na maquina local ou servidor e configurar as propriedades no projeto localizado em: "src/main/resorces/application.properties" por padrão segue as configurações abaixo:
   
   URL: "jdbc:postgresql://localhost:5432/backend"
   USERNAME: "postgres"
   PASSWORD: "postgres"   
  
  Compilar o projeto usando o comando "gradle build" e na sequência executar a aplicação com o comando "gradle run".
  
  Não é necessario aplicar quaisquer script manualmente no banco, pois o liquibase se encarregara de executar esta tarefa.
  
  É possível verificar as especificações dos endpoints expostos através do swagger acessando: " http://localhost:8080/swagger-ui.html#/" exemplo:
 
  <img width="1280" alt="Captura de Tela 2019-11-05 às 19 09 36" src="https://user-images.githubusercontent.com/22947439/68250922-cdbdf600-0000-11ea-968c-4fe848e5af09.png">
  
 
 # Serviços 
 
Manufacturer 

TIPO: POST   URL:http://localhost:8080/manufacturer/

<img width="663" alt="Captura de Tela 2019-11-05 às 21 13 01" src="https://user-images.githubusercontent.com/22947439/68257129-fd74fa00-0010-11ea-8755-3767a5e4073b.png">

Product

TIPO: POST   URL:http://localhost:8080/product/

<img width="663" alt="Captura de Tela 2019-11-05 às 21 37 58" src="https://user-images.githubusercontent.com/22947439/68258118-7164d180-0014-11ea-8bcc-d5947ecb18c5.png">

Ordered

TIPO: POST   URL:http://localhost:8080/ordered/



#Testes Unitários e de Integração:


<img width="511" alt="Captura de Tela 2019-11-05 às 21 50 01" src="https://user-images.githubusercontent.com/22947439/68258667-32378000-0016-11ea-918e-dd2b81e52ef5.png">

