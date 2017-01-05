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

package org.cloudfoundry;

import com.github.zafarkhaja.semver.Version;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.cloudfoundry.IfCloudFoundryVersion.CloudFoundryVersion.UNSPECIFIED;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface IfCloudFoundryVersion {

    CloudFoundryVersion equalTo() default UNSPECIFIED;

    CloudFoundryVersion greaterThan() default UNSPECIFIED;

    CloudFoundryVersion greaterThanOrEqualTo() default UNSPECIFIED;

    CloudFoundryVersion lessThan() default UNSPECIFIED;

    CloudFoundryVersion lessThanOrEqualTo() default UNSPECIFIED;

    enum CloudFoundryVersion {

        PCF_1_7(Version.forIntegers(2, 54, 0)),

        PCF_1_8(Version.forIntegers(2, 58, 0)),

        PCF_1_9(Version.forIntegers(2, 65, 0)),

        UNSPECIFIED(Version.forIntegers(0));

        private final Version version;

        CloudFoundryVersion(Version version) {
            this.version = version;
        }

        Version getVersion() {
            return this.version;
        }

    }

}
