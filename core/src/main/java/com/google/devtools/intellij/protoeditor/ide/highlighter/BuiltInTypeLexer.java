/*
 * Copyright 2019 Google LLC
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
package com.google.devtools.intellij.protoeditor.ide.highlighter;

import com.google.devtools.intellij.protoeditor.lang.psi.ProtoTokenTypes;
import com.google.devtools.intellij.protoeditor.lang.util.BuiltInType;
import com.intellij.lexer.DelegateLexer;
import com.intellij.lexer.Lexer;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BuiltInTypeLexer extends DelegateLexer {

  BuiltInTypeLexer(@NotNull Lexer delegate) {
    super(delegate);
  }

  @Nullable
  @Override
  public IElementType getTokenType() {
    if (BuiltInType.isBuiltInType(getTokenText())) {
      return ProtoTokenTypes.BUILT_IN_TYPE;
    }
    return myDelegate.getTokenType();
  }
}
