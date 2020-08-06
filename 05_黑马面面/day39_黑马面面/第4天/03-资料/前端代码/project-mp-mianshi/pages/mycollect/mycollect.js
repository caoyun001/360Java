const app = getApp()

Page({
  /**
   * 页面的初始数据
   */
  data: {
    pagetype: '收藏',
    scrollHeight: '',
    questionList: [], //  问题列表
    currentTab: 0, // 当前索引
    categoryKind: '',
    categoryType: ''

  },
  /**
   * 监听页面加载
   */
  onLoad: function (e) {
    let _this = this
    _this.setData({
      categoryKind: e.categoryKind,
      categoryType: e.categoryType
    })
    this.loadList(e)
    wx.getSystemInfo({
      success: function (res) {
        _this.setData({
          scrollHeight: res.windowHeight
        })
      }
    })
  },
  onShow: function () {
    let _this = this
    let backdata = {
      categoryType: _this.data.categoryType,
      categoryKind: _this.data.categoryKind
    }
    app.api
      .questionsCategorys(backdata)
      .then(res => {
        _this.setData({
          questionList: res.data.items
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
  },
  /**
   * 业务请求
   */
  // 默认加载
  loadList(e) {
    let _this = this
    let data = {
      categoryKind: e.categoryKind,
      categoryType: e.categoryType
    }
    app.api
      .questionsCategorys(data)
      .then(res => {
        _this.setData({
          questionList: res.data.items
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
  },
  // 数据交互
  loadSwitchData: function (e) {
    let _this = this
    _this.setData({
      categoryKind: e.detail.val
    })

    let data = {
      categoryType: 203,
      categoryKind: this.data.categoryKind
    }
    app.api
      .questionsCategorys(data)
      .then(res => {
        _this.setData({
          questionList: res.data.items
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
  },
  // 数据交互
  loadSwiperData: function (e) {
    let _this = this
    _this.setData({
      categoryKind: e.detail.val
    })

    let data = {
      categoryType: 203,
      categoryKind: this.data.categoryKind
    }
    app.api
      .questionsCategorys(data)
      .then(res => {
        _this.setData({
          questionList: res.data.items
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
  },
  // 路由： 去试题页
  handleExam: function (e) {
    let id = e.detail.id
    let title = e.detail.title
    let types = this.data.categoryType
    let kind = this.data.categoryKind

    wx.navigateTo({
      url: '../exam/exam?id=' + id + '&title=' + title + '&type=' + types + '&kind=' + kind
    })
  }
})