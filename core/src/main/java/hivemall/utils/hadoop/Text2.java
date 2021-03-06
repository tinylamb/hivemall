/*
 * Hivemall: Hive scalable Machine Learning Library
 *
 * Copyright (C) 2015 Makoto YUI
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hivemall.utils.hadoop;

import hivemall.utils.lang.Preconditions;
import hivemall.utils.lang.PrivilegedAccessor;

import java.lang.reflect.Field;

import javax.annotation.Nonnull;

import org.apache.hadoop.io.Text;

/**
 * {@link Text} that internally uses given bytes avoiding copies.
 */
public final class Text2 extends Text {

    public Text2(@Nonnull byte[] b) {
        this(b, b.length);
    }

    public Text2(@Nonnull byte[] b, int len) {
        super();
        Field bytesField = PrivilegedAccessor.getField(Text.class, "bytes");
        PrivilegedAccessor.setField(this, Preconditions.checkNotNull(bytesField), b);
        Field lengthField = PrivilegedAccessor.getField(Text.class, "length");
        PrivilegedAccessor.setField(this, Preconditions.checkNotNull(lengthField), len);
    }

}
