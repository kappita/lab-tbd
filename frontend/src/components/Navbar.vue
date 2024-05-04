<template>
    <nav>
      <router-link to="/" class="navbar-header">
        <img src="@/assets/logo-white.png" alt="Logo" class="navbar-logo">
        <h1 class="navbar-title">PóneleVoluntAPP</h1>
      </router-link>
      <ul>
        <li><router-link to="/about">¡Inscríbete!</router-link></li>
      </ul>
    </nav>
  </template>
  
  <script>
  export default {
    name: 'Navbar'
  }
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
    }

  .navbar-title {
    font-family: 'Roboto', sans-serif;
    margin: 0;
    text-shadow: #564787;
    font-weight: 700;
    }

    .navbar-header {
    display: flex;
    align-items: center;
    }

    .navbar-logo {
    width: 80px;
    height: 50px;
    margin-right: 10px;
    }

    ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
        display: flex;
        align-items: center
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
</style>