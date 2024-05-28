<template>
  <nav :class="{ 'easter-egg-active': isEasterEggActive }">
    <div class="navbar-header">
      <img @click="handleLogoClick" :src="logoSrc" alt="Logo" class="navbar-logo">
      <h1 @click="redirectToHome" class="navbar-title">{{ navbarTitle }}</h1>
    </div>
    <ul>
      <li><router-link to="/inscribete">¡Inscríbete!</router-link></li>
    </ul>
    <audio ref="audio" :src="audioSrc"></audio>
  </nav>
</template>

<script setup>
import { ref, nextTick } from 'vue';
import { useRouter } from 'vue-router';

// Importa las imágenes y el audio
import defaultLogo from '@/assets/logo-white.png';
import coloColoLogo from '@/assets/colo-colo-logo.png';
import coloColoHimno from '@/assets/colo-colo-himno.mp3';

const clickCount = ref(0);
const logoSrc = ref(defaultLogo);
const navbarTitle = ref('PóneleVoluntAPP');
const audioSrc = ref('');
const audio = ref(null);
const isEasterEggActive = ref(false);
const router = useRouter();

const handleLogoClick = () => {
  clickCount.value++;
  console.log(`Logo clicked ${clickCount.value} times`);
  if (clickCount.value === 10) {
    logoSrc.value = coloColoLogo;
    navbarTitle.value = 'Colocolo lo más grande';
    audioSrc.value = coloColoHimno;
    isEasterEggActive.value = true;
    nextTick(() => {
      if (audio.value) {
        console.log("Playing audio...");
        audio.value.play().catch((error) => {
          console.error("Error playing audio:", error);
        });
      }
    });
  }
};

const redirectToHome = () => {
  router.push('/');
};
</script>

<style scoped>
nav {
  background-color: #564787;
  color: #f2fdff;
  padding: 5px;
  display: flex;
  justify-content: space-between;
  position: fixed;
  width: 100%;
  top: 0;
  z-index: 1000;
  transition: background-color 0.3s;
}

.navbar-title {
  font-family: 'Roboto', sans-serif;
  margin: 0;
  text-shadow: #564787;
  font-weight: 700;
  cursor: pointer;
}

.navbar-header {
  display: flex;
  align-items: center;
}

.navbar-logo {
  width: 80px;
  height: 50px;
  margin-right: 10px;
  cursor: pointer;
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  display: flex;
  align-items: center;
}

li a {
  font-weight: 500;
  display: inline-block;
  background-color: #9ad4d6;
  color: #101935;
  padding: 5px 20px;
  border-radius: 10px;
  text-decoration: none;
  transition: background-color 0.3s, transform 0.2s;
  margin-right: 20px;
}

li a:hover {
  background-color: #564787;
  border: 1px solid #cccccc;
  color: #f2fdff;
  transform: translateY(-2px);
}

a {
  color: #fff;
  text-decoration: none;
}

.easter-egg-active {
  background-color: #000000 !important;
  .navbar-logo {
    width: 100px;
    height: 100px;
  }
}
</style>
