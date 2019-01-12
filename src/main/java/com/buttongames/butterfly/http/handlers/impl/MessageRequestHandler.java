package com.buttongames.butterfly.http.handlers.impl;

import com.buttongames.butterfly.http.exception.InvalidRequestMethodException;
import com.buttongames.butterfly.http.handlers.BaseRequestHandler;
import com.buttongames.butterfly.xml.KXmlBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.w3c.dom.Element;
import spark.Request;
import spark.Response;

/**
 * Handler for any requests that come to the <code>message</code> module.
 * @author skogaby (skogabyskogaby@gmail.com)
 */
@Component
public class MessageRequestHandler extends BaseRequestHandler {

    private final Logger LOG = LogManager.getLogger(MessageRequestHandler.class);

    /**
     * Handles an incoming request for the <code>message</code> module.
     * @param requestBody The XML document of the incoming request.
     * @param request The Spark request
     * @param response The Spark response
     * @return A response object for Spark
     */
    @Override
    public Object handleRequest(final Element requestBody, final Request request, final Response response) {
        final String requestMethod = request.attribute("method");

        if (requestMethod.equals("get")) {
            return handleGetRequest(request, response);
        } else {
            throw new InvalidRequestMethodException();
        }
    }

    /**
     * Handles an incoming request for <code>message.get</code>
     * @param request The Spark request
     * @param response The Spark response
     * @return A response object for Spark
     */
    private Object handleGetRequest(final Request request, final Response response) {
        // TODO: Remove all the hardcoded stuff and actually do something with the input
        KXmlBuilder respBuilder = KXmlBuilder.create("response")
                .e("message").a("expire", "1800").a("status", "0")
                    .e("item").a("end", "604800").a("name", "sys.mainte").a("start", "0").up()
                    .e("item").a("end", "604800").a("name", "sys.eacoin.mainte").a("start", "0");

        return this.sendResponse(request, response, respBuilder);
    }
}