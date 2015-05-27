package com.nixsolutions.chaban.camel.component;

import java.util.Map;

import com.nixsolutions.chaban.camel.endpoint.CustomEndpoint;
import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultComponent;

/**
 * Created by chaban on 22.05.15.
 */
public class CustomComponent extends DefaultComponent {

    @Override
    protected Endpoint createEndpoint(String uri, String remaining,
            Map<String, Object> params) throws Exception {
        Endpoint endpoint = new CustomEndpoint(remaining, uri, this);
        return endpoint;
    }
}
