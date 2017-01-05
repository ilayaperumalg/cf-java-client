/*
 * Copyright 2013-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cloudfoundry.client.v2.organizations;

import org.cloudfoundry.Nullable;
import org.cloudfoundry.client.v2.InFilterParameter;
import org.cloudfoundry.client.v2.PaginatedRequest;
import org.immutables.value.Value;

import java.util.List;

/**
 * The request payload for the List Organizations operation
 */
@Value.Immutable
abstract class _ListOrganizationsRequest extends PaginatedRequest {

    /**
     * The auditor ids
     */
    @InFilterParameter("auditor_guid")
    @Nullable
    abstract List<String> getAuditorIds();

    /**
     * The billing manager ids
     */
    @InFilterParameter("billing_manager_guid")
    @Nullable
    abstract List<String> getBillingManagerIds();

    /**
     * The manager ids
     */
    @InFilterParameter("manager_guid")
    @Nullable
    abstract List<String> getManagerIds();

    /**
     * The names
     */
    @InFilterParameter("name")
    @Nullable
    abstract List<String> getNames();

    /**
     * The space ids
     */
    @InFilterParameter("space_guid")
    @Nullable
    abstract List<String> getSpaceIds();

    /**
     * The statuses
     */
    @InFilterParameter("status")
    @Nullable
    abstract List<String> getStatuses();

    /**
     * The user ids
     */
    @InFilterParameter("user_guid")
    @Nullable
    abstract List<String> getUserIds();

}
