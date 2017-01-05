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

package org.cloudfoundry.client.v2.organizationquotadefinitions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.cloudfoundry.Nullable;
import org.immutables.value.Value;

/**
 * The request payload for the Updating an Organization Quota Definition operation
 */
@Value.Immutable
abstract class _UpdateOrganizationQuotaDefinitionRequest {

    /**
     * The application instance limit
     */
    @JsonProperty("app_instance_limit")
    @Nullable
    abstract Integer getApplicationInstanceLimit();

    /**
     * The application task limit
     */
    @JsonProperty("app_task_limit")
    @Nullable
    abstract Integer getApplicationTaskLimit();

    /**
     * The instance memory limit
     */
    @JsonProperty("instance_memory_limit")
    @Nullable
    abstract Integer getInstanceMemoryLimit();

    /**
     * The memory limit
     */
    @JsonProperty("memory_limit")
    @Nullable
    abstract Integer getMemoryLimit();

    /**
     * The name
     */
    @JsonProperty("name")
    @Nullable
    abstract String getName();

    /**
     * The non basic services allowed
     */
    @JsonProperty("non_basic_services_allowed")
    @Nullable
    abstract Boolean getNonBasicServicesAllowed();

    /**
     * The quota definition id
     */
    @JsonIgnore
    abstract String getOrganizationQuotaDefinitionId();

    /**
     * The total private domains
     */
    @JsonProperty("total_private_domains")
    @Nullable
    abstract Integer getTotalPrivateDomains();

    /**
     * The total routes
     */
    @JsonProperty("total_routes")
    @Nullable
    abstract Integer getTotalRoutes();

    /**
     * The total service keys
     */
    @JsonProperty("total_service_keys")
    @Nullable
    abstract Integer getTotalServiceKeys();

    /**
     * The total services
     */
    @JsonProperty("total_services")
    @Nullable
    abstract Integer getTotalServices();

    /**
     * The trial db allowed
     */
    @Deprecated
    @JsonProperty("trial_db_allowed")
    @Nullable
    abstract Boolean getTrialDatabaseAllowed();

}
