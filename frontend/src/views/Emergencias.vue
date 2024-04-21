<script setup>
  import Emergency from '@/components/Emergency.vue';
  import { ref } from 'vue';
  const email = ref("")
  const emergencies = [
    {emergency_name: "El pepe", emergency_id: 10, skills: ["bañarse", "ser sigma"]},
    {emergency_name: "Ete sech", emergency_id: 11, skills: ["Ser skibidi", "ser Toilet"]}
  ]
</script>

<template>
  <main>
    <header>
      <h1>
        Listado de emergencias activas
      </h1>
      <h2>
        Inscríbete como disponible para ayudar
      </h2>
    </header>

    <div class="emergency-section">
      <div class="user-input">
        <h2>
          Ingresa tu correo electrónico para inscribirte en emergencias:
        </h2>
        <input placeholder="Correo electrónico. Ej: rene@outlook.my" type="text" name="email" id="" v-model="email">
      </div>

      <div class="emergencies">
        <Emergency v-for="e in emergencies" :data="e"></Emergency>
      </div>
    </div>


  </main>

</template>


<style scoped>
main {
  width: 100vw;
  height: 100vh;
  padding-left: 10%;
  padding-right: 10%;
}

header {
  height: 20%;
  width: 100%;
}

.emergency-section {
  height: 80%;
  width: 100%;
}

.user-input {
  height: 20%;
  width: 100%;
}

.emergencies {
  display: grid;
  grid-template-columns: repeat(1, minmax(0, 1fr));
  width: 50%;
  height: 80%;
  overflow: scroll;
}

</style>