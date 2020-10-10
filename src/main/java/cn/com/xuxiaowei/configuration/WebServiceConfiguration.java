package cn.com.xuxiaowei.configuration;

import cn.com.xuxiaowei.web.service.RhapsodyWebService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * WebServices 配置
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Configuration
public class WebServiceConfiguration {

    /**
     * Rhapsody WebService 接口
     */
    private RhapsodyWebService rhapsodyWebService;

    @Autowired
    public void setRhapsodyService(RhapsodyWebService rhapsodyWebService) {
        this.rhapsodyWebService = rhapsodyWebService;
    }

    /**
     * CXF
     */
    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    /**
     * 注册 CXF 前缀 Servlet
     */
    @Bean
    public ServletRegistrationBean<CXFServlet> ws() {
        return new ServletRegistrationBean<>(new CXFServlet(), "/ws/*");
    }

    /**
     * 注册服务：Rhapsody WebService 接口
     */
    @Bean
    public Endpoint rhapsodyServiceEndpoint() {
        EndpointImpl rhapsodyWebServiceImpl = new EndpointImpl(springBus(), rhapsodyWebService);
        rhapsodyWebServiceImpl.publish("/rhapsodyWebService");
        return rhapsodyWebServiceImpl;
    }

}
