package com.br.second.tech.challenge.infra.config;

import com.br.second.tech.challenge.core.exception.*;
import com.br.second.tech.challenge.core.exception.model.ExceptionMensagem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class GlobalHandleConfiguration {

    private static final String EXCEPTION_HANDLER_ERROR_TO_RESOLVE_EXCEPTION = "exceptionHandler.errorToResolveException";
    private static final String ARGUMENT_NOT_VALID = "argumentNotValid";
    private static final String ERROR_TO_RESOLVE_EXCEPTION_HANDLER = "Error to resolve exception handler";


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({UsuarioNotFound.class, RestauranteNotFound.class})
    @ResponseBody
    public ExceptionMensagem handleNotFoundException(Exception ex) {
        log.error(ex.getMessage(), ex);
        return new ExceptionMensagem(HttpStatus.NOT_FOUND.name(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            AutorizacaoLoginErro.class,
            AutorizacaoIncorreta.class,
            UsuarioSemPermissaoException.class,
            MethodArgumentTypeMismatchException.class
    })
    @ResponseBody
    public ExceptionMensagem handleBadRequestException(Exception ex) {
        log.error(ex.getMessage(), ex);
        return new ExceptionMensagem(HttpStatus.BAD_REQUEST.name(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ExceptionMensagem validationException(final MethodArgumentNotValidException methodArgumentNotValidException) {
        log.error(methodArgumentNotValidException.getMessage(), methodArgumentNotValidException);
        try {
            final StringBuilder errors = new StringBuilder();

            methodArgumentNotValidException
                    .getBindingResult()
                    .getFieldErrors()
                    .forEach(field -> errors.append(field.getField()).append(":").append(field.getDefaultMessage()).append(";"));

            return new ExceptionMensagem(ARGUMENT_NOT_VALID, errors.toString());

        } catch (Exception exception) {
            log.error(ERROR_TO_RESOLVE_EXCEPTION_HANDLER, exception);
            return new ExceptionMensagem(EXCEPTION_HANDLER_ERROR_TO_RESOLVE_EXCEPTION, exception.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({
            UsuarioExistenteException.class,
            RestauranteJaExistenteException.class
    })
    @ResponseBody
    public ExceptionMensagem handleConflict(Exception ex) {
        log.error(ex.getMessage(), ex);
        return new ExceptionMensagem(HttpStatus.CONFLICT.name(), ex.getMessage());
    }
}
