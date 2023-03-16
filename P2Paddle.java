import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;

public class P2Paddle extends JFrame{


    // Color name array
    private String[] colorNameArray = {"Red", "Yellow", "Pink"};
    // Color list array
    private Color[] colorListArray = {Color.RED, Color.YELLOW, Color.PINK};

    // JLIst
    JList colorList;
    
    P2Paddle(){
        // JLabel
        JLabel label = new JLabel();
        label.setText("Player 2, choose color:");
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setForeground(Color.black);
        
        
        // JList
        colorList = new JList(colorNameArray);
        colorList.setFont(new Font("Arial", Font.BOLD, 30));
        colorList.setForeground(Color.black);

        // Allows only once selection in the list
        colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // JLabel for image
        JLabel imageLabel = new JLabel();

        // Image shown at PlayAgain
        ImageIcon imageP1 = new ImageIcon("paddles.jpg");
               
        // Set image to label
        imageLabel.setIcon(imageP1);
        
        // Add Event Handler
        EventHandler handler = new EventHandler();
        colorList.addListSelectionListener(handler);

        
        // Add list to frame 
        this.add(label);
        this.add(colorList);

        // Directions
        JLabel direction = new JLabel("Race to five");
        direction.setFont(new Font("Arial", Font.PLAIN, 20));
        direction.setForeground(Color.BLACK);

        JLabel direction0 = new JLabel("To be the Winner!");
        direction0.setFont(new Font("Arial", Font.PLAIN, 20));
        direction0.setForeground(Color.BLACK);
        
        // Add directions to the frame
        this.add(imageLabel);
        this.add(direction);
        this.add(direction0);

        //Frame title
        this.setLayout(new FlowLayout());
        // Frame title
        this.setTitle("Pong Game!");
        // Terminates java program on close
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Frame size
        this.setSize(1000,800);
        // Puts frame in the middle 
        this.setLocationRelativeTo(null);
        // Make frame appear
        this.setVisible(true);
        // Disable resize
        this.setResizable(false);
        // set Background color
        this.getContentPane().setBackground(Color.gray);

    }
    private class EventHandler implements ListSelectionListener{

        public void valueChanged(ListSelectionEvent event){
            Paddle.paddle2 = colorListArray[colorList.getSelectedIndex()];

            // open EnterPlayerNames
            new PlayerNames();

            // close game frame
            dispose();
        }
    }  
}
