<script setup>
import { ref } from 'vue';
import axios from 'axios';
import Navbar from '@/components/Navbar.vue';
import Tarea from '@/components/Tarea.vue';
import { userJwt } from '@/store/store';

const habilidades = ref([]);
const tareas = ref([]);

const buscar = () => {
  const body = {
    token: userJwt.value
  }

  axios.post(`http://localhost:8080/tareas/postulables`, body).then(e => {
    tareas.value = e.data;
  }).catch(e => {
    console.log(e);
    window.alert("El correo electrónico no existe");
  });
  axios.post(`http://localhost:8080/voluntarios/habilidades`, body).then(e => {
    habilidades.value = e.data;
  }).catch(e => {
    console.log(e);
  });

};

buscar();
</script>

<template>
  <div>
    <Navbar />
    <div class="applications-main">
      <div class="applications-content">
        <h1>Postulación a tareas</h1>
        <h2>Ve las tareas en las que puedas ayudar con tus habilidades!</h2>

        <div class="habilidades">
          <h2>Tus habilidades son:</h2>
          <div class="habilidad-container">
            <div v-for="habilidad in habilidades" :key="habilidad.id" class="habilidad">{{ habilidad.nombre }}</div>
          </div>
        </div>

        <div class="tareas">
          <h1>Tareas disponibles</h1>
          <div class="tarea-container">
            <Tarea v-for="tarea in tareas" :key="tarea.id" :data="tarea"></Tarea>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300;400&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Lato:wght@300;400&display=swap');

.applications-main {
  background-color: #f0f9ff;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 20px;
  min-height: 100vh;
}

.applications-content {
  background: white;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  width: 80%;
  max-width: 800px;
}

h1, h2 {
  color: #101935;
  font-family: 'Roboto', sans-serif;
  text-align: center;
  margin-bottom: 20px;
}

.buscador, .habilidades, .tareas {
  margin-top: 20px;
}

.buscador input {
  padding: 10px;
  margin-right: 10px;
  border-radius: 5px;
  border: 1px solid #cccccc;
  width: calc(100% - 80px); /* Adjust width to account for button */
}

.buscador .btn-search {
  padding: 10px 20px;
  background-color: #9ad4d6;
  color: #101935;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s, transform 0.2s;
}

.buscador .btn-search:hover {
  background-color: #564787;
  color: #f2fdff;
  transform: translateY(-2px);
}

.habilidad-container, .tarea-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.habilidad {
  background-color: #9ad4d6;
  color: #101935;
  padding: 10px;
  margin: 5px;
  border-radius: 5px;
  font-family: 'Lato', sans-serif;
}

.tarea-container {
  margin-top: 20px;
}

.tarea-container > div {
  width: 100%;
  margin-bottom: 10px;
}
</style>
