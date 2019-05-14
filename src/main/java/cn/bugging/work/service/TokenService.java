package cn.bugging.work.service;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import cn.bugging.work.entity.UserEntity;
import cn.bugging.work.utils.consts.Response;

@Service("TokenService")
public class TokenService {

	/**
	 * 根据user.password或者自定义secret（这里）来创建token
	 * 
	 * @param user
	 * @return token
	 */
	public String createToken(UserEntity user) {
		String token = "";
		try {
			//根据HMAC256加密算法对默认security password进行加密，也可以使用user.password
			Algorithm algorithm = Algorithm.HMAC256("secret");
			token = JWT.create().withIssuedAt(new Date()) //签署token时间
					.withExpiresAt(new Date(System.currentTimeMillis() + (60 * 60 * 1000))) // 过期时间（毫秒）
					.withIssuer(user.getID())// 将 user id 保存到 token 里面
					.sign(algorithm);//用algorithm来签署token令牌，验证时需要一致
		} catch (JWTCreationException exception) {
			// Invalid Signing configuration / Couldn't convert Claims.
			exception.printStackTrace();
		}
		return token;
	}

	/**
	 * 验证token是否正确(时效或者是否与生成的的token一致)
	 * 
	 * @param token
	 * @param user
	 * @return 注意:如果验证token已失效或者不正确，则会通过JWTVerificationException异常来抛出
	 */
	public Object verifyToken(String token, UserEntity user) {
		JSONObject jsonObject = new JSONObject();
		Algorithm algorithm = Algorithm.HMAC256("secret");
		try {
			JWTVerifier verifier = JWT.require(algorithm).build(); // Reusable verifier instance
			verifier.verify(token);// 对token进行验证，错误则抛出异常
			jsonObject.put("code", Response.CODE_ALL_CORRECT);
			jsonObject.put("token", token);
			jsonObject.put("roles", user.getUsername());
		} catch (JWTVerificationException exception) {
//			exception.printStackTrace();  
			jsonObject.put("code", Response.CODE_TOKEN_OVERVUE);
			jsonObject.put("token", "");
			jsonObject.put("message", Response.MSG_TOKEN_OVERVUE);
		}
		return jsonObject;
	}
}
