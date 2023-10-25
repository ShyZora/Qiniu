import Vue from 'vue'
import VueRouter from 'vue-router'
import mainPage from '/src/views/mainPage/mainPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: mainPage,
    
},
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
