package personal_micor_vertx.learn;

import java.util.function.BiFunction;

/** 
 * @author hzhang
 * @date Jan 28, 2019 11:08:41 AM 
 *  
 */
public class BinFunction {

  /** 
  * @Title: main 
  * @param @param args 
  * @return void 
  * @throws 
  */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    BiFunction<String, String,String> bi = (x, y) -> {      
      return x + y;
    };

    System.out.println(bi.apply("java2s.com", " tutorial"));
  }

}
