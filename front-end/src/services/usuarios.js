import { http } from './config.js'

export default{
   listar:() => {
      return http.get('usuarios')
   },

   salvar:(usuario) =>{
      return http.post('usuario', usuario)
   },

   atualizar:(usuario) => {
      return http.put('usuario', usuario)
   }
}