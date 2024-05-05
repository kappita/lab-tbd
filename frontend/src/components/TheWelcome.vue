<template>
  <Navbar />
  <div class="hero">
    <div class="content">
      <h1>¡Bienvenid@ a PóneleVoluntAPP!</h1>
      <p>Coordinando esfuerzos voluntarios en situaciones de emergencia.</p>
      <router-link to="/inscribete" class="btn btn-primary">Comienza a ayudar</router-link>
    </div>
  </div>
</template>

<script>
import Navbar from './Navbar.vue';
export default {
  name: 'HeroComponent',
  components: {
    Navbar
  }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300;400&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Lato:wght@300;400&display=swap');

.hero {
  background-image: url('@/assets/wallpaper.png');
  background-size: cover;
  background-position: center;
  padding: 50px;
  min-height: 100vh;
  display: flex;
  align-items: center;
}

.content {
  max-width: 500px;
  text-align: left; 
}

h1 {
  color: #101935;
  font-size: 3rem;
  font-family: 'Roboto', sans-serif;
  font-weight: 800;
  margin-bottom: 20px;
}

p {
  color: #101935;
  font-size: 1.2rem;
  font-family: 'Lato';
  font-weight: 400;
  margin-bottom: 40px;
  width: 300px;
  text-align: justify;
}


@keyframes blink {
  0% { opacity: 1; }
  50% { opacity: 0.5; }
  100% { opacity: 1; }
}

.btn-primary {
  background-color: #9ad4d6;
  color: #101935;
  padding: 12px 24px;
  border-radius: 10px;
  font-weight: 500;
  font-size: 1.2rem;
  text-decoration: none;
  transition: background-color 0.3s, transform 0.2s;
  animation: blink 5s infinite;
  margin-top: 30px;
}

.btn-primary:hover {
  background-color: #564787;
  border: 1px solid #cccccc;
  color: #f2fdff;
  transform: translateY(-2px);
}
</style>
