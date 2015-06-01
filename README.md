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
 Obs: será necessário criar um datasource para cadas aplicação, ex: PortalDS, VendasDS
 
3 - Criar o Banco
  - Criar um banco no postgres chamado "portal"
  
# Utilizando Aplicação

1 - Acessar o Portal
- http://localhost:8080/portal/login.xhtml

2 - Logar no sistema
  - email: teste@gmail.com
  - senha: 123
  
# Aplicações (Modulo)
  Para cada aplicação será um subprojeto no projeto arquitetura-microservices
  
  1 - portal: É aplicação central, onde terá as funcionalidades que são comuns entre todas aplicações
    
    - acesso: http://localhost:8080/portal/login.xhtml
     
  2 - vendas: É aplicação responsável por realizar os pedidos
    
    - acesso: http://localhost:8080/vendas/auth/?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjaGF2ZUFwbGljYWNhbyI6IlNBQ1JTQzEyMzQiLCJub21lIjoiVXN1YXJpbyAxIiwiaWQiOjEsIm1vZHVsb3MiOlt7ImlkIjoyLCJub21lIjoiVmVuZGFzIiwiY2hhdmUiOiJTQUNSU0MxMjM0IiwidXJsIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL3ZlbmRhcy9hdXRoLyJ9XSwiZW1haWwiOiJ0ZXN0ZUBnbWFpbC5jb20ifQ.ZaJMB8B0BIUb-51f84zWdpxNbshJELZNf8twOrJJaDQ&

  
