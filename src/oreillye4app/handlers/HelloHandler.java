package oreillye4app.handlers;

import javax.inject.Named;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloHandler {
    private static final Logger log = LoggerFactory.getLogger(HelloHandler.class);

    @Execute
    public void hello(
            @Named(IServiceConstants.ACTIVE_SHELL) Shell shell,
            @Optional @Named("oreillye4app.commandparameter.hellovalue") String helloValue) {
        log.info("Hello from Handler!");
        MessageDialog.openInformation(shell, "Hello", "Welcome . . .\n" + helloValue);
    }
}
