package com.nixsolutions.chaban.camel.endpoint;

import com.nixsolutions.chaban.camel.consumer.CustomConsumer;
import org.apache.camel.Component;
import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.impl.DefaultPollingEndpoint;

/**
 * Created by chaban on 22.05.15.
 */
public class CustomEndpoint extends DefaultPollingEndpoint {

    private String directory;

    public CustomEndpoint() {
    }

    public CustomEndpoint(String directory, String uri, Component component) {
        super(uri, component);
        setDirectory(directory);
    }

    @Override
    public Producer createProducer() throws Exception {
        return null;
    }

    @Override
    public Consumer createConsumer(Processor processor) throws Exception {
        Consumer consumer = new CustomConsumer(directory, this, processor);
        configureConsumer(consumer);
        return consumer;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }
}
