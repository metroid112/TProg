package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.tika.Tika;

public class Imagen {
  private int id;
  private static int idCounter = 0;
  private byte[] imgByte;
  private String extension;
  
  public Imagen(byte[] imgByte) {
    this.setImgByte(imgByte);
    Imagen.idCounter++;
    this.id = Imagen.idCounter;
    //Devuelve image/*;
    this.extension = (new Tika().detect(imgByte)).replaceAll("image/", ".");
    File directorio = new File("media/");
    if (!directorio.isDirectory()) {
      directorio.mkdirs();
    }
    File archivo = new File(directorio, Integer.toString(id) + this.extension);
    try (OutputStream oStream = new FileOutputStream(archivo)) {
      oStream.write(imgByte);
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public byte[] getImgByte() {
    return imgByte;
  }

  public void setImgByte(byte[] imgByte) {
    this.imgByte = imgByte;
  }
  
  public int getId() {
    return this.id;
  }

  public String getExtension() {
    return this.extension;
  }
}
