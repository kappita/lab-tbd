<script setup>
  import Emergency from '@/components/Emergency.vue';
  import axios from 'axios';
  import { ref } from 'vue';
  const email = ref("")
  const emergencies = ref([])
  const exito = ref("")
  axios.get(`http://localhost:8080/emergencias_habilidad/getEmergencias`).then( e=> {
    emergencies.value = e.data
  })


  const agregar = (id_emergencia) => {
    axios.post(`http://localhost:8080/agregar_voluntario_disponible/${id_emergencia}/${email.value}`).then( e=> {
      console.log(e.data)
      exito.value = e.data
  })
  }

  
  
</script>

<template>
  <main>
    <header>
      <h1>
        Listado de emergencias activas
      </h1>
      <h2>
        Inscríbete como disponible para ayudar
      </h2>
    </header>

    <div class="emergency-section">
      <div class="user-input">
        <h2>
          Ingresa tu correo electrónico para inscribirte en emergencias:
        </h2>
        <input placeholder="Correo electrónico. Ej: rene@outlook.my" type="text" name="email" v-model="email">
      </div>

      <div class="emergencies">
        <Emergency v-for="e in emergencies" :data="e" @sign-in="n => agregar(n)"></Emergency>
      </div>
    </div>

    <div v-if="exito" class="mensaje-exito">
        {{ exito }}
    </div>


  </main>

</template>


<style scoped>
main {
  width: 100vw;
  height: 100vh;
  padding-left: 10%;
  padding-right: 10%;
}

header {
  height: 20%;
  width: 100%;
}

.emergency-section {
  height: 80%;
  width: 100%;
}

.user-input {
  height: 20%;
  width: 100%;
}

.emergencies {
  display: grid;
  grid-template-columns: repeat(1, minmax(0, 1fr));
  width: 50%;
  height: 80%;
  overflow: scroll;
}
.mensaje-exito {
  color: green;
  background-color: #e8f5e9;
  border-left: 5px solid #4caf50;
  padding: 10px;
  margin: 10px 0;
}

</style>