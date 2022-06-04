package edu.ccsu.grade19.wu.cims.utility.util;

import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Jwts;

import java.util.Date;

/**
 * 生成Token的工具类，用于用户登录成功后生成Token进行返回
 *
 * @author Haixin Wu
 * @since 1.0
 */
public class TokenUtil {
    /**
     * token有效时长
     */
    private final static long TOKEN_EXPIRATION = 2 * 60 * 60 * 1000;
    /**
     * 编码密钥
     */
    private final static String TOKEN_SIGN_KEY = "cims";

    /**
     * 用jwt根据用户名生成token
     *
     * @param username 用户名
     * @return token
     */
    public static String createToken(String username) {
        return Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION))
                .signWith(SignatureAlgorithm.HS512, TOKEN_SIGN_KEY).compressWith(CompressionCodecs.GZIP).compact();
    }

    /**
     * 根据token字符串得到用户信息
     *
     * @param token token
     * @return username
     */
    public static String getUserInfoFromToken(String token) {
        return Jwts.parser().setSigningKey(TOKEN_SIGN_KEY).parseClaimsJws(token).getBody().getSubject();
    }
}