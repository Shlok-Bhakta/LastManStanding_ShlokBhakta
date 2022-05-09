import javax.swing.*;

public class gameCheckBox extends JCheckBox {
    JCheckBox checkBox = new JCheckBox();

    public gameCheckBox(String name, boolean enabled) {
        super();

        this.setText(name);
        this.setEnabled(enabled);

    }

}
