# DesafioZetta_CadatroUsuarios
**Desafio técnico**

## Descrição

### BACK-END
APIREST construída utilizando Swagger e Spring Boot. <br>
Banco de dados utilizado foi Postgresql. <br>
Segue o link da API:  https://apirest-cadastrousuarios.herokuapp.com/swagger-ui.html

### FRONT-END
Framework utilizado para o front-end foi o Vue.Js. <br>
Para a estilização foi utilizado o materialize. <br>

## Inicialização
**BACKEND**<br> 

Importar a pasta backend como um projeto maven existente na IDE. <br>

**Foi gerado um banco de dados local na minha máquina então caso o banco não for gerado crie um database manual no postgresql usando o comando CREATE DATABASE tb_usuario**<br>
Após ter criado o database abra o aplication.properties em src/main/resource e mude o password e caso for preciso mude também a url e o username de acordo com o seu banco postgresql local. 

Após isso em  src/main/java no package com.usuarios.apirest iniciar Apirest.Aplication.java como uma aplicação java. Com isso ela irá subir para o localhost:8080.<br>
Feito isso a API já foi inicializada.

**FRONTEND**<br>

Abrir o terminal ir até a pasta frontend e inserir o seguinte comando: npm run serve.<br>
**Lembrando que deverá ter o Vue CLI e Node.Js instalados na maquina**<br>
Apos ter colocado o comando para iniciar o server ele ira disponibilizar o localhost no terminal, apenas copie a URL e coloque no navegador.
Se tudo der certo a aplicação foi iniciada.

## Uso da aplicação
**Campo Nome**: Deve informar o nome do usuário<br>
**Campo Cpf**: Informar o cpf do usuário com os pontos e traço para uma melhor visualização<br>
**Campo Data de Nascimento**: Colocar a data de nascimento do usuário<br>
**Campo Sexo**: Selecionar o sexo do usuário<br>
**Campo Data de Cadastro**: Informar a data que esta sendo cadastrado (não foi possível colocar preenchimento automático)<br>
**Campo Cargo**: Informe o cargo do funcionário<br>
Clicando em cadastrar o usuário é enviado ao banco de dados e é mostrado abaixo.<br>
Os botões presentes na tabela de usuários servem para editar assim os dados do usuário será retornado no formulário acima permitindo a edição, clicando em salvar para finalizar a alteração e o outro botão serve para excluir, quando clicado um alert sera mostrado pedindo a confirmação da exclusão.
