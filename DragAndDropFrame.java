package codageHuffman;

import java.awt.BorderLayout;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.*;

public class DragAndDropFrame extends JFrame implements DropTargetListener  {
	
	public DragAndDropFrame() {
		// Set the frame title
        super("Drag and drop test");

        // Set the size
        this.setSize(250, 150);

        JLabel myLabel = new JLabel("Glisser le fichier a compresser ici", SwingConstants.CENTER);

        // Connect the label with a drag and drop listener
        new DropTarget(myLabel, this);

        // Add the label to the content
        this.getContentPane().add(BorderLayout.CENTER, myLabel);

        // Show the frame
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}

	@Override
	public void drop(DropTargetDropEvent event) {

        // Accept copy drops
        event.acceptDrop(DnDConstants.ACTION_COPY);

        // Get the transfer which can provide the dropped item data
        Transferable transferable = event.getTransferable();

        // Get the data formats of the dropped item
        DataFlavor[] flavors = transferable.getTransferDataFlavors();
        
        List<File> files;
		try {
			files = (List) transferable.getTransferData(flavors[0]);
			System.out.println("File path is '" + files.get(0).getPath() + "'.");
			if(files.get(0).getPath().endsWith(".txt")) {
				new HuffmanMaker(files.get(0).getPath());
				this.dispose();
			}
			else {
				JOptionPane.showMessageDialog(new JFrame(), "Le fichier n'est pas un text", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		} catch (UnsupportedFlavorException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        


        event.dropComplete(true);

    }
	
	@Override
	public void dragEnter(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragOver(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropActionChanged(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragExit(DropTargetEvent dte) {
		// TODO Auto-generated method stub
		
	}

	

}
