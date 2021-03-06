package cn.jannal.spring.tag.handler;

import cn.jannal.spring.tag.pojo.RpcService;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class RpcServicePublishBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {


    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String contact = element.getAttribute("contact");
        String serviceName = element.getAttribute("serviceName");
        String serviceImplName = element.getAttribute("serviceImplName");
        if (StringUtils.hasText(contact)){
            builder.addPropertyValue("contact", contact);
        }

        if (StringUtils.hasText(serviceName)){
            builder.addPropertyValue("serviceName", serviceName);
        }

        if (StringUtils.hasText(serviceImplName)){
            builder.addPropertyValue("serviceImplName", serviceImplName);
        }
    }

    @Override
    protected Class<?> getBeanClass(Element element) {
        return RpcService.class;
    }

    @Override
    protected String getBeanClassName(Element element) {
        return RpcService.class.getSimpleName();
    }

}