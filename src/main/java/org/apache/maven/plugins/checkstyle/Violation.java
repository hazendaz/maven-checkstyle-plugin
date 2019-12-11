package org.apache.maven.plugins.checkstyle;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Holds data about a single violation and represents the violation itself.
 */
public class Violation
{
  private final String source;

  private final String file;

  private final int line;

  private @Nullable Integer column;

  private final String severity;

  private final String message;

  private final String ruleName;

  private final String category;

  // Leaving out column, because there is no CHECKSTYLE:OFF support.
  public Violation( String source,
                    String file,
                    int line,
                    String severity,
                    String message,
                    String ruleName,
                    String category )
  {
    this.source = Objects.requireNonNull( source );
    this.file = file;
    this.line = line;
    this.severity = Objects.requireNonNull( severity );
    this.message = Objects.requireNonNull( message );
    this.ruleName = Objects.requireNonNull( ruleName );
    this.category = Objects.requireNonNull( category );
  }

  public String getSource()
  {
    return source;
  }

  public String getFile()
  {
    return file;
  }

  public long getLine()
  {
    return line;
  }

  public @Nullable Integer getColumn()
  {
    return column;
  }

  public void setColumn( @Nullable Integer column )
  {
    this.column = column;
  }

  public String getSeverity()
  {
    return severity;
  }

  public String getMessage()
  {
    return message;
  }

  public String getRuleName()
  {
    return ruleName;
  }

  public String getCategory()
  {
    return category;
  }

  @Override
  public boolean equals( Object other )
  {
    if ( this == other )
    {
      return true;
    }
    if ( !( other instanceof Violation ) )
    {
      return false;
    }
    Violation violation = ( Violation ) other;
    return line == violation.line
        && Objects.equals( column, violation.column )
        && source.equals( violation.source )
        && file.equals( violation.file )
        && severity.equals( violation.severity )
        && message.equals( violation.message )
        && ruleName.equals( violation.ruleName )
        && category.equals( violation.category );
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( source, file, line, column, severity, message, ruleName, category );
  }

  @Override
  public String toString()
  {
    return new StringJoiner( ", ", Violation.class.getSimpleName() + "[", "]" )
        .add( "source='" + source + "'" )
        .add( "file='" + file + "'" )
        .add( "line=" + line )
        .add( "column=" + column )
        .add( "severity='" + severity + "'" )
        .add( "message='" + message + "'" )
        .add( "ruleName='" + ruleName + "'" )
        .add( "category='" + category + "'" )
        .toString();
  }
}
