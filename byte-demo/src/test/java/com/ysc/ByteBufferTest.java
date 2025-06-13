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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ByteBufferTest {
  public static void main(String[] args) {
    final long currentTime = System.currentTimeMillis();
    try (final FileChannel channel =
        new FileInputStream(
                "E:\\Development\\Project\\Start-Learning\\netty-studying\\byte-demo\\src\\test\\resources\\data.txt")
            .getChannel()) {
      final ByteBuffer buffer = ByteBuffer.allocate(10);
      while (channel.read(buffer) != -1) {
        buffer.flip();
        while (buffer.hasRemaining()) {
          System.out.print((char) buffer.get());
        }
        buffer.clear();
      }
    } catch (final IOException e) {
      throw new RuntimeException(e);
    }
    final long endTime = System.currentTimeMillis();
    System.out.println("\nTime taken: " + (endTime - currentTime));
  }
}
