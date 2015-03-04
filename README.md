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
 
3 - Criar o Banco
  - Criar um banco no postgres chamado "portal"
  
# Utilizando Aplicação

1 - Logar no sistema
- email: teste@gmail.com
- senha: 123

2 - Configurar Portal
  - Inserir nome do projeto
  - Selecionar Aplicações(Modulos) que estará disponível no menu
  
# Aplicações (Modulo)
  Para cada aplicação configurado no Portal será criado um novo projeto

  - Subir o projeto https://github.com/emmanuelneri/arquitetura-multi-modulos-Vendas
  
Obs: A configuração padrão do módulo de vendas está para acessar na porta 8080.
  
