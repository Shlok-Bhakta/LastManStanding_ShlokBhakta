import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class gameBox extends JFrame implements ActionListener {

    GridBagLayout gridBag = new GridBagLayout();
    JFrame frame = new JFrame();
    ArrayList<JCheckBox> boxes = new ArrayList<JCheckBox>();

    JButton button = new JButton("Submit Move");

    public gameBox() {
        super();
        /* JFrame */ {
            this.setSize(300, 400);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setLayout(gridBag);
        }
        /* Submit Button */ {
            GridBagConstraints c = new GridBagConstraints();

            c.gridx = 2;
            c.gridy = 2;

            gridBag.setConstraints(button, c);
            this.add(button, c);
        }

        /* checkbox1 */ {
            JCheckBox box = boxMaker();
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.CENTER;
            c.gridx = 0;
            c.gridy = 1;

            gridBag.setConstraints(button, c);

            this.add(box, c);
            boxes.add(box);
        }
        /* checkbox2 */ {
            JCheckBox box = boxMaker();
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.CENTER;
            c.gridx = 1;
            c.gridy = 1;

            gridBag.setConstraints(button, c);

            this.add(box, c);
            boxes.add(box);
        }
        /* checkbox3 */ {
            JCheckBox box = boxMaker();
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.CENTER;
            c.gridx = 2;
            c.gridy = 1;

            gridBag.setConstraints(button, c);

            this.add(box, c);
            boxes.add(box);
        }
        /* checkbox4 */ {
            JCheckBox box = boxMaker();
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.CENTER;
            c.gridx = 3;
            c.gridy = 1;

            gridBag.setConstraints(button, c);

            this.add(box, c);
            boxes.add(box);
        }
        /* checkbox5 */ {
            JCheckBox box = boxMaker();
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.CENTER;
            c.gridx = 4;
            c.gridy = 1;

            gridBag.setConstraints(button, c);

            this.add(box, c);
            boxes.add(box);
        }
        System.out.println(boxes);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    public static JCheckBox boxMaker() {
        JCheckBox box = new JCheckBox();

        return box;
    }
}
