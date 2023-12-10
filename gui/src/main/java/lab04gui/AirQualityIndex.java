package lab04gui;

import lab04client.aqIndex.AirQualityColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class AirQualityIndex extends JFrame implements ActionListener {

    private JPanel labelsPanel;
    private JPanel legendPanel;
    private Map<Integer, Color> idColorMap;
    private int id;

    public AirQualityIndex(int id) {
        this.id = id;
        setTitle("Air quality index");
        initializeIdColorMap();
        labelsPanel = new JPanel(new GridLayout(0, 1));
        for (AirQualityColor airQualityColor : AirQualityColor.getColorList(id)) {
            JLabel label = createLabel(airQualityColor);
            labelsPanel.add(label);
        }
        legendPanel = createLegendPanel();

        // Create a container panel to hold both labels and the legend
        JPanel containerPanel = new JPanel(new BorderLayout());
        containerPanel.add(labelsPanel, BorderLayout.CENTER);
        containerPanel.add(legendPanel, BorderLayout.EAST);

        // Add the container panel to the frame
        add(containerPanel, BorderLayout.CENTER);
        setSize(600, 300);
        JButton closeButton = new JButton("Sensor list");
        closeButton.addActionListener(this);
        add(closeButton, BorderLayout.SOUTH);
        this.setLocationRelativeTo((Component)null);
        setVisible(true);
    }

    private void initializeIdColorMap() {
        idColorMap = new HashMap<>();
        idColorMap.put(-1, Color.GRAY);
        idColorMap.put(0, Color.CYAN);
        idColorMap.put(1, Color.GREEN);
        idColorMap.put(2, Color.YELLOW);
        idColorMap.put(3, Color.ORANGE);
        idColorMap.put(4, Color.PINK);
        idColorMap.put(5, Color.RED);
    }

    private JLabel createLabel(AirQualityColor myObject) {
        JLabel label = new JLabel(myObject.getName());
        label.setOpaque(true);
        label.setBackground(idColorMap.getOrDefault(myObject.getIndex(), Color.BLACK));

        return label;
    }
    private JPanel createLegendPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (Map.Entry<Integer, Color> entry : idColorMap.entrySet()) {
            JLabel legendLabel = new JLabel("Index " + entry.getKey());
            legendLabel.setOpaque(true);
            legendLabel.setBackground(entry.getValue());
            panel.add(legendLabel);
        }

        return panel;
    }

//    public static void main(String[] args) {
//        new AirQualityIndex(52);
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        disposeChartPanel();
    }
    private void disposeChartPanel() {
        new SensorList(id);
        this.dispose();
    }
}
