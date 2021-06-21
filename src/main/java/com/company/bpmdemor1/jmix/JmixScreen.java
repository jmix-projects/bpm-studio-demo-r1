package com.company.bpmdemor1.jmix;

import com.vaadin.ui.Button;
import io.jmix.bpmui.processform.ProcessFormContext;
import io.jmix.bpmui.processform.annotation.ProcessForm;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

@ProcessForm
@UiController("JmixScreen")
@UiDescriptor("jmix-screen.xml")
public class JmixScreen extends Screen {
    @Autowired
    ProcessFormContext processFormContext;

    @Subscribe("commitAndCloseBtn")
    public void onCommitAndCloseBtnClick(Button.ClickEvent event) {
        processFormContext.taskCompletion().complete();
        closeWithDefaultAction();
    }

    @Subscribe("closeBtn")
    public void onCloseBtnClick(Button.ClickEvent event) {
        closeWithDefaultAction();
    }

}