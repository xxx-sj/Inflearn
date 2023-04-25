import { createApp } from 'vue'

import App from './App.vue'
import router from "./router"
import store from "./store"

import TheHeader from "./components/layout/TheHeader.vue";
import TheFooter from "./components/layout/TheFooter.vue";

const app = createApp(App);

app.component("the-header", TheHeader)
app.component("the-footer", TheFooter)

app.use(router);
app.use(store)
app.mount('#app');
