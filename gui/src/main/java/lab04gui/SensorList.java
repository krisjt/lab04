package lab04gui;

import lab04client.measurementStation.MeasurementStationsParser;
import lab04client.measurementStation.OneMeasurementStation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SensorList extends JFrame implements ActionListener {
    private JButton closeButton = new JButton("Close");
    JPanel buttonsPanel = new JPanel(new GridLayout(0, 1));

    SensorList(int id){
        setVisible(true);
        setTitle("Sensor list");
        setText(id);
        JScrollPane scrollPane = new JScrollPane(buttonsPanel);
        add(scrollPane, BorderLayout.CENTER);
        setSize(800, 500);
        this.setLocationRelativeTo(null);
        closeButton.addActionListener(this);
        add(closeButton, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(closeButton)){
            this.dispose();
        }
    }

    private void setText(int id){
//        StringBuilder string = new StringBuilder("Here are the measurment stations, available in the measurement station with id = " + id + " = \n");
        for(OneMeasurementStation o : MeasurementStationsParser.getMeasurementStation(id)){
//            string.append("Sensor id = ").append(o.id).append(", parameter name = ").append(o.param.paramName).append(", parameter id = ").append(o.param.idParam).append(", parameter formula = ").append(o.param.paramFormula).append(", parameter code = ").append(o.param.paramCode).append(".\n");
            String string2 = "Sensor id = " + o.id + ", parameter name = " + o.param.paramName;
            buttonsPanel.add(createButton(string2,o.id));
        }
//        textArea1.setText(string.toString());
        pack();
    }
    private JButton createButton(String string, int id) {
        // Create a JButton for a given element
        JButton button = new JButton("See data chart for sensor: " + string);
        button.setPreferredSize(new Dimension(200, 50));

        button.addActionListener(e -> {
            // Handle button click (you can add custom logic here)
            new DataChart(id);
        });

        return button;
    }

}
