<template>
  <div id="app">

    <nav>
      <div class="nav-wrapper blue darken-1">
        <a href="#" class="brand-logo center">Cadastro de Usuário</a>
      </div>
    </nav>

    <div class="container">


      <form @submit.prevent="salvar">

          <label>Nome</label>
          <input type="text" placeholder="Nome completo" v-model="usuario.nome" required>
          <label>CPF</label>
          <input type="text" placeholder="xxx.xxx.xxx-xx" v-model="usuario.cpf" required>
          <label>Data de Nascimento</label>
          <input type="date" v-model="usuario.dataNascimento" required>
          <label>Sexo</label>
          <p>
            <label>
              <input class="with-gap" type="radio" value="M" name="sexo" v-model="usuario.sexo" />
              <span>M</span>
            </label>
          </p>
          <p>
            <label>
              <input class="with-gap" type="radio" value="F" name="sexo" v-model="usuario.sexo" />
              <span>F</span>
            </label>
          </p>
          <label>Data de cadastro</label>
          <input type="date" placeholder="xxx.xxx.xxx-xx" v-model="usuario.dataCadastro" required/>
          <label>Cargo</label>
          <input type="text" v-model="usuario.cargo" required/>


          <button class="waves-effect waves-light btn-small">Salvar<i class="material-icons left">save</i></button>

      </form>

      <table>

        <thead>

          <tr>
            <th>NOME</th>
            <th>CPF</th>
            <th>DATA DE NASCIMENTO</th>
            <th>SEXO</th>
            <th>DATA DE CADASTRO</th>
            <th>CARGO</th>
            <th>EDITAR/DELETAR</th>

          </tr>

        </thead>

        <tbody>

          <tr v-for="usuario of usuarios" :key="usuario.id">

            <td>{{ usuario.nome }}</td>
            <td>{{ usuario.cpf }}</td>
            <td>{{ usuario.dataNascimento }}</td>
            <td>{{ usuario.sexo }}</td>
            <td>{{ usuario.dataCadastro }}</td>
            <td>{{ usuario.cargo }}</td>
            <td>
              <button @click="editar(usuario)" class="waves-effect btn-small blue darken-1"><i class="material-icons">create</i></button>
              <button class="waves-effect btn-small red darken-1"><i class="material-icons">delete_sweep</i></button>
            </td>

          </tr>

        </tbody>
      
      </table>

    </div>

  </div>
</template>

<script>

  //import Usuario from './service/usuarios'
  import Usuario from './services/usuarios.js'
  export default {
    
    data(){
      return {
        usuario: {
          id: '',
          nome: '',
          cpf: '',
          dataNascimento: '',
          sexo: '',
          dataCadastro: '',
          cargo: ''
        },
        usuarios: [],
      }
    },

    mounted(){
      this.listar()
    },

    methods:{

      listar(){
        Usuario.listar().then(res => {
          this.usuarios = res.data;
        })
      },

      salvar(){

        Usuario.salvar(this.usuario).then(res => {
          this.usuario = {}
          alert("Usuário salvo!")
          this.listar()
          res;
        })
      },

      atualizar(){
        Usuario.atualizar(this.usuario).then(res => {
            this.usuario = {}
            alert("Usuário atualizado!")
            this.listar()
            res;
        })
      },

      editar(usuario){
        this.usuario = usuario;
      }
    }
  }
</script>

<style>

</style>
