/*
 * Copyright 2013 Geoff M. Granum
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
package biz.granum.datagen.base;

/**
 * A 'Generator' that always returns the value provided to the constructor.
 * <br/>
 * <br/>
 * This Generator (or 'value provider', if you prefer, since it isn't generating anything) is useful
 * for bootstrapping the DataGen API into your project, and also more generally for creating
 * test Fixtures with specific values. For example, to create two children under a single parent when the child
 * owns the relationship and uses a Generator&lt;ParentType&gt;.
 *
 * @author Geoff M. Granum
 */
public class DefinedValueGenerator<T> implements Generator<T> {

    private final T value;

    public DefinedValueGenerator(T value) {
        this.value = value;
    }

    @Override
    public T next() {
        return value;
    }

    public static <U> Generator<U> theValue(U value) {
        return new DefinedValueGenerator<U>(value);
    }
}
 
