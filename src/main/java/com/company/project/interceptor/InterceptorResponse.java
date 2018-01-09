package com.company.project.interceptor;

import com.alibaba.fastjson.JSON;
import com.company.project.core.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 拦截器响应
public class InterceptorResponse {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    void responseResult(HttpServletResponse response, Result result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }
}
