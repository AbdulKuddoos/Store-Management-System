/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 *
 * @author Abdul Quddoos
 */
public class FxmlLoader {
    private Pane screen;
    
    public Pane getPage(String fileName)
    {
        try{
            URL fileUrl = SMS.class.getResource("/sms/"+fileName+".fxml");
            if(fileUrl == null){
                throw new java.io.FileNotFoundException("File not Found");
        
            }
        
        
        screen = new FXMLLoader().load(fileUrl);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        return screen;
    }
    
}
