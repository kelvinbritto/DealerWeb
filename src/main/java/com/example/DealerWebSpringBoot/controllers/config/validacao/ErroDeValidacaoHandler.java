package com.example.DealerWebSpringBoot.controllers.config.validacao;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErroDeValidacaoHandler {


	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ModelAndView handle() {
		
		return new ModelAndView("redirect:/mesa/formcomunitarias");
	
	}
}