/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bean;
import java.util.*;
import java.io.*;
/**
 *
 * @author 志彬
 */
public class Message implements Serializable{
    private String sender;
    private String receiver;
    private String content;
    private Date date;
    
    public void setSender(String sender){
    this.sender = sender;
    }
    public void setReceiver(String receiver){
    this.receiver = receiver;
    }
    public void setContent(String content){
    this.content = content;
    }
    public void setDate(Date date){
    this.date = date;
    }
    public String getSender(){
    return sender;
    }
    public String getReceiver(){
    return receiver;
    }
    public String getContent(){
    return content;
    }
    public Date getDate(){
    return date;
    }
    
}
