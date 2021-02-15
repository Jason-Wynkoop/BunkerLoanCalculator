import javax.swing.*;
import java.awt.*;

/**
 *Holds the optional addons and sets SecuriSafe
 * to selected on default and reset
 */
class OptionsPanel extends JPanel {

    private final JCheckBox autoLock;
    private final JCheckBox securiSafe;
    private final JCheckBox guardRobot;
    private final JCheckBox safetyProtocols;
    private final JCheckBox medical;


    public OptionsPanel() {

        setLayout(new GridLayout(5, 1));

        //Creates check boxes
        autoLock = new JCheckBox("Auto Lock Door: $21,000");
        securiSafe = new JCheckBox("SecuriSafe Ultra Concrete: $30,000", true);
        guardRobot = new JCheckBox("Guard Robot: $150,000");
        safetyProtocols = new JCheckBox("Guard Robot Safety Protocols: $30,000");
        medical = new JCheckBox("Medical Addons: $200,000");

        //Adds them to panel
        add(autoLock);
        add(securiSafe);
        add(guardRobot);
        add(safetyProtocols);
        add(medical);

        //Creates border
        setBorder(BorderFactory.createTitledBorder("Bunker Options"));

    }

    //Sums accumulator for every check box that is checked with appropriate price and allows it to be retrieved
    public double getPWO() {

        double optionSum = 0;

        if (autoLock.isSelected()) {

            optionSum += 21000;
        }

        if (securiSafe.isSelected()) {

            optionSum += 30000;
        }

        if (guardRobot.isSelected()) {

            optionSum += 150000;
        }

        if (safetyProtocols.isSelected()) {

            optionSum += 30000;
        }

        if (medical.isSelected()) {

            optionSum += 200000;
        }

        return (optionSum);
    }

    public void setPWO() {

        autoLock.setSelected(false);
        securiSafe.setSelected(true);
        guardRobot.setSelected(false);
        safetyProtocols.setSelected(false);
        medical.setSelected(false);
    }

}