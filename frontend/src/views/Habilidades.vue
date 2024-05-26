<template>
  <div>
    <Navbar />
    <div class="skills-main">
      <div class="skills-content">
        <h1 class="main-title">Agrega tus habilidades aquí</h1>
        <form @submit.prevent="registrarVoluntario">
          <div class="selector-multiple">
            <h2 class="sub-title">Ingresa tus habilidades:</h2>
            <label v-for="habilidad in habilidades" :key="habilidad.id" class="habilidad-label">
              <input type="checkbox" :value="habilidad.id" v-model="voluntario.habilidades">
              {{ habilidad.descripcion }}
            </label>
          </div>
          <div class="btn-container">
            <button type="submit" class="btn-registrar">Registrar</button>
          </div>
        </form>
        <div v-if="mensajeExito" class="mensaje-exito">
          {{ mensajeExito }}
        </div>
      </div>
    </div>
  </div>
</template>


<script>
import axios from 'axios';
import { obtenerHabilidades } from './apiService';
import Navbar from '@/components/Navbar.vue';
import { userJwt } from '@/store/store';

export default {
  components: {
    Navbar
  },
  data() {
    return {
      voluntario: {
        email: '',
        habilidades: []
      },
      habilidades: [],
      mensajeExito: ''
    };
  },
  created() {
    this.fetchHabilidades();
  },
  methods: {
    fetchHabilidades() {
      obtenerHabilidades()
        .then(response => {
          this.habilidades = response.data;
        })
        .catch(error => {
          console.error('Hubo un error al obtener las habilidades:', error);
        });
    },
    registrarVoluntario() {
      const body = {
        token: userJwt.value,
        ability_ids: this.voluntario.habilidades
      };

      axios.post("http://localhost:8080/voluntarios/agregarHabilidades", body)
        .then(response => {
          this.mensajeExito = response.data;
        })
        .catch(error => {
          this.mensajeExito = "El correo electrónico es incorrecto";
          console.error('Hubo un error al registrar las habilidades:', error);
        });
    }
  }
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300;400&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Lato:wght@300;400&display=swap');

.skills-main {
  background-color: #f0f9ff;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 20px;
  min-height: 100vh;
}

h1 {
  font-weight: bold;
}

.skills-content {
  background: white;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  width: 80%;
  max-width: 800px;
}

.main-title {
  color: #101935;
  font-family: 'Roboto', sans-serif;
  text-align: center;
  margin-bottom: 20px;
  font-size: 2rem;
}

.sub-title {
  color: #101935;
  font-family: 'Roboto', sans-serif;
  text-align: center;
  margin-bottom: 20px;
  font-size: 1.5rem;
}

.selector-multiple {
  display: flex;
  flex-direction: column;
  margin-top: 20px;
}

.habilidad-label {
  display: flex;
  align-items: center;
  margin: 0.5rem 0;
  font-size: 1.2rem;
}

.habilidad-label input[type="checkbox"] {
  width: 20px;
  height: 20px;
  margin-right: 10px;
  cursor: pointer;
}

.habilidad-label input[type="checkbox"]:checked {
  background-color: #9ad4d6;
  border-color: #9ad4d6;
}

input[type="email"] {
  width: 100%;
  padding: 10px;
  margin-top: 10px;
  border-radius: 5px;
  border: 1px solid #cccccc;
}

input[type="email"]:focus {
  outline: none;
  border-color: #9ad4d6;
}

label {
  color: black;
}

.btn-container {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}

.btn-registrar {
  background-color: #9ad4d6;
  color: #101935;
  padding: 12px 24px;
  border-radius: 10px;
  font-size: 1.2rem;
  text-decoration: none;
  transition: background-color 0.3s, transform 0.2s;
  cursor: pointer;
}

.btn-registrar:hover {
  background-color: #564787;
  color: #f2fdff;
  transform: translateY(-2px);
}

.mensaje-exito {
  color: #564787;
  background-color: #e8f5e9;
  border-left: 5px solid #564787;
  padding: 10px;
  margin-top: 20px;
  text-align: center;
}
</style>
