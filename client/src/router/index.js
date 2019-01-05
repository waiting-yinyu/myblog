import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/Index'
import Add from '@/components/Add'

Vue.use(Router)

export default new Router({
    routes: [{
            path: '/home',
            name: 'Index',
            component: Index
        },
        {
            path: '/add',
            name: 'Add',
            component: Add
        }
    ]})