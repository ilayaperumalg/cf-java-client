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

package org.cloudfoundry.reactor.client.v2.serviceinstances;

import org.cloudfoundry.client.v2.serviceinstances.BindServiceInstanceToRouteRequest;
import org.cloudfoundry.client.v2.serviceinstances.BindServiceInstanceToRouteResponse;
import org.cloudfoundry.client.v2.serviceinstances.CreateServiceInstanceRequest;
import org.cloudfoundry.client.v2.serviceinstances.CreateServiceInstanceResponse;
import org.cloudfoundry.client.v2.serviceinstances.DeleteServiceInstanceRequest;
import org.cloudfoundry.client.v2.serviceinstances.DeleteServiceInstanceResponse;
import org.cloudfoundry.client.v2.serviceinstances.GetServiceInstancePermissionsRequest;
import org.cloudfoundry.client.v2.serviceinstances.GetServiceInstancePermissionsResponse;
import org.cloudfoundry.client.v2.serviceinstances.GetServiceInstanceRequest;
import org.cloudfoundry.client.v2.serviceinstances.GetServiceInstanceResponse;
import org.cloudfoundry.client.v2.serviceinstances.ListServiceInstanceServiceBindingsRequest;
import org.cloudfoundry.client.v2.serviceinstances.ListServiceInstanceServiceBindingsResponse;
import org.cloudfoundry.client.v2.serviceinstances.ListServiceInstanceServiceKeysRequest;
import org.cloudfoundry.client.v2.serviceinstances.ListServiceInstanceServiceKeysResponse;
import org.cloudfoundry.client.v2.serviceinstances.ListServiceInstancesRequest;
import org.cloudfoundry.client.v2.serviceinstances.ListServiceInstancesResponse;
import org.cloudfoundry.client.v2.serviceinstances.ServiceInstances;
import org.cloudfoundry.client.v2.serviceinstances.UpdateServiceInstanceRequest;
import org.cloudfoundry.client.v2.serviceinstances.UpdateServiceInstanceResponse;
import org.cloudfoundry.reactor.ConnectionContext;
import org.cloudfoundry.reactor.TokenProvider;
import org.cloudfoundry.reactor.client.v2.AbstractClientV2Operations;
import reactor.core.publisher.Mono;

/**
 * The Reactor-based implementation of {@link ServiceInstances}
 */
public final class ReactorServiceInstances extends AbstractClientV2Operations implements ServiceInstances {

    /**
     * Creates an instance
     *
     * @param connectionContext the {@link ConnectionContext} to use when communicating with the server
     * @param root              the root URI of the server.  Typically something like {@code https://api.run.pivotal.io}.
     * @param tokenProvider     the {@link TokenProvider} to use when communicating with the server
     */
    public ReactorServiceInstances(ConnectionContext connectionContext, Mono<String> root, TokenProvider tokenProvider) {
        super(connectionContext, root, tokenProvider);
    }

    @Override
    public Mono<BindServiceInstanceToRouteResponse> bindToRoute(BindServiceInstanceToRouteRequest request) {
        return put(request, BindServiceInstanceToRouteResponse.class, builder -> builder.pathSegment("v2", "service_instances", request.getServiceInstanceId(), "routes", request.getRouteId()));
    }

    @Override
    public Mono<CreateServiceInstanceResponse> create(CreateServiceInstanceRequest request) {
        return post(request, CreateServiceInstanceResponse.class, builder -> builder.pathSegment("v2", "service_instances"));
    }

    @Override
    public Mono<DeleteServiceInstanceResponse> delete(DeleteServiceInstanceRequest request) {
        return delete(request, DeleteServiceInstanceResponse.class, builder -> builder.pathSegment("v2", "service_instances", request.getServiceInstanceId()));
    }

    @Override
    public Mono<GetServiceInstanceResponse> get(GetServiceInstanceRequest request) {
        return get(request, GetServiceInstanceResponse.class, builder -> builder.pathSegment("v2", "service_instances", request.getServiceInstanceId()));
    }

    @Override
    public Mono<GetServiceInstancePermissionsResponse> getPermissions(GetServiceInstancePermissionsRequest request) {
        return get(request, GetServiceInstancePermissionsResponse.class, builder -> builder.pathSegment("v2", "service_instances", request.getServiceInstanceId(), "permissions"));
    }

    @Override
    public Mono<ListServiceInstancesResponse> list(ListServiceInstancesRequest request) {
        return get(request, ListServiceInstancesResponse.class, builder -> builder.pathSegment("v2", "service_instances"));
    }

    @Override
    public Mono<ListServiceInstanceServiceBindingsResponse> listServiceBindings(ListServiceInstanceServiceBindingsRequest request) {
        return get(request, ListServiceInstanceServiceBindingsResponse.class, builder -> builder.pathSegment("v2", "service_instances", request.getServiceInstanceId(), "service_bindings"));
    }

    @Override
    public Mono<ListServiceInstanceServiceKeysResponse> listServiceKeys(ListServiceInstanceServiceKeysRequest request) {
        return get(request, ListServiceInstanceServiceKeysResponse.class, builder -> builder.pathSegment("v2", "service_instances", request.getServiceInstanceId(), "service_keys"));
    }

    @Override
    public Mono<UpdateServiceInstanceResponse> update(UpdateServiceInstanceRequest request) {
        return put(request, UpdateServiceInstanceResponse.class, builder -> builder.pathSegment("v2", "service_instances", request.getServiceInstanceId()));
    }

}
