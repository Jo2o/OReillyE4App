package oreillye4app.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloHandler {
    private static final Logger log = LoggerFactory.getLogger(HelloHandler.class);

    @Execute
    public void hello() {
        log.info("Hello from Handler!");
    }
}
