<script setup>
  const { data } = defineProps(["data"])

</script>


<template>
  <div class="tarea">
    <p>Id emergencia: {{ data.idEmergencia }} </p>
    <p>Nombre emergencia: {{ data.nombreEmergencia }} </p>
    <p>Id tarea: {{ data.idTarea }} </p>
    <p>Nombre tarea: {{ data.nombreTarea }} </p>
    <p>Habilidades: </p>
    <div class="habilidades">
      <p class="habilidad" v-for="habilidad in data.habilidades">-{{ habilidad }}</p>
    </div>
  </div>

</template>


<style scoped>
  .tarea {
    display: flex;
  }

  .habilidades {
    display: grid;
    grid-template-columns: repeat(1, minmax(0, 1fr));
  }

  p {
    padding: 5px;
  }

  .habilidad {
    width: 100%;
  }

  p {
    color: black;
  }

</style>