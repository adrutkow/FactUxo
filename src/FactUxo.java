import javax.swing.*;
import java.awt.*;

public class FactUxo extends JFrame {

    private JPanel leftPanel, middlePanel, rightPanel;
    private JButton leftButton, middleButton, rightButton;
    private JScrollPane leftScrollPane, middleScrollPane;
    private JCheckBox[] checkBoxes;

    public FactUxo() {
        // Create the main JFrame
        super("FactUxo Mod Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Create the left panel with a button on top and a scrollable list of objects
        leftPanel = new JPanel(new BorderLayout());
        leftButton = new JButton("Left Panel sadasddsasdasdasdads");
        leftPanel.add(leftButton, BorderLayout.NORTH);
        String[] leftListItems = {"Object sadasdasafafafasfasfasfasfasf1", "Object 2", "Object 3", "Object 4", "Object 5"};
        JList<String> leftList = new JList<>(leftListItems);
        leftScrollPane = new JScrollPane(leftList);
        leftPanel.add(leftScrollPane, BorderLayout.CENTER);

        // Create the middle panel with a button on top and a scrollable list of objects with checkboxes
        middlePanel = new JPanel(new BorderLayout());
        middleButton = new JButton("Middle Panel Button");
        middlePanel.add(middleButton, BorderLayout.NORTH);

        JPanel middleCheckBoxPanel = new JPanel();
        middleCheckBoxPanel.setLayout(new BoxLayout(middleCheckBoxPanel, BoxLayout.Y_AXIS));
        String[] middleListItems = {"Object 1", "Object 2", "Object 3", "Object 4", "Object 5"};
        checkBoxes = new JCheckBox[middleListItems.length];
        for (int i = 0; i < middleListItems.length; i++) {
            checkBoxes[i] = new JCheckBox();
            middleCheckBoxPanel.add(checkBoxes[i]);
        }

        JList<String> middleList = new JList<>(middleListItems);
        middleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        middleList.setFont(new Font(Font.SANS_SERIF, 0, 14));

        middleList.addListSelectionListener(e -> {
            int index = middleList.getSelectedIndex();
            checkBoxes[index].setSelected(!checkBoxes[index].isSelected());
        });

        middleScrollPane = new JScrollPane(middleList);
        middlePanel.add(middleCheckBoxPanel, BorderLayout.WEST);
        middlePanel.add(middleScrollPane, BorderLayout.CENTER);

        // Create the right panel with a button on top
        rightPanel = new JPanel(new BorderLayout());
        rightButton = new JButton("Right Panel Button");
        rightPanel.add(rightButton, BorderLayout.NORTH);

        // Add the panels to the main JFrame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(leftPanel, BorderLayout.WEST);
        getContentPane().add(middlePanel, BorderLayout.CENTER);
        getContentPane().add(rightPanel, BorderLayout.EAST);

        // Display the main JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        new FactUxo();
    }
}
