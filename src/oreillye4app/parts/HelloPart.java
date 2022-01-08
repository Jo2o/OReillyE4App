package oreillye4app.parts;

import javax.annotation.PostConstruct;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class HelloPart {

    private Label label;

    @PostConstruct
    public void create(Composite parent) {
        label = new Label(parent, SWT.NONE);
        label.setText("Hello");
    }

    @Focus
    public void focus() {
        label.setFocus();
    }
}
