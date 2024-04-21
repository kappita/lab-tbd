<template>
  <div class="title">
    <h1>Bienvenido a la aplicación de Voluntariados de Emergencia</h1>
    <h2>¡Regístrate aquí!</h2>
  </div>

  <div>
    <h1>Ingresa tus datos:</h1>
    <form @submit.prevent="registrarVoluntario">
      <input v-model="voluntario.nombre" placeholder="Nombre" required />
      <input v-model="voluntario.email" placeholder="Email" type="email" required />
      <input v-model="voluntario.password" placeholder="Contraseña" type="password" required />
      <input v-model="voluntario.rut" placeholder="RUT" required />
      
      <div class="selector-multiple">
        <h1>Ingresa tus habilidades:</h1>
        <label v-for="habilidad in habilidades" :key="habilidad.id" class="habilidad-label">
          <input type="checkbox" :value="habilidad.id" v-model="voluntario.habilidades">
          {{ habilidad.descripcion }}
        </label>
      </div>
      
      <button type="submit">Registrar</button>
    </form>
  </div>
  
  <!-- Mensaje de éxito después de registrar -->
  <div v-if="mensajeExito" class="mensaje-exito">
    {{ mensajeExito }}
  </div>
</template>

<script>
import axios from 'axios';
import { obtenerHabilidades } from './apiService';

export default {
  data() {
    return {
      voluntario: {
        nombre: '',
        email: '',
        password: '',
        rut: '',
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
      if (this.voluntario.habilidades.length === 0) {
        alert("Por favor, selecciona al menos una habilidad.");
        return;
      }
      
      const url = 'http://localhost:8080/voluntarios/save';
      axios.post(url, this.voluntario)
        .then(response => {
          this.mensajeExito = 'Voluntario registrado con éxito.'; // Mensaje de éxito
          console.log('Voluntario registrado con éxito:', response.data);
        })
        .catch(error => {
          console.error('Hubo un error al registrar el voluntario:', error);
          this.mensajeExito = '';
        });
    }
  }
};
</script>

<style>
.selector-multiple {
  display: flex;
  flex-direction: column;
}

.habilidad-label {
  margin: 0.5rem 0;
}

/* Estilos para el mensaje de éxito */
.mensaje-exito {
  color: green;
  background-color: #e8f5e9;
  border-left: 5px solid #4caf50;
  padding: 10px;
  margin: 10px 0;
}
</style>
