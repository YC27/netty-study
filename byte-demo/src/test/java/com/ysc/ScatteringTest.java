/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.ysc;

import java.nio.ByteBuffer;

import static com.ysc.ByteBufferUtil.debugAll;

public class ScatteringTest {
  public static void main(String[] args) {
    final ByteBuffer source = ByteBuffer.allocate(32);
    source.put("Hello,world\nI'm yangchen.\nHo".getBytes());
    split(source);
    source.put("w are you?\n".getBytes());
    split(source);
  }

  public static void split(final ByteBuffer source) {
    source.flip();
    for (int i = 0; i < source.limit(); i++) {
      if (source.get(i) == '\n') {
        int length = i + 1 - source.position();
        final ByteBuffer target = ByteBuffer.allocate(length);
        for (int j = 0; j < length; j++) {
          target.put(source.get());
        }
        debugAll(target);
      }
    }

    source.compact();
  }
}
