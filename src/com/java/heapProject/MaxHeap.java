package com.java.heapProject;

import java.util.Arrays;

public class MaxHeap {
	private Kayit[] heap;
	private int size;
	
	
	public MaxHeap(int capacity) {
		heap = new Kayit[capacity];
		System.out.println("Kapasitesi " + capacity + " olan veri yapýsý yaratýlmýþtýr.");
	}

	
	public void Insert(Kayit kayit) {
		if(size == heap.length) {
			throw new IndexOutOfBoundsException("Heap yapýsý dolu lütfen boyutunu arttýrýn!");
		}
		heap[size] = kayit;
		HeapifyAbove(size);
		size++;
		
	}
	
	public Kayit Search(Long TCKN) {
		for(int i = 0; i < heap.length; i++) {
			if(heap[i].TCKN.equals(TCKN)) {
				return heap[i];
			}
		}
		return null;
	}
	
	public Kayit En_Buyuk_Kaydi_Cikar() {
		if(size == 0) {
			throw new IndexOutOfBoundsException("Heap yapýsýnda veri bulunmamaktadýr!");
		}
		Kayit deletedValue = heap[0];
		heap[0] = heap[size-1];
		HeapifyBelow(0, size- 1);
		size--;
		return deletedValue;
	} 
	
	
	
	public Kayit Delete(Long TCKN) {
		for(int i = 0; i < heap.length; i++) {
			if(heap[i].TCKN.equals(TCKN)) {
				Kayit temp = heap[i];
				Delete_pos(i);
				return temp;
			}
		}
		return null;
	}
	
	
	public Kayit Delete_pos(int index) {
		if(index < 0 || index >= size) {
			return null;
		}
		int parent = getParent(index);
		Kayit deletedValue = heap[index];
		
		heap[index] = heap[size-1];
		if(index == 0 || heap[index].TCKN < heap[parent].TCKN) {
			HeapifyBelow(index, size- 1);
		}else {
			HeapifyAbove(index);
		}
		size--;
		return deletedValue;
	}
	
	
	public int Return_Kayit_Sayisi() {
		return size;
	}
	
	public int Return_Seviye_Sayisi() {
		int result = (int)((Math.log(size) / Math.log(2)) + 1);
		return result;
	}
	
	public void Ekrana_Yazdir(Kayit kayit) {
		System.out.println("T.C. kimlik no: " + kayit.TCKN + "\nAd: " + kayit.ad + "\nSoyad: " + kayit.soyad);;
	}
	
	
	public void Resize() {
		heap = Arrays.copyOf(heap, heap.length * 2);
		System.out.println("Resize methodu kullanýlarak veri yapýsýnýn boyutu 2 katýna çýkartýlmýþtýr.");
	}
	
	
	private void HeapifyAbove(int index) {
		Kayit yeniKayit= heap[index];
		while(index > 0 && yeniKayit.TCKN > heap[getParent(index)].TCKN) {
			heap[index] = heap[getParent(index)];
			index = getParent(index);
		}
		heap[index] = yeniKayit;
	}
	
	private int getParent(int index) {
		return (index - 1) / 2;
	}
	
	
	private void HeapifyBelow(int index, int lastHeapIndex) {
		int childToSwap;
		while(index <= lastHeapIndex) {
			int leftChild = getChild(index, true);
			int rightChild = getChild(index, false);
			
			if(leftChild <= lastHeapIndex) {
				
				if(rightChild > lastHeapIndex) {
					childToSwap = leftChild;
				}else {
					childToSwap = (heap[leftChild].TCKN > heap[rightChild].TCKN  ? leftChild : rightChild);
				}
				
				if(heap[index].TCKN < heap[childToSwap].TCKN) {
					Kayit temp = heap[index];
					heap[index] = heap[childToSwap];
					heap[childToSwap] = temp;
					
				}else {
					break;
				}
				index = childToSwap;
			}else {
				break;
			}
			 
		}
	}
	
	
	
	public int getChild(int index, boolean left) {
		return 2 * index + (left ? 1: 2);
	}
	
	

	

}
