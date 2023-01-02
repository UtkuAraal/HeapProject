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
		MaxHeap Heap = new MaxHeap(2500); // Heap yap�s� olu�turuldu.
		
			
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
	    	Heap.Insert(yeniKayit);	// Insert metodu �a��r�larak heap yap�s�na ilk 2500 kay�t kaydedildi.
	    }
		
	    System.out.println("�lk 2500 kay�t veri yap�s�na eklenmi�tir.");     
		       
	    Heap.Resize();	// Resize() metodu ile veri yap�s�n�n boyutu 2 kat�na ��kart�ld�.
		    
	    for(int i = 2500; i<5000;i++) {
	    	String[]  values = lines.get(i).split(",");
	    	Kayit yeniKayit = new Kayit(Long.parseLong(values[0]), values[1], values[2]);
	    	Heap.Insert(yeniKayit);	// Insert metodu �a��r�larak heap yap�s�na ikinci 2500 kay�t kaydedildi.
	    }
	    System.out.println("�kinci 2500 kay�t veri yap�s�na eklenmi�tir.");   
	    
	    System.out.println(Heap.Return_Kayit_Sayisi() + " adet kay�t bulunmaktad�r.");
	    Kayit deletedTemp = Heap.Delete(7756591263L);
	    Heap.Ekrana_Yazdir(deletedTemp);
	    System.out.println("Kay�t silinmi�tir!");
	    System.out.println(Heap.Return_Kayit_Sayisi()  + " adet kay�t bulunmaktad�r.");
	    Kayit en_buyuk = Heap.En_Buyuk_Kaydi_Cikar();
	    Heap.Ekrana_Yazdir(en_buyuk);
	    System.out.println("En b�y�k kay�t silinmi�tir!");
	    Kayit index43 = Heap.Delete_pos(43);
	    Heap.Ekrana_Yazdir(index43);
	    System.out.println("43 Numaral� kay�t silinmi�tir!");
	    Kayit arananKayit = Heap.Search(9377761894L);
	    Heap.Ekrana_Yazdir(arananKayit);
	    System.out.println("Aranan kay�t ekrana yazd�r�ld�!");
	    System.out.println("A�a� seviyesi: " + Heap.Return_Seviye_Sayisi());
	    
	}
}


