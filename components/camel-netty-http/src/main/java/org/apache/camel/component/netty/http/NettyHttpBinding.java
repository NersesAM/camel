/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.netty.http;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.spi.HeaderFilterStrategy;
import org.jboss.netty.handler.codec.http.HttpRequest;
import org.jboss.netty.handler.codec.http.HttpResponse;

/**
 * To bind Netty http codec with the Camel {@link org.apache.camel.Message} api.
 */
public interface NettyHttpBinding {

    /**
     * Binds from Netty {@link HttpRequest} to Camel {@Message}.
     *
     * @param request   the netty http request
     * @param exchange  the exchange that should contain the returned message.
     * @return the message to store on the given exchange
     * @throws Exception is thrown if error during binding
     */
    Message toCamelMessage(HttpRequest request, Exchange exchange) throws Exception;

    /**
     * Binds from Camel {@link Message} to Netty {@link HttpResponse}.
     *
     * @param message  the Camel message
     * @return the http response
     * @throws Exception is thrown if error during binding
     */
    HttpResponse fromCamelMessage(Message message) throws Exception;

    /**
     * Gets the header filter strategy
     *
     * @return the strategy
     */
    HeaderFilterStrategy getHeaderFilterStrategy();

    /**
     * Sets the header filter strategy to use.
     *
     * @param headerFilterStrategy the custom strategy
     */
    void setHeaderFilterStrategy(HeaderFilterStrategy headerFilterStrategy);

}