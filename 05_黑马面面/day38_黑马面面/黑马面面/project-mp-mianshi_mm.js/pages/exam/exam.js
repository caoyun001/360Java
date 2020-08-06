// pages/exam/exam.js
const Api = getApp().api
const Util = getApp().util

// 题目类型
// 1单选，2多选，3判断，5简答，6代码，7实操
const QuestionTypeConstants = {
  SINGLE: 1,
  MULTIPLE: 2,
  JUDGE: 3,
  SHORT: 5,
  CODE: 6,
  OPERATE: 7
}

// 题目数据
var categoryID = 0 // 分类ID

/*
1 = TAG
2 = 企业
3 = 方向
*/
var categoryKind = 0 // 分类

/*
101 = 刷题
201 = 错题本
202 = 我的练习
203 = 收藏题库
*/
var categoryType = 0 // 分类

Page({
  data: {
    QuestionType: QuestionTypeConstants, // 答题类型
    hiddenBG: false, // 隐藏背景
    categoryTitle: '', // 分类标题
    actionSheetVisible: false, // 答题卡是否可见

    questions: undefined, // 分类题目列表
    currPosition: 0, // 当前位置
    questionsSwiper: [], // 当前展示题目
    clientHeight: '',
    clickStyle: '',
    categoryKind:''
    // object: ''
  },

  /**
   * 监听页面开在加载的状态
   *    页面加载完成之后就不会在执行
   */
  onLoad: function (option) {
    categoryID = option.id
    categoryKind = option.kind
    categoryType = option.type
    this.setData({
      categoryTitle: option.title,
      categoryKind: option.kind,
      categoryType: option.type
    })
    this.getList()
    // 滚动区域
    let _this = this
    wx.getSystemInfo({
      success: function (res) {
        _this.setData({
          clientHeight: res.windowHeight
        })
      }
    })
  },
  // 上一个界面参数传递
  // navigateBackFunc: function (e) {
  //   console.log(e)
  //   var pages = getCurrentPages()
  //   var prevPage = pages[pages.length - 1]  //当前界面
  //   var prevPage = pages[pages.length - 2]  //上一个页面
  //   prevPage.setData({
  //     object: this.data.object
  //   })
  // },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    this.videoContext = wx.createVideoContext('myVideo')
  },

  /**
   * ajax
   */
  // 拉取题目列表
  getList() {
    wx.showLoading({
      title: '加载中'
    })
    Api.questionsList({
      categoryID,
      categoryKind,
      categoryType
    })
      .then(res => {
        console.log('数据下载完成')
        this.processData(res.data)
        wx.hideLoading()
      })
      .catch(err => {
        console.log(err)
        wx.hideLoading()
      })
  },
  // 处理数据
  processData(data) {
    this.setData({
      questions: data,
      hiddenBG: true
    })
    if (data.items.length > 0) {
      let lastID = data.lastID
      // 跳转没有做的第一题，如果都做了返回最后做的题目
      let currPosition = this.data.questions.items.findIndex((element, index) => {
        return !element.isFinished
      })
      if (currPosition < 0) {
        currPosition = this.data.questions.items.findIndex((element, index) => {
          return element.id === lastID
        })
      }
      if (currPosition < 0) {
        currPosition = 0
      }
      this.goQuestion(currPosition)
      if (data.items.length > 200) {
        wx.showToast({
          title: '正在准备试题...',
          icon: 'none',
          duration: 2000
        })
      }
    }
  },
  // 提交单题
  commentFavorite() {
    let currQuestion = this.data.questions.items[this.data.currPosition]
    Api.questionsFavorite({
      id: currQuestion.id,
      isFavorite: currQuestion.isFavorite
    })
      .then(res => {})
      .catch(err => {})
  },
  // 提交单题
  commentOne() {
    let currQuestion = this.data.questions.items[this.data.currPosition]
    Api.questionsCommmitOne({
      categoryID,
      categoryKind,
      categoryType,
      id: currQuestion.id,
	  type: currQuestion.type,
      answerIsRight: currQuestion.answerIsRight,
      answerResult: currQuestion.answerResult,
      isFavorite: currQuestion.isFavorite
    })
      .then(res => { })
      .catch(err => { })
  },
  // 清空题目
  commentEmpty() {
    // this.setData({
    //   questions: null
    // })
    Api.questionsEmpty({
      categoryID,
      categoryKind,
      categoryType
    })
      .then(res => {
        this.getList()
      })
      .catch(err => { })
  },

  /**
   * 翻页控制
   */
  // 跳转题目
  goQuestion(currPosition) {
    let questions = this.data.questions
    questions.items[currPosition].answerDisplay =
      questions.items[currPosition].isFinished
    this.setData({ questions, currPosition })
    // console.log('currQuestion => ', questions.items[currPosition])
  },
  // goQuestion(itemID) {
  //   // let currPosition = _findIndex(this.data.questions.items, {'id': itemID})
  //   let currPosition = this.data.questions.items.findIndex((element, index) => {
  //     return element.id === itemID
  //   })
  //   let start = currPosition - 1
  //   if (start < 0) {
  //     start = 0
  //   }
  //   let end = currPosition + (3 - (currPosition - start))
  //   if (end > this.data.questions.items.length) {
  //     end = this.data.questions.items.length
  //   }
  //   let questionsSwiper = this.data.questions.items.slice(start, end)
  //   let currItemID = itemID
  //   this.setData({
  //     questionsSwiper,
  //     currPosition
  //   })
  //   let _this = this
  //   setTimeout(function(){
  //     _this.setData({
  //       currItemID
  //     })
  //   },500)
  //   console.log('goQuestion => ', questionsSwiper, `itemID:${currItemID} currPosition:${currPosition} start:${start} end:${end}`, this.data.currItemID)
  // },

  // 滑动处理
  swiperChange(e) {
    // let itemID = this.data.questionsSwiper[e.detail.current].id
    // console.log('swiperChange => ', e.detail.current, itemID, this.data.currItemID)
    // this.goQuestion(itemID)
    this.goQuestion(e.detail.current)
  },

  /**
   * 交互事件--点击触发的各类事件
   */

  // 简答题：点击按钮 , 显示答案
  handleShowAnswer: function () {
    let currQuestion = this.data.questions.items[this.data.currPosition]
    currQuestion.answerDisplay = true
    this.setData({
      questions: this.data.questions
    })
  },
  // 单选题： 点击单选
  handleRadioGroupChange: function (e) {
    let selVal = e.detail.value
    let currQuestion = this.data.questions.items[this.data.currPosition]
    if (currQuestion.isFinished) {
      return
    }
    currQuestion.isFinished = true // 是否完成
    currQuestion.answerResult = [] // 回答返回
    currQuestion.answerResult.push(selVal)
    currQuestion.answerIsRight = false // 回答是否正确
    for (let item of currQuestion.selection) {
      if (item.isRight === true && item.code === selVal) {
        currQuestion.answerIsRight = true
        break
      }
    }
    this.setData({
      questions: this.data.questions
    })
    // console.log('handleRadioGroupChange', selVal, currQuestion)
    this.commentOne() // 提交单题结果
  },
  // 多选题：点击多选选项
  handleCheckboxGroupChange: function (e) {

    let selVal = e.detail.value
    let currQuestion = this.data.questions.items[this.data.currPosition]
    if (currQuestion.isFinished) {
      return
    }
    currQuestion.isFinished = false // 是否完成
    currQuestion.answerResult = selVal // 回答返回
    currQuestion.answerIsRight = false // 回答是否正确
    this.setData({
      questions: this.data.questions,
    })
    // console.log('handleRadioGroupChange', selVal, currQuestion)
  },
  // 多选: 点击确认答案
  handleCheckboxAnswerIsFinished: function (e) {
    let currQuestion = this.data.questions.items[this.data.currPosition]
    if (currQuestion.isFinished) {
      return
    }

    let rightSelections = []
    for (let item of currQuestion.selection) {
      if (item.isRight) {
        rightSelections.push(item.code)
      }
    }
    let diff = Util.difference(rightSelections, currQuestion.answerResult)
    // console.log(rightSelections, currQuestion.answerResult, diff)

    currQuestion.answerIsRight = diff.length > 0 ? false : true

    currQuestion.isFinished = true // 是否完成
    this.setData({
      questions: this.data.questions
    })

    this.commentOne() // 提交单题结果
  },

  // 播放视频
  handlePlayVideo() {
    let videoComponent = this.selectComponent('.heima-video')
    videoComponent.show()
  },

  // 底部操作区
  // 点击收藏
  handleFavor: function (e) {
    let currQuestion = this.data.questions.items[this.data.currPosition]
    currQuestion.isFavorite = !currQuestion.isFavorite
    this.setData({
      questions: this.data.questions
    })
    this.commentFavorite() // 提交收藏
  },
  // 点击正确or错误
  handleAnswerIsRight: function (e) {
    let currQuestion = this.data.questions.items[this.data.currPosition]
    currQuestion.answerDisplay = true
    // if (currQuestion.isFinished) {
    //   return
    // }
    if (currQuestion.type !== QuestionTypeConstants.SHORT) {
      // 只有 主观题 能操作
      return
    }
    currQuestion.isFinished = true // 是否完成
    currQuestion.answerIsRight = e.currentTarget.dataset.current
    this.setData({
      questions: this.data.questions
    })
    this.commentOne() // 提交单题结果
  },

  // 点击答题卡
  handleOpen(e) {
    this.setData({
      actionSheetVisible: true
    })
  },
  // 动画面板操作
  handleActionSheetCancel() {
    this.setData({
      actionSheetVisible: false
    })
  },
  // 点击清空
  handleQuestionsEmpty: function (e) {
    this.setData({
      questions: {}
    })
    this.commentEmpty()
    this.setData({
      actionSheetVisible: false
    })
  },
  // 选择单题
  handleSelectItem(e) {
    this.goQuestion(e.currentTarget.dataset.current)
    this.setData({
      actionSheetVisible: false
    })
  },
  // 视频播放
  videoPlay: function (e) {
    this.setData({
      curr_id: e.currentTarget.dataset.id
      // video_image: 'none'
    })
    this.videoContext.play()
  }
})
