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

body, html {
  margin: 0;
  padding: 0;
  height: 100%;
}

h1{
  font-weight: bold;
}

.emergencies-main {
  background-color: #f0f9ff;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 20px;
  min-height: calc(100vh - 80px);
  padding-top: 80px;
}

.emergencies-content {
  background: white;
  padding: 30px;
  border-radius: 15px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
  width: 90%;
  max-width: 1200px;
}

header {
  text-align: center;
  margin-bottom: 20px;
}

h1, h2 {
  color: #101935;
  font-family: 'Roboto', sans-serif;
  text-align: center;
  margin-bottom: 20px;
}

.emergency-section {
  display: flex;
  justify-content: center;
}

.emergencies {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 20px;
}

.mensaje-exito {
  color: green;
  background-color: #e8f5e9;
  border-left: 5px solid #564787;
  padding: 10px;
  margin-top: 20px;
  text-align: center;
}
</style>
