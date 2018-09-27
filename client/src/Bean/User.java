/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bean;
import java.io.*;
/**
 *
 * @author 志彬
 */
public class User implements Serializable{
    private static final long serialVersionUID=1L;
    private String name;
    private String password;
    private String picture;
    
    public User() {  
          
    }  
    public void setName(String name){
    this.name = name;
    }
    public void setPassword(String password){
    this.password = password;
    }
    public void setPicture(String picture){
    this.picture = picture;
    }
    public String getName(){
    return this.name;
    }
    public String getPassword(){
    return this.password;
    }
    public String getPicture(){
    return this.picture;
    }
    
}
