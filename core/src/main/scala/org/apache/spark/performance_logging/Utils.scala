/*
 * Copyright 2014 The Regents of The University California
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.performance_logging

import java.lang.management.ManagementFactory

import scala.collection.JavaConversions._

object Utils {
  // Beware that the name returned by getName() is not guaranteed to keep following the pid@X
  // format.
  def getPid(): String = ManagementFactory.getRuntimeMXBean().getName().split("@")(0)

  def totalGarbageCollectionMillis: Long =
    ManagementFactory.getGarbageCollectorMXBeans.map(_.getCollectionTime).sum
}