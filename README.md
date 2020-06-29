# pamcary_aluno

 A **API (micro serviço) Aluno** em Spring Boot, utiliza start.spring.io, que fornecerá algum código de bootstrap (classe principal e arquivos pom.xml). 
  Precisamos dos pacotes Web, JPA, Lombok e H2.
  
**Estrutura do projeto em pacotes:**
   model, repository, service, controller e handler.
   
 **A API Aluno deverá ter a seguinte configuração:**
    a. Rodar na porta: 8000
    b. Contexto: /aluno
    c. Utilizar jpa/hibernate
    d. Utilizar H2 em memória, habilitando o console
    
 **Handler para capturar os erros gerados** 
    (ex: 409 – Conflict para dados obrigatórios e não encontrados)
    
**Modelo (entidade JPA):**
    Aluno com os seguintes atributos: id,nome,idade.
    
 **Serviço de Aluno com os seguintes itens:**
  * Recuperar todos os alunos
  *  Recuperar um aluno por id
  *  Criar um novo aluno validando os campos nome e idade com o BeanValidation.
  *  Atualizar um aluno (verificando se o mesmo existe)
  *  Remover um aluno
