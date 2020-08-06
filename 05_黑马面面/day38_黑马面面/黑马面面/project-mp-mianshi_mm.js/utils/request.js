const config = require('./config')

const request = (method, url, data,isNewUrlBase) => {
  let baseUrl = config.urlBase;
  if (isNewUrlBase) {
    baseUrl = config.urlNewBase;
  }
  let header = {}
  const token = wx.getStorageSync('token') || null
  if (token) {
    header['Authorization'] = `${token}`
  }
  header['Content-Type'] = 'application/json'
  if (method === 'form') {
    method = 'post'
    header['Content-Type'] = 'application/x-www-form-urlencoded'
  }
  return new Promise((resolve, reject) => {
    // wx.showLoading({
    //   title: '加载中',
    //   mask: true
    // })
    
    wx.request({
      url: `${baseUrl}${url}`,
      data,
      method: method.toUpperCase(),
      header,
      success: function(res) {
        console.log('res.statusCode: ', res.statusCode)
        let statusCode = parseInt(res.statusCode)
        // if (statusCode !== 200) {
        //   wx.clearStorageSync()
        //   wx.reLaunch({
        //     url: '/pages/welcome/activate/activate'
        //   })
        // } else {
        //   resolve(res)
        // }
        if (statusCode === 401 || statusCode === 403) {
          wx.clearStorageSync()
          wx.login({
            success: res => {
              console.log('wx.login', res)
              wx.setStorageSync('code', res.code)
              wx.reLaunch({
                url: '/pages/welcome/activate/activate'
              })
            }
          })
        }
        else if (statusCode !== 200) {
          // let errmsg = res.data.errmsg === undefined ? res.data : res.data.errmsg
          wx.showToast({
            title: '通讯错误',
            icon: 'none',
            duration: 1500
          })
          reject(res)
        }  else {
          resolve(res)
        }
      },
      fail: reject,
      complete: function() {
        // wx.hideLoading()
      }
    })
  })
}

module.exports = request
