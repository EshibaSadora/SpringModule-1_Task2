package org.example.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class CustomPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishCustomEvent(String message) {
        applicationEventPublisher.publishEvent(new CustomEvent(Thread.currentThread().getStackTrace()[2].getMethodName(), message));
    }

}
