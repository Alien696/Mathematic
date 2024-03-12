package mm.fe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SwingApplication {
    private JPanel outputPanel;
    private JPanel buttonsPanel;
    private JTextField output;

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
        output = new JTextField();
        output.setSize(438, 77);
        outputPanel.add(output);
        output.setFont(new Font("Arial", Font.BOLD, 46));
        output.setHorizontalAlignment(JTextField.RIGHT);
    }

    private void addFunctionButtons() {
        addButtons(4,4);
    }

    private void addNumericButtons() {
        addButtons(3,4);
    }

    private void addButtons(int rowCount, int columnCount) {
        for (int j = 0; j < columnCount; j++) {
            for (int i = 0; i < rowCount; i++) {
                addNewButton(i, j);
            }
        }
    }

    private void addNewButton(int i, int j) {
        JButton button = new JButton(getButtonName(i, j));
        button.setSize(50, 50);
        button.setLocation(i * 55 + 10, j * 55 + 10);
        buttonsPanel.add(button);
//        button.addActionListener(evt -> action(evt)); Tento řádek je nahrazen následujícím řádkem který dělá úplně to samé ale je zapsán takzvanou method reference syntaxí
        button.addActionListener(this::action);
    }

    private void action(ActionEvent evt) {
//        Počítáme s tím že událost bude pouze z JButton proto si můžeme dovolit přetypovat zdroj na JButton
        JButton button = (JButton) evt.getSource(); // měkke přetypování = Pokud mám nějakého předka můžu jej pomocí kulatých závorek přetypovat na jednoho z jeho potomků
        String buttonText = button.getText();
        output.setText(output.getText() + buttonText);
//        output.setText(((JButton)evt.getSource()).getText());

    }

    private String getButtonName(int i, int j) {
        String resultName = "" + ((i + 1) + (2 - j) * 3);
        if (resultName.equals("-2")) {
            return ".";
        } else if (resultName.equals("-1")) {
            return "=";
        } else if (resultName.equals("10")) {
            return "÷";
        } else if (i == 3 && j == 1) {
            return "×";
        } else if (i == 3 && j == 2) {
            return "-";
        } else if (i == 3 && j == 3) {
            return "+";
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
