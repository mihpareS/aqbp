package io.sutsaehpeh.aqbp.auth.config.filter;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import io.sutsaehpeh.aqbp.auth.service.TokenService;
import io.sutsaehpeh.aqbp.common.constant.SystemConst;
import io.sutsaehpeh.aqbp.common.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TokenFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String accessToken = request.getHeader(SystemConst.ACCESS_TOKEN);
        if (StrUtil.isEmpty(accessToken)) {
            filterChain.doFilter(request, response);
            return;
        }
        LoginUser user = tokenService.getLoginUser(accessToken);
        if (ObjectUtil.isNotNull(user.getUserId())) {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(user, null, null);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(request, response);
    }
}
