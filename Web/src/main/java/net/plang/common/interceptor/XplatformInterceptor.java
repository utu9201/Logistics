package net.plang.common.interceptor;

import com.tobesoft.xplatform.data.PlatformData;
import com.tobesoft.xplatform.tx.HttpPlatformRequest;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XplatformInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpPlatformRequest httpPlatformRequest = new HttpPlatformRequest(request);
        httpPlatformRequest.receiveData();

        PlatformData inData = httpPlatformRequest.getData();
        PlatformData outData = new PlatformData();

        request.setAttribute("inData", inData);
        request.setAttribute("outData", inData);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
