const request = require('./request')

// 基础数据
const baseCitys = data => request('post', `/base/citys/`, data)
const baseSubjects = data => request('get', '/base/sujects/52', data)

// 用户数据
const userLogin = data => request('post', '/user/login', data)
const userCenter = data => request('get', '/user/center', data)

// 面试题数据
const questionsConfirm = data => request('post', `/questions/confirm`, data)
const questionsFavorite = data => request('post', `/questions/favorite/${data.id}`, data)
const questionsCategorys = data => request('get', `/questions/categorys/${data.categoryKind}/${data.categoryType}`, data)
const questionsList = data => request('get', `/questions/${data.categoryID}/${data.categoryKind}/${data.categoryType}`, data)
const questionsCommmitOne = data => request('post', `/questions/${data.id}/${data.categoryID}/${data.categoryKind}/${data.categoryType}`, data)
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
