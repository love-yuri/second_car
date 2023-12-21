package com.yuri.second_car.service;

import cn.hutool.core.lang.UUID;
import com.unfbx.sparkdesk.SparkDeskClient;
import com.unfbx.sparkdesk.entity.*;
import com.unfbx.sparkdesk.listener.ChatListener;
import com.yuri.second_car.result.R;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Service
@Slf4j
public class OssService {
    @Autowired
    private CarService carService;
    public R<String> test(String msg) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("接下来你将模拟一个搜索引擎.我会把数据和提问词发给你.请你返回符合我要求的数据.要求返回完整数据就行.别的话不用说.数据: ");
        carService.getAllCarInfo().forEach(e -> stringBuilder.append("id: ").append(e.getId()).append(" 品牌名:").append(e.getBrand_name()).append(" 型号: ").append(e.getModel_name()).append(" "));
//        log.info(carService.getAllCarInfo().toString());
        stringBuilder.append(" 不要日本的车");
        return R.success(spark(stringBuilder.toString()).getData());
    }
    public R<String> spark(String msg) {
        SparkDeskClient sparkDeskClient = SparkDeskClient.builder()
                .host("https://spark-api.xf-yun.com/v3.1/chat")
                .appid("6d17bd0e")
                .apiKey("a06ad13c5a3fcb31e55f64e2305652be")
                .apiSecret("YWVkMjdmYzJkOWM2YmY1ODUwMjgyNDI4")
                .build();
        //构建请求参数
        InHeader header = InHeader.builder().uid(UUID.randomUUID().toString().substring(0, 10)).appid("6d17bd0e").build();
        Parameter parameter = Parameter.builder().chat(Chat.builder().domain("generalv3").maxTokens(2048).temperature(0.3).build()).build();
        List<Text> text = new ArrayList<>();
        text.add(Text.builder().role(Text.Role.USER.getName()).content(msg).build());
        InPayload payload = InPayload.builder().message(Message.builder().text(text).build()).build();
        AIChatRequest aiChatRequest = AIChatRequest.builder().header(header).parameter(parameter).payload(payload).build();

        CountDownLatch countDownLatch = new CountDownLatch(1);
        StringBuilder result = new StringBuilder();
        sparkDeskClient.chat(new ChatListener(aiChatRequest) {
            //异常回调
            @SneakyThrows
            @Override
            public void onChatError(AIChatResponse aiChatResponse) {
                log.warn(String.valueOf(aiChatResponse));
                countDownLatch.countDown();
            }
            //输出回调
            @Override
            public void onChatOutput(AIChatResponse aiChatResponse) {
                List<Text> texts = aiChatResponse.getPayload().getChoices().getText();
                for(Text text: texts) {
                    log.info("text -> {}", text.getContent());
                    result.append(text.getContent());
                }

            }
            //会话结束回调
            @Override
            public void onChatEnd() {
                log.info("chat -> {}", result.toString());
                countDownLatch.countDown();
            }
            //会话结束 获取token使用信息回调
            @Override
            public void onChatToken(Usage usage) {
                System.out.println("token 信息：" + usage);
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        return R.success(result.toString());
    }
}
