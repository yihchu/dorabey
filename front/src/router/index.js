import Vue from 'vue'
import Router from 'vue-router'
import Desktop from '@/components/Desktop'
import DeviceList from '@/components/Device/DeviceList'
import DeviceDetail from '@/components/Device/DeviceDetail'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Desktop',
      component: Desktop
    }, {
      path: '/device-list',
      name: 'DeviceList',
      component: DeviceList
    }, {
      path: '/device-detail',
      name: 'DeviceDetail',
      component: DeviceDetail
    }
  ]
})
