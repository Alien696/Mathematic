package mm.fe;

import javax.swing.*;
import java.awt.*;

public class SwingApplication {
    public void createBasicWindow () {
        JFrame frame = new JFrame();
        frame.setSize(450,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        addPanels(frame);



        frame.setVisible(true);

    }

    private void addPanels(JFrame frame) {
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(204, 152, 152));
        frame.add(mainPanel);
        mainPanel.setLayout(new BorderLayout());

        JPanel outputPanel = new JPanel();
        mainPanel.add(outputPanel);
        outputPanel.setPreferredSize(new Dimension(450,75));
        mainPanel.add(outputPanel,BorderLayout.NORTH);


        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(new Color(79, 106, 178));
        mainPanel.add(buttonsPanel,BorderLayout.CENTER);
        buttonsPanel.setSize(buttonsPanel.getWidth(),300);

        JPanel functionButtonsPanel = new JPanel();
        functionButtonsPanel.setBackground(Color.GREEN);
        mainPanel.add(functionButtonsPanel,BorderLayout.EAST);


    }
}
