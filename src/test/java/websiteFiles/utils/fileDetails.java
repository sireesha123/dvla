package websiteFiles.utils;

public class fileDetails {

    public Long fileSize;

    public  String fileName;

    public String mimeType;


    public fileDetails(long fileSize, String fileName, String mimeType) {

        this.fileSize = fileSize;
        this.fileName = fileName;
        this.mimeType = mimeType;
    }




    public Long getfileSize(){
        return fileSize;
    }


    public String getFileName(){
        return fileName;
    }

    public String getMimeType(){
        return mimeType;
    }




}
