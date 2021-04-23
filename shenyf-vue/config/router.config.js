// eslint-disable-next-line
import {UserLayout} from '../layouts'


/**
 * 基础路由
 * @type { *[] }
 */
export const constantRouterMap = [
  {
    path: '/login',
    redirect: 'loginIndex',
    hidden: true,
    component: () => import('../src/components/views/login/Login'),
    children: [
      {
        path: '/loginIndex',
        name: 'loginIndex',
        component: () => import('../src/components/views/login/Login')
      }
    ]
  },

  {
    path: '/404',
    component: () => import('../src/components/views/exception/404')
  },

  {
    path: '/idiomDetail',
    name: 'idiomDetail',
    component: () => import('../src/components/views/idiom/idiomDetail')
  },
  {
    path: '/idiomSearch',
    name: 'idiomSearch',
    component: () => import('../src/components/views/idiom/idiomSearch')
  },

  {
    path: '/index',
    name: 'index',
    component: () => import('../src/components/views/index/index')
  }


]
