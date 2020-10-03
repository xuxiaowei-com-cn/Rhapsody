package cn.com.xuxiaowei.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 公共 HTTP RestController
 *
 * @author xuxiaowei
 */
@RestController
@RequestMapping("/common")
public class CommonRestController {

    /**
     * 公共 HTTP
     *
     * @param request  请求
     * @param response 响应
     * @return 返回 公共 HTTP 响应结果
     */
    @RequestMapping
    public Map<String, Object> common(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>(4);
        Map<String, Object> data = new HashMap<>(4);
        map.put("data", data);

        data.put("now", LocalDateTime.now().toString());

        map.put("CODE", 0);
        map.put("msg", "请求成功");

        return map;
    }

}
