package br.com.agendalize.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorController {


    @ExceptionHandler(Throwable.class)
    @ResponseStatus()
    public String exception(final Throwable throwable, final Model model) {
     
        String errorMessage = (throwable != null ? throwable.getMessage() : "Erro desconhecido.");
        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }

}