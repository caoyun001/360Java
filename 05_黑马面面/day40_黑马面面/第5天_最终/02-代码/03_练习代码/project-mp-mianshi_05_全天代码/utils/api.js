const request = require('./request')

// 基础数据
//const baseCitys = data => request('post', `/base/citys/`, data)
const baseCitys = data => request('post', `/common/citys.do`, data, true)
//const baseSubjects = data => request('get', '/base/sujects/52', data)
const baseSubjects = data => request('get', '/common/courseList.do', data,true)

// 用户数据
//const userLogin = data => request('post', '/user/login', data)
const userLogin = data => request('post', '/member/login.do', data,true)
// const userCenter = data => request('get', '/user/center', data)
const userCenter = data => request('get', '/member/center.do', data,true)

// 面试题数据
//const questionsConfirm = data => request('post', `/questions/confirm`, data)
const questionsConfirm = data => request('post', `/member/setCityCourse.do`, data,true)
const questionsFavorite = data => request('post', `/questions/favorite/${data.id}`, data)
// const questionsCategorys = data => request('get', `/questions/categorys/${data.categoryKind}/${data.categoryType}`, data)
const questionsCategorys = data => request('post', `/category/list.do`, data,true)
// const questionsList = data => request('get', `/questions/${data.categoryID}/${data.categoryKind}/${data.categoryType}`, data)
const questionsList = data => request('post', `/category/question/list.do`, data,true)
const questionsCommmitOne = data => request('post', `/category/question/commit.do`, data,true)
const questionsCommmitBatch = data => request('post', `/questions/category/${data.categoryID}/${data.categoryKind}/${data.categoryType}`, data)
const questionsEmpty = data => request('post', `/questions/empty/${data.categoryID}/${data.categoryKind}/${data.categoryType}`, data)

module.exports = {
  baseCitys,
  baseSubjects,
  userLogin,
  userCenter,
  questionsConfirm,
  questionsFavorite,
  questionsCategorys,
  questionsList,
  questionsCommmitOne,
  questionsCommmitBatch,
  questionsEmpty
}
