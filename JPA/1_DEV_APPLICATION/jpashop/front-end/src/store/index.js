import { createStore } from "vuex";

import oneModule from "./modules/one/index"

const store = createStore({
    modules: {
        oneStore: oneModule
    }
})

export default store;