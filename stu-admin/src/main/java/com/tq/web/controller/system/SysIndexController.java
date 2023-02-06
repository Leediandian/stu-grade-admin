package com.tq.web.controller.system;

import com.tq.common.config.TqConfig;
import com.tq.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页
 *
 * @author tq
 */
@RestController
public class SysIndexController
{
    /** 系统基础配置 */
    @Autowired
    private TqConfig tqConfig;

    /**
     * 访问首页，提示语
     */
    @RequestMapping("/")
    public String index()
    {
        return StringUtils.format("欢迎使用{}后台管理框架，当前版本：v{}，请通过前端地址访问。", tqConfig.getName(), tqConfig.getVersion());
    }
}
