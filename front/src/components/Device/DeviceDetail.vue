<template>
  <div class="hello">
    <h1>MuMu</h1>
    <canvas id="canvas" style="border: 1px solid #ff0000;"></canvas>

    <button v-on:click="connect()">Connect</button>
    <button v-on:click="play()">Play</button>
    <button v-on:click="pause()">Pause</button>
    <button v-on:click="stop()">Stop</button>4
    <button v-on:click="restart()">Restart</button>
    <button v-on:click="screenShot()">ScreenShot</button>
  </div>
</template>

<script>
import * as StompJs from '@stomp/stompjs'
export default {
  name: 'MuMu',
  data: () => {
    return {
      stompClient: null,
      canvas: null,
      g: null,
      BLANK_IMG: 'data:image/gif;base64,R0lGODlhAQABAAAAACH5BAEKAAEALAAAAAABAAEAAAICTAEAOw==',
      paused: false
    }
  },
  methods: {
    connect: () => {
      this.stompClient.activate()
    },
    play: () => {
      // trying to publish a message when the broker is not connected will throw an exception
      if (!this.stompClient.connected) {
        alert('Broker disconnected, can\'t send message.')
        return false
      }
      this.stompClient.publish({destination: '/app/message', body: 'Hello'})
      return true
    },
    pause: () => {

    },
    stop: () => {
      // trying to publish a message when the broker is not connected will throw an exception
      if (!this.stompClient.connected) {
        alert('Broker disconnected, can\'t send message.')
        return false
      }
      this.stompClient.publish({destination: '/app/image', body: 'Hello'})
      return true
    },
    restart: () => {

    },
    screenShot: () => {

    }
  },
  mounted: () => {
    console.log('>>>>> mounted')
    this.canvas = document.getElementById('canvas')
    this.g = this.canvas.getContext('2d')
    let stompConfig = {
      brokerURL: 'ws://localhost:28080/apis/greeting',
      debug: str => {
        console.log('STOMP: ' + str)
      },
      reconnectDelay: 200,
      onConnect: frame => {
        this.stompClient.subscribe('/user/queue/errors', message => {
          alert('Error ' + message.body)
        })
        this.stompClient.subscribe('/user/queue/reply', message => {
          alert('Message ' + message.body)
        })
        this.stompClient.subscribe('/user/queue/stream', message => {
          let img = new Image()
          img.onload = () => {
            console.log(img.width, img.height)
            this.canvas.width = img.width
            this.canvas.height = img.height
            this.g.drawImage(img, 0, 0)
            img.onload = null
            img.src = this.BLANK_IMG
            img = null
          }
          img.src = 'data:image/jpeg;base64,' + JSON.parse(message.body).payload
        })
      }
    }
    this.stompClient = new StompJs.Client(stompConfig)
  }
}
</script>
