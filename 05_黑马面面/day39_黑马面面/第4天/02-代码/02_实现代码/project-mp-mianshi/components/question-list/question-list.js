Component({
  externalClasses: ['icon-class'],
  // 属性定义
  properties: {

    questionList: { // 属性名
      type: Object, // 类型（必填），目前接受的类型包括：String, Number, Boolean, Object, Array, null（表示任意类型）
      value: '', // 属性初始值（可选），如果未指定则会根据类型选择一个
    },
    scrollHeight: {
      type: Number,
      value: ''
    },
    pagetype: {
      type: String
    }
  },
  // 私有数据
  data: {
    currentTab: 0, //  默认标签
  },
  // 方法
  methods: {
    // 点击触发
    handleSwitch: function (e) {
      var transferData = e.currentTarget.dataset.kind

      var switchNavDetail = {
        val: transferData
      }
      var switchNavOption = {}
      this.triggerEvent('tapswitch', switchNavDetail, switchNavOption)
      if (this.data.currentTab === e.currentTarget.dataset.current) {
        return false
      } else {
        this.setData({
          currentTab: e.currentTarget.dataset.current,
        })
      }
    },
    // 点击切换页面
    handleGoExam: function(e) {
      var transferId= e.currentTarget.dataset.id
      var transferTitle = e.currentTarget.dataset.title

      var switchNavDetail = {
        id: transferId,
        title: transferTitle

      }
      var switchNavOption = {}
      this.triggerEvent('handleroute', switchNavDetail, switchNavOption)
    }
  }
})