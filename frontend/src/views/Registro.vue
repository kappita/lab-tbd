<script setup>
import axios from 'axios';
import { ref } from 'vue';

  const usertype = ref(0)
  const name = ref("")
  const email = ref("")
  const password = ref("")

  const sendForm = () => {
    if (usertype.value === 0) {
      window.alert("Información inválida")
      return
    }
    const body = {
      nombre: name.value,
      email: email.value,
      password: password.value
    }
    if (usertype.value === 1) {
      axios.post("localhost:8080/voluntario/registro", body)
    }
    if (usertype.value === 2) {
      axios.post("localhost:8080/institucion/registro", body)
    }
  }

</script>

<template>
  <main>
    <div class="title">
      <h1>
        Bienvenido a la aplicación de Voluntariados de Emegencia
      </h1>
      <h2>
        ¡Regístrate aquí!
      </h2>
    </div>

    <div class="form">
      <input placeholder="Nombre. Ej: René Cáceres" type="text" name="name" id="" v-model="name">
      <input placeholder="Correo electrónico. Ej: rene@outlook.my" type="text" name="email" id="" v-model="email">
      <input placeholder="Contraseña" type="text" name="password" id="" v-model="password">
      <select placeholder="Tipo de usuario" class="tipo-user" v-model="usertype" >
        <option disabled value="">Selecciona el tipo de usuario</option>
        <option :value="1">Voluntario</option>
        <option :value="2">Institución</option>
      </select>
      <button @click="sendForm()">
        Registrarse
      </button>
    </div>
  </main>


</template>



<style scoped>
template {
  width: 100vw;
  height: 100vh;
}

</style>