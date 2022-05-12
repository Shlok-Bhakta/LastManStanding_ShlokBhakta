import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class gameBox extends JFrame implements ActionListener {

    GridBagLayout gridBag = new GridBagLayout();
    ArrayList<JCheckBox> boxes = new ArrayList<JCheckBox>();
    ArrayList<String> boxesID = new ArrayList<String>();

    public gameBox() {
        super();
        /* JFrame */ {
            this.setSize(225, 150);

            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setTitle("GridBag");
            this.setAlwaysOnTop(true);
            this.setLayout(gridBag);

        }
        /* Label */ {
            JLabel label = new JLabel("Select >=3 boxes");
            try {
                Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("OpenSans-SemiBold.ttf"))
                        .deriveFont(12f);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(customFont);
                label.setFont(customFont);
            } catch (IOException | FontFormatException e) {

            }

            GridBagConstraints c = setConstraints(0, 0);
            c.gridwidth = 5;
            this.add(label, c);

        }
        /* add checkboxes */ {
            int ID = 0;
            for (int col = 1; col <= 2; col++) {
                for (int row = 0; row <= 4; row++) {

                    JCheckBox box = boxMaker(ID);
                    this.add(box, setConstraints(row, col));
                    boxes.add(box);
                    ID++;
                }
            }
        }
        /* Submit Button */ {
            JButton button = new JButton("Submit Move");
            try {
                Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("OpenSans-SemiBold.ttf"))
                        .deriveFont(12f);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(customFont);
                button.setFont(customFont);
            } catch (IOException | FontFormatException e) {

            }
            button.addActionListener(this);
            GridBagConstraints c = setConstraints(0, 3, GridBagConstraints.CENTER, GridBagConstraints.CENTER);
            c.gridwidth = 6;
            this.add(button, c);
        }
        System.out.println(boxes.get(0));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int boxesChecked = 0;
        ArrayList<JCheckBox> boxArray = boxes;

        if (e.getActionCommand() == "Submit Move") {



        } else {

            if (boxesID.contains(e.getActionCommand())) {
                boxesChecked--;
                boxesID.remove(e.getActionCommand());
                System.out.println(boxesID);

            } else {
                boxesID.add(e.getActionCommand());
                boxesChecked++;

            }
            if (boxesID.size() >= 3) {
                for (int k = 0; k < boxesID.size() - 1; k++) {
                    for (int l = 0; l < boxes.size(); l++) {
                        if (!(boxesID.get(k) == boxes.get(l).getActionCommand())) {
                            boxes.get(l).setEnabled(false);

                        }
                        if(boxes.get(l).isSelected()){
                            boxes.get(l).setEnabled(true);
                        }
                    }
                    

                }

            }else{
                for(int l = 0; l < boxes.size(); l++){
                    boxes.get(l).setEnabled(true);
                }
            }
        }
    }

    // makes a box with a unique id
    public JCheckBox boxMaker(int ID) {
        JCheckBox box = new JCheckBox();
        box.addActionListener(this);
        box.setActionCommand("ID_" + ID);
        return box;
    }

    // 3 overloaded methods for setiing constraints to gridbaglayout
    public static GridBagConstraints setConstraints(int gridx, int gridy, int fill) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = gridx;
        c.gridy = gridy;
        c.fill = fill;

        return c;

    }

    public static GridBagConstraints setConstraints(int gridx, int gridy) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = gridx;
        c.gridy = gridy;
        return c;

    }

    public static GridBagConstraints setConstraints(int gridx, int gridy, int fill, int anchor) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = gridx;
        c.gridy = gridy;
        c.fill = fill;
        c.anchor = anchor;

        return c;

    }

}
