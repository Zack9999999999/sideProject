package com.example.side.exception;

import com.example.side.vo.RestResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(WeakPasswordException.class)
//    public RestResult<Map<String, Object>> handleWeakPasswordException(WeakPasswordException e) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", RestResult.ERROR);
//        map.put("msg", e.getMessage());
//        return RestResult.getRestResult(map);
//    }
//    @ExceptionHandler(UserAlreadyExistsException.class)
//    public RestResult<Map<String, Object>> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", RestResult.ERROR);
//        map.put("msg", e.getMessage());
//        return RestResult.getRestResult(map);
//    }
//    @ExceptionHandler(Exception.class)
//    public RestResult<Map<String, Object>> handleGenericException(Exception e) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", RestResult.ERROR);
//        map.put("msg", e.getMessage());
//        return RestResult.getRestResult(map);
//    }


    @ExceptionHandler(WeakPasswordException.class)
    public ResponseEntity<String> handleWeakPasswordException(WeakPasswordException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<String> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("伺服器錯誤");
    }
}
