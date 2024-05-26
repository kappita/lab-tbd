<script setup>
import { ref } from 'vue';
import axios from 'axios';
import Navbar from '@/components/Navbar.vue';
import Emergency from '@/components/Emergency.vue';
import { userJwt } from '@/store/store';

const email = ref("");
const emergencies = ref([]);
const exito = ref("");

axios.get(`http://localhost:8080/emergencias_habilidad/getEmergencias`).then(e => {
  emergencies.value = e.data;
});

const agregar = (id_emergencia) => {
  const body = {
    token: userJwt.value,
    id_emergencia: id_emergencia
  }
  console.log(body)
  axios.post(`http://localhost:8080/agregar_voluntario_disponible`, body).then(e => {
    console.log(e.data);
    exito.value = e.data;
  });
};
</script>

<template>
  <div>
    <Navbar />
    <div class="emergencies-main">
      <div class="emergencies-content">
        <header>
          <h1>Listado de emergencias activas</h1>
          <h2>Inscríbete como disponible para ayudar</h2>
        </header>

        <div class="emergency-section">
          <div class="emergencies">
            <Emergency v-for="e in emergencies" :key="e.id" :data="e" @sign-in="n => agregar(n)"></Emergency>
          </div>
        </div>

        <div v-if="exito" class="mensaje-exito">
          {{ exito }}
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300;400&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Lato:wght@300;400&display=swap');

.emergencies-main {
  background-color: #f0f9ff;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 20px;
  min-height: 100vh;
}

.emergencies-content {
  background: white;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  width: 80%;
  max-width: 800px;
}

header {
  text-align: center;
  margin-bottom: 20px;
}

h1, h2 {
  color: #101935;
  font-family: 'Roboto', sans-serif;
}

.user-input {
  margin-bottom: 20px;
}

.user-input input {
  width: 100%;
  padding: 10px;
  margin-top: 10px;
  border-radius: 5px;
  border: 1px solid #cccccc;
}

.user-input input:focus {
  outline: none;
  border-color: #9ad4d6;
}

.emergencies {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.mensaje-exito {
  color: green;
  background-color: #e8f5e9;
  border-left: 5px solid #4caf50;
  padding: 10px;
  margin-top: 20px;
  text-align: center;
}
</style>
