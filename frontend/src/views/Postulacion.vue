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
        <h2>¡Visualiza las tareas en las que puedas ayudar con tus habilidades!</h2>

        <div class="habilidades">
          <h2>Tus habilidades son:</h2>
          <div class="habilidad-container">
            <div v-for="habilidad in habilidades" :key="habilidad.id" class="habilidad">{{ habilidad.nombre }}</div>
          </div>
        </div>

        <div class="tareas">
          <h2>Tareas disponibles:</h2>
          <div class="tarea-container">
            <div v-for="tarea in tareas" :key="tarea.id" class="tarea-card">
              <div class="tarea-info">
                <div class="tarea-main">
                  <h3>{{ tarea.nombreTarea }}</h3>
                  <p><strong class="subtitulo">Nombre emergencia:</strong> {{ tarea.nombreEmergencia }}</p>
                  <p><strong class="subtitulo">Habilidades:</strong> {{ tarea.habilidades.join(', ') }}</p>
                </div>
                <div class="tarea-ids">
                  <p><strong class="subtitulo">Id emergencia:</strong> {{ tarea.idEmergencia }}</p>
                  <p><strong class="subtitulo">Id tarea:</strong> {{ tarea.idTarea }}</p>
                </div>
              </div>
            </div>
          </div>
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

.applications-main {
  background-color: #f0f9ff;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 20px;
  min-height: calc(100vh - 80px);
  padding-top: 80px;
}

.applications-content {
  background: white;
  padding: 30px;
  border-radius: 15px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
  width: 90%;
  max-width: 900px;
}

h1, h2 {
  color: #101935;
  font-family: 'Roboto', sans-serif;
  text-align: center;
  margin-bottom: 20px;
}

h1 {
  font-weight: bold;
}

h3 {
  color: #101935;
  font-family: 'Roboto', sans-serif;
  font-size: 1.5rem;
  margin-bottom: 10px;
  font-weight: bold;
}

.habilidades, .tareas {
  margin-top: 30px;
}

.habilidad-container, .tarea-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 10px;
}

.habilidad {
  background-color: #9ad4d6;
  color: #101935;
  padding: 10px 15px;
  margin: 5px;
  border-radius: 15px;
  font-family: 'Lato', sans-serif;
  font-size: 1rem;
  font-weight: bold;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

.tarea-container {
  margin-top: 20px;
  width: 100%;
}

.tarea-card {
  background-color: #fff;
  padding: 20px;
  margin: 10px;
  border-radius: 10px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  width: 100%;
  transition: transform 0.2s;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.tarea-card:hover {
  transform: translateY(-3px);
}

.tarea-info {
  display: grid;
  grid-template-columns: 1fr auto;
  gap: 20px;
  width: 100%;
}

.tarea-main {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.tarea-ids {
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  gap: 5px;
}

.tarea-card h3, .tarea-card .habilidades {
  font-size: 1.2rem;
  color: #101935;
}

.tarea-card p {
  margin: 5px 0;
  font-family: 'Lato', sans-serif;
  color: #333;
}

.subtitulo {
  font-weight: bold;
  font-size: 1rem;
}
</style>
