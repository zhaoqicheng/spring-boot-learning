package com.example.learning.controller;

import com.example.learning.common.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by zhaoqicheng on 2017/4/19.
 * 用户相关
 *
 * 模拟JTW规范  给用户添加JWT身份识别（通过这种手段，可以支持移动端的）
 *
 */
@RestController
@RequestMapping(value = "user")
public class UserController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

//    @Autowired
//    private Audience audience;
//
//    @Autowired
//    private AccountService accountService;

    /**
     * 用户登录
     */
    @PostMapping(value = "login")
    public ResponseEntity<Result> doLogin(@RequestBody Map map , HttpServletRequest request , HttpServletResponse response){

        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("登录方法开始，接收客户 端参数为：" + map.toString() + "客户端携带的Token值为：" + request.getHeader("Token") );
        }

        String userName = (String)map.get("UserName");
        String passWord = (String)map.get("PassWord");
        String accountType = (String)map.get("AccountType");

//        if(StringUtils.isNotBlank(accountType) && accountType.equals(AccountTypeEnum.TenantAccount.getAccountType())){

//            Result<Tenant> r = this.accountService.findTenantByUserNameAndPassWord(userName, passWord);
//
//            if(r.getData() == null){
//                return ResponseEntity.status(HttpStatus.OK).body(r);
//            }
//            //给客户端生成token
//            Tenant t = r.getData();
//            String jwt = JwtHelperUtil.createJWT(t.getId(), t.getTenantid(), t.getTenantname(), t.getMobile(), accountType, audience.getExpiresSecond(), audience.getBase64Secret());
//            response.setHeader("jwt_token",jwt);
//            response.addHeader("Access-Control-Expose-Headers","jwt_token");
//            return ResponseEntity.status(HttpStatus.OK).body(r);

//        }else if(StringUtils.isNotBlank(accountType) && accountType.equals(AccountTypeEnum.UserAccount.getAccountType())){

//            Result<User> r = this.accountService.findUserByUserNameAndPassWord(userName, passWord);
//
//
//            if(r.getData() == null){
//                return ResponseEntity.status(HttpStatus.OK).body(r);
//            }
//            /**
//             * 未完成  可能用户角色登录需要在token中添加权限或者角色信息，需要重新定义JWT生成规则
//             */
//            //给客户端生成token
//            User u = r.getData();
//            String jwt = JwtHelperUtil.createJWT(u.getId(), u.getUserid(), u.getUsername(), u.getMobile(), accountType, audience.getExpiresSecond(), audience.getBase64Secret());
//            response.setHeader("jwt_token",jwt);
//            response.addHeader("Access-Control-Expose-Headers","jwt_token");
//            return ResponseEntity.status(HttpStatus.OK).body(r);
//        }else {
//           Result r = ResultUtil.error(ResultEnum.PARAM_ERROR);
//           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(r);
//        }
        return null;
    }
}
