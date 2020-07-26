import Vue from 'vue'
import VueRouter from 'vue-router'
import start from '@/views/start.vue'
import Home from '@/views/Home.vue'
import index from '@/components/index.vue'
import question from '@/components/question.vue'


Vue.use(VueRouter)

const routes = [{
  path: '/',
  redirect: '/start'
}, {
  path: '/start',
  component: start
}, {
  path: '/home',
  component: Home,
  children: [{
      path: 'index',
      component: index
    },{
      path: 'question',
      component: question
    }
  ]
}
]

const router = new VueRouter({
  routes
})

export default router