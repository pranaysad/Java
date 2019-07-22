package javaProject1Package;

import java.io.*;

import net.sourceforge.tess4j.*;

public class TessApp {

// TODO Auto-generated constructor stub
public String getImgText(String imageLocation) {
		      ITesseract instance = new Tesseract();
		      try 
		      {
		         String imgText = instance.doOCR(new File(imageLocation));
		         return imgText;
		      } 
		      catch (TesseractException e) 
		      {
		         e.getMessage();
		         return "Error while reading image";
		      }
	}

}
