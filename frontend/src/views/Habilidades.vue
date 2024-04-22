<template>
  <div class="habilidades">
    <div class="form">
      <h1>Agrega tus habilidades aquí</h1>
      <h2>Ingresa tu correo:</h2>
      <form @submit.prevent="registrarVoluntario">
        <div class="selector-multiple">
          <input v-model="voluntario.email" placeholder="Email" type="email" required />
          <h1>Ingresa tus habilidades:</h1>
          <label v-for="habilidad in habilidades" :key="habilidad.id" class="habilidad-label">
            <input type="checkbox" :value="habilidad.id" v-model="voluntario.habilidades">
            {{ habilidad.descripcion }}
          </label>
        </div>
        
        <button type="submit">Registrar</button>
      </form>
      <!-- Mensaje de éxito después de agregar -->
      <div v-if="mensajeExito" class="mensaje-exito">
        {{ mensajeExito }}
    </div>
    
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import { obtenerHabilidades } from './apiService';

export default {
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
      if (this.voluntario.habilidades.length === 0) {
        alert("Por favor, selecciona al menos una habilidad.");
        return;
      }
      
      const body = {
        email: this.voluntario.email,
        ability_ids: this.voluntario.habilidades
      }

      axios.post("http://localhost:8080/voluntarios/agregarHabilidades", body).then( e=> {
        this.mensajeExito = e.data
      }).catch(e=> {
        this.mensajeExito = "El correo electrónico es incorrecto"
      })

    }
  }
};
</script>

<style>

  template {
    display: flex;
    justify-content: center;
    align-items: center;
  }

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

.habilidades {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}

.form {
  width: 40%;
  height: 100%

}
</style>
