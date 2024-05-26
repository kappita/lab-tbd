<script setup>
  const { data } = defineProps(["data"])
  const emit = defineEmits(["sign-in"])
</script>

<template>
  <div class="card">
    <div class="emergency">
      Nombre: {{ data.nombre_emergencia }}
    </div>
    <div class="skills">
      <p>Habilidades:</p>
      <p> - {{ data.nombre_habilidad }}</p>
    </div>
    <button @click="$emit('sign-in', data.id_emergencia)">
      +
    </button>
  </div>


</template>

<style scoped>
  .card {
    height: 100%;
    width: 100%;
    display: grid;
    grid-template-rows: repeat(1, minmax(0, 1fr));
    grid-template-columns: repeat(3, minmax(0, 1fr));
  }

  .emergency {
    margin-right: 20px;
  }

  p {
    color: black;
  }

  div {
    color: black;
  }
</style>