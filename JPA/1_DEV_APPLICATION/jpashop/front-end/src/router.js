import { createRouter, createWebHistory } from "vue-router";

import WelcomeHome from "@/components/WelcomeHome";
import CoachList from "@/components/CoachList";
import TeamList from "@/components/TeamList";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {path: "/", component: WelcomeHome},
        {path: "/team", component: TeamList},
        {path: "/coach", component: CoachList},

        // {path: "/", redirect: "/"},
    //     {path: "/one", component: null},
    //     {path: "/one/:id", component: null, props: true,},
    //     {path: "/two", component: null, children: [
    //         {path: "/two-one", component: null},
    //     ]},
    //     {path: "/:notFound(.*)", component: null}
    ],
});

export default router;
