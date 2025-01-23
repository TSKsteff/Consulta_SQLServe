package br.com.Consulta.service;

import lombok.extern.log4j.Log4j2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

@Log4j2
public class FileUtils {

    public static void saveObjectToFile(Object obj) {
        String filePath = System.getProperty("user.dir");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(obj);
            log.info("Objeto salvo com sucesso em: {}", filePath);
        } catch (IOException e) {
            log.error("Erro ao salvar objeto: {} " + e.getMessage());
        }
    }
}
