/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import org.springframework.stereotype.Service;

/**
 *
 * @author lucille
 */
@Service("MessageService")
public class MessageImpl implements MessageService{

    @Override
    public String messageAmi(String nomAmi, String message) {
        return nomAmi+" : "+message;
    }
    
}
