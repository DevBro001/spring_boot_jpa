package uz.pdp.SpringDataJpaTest.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.pdp.SpringDataJpaTest.dto.ErrorBodyDto;
import uz.pdp.SpringDataJpaTest.exception.UsernameOrPasswordWrong;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({UsernameOrPasswordWrong.class, RuntimeException.class})
    public ErrorBodyDto usernameOrPasswordWrong(HttpServletRequest request, UsernameOrPasswordWrong exception){
        return new ErrorBodyDto(
                exception.getStatus().value(),
                request.getRequestURI(),
                request.getRequestURL().toString(),
                exception.getClass().toString(),
                exception.getMessage(),
                LocalDateTime.now());
    }
}
