package org.writequit.elasticsearch.nrepl;

import clojure.lang.Keyword;
import clojure.lang.RT;
import clojure.lang.Symbol;
import org.elasticsearch.common.component.AbstractComponent;
import org.elasticsearch.common.settings.Settings;

/**
 * @author dakrone
 */
public class EmbeddedNREPLHandler extends AbstractComponent {
    private final boolean enabled = true;

    private boolean alreadyStarted = false;

    private final Keyword portKW;

    public EmbeddedNREPLHandler(Settings settings) {
        super(settings);
        this.portKW = (Keyword) RT.var("clojure.core", "keyword").invoke("port");
    }

    public void startupNREPL() {
        if (this.enabled && !this.alreadyStarted) {
            logger.info("starting nREPL on port 8200");
            RT.var("clojure.core", "require").invoke(Symbol.intern("clojure.tools.nrepl.server"));
            RT.var("clojure.tools.nrepl.server", "start-server").invoke(portKW, 8200);
            this.alreadyStarted = true;
        } else {
            logger.info("not starting nREPL, enabled: {}, alreadyStarted: {}", this.enabled, this.alreadyStarted);
        }
    }
}
