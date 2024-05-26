<script setup>
const { data } = defineProps(["data"])
const emit = defineEmits(["sign-in"])
</script>

<template>
  <div class="card">
    <div class="card-content">
      <div class="emergency">
        <h3>{{ data.nombre_emergencia }}</h3>
      </div>
      <div class="skills">
        <p><strong class="subtitulo">Habilidades:</strong></p>
        <p> {{ data.nombre_habilidad }}</p>
      </div>
    </div>
    <div class="btn-container">
      <button class="btn-add" @click="$emit('sign-in', data.id_emergencia)">
        +
      </button>
    </div>
  </div>
</template>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300;400&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Lato:wght@300;400&display=swap');

.card {
  background: #fff;
  border-radius: 10px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  padding: 20px;
  margin: 10px;
  transition: transform 0.2s;
  flex: 1 1 calc(33.33% - 20px);
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

.card:hover {
  transform: translateY(-3px);
}

.card-content {
  flex-grow: 1;
}

.emergency, .skills {
  font-family: 'Lato', sans-serif;
  color: #333;
}

h3 {
  color: #101935;
  font-family: 'Roboto', sans-serif;
  font-size: 1.5rem;
  margin-bottom: 10px;
}

p {
  margin: 5px 0;
}

.subtitulo {
  font-weight: bold;
}

.btn-container {
  display: flex;
  justify-content: center;
  margin-top: 10px;
}

.btn-add {
  background-color: #9ad4d6;
  color: #101935;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s;
  font-family: 'Lato', sans-serif;
  font-size: 1rem;
  font-weight: bold;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

.btn-add:hover {
  background-color: #9ad4d6;
}
</style>
