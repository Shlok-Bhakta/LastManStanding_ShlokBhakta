import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class gameBox extends JFrame implements ActionListener{
    JFrame frame = new JFrame();
    gameCheckBox box1 = new gameCheckBox("spot1", false);
    
    
    
    
    
    public gameBox() {
        this.setSize(100, 100);
        this.add(box1);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);





    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    




    
}
