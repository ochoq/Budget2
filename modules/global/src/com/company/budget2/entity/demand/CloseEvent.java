package com.company.budget2.entity.demand;

import com.haulmont.cuba.gui.events.UiEvent;
import org.springframework.context.ApplicationEvent;

public class CloseEvent extends ApplicationEvent implements UiEvent {
    public CloseEvent(Object source) {
        super(source);
    }
}
