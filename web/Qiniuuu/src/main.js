import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUI)
Vue.config.productionTip = false
import videojs from "video.js";
import "video.js/dist/video-js.css";
Vue.prototype.$video = videojs;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
