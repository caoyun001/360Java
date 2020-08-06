//index.js
//获取应用实例
const app = getApp()
const {$Message} = require('../../../lib/iview/base/index')

Page({
  data: {
    currentCityID: 52, // 当前城市ID
    currentCity: '', // 当前城市名称
    cityList: [], // 城市列表
    subjectsList: [], // 学科列表

    subjectID: 87, // 学科ID
    loading: true,
    clientHeight: ''
  },
  onLoad: function(option) {
    this.loadSubjects()
    this.loadCities()

    this.setData({
      currentCityID: option.cityID === undefined ? 52 : option.cityID,
      subjectID: option.subjectID === undefined ? 87 : option.subjectID // FIXME: subjectID
    })

    // FIXME: 取消本地缓存 categoryType
    // let categoryType = wx.getStorageSync('categoryType') || null
    // if(categoryType) {
    //   this.setData({
    //     currentCityID: categoryType.cityID,
    //     subjectID: categoryType.subjectID // FIXME: subjectID
    //   })
    // }
    let _this = this
    wx.getSystemInfo({
      success: function(res) {
        _this.setData({
          clientHeight: res.windowHeight
        })
      }
    })
  },
  ///////////////////////////////////////////////////////////////////////////   页面交互
  // 进入城市列表
  cityChoose: function(e) {
    wx.navigateTo({
      url: '../city/city'
    })
  },
  // 选择城市
  handleChangecity: function(e) {
    this.setData({
      currentCityID: e.currentTarget.dataset.id,
      currentCity: e.currentTarget.dataset.title
    })
  },
  // 选择学科
  changeTechnology: function(e) {
    this.setData({
      subjectID: e.currentTarget.dataset.id
    })
  },

  // /////////////////////////////////////////////////////////////////////////  业务请求
  // 城市列表接口
  loadCities() {
    let _this = this
    let data = {
      fs: 1
    }
    wx.getLocation({
      success: function(res) {
        let lat = res.longitude
        let lng = res.latitude
        data = {
          ...data,
          location: `${lat},${lng}`
        }
      },
      fail: function() {
        $Message({
          content: '当前城市获取失败',
          type: 'error',
          duration: 5
        })
      },
      complete: function() {
        app.api
          .baseCitys(data)
          .then(res => {
            console.log(res.data.citys)
            _this.setData({
              currentCityID: res.data.location.id,
              currentCity: res.data.location.title,
              cityList: res.data.citys
            })
          })
          .catch(res => {
            $Message({
              content: '请求出现错误',
              type: 'error',
              duration: 5
            })
          })
      }
    })
  },
  // 学科列表接口
  loadSubjects() {
    let _this = this
    app.api
      .baseSubjects()
      .then(res => {
        console.log(res.data)
        _this.setData({
          subjectsList: res.data
        })
      })
      .catch(res => {
        $Message({
          content: '请求出现错误',
          type: 'error',
          duration: 5
        })
      })
  },
  // 点击确定，并保存选择
  handleLogin: function(e) {
    let _this = this
    let data = {
      cityID: _this.data.currentCityID,
      subjectID: _this.data.subjectID // FIXME: subjectID
    }

    let userInfo = wx.getStorageSync('userInfo') || null
    // let categoryType = wx.getStorageSync('categoryType') || null // FIXME: 取消本地缓存

    if (userInfo) {
      app.api
        .questionsConfirm(data)
        .then(res => {
          // wx.setStorageSync('categoryType', data) // 写缓存 // FIXME: 取消本地缓存
          // console.log(res)
          wx.redirectTo({
            url:
              '/pages/main/main?cityID=' +
              data.cityID +
              '&subjectID=' +
              data.subjectID
          })
        })
        .catch(res => {
          let errmsg =
            res.data.errmsg === undefined ? res.data : res.data.errmsg
          $Message({
            content: errmsg,
            type: 'error',
            duration: 5
          })
        })
    } else {
      app.getUserInfo(e.detail, function() {
        app.api
          .questionsConfirm(data)
          .then(res => {
            // wx.setStorageSync('categoryType', data) // 写缓存 // FIXME: 取消本地缓存
            // console.log(res)
            wx.redirectTo({
              url:
                '/pages/main/main?cityID=' +
                data.cityID +
                '&subjectID=' +
                data.subjectID
            })
          })
          .catch(res => {
            let errmsg =
              res.data.errmsg === undefined ? res.data : res.data.errmsg
            $Message({
              content: errmsg,
              type: 'error',
              duration: 5
            })
          })
      })
    }
  }
})
