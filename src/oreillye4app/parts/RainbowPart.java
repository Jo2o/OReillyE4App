package oreillye4app.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class RainbowPart {
    private static final String[] rainbowColors = {"Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet"};

    @Inject
    private ESelectionService selectionService;

    @PostConstruct
    public void create(Composite parent) {
        ListViewer listViewer = new ListViewer(parent, SWT.NONE);
        listViewer.setContentProvider(new ArrayContentProvider());
        listViewer.setInput(rainbowColors);
        listViewer.addSelectionChangedListener(event -> selectionService.setSelection(event.getSelection()));
    }
}
