package src.ast;

/*
 * Esta classe representa um comando de Impressão.
 * Exp
 */
import java.util.HashMap;

import src.visitors.Visitor;

public class LiteralValue<T> extends Exp {

      private T value;

      public LiteralValue(T value) {
            this.value = value;
      };

      // @Override
      public String toString() {
            return "" + value;
      }

      public T getValue() {
            return this.value;
      };

      public void accept(Visitor v) {
            v.visit(this);
      }
}
