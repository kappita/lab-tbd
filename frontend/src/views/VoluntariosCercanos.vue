<template>
  <div>
    <Navbar />
    <div class="voluntarios-cercanos-main">
      <div class="voluntarios-cercanos-content">
        <h1>Voluntarios cercanos a la tarea</h1>
        <form @submit.prevent="buscarVoluntarios">
          <div class="form-group">
            <label for="tarea">Selecciona la Tarea:</label>
            <select v-model="idTarea" required>
              <option value="" disabled selected hidden>Seleccione una tarea</option>
              <option v-for="tarea in tareas" :key="tarea.id" :value="tarea.id">
                {{ tarea.nombre }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label for="n">Número de Voluntarios:</label>
            <input type="number" v-model="n" required />
          </div>
          <div class="btn-container">
            <button type="submit" class="btn-buscar">Buscar</button>
          </div>
        </form>
        <div v-if="voluntarios.length">
          <h2>Voluntarios Encontrados:</h2>
          <ul>
            <li v-for="voluntario in voluntarios" :key="voluntario.id">{{ voluntario.nombre }}</li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import Navbar from '@/components/Navbar.vue';

export default {
  components: {
    Navbar
  },
  data() {
    return {
      idTarea: '',
      n: '',
      tareas: [],
      voluntarios: []
    };
  },
  created() {
    this.fetchTareas();
  },
  methods: {
    fetchTareas() {
      axios.get("http://localhost:8080/tareas/getAll")
        .then(response => {
          this.tareas = response.data;
        })
        .catch(error => {
          console.error("Hubo un error al obtener las tareas:", error);
        });
    },
    buscarVoluntarios() {
      axios.get(`http://localhost:8080/voluntarios/getByCercania/${this.idTarea}/${this.n}`, {
        params: {
          n: this.n
        }
      })
      .then(response => {
        this.voluntarios = response.data;
      })
      .catch(error => {
        console.error("Hubo un error al obtener los voluntarios cercanos:", error);
      });
    }
  }
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300;400&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Lato:wght@300;400&display=swap');

body, html {
  margin: 0;
  padding: 0;
  height: 100%;
}

.voluntarios-cercanos-main {
  background-color: #f0f9ff;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 20px;
  min-height: calc(100vh - 80px);
  padding-top: 80px;
}

.voluntarios-cercanos-content {
  background: white;
  padding: 30px;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  width: 80%;
  max-width: 800px;
  margin-top: 20px;
}

h1{
  font-weight: bold;
}

h1, h2 {
  color: #101935;
  font-family: 'Roboto', sans-serif;
  text-align: center;
  margin-bottom: 20px;
}

form {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-gap: 20px;
  margin-bottom: 20px;
}

.form-group {
  display: flex;
  flex-direction: column;
}

label {
  color: #101935;
  font-weight: bold;
  margin-bottom: 5px;
}

input, select {
  padding: 10px;
  border-radius: 5px;
  border: 1px solid #cccccc;
  font-size: 1rem;
}

input:focus, select:focus {
  outline: none;
  border-color: #9ad4d6;
}

.btn-container {
  grid-column: span 2;
  display: flex;
  justify-content: center;
}

.btn-buscar {
  background-color: #9ad4d6;
  color: #101935;
  padding: 12px 24px;
  border-radius: 10px;
  font-size: 1.2rem;
  text-decoration: none;
  transition: background-color 0.3s, transform 0.2s;
  cursor: pointer;
}

.btn-buscar:hover {
  background-color: #564787;
  color: #f2fdff;
  transform: translateY(-2px);
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  margin: 5px 0;
  padding: 10px;
  background-color: #f0f9ff;
  border-radius: 5px;
  font-family: 'Lato', sans-serif;
  color: #101935;
}
</style>
