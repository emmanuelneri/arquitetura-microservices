#Arquitetura
![alt tag](https://github.com/emmanuelneri/arquitetura-microservices/blob/master/arquitetura-microservices.png)

#Requisitos
- Postgres 9.3+
- Wildfly 8.0.2.Final
- Java 8

# Configurando Projeto
1 - Adicionar módulo Postgres no Wildfly
  - Adicionar jar do Posgres em  modules/system/layers/base/org/postgresql
  - Configurar driver no standalone/configuration/standalone.xml
  
  ```
  <datasources>
    <driver name="postgresql" module="org.postgresql">
      <xa-datasource-class>org.postgresql.Driver</xa-datasource-class>
    </driver>
 </datasources>
 ```

2 - Configurar DataSource no Wildfly
  - Adicionar nova configuração de datasource
  
  ```
  <datasources>
     <datasource jta="true" jndi-name="java:jboss/datasources/PortalDS" pool-name="PortalDS" enabled="true" use-java-context="true" use-ccm="true">
      <connection-url>jdbc:postgresql://localhost:5432/portal</connection-url>
      <driver>postgresql</driver>
      <security>
        <user-name>postgres</user-name>
        <password>postgres</password>
      </security>
    </datasource>
 </datasources>
 ```
 Obs: O Datasource está configurado para acessar a porta padrão do Postgres e como usuário e senha "postgres"
 Obs: será necessário criar um datasource para cadas aplicação, PortalDS, CadastrosDS, VendasDS e RelatoriosDS
 
3 - Criar o Banco
  - Criar os bancos, no postgres, "portal", "cadastros", "venda", "relatorios"
   
4 - Configurar na IDE para fazer deploy de todos módulos, ex: Portal, Cadastros, Vendas e Relatorios 
  
# Utilizando Aplicação

1 - Acessar o Portal
- http://localhost:8080/portal/login.xhtml

2 - Logar no sistema
  - email: teste@gmail.com
  - senha: 123
  
# Aplicações (Modulo)
  Para cada aplicação será um subprojeto no projeto arquitetura-microservices
  
  1 - portal: É a aplicação central, onde terá as funcionalidades que são comuns entre todas aplicações

  2 - cadastros: É a aplicação responsável por todos cadastros

  3 - vendas: É a aplicação responsável por realizar os pedidos
  
  4 - relatorios: É a aplicação responsável por emitir os relatórios referente aos dados de cadastros e pedidos
  
# Branchs
  - microservices-replicacao-base: Arquitetura de microserviços replicando os dados entre os modúlos via serviços Rest, dessa forma cada aplicação possui os dados que precisa em sua própria base.
  
  - microservices-sem-replicacao-base: Arquitetura de microserços sem replicação dados, dessa forma quando uma aplicação precisa de algum dado de outra aplicação acessa um serviço Rest
  
  
  


  
