import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class gameBox extends JFrame implements ActionListener {

    GridBagLayout gridBag = new GridBagLayout();
    ArrayList<JCheckBox> boxes = new ArrayList<JCheckBox>();

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
        /* checkbox1 */ {
            JCheckBox box = boxMaker();
            this.add(box, setConstraints(0, 1));
            boxes.add(box);
        }
        /* checkbox2 */ {
            JCheckBox box = boxMaker();
            this.add(box, setConstraints(1, 1, GridBagConstraints.CENTER));
            boxes.add(box);
        }
        /* checkbox3 */ {
            JCheckBox box = boxMaker();
            this.add(box, setConstraints(2, 1, GridBagConstraints.CENTER));
            boxes.add(box);
        }
        /* checkbox4 */ {
            JCheckBox box = boxMaker();
            this.add(box, setConstraints(3, 1, GridBagConstraints.CENTER));
            boxes.add(box);
        }
        /* checkbox5 */ {
            JCheckBox box = boxMaker();
            this.add(box, setConstraints(4, 1, GridBagConstraints.CENTER));
            boxes.add(box);
        }
        /* checkbox6 */ {
            JCheckBox box = boxMaker();
            this.add(box, setConstraints(0, 2));
            boxes.add(box);
        }
        /* checkbox7 */ {
            JCheckBox box = boxMaker();
            this.add(box, setConstraints(1, 2, GridBagConstraints.CENTER));
            boxes.add(box);
        }
        /* checkbox8 */ {
            JCheckBox box = boxMaker();
            this.add(box, setConstraints(2, 2, GridBagConstraints.CENTER));
            boxes.add(box);
        }
        /* checkbox9 */ {
            JCheckBox box = boxMaker();
            this.add(box, setConstraints(3, 2, GridBagConstraints.CENTER));
            boxes.add(box);
        }
        /* checkbox10 */ {
            JCheckBox box = boxMaker();
            this.add(box, setConstraints(4, 2, GridBagConstraints.CENTER));
            boxes.add(box);
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
            GridBagConstraints c = setConstraints(0, 3, GridBagConstraints.CENTER, GridBagConstraints.CENTER);
            c.gridwidth = 6;
            this.add(button, c);
        }
        System.out.println(boxes.get(0));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO check for only 3 boxes checked
        int boxesChecked = 0;
        






    }

    public static JCheckBox boxMaker() {
        JCheckBox box = new JCheckBox();

        return box;
    }

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
