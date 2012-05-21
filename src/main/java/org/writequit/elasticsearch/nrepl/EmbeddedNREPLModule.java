package org.writequit.elasticsearch.nrepl;

import org.elasticsearch.common.inject.AbstractModule;
import org.elasticsearch.common.settings.Settings;

/**
 * @author dakrone
 */
public class EmbeddedNREPLModule extends AbstractModule {


    private final Settings componentSettings;

    public EmbeddedNREPLModule(Settings settings) {
        this.componentSettings = settings.getComponentSettings(this.getClass());
    }

    @Override
    protected void configure() {
        bind(EmbeddedNREPLHandler.class).asEagerSingleton();

        EmbeddedNREPLHandler handler = new EmbeddedNREPLHandler(this.componentSettings);
        handler.startupNREPL();
    }
}
