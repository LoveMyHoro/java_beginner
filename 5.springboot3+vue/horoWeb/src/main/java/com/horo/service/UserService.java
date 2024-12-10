package com.horo.service;

import com.horo.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.horo.utils.Result;
import com.horo.vo.UpdatePwdVo;

/**
* @author iove
* @description 针对表【user】的数据库操作Service
* @createDate 2024-11-11 10:23:09
*/
public interface UserService extends IService<User> {

    Result register(User user);

    Result login(User user);

	Result getUserInfo(int id);

	Result updatePwd(UpdatePwdVo updatePwdVo);

	Result sendMaill(String mail);
}
