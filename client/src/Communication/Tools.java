/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Communication;
import java.util.*;
/**
 *
 * @author 志彬
 */
public class Tools {
    
    static Boolean judge(List<String> a ,List<String> b){
    if(a.size() == b.size() && a.containsAll(b)&& b.containsAll(a)){
        return true;
    }
    return false;
    }
}
