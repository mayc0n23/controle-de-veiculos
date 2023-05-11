package br.com.controledeveiculos.utils;

import java.io.File;

public class CleanFilesFolder {
	
	public static void clean() {
		File directory = new File("files");
		File[] files = directory.listFiles();
		if (files != null) {
			for (File file: files) {
				if (file.isFile()) {
					file.delete();
				}
			}
		}
	}
	
}