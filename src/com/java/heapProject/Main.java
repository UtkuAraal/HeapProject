package com.java.heapProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		MaxHeap Heap = new MaxHeap(2500); // Heap yapýsý oluþturuldu.
		
			
		List<String> lines = Collections.emptyList();
	    try
	    {
	      lines = Files.readAllLines(Paths.get("kayit_dosyasi.txt"), StandardCharsets.UTF_8);
	    }catch (Exception e){
	      e.printStackTrace();
	    }
	    
	    for(int i = 0; i<2500;i++) {
	    	String[]  values = lines.get(i).split(",");
	    	Kayit yeniKayit = new Kayit(Long.parseLong(values[0]), values[1], values[2]);
	    	Heap.Insert(yeniKayit);	// Insert metodu çaðýrýlarak heap yapýsýna ilk 2500 kayýt kaydedildi.
	    }
		
	    System.out.println("Ýlk 2500 kayýt veri yapýsýna eklenmiþtir.");     
		       
	    Heap.Resize();	// Resize() metodu ile veri yapýsýnýn boyutu 2 katýna çýkartýldý.
		    
	    for(int i = 2500; i<5000;i++) {
	    	String[]  values = lines.get(i).split(",");
	    	Kayit yeniKayit = new Kayit(Long.parseLong(values[0]), values[1], values[2]);
	    	Heap.Insert(yeniKayit);	// Insert metodu çaðýrýlarak heap yapýsýna ikinci 2500 kayýt kaydedildi.
	    }
	    System.out.println("Ýkinci 2500 kayýt veri yapýsýna eklenmiþtir.");   
	    
	    System.out.println(Heap.Return_Kayit_Sayisi() + " adet kayýt bulunmaktadýr.");
	    Kayit deletedTemp = Heap.Delete(7756591263L);
	    Heap.Ekrana_Yazdir(deletedTemp);
	    System.out.println("Kayýt silinmiþtir!");
	    System.out.println(Heap.Return_Kayit_Sayisi()  + " adet kayýt bulunmaktadýr.");
	    Kayit en_buyuk = Heap.En_Buyuk_Kaydi_Cikar();
	    Heap.Ekrana_Yazdir(en_buyuk);
	    System.out.println("En büyük kayýt silinmiþtir!");
	    Kayit index43 = Heap.Delete_pos(43);
	    Heap.Ekrana_Yazdir(index43);
	    System.out.println("43 Numaralý kayýt silinmiþtir!");
	    Kayit arananKayit = Heap.Search(9377761894L);
	    Heap.Ekrana_Yazdir(arananKayit);
	    System.out.println("Aranan kayýt ekrana yazdýrýldý!");
	    System.out.println("Aðaç seviyesi: " + Heap.Return_Seviye_Sayisi());
	    
	}
}


