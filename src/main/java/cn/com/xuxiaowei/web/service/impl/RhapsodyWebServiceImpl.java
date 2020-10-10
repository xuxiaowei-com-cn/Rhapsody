package cn.com.xuxiaowei.web.service.impl;

import cn.com.xuxiaowei.web.service.RhapsodyWebService;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

/**
 * Rhapsody WebService 实现类
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Service
@WebService(targetNamespace = "http://xuxiaowei.com.cn")
public class RhapsodyWebServiceImpl implements RhapsodyWebService {

    /**
     * Rhapsody WebService 测试方法
     *
     * @param username 测试参数，用户名
     * @return 测试结果
     */
    @Override
    public String hiWebService(String username) {

        String response;

        if (username == null || "".equals(username)) {
            response = "请输入用户名";
        } else {
            response = "你好：" + username;
        }

        return response;
    }

}
