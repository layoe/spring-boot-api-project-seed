package com.company.project.interceptor;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.company.project.core.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyInterceptor extends InterceptorResponse implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //        boolean flag =true;
//        User user=(User)request.getSession().getAttribute("user");
//        if(null==user){
//            response.sendRedirect("toLogin");
//            flag = false;
//        }else{
//            flag = true;
//        }
//        return flag;
        String token = request.getHeader("token");
//        this.responseResult(response, ResultGenerator.genFailResult(token));
//        return false;
        String data = request.getParameter("str");
        String param = request.getParameter("param");


        try{
            //        User user = (User) JSON.parseObject(data, User.class);

//            ParamDto dto = JSON.parseObject(param, ParamDto.class);
            JSONObject json = JSON.parseObject(param);
//            this.responseResult(response, ResultGenerator.genSuccessResult(json));
//        System.out.println("parseBeanObject()方法：user==" + user.getId() + "," + user.getName() + "," + user.getAge());
        }catch(JSONException jse){
            logger.error(jse.getMessage());
            this.responseResult(response, ResultGenerator.genFailResult("签名验证错误"));
            return false;
        }
        return true;

//        if(!StringUtils.equals(token,"abc")){
//            this.responseResult(response, ResultGenerator.genFailResult("failed"));
//            return false;
//        }
//        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}

