// components/video-play/video-play.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    video: {
      type: String
    },
    videoPoster: {
      type: String
    }
  },

  /**
   * 组件的初始数据
   */
  data: {
    show: false
  },
  /**
   * 组件的方法列表
   */
  methods: {
    hide() {
      this.setData({
        show: false
      })
    },
    show() {
      this.setData({
        show: true
      })
    }
  }
})
