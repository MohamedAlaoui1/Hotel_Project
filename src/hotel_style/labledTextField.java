package hotel_style;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class labledTextField extends JPanel {

	public labledTextField(String label, int col) {
		
		
		setLayout(new FlowLayout(FlowLayout.LEFT));

		
		JTextField txtF = new JTextField(col);
		txtF.setBorder(BorderFactory.createLineBorder(Color.gray));
		txtF.setBorder(BorderFactory.createCompoundBorder(
		        txtF.getBorder(), 
		        BorderFactory.createEmptyBorder(3,3, 3, 3)));
		
		add(new JLabel(label));
		add(txtF);
		
	
	}

	public labledTextField(String label, int col, int labelWidth) {
		this(label, col);
		((JLabel)this.getComponent(0)).setPreferredSize(new Dimension(labelWidth, 60));
	}
	
	public String getText() {
		return ((JTextField)this.getComponent(1)).getText();
	}

	public void setText(String text) {
		((JTextField)this.getComponent(1)).setText(text);
	}

}