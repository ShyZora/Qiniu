import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)
import home from '../views/home.vue'
import user from '../views/user.vue'
import HomeView from '../views/HomeView.vue'
import recommend from '../views/recommend.vue'
import collect from '../views/collect.vue'
import fashion from '../views/classification/fashion.vue'
import sports from '../views/classification/sports.vue'
import music from '../views/classification/music.vue'
import recreation from '../views/classification/recreation.vue'
import game from '../views/classification/fashion.vue'
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    redirect:'/home',
    children: [
      { path: 'home', component: home,name:'home' },
      { path: 'user', component: user,name:'user' },
      { path: 'recommend', component: recommend,name:'recommend' },
      { path: 'collect', component: collect ,name:'collect'},
      { path: 'fashion', component: fashion ,name:'fashion'},
      { path: 'sports', component: sports ,name:'sports'},
      { path: 'music', component: music ,name:'music'},
      { path: 'recreation', component: recreation,name:'recreation'},
      { path: 'game', component: game ,name:'game'},
  ]
  },
 
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
