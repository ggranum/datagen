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
 * @author Geoff M. Granum
 */
public class EmailAddressGenerator implements Generator<String> {

  private Generator<String> emailAddress = new StringGenerator()
      .prefix("email_")
      .content(StringSequenceGenerator.globalStringSequenceGenerator())
      .postfix("@example.com");

  @Override
  public String next() {
    return emailAddress.next();
  }
}
 