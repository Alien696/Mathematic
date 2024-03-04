package mm.fe;

import javax.swing.*;
import java.awt.*;

public class SwingApplication {
    private JPanel outputPanel;
    private JPanel buttonsPanel;

    public void createBasicWindow() {
        JFrame frame = new JFrame();
        frame.setSize(450, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
//        frame.setResizable(false);

        // POZOR záleží na pořadí metoda addPanels musí být volána před komponentama
        addPanels(frame);
        addComponents();


        frame.setVisible(true);

    }

    private void addComponents() {
        addNumericButtons();
        addFunctionButtons();
        addOutput();

    }

    private void addOutput() {
        JTextField output = new JTextField();
        output.setSize(438, 77);
        outputPanel.add(output);
        output.setFont(new Font("Arial", Font.BOLD, 46));
        output.setHorizontalAlignment(JTextField.RIGHT);


    }

    private void addFunctionButtons() {

    }

    private void addNumericButtons() {
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 3; i++) {

                JButton button = new JButton(getButtonName(i, j));
                button.setSize(50, 50);
                button.setLocation(i * 55 + 10, j * 55 + 10);
                buttonsPanel.add(button);
            }
        }


    }

    private String getButtonName(int i, int j) {
        String resultName = "" + ((i + 1) + (2 - j) * 3);
        if (resultName.equals("-2")) {
            return ".";

        } else if (resultName.equals("-1")) {
            return "=";
        }
        return resultName;
    }

    private void addPanels(JFrame frame) {
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(204, 152, 152));
        frame.add(mainPanel);
        mainPanel.setLayout(new BorderLayout());

        outputPanel = new JPanel();
        mainPanel.add(outputPanel);
        outputPanel.setPreferredSize(new Dimension(450, 75));
        mainPanel.add(outputPanel, BorderLayout.NORTH);
        outputPanel.setBackground(Color.BLUE);
        outputPanel.setLayout(null);


        buttonsPanel = new JPanel();
        buttonsPanel.setBackground(new Color(79, 106, 178));
        mainPanel.add(buttonsPanel, BorderLayout.CENTER);
        buttonsPanel.setSize(buttonsPanel.getWidth(), 300);
        buttonsPanel.setLayout(null);

        JPanel functionButtonsPanel = new JPanel();
        functionButtonsPanel.setBackground(Color.GREEN);
        mainPanel.add(functionButtonsPanel, BorderLayout.EAST);


    }
}
