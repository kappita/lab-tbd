<script setup>
  const { data } = defineProps(["data"])
  const emit = defineEmits(["sign-in"])
</script>

<template>
  <div class="card">
    <div class="emergency">
      Nombre: {{ data.emergency_name }}
    </div>
    <div class="skills">
      <p>Habilidades:</p>
      <p v-for="skill in data.skills"> - {{ skill }}</p>
    </div>
    <button @click="$emit('sign-in', data.emergency_id)">
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
</style>