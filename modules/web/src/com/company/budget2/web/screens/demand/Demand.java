package com.company.budget2.web.screens.demand;

import com.company.budget2.entity.demand.IPRB;
import com.company.budget2.web.screens.iprb.IprbFragment;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Fragments;
import com.haulmont.cuba.gui.components.Fragment;
import com.haulmont.cuba.gui.components.ScrollBoxLayout;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;

@LoadDataBeforeShow
@UiController("budget2_Demand")
@UiDescriptor("demand.xml")
public class Demand extends Screen {
    private static final Logger log = LoggerFactory.getLogger(Demand.class);
    @Inject
    private CollectionContainer<IPRB> iPRBsDc;
    @Inject
    private ScrollBoxLayout demand;
    @Inject
    private Fragments fragments;
    @Inject
    private CollectionLoader<IPRB> iPRBsDl;
    @Inject
    private DataManager dm;


    @Subscribe
    public void onInit(InitEvent event) {
        refreshScreen();
    }

    public void refreshScreen() {
        demand.removeAll();
        iPRBsDl.load();
        for (IPRB iprb: iPRBsDc.getItems()) {
            addItemToDispaly(iprb);
        }
    }

    private void addItemToDispaly(IPRB iprb) {
        IprbFragment basic = fragments.create(this, IprbFragment.class);
        basic.changeMode(false);
        // basic.init();
        demand.add(basic.getFragment(),0);
        basic.setItem(iprb);
        basic.changeMode(true);
    }

    public void onAddIPRBClick() {
        IPRB iprb = dm.create(IPRB.class);
        iprb.setIcTag("to add");
        dm.commit(iprb);
        addItemToDispaly(iprb);
    }
}