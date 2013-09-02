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

import static biz.granum.datagen.base.DefinedValueGenerator.theValue;

/**
 * @author Geoff M. Granum
 */
public class StringGenerator implements Generator<String> {

    private Generator<String> prefix = theValue("");
    private Generator<String> content = theValue("");
    private Generator<String> postfix = theValue("");

    public StringGenerator() {
    }

    public StringGenerator prefix(String prefix) {
        return this.prefix(theValue(prefix));
    }

    public StringGenerator prefix(Generator<String> prefix) {
        this.prefix = prefix;
        return this;
    }

    public StringGenerator postfix(Generator<String> postfix) {
        this.postfix = postfix;
        return this;
    }

    public Generator<String> postfix(String value) {
        return this.postfix(theValue(value));
    }

    public StringGenerator content(Generator<String> content) {
        this.content = content;
        return this;
    }

    public Generator<String> content(String value) {
        return this.content(theValue(value));
    }

    @Override
    public String next() {
        return prefix.next() + content.next() + postfix.next();
    }
}
 
