package codageHuffman;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Class that define the frame in which the user will enter the file he want to
 * compress
 * 
 * @author Gabriel
 *
 */
public class InputFrame extends JFrame implements ActionListener {

	private JTextField textField = new JTextField();

	public InputFrame() {

		this.setSize(300, 200);
		this.setLocationRelativeTo(null);

		this.setLayout(new GridLayout(0, 1));

		JLabel label = new JLabel("Enter file name : ");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);

		JButton button = new JButton("Ok");

		button.addActionListener(this);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);

		this.add(label);
		this.add(textField);
		this.add(button);

		this.setVisible(true);

	}

	/**
	 * Method that create a HuffmanMaker with the entered file name
	 */
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		new HuffmanMaker(this.textField.getText());
		
	}

}
