package org.activiti.examples;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.engine.delegate.event.ActivitiEventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * UserTask 定时器事件监听器
 */
@Component
public class UserTaskTimerListener implements ActivitiEventListener {
    private static final Logger logger = LoggerFactory.getLogger(UserTaskTimerListener.class);

    private final ProcessEngine processEngine;
    private int counter = 0;

    @Autowired
    public UserTaskTimerListener(ProcessEngine processEngine) {
        this.processEngine = processEngine;
        processEngine.getRuntimeService().addEventListener(this, ActivitiEventType.TIMER_FIRED);
    }

    @Override
    public void onEvent(ActivitiEvent event) {
        counter++;
        logger.info("timer fired counter={}", counter);
    }

    @Override
    public boolean isFailOnException() {
        return false;
    }
}
