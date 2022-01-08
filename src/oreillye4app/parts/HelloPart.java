package oreillye4app.parts;

import javax.annotation.PostConstruct;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloPart {

    private static final Logger log = LoggerFactory.getLogger(HelloPart.class);

    private Label label;

    @PostConstruct
    public void create(Composite parent) {
        label = new Label(parent, SWT.NONE);
        label.setText("Hello");
        log.error("Hello {}", 5);
    }

    @Focus
    public void focus() {
        label.setFocus();
    }
}
