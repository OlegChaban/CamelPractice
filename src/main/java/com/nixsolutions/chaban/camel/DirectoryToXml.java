package com.nixsolutions.chaban.camel;

import com.nixsolutions.chaban.camel.component.CustomComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Created by chaban on 22.05.15.
 */
public class DirectoryToXml {

    private Boolean sleep = true;

    public void run(final String directoryPath,final
            String fileName) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addComponent("toXml",new CustomComponent());
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("toXml:" + directoryPath)
                           .process(new Processor() {
                            @Override
                            public void process(Exchange exchange)
                                    throws Exception {
                                sleep = false;
                            }
                        })
                        .to("file:?fileName=" + fileName);
            }
        });
        context.start();
        while(sleep){
            Thread.sleep(100);
        }
        context.stop();
    }
}
