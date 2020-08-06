const formatTime = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return (
    [year, month, day].map(formatNumber).join('/') +
    ' ' +
    [hour, minute, second].map(formatNumber).join(':')
  )
}

const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : '0' + n
}

const difference = (a, b) => {
  if (b.length > a.length) {
    var tmp = a
    a = b
    b = tmp
  }

  var o_a = {}
  var o_b = {}

  for (var i = 0; i < a.length; i += 1) {
    o_a[a[i]] = a[i]
  }

  for (var i = 0; i < b.length; i += 1) {
    o_b[b[i]] = b[i]
  }

  var result = []
  for (var key in o_b) {
    if (o_a[key] === undefined) result.push(o_b[key])
  }
  for (var key in o_a) {
    if (o_b[key] === undefined) result.push(o_a[key])
  }
  return result
}

module.exports = {
  formatTime: formatTime,
  difference: difference
}
