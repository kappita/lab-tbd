<script setup>
  import axios from 'axios';
  import { ref } from 'vue';

  const usertype = ref(0)
  const email = ref("")
  const password = ref("")

  const sendForm = () => {
    if (usertype.value === 0) {
      window.alert("Debe escoger un tipo de usuario")
      return
    }

    if (email.value === "") {
      window.alert("Debe ingresar un correo electronico")
      return
    }

    if (password.value === "") {
      window.alert("Debe ingresar una contraseña")
      return
    }




    const body = {
      email: email.value,
      password: password.value
    }
    if (usertype.value === 1) {
      axios.post("http://localhost:8080/voluntario/login", body).then(e=> console.log(e.data))
    }
    if (usertype.value === 2) {
      axios.post("http://localhost:8080/institucion/login", body).then(e => console.log(e.data))
    }
  }

</script>


<template>
  <main>
    <div class="content">
      <h1>
        Inicia sesion en PoneleVoluntapp
      </h1>
  
      <div class="form">
        <input placeholder="Correo electrónico. Ej: rene@outlook.my" type="text" name="email" id="" v-model="email">
        <input placeholder="Contraseña" type="text" name="password" id="" v-model="password">
        <select class="tipo-user" v-model="usertype" >
          <option disabled value="" selected >Selecciona el tipo de usuario</option>
          <option :value="1">Voluntario</option>
          <option :value="2">Institución</option>
        </select>
        <button @click="sendForm()">
          Registrarse
        </button>
      </div>
    </div>

  </main>


</template>

<style scoped> 

main {
  display: flex;
  height: 100vh;
  width: 100vw;
  align-items: center;
  justify-content: center;

}

.content {
  width: 25%;
  height: 40%;
}

.form {
  height: 100%;
  width: 100%;
  display: flex;
  flex-direction: column;
}

input {
  margin-bottom: 10px;
}

select {
  margin-bottom: 10px;
}
</style>