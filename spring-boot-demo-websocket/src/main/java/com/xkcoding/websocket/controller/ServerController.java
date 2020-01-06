package com.xkcoding.websocket.controller;

import cn.hutool.core.lang.Dict;
import com.xkcoding.websocket.model.Server;
import com.xkcoding.websocket.payload.ServerVO;
import com.xkcoding.websocket.util.ServerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 服务器监控Controller
 * </p>
 *
 * @package: com.xkcoding.websocket.controller
 * @description: 服务器监控Controller
 * @author: yangkai.shen
 * @date: Created in 2018-12-17 10:22
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@RestController
@RequestMapping("/server")
@Slf4j
public class ServerController {

    @GetMapping
    public Dict serverInfo() throws Exception {
        Server server = new Server();
        server.copyTo();
        ServerVO serverVO = ServerUtil.wrapServerVO(server);
        return ServerUtil.wrapServerDict(serverVO);
    }
  @MessageMapping("/change-notice")
  public void greeting(String value){
    log.info("收到的消息"+value);
  }
}
