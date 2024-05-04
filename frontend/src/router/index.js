import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Registro from '@/views/Registro.vue'
import Emergencias from '@/views/Emergencias.vue'
import Postulacion from '@/views/Postulacion.vue'
import Login from '@/views/Login.vue'
import Habilidades from '@/views/Habilidades.vue'
import Navbar from '@/components/Navbar.vue'
import AboutView from '../views/AboutView.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/registro',
      name: 'registro',
      component: Registro
    },
    {
      path: '/emergencias',
      name: 'emergencias',
      component: Emergencias
    },
    {
      path: '/postulaciones',
      name: 'postulaciones',
      component: Postulacion
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/habilidades',
      name: 'Habilidades',
      component: Habilidades
    }
    
  ]
})

export default router
