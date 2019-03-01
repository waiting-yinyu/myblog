import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import VueLogger from 'vuejs-logger'

Vue.config.productionTip = false

const options = {
  isEnabled: true,
  logLevel: 'debug',
  stringifyArguments: false,
  showLogLevel: true,
  showMethodName: false,
  separator: '|',
  showConsoleColors: true
}

Vue.use(VueLogger, options)

Vue.use(ElementUI)

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
