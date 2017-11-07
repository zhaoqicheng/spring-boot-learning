package com.example.learning.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * Created by zhaoqicheng on 2017/4/24.
 *
 * JWT TOKEN 工具类
 */
public class JwtHelperUtil {

    /**
     * 解析
     * @param jsonWebToken
     * @param base64Security
     * @return
     */
    public static Claims parseJWT(String jsonWebToken, String base64Security){
        try
        {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
                    .parseClaimsJws(jsonWebToken.trim()).getBody();
            return claims;
        }
        catch(Exception ex)
        {
            return null;
        }
    }

    /**
     * 生成
     * @param userName
     * @param userId
     * @param id
     * @param TTLMillis
     * @param base64Security
     * @return
     */
    public static String createJWT(Integer id, String userId, String userName, String phoneNumber, String accountType, long TTLMillis, String base64Security)
    {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //生成签名密钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Security);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                .claim("id", id)
                .claim("userid", userId)
                .claim("unique_name", userName)
                .claim("phoneNumber",phoneNumber)
                .claim("accountType",accountType)
                .signWith(signatureAlgorithm, signingKey);
        //添加Token过期时间
        if (TTLMillis >= 0) {
            //秒和毫秒之间的转换
            long expMillis = nowMillis/1000 + TTLMillis;
            Date exp = new Date(expMillis*1000);
            builder.setExpiration(exp).setNotBefore(now);
        }

        //生成JWT
        return builder.compact();
    }

}