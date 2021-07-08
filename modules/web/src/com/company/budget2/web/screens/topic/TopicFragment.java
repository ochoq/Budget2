package com.company.budget2.web.screens.topic;

import com.company.budget2.entity.demand.CloseEvent;
import com.company.budget2.entity.demand.Topic;
import com.haulmont.cuba.core.global.Events;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.ScreenFragment;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;

@UiController("budget2_TopicFragment")
@UiDescriptor("topic-fragment.xml")
public class TopicFragment extends ScreenFragment {
    @Inject
    private InstanceContainer<Topic> topicDc;
    @Inject
    Events events;

    public void setItem(Topic topic) {
        topicDc.setItem(topic);
    }
    public  Topic getItem() {
        return topicDc.getItem();
    }

    public void onAddTopicClick() {
        // fires the closing event
        events.publish(new CloseEvent(this));
    }
}