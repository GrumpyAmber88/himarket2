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

package com.alibaba.apiopenplatform.core.advice;

import cn.hutool.json.JSONUtil;
import com.alibaba.apiopenplatform.core.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 统一响应处理
 * <p>
 * 用于封装接口响应数据为统一格式：
 * {
 * "code": "Success",
 * "message": "操作成功",
 * "data": T
 * }
 * <p>
 * 以下情况不会被包装:
 * 1. 返回值已经是 {@link ResponseEntity}
 * 2. 返回值已经是 {@link Response}
 *
 */
@RestControllerAdvice
@Slf4j
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 排除Swagger相关路径
        Class<?> declaringClass = returnType.getDeclaringClass();
        if (declaringClass.getName().contains("org.springdoc") ||
                declaringClass.getName().contains("springfox.documentation")) {
            return false;
        }

        return !returnType.getParameterType().equals(ResponseEntity.class)
                && !returnType.getParameterType().equals(Response.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        // 设置成功响应码
        response.setStatusCode(HttpStatus.OK);

        if (body instanceof String) {
            return JSONUtil.toJsonStr(Response.ok(body));
        }
        return Response.ok(body);
    }
}
