<script setup>
import { ref, watch } from 'vue';
import Tarea from '@/components/Tarea.vue';
import axios from 'axios';

  const email = ref("")
  const habilidades = ref([])
  const tareas = ref([])

  const buscar = () => {
    console.log(email.value)
    axios.get(`http://localhost:8080/tareas/postulables/${email.value}`).then(e => {
      tareas.value = e.data
    }).catch(e => {
      console.log(e)
      window.alert("El correo electrónico no existe")
    })
    axios.get(`http://localhost:8080/habilidades/voluntario/${email.value}`).then(e => {
      habilidades.value = e.data
    }).catch(e => {
      
    })
  }


</script>

<template>
  <main>
    <header>
      <h1>
        Postulación a tareas
      </h1>

      <h2>
        Ve las tareas en las que puedas ayudar con tus habilidades!
      </h2>
    </header>

    <div class="postulaciones">
      <div class="buscador">
        <h2>
          Ingresa tu correo electrónico para buscar emergencias:
        </h2>
        <input placeholder="Correo electrónico. Ej: rene@outlook.my" type="text" name="email" id="" v-model="email">
        <button @click="buscar()">🔎</button>
      </div>

      <div class="habilidades">
        <h2>
          Tus habilidades son:
        </h2>
        <div class="habilidad-container">
          <div v-for="habilidad in habilidades" class="habilidad" > {{ habilidad.nombre }}</div>
        </div>
      </div>

      <div class="tareas">
        <h1>
          Tareas disponibles
        </h1>
        <div class="tarea-container">
          <Tarea v-for="tarea in tareas" :data="tarea"></Tarea>
        </div>
      </div>

    </div>

  </main>


</template>

<style scoped>

  .main {
    width: 100%;
    height: 100%;
  }

  .buscador {
    display: flex;
    width: 100%;
  }

  input {
    margin-left: 20px;
  }


  .habilidades {
    height: 25%;
    margin-top: 40px;
  }

  .habilidad-container {
    height: 80%;
    display: grid;
    margin-top: 40px;
  }
  .tareas {
    margin-top: 40px;
  }

  .tarea-container {
    display: grid;
    overflow: scroll;
    grid-template-columns: repeat(1, minmax(0, 1fr));
    height: 70%;
    width: 100%;
  }


</style>