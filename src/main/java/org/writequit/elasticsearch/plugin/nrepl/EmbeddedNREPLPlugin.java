package org.writequit.elasticsearch.plugin.nrepl;

import org.elasticsearch.plugins.AbstractPlugin;

/**
 * @author dakrone
 */
public class EmbeddedNREPLPlugin extends AbstractPlugin {
    @Override
    public String name() {
        return "nREPL";
    }

    @Override
    public String description() {
        return "An embedded nREPL server inside of ElasticSearch";
    }
}
