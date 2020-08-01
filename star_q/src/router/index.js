import Vue from 'vue'
import VueRouter from 'vue-router'
import start from '@/views/start.vue'

import register from '@/views/register.vue'
import userRegister from '@/components/register/userRegister.vue'
import userTest from '@/components/register/userTest.vue'

import Home from '@/views/Home.vue'
import index from '@/components/home/index.vue'
import question from '@/components/home/question.vue'
import wish from '@/components/home/wish.vue'


Vue.use(VueRouter)

const routes = [{
  path: '/',
  redirect: '/start'
}, {
  path: '*',
  redirect: '/home/index'
}, {
  path: '/start',
  component: start
}, {
  path: '/home',
  component: Home,
  children: [{
    path: 'index',
    component: index
  }, {
    path: 'question',
    component: question
  }, {
    path: 'wish',
    component: wish
  }]
}, {
  path: '/register',
  component: register
}, {
  path: '/register/userRegister',
  component: userRegister
}, {
  path: '/register/userTest',
  component: userTest
}]

const router = new VueRouter({
  routes,
})

export default router