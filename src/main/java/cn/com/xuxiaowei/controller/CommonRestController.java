package cn.com.xuxiaowei.controller;

import cn.com.xuxiaowei.util.RequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
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
     * 公共 HTTP 1
     *
     * @param request  请求
     * @param response 响应
     * @return 返回 公共 HTTP 1 响应结果
     */
    @RequestMapping("/1")
    public Map<String, Object> common1(HttpServletRequest request, HttpServletResponse response) {

        log.info("请求参数 1：{}", RequestUtils.keyValue(request));

        try {
            log.info("请求流 1：{}", RequestUtils.getInputStream(request));
        } catch (IOException e) {
            log.error("获取请求流异常 1");
            log.error(e.getMessage(), e);
        }

        Map<String, Object> map = new HashMap<>(4);
        Map<String, Object> data = new HashMap<>(4);
        map.put(DATA, data);

        data.put("now 1", LocalDateTime.now().toString());

        map.put(CODE, CODE_OK);
        map.put(MSG, "请求成功 1");

        return map;
    }

    /**
     * 公共 HTTP 2
     *
     * @param request  请求
     * @param response 响应
     * @return 返回 公共 HTTP 2 响应结果
     */
    @RequestMapping("/2")
    public Map<String, Object> common2(HttpServletRequest request, HttpServletResponse response) {

        log.info("请求参数 2：{}", RequestUtils.keyValue(request));

        try {
            log.info("请求流 2：{}", RequestUtils.getInputStream(request));
        } catch (IOException e) {
            log.error("获取请求流异常 2");
            log.error(e.getMessage(), e);
        }

        Map<String, Object> map = new HashMap<>(4);
        Map<String, Object> data = new HashMap<>(4);
        map.put(DATA, data);

        data.put("now 2", LocalDateTime.now().toString());

        map.put(CODE, CODE_OK);
        map.put(MSG, "请求成功 2");

        return map;
    }

    /**
     * 公共 HTTP 3
     *
     * @param request  请求
     * @param response 响应
     * @param a        地址参数
     * @return 返回 公共 HTTP 3 响应结果
     */
    @RequestMapping("/path/{a}")
    public Map<String, Object> commonPath(HttpServletRequest request, HttpServletResponse response, @PathVariable("a") String a) {

        log.info("请求参数 {}：{}", a, RequestUtils.keyValue(request));

        try {
            log.info("请求流 {}：{}", a, RequestUtils.getInputStream(request));
        } catch (IOException e) {
            log.error("获取请求流异常 {}", a);
            log.error(e.getMessage(), e);
        }

        Map<String, Object> map = new HashMap<>(4);
        Map<String, Object> data = new HashMap<>(4);
        map.put(DATA, data);

        data.put("now " + a, LocalDateTime.now().toString());

        map.put(CODE, CODE_OK);
        map.put(MSG, "请求成功 " + a);

        return map;
    }

}
