# arquitetura-multi-modulos-Portal

Requisitos
- Postgres 9.3+
- JBoss 7.1.1.Final
- Java 7 


1 - Adicionar módulo Postgres no JBoss
  - Adicionar jar do Posgres em  modules/org/postgresql
  - Configurar módulo no standalone/configuration/standalone.xml
  
  ```
  <datasources>
    <driver name="postgresql" module="org.postgresql">
      <xa-datasource-class>org.postgresql.Driver</xa-datasource-class>
    </driver>
 </datasources>
 ```

2 - Configurar DataSource no JBoss
  - Adicionar nova configuração de datasource
  
  ```
  <datasources>
     <datasource jta="true" jndi-name="java:jboss/datasources/PortalDS" pool-name="PortalDS" enabled="true" use-java-context="true" use-ccm="true">
      <connection-url>jdbc:postgresql://localhost:5432/portal</connection-url>
      <driver>postgresql</driver>
      <transaction-isolation>TRANSACTION_READ_COMMITTED</transaction-isolation>
      <pool>
        <min-pool-size>5</min-pool-size>
        <max-pool-size>30</max-pool-size>
        <prefill>true</prefill>
        <use-strict-min>false</use-strict-min>
        <flush-strategy>FailingConnectionOnly</flush-strategy>
      </pool>
      <security>
        <user-name>postgres</user-name>
        <password>postgres</password>
      </security>
      <statement>
        <prepared-statement-cache-size>32</prepared-statement-cache-size>
      </statement>
    </datasource>
 </datasources>
 ```
 Obs: O Datasource está configurado para acessar a porta padrão do Postgres e como usuário e senha "postgres"
 
3 - Criar o Banco
  - Criar um banco no postgres chamado "portal"
