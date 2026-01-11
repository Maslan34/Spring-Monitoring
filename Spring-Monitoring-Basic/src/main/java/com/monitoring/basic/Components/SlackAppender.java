package com.monitoring.basic.Components;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class SlackAppender extends AppenderBase<ILoggingEvent> {

    private String webhookUrl;
    private final RestTemplate restTemplate = new RestTemplate();

    public void setWebhookUrl(String webhookUrl) {
        this.webhookUrl = webhookUrl;
    }

    @Override
    protected void append(ILoggingEvent event) {

        if (!event.getLevel().isGreaterOrEqual(ch.qos.logback.classic.Level.ERROR)) {
            return;
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String message = """
                🚨 *SPRING BOOT ERROR*
                *Message:* %s
                *Logger:* %s
                """.formatted(
                event.getFormattedMessage(),
                event.getLoggerName()
        );

        Map<String, String> payload = Map.of("text", message);

        try {
            restTemplate.postForEntity(
                    webhookUrl,
                    new HttpEntity<>(payload, headers),
                    String.class
            );
        } catch (Exception e) {
            addError("Failed Sending Error Message!", e);
        }
    }
}
