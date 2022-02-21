import java.io.File;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class ExportDomain extends QPanel {
	Domain domainClicked;
	private JScrollPane domains;
	public ExportDomain(String t) {
		super(t);
		domains = new JScrollPane();
		domains.setPreferredSize(new Dimension(900,300));
		domains.setLayout(new ScrollPaneLayout());
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getScreenID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean popup(String text) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void buttonClicked(int buttonID) {
		// TODO Auto-generated method stub
		File exported = domainClicked.export();
	}

}
