/**
 * Copyright (C) 2010 dennis zhuang (killme2008@gmail.com)
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this program;
 * if not, write to the Free Software Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 *
 **/
package priv.yulong.expression.token;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;


/**
 * A Number token
 * 
 * @author dennis
 * 
 */
public class NumberToken extends AbstractToken<BigDecimal> {

  private BigDecimal value;


  public NumberToken(BigDecimal value, String lexeme) {
    super(-1, lexeme);
    this.value = value;
  }


  public NumberToken(BigDecimal value, String lexeme, int startIndex) {
    super(startIndex, lexeme);
    this.value = value;
  }
  
  public NumberToken(BigInteger value, String lexeme, int startIndex) {
	    super(startIndex, lexeme);
	    this.value = new BigDecimal(value.toString());
	  }


  public void setNumber(BigDecimal number) {
    this.value = number;
  }


  public Number getNumber() {
    return this.value;
  }


  public BigDecimal getValue(Map<String, Object> env) {
    return value;
  }


  public TokenType getType() {
    return TokenType.Number;
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((value == null) ? 0 : value.hashCode());
    return result;
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!super.equals(obj)) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    NumberToken other = (NumberToken) obj;
    if (value == null) {
      if (other.value != null) {
        return false;
      }
    } else if (!value.equals(other.value)) {
      return false;
    }
    return true;
  }

}
