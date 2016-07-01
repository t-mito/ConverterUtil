package util.generator;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * ContainerFieldJavadocGenerator
 *
 * @author t-mito
 */
public class ContainerFieldJavadocGenerator {

    /**
     * main
     *
     * @param args
     */
    public static void main(String[] args) {

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);

        try {
            String data = (String) contents.getTransferData(DataFlavor.stringFlavor);

            String[] line = data.split("\n");

            StringBuilder stb = new StringBuilder();

            for (int i = 0; i < line.length; i++) {

                String[] value = line[i].split("\t");

                if (value.length != 2) {
                	throw new IllegalArgumentException("Line Please specify in the following format: javadoc name + tab + field name");
                }
                
                stb.append("/** " + value[0] + " */\n");
                stb.append("private String " + value[1] + " = null;\n\n");
            }

            StringSelection selection = new StringSelection(new String(stb));
            clipboard.setContents(selection, null);

        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }
    }
}
