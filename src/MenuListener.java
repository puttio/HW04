import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MenuListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		AbstractButton source = (AbstractButton) e.getSource();
		if(source.getText().equals("Author")){
			showAuthorDialog();
		}else if(source.getText().equals("Help")){
			showHelpDialog();
		}else if(source.getText().equals("New")){
			ScribbleShop.createFrame();

		}else if(source.getText().equals("Close")){

			if(ScribbleShop.openFrameCount!=0){
				try {
					ScribbleShop.desktop.getSelectedFrame().setClosed(true);
					ScribbleShop.openFrameCount--;

					if(ScribbleShop.openFrameCount != 1) ScribbleShop.desktop.selectFrame(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}


		}else if(source.getText().equals("Close All")){
			for(int i = 0; i < ScribbleShop.openFrameCount; i++){
				try {

					ScribbleShop.desktop.getSelectedFrame().setClosed(true);
					if(i > 0) ScribbleShop.desktop.selectFrame(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			ScribbleShop.openFrameCount = 0;
		}else if(source.getText().equals("Exit")){
			System.exit(0);
		}else{}
	}

	private void showHelpDialog() {
		Image img = null;
		final JDialog helpDialog = new JDialog();
		helpDialog.setLayout(new BorderLayout());
		URL imgURL = getClass().getResource("/dogswing.jpg");
		try {
			img = ImageIO.read(imgURL);
		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel imgLabel = new JLabel(new ImageIcon(img));

		helpDialog.getContentPane().add(imgLabel, BorderLayout.CENTER);
		helpDialog.setModal(true);
		helpDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		helpDialog.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				helpDialog.dispose();
			}
		});
		helpDialog.setSize(700,526);
		helpDialog.setLocationRelativeTo(null);
		helpDialog.pack();
		helpDialog.setVisible(true);

	}

	public void showAuthorDialog(){
		final JDialog dialog = new JDialog();
		dialog.setLayout(new BorderLayout());
		dialog.getContentPane().add(new MyAvatar(), BorderLayout.CENTER);
		JButton OKButton = new JButton("OK! OK! Stop bragging!");
		dialog.getContentPane().add(OKButton,BorderLayout.SOUTH);
		OKButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dialog.dispose();
			}
		});
		dialog.setModal(true);
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.setSize(700,750);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
	}
}
