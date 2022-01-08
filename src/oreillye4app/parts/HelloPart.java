package oreillye4app.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloPart {
    private static final Logger log = LoggerFactory.getLogger(HelloPart.class);

    @Inject
    private MWindow window;
    @Inject
    private UISynchronize uiSynchronize;

    private Label label;
    private Button button;

    @PostConstruct
    public void create(Composite parent) {
        createLabel(parent);
        log.error("Label created...");
        createButton(parent);
        log.error("Button created...");
    }

    @Focus
    public void focus() {
        label.setFocus();
    }

    @Inject
    @Optional
    public void receiveEvent(@UIEventTopic(RainbowPart.RAINBOW_COLOR) String data) {
        label.setText(data);
    }

    private void createLabel(Composite parent) {
        label = new Label(parent, SWT.NONE);
        label.setText(window.getLabel());
    }

    private void createButton(Composite parent) {
        button = new Button(parent, SWT.NONE);
        button.setText("DO NOT PUSH!");

        button.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                button.setEnabled(false);

                new Job("Button Push Job") {
                    @Override
                    protected IStatus run(IProgressMonitor progressMonitor) {
                        // button.setEnabled(true); // this has to be run on UI thread!!!
                        // => Display.getDefault().syncExec(() -> button.setEnabled(true));
                        uiSynchronize.asyncExec(() -> button.setEnabled(true));
                        return Status.OK_STATUS;
                    }
                }
                .schedule(3000);

            }
            @Override
            public void widgetDefaultSelected(SelectionEvent event) {
            }
        });
    }

    // @Inject
    // @Optional
    // public void setSelection(@Named(IServiceConstants.ACTIVE_SELECTION) Object selection) {
    // if (nonNull(selection)) {
    // label.setText(selection.toString());
    // }
    // }
}
