<template>
  <Navbar />
  <div class="login-main">
    <div class="login-content">
      <h1>Logeate en PóneleVoluntAPP</h1>
      <div class="login-form">
        <select v-model="usertype">
          <option disabled value="0" selected>Selecciona el tipo de usuario</option>
          <option value="1">Voluntario</option>
          <option value="2">Institución</option>
        </select>
        <input :placeholder="emailPlaceholder" type="email" v-model="email">
        <input placeholder="Contraseña" type="password" v-model="password">
        <button @click="sendForm()" class="btn-login">Iniciar sesión</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import Navbar from '@/components/Navbar.vue';
import axios from 'axios';
import { ref, computed } from 'vue';
import { useRouter } from 'vue-router';

const usertype = ref(0);
const email = ref("");
const password = ref("");
const router = useRouter();

const emailPlaceholder = computed(() => {
  if (usertype.value === '1') {
    return "matias.calderon@outlook.cl"; // Placeholder for Voluntario
  } else if (usertype.value === '2') {
    return "shishigang@coordinadora.cl"; // Placeholder for Institución
  }
  return "Correo electrónico"; // Default placeholder
});

const sendForm = () => {
  console.log("El pepe")
  if (usertype.value === 0) {
    window.alert("Debe escoger un tipo de usuario");
    return;
  }

  if (email.value === "") {
    window.alert("Debe ingresar un correo electrónico");
    return;
  }

  if (password.value === "") {
    window.alert("Debe ingresar una contraseña");
    return;
  }

  const body = {
    email: email.value,
    password: password.value
  };

  if (usertype.value == 1) {
    console.log("Voluntario")
    axios.post("http://localhost:8080/voluntarios/login", body).then(e => {
      console.log(e.data);
      router.push('/dashboard');
    });
  }
  if (usertype.value == 2) {
    axios.post("http://localhost:8080/instituciones/login", body).then(e => {
      console.log(e.data);
      router.push('/dashboard');
    });
  }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300;400&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Lato:wght@300;400&display=swap');

@keyframes fadeIn {
  0% {
    opacity: 0;
  }
  100% {
    opacity: 1;
  }
}


.login-main {
  background-image: linear-gradient(to bottom right, #f0f9ff, #cbebff);
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100vh;
  text-align: center;
}

.login-content {
  background: white;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0,0,0,0.1);
  width: 350px;
  animation: fadeIn 1s ease-in-out;
}

.login-form {
  display: flex;
  flex-direction: column;
}

h1 {
  color: #101935;
}

input, select, button {
  padding: 8px 10px; 
  margin-bottom: 10px;
  border-radius: 5px;
  border: 1px solid #cccccc;
  width: 100%; 
  font-size: 0.9rem; 
}

input[type="email"], input[type="password"], select {
  background-color: #f0f9ff;
  color: #000;
}

input:hover, select:hover, input:focus, select:focus {
  background-color: #e6f7ff;
  outline: none; 
}

.btn-login {
  background-color: #9ad4d6;
  color: #101935;
  padding: 12px 24px;
  border-radius: 10px;
  font-size: 1.2rem;
  text-decoration: none;
  transition: background-color 0.3s, transform 0.2s;
  cursor: pointer;
}

.btn-login:hover {
  background-color: #564787;
  color: #f2fdff;
  transform: translateY(-2px);
}
</style>
