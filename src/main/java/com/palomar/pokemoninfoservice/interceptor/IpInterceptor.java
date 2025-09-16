package com.palomar.pokemoninfoservice.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Autor: josue.palomar
 * Fecha de creación: 13/09/25
 */
@Log4j2
@Component
public class IpInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String clientIp = request.getHeader("X-Forwarded-For");
        if (clientIp == null || clientIp.isEmpty()) {
            clientIp = request.getRemoteAddr();
        }
        // Aquí puedes guardar la IP en la bitácora, en el request, en un log, etc.
        log.debug("IP de origen: " + clientIp);
        // Puedes guardar la IP en un atributo para usarla después:
        request.setAttribute("clientIp", clientIp);
        return true;
    }
}