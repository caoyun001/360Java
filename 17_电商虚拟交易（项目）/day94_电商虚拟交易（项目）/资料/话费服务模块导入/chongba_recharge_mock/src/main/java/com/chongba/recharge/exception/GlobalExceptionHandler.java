package com.chongba.recharge.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 通用异常处理
 *
 */
@ControllerAdvice(basePackages = "com.recharge.controller")
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ErrorInfo<String> errorResult(HttpServletRequest req) {
		ErrorInfo<String> r = new ErrorInfo<String>();
		r.setMessage("参数异常");
		r.setCode(ErrorInfo.ERROR);
		r.setUrl(req.getRequestURL().toString());
		return r;
	}

	@ExceptionHandler(value = MockException.class)
	@ResponseBody
	public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, MockException e) throws Exception {
		ErrorInfo<String> r = new ErrorInfo<String>();
		r.setMessage(e.getMessage());
		r.setCode(ErrorInfo.ERROR);
		r.setData("Some Data");
		r.setUrl(req.getRequestURL().toString());
		return r;
	}

}
