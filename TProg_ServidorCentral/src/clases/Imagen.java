package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.tika.Tika;

import excepciones.NotFoundException;

public class Imagen {
  private int id;
  private static int idCounter = 0;
  private byte[] imgByte;
  private String extension;
  
  public Imagen(byte[] imgByte) {
    this.id = Imagen.idCounter;
    Imagen.idCounter++;
    this.crearImg(imgByte);
  }
  
  public void crearImg(byte[] imgByte) {
    this.setImgByte(imgByte);
    this.extension = (new Tika().detect(imgByte)).replaceAll("image/", ".");
    File directorio = new File("media/");
    if (!directorio.isDirectory()) {
      directorio.mkdirs();
    }
    File archivo = null;
    if (this.id == 0) {
      archivo = new File(directorio, Integer.toString(this.id) + ".JPG");
    } else {
      archivo = new File(directorio, Integer.toString(this.id) + this.extension);
    }
   
    try (OutputStream oStream = new FileOutputStream(archivo)) {
      oStream.write(imgByte);
      oStream.close();
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
  
  public static void borrar(int idImg) throws NotFoundException {
    File media = new File("media/");
    boolean borro = false;
    for (File img : media.listFiles()) {
      if (img.getName().matches(Integer.toString(idImg) + "\\..*")) {
        img.delete();
        borro = true;
      }
    }
    if (!borro) {
      throw new NotFoundException(Integer.toString(idImg));
    }
  }

  public String getExtension() {
    return this.extension;
  }
  
  public static void borrar(int idImg) throws NotFoundException {
    File media = new File("media/");
    boolean borro = false;
    for (File img : media.listFiles()) {
      if (img.getName().matches(Integer.toString(idImg) + "\\..*")) {
        img.delete();
        borro = true;
      }
    }
    if (!borro) {
      throw new NotFoundException(Integer.toString(idImg));
    }
  }
  
  public void modificarImg(int idImg, byte[] img) throws NotFoundException {
    Imagen.borrar(idImg);
    this.crearImg(img);
  }
}
