import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class gameBox extends JFrame implements ActionListener {

    GridBagLayout gridBag = new GridBagLayout();
    ArrayList<JCheckBox> boxes = new ArrayList<JCheckBox>();
    ArrayList<String> boxesLeft = new ArrayList<String>();
    ArrayList<String> boxesChecked = new ArrayList<String>();
    ArrayList<String> boxesID = new ArrayList<String>();
    String buttonText = ("Select Boxes!");
    JButton button = new JButton(buttonText);
    int turn = 0;

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

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println(e.getActionCommand());
        if (e.getActionCommand() == "Submit Move" || e.getActionCommand() == buttonText) {
            turn++;
            for (int FreezeButton = 0; FreezeButton < boxesID.size(); FreezeButton++) {
                System.out.println(IDToInt(boxesID.get(FreezeButton)));
                System.out.println(boxesID.get(FreezeButton));
                boxesLeft.remove(boxesID.get(FreezeButton));
                boxes.get(IDToInt(boxesID.get(FreezeButton))).setSelected(false);
                boxes.get(IDToInt(boxesID.get(FreezeButton))).setEnabled(false);
                boxesChecked.add(boxesID.get(FreezeButton));
            }
            boxesID.clear();
            System.out.println(boxesLeft);
            System.out.println(boxesChecked);
            for (int l = 0; l < boxesLeft.size(); l++) {
                boxes.get(IDToInt(boxesLeft.get(l))).setEnabled(true);
            }
            /* AI Turn */ {
                int I = randomGen(1, 3);
                int aiBoxSelected = 0;
                for (int boxesGoingToBeChecked = 0; boxesGoingToBeChecked < I; boxesGoingToBeChecked++) {
                    try{
                        aiBoxSelected = randomGen(0, boxesLeft.size() - 1);
                    }catch(Exception exc){
                        if(turn % 2 == 0){
                            System.out.println("bot wins");

                        }else{
                            System.out.println("Human Win");
                        }

                    }
                    
                    boxes.get(IDToInt(boxesLeft.get(aiBoxSelected))).setEnabled(false);
                    boxesChecked.add(boxesLeft.get(aiBoxSelected));
                    System.out.println(boxesLeft);
                    System.out.println(boxesChecked);
                    boxesLeft.remove(aiBoxSelected);
                    

                }
                turn++;
            }

        } else {

            if (boxesID.contains(e.getActionCommand())) {

                boxesID.remove(e.getActionCommand());
                System.out.println(boxesID);
                if (boxesID.size() == 0) {
                    button.setText(buttonText);
                    button.setActionCommand(buttonText);
                }
            } else {
                boxesID.add(e.getActionCommand());
                System.out.println(boxesID);
                if (boxesID.size() <= 1) {
                    button.setText("Submit Move");
                    button.setActionCommand("Submit Move");
                }

            }
            if (boxesID.size() >= 3) {
                for (int k = 0; k < boxesID.size(); k++) {
                    for (int l = 0; l < boxes.size(); l++) {
                        if (!(boxesID.get(k) == boxes.get(l).getActionCommand())) {
                            boxes.get(l).setEnabled(false);

                        }
                        if (boxes.get(l).isSelected()) {
                            boxes.get(l).setEnabled(true);
                        }
                    }

                }

            } else {
                for (int l = 0; l < boxesLeft.size(); l++) {

                    boxes.get(IDToInt(boxesLeft.get(l))).setEnabled(true);
                }
            }
            if (boxesID.size() >= 1) {
                button.setText("Submit Move");
                button.setActionCommand("Submit Move");
            }else{
                button.setText(buttonText);
                button.setActionCommand(buttonText);
            }
        }

    }





    // makes a box with a unique id
    public JCheckBox boxMaker(int ID) {
        JCheckBox box = new JCheckBox();
        box.addActionListener(this);
        box.setActionCommand("ID_" + ID);
        boxesLeft.add(box.getActionCommand());
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

    public int IDToInt(String IDnum) {
        int ID = -1;

        ID = IDnum.charAt(3) - 48;

        return ID;

    }

    public int randomGen(int min, int max) {

        int randomNum = 0;
        Random rand = new Random();

        randomNum = rand.nextInt(max - min + 1) + min;

        return randomNum;

    }

}
