package util.converter;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * CamelToSnakeConverter
 *
 * @author t-mito
 */
public class CamelToSnakeConverter {

    /**
     * main
     *
     * @param args
     */
    public static void main(String[] args) {

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);

        try {
            String convertedString = CaseConverter.camelToSnake((String) contents.getTransferData(DataFlavor.stringFlavor));

            StringSelection selection = new StringSelection(convertedString);
            clipboard.setContents(selection, null);

        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }
    }
}
