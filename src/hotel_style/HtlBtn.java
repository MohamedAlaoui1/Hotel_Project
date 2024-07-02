package hotel_style;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class HtlBtn extends JButton{
	
	HtlBtn(String btn_label){
		setText(btn_label);
		setFocusable(false);
		setBorderPainted(false);
		setBorder(null);
		setBackground(Color.black);
  		setForeground(Color.white);

  		setBorder(BorderFactory.createEmptyBorder(8, 30, 8, 30));
  		
	  	addMouseListener(new java.awt.event.MouseAdapter() {
	  		public void mouseEntered(java.awt.event.MouseEvent evt) {
	  		        setBackground(Color.GRAY);
	  		        setCursor(new Cursor(Cursor.HAND_CURSOR));
	  		        setBorderPainted(false);

	  		        
	  		    }

	  		    public void mouseExited(java.awt.event.MouseEvent evt) {
	  		        setBackground(Color.black);
	  		    }
	  		});
	}
}
