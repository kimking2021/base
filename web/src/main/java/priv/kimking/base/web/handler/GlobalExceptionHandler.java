package priv.kimking.base.web.handler;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import priv.kimking.base.web.common.Result;
import priv.kimking.base.web.common.enums.ResultCodeEnum;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 缺少参数抛出的异常是MissingServletRequestParameterException，
 * 单参数校验失败后抛出的异常是ConstraintViolationException，
 * get请求的对象参数校验失败后抛出的异常是BindException，
 * post请求的对象参数校验失败后抛出的异常是MethodArgumentNotValidException
 *
 * @author kim
 * @date 2021/8/12
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    Result<?> handleParameterException(MissingServletRequestParameterException e, HttpServletRequest request) {
        Result<?> result = Result.buildErrorResult(ResultCodeEnum.PARAM_ILLEGAL);
        String msg = StrUtil.format("缺少参数{0}", ((MissingServletRequestParameterException) e).getParameterName());
        result.setMsg(msg);
        return result;
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    Result<?> handleConstraintException(ConstraintViolationException e) {
        Result<?> result = Result.buildErrorResult(ResultCodeEnum.PARAM_ILLEGAL);
        Set<ConstraintViolation<?>> sets = ((ConstraintViolationException) e).getConstraintViolations();
        if (CollUtil.isNotEmpty(sets)) {
            StringBuilder sb = new StringBuilder();
            sets.forEach(error -> {
                if (error instanceof FieldError) {
                    sb.append(((FieldError) error).getField()).append(":");
                }
                sb.append(error.getMessage()).append(";");
            });
            String msg = sb.toString();
            log.warn("参数校验失败：{}", msg);
            msg = StrUtil.sub(msg, 0, msg.length() - 1);
            result.setMsg(msg);
        }
        return result;
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    Result<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        // post请求的对象参数校验异常
        Result<?> result = Result.buildErrorResult(ResultCodeEnum.PARAM_ILLEGAL);
        List<ObjectError> errors = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors();
        String msg = getValidExceptionMsg(errors);
        if (StrUtil.isNotBlank(msg)) {
            result.setMsg(msg);
        }
        return result;
    }

    @ExceptionHandler(value = {BindException.class})
    Result<?> handleMethodArgumentNotValidException(BindException e) {
        // get请求的对象参数校验异常
        Result<?> result = Result.buildErrorResult(ResultCodeEnum.PARAM_ILLEGAL);
        List<ObjectError> errors = ((BindException) e).getBindingResult().getAllErrors();
        String msg = getValidExceptionMsg(errors);
        if (StrUtil.isNotBlank(msg)) {
            result.setMsg(msg);
        }
        return result;
    }

    @ExceptionHandler(value = {Throwable.class})
    // @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    Result<?> handleException(Throwable e, HttpServletRequest request) {
        // 异常处理
        log.error("异常：{}", e.getLocalizedMessage());
        return Result.fail();
    }


    private String getValidExceptionMsg(List<ObjectError> errors) {
        if (CollUtil.isNotEmpty(errors)) {
            StringBuilder sb = new StringBuilder();
            errors.forEach(error -> {
                if (error instanceof FieldError) {
                    sb.append(((FieldError) error).getField()).append(":");
                }
                sb.append(error.getDefaultMessage()).append(";");
            });
            String msg = sb.toString();
            msg = StrUtil.sub(msg, 0, msg.length() - 1);
            return msg;
        }
        return null;
    }

}
