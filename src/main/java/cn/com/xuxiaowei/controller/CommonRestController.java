package cn.com.xuxiaowei.controller;

import cn.com.xuxiaowei.util.RequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static cn.com.xuxiaowei.util.Constants.*;

/**
 * 公共 HTTP RestController
 *
 * @author xuxiaowei
 */
@Slf4j
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

        log.info("请求参数：{}", RequestUtils.keyValue(request));

        try {
            log.info("请求流：{}", RequestUtils.getInputStream(request));
        } catch (IOException e) {
            log.error("获取请求流异常");
            log.error(e.getMessage(), e);
        }

        Map<String, Object> map = new HashMap<>(4);
        Map<String, Object> data = new HashMap<>(4);
        map.put(DATA, data);

        data.put("now", LocalDateTime.now().toString());

        map.put(CODE, CODE_OK);
        map.put(MSG, "请求成功");

        return map;
    }

}
