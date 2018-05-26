package excel.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class UploadExcel {
	
	public static String uploadExcelFile(MultipartFile file, String name) {
		if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = 
                        new BufferedOutputStream(new FileOutputStream(new File("uploads/" + name)));
                stream.write(bytes);
                stream.close();
                return "Fichier uploadé avec succès " + name + " dans le dossier uploads/" + name;
            } catch (Exception e) {
                return "Problème de chargement du fichier " + name + " => " + e.getMessage();
            }
        } else {
            return "Le fichier " + name + " n‘a pas été uploadé car il est vide.";
        }
	}

}
