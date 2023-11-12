import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author executive
 */
public class ResViewController implements Initializable {

    //personal details tab
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField phone;
    @FXML
    private TextField email;
    @FXML
    private TextField address;
    @FXML
    private TextField city;
    @FXML
    private TextField state;
    @FXML
    private TextField zip;
    
    //education tab
    @FXML
    private TextField school1;
    @FXML
    private TextField school2;
    @FXML
    private TextField school3;
    @FXML 
    private TextField major1;
    @FXML 
    private TextField major2;
    @FXML 
    private TextField major3;
    @FXML
    private DatePicker dpA1;
    @FXML
    private DatePicker dpA2;
    @FXML
    private DatePicker dpB1;
    @FXML
    private DatePicker dpB2;
    @FXML
    private DatePicker dpC1;
    @FXML
    private DatePicker dpC2;
    
    //job history tab
    @FXML
    private TextField job1;
    @FXML
    private TextField job2;
    @FXML
    private TextField job3;
    @FXML 
    private TextField position1;
    @FXML 
    private TextField position2;
    @FXML 
    private TextField position3;
    @FXML
    private DatePicker dpD1;
    @FXML
    private DatePicker dpD2;
    @FXML
    private DatePicker dpE1;
    @FXML
    private DatePicker dpE2;
    @FXML
    private DatePicker dpF1;
    @FXML
    private DatePicker dpF2;
    
    //skills & certifications tab
    @FXML
    private TextField skill1;
    @FXML
    private TextField skill2;
    @FXML
    private TextField skill3;
    @FXML 
    private TextField cert1;
    @FXML 
    private TextField cert2;
    @FXML 
    private TextField cert3;
    @FXML
    private Button export;
    
    //generate resume tab
    @FXML
    private TextArea output;
    
    
    @FXML
    private Button generateResume;
 
    
    //method to gather all personal detials
    @FXML
    public void personDetails(){
    
    output.appendText(firstName.getText()+ " "+lastName.getText() + "\n" +
              address.getText() + "\n" + city.getText() + " "+ state.getText() +" "+ 
                      zip.getText() +"\n" + email.getText()+" | "+ phone.getText() +"\n");
     
    }
     //method to gather all education details
    @FXML
    public void educationDetails(){
        output.setStyle("-fx-font-family: times new roman");
        output.appendText("Educaiton");
        output.appendText("\n" +"–––––––––––––––––––––––––––––––––––––––––––––––––––––"+"\n");
        //first school
        output.appendText(school1.getText() +"\n "+ major1.getText() +
               "\n"+ dpA1.getValue() +" to "+ dpA1.getValue());
        
        
            //second school
            output.appendText("\n"+school2.getText() +"\n "+ major2.getText() +
                    "\n"+ dpB1.getValue() +" to "+ dpB1.getValue());
        
        //third school 
          output.appendText("\n"+school3.getText() +"\n "+ major3.getText() +
               "\n"+ dpC1.getValue() +" to "+ dpC1.getValue());
        
    }
    //job history details
    @FXML
    public void jobHistoryDetails(){
        output.setStyle("-fx-font-family: times new roman");
        //work history header
        output.appendText("\n\n"+"Work History"+"\n\n");
        
        //job 1
        output.appendText(job1.getText()+ "\n" +position1.getText()+ "\n"+
                dpD1.getValue()+ " to "+ dpD2.getValue()+"\n");
        
        //job2
         output.appendText(job2.getText()+ "\n" +position2.getText()+ "\n"+
                dpE1.getValue()+ " to "+ dpE2.getValue()+"\n");
         
         //job3
          output.appendText(job3.getText()+ "\n" +position3.getText()+ "\n"+
                dpF1.getValue()+ " to "+ dpF2.getValue()+"\n");
          
          output.appendText("–––––––––––––––––––––––––––––––––––––––––––––––––––––");
    }
    
    //skills and certification detials
    @FXML
    public void skillsAndCerts(){
        output.setStyle("-fx-font-family: times new roman");
        //skills and certification header
        output.appendText("\n"+ "Skills and Certifications" + "\n\n");
        
        //skills output
        output.appendText("•"+skill1.getText() + "\n" +
                          "•"+skill2.getText() + "\n" +
                          "•"+skill3.getText() + "\n" + "\n");
       
        //certification output
        output.appendText("•"+cert1.getText() + "\n" +
                          "•"+cert2.getText() + "\n" +
                          "•"+cert3.getText() + "\n");           
    }

    /**
     *
     * @param e
     */
    @FXML
    public void handle(ActionEvent e){
        
        //call methods to dispay content
        personDetails();
        educationDetails();
        jobHistoryDetails();
        skillsAndCerts();
    }
    
    //method for handling export 
     //public void handle2(ActionEvent e)
   public void handle2(ActionEvent e) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(
                new FileWriter("myResume.txt", true)))) {
            out.println(output.getText());
        } catch (IOException ioe) {
        }
    }

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        state.textProperty().addListener((ov, oldValue, newValue) -> {
     state.setText(newValue.toUpperCase());
});
}    

 
 }

    

