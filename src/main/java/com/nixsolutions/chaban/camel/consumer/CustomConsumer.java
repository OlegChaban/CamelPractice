package com.nixsolutions.chaban.camel.consumer;

import java.io.File;

import com.nixsolutions.chaban.camel.beans.Files;
import com.nixsolutions.chaban.camel.beans.Folders;
import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.impl.ScheduledPollConsumer;

/**
 * Created by chaban on 22.05.15.
 */
public class CustomConsumer extends ScheduledPollConsumer {

    private String directory;

    public CustomConsumer(String directory, Endpoint endpoint,
            Processor processor) {
        super(endpoint, processor);
        setDirectory(directory);
    }

    @Override
    protected int poll() throws Exception {
        Exchange exchange = getEndpoint().createExchange();
        exchange.getIn().setBody(getFolder(directory));
        getProcessor().process(exchange);
        return 1;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    private Folders getFolder(String path) {
        File dir = new File(path);
        Folders result = toFolders(dir);
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                result.addFile(toFiles(file));
            } else if (file.isDirectory()&&!file.getName().equals("target")) {
                result.addDirectory(getFolder(file.getAbsolutePath()));
            }
        }
        return result;
    }

    private static Folders toFolders(File file) {
        Folders result = new Folders();
        result.setName(file.getName());
        return result;
    }

    private static Files toFiles(File file) {
        Files result = new Files();
        result.setName(file.getName());
        result.setSize(file.length());
        return result;
    }
}
