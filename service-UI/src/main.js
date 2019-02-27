import Vue from 'vue'
import './plugins/vuetify'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import './registerServiceWorker'

import VModal from 'vue-js-modal'
import EditYaml from './components/edityamlpage.vue'
import textReader from './components/yaml.vue'


Vue.use(VModal)
Vue.component('EditYaml', EditYaml)
Vue.component('text-reader', textReader)


Vue.prototype.$http = axios

if( process.env.NODE_ENV == "development" ){
    window.API_HOST = "http://localhost:8086";
}else{
    window.API_HOST = process.env.VUE_APP_API_HOST
}

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: function (h) { return h(App) }
}).$mount('#app')
