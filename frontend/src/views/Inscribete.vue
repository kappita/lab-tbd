<template>
  <Navbar />
  <div class="hero">
    <video autoplay muted loop id="heroVideo">
      <source src="@/assets/PóneleVoluntAPP.mp4" type="video/mp4">
    </video>
    <div class="overlay-text">
      <p>NO SON SOLO MANOS</p>
      <p>ES COMPROMISO</p>
      <p>#PÓNELEVOLUNTAPP</p>
    </div>
  </div>
    <div class="hero-content">
      <p>
        Surgimos como solución a la necesidad de coordinar eficazmente el flujo 
        de voluntarios espontáneos en situaciones de emergencia en Chile.
        Facilitamos la gestión de esfuerzos voluntarios, emparejando habilidades y
        disponibilidades con las necesidades específicas de cada emergencia, y permitiendo a los
        coordinadores organizar y asignar tareas de forma estratégica para una respuesta ágil y 
        efectiva ante desastres naturales.
      </p>
      <div class = "sumate">
      <h2>¡Súmate al cambio tanto como Voluntario o Institución!</h2>
      <div class="button-group">
        <router-link to="/login" class="btn btn-login">Iniciar sesión</router-link>
        <router-link to="/registro" class="btn btn-register">Registrarse</router-link>
      </div>
    </div>
  </div>
</template>

<script>
import Navbar from '@/components/Navbar.vue';

export default {
  name: 'AboutView',
  components: {
    Navbar
  }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Lato:wght@300;400&display=swap');

@keyframes fadeIn {
  0% {
    opacity: 0;
  }
  100% {
    opacity: 1;
  }
}

.hero {
  position: relative;
  text-align: center;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: flex-start;
}

#heroVideo {
  width: 100%;
  height: 50vh;
  object-fit: cover;
}

.overlay-text {
  position: absolute;
  top: 30%;
  width: 100%;
  color: #f2fdff;
  line-height: 1.6;
  text-align: center;
  font-weight:bold; 
  font-family: 'Roboto', sans-serif; 
  font-style: italic;
  text-shadow: 2px 2px 4px rgba(0,0,0,0.5);
  padding: 0 30px;
}

.hero-content {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: auto;
  min-height: 50vh;
  color: #101935;
  padding: 40px;
  background: rgba(255, 255, 255, 0.9);
  box-shadow: 0 4px 8px rgba(0,0,0,0.1);
}

p {
  margin-top: 20px;
  font-family: 'Lato', sans-serif;
  font-size: 1.2rem;
  width: 80%;
  line-height: 1.6;
  text-align: justify;
  animation: fadeIn 1s ease-in-out;
}

h2 {
  margin-top: 5vh;
  font-size: 1.5rem;
  color: #101935;
  margin-bottom: 10px;
  font-weight: 700;
  animation: fadeIn 1s ease-in-out;
}

.button-group {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}

.btn-login, .btn-register {
  font-weight: 500;
  background-color: #9ad4d6;
  color: #101935;
  padding: 12px 24px;
  border-radius: 10px;
  font-size: 1.2rem;
  text-decoration: none;
  transition: background-color 0.3s, transform 0.2s;
  cursor: pointer;
  margin-right: 30px;
  animation: fadeIn 1s ease-in-out;
}

.btn-login:hover, .btn-register:hover {
  transform: translateY(-2px);
  background-color: #564787;
  color: #f2fdff;
}
</style>
