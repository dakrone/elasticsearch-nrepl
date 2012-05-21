package org.writequit.elasticsearch.nrepl;

import clojure.lang.*;
import org.elasticsearch.common.component.AbstractComponent;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.internal.InternalNode;

import java.util.Random;

/**
 * @author dakrone
 */
public class EmbeddedNREPLHandler extends AbstractComponent {
    private final boolean enabled = true;
    public final String internalNode;

    private boolean alreadyStarted = false;

    private final Keyword portKW;

    @Inject
    public EmbeddedNREPLHandler(Settings settings) {
        super(settings);
        this.portKW = (Keyword) RT.var("clojure.core", "keyword").invoke("port");
        // TODO: bind this to a useful object
        this.internalNode = "this will hopefully be an internalNode someday";
    }

    public void startupNREPL() {
        Random r = new Random(System.currentTimeMillis());
        int portNum = r.nextInt(1000) + 9400;
        logger.info("startupNREPL {} {}", this.enabled, this.alreadyStarted);
        if (this.enabled && !this.alreadyStarted) {
            logger.info("starting nREPL on port {}", portNum);
            RT.var("clojure.core", "require").invoke(Symbol.intern("clojure.tools.nrepl.server"));
            RT.var("clojure.tools.nrepl.server", "start-server").invoke(portKW, portNum);
            Var.intern(Namespace.findOrCreate(Symbol.intern("user")), Symbol.intern("node"), this.internalNode);
            this.alreadyStarted = true;
        } else {
            logger.info("not starting nREPL, enabled: {}, alreadyStarted: {}", this.enabled, this.alreadyStarted);
        }
    }
}
