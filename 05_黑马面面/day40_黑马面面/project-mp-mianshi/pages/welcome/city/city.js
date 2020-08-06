// pages/city/city.js

const app = getApp()
const { $Message } = require('../../../lib/iview/base/index')
Page({
  data: {
    cityList: [],

    currentItemId: 1,
    currentCity: '北京'
  },
  onLoad: function () {
    this.loadCitys()
  },
  loadCitys() {
    let _this = this
    wx.getLocation({
      success: function (res) {
        let lat = res.longitude
        let lng = res.latitude
        let data = {
          fs: 0,
          location: `${lat},${lng}`
        }
        app.api
          .baseCitys(data)
          .then(res => {
            _this.setData({
              cityList: res.data.citys
            })
          })
          .catch(res => {
            console.log(res);
            $Message({
              content: '请求出现错误',
              type: 'error',
              duration: 5
            })
          })

      },
    })
  },
  changeCity: function (e) {
    let cityID = e.currentTarget.dataset.id
    let currentCityName = e.currentTarget.dataset.title

    let pages = getCurrentPages();
    var currPage = pages[pages.length - 1];  // 当前页
    var prevPage = pages[pages.length - 2];  // 上一页

    prevPage.setData({
      currentCity: currentCityName,
      currentCityID: cityID
    })
    wx.navigateBack()
  },
})