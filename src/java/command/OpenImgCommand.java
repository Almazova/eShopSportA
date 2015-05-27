/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import helperclasses.Path;
import helperclasses.RequestAttributes;
import helperclasses.SessionAttributes;
import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author asus
 */
public class OpenImgCommand implements ActionCommand {

    private static final Logger log = Logger.getLogger(OpenImgCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        File file;
        String path = "";
        try {
            JFileChooser fileopen = new JFileChooser();
            File dir = new File(Path.DOWNLOAD_IMG);
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "JPG GIF PNG Images", "jpg", "gif", "png");
            fileopen.setFileFilter(filter);
            fileopen.setCurrentDirectory(dir);
            fileopen.setApproveButtonText("Выбрать");//выбрать название для кнопки согласия        
            fileopen.setAcceptAllFileFilterUsed(false);
            fileopen.setDialogTitle("Выберите картинку для загрузки");// выбрать название
            fileopen.setDialogType(JFileChooser.OPEN_DIALOG);// выбрать тип диалога Open или Save
            int ret = fileopen.showDialog(null, "Открыть файл");

            if (ret == JFileChooser.APPROVE_OPTION) {
                file = fileopen.getSelectedFile();
                path = Path.DOWNLOAD_IMG_SHORT + file.getName();
            }

            request.setAttribute(RequestAttributes.IMAGE_PATH, path);
            HttpSession session = request.getSession();
            session.setAttribute(SessionAttributes.LOCATION_OF_SITE, SessionAttributes.ADMINISTRATIVE_PART);
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString() + " :Incorrect file path");
        } catch (IndexOutOfBoundsException ex) {
            log.error("Exception: " + ex.toString() + " :don't fill in the required fields ");
        } catch (HibernateException ex) {
            log.error("Exception: " + ex.toString());
        } catch (NumberFormatException ex) {
            log.error("Exception: " + ex.toString());
        }catch (IllegalArgumentException ex) {
            log.error("Exception: " + ex.toString()+" :Extensions must be non-null and not empty");
        }
        return Path.ADMIN_ADD_GOODS;

    }

}
