/*
*  Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.wso2.carbon.event.output.adapter.cassandra.internal.ds;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.event.output.adapter.core.OutputEventAdapterFactory;
import org.wso2.carbon.event.output.adapter.cassandra.CassandraEventAdapterFactory;

/**
 * @scr.component component.name="output.Cassandra.AdapterService.component" immediate="true"
 */
public class CassandraEventAdapterServiceDS {

    private static final Log log = LogFactory.getLog(CassandraEventAdapterServiceDS.class);

    /**
     * initialize the cassandra service here service here.
     *
     * @param context
     */
    protected void activate(ComponentContext context) {
        try {
            CassandraEventAdapterFactory cassandraEventAdapterFactory = new CassandraEventAdapterFactory();
            context.getBundleContext().registerService(OutputEventAdapterFactory.class.getName(), cassandraEventAdapterFactory, null);
            if (log.isDebugEnabled()) {
                log.debug("Successfully deployed the output cassandra event adaptor service");
            }
        } catch (RuntimeException e) {
            log.error("Can not create the output cassandra event adaptor service ", e);
        }
    }

}