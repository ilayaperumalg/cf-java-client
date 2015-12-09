/*
 * Copyright 2015 the original author or authors.
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

import org.cloudfoundry.client.ValidationResult;
import org.junit.Test;

import static org.cloudfoundry.client.ValidationResult.Status.INVALID;
import static org.cloudfoundry.client.ValidationResult.Status.VALID;
import static org.junit.Assert.assertEquals;

public final class AssociateOrganizationUserRequestTest {

    @Test
    public void isValid() {
        ValidationResult result = AssociateOrganizationUserRequest.builder()
                .id("test-id")
                .userId("test-user-id")
                .build()
                .isValid();

        assertEquals(VALID, result.getStatus());
    }

    @Test
    public void isValidNoId() {
        ValidationResult result = AssociateOrganizationUserRequest.builder()
                .userId("test-user-id")
                .build()
                .isValid();

        assertEquals(INVALID, result.getStatus());
        assertEquals("id must be specified", result.getMessages().get(0));
    }

    @Test
    public void isValidNoUserId() {
        ValidationResult result = AssociateOrganizationUserRequest.builder()
                .id("test-id")
                .build()
                .isValid();

        assertEquals(INVALID, result.getStatus());
        assertEquals("user id must be specified", result.getMessages().get(0));
    }

}
