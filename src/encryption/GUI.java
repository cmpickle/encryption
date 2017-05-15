package encryption;

/**
 * The graphical user interface for Encode.
 * 
 * @author Cameron Pickle
 * @author Nathan Pickle
 */
import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class GUI {

    final JFileChooser fc = new JFileChooser();
    private JFrame frame;
    private JLabel lblEncode;
    private JLabel lblDecode;
    private JTextPane decodeText;
    private JTextPane encodeText;
    private JButton encodeString;
    private JButton decodeString;
    private JButton decodeTextFile;
    private JButton encodeTextFile;

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
	EventQueue.invokeLater(new Runnable() {
	    public void run()
	    {
		try
		{
		    GUI window = new GUI();
		    window.frame.setVisible(true);
		} catch (Exception e)
		{
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the application.
     */
    public GUI()
    {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
	frame = new JFrame();
	frame.setBounds(100, 100, 450, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	frame.setTitle("Encriptor Pro");

	lblEncode = new JLabel("Encode");
	lblEncode.setBounds(12, 12, 70, 15);
	frame.getContentPane().add(lblEncode);

	lblDecode = new JLabel("Decode");
	lblDecode.setBounds(12, 127, 70, 15);
	frame.getContentPane().add(lblDecode);

	decodeText = new JTextPane();
	decodeText.setBounds(12, 140, 373, 80);
	frame.getContentPane().add(decodeText);

	encodeText = new JTextPane();
	encodeText.setBounds(12, 26, 383, 61);
	frame.getContentPane().add(encodeText);

	encodeString = new JButton("To String");
	encodeString.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e)
	    {
		String input = encodeText.getText();
		input = Encode.encode(input);
		encodeText.setText(input);
	    }
	});
	encodeString.setBounds(12, 90, 117, 25);
	frame.getContentPane().add(encodeString);

	decodeString = new JButton("String");
	decodeString.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e)
	    {
		String input = decodeText.getText();
		input = Encode.decode(input);
		decodeText.setText(input);
	    }
	});
	decodeString.setBounds(12, 224, 117, 25);
	frame.getContentPane().add(decodeString);

	decodeTextFile = new JButton("Text File");
	decodeTextFile.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e)
	    {
		String output = Encode.decodeText();
		decodeText.setText(output);
	    }
	});
	decodeTextFile.setBounds(141, 224, 117, 25);
	frame.getContentPane().add(decodeTextFile);

	encodeTextFile = new JButton("To Text File");
	encodeTextFile.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e)
	    {
//		// Handle open button action.
//		if (e.getSource() == openButton)
//		{
//		    int returnVal = fc.showOpenDialog(FileChooserDemo.this);
//
//		    if (returnVal == JFileChooser.APPROVE_OPTION)
//		    {
//			File file = fc.getSelectedFile();
//			// This is where a real application would open the file.
//		    } else
//		    {
//		    }
//		}
		String input = encodeText.getText();
		Encode.encodeText(input);
		input = Encode.encode(input);
		encodeText.setText(input);
	    }
	});
	encodeTextFile.setBounds(141, 90, 117, 25);
	frame.getContentPane().add(encodeTextFile);
    }
}
