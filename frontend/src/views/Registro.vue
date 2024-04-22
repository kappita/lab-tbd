<script setup>
import axios from 'axios';
import { ref } from 'vue';


const usertype = ref(0)
const name = ref("")
const email = ref("")
const password = ref("")
const rut = ref("")
const exito = ref(false)
const mensajeExito = "Usuario registrado exitosamente"

const sendForm = () => {
    if (usertype.value === 0) {
      window.alert("Información inválida")
      return
    }

    if (rut.email === "") {
        window.alert("Debes ingresar un email")
        return
    }
    if (password.value === "") {
        window.alert("Debes ingresar una contraseña")
        return
      }

    if (name.value === "") {
      window.alert("Debes ingresar un nombre para la institucion")
      return
    }
    
    if (usertype.value === 1) {
      if (rut.value === "") {
        window.alert("Debes ingresar un rut")
        return
      }

      const body = {
      rut: rut.value,
      nombre: name.value,
      email: email.value,
      password: password.value
      }
      axios.post("http://localhost:8080/voluntarios/save", body).then(e => exito.value = true)
      return
    }


    if (usertype.value === 2) {
      const body = {
      nombre: name.value,
      email: email.value,
      password: password.value
      }
      axios.post("http://localhost:8080/instituciones/save", body).then(e => exito.value = true)
    }
}

</script>

<template>

<main>
    <div class="title">
    <img src="@/assets/logo.png" alt="PoneleVoluntAPP Logo" class="logo" />
      <h1>
        Bienvenido a la aplicación de Voluntariados de Emegencia
      </h1>
      <h2>
        ¡Regístrate aquí!
      </h2>
    </div>

    <div class="form">
      <select placeholder="Tipo de usuario" class="tipo-user" v-model="usertype" >
        <option disabled value="">Selecciona el tipo de usuario</option>
        <option :value="1">Voluntario</option>
        <option :value="2">Institución</option>
      </select>
      <input v-if="usertype === 1" placeholder="Rut" type="text" name="rut" v-model="rut">
      <input placeholder="Nombre. Ej: René Cáceres" type="text" name="name" id="" v-model="name">
      <input placeholder="Correo electrónico. Ej: rene@outlook.my" type="text" name="email" id="" v-model="email">
      <input placeholder="Contraseña" type="text" name="password" id="" v-model="password">
      <button @click="sendForm()">
        Registrarse
      </button>
    </div>

    <div v-if="exito" class="mensaje-exito">
    {{ mensajeExito }}
    </div>
  </main>

</template>

<style scoped>
.mensaje-exito {
  color: green;
  background-color: #e8f5e9;
  border-left: 5px solid #4caf50;
  padding: 10px;
  margin: 10px 0;
}

.logo {
  display: block;
  margin: 0 auto;
  max-width: 100px;
  height: auto;
}
</style>


