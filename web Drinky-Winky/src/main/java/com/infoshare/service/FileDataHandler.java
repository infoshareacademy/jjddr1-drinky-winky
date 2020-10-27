package com.infoshare.service;

import com.infoshare.service.FileUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;
import java.io.IOException;

@RequestScoped
public class FileDataHandler {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    FileUploadService fileUploadService;

    @Inject
    FileParserService fileParserService;

    public <T> Object dataUploadHandler(Part partFile) throws IOException, RecipeUploadedFileNotFound {
        logger.info("file was parsed");
        return fileParserService.parseDataToDatabase(fileUploadService.uploadFile(partFile));
    }
}
