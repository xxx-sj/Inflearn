import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {path: "/", redirect: "/"},
        {path: "/one", component: null},
        {path: "/one/:id", component: null, props: true,},
        {path: "/two", component: null, children: [
            {path: "/two-one", component: null},
        ]},
        {path: "/:notFound(.*)", component: null}
    ],
});

export default router;
