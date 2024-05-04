<template>
  <Navbar />
  <div class="hero">
    <h1>¡PóneleVoluntAPP!</h1>
    <p>
  
      Surgimos como solución a la necesidad de coordinar eficazmente el flujo 
      de voluntarios espontáneos en situaciones de emergencia en Chile.

      <br><br>

      Esta plataforma facilita la gestión de esfuerzos voluntarios, emparejando habilidades y
      disponibilidades con las necesidades específicas de cada emergencia, y permitiendo a los
      coordinadores organizar y asignar tareas de forma estratégica para una respuesta ágil y 
      efectiva ante desastres naturales.

    </p>
    <div class="button-group">
      <router-link to="/login" class="btn btn-login">Iniciar sesión</router-link>
      <router-link to="/registro" class="btn btn-register">Registrarse</router-link>
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
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300;400&display=swap');
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
  background-image: linear-gradient(to bottom right, #f0f9ff, #cbebff);
  text-align: center;
  padding: 50px;
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
h1 {
  color: #101935;
  font-size: 3rem;
  font-family: 'Roboto', sans-serif;
  font-weight: 800;
  margin-bottom: 20px;
  animation: fadeIn 2s ease-in-out;
}
p {
  color: #101935;
  font-size: 1.2rem;
  font-family: 'Lato';
  font-weight: 400;
  width: 50%;
  margin-bottom: 20px;
  animation: fadeIn 2s ease-in-out;
  text-align: justify;
  line-height: 1.5;

}
.button-group {
  display: flex;
  gap: 20px;
}
.btn {
  background-color: #9ad4d6;
  color: #101935;
  padding: 12px 24px;
  border-radius: 10px;
  font-size: 1.2rem;
  text-decoration: none;
  transition: background-color 0.3s, transform 0.2s;
  margin-top: 20px;
  cursor: pointer;
}
.btn-login, .btn-register {
  background-color: #9ad4d6;
  color: #101935;
  font-weight: 500;
  padding: 12px 24px;
  border-radius: 10px;
  font-size: 1.2rem;
  text-decoration: none;
  transition: background-color 0.3s, transform 0.2s;
  cursor: pointer;
  animation: fadeIn 2s ease-in-out;
}

.btn-login:hover, .btn-register:hover {
  transform: translateY(-2px);
  background-color: #564787;
  border: 1px solid #cccccc;
  color: #f2fdff;
}
.image {
  width: 30%;
  height: auto;
  margin-bottom: 10px;
}

</style>

