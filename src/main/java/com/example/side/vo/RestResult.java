package com.example.side.vo;

import java.io.Serializable;
import java.util.Map;

/**
 * @param <T>
 */
public final class RestResult<T> implements Serializable {

    public static final String SUCCESS = "success";
    public static final String ERROR = "error";
    public static final String FAIL = "fail";

    private String code;

    private T data;

    private String msg;

    /**
     * @param map
     * 參數內有code or msg會自動匹配,其餘一律以map放入data
     * @return
     */
    public static RestResult<Map<String, Object>> getRestResult(Map<String, Object> map) {
        RestResult<Map<String, Object>> result = new RestResult<>();
        if (map != null) {
            if (map.get("code") != null) {
                result.setCode(map.get("code").toString());
                map.remove("code");
            }
            if (map.get("msg") != null) {
                result.setMsg(map.get("msg").toString());
                map.remove("msg");
            }
            result.setData(map);
        }
        return result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
