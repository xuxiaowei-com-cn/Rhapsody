package cn.com.xuxiaowei.web.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Rhapsody WebService 接口
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@WebService
public interface RhapsodyWebService {

    /**
     * Rhapsody WebService 测试方法
     *
     * @param username 测试参数，用户名
     * @return 测试结果
     */
    @WebMethod
    String hiWebService(@WebParam(name = "username") String username);

}
