<template>
  <Navbar />
  <div class="register-main">
    <div class="register-content">
      <h2>¡Regístrate aquí!</h2>
      <div class="register-form">
        <select v-model="usertype">
          <option disabled value="">Selecciona el tipo de usuario</option>
          <option value="1">Voluntario</option>
          <option value="2">Institución</option>
        </select>
        <input v-if="usertype === '1'" placeholder="RUT" type="text" v-model="rut">
        <input :placeholder="namePlaceholder" type="text" v-model="name">
        <input :placeholder="emailPlaceholder" type="email" v-model="email">
        <input placeholder="Contraseña" type="password" v-model="password">
        <button @click="sendForm">Registrarse</button>
      </div>
      <div v-if="exito" class="mensaje-exito">
        {{ mensajeExito }}
      </div>
    </div>
  </div>
</template>

<script setup>
import Navbar from '@/components/Navbar.vue';
import axios from 'axios';
import { ref, computed } from 'vue';

const usertype = ref('');
const name = ref("");
const email = ref("");
const password = ref("");
const rut = ref("");
const exito = ref(false);
const mensajeExito = "Usuario registrado exitosamente";

const namePlaceholder = computed(() => {
  return usertype.value === '1' ? "Nombre completo. Ej: Matías Calderón" : "Nombre de la institución. Ej: Coordinadora Social Shishigang";
});

const emailPlaceholder = computed(() => {
  return usertype.value === '1' ? "Correo electrónico. Ej: matias.calderon@outlook.my" : "Correo electrónico. Ej: coordinadora@volunteers.my";
});

const sendForm = () => {
    if (!usertype.value) {
        window.alert("Por favor, selecciona un tipo de usuario.");
        return;
    }
    
    if (!email.value) {
        window.alert("Debes ingresar un email");
        return;
    }

    if (!password.value) {
        window.alert("Debes ingresar una contraseña");
        return;
    }

    if (!name.value) {
        window.alert("Debes ingresar un nombre");
        return;
    }

    let body = {
        nombre: name.value,
        email: email.value,
        password: password.value,
        rut: rut.value
    };

    if (usertype.value === '1') { // Voluntario
        if (!rut.value) {
            window.alert("Debes ingresar un RUT para el tipo Voluntario.");
            return;
        }
        axios.post("http://localhost:8080/voluntarios/save", body).then(response => {
            exito.value = true;
            console.log(response.data);
        }).catch(error => console.error('Error:', error));
    } else if (usertype.value === '2') { // Institución
        axios.post("http://localhost:8080/instituciones/save", body).then(response => {
            exito.value = true;
            console.log(response.data);
        }).catch(error => console.error('Error:', error));
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

.register-main {
  background-image: linear-gradient(to bottom right, #f0f9ff, #cbebff);
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100vh;
  text-align: center;
}

.register-content {
  background: white;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0,0,0,0.1);
  width: 350px;
  animation: fadeIn 1s ease-in-out;
}

.register-form {
  display: flex;
  flex-direction: column;
}

h1, h2 {
  color: #101935;
}

input, select, button {
  padding: 8px 10px; 
  margin-bottom: 10px;
  border-radius: 5px;
  border: 1px solid #cccccc;
  width: 100%;
  box-sizing: border-box;
  font-size: 0.9rem;
}

input[type="email"], input[type="text"], input[type="password"], select {
  background-color: #f0f9ff;
  color: #000; 
}

input::placeholder, select::placeholder {
  color: #888; 
}

input:hover, select:hover, input:focus, select:focus {
  background-color: #e6f7ff; 
  outline: none;
}

button {
  background-color: #9ad4d6;
  color: #101935;
  padding: 12px 24px;
  border-radius: 10px;
  font-size: 1.2rem;
  text-decoration: none;
  transition: background-color 0.3s, transform 0.2s;
  cursor: pointer;
}

button:hover {
  background-color: #564787;
  color: #f2fdff;
  transform: translateY(-2px);
}

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

