const loadCitys = (formData, methodType) => {
  console.log("自定义的方法");
  console.log(formData);
  let head = {};
  head['Content-Type'] = 'application/json';
  wx.request({
    url: 'http://localhost:7070/wx/common/citys.do',
    data: formData,
    method: methodType,
    header: head,
    success: function (res) {
      console.log("自己的返回");
      console.log(res);
    }
  })
}

module.exports = {
  loadCitys
}