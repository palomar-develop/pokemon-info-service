package com.palomar.pokemoninfoservice.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;

@Slf4j
public class SoapIpInterceptor implements EndpointInterceptor {
    @Override
    public boolean handleRequest(MessageContext messageContext, Object endpoint) throws Exception {
        // Intentar obtener el HttpServletRequest desde el contexto de Spring
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attrs != null) {
            HttpServletRequest request = attrs.getRequest();
            String clientIp = request.getHeader("X-Forwarded-For");
            if (clientIp == null || clientIp.isEmpty()) {
                clientIp = request.getRemoteAddr();
            }
            log.debug("IP de origen SOAP: " + clientIp);
            request.setAttribute("clientIp", clientIp);
        } else {
            log.debug("No se pudo obtener HttpServletRequest desde el contexto de Spring");
        }
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext, Object endpoint) { return true; }
    @Override
    public boolean handleFault(MessageContext messageContext, Object endpoint) { return true; }
    @Override
    public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex) {log.debug("Completado");}
}
