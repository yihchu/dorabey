import Vue from 'vue'
import Desktop from '@/components/Desktop'

describe('Desktop.vue', () => {
  it('should render correct contents', () => {
    const Constructor = Vue.extend(Desktop)
    const vm = new Constructor().$mount()
    expect(vm.$el.querySelector('.hello h1').textContent)
      .toEqual('Welcome to Your Vue.js App')
  })
})
