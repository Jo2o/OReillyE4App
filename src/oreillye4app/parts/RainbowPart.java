package oreillye4app.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class RainbowPart {
    public static final String RAINBOW_COLOR = "rainbow/color";

    private static final String[] rainbowColors = {"Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet"};

    // @Inject private ESelectionService selectionService;

    @Inject
    private IEventBroker eventBroker;

    @PostConstruct
    public void create(Composite parent) {
        ListViewer listViewer = new ListViewer(parent, SWT.NONE);
        listViewer.setContentProvider(new ArrayContentProvider());
        listViewer.setInput(rainbowColors);
        // listViewer.addSelectionChangedListener(event->selectionService.setSelection(event.getSelection()));
        listViewer.addSelectionChangedListener(this::setSelection);
    }

    public void setSelection(SelectionChangedEvent event) {
        Object color = event.getStructuredSelection().getFirstElement();
        eventBroker.post(RAINBOW_COLOR, color);
    }
}
