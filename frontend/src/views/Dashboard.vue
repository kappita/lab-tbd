<template>
    <div>
      <Navbar />
      <div class="dashboard-main">
        <div class="dashboard-header">
          <h1>Bienvenid@ al Panel de Gestión</h1>
          <p>Aquí puedes gestionar tus actividades como voluntario.</p>
        </div>
        <div class="dashboard-content">
          <div class="card" @click="navigateTo('emergencias')">
            <font-awesome-icon icon="fa-solid fa-fire" size="3x" class="icon" />
            <h2>Emergencias</h2>
            <p>Consulta y regístrate en emergencias activas.</p>
          </div>
          <div class="card" @click="navigateTo('habilidades')">
            <font-awesome-icon icon="fa-solid fa-wrench" size="3x" class="icon" />
            <h2>Habilidades</h2>
            <p>Agrega tus habilidades y mantén tu perfil actualizado.</p>
          </div>
          <div class="card" @click="navigateTo('postulaciones')">
            <font-awesome-icon icon="fa-solid fa-clipboard-check" size="3x" class="icon" />
            <h2>Postulaciones</h2>
            <p>Postúlate para tareas en las que puedas ayudar.</p>
          </div>
          <div class="card" @click="navigateTo('cercanos')">
            <font-awesome-icon icon="fa-solid fa-users" size="3x" class="icon" />
            <h2>Voluntarios Cercanos</h2>
            <p>Encuentra a los voluntarios más cercanos a una tarea.</p>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import Navbar from '@/components/Navbar.vue';
  import { useRouter } from 'vue-router';
  
  export default {
    components: {
      Navbar
    },
    setup() {
      const router = useRouter();
      const navigateTo = (route) => {
        router.push(`/${route}`);
      };
  
      return { navigateTo };
    }
  };
  </script>
  
  <style scoped>
  @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap');
  @import url('https://fonts.googleapis.com/css2?family=Lato:wght@300;400&display=swap');
  
  body, html {
    margin: 0;
    padding: 0;
    height: 100%;
  }
  
  .dashboard-main {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    padding: 20px;
    background-color: #f9f9f9;
    min-height: 100vh; /* Full viewport height */
  }
  
  .dashboard-header {
    text-align: center;
    margin-bottom: 20px;
  }
  
  h1 {
    color: #101935;
    font-family: 'Roboto', sans-serif;
    font-size: 2.5rem;
  }
  
  p {
    color: #555;
    font-family: 'Lato', sans-serif;
    font-size: 1.2rem;
  }
  
  .dashboard-content {
    display: flex;
    flex-wrap: wrap;
    gap: 20px;
    justify-content: center; /* Center align the cards */
  }
  
  .card {
    background: white;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    overflow: hidden;
    width: 300px;
    text-align: center;
    cursor: pointer;
    transition: transform 0.3s, box-shadow 0.3s;
    padding: 20px;
  }
  
  .card:hover {
    transform: translateY(-10px);
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
  }
  
  .card h2 {
    color: #101935;
    font-family: 'Roboto', sans-serif;
    font-size: 1.5rem;
    margin: 10px 0;
  }
  
  .card p {
    color: #555;
    font-family: 'Lato', sans-serif;
    padding: 0 10px 20px;
  }
  
  .icon {
    margin-bottom: 15px;
    color: #9ad4d6;
  }
  </style>
  