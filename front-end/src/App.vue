<template>
  <div id="app">

    <nav>
      <div class="nav-wrapper blue darken-1">
        <a href="#" class="brand-logo center">Cadastro de Usuário</a>
      </div>
    </nav>

    <div class="container">

      <ul>
        <li v-for="(erro, index) of errors" :key="index">
          campo <b>{{ erro.field }}</b> - {{ erro.defaultMessage }}
        </li>
      </ul>


      <form @submit.prevent="salvar">

          <label>Nome</label>
          <input type="text" placeholder="Nome completo" v-model="usuario.nome">
          <label>CPF</label>
          <input type="text" placeholder="xxx.xxx.xxx-xx" v-model="usuario.cpf">
          <label>Data de Nascimento</label>
          <input type="date" v-model="usuario.dataNascimento">
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
          <input type="date" placeholder="xxx.xxx.xxx-xx" v-model="usuario.dataCadastro" />
          <label>Cargo</label>
          <input type="text" v-model="usuario.cargo">


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
              <button class="waves-effect btn-small blue darken-1"><i class="material-icons">create</i></button>
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
          nome: '',
          cpf: '',
          dataNascimento: '',
          sexo: '',
          dataCadastro: '',
          cargo: ''
        },
        usuarios: [],
        errors: []
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
        }).catch(e => {
          console.log(e.response.data.errors);
          this.errors = e.response.data.errors;
        })

      }
    }
  }
</script>

<style>

</style>
