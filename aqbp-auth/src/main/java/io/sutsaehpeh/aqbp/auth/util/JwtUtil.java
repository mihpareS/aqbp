package io.sutsaehpeh.aqbp.auth.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.signers.JWTSigner;
import cn.hutool.jwt.signers.JWTSignerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class JwtUtil {

    @Value("${jwt-privacy-secret}")
    private String jwtSecretKey;

    private JWTSigner signer;

    @PostConstruct
    public void init() {
        signer = JWTSignerUtil.hs256(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String createToken(Map<String, Object> headers, Map<String, Object> payloads) {
        try {
            return JWTUtil.createToken(headers, payloads, signer);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return StrUtil.EMPTY;
    }

    public String createToken(Map<String, Object> headers, Map<String, Object> payloads, JWTSigner signer) {
        try {
            return JWTUtil.createToken(headers, payloads, signer);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return StrUtil.EMPTY;
    }

    public Boolean verifyToken(String token) {
        try {
            return JWTUtil.verify(token, signer);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return Boolean.FALSE;
    }


    public Map<String, Object> parseToken(String token) {
        Map<String, Object> map = new HashMap<>();
        if (!verifyToken(token)) {
            return map;
        }
        try {
            JWT jwt = JWTUtil.parseToken(token);
            JSONObject headers = jwt.getHeaders();
            map.putAll(headers);
            JSONObject payloads = jwt.getPayloads();
            map.putAll(payloads);
            return map;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return map;
    }
}
