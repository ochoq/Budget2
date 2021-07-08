package com.company.budget2.web.screens.iprb;

import com.company.budget2.entity.demand.CloseEvent;
import com.company.budget2.entity.demand.IPRB;
import com.company.budget2.entity.demand.Topic;
import com.company.budget2.web.screens.topic.TopicFragment;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Fragments;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.TextInputField;
import com.haulmont.cuba.gui.components.VBoxLayout;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.ScreenFragment;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;

import javax.inject.Inject;
import java.util.stream.Collectors;

@UiController("budget2_IprbFragment")
@UiDescriptor("iprb-fragment.xml")
public class IprbFragment extends ScreenFragment {
    private static final Logger log = LoggerFactory.getLogger(IprbFragment.class);
    @Inject
    private InstanceContainer<IPRB> iPRBDc;
    @Inject
    private Fragments fragments;

    private boolean changeMode = false;

    @Inject
    private DataManager dm;
    @Inject
    private CollectionLoader<Topic> topicsDl;
    @Inject
    private CollectionContainer<Topic> topicsDc;
    @Inject
    private VBoxLayout topicList;

    public void changeMode(boolean mode) {
        changeMode = mode;
    }

   public void setItem(IPRB iprb) {
       iPRBDc.setItem(iprb);
       // get the list of children
       topicsDl.setQuery("select t from budget2_Topic t WHERE t.iprb = :iprb");
       topicsDl.setParameter("iprb", iprb);
       topicsDl.load();
       log.info("nb of children for " + iprb.getIcTag() + " : " + topicsDc.getItems().size());
       // add the list of children
       for (Topic topic: topicsDc.getItems()) {
           TopicFragment basic = fragments.create(this,TopicFragment.class);
           topicList.add(basic.getFragment(),0);
           basic.setItem(topic);
       }
   }


    @Subscribe("q1")
    public void onQ1ValueChange(HasValue.ValueChangeEvent<Integer> event) {
        if(changeMode) {
            dm.commit(iPRBDc.getItem());
            log.info("saved");
        }
    }

    public void onToggleViewClick() {
        topicList.setVisible(!topicList.isVisible());
    }

    public void onAddTopicClick() {
        // add a new Topic to the current IPRB
        Topic topic = dm.create(Topic.class);
        topic.setIprb(iPRBDc.getItem());
        dm.commit(topic);
        // add it to the screen
        TopicFragment basic = fragments.create(this,TopicFragment.class);
        topicList.add(basic.getFragment(),0);
        basic.setItem(topic);
    }

    @Order(10)
    @EventListener
    public void onApplicationEvent(CloseEvent event) {
        TopicFragment frag = (TopicFragment) event.getSource();
        Topic topic = frag.getItem();
        dm.remove(topic);
        topicList.remove(frag.getFragment());

    }
}