const http = require('http')

class RequestUtil {
  constructor (hostname, port, baseUrl) {
    this.hostname = hostname
    this.port = port
    this.baseUrl = baseUrl
  }
  get (url, headers = {}, callback = null) {
    const options = {
      hostname: this.hostname,
      port: this.port,
      path: this.baseUrl + url,
      headers: headers,
      method: 'GET'
    }
    const req = http.request(options, (res) => {
      let data = ''
      res.setEncoding('utf8')
      res.on('data', (chunk) => {
        data += chunk
      })
      res.on('end', () => {
        if (callback) {
          callback(data)
        }
      })
    })
    req.on('error', (e) => {
      console.error(`problem with request: ${e.message}`)
    })
    req.end()
  }
  post (url, postData, headers = {}, callback = null) {
    postData = JSON.stringify(postData)
    if (!headers['Content-Type']) {
      headers['Content-Type'] = 'application/json'
    }
    if (!headers['Content-Length']) {
      headers['Content-Length'] = Buffer.byteLength(postData)
    }
    let data = ''
    const options = {
      hostname: this.hostname,
      port: this.port,
      path: this.baseUrl + url,
      headers: headers,
      method: 'POST'
    }
    const req = http.request(options, (res) => {
      res.setEncoding('utf8')
      res.on('data', (chunk) => {
        data += chunk
      })
      res.on('end', () => {
        if (callback) {
          callback(data)
        }
      })
    })
    req.on('error', (e) => {
      console.error(`problem with request: ${e.message}`)
    })
    req.write(postData)
    req.end()
  }
}

export default RequestUtil
