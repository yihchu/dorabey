<template>
  <div>
    <el-container class="el-container">
      <el-header>My Devices</el-header>
      <el-container>
<!--        <el-aside width="200px">Aside</el-aside>-->
        <el-container>
        <el-main>
          <el-row :gutter="24" >
            <el-col :span="4" v-for="device in devices" :key="device.serialNumber">
              <div class="grid-content bg-purple" style="text-align: center; margin-top: 10px">
                <div style="align-items: center;">
                  <el-image style="width: 100px; height: 180px;" :src="device.image" lazy>
                    <div slot="error" class="image-slot">
                      <el-image style="width: 100px; height: 180px;" src="/static/image/device.png" lazy/>
                    </div>
                  </el-image>
                </div>
                <div>{{device.name}}</div>
              </div>
            </el-col>
            <!--add-->
            <el-col :span="4">
              <div class="grid-content bg-purple" style="text-align: center; margin-top: 10px">
                <div style="align-items: center;">
                  <el-image style="width: 100px; height: 180px;" src="/static/image/add-device.png" lazy>
                  </el-image>
                </div>
                <div>Add Device</div>
              </div>
            </el-col>
          </el-row>
        </el-main>
        <el-footer>Footer</el-footer>
        </el-container>
      </el-container>
    </el-container>
    <div style="position: fixed; top: 10px; left: 10px;">
      <el-button type="text"><i class="el-icon-back"> Back</i></el-button>
    </div>
  </div>
</template>
<style>
.el-header {
  background-color: #B3C0D1;
  color: #333;
  text-align: center;
  line-height: 60px;
  position: absolute;
  left: 0;
  right: 0;
}

.el-footer {
  background-color: #B3C0D1;
  color: #333;
  text-align: center;
  line-height: 60px;
  position: absolute;
  /*left: 200px;*/
  left: 0;
  right: 0;
}

.el-main {
  background-color: #E9EEF3;
  color: #333;
  text-align: center;
  position: absolute;
  /*left: 200px;*/
  left: 0;
  right: 0;
  top: 60px;
  bottom: 60px;
}

.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
  top: 0;
}

.el-footer {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
  bottom: 0;
}

.el-aside {
  /*background-color: #D3DCE6;*/
  color: #333;
  text-align: center;
  line-height: calc(100vh - 70px);
}

</style>
<script>
import RequestUtil from '../../module/request.js'
export default {
  name: 'DeviceList',
  data: () => {
    return {
      request: null,
      defaultImage: '/static/image/device.png',
      devices: [
        {
          serialNumber: '1',
          name: '11111',
          image: '/static/image/device.png'
        }, {
          serialNumber: '2',
          name: '22222',
          image: ''
        }, {
          serialNumber: '3',
          name: '33333',
          image: ''
        }, {
          serialNumber: '4',
          name: '44444',
          image: ''
        }, {
          serialNumber: '5',
          name: '55555',
          image: ''
        }, {
          serialNumber: '6',
          name: '66666',
          image: '/static/image/device.png'
        }, {
          serialNumber: '7',
          name: '77777',
          image: ''
        }, {
          serialNumber: '8',
          name: '88888',
          image: ''
        }, {
          serialNumber: '9',
          name: '99999',
          image: ''
        }
      ]
    }
  },
  methods: {
  },
  mounted: () => {
    this.request = new RequestUtil('localhost', 28080, '/apis')
    console.log('>>>>>>>>>>')
    console.log(this.request)
    this.request.post('/phone/test', {id: 1, name: 'one plus'}, {}, (data) => {
      console.log('>>>>>')
      console.log(data)
      console.log('<<<<<<')
    })
  }
}
</script>
