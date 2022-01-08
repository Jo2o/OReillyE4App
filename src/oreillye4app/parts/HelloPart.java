package oreillye4app.parts;

import static java.util.Objects.nonNull;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloPart {
    private static final Logger log = LoggerFactory.getLogger(HelloPart.class);

    @Inject
    private MWindow window;

    private Label label;

    @PostConstruct
    public void create(Composite parent) {
        label = new Label(parent, SWT.NONE);
        label.setText(window.getLabel());
        log.error("Hello {}", 5);
    }

    @Focus
    public void focus() {
        label.setFocus();
    }

    @Inject
    @Optional
    public void setSelection(@Named(IServiceConstants.ACTIVE_SELECTION) Object selection) {
        if (nonNull(selection)) {
            label.setText(selection.toString());
        }
    }
}
