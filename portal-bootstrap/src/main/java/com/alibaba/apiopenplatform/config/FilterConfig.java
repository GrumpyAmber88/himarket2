/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.alibaba.apiopenplatform.config;

import com.alibaba.apiopenplatform.core.security.ContextHolder;
import com.alibaba.apiopenplatform.filter.PortalResolvingFilter;
import com.alibaba.apiopenplatform.service.PortalService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
@RequiredArgsConstructor
public class FilterConfig {

    private final PortalService portalService;

    private final ContextHolder contextHolder;

    @Bean
    public FilterRegistrationBean<PortalResolvingFilter> portalResolvingFilter() {
        FilterRegistrationBean<PortalResolvingFilter> registrationBean = new FilterRegistrationBean<>();

        PortalResolvingFilter filter = new PortalResolvingFilter(portalService, contextHolder);
        registrationBean.setFilter(filter);
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }
}
