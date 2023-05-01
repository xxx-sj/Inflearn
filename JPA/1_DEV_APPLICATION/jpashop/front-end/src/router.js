import { createRouter, createWebHistory } from "vue-router";

import MainPage from "./page/MainPage.vue";
import ItemRegistration from "./page/item/ItemRegistration.vue";
import ItemList from "./page/item/ItemList.vue";
import MemberRegistration from "./page/member/MemberRegistration.vue";
import MemberList from "./page/member/MemberList.vue";
import OrderItem from "./page/order/OrderItem.vue";
import OrderList from "./page/order/OrderList.vue";
import ItemDetail from "@/page/item/ItemDetail";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {path: "/", component: MainPage},
        {path: "/members", component: MemberList },
        {path: "/members/register", component: MemberRegistration},
        {path: "/items", component: ItemList},
        {path: "/items/register", component: ItemRegistration},
        {path: "/items/:id/edit", component: ItemDetail},
        {path: "/order-item", component: OrderItem},
        {path: "/orders", component: OrderList},
        {path: "/:notFound(.*)", redirect: "/"}

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
