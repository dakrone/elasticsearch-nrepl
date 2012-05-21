package org.writequit.elasticsearch.plugin.nrepl;

import org.elasticsearch.common.collect.ImmutableList;
import org.elasticsearch.common.inject.Module;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.plugins.AbstractPlugin;
import org.writequit.elasticsearch.nrepl.EmbeddedNREPLModule;

import java.util.Collection;

/**
 * @author dakrone
 */
public class EmbeddedNREPLPlugin extends AbstractPlugin {
    private final Settings settings;

    public EmbeddedNREPLPlugin(Settings settings) {
        this.settings = settings;
    }

    @Override
    public String name() {
        return "nREPL";
    }

    @Override
    public String description() {
        return "An embedded nREPL server inside of ElasticSearch";
    }

    @Override public Settings additionalSettings() {
        return super.additionalSettings();
    }

    @Override
    public Collection<Class<? extends Module>> modules() {
        return ImmutableList.<Class<? extends Module>>of(EmbeddedNREPLModule.class);
    }

}
