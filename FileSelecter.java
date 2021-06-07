package codageHuffman;

import java.io.File;

import javax.swing.JFileChooser;

public class FileSelecter {

	public String getPath() {
		JFileChooser jfc = new JFileChooser();
		int returnValue = jfc.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			return selectedFile.getAbsolutePath();
		}
		else {
			return "Error";
		}
	}

}
